package com.macro.mall.portal;

import com.macro.mall.portal.dao.PortalProductDao;
import com.macro.mall.portal.domain.PromotionProduct;
import org.springframework.data.mongodb.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macro on 2018/8/27.
 * 前台商品查询逻辑单元测试
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
@SpringBootTest
public class MongodbTest {
    
}