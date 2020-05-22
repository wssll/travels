package com.tv.travels.controller;

import com.tv.travels.entity.Place;
import com.tv.travels.entity.Province;
import com.tv.travels.entity.Result;
import com.tv.travels.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("place")
@Slf4j
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @Value("${upload.dir}")
    private String realPath;

    @GetMapping("findAllPlace")
    public Map<String, Object> findAllPlace(Integer page, Integer rows, String provinceId) {
        log.info(page+"----------------------------"+provinceId);
        HashMap<String, Object> result = new HashMap<>();
        page = page == null ? 1 : page;
        rows = rows == null ? 3 : rows;
        //景点集合
        List<Place> places = placeService.findByProvinceIdPage(page, rows, provinceId);
        //处理分页
        Integer counts = placeService.findByProvinceIdCounts(provinceId);
        //总页数
        Integer totalPage = counts % rows == 0 ? counts / rows : counts / rows + 1;
        result.put("places", places);
        result.put("page", page);
        result.put("counts", counts);
        result.put("totalPage", totalPage);
        return result;
    }

    /**
     * 添加一个景点
     * @param pic
     * @param place
     * @return
     * @throws IOException
     */
    @PostMapping("sava")
    public Result save(MultipartFile pic, Place place){
        Result result = new Result();
        try {
            if(pic!=null){
                setPic(pic,place);
            }
            placeService.save(place);
            result.setMsg("景点添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("景点添加失败").setState(false);
        }
        return result;
    }

    @GetMapping("delete")
    public Result delete(String id){
        log.info(id+"这是id*****************************************");
        Result result = new Result();
        try {
            placeService.delete(id);
            result.setMsg("删除景点信息成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setState(false).setMsg("删除景点信息失败");
        }
        return result;
    }

    /**
     * 根据id获取place
     * @param id
     * @return
     */
    @GetMapping("findOne")
    public Map<String,Object> findOne(String id){
        Map<String,Object> map = new HashMap<>();
        Place place = placeService.findOne(id);
        map.put("place",place);
        return map;
    }

    @PostMapping("updatePlace")
    public Result updatePlace(MultipartFile pic,Place place){
        Result result = new Result();
        try {
            if(pic!=null){
                setPic(pic,place);
            }
            placeService.update(place);
            result.setMsg("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setState(false).setMsg("景点更新失败");
        }
        return result;
    }

    public Place setPic(MultipartFile pic,Place place) throws IOException {
        //对接收文件做base64
        String picpath = Base64Utils.encodeToString(pic.getBytes());
        place.setPicPath(picpath);
        //处理文件上传
        String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + extension;
        pic.transferTo(new File(realPath,newFileName));
        return place;
    }
}
