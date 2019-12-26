package com.macro.mall.portal.service.impl;

import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.UmsMember;
import com.macro.mall.portal.domain.MemberProductCollection;
import com.macro.mall.portal.repository.MemberProductCollectionRepository;
import com.macro.mall.portal.service.MemberCollectionService;
import com.macro.mall.portal.service.UmsMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

/**
 * 会员收藏Service实现类
 * Created by macro on 2018/8/2.
 */
@Service
public class MemberCollectionServiceImpl implements MemberCollectionService {

    @Autowired
    private MemberProductCollectionRepository productCollectionRepository;

    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Override
    public int addProduct(@RequestBody Long productId) {
        UmsMember currentMember = memberService.getCurrentMember();
     
        MemberProductCollection findCollection = productCollectionRepository.findByMemberIdAndProductId(currentMember.getId(), productId);
        if (findCollection == null) {
            PmsProduct product = pmsProductMapper.selectByPrimaryKey(productId);
            findCollection = new MemberProductCollection();
            findCollection.setCreateTime(new Date());
            findCollection.setMemberIcon(currentMember.getIcon());
            findCollection.setMemberId(currentMember.getId());
            findCollection.setMemberNickname(currentMember.getNickname());
            findCollection.setProductId(productId);
            findCollection.setProductPic(product.getPrice());
            findCollection.setProductName(product.getName());
            findCollection.setProductSubTitle(product.getSubTitle());
            findCollection.setProductPrice(product.getPrice());
            productCollectionRepository.save(findCollection);
        
        }
        return 1;
    }

    @Override
    public int deleteProduct(Long productId) {
        UmsMember currentMember = memberService.getCurrentMember();
        return productCollectionRepository.deleteByMemberIdAndProductId(currentMember.getId(), productId);
    }

    @Override
    public List<MemberProductCollection> listProduct() {
        UmsMember currentMember = memberService.getCurrentMember();
        return productCollectionRepository.findByMemberId(currentMember.getId());
    }
}
