package com.macro.mall.portal.service;

import java.util.List;

import com.macro.mall.model.CfgCnarea;

public interface CfgcnareaService{

    /**
     * 根据父编码获取子列表
     * @param parentCode
     * @return
     */
    List<CfgCnarea>listByparentCode(Long parentCode);
}