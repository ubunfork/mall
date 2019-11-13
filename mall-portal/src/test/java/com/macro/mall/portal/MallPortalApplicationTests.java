package com.macro.mall.portal;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.portal.dao.PmsProductDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallPortalApplicationTests {

    @Autowired(required=false)
    private PmsProductDao pmsProductDao;


    @Test
    public void contextLoads() {
        // PmsProduct pmsProduct = pmsProductDao.productInfo(26L);
        PmsProduct product = pmsProductDao.productInfo(26L);
    }

}
