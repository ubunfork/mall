package com.macro.mall.portal;

import com.macro.mall.portal.dao.PmsProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.macro.mall.portal.dao.PmsProductResult;
import com.macro.mall.portal.service.impl.PmsProductServiceImp;
import com.macro.mall.model.PmsProduct;
/**
 * 
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath*:*.xml"})
@SpringBootTest
public class PmsProductDaoTest {
    @Autowired(required=false)
    private PmsProductDao pmsProductDao;

    @Test
    public void testGetPromotionProductList(){
        PmsProduct pmsProduct = pmsProductDao.productInfo(26L);
        Assert.assertEquals(4,1);
    }
}