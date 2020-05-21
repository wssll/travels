package com.tv.travels.dao;

import com.tv.travels.entity.Place;
import com.tv.travels.entity.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlaceDAO extends BaseDAO<Place,String> {

    List<Place> findByProvinceIdPage(@Param("start") Integer start,@Param("rows") Integer rows,
                                        @Param("provinceId") String provinceId);

    Integer findByProvinceIdCounts(String provinceId);

}
