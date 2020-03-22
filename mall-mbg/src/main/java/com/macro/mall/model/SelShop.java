package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SelShop implements Serializable {
    private Long id;

    @ApiModelProperty(value = "个人认证状态 0->等待审核 1->审核通过 2->审核失败")
    private Integer personStatus;

    @ApiModelProperty(value = "企业认证状态 0->等待审核 1->审核通过 2->审核失败")
    private Integer companyStatus;

    @ApiModelProperty(value = "会员id")
    private Long memberId;

    @ApiModelProperty(value = "店铺名")
    private String name;

    @ApiModelProperty(value = "关键字")
    private String keyword;

    @ApiModelProperty(value = "责任人（法人代表或真实姓名）")
    private String person;

    @ApiModelProperty(value = "主体信息")
    private String companyInfo;

    @ApiModelProperty(value = "公司名称")
    private String company;

    @ApiModelProperty(value = "联系方式")
    private String mobile;

    @ApiModelProperty(value = "店铺等级")
    private Integer level;

    @ApiModelProperty(value = "经营类型")
    private String type;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "区域")
    private String district;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "证件类型 0->无 1->个人 2->企业")
    private Integer identityType;

    @ApiModelProperty(value = "证件号码")
    private String identityNumber;

    @ApiModelProperty(value = "手持证件拍照")
    private String personhandIdentityPic;

    @ApiModelProperty(value = "证件正面")
    private String identityPicFront;

    @ApiModelProperty(value = "证件反面")
    private String identityPicBack;

    @ApiModelProperty(value = "营业执照注册号")
    private String businessLicence;

    @ApiModelProperty(value = "营业执照")
    private String businessLicencePic;

    @ApiModelProperty(value = "帐户名称")
    private String bankAccountName;

    @ApiModelProperty(value = "收款银行")
    private String bankName;

    @ApiModelProperty(value = "开户银行支行名称")
    private String bankBranchName;

    @ApiModelProperty(value = "银行账号")
    private String bankAccountNumber;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "经度")
    private BigDecimal lng;

    @ApiModelProperty(value = "纬度")
    private BigDecimal lat;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(Integer personStatus) {
        this.personStatus = personStatus;
    }

    public Integer getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(Integer companyStatus) {
        this.companyStatus = companyStatus;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPersonhandIdentityPic() {
        return personhandIdentityPic;
    }

    public void setPersonhandIdentityPic(String personhandIdentityPic) {
        this.personhandIdentityPic = personhandIdentityPic;
    }

    public String getIdentityPicFront() {
        return identityPicFront;
    }

    public void setIdentityPicFront(String identityPicFront) {
        this.identityPicFront = identityPicFront;
    }

    public String getIdentityPicBack() {
        return identityPicBack;
    }

    public void setIdentityPicBack(String identityPicBack) {
        this.identityPicBack = identityPicBack;
    }

    public String getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(String businessLicence) {
        this.businessLicence = businessLicence;
    }

    public String getBusinessLicencePic() {
        return businessLicencePic;
    }

    public void setBusinessLicencePic(String businessLicencePic) {
        this.businessLicencePic = businessLicencePic;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", personStatus=").append(personStatus);
        sb.append(", companyStatus=").append(companyStatus);
        sb.append(", memberId=").append(memberId);
        sb.append(", name=").append(name);
        sb.append(", keyword=").append(keyword);
        sb.append(", person=").append(person);
        sb.append(", companyInfo=").append(companyInfo);
        sb.append(", company=").append(company);
        sb.append(", mobile=").append(mobile);
        sb.append(", level=").append(level);
        sb.append(", type=").append(type);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", address=").append(address);
        sb.append(", identityType=").append(identityType);
        sb.append(", identityNumber=").append(identityNumber);
        sb.append(", personhandIdentityPic=").append(personhandIdentityPic);
        sb.append(", identityPicFront=").append(identityPicFront);
        sb.append(", identityPicBack=").append(identityPicBack);
        sb.append(", businessLicence=").append(businessLicence);
        sb.append(", businessLicencePic=").append(businessLicencePic);
        sb.append(", bankAccountName=").append(bankAccountName);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankBranchName=").append(bankBranchName);
        sb.append(", bankAccountNumber=").append(bankAccountNumber);
        sb.append(", remark=").append(remark);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}