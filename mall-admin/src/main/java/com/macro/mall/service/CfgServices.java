package com.macro.mall.service;

import com.macro.mall.model.CfgService;
import com.macro.mall.model.CfgSource;
import com.macro.mall.model.CfgType;
import com.macro.mall.dto.CfgSourceParam;
import java.util.List;
/**
 * app配置Service
 * Created by macro on 2018/6/1.
 */
public interface CfgServices {

    List<CfgType> listAllType();

    int createType(CfgType cfgType);
    int updateType(Integer id, CfgType cfgType);
    int deletetype(Long id);
    
    int addsource(Long typeid, CfgSource cfgSource);
    int updatesource(Long id, CfgSource cfgSource);
    int deletesource(Long id);
    
    List<CfgSource> getsourcebytype(CfgSourceParam cfgSourceParam);

    List<CfgService> listservice();
}