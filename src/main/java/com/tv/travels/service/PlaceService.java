package com.tv.travels.service;

import com.tv.travels.entity.Place;
import com.tv.travels.entity.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlaceService {

    List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId);

    Integer findByProvinceIdCounts(String provinceId);

}
