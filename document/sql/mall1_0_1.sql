
alter table `ums_member` ADD `pid` bigint(20) DEFAULT NULL COMMENT '邀请人id';
alter table `ums_member` ADD `reccode` varchar(6) DEFAULT NULL COMMENT '邀请码';
alter table `ums_member` ADD `depth` int(3) DEFAULT NULL COMMENT '深度';

-- ----------------------------
-- Table structure for oms_order_confim
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

-- ----------------------------
-- 删除商品的库存属性，修改价格属性为价格区间
-- ----------------------------
ALTER TABLE pms_product drop column `promotion_price`,drop column `original_price`;
ALTER TABLE pms_product drop column `stock`,drop column `low_stock`;
ALTER TABLE pms_product drop column `price`;
ALTER table pms_product add `price` decimal(10,2) COMMENT '商品销售价格区间';
-- ----------------------------
-- 给sku添加市场价格，作为原价显示
-- ----------------------------
ALTER table pms_sku_stock add `original_price` decimal(10,2) COMMENT '市场价格'; 

-- ----------------------------
-- 删除购物车多余属性
-- ----------------------------
ALTER TABLE oms_cart_item drop column `price`,drop column `sp1`,drop column `sp2`;
ALTER TABLE oms_cart_item drop column `sp3`,drop column `member_nickname`,drop column `product_sub_title`;
ALTER TABLE oms_cart_item drop column `product_category_id`,drop column `product_brand`;
ALTER TABLE oms_cart_item drop column `product_sn`,drop column `product_attr`;
ALTER TABLE oms_cart_item drop column `product_pic`,drop column `product_name`;
ALTER TABLE oms_cart_item drop column `product_sku_code`;

-- ----------------------------
-- 订单设置添加确认订单数据删除事件设置
-- ----------------------------
ALTER table oms_order_setting add `confim_overtime` int(11) COMMENT '确认订单取消时间';
UPDATE oms_order_setting set `confim_overtime`=1 where id=1;


ALTER table pms_product add `ownerId` bigint(20) NOT NULL  COMMENT '商品拥有者(卖家id)';

-- ----------------------------
-- 自提点表
-- ----------------------------
DROP TABLE IF EXISTS `pms_station`;
CREATE TABLE `pms_station` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`status` int(1) DEFAULT '0' COMMENT '0->等待审核 1->审核通过 2->审核失败',
`member_id` bigint(20) DEFAULT NULL COMMENT '会员id',
`name` varchar(100) DEFAULT NULL COMMENT '自提点名称',
`phone_number` varchar(64) DEFAULT NULL COMMENT '电话号码',
`province` varchar(100) DEFAULT NULL COMMENT '省份/直辖市',
`city` varchar(100) DEFAULT NULL COMMENT '城市',
`region` varchar(100) DEFAULT NULL COMMENT '区',
`detail_address` varchar(128) DEFAULT NULL COMMENT '详细地址(街道)',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品自提点表';


DROP TABLE IF EXISTS `sys_vertify_record`;
CREATE TABLE `sys_vertify_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ver_id` bigint(20) DEFAULT NULL COMMENT '审核人id',
  `def_id` bigint(20) DEFAULT NULL COMMENT '审核对应的订单id',
  `type` int(3) DEFAULT NULL COMMENT '审核对应类型 1->自提点申请',
  `status` int(1) DEFAULT NULL COMMENT  '对应的审核状态',
  `detail` varchar(255) DEFAULT NULL COMMENT '反馈详情',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='审核记录';


-- ----------------------------
-- 物流订单
-- ----------------------------
DROP TABLE IF EXISTS `oms_logistics`;
CREATE TABLE `oms_logistics` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`logisticsNum` varchar(64) DEFAULT NULL COMMENT '物流单号',
`orderid` bigint(20) DEFAULT NULL COMMENT '订单id',
`logisticsCom` varchar(64) DEFAULT NULL COMMENT '物流公司',
`price` decimal(10,2) DEFAULT NULL COMMENT '物流价格',
`payer` varchar(100) DEFAULT NULL COMMENT '付款人',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流订单表';

-- ----------------------------
-- 自提点订单
-- ----------------------------
DROP TABLE IF EXISTS `oms_station`;
CREATE TABLE `oms_station` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`stationid` bigint(20) DEFAULT NULL COMMENT '自提点id',
`status` int(1) DEFAULT '0' COMMENT ' 1->配送中 2->待取货 3->已取货 4->已结算',
`logisticsid` bigint(20) DEFAULT NULL COMMENT '物流id',
`orderid` bigint(20) DEFAULT NULL COMMENT '订单id',
`price` decimal(10,2) DEFAULT NULL COMMENT '自提点价格',
`payer` varchar(100) DEFAULT NULL COMMENT '付款人',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自提点订单表';


ALTER table pms_product_attribute_value add `skuid` bigint(20) NOT NULL  COMMENT 'skuid';





-- ----------------------------
-- 商品表添加添加时间跟修改时间
-- ----------------------------
ALTER table pms_product add `create_time` datetime DEFAULT NULL COMMENT '创建时间';
ALTER table pms_product add `modify_time` datetime DEFAULT NULL COMMENT '修改时间';

ALTER table oms_order modify column `receiver_name` varchar(100) DEFAULT NULL COMMENT '收货人姓名';
ALTER table oms_order modify column `receiver_phone` varchar(32) DEFAULT NULL COMMENT '收货人电话';
ALTER table oms_order modify column `status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->待收货（待自提） 4->已完成；5->已关闭；6->无效订单'



ALTER table pms_product add `defual_sku` bigint(20) DEFAULT NULL COMMENT '默认SKUID';
ALTER TABLE pms_product drop column `price`;
ALTER table pms_product add `price` decimal(10,2) COMMENT '商品销售价格';


-- ----------------------------
-- 用户信息添加最新登陆事件
-- ----------------------------
alter table `ums_member` ADD `login_time` datetime DEFAULT NULL COMMENT '最后登陆时间';
alter table `ums_member` ADD `login_uuid` varchar(200) NULL COMMENT '设备UUID';
alter table `ums_member` ADD `login_ip` varchar(50) NULL COMMENT '登陆ip地址';

-- ----------------------------
-- 用户登陆日志添加uuid
-- ----------------------------
alter table `ums_member_login_log` ADD `uuid` varchar(200) NULL COMMENT '设备UUID';
alter table `ums_member_login_log` ADD `remark` varchar(200) NULL COMMENT '备注';

alter table `ums_integration_change_history` ADD  `balance` int(11)   DEFAULT NULL COMMENT '积分结余';

-- ----------------------------
-- 后台用户添加手机号 密码版本
-- ----------------------------
alter table `ums_admin` ADD `phone` varchar(64) DEFAULT NULL COMMENT '手机号码';
alter table `ums_admin` ADD `password_verstion` int(1) DEFAULT NULL COMMENT '密码版本 0->未设置 1->系统默认 2->用户设置';


