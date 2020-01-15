-- ----------------------------
-- 送验证码配置
-- ----------------------------
INSERT INTO `cfg_service` VALUES (1, '验证码配置', '0', 1,0);
INSERT INTO `cfg_service` VALUES (1001, '是否发送验证码', '1', 1,1);

INSERT INTO `cfg_service_value` VALUES (1,1001,0,"发送");
INSERT INTO `cfg_service_value` VALUES (2,1001,1,"不发送");
1

