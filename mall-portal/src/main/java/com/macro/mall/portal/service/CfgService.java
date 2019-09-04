package com.macro.mall.portal.service;

import java.util.List;

import com.macro.mall.model.CfgSource;
import com.macro.mall.portal.dao.CfgSourceParam;

public interface CfgService{

    List<CfgSource>getsourcebytype(CfgSourceParam ploform);
}