


alter table `ums_member` ADD `pid` bigint(20) DEFAULT NULL COMMENT '邀请人id';
alter table `ums_member` ADD `reccode` varchar(6) DEFAULT NULL COMMENT '邀请码';
alter table `ums_member` ADD `depth` int(3) DEFAULT NULL COMMENT '深度';