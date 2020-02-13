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

