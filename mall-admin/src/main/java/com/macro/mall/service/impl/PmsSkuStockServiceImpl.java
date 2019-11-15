package com.macro.mall.service.impl;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dao.PmsSkuStockDao;
import com.macro.mall.dto.PmsSkuStockParam;
import com.macro.mall.mapper.PmsProductAttributeValueMapper;
import com.macro.mall.mapper.PmsSkuStockMapper;
import com.macro.mall.model.PmsProductAttributeValue;
import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.model.PmsSkuStockExample;
import com.macro.mall.service.PmsSkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品sku库存管理Service实现类
 * Created by macro on 2018/4/27.
 */
@Service
public class PmsSkuStockServiceImpl implements PmsSkuStockService {
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsSkuStockDao skuStockDao;
    @Autowired
    private PmsProductAttributeValueMapper attributeValueMapper;

    /**
     * 给商品添加sku
     */
    @Override
    public CommonResult create(PmsSkuStockParam skuitem){
        if(skuitem.getProductId() == null){
            return CommonResult.failed("产品id不能为空");
        }
        int result = 0;
        result = skuStockMapper.insert(skuitem);
        if(result ==1 ){
            for (PmsProductAttributeValue attvalue : skuitem.getAttributlvaluelist()) {
                //
                attvalue.setSkuid(skuitem.getId());
                result = attributeValueMapper.insert(attvalue);
                if(result !=1 ){
                    return CommonResult.failed("系统错误");
                }
            }
            return CommonResult.success(result);
        }else{
            return CommonResult.failed("系统错误");
        }
       
    }


    /**
     * 根据商品id获取商品sku列表
     */
    @Override
    public List<PmsSkuStockParam> skuList(Long proid){
        return skuStockDao.selectSkulist(proid);
    }


    @Override
    public List<PmsSkuStock> getList(Long pid, String keyword) {
        PmsSkuStockExample example = new PmsSkuStockExample();
        PmsSkuStockExample.Criteria criteria = example.createCriteria().andProductIdEqualTo(pid);
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andSkuCodeLike("%" + keyword + "%");
        }
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public int update(Long pid, List<PmsSkuStock> skuStockList) {
        return skuStockDao.replaceList(skuStockList);
    }
}
