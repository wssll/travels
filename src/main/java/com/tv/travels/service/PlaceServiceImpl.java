package com.tv.travels.service;

import com.tv.travels.dao.PlaceDAO;
import com.tv.travels.dao.ProvinceDAO;
import com.tv.travels.entity.Place;
import com.tv.travels.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDAO placeDAO;

    @Autowired
    private ProvinceDAO provinceDAO;

    /**
     * 分页
     * @param page
     * @param rows
     * @param provinceId
     * @return
     */
    @Override
    public List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId) {
        int start = (page-1)*rows;
        return placeDAO.findByProvinceIdPage(start,rows,provinceId);
    }

    /**
     * 查询省份个数
     * @param provinceId
     * @return
     */
    @Override
    public Integer findByProvinceIdCounts(String provinceId) {
        return placeDAO.findByProvinceIdCounts(provinceId);
    }

    /**
     * 保存一个景点信息
     * @param place
     */
    @Override
    public void save(Place place) {
//        保存景点信息
        placeDAO.save(place);
//        获取省份信息
        Province province = provinceDAO.findOne(place.getProvinceId());
        province.setPlacecounts(province.getPlacecounts()+1);
        provinceDAO.update(province);
    }

    /**
     * 根据id删除景点信息
     * @param id
     */
    @Override
    public void delete(String id) {
        Place place = placeDAO.findOne(id);
        System.out.println(place+"**************************");
        Province province = provinceDAO.findOne(place.getProvinceId());
        System.out.println(province+"**************************");
        province.setPlacecounts(province.getPlacecounts()-1);
        provinceDAO.update(province);
        placeDAO.delete(id);
    }

    /**
     * 根据id查找place
     * @param id
     * @return
     */
    @Override
    public Place findOne(String id) {
        Place place = placeDAO.findOne(id);
        return place;
    }


    @Override
    public void update(Place place) {
        placeDAO.update(place);
    }
}
