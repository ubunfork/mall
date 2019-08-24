
alter table `ums_member` ADD `pid` bigint(20) DEFAULT NULL COMMENT '邀请人id';
alter table `ums_member` ADD `reccode` varchar(6) DEFAULT NULL COMMENT '邀请码';
alter table `ums_member` ADD `depth` int(3) DEFAULT NULL COMMENT '深度';

-- ------------未执行----------------

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
  `verstion` varchar(64) DEFAULT NULL COMMENT '版本',
  `platform` int(1) DEFAULT NULL COMMENT '平台：1->ios 2->安卓 3->webapp', 
  `icon` varchar(200) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`),
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
  PRIMARY KEY (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置资源关系表';