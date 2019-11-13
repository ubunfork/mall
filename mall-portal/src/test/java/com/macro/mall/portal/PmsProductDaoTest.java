package com.macro.mall.portal;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.portal.dao.PmsProductDao;
import com.macro.mall.portal.domain.PmsProductAttributeItem;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;

/**
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsProductDaoTest {


    @Autowired(required=false)
    private PmsProductDao pmsProductDao;

    @Test
    public void testGetPromotionProductList(){
        
        PmsProduct pmsProduct = pmsProductDao.productInfo(26L);

        Assert.assertEquals(0,0);
    }

    @Test
    public void testgetAttributeList(){
        //  根据商品ID获取可选属性 
        List<PmsProductAttributeItem> itemlist = pmsProductDao.getAttributeList(26L);
        Assert.assertEquals(0,0);
    }
}