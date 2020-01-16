-- ----------------------------
-- 送验证码配置
-- ----------------------------
INSERT INTO `cfg_service` VALUES (1, '验证码配置', '0', 1,0);
INSERT INTO `cfg_service` VALUES (1001, '是否发送验证码', '1', 1,1);

INSERT INTO `cfg_service_value` VALUES (1,1001,0,"发送");
INSERT INTO `cfg_service_value` VALUES (2,1001,1,"不发送");

INSERT INTO `cfg_service` VALUES (2, '支付宝支付配置', '0', 1, 0);
INSERT INTO `cfg_service` VALUES (1002, '商户appid', NULL, 0, 2);
INSERT INTO `cfg_service` VALUES (1003, '私钥 pkcs8格式的', NULL, 0, 2);
INSERT INTO `cfg_service` VALUES (1004, '支付宝公钥', NULL, 0, 2);
INSERT INTO `cfg_service` VALUES (1005, '服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问', NULL, 0, 2);
INSERT INTO `cfg_service` VALUES (1006, '页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问', NULL, 0, 2);
INSERT INTO `cfg_service` VALUES (1007, '请求支付宝的网关地址', NULL, 0, 2);
INSERT INTO `cfg_service` VALUES (1008, '编码', "UTF-8", 0, 2);
INSERT INTO `cfg_service` VALUES (1009, '返回格式', "json", 0, 2);
INSERT INTO `cfg_service` VALUES (1010, '加密类型', "RSA2", 0, 2);

1

