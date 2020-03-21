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
-- 服务器配置表
-- ----------------------------
DROP TABLE IF EXISTS `cfg_service`;
CREATE TABLE `cfg_service` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(512) DEFAULT NULL COMMENT '标题',
  `value` varchar(200) DEFAULT NULL COMMENT '设置值',
  `maybe` varchar(1000) DEFAULT NULL COMMENT '可选json参数[{key:value}]，如果为空则为string',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务器设置';
-- ----------------------------
-- 服务器配置修改
-- ----------------------------
ALTER table cfg_service add `value_type` int(1) DEFAULT 0 COMMENT '值类型，0 用户输入 1:有可选值';
ALTER table cfg_service add `parentid` int(4) DEFAULT 0 COMMENT '配置父id';
ALTER table cfg_service modify column `maybe` varchar(1000) DEFAULT NULL COMMENT '废弃（20200115） 可选json参数[{key:value}]，如果为空则为string';
-- ----------------------------
-- 服务器配置修改 添加关键key，id不再作为关键key
-- ----------------------------
ALTER table cfg_service add `cfg_key` varchar(50) DEFAULT NULL COMMENT '关键key';


CREATE TABLE `cfg_cnarea` (
  `id` mediumint(7) unsigned NOT NULL AUTO_INCREMENT,
  `level` tinyint(1) unsigned NOT NULL COMMENT '层级',
  `parent_code` bigint(14) unsigned NOT NULL DEFAULT '0' COMMENT '父级行政代码',
  `area_code` bigint(14) unsigned NOT NULL DEFAULT '0' COMMENT '行政代码',
  `zip_code` mediumint(6) unsigned zerofill NOT NULL DEFAULT '000000' COMMENT '邮政编码',
  `city_code` char(6) NOT NULL DEFAULT '' COMMENT '区号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `short_name` varchar(50) NOT NULL DEFAULT '' COMMENT '简称',
  `merger_name` varchar(50) NOT NULL DEFAULT '' COMMENT '组合名',
  `pinyin` varchar(30) NOT NULL DEFAULT '' COMMENT '拼音',
  `lng` decimal(10,6) NOT NULL DEFAULT '0.000000' COMMENT '经度',
  `lat` decimal(10,6) NOT NULL DEFAULT '0.000000' COMMENT '纬度',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code` (`area_code`) USING BTREE,
  KEY `idx_parent_code` (`parent_code`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='中国行政地区表';




-- ----------------------------
-- 服务器设置的值表
-- ----------------------------
DROP TABLE IF EXISTS `cfg_service_value`;
CREATE TABLE `cfg_service_value` (
  `id` int(4) NOT NULL,
  `serviceid` int(4) NOT NULL COMMENT '配置id',
  `value` varchar(1024) NOT NULL COMMENT '配置值',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务器设置的值表';