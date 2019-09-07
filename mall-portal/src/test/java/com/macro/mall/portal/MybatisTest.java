package com.macro.mall.portal;

import java.util.List;

import com.macro.mall.model.CfgSource;
import com.macro.mall.portal.dao.CfgDao;
import com.macro.mall.portal.dao.CfgSourceParam;
import com.macro.mall.portal.dao.OmsCartItemDao;
import com.macro.mall.portal.domain.OmsCartResult;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisTest{
    @Autowired
    private OmsCartItemDao omsCartItemDao;

    @Test
    public void testOmsCarItemDao() throws Exception{
        List <OmsCartResult> list = omsCartItemDao.getOmsCartItemDto(1L);
        System.out.println(list);
    }


    @Autowired
    private CfgDao cfgDao;

    @Test
    public void testCfgDao() throws Exception{
        CfgSourceParam cfgSourceParam = new CfgSourceParam();
        cfgSourceParam.setTypeid(1001);
        cfgSourceParam.setPlatform("iOS");
        List<CfgSource> list = cfgDao.selectsource(cfgSourceParam); 
        System.out.println(list);
    }
}