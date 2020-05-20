package com.tv.travels;

import com.tv.travels.entity.Province;
import com.tv.travels.service.ProvinceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = TravelsApplication.class)
public class ProvinceTexts {

    @Autowired
    private ProvinceService provinceService;

    @Test
    public void testFindByPage(){
        List<Province> byPage = provinceService.findByPage(1, 5);
        byPage.forEach(province -> {
            System.out.println("6-----------------------------");
            System.out.println(province);
        });
    }

}
