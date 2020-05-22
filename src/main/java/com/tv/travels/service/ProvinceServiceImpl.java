package com.tv.travels.service;

import com.tv.travels.dao.ProvinceDAO;
import com.tv.travels.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceDAO provinceDAO;

    /**
     * 分页
     * @param page
     * @param rows
     * @return
     */
    @Override
    public List<Province> findByPage(Integer page, Integer rows) {
        int start = (page-1)*rows;
        return provinceDAO.findByPage(start,rows);
    }

    /**
     * 获取总数
     * @return
     */
    @Override
    public Integer findTotals() {
        return provinceDAO.findTotals();
    }

    /**
     * 新增
     * @param province
     */
    @Override
    @Transactional
    public void save(Province province) {
        province.setPlacecounts(0);
        provinceDAO.save(province);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    @Transactional
    public void delete(String id) {
        provinceDAO.delete(id);
    }

    /**
     * 查询一个省份信息
     * @param id
     * @return
     */
    @Override
    public Province findOne(String id) {
        return provinceDAO.findOne(id);
    }

    /**
     * 修改省份信息
     * @param province
     */
    @Override
    @Transactional
    public void update(Province province) {
        provinceDAO.update(province);
    }

    /**
     * 获取所有省份信息
     * @return
     */
    @Override
    public List<Province> findAllProvince() {
        return provinceDAO.findAllProvince();
    }
}
