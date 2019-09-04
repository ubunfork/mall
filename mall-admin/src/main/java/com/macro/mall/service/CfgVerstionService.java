package com.macro.mall.service;

import java.util.List;

import com.macro.mall.model.CfgVerlog;


/**
 * app配置Service
 * Created by macro on 2018/6/1.
 */
public interface CfgVerstionService {

    List<CfgVerlog> list();

    int create(CfgVerlog cfgVerlog);

    int update(CfgVerlog cfgVerlog);

    int delete(Long id);

    List<String> listplatform();

    List<String> listverstion(String platfrom);
}