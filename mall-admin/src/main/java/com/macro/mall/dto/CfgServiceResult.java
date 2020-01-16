package com.macro.mall.dto;

import java.util.List;

import com.macro.mall.model.CfgService;
import com.macro.mall.model.CfgServiceValue;

import io.swagger.annotations.ApiModelProperty;



/**
 * 查询单个产品进行修改时返回的结果
 * Created by macro on 2018/4/26.
 */
public class CfgServiceResult extends CfgService {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("配置可选项")
    private List<CfgServiceValue> values;

   /**
    * @param values the values to set
    */
   public void setValues(List<CfgServiceValue> values) {
       this.values = values;
   }

   /**
    * @return the values
    */
   public List<CfgServiceValue> getValues() {
       return values;
   }
}
