
alter table `ums_member` ADD `pid` bigint(20) DEFAULT NULL COMMENT '邀请人id';
alter table `ums_member` ADD `reccode` varchar(6) DEFAULT NULL COMMENT '邀请码';
alter table `ums_member` ADD `depth` int(3) DEFAULT NULL COMMENT '深度';

-- ------------**----------------
-- Table structure for cfg_type
-- ----------------------------
DROP TABLE IF EXISTS `cfg_type`;
CREATE TABLE `cfg_type` (
  `id` int(4) NOT NULL,
  `name` varchar(64) DEFAULT NULL COMMENT '标题',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置类型表';

-- ----------------------------
-- Table structure for cfg_source
-- ----------------------------
DROP TABLE IF EXISTS `cfg_source`;
CREATE TABLE `cfg_source` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '标题',
  `value` varchar(200) DEFAULT NULL COMMENT '值',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `verstion` varchar(10) DEFAULT NULL COMMENT '版本',
  `platform` varchar(10) DEFAULT NULL COMMENT '平台', 
  `icon` varchar(200) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置资源表';


-- ----------------------------
-- Table structure for cfg_type_source
-- ----------------------------
DROP TABLE IF EXISTS `cfg_type_source`;
CREATE TABLE `cfg_type_source` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sourceid` bigint(20) DEFAULT NULL COMMENT '资源id',
  `typeid` bigint(20) DEFAULT NULL COMMENT '资源类型id',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置资源关系表';


-- ------------未执行----------------

-- ----------------------------
-- Table structure for cfg_type_source
-- ----------------------------
DROP TABLE IF EXISTS `cfg_verlog`;
CREATE TABLE `cfg_verlog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `verstion` varchar(10) DEFAULT NULL COMMENT '版本',
  `platform` varchar(10) DEFAULT NULL COMMENT '平台', 
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  `status` int(1) DEFAULT NULL COMMENT '状态 0->待上传 1->待上架 2->已上架 3->已下架', 
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='版本上架记录表';

-- ----------------------------
-- Table structure for cfg_type_source
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_confim`;
CREATE TABLE `oms_order_confim` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(1) DEFAULT NULL COMMENT '状态 0->商品详情购买 1->购物车购买',
  `remark` varchar(1000) DEFAULT NULL COMMENT '下单列表","分割 商品详情是商品id+skuid 购物车是购物车id',
  `status` int(1) DEFAULT NULL COMMENT '状态 0->等待下单 1->已下单 2->超时删除', 
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='确认订单零时记录表';

ALTER TABLE pms_product drop column `promotion_price`,drop column `original_price`;
ALTER TABLE pms_product drop column `stock`,drop column `low_stock`;
ALTER TABLE pms_product drop column `price`;
ALTER table pms_product add `price` varchar(100) COMMENT '商品销售价格区间';

ALTER table pms_sku_stock add `original_price` decimal(10,2) COMMENT '市场价格'; 

ALTER TABLE oms_cart_item drop column `price`,drop column `sp1`,drop column `sp2`;
ALTER TABLE oms_cart_item drop column `sp3`,drop column `member_nickname`,drop column `product_sub_title`;
ALTER TABLE oms_cart_item drop column `product_category_id`,drop column `product_brand`;
ALTER TABLE oms_cart_item drop column `product_sn`,drop column `product_attr`;
ALTER TABLE oms_cart_item drop column `product_pic`,drop column `product_name`;
ALTER TABLE oms_cart_item drop column `product_sku_code`;

ALTER table oms_order_setting add `confim_overtime` int(11) COMMENT '确认订单取消时间';
UPDATE oms_order_setting set `confim_overtime`=1 where id=1;
