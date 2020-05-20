package com.tv.travels.dao;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BaseDAO<T,K> {

    void save(T t);

    void update(T t);

    void delete(K k);

    List<T> findAll();

    List<T> findByPage(@Param("start")Integer start,@Param("rows")Integer rows);

    Integer findTotals();

    T findOne(K k);
}
