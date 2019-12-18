CREATE DATABASE  IF NOT EXISTS `jpa_guid`;
USE `jpa_guid`;

-- 客户表
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
    `customer_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '客户ID',
    `customer_name` varchar(255) NOT NULL DEFAULT '' COMMENT '客户姓名',
    `address` varchar(255) DEFAULT NULL COMMENT '地址',
    `email` VARCHAR(128) DEFAULT NULL COMMENT 'Email',
    `phone` VARCHAR(32) DEFAULT NULL COMMENT '联系方式',
    `date_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新建时间',
    `date_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更改时间',
    `date_delete` timestamp NULL DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 订单表
DROP TABLE IF EXISTS `customer_order`;
CREATE TABLE `customer_order` (
    `order_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    `order_desc` varchar(500)  DEFAULT NULL COMMENT '订单描述',
    `order_content` varchar(255) DEFAULT '' COMMENT '订单内容',
    `customer_id` int(11) unsigned NOT NULL COMMENT '客户ID',
    `date_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新建时间',
    `date_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更改时间',
    `date_delete` timestamp NULL DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- init data
INSERT INTO `jpa_guid`.`customer`(`customer_id`, `customer_name`, `address`, `email`, `phone`) VALUES (1, '小王', '五常大道175号', '2325345@qq.com', '13251238796');
INSERT INTO `jpa_guid`.`customer`(`customer_id`, `customer_name`, `address`, `email`, `phone`) VALUES (2, '小李', '五常大道175号', '23253451@qq.com', '15251238796');

INSERT INTO `jpa_guid`.`customer_order`(`order_id`, `order_desc`, `order_content`, `customer_id`) VALUES (1, '护肤物品', '神仙水1瓶', 1);
INSERT INTO `jpa_guid`.`customer_order`(`order_id`, `order_desc`, `order_content`, `customer_id`) VALUES (2, '饮食', '煲仔饭', 1);
INSERT INTO `jpa_guid`.`customer_order`(`order_id`, `order_desc`, `order_content`, `customer_id`) VALUES (3, '饮食', '黄焖鸡', 1);