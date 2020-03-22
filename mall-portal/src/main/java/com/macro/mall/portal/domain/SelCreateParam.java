package com.macro.mall.portal.domain;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;

/**
 * 创建店铺时入参数
 * Created by ubungit on 2020/3/20.
 */
public class SelCreateParam {

    private Long id;

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


    @ApiModelProperty(value = "经度")
    private BigDecimal lng;

    @ApiModelProperty(value = "纬度")
    private BigDecimal lat;


    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
