package com.macro.mall.portal.service.impl;

import com.macro.mall.mapper.UmsMemberReceiveAddressMapper;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsMemberReceiveAddress;
import com.macro.mall.model.UmsMemberReceiveAddressExample;
import com.macro.mall.portal.service.UmsMemberReceiveAddressService;
import com.macro.mall.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户地址管理Service实现类
 * Created by macro on 2018/8/28.
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private UmsMemberReceiveAddressMapper addressMapper;
    @Override
    public int add(UmsMemberReceiveAddress address) {
        UmsMember currentMember = memberService.getCurrentMember();
        address.setMemberId(currentMember.getId());
        if(address.getDefaultStatus()==1){
            setDefaultStatus(address);
        }
        return addressMapper.insert(address);
    }

    @Override
    public int delete(Long id) {

        UmsMemberReceiveAddress daddress =  addressMapper.selectByPrimaryKey(id);
        int result = addressMapper.deleteByPrimaryKey(id);
        if(daddress.getDefaultStatus()==1){
            setDefaultStatus(null);
        }
        
        return result;
    }

    @Override
    public int update(Long id, UmsMemberReceiveAddress address) {
        address.setId(null);
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        
        if( address.getDefaultStatus()!=null && address.getDefaultStatus()==1){
            setDefaultStatus(address);
        }
        return addressMapper.updateByExampleSelective(address,example);
    }

    @Override
    public List<UmsMemberReceiveAddress> list() {
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId());
        return addressMapper.selectByExample(example);
    }

    @Override
    public UmsMemberReceiveAddress getItem(Long id) {
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        List<UmsMemberReceiveAddress> addressList = addressMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(addressList)){
            return addressList.get(0);
        }
        return null;
    }
    @Override
    public UmsMemberReceiveAddress defual(){
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andDefaultStatusEqualTo(1);
        List<UmsMemberReceiveAddress> addressList = addressMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(addressList)){
            return addressList.get(0);
        }
        return null;
    }

    private int setDefaultStatus(UmsMemberReceiveAddress address){
       

        UmsMember currentMember = memberService.getCurrentMember();
        //修改用户收获地址为非默认
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId());
        UmsMemberReceiveAddress upaddress = new UmsMemberReceiveAddress();
        upaddress.setDefaultStatus(0);
        addressMapper.updateByExampleSelective(upaddress, example);

        if(address == null){
            address = addressMapper.selectByExample(example).get(0);
        }

        address.setDefaultStatus(1);
        return addressMapper.updateByPrimaryKeySelective(address);

    }
}
