## 2019.9.9

### 1:移动商品销售价格，库存信息到sku表
> 删除商品表中以下4个字段
ALTER TABLE pms_product drop column `promotion_price`,drop column `original_price`;
ALTER TABLE pms_product drop column `stock`,drop column `low_stock`;
ALTER TABLE pms_product drop column `price`;
ALTER table pms_product add `price` varchar(100);


> 后台取消设置商品库存与价格相关逻辑
> sku表添加市场价
ALTER table pms_sku_stock add `original_price` decimal(10,2) COMMENT '市场价格'; 

### 2:删除购物车价格相关参数

ALTER TABLE oms_cart_item drop column `price`,drop column `sp1`,drop column `sp2`;
ALTER TABLE oms_cart_item drop column `sp3`,drop column `member_nickname`,drop column `product_sub_title`;
ALTER TABLE oms_cart_item drop column `product_category_id`,drop column `product_brand`;
ALTER TABLE oms_cart_item drop column `product_sn`,drop column `product_attr`;
ALTER TABLE oms_cart_item drop column `product_pic`,drop column `product_name`;
ALTER TABLE oms_cart_item drop column `product_sku_code`;


### 2:添加根据商品id加sku id查询商品详情
