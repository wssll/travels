package com.tv.travels.controller;

import com.tv.travels.entity.Place;
import com.tv.travels.entity.Province;
import com.tv.travels.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
