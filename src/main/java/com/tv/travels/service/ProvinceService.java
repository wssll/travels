package com.tv.travels.service;

import com.tv.travels.entity.Province;

import java.util.List;

public interface ProvinceService {

//    分页，参数1：当前页  参数2：当前显示的记录数
    List<Province> findByPage(Integer page,Integer rows);

//    查询总条数
    Integer findTotals();

//    新增
    void save(Province province);

//    删除省份
    void delete(String id);

//    获取一个省份信息
    Province findOne(String id);

//    修改省份信息
    void update(Province province);

//    获取所有省份
    List<Province> findAllProvince();

}
