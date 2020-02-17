-- ----------------------------
-- 服务器配置
-- ----------------------------
INSERT INTO `cfg_service` (`id`, `name`, `value`, `maybe`, `parentid`, `type`)
VALUES
	(1,'验证码配置','0',NULL,0,0),
	(2,'支付宝支付配置','0',NULL,0,0),
	(1001,'是否发送验证码','1',NULL,1,1),
	(1002,'商户appid',NULL,NULL,2,0),
	(1003,'私钥 pkcs8格式的',NULL,NULL,2,0),
	(1004,'支付宝公钥',NULL,NULL,2,0),
	(1005,'服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问',NULL,NULL,2,0),
	(1006,'页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问',NULL,NULL,2,0),
	(1007,'请求支付宝的网关地址',NULL,NULL,2,0),
	(1008,'编码','UTF-8',NULL,2,0),
	(1009,'返回格式','json',NULL,2,0),
	(1010,'加密类型','RSA2',NULL,2,0);

INSERT INTO `cfg_service_value` (`id`, `serviceid`, `value`, `remark`)
VALUES
	(1,1001,'0','发送'),
	(2,1001,'1','不发送');

-- ----------------------------
-- app 配置
-- ----------------------------

LOCK TABLES `cfg_verlog` WRITE;
INSERT INTO `cfg_verlog` (`id`, `verstion`, `platform`, `remark`, `status`, `modify_time`, `create_time`)
VALUES
	(1,'v1.0.1','iOS',NULL,0,'2020-02-15 10:56:54','2020-02-15 10:56:54'),
	(2,'v1.0.1','Android',NULL,1,'2020-02-15 10:57:55','2020-02-15 10:57:55'),
	(3,'v0.0.0','all','全部平台 全部版本',2,'2020-02-15 11:19:33','2020-02-15 11:19:33'),
	(4,'v0.0.0','iOS','iOS全部版本',2,'2020-02-15 11:20:13','2020-02-15 11:20:13'),
	(5,'v0.0.0','Android','Android全部版本',2,'2020-02-15 11:20:40','2020-02-15 11:20:40');
UNLOCK TABLES;


LOCK TABLES `cfg_type_source` WRITE;
INSERT INTO `cfg_type_source` (`id`, `sourceid`, `typeid`, `modify_time`)
VALUES
	(1,1,1001,'2020-02-15 11:23:46');
UNLOCK TABLES;

LOCK TABLES `cfg_type` WRITE;
INSERT INTO `cfg_type` (`id`, `name`, `remark`)
VALUES
	(1001,'支付类型','支付类型');
UNLOCK TABLES;


LOCK TABLES `cfg_source` WRITE;
INSERT INTO `cfg_source` (`id`, `name`, `value`, `remark`, `verstion`, `platform`, `icon`)
VALUES
	(1,'支付宝','1001','支付宝支付','v0.0.0','all',NULL);
UNLOCK TABLES;

