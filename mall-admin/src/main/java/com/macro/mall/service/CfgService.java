package com.macro.mall.service;

import com.macro.mall.model.CfgSource;
import com.macro.mall.model.CfgType;

import java.util.List;
/**
 * app配置Service
 * Created by macro on 2018/6/1.
 */
public interface CfgService {
    List<CfgType> listAllType();

    int createType(CfgType cfgType);

    int addsource(Long id, CfgSource cfgSource);
}