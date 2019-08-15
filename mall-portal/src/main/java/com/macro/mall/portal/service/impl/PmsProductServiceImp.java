package com.macro.mall.portal.service.impl;

import com.macro.mall.portal.dao.PmsProductDao;
import com.macro.mall.portal.dao.PmsProductResult;
import com.macro.mall.portal.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PmsProductServiceImp implements PmsProductService {

    @Autowired
    private PmsProductDao productDao;

    @Override
    public PmsProductResult productInfo(Long id) {
        return productDao.productInfo(id);
    }
}