package com.tv.travels.dao;

import com.tv.travels.entity.Province;

import java.util.List;

public interface ProvinceDAO extends BaseDAO<Province,String> {

    List<Province> findAllProvince();

}
