package com.macro.mall.portal.service.impl;

import java.util.Date;
import java.util.List;

import com.alipay.api.domain.Shop;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.SelShopMapper;
import com.macro.mall.model.SelShop;
import com.macro.mall.model.SelShopExample;
import com.macro.mall.model.UmsMember;
import com.macro.mall.portal.domain.SelCreateParam;
import com.macro.mall.portal.service.SelShopService;
import com.macro.mall.portal.service.UmsMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelShopServiceImpl implements SelShopService {

    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private SelShopMapper selShopMapper;
    /**
     * 店铺申请
     */
    @Override
    public CommonResult create(SelCreateParam param) {
        UmsMember currentMember = memberService.getCurrentMember();
        SelShopExample example = new SelShopExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId());
        Long count = selShopMapper.countByExample(example);
        if(count>0){
            return CommonResult.failed("一个会员只能申请一个店铺");
        }
        SelShop selShop = new SelShop();
        selShop.setId(null);
        selShop.setMemberId(currentMember.getId());
        selShop.setName(param.getName());
        selShop.setKeyword(param.getKeyword());
        selShop.setPerson(param.getPerson());
        selShop.setCompanyInfo(param.getCompanyInfo());
        selShop.setCompany(param.getCompany());
        selShop.setMobile(param.getMobile());
        selShop.setType(param.getType());
        selShop.setProvince(param.getProvince());
        selShop.setCity(param.getCity());
        selShop.setDistrict(param.getDistrict());
        selShop.setAddress(param.getAddress());
        selShop.setIdentityType(param.getIdentityType());
        selShop.setIdentityNumber(param.getIdentityNumber());
        selShop.setPersonhandIdentityPic(param.getPersonhandIdentityPic());
        selShop.setIdentityPicFront(param.getIdentityPicFront());
        selShop.setIdentityPicBack(param.getIdentityPicBack());
        selShop.setBusinessLicence(param.getBusinessLicence());
        selShop.setBusinessLicencePic(param.getBusinessLicencePic());
        selShop.setBankAccountName(param.getBankAccountName());
        selShop.setBankName(param.getBankName());
        selShop.setBankBranchName(param.getBankBranchName());
        selShop.setBankAccountNumber(param.getBankAccountNumber());
        selShop.setLng(param.getLng());
        selShop.setLat(param.getLat());
        selShop.setApplyTime(new Date());
        selShop.setModifyTime(new Date());
        selShop.setCreateTime(new Date());
        selShop.setLevel(0);
        int result =  selShopMapper.insertSelective(selShop);
        if(result == 1){
            return CommonResult.success(null);
        }else{
            return CommonResult.failed("申请失败");
        }
        
    }

}