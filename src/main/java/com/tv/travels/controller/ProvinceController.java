package com.tv.travels.controller;

import com.tv.travels.entity.Province;
import com.tv.travels.entity.Result;
import com.tv.travels.service.ProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("province")
@Slf4j
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;


    /**
     * 查询所有
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("findByPage")
    public Map<String,Object> findByPage(Integer page, Integer rows){
        Map<String,Object> map = new HashMap<>();
        page = page==null?1:page;
        rows = rows==null?4:rows;
//        分页处理
        List<Province> provinces = provinceService.findByPage(page,rows);
//        获取总条数
        Integer totals = provinceService.findTotals();
        Integer totalsPage = totals%rows==0 ?totals/rows : totals/rows+1;
        map.put("provinces",provinces);
        map.put("totals",totals);
        map.put("totalPage",totalsPage);
        map.put("page",page);
        return map;
    }


    /**
     * 新增一条数据
     * @param province
     * @return
     */
    @PostMapping("save")
    public Result save(@RequestBody Province province){
        Result result = new Result();
        try {
            provinceService.save(province);
            result.setMsg("省份信息添加成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setState(false).setMsg("省份信息添加失败");
        }
        return  result;
    }

    /**
     * 删除省份信息
     * @param id
     * @return
     */
    @GetMapping("delete")
    public Result delete(String id){
        Result result = new Result();
        try {
            provinceService.delete(id);
            result.setMsg("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setState(false).setMsg("删除失败");
        }
        return result;
    }

    /**
     * 查询一个省份信息
     * @param id
     * @return
     */
    @GetMapping("findOne")
    public Province findOne(String id){
        return provinceService.findOne(id);
    }

    /**
     * 更新省份信息
     * @param province
     * @return
     */
    @PostMapping("update")
    public Result update(@RequestBody Province province){
        Result result = new Result();
        try {
            provinceService.update(province);
            result.setMsg("更新成功");
        }catch (Exception e){
            e.printStackTrace();
//            e.getMessage();
            result.setMsg("更新失败").setState(false);
        }
        return result;
    }

    @GetMapping("findAll")
    public Map<String,Object> findAll(){
        List<Province> allProvince = provinceService.findAllProvince();
        Map<String,Object> map = new HashMap<>();
        map.put("provinces",allProvince);
        map.put("count",allProvince.size());
        return map;
    }

}
