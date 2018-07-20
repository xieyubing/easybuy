/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : easybuy

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2017-06-30 08:25:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `easybuy_comment`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_comment`;
CREATE TABLE `easybuy_comment` (
  `ec_id` int(10) NOT NULL default '0' COMMENT '自动编号',
  `ec_reply` varchar(200) default NULL,
  `ec_content` varchar(200) NOT NULL,
  `ec_create_time` datetime NOT NULL,
  `ec_reply_time` datetime default NULL,
  `ec_nick_name` varchar(10) NOT NULL,
  PRIMARY KEY  (`ec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_comment
-- ----------------------------
INSERT INTO `easybuy_comment` VALUES ('655', '货以发出，请注意收货时间', '刚定了台IPod，很是期待啊', '2010-10-22 00:00:00', '2010-10-22 00:00:00', '小乖');
INSERT INTO `easybuy_comment` VALUES ('680', '一般在订单确定后的第3天开始发货', '佳能D50现在可以多长时间发货', '2010-10-24 00:00:00', '2011-02-14 00:00:00', '无极');

-- ----------------------------
-- Table structure for `easybuy_news`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_news`;
CREATE TABLE `easybuy_news` (
  `en_id` int(10) NOT NULL default '0',
  `en_title` varchar(40) NOT NULL default '' COMMENT '不能重复',
  `en_content` varchar(1000) NOT NULL,
  `en_create_time` datetime NOT NULL COMMENT '系统时间',
  PRIMARY KEY  (`en_id`,`en_title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_news
-- ----------------------------
INSERT INTO `easybuy_news` VALUES ('529', '最新酷睿笔记本', 'IBME系列全场促销中，最新酷睿双核处理机，保证CPU更高效的运转', '2010-12-23 00:00:00');
INSERT INTO `easybuy_news` VALUES ('530', '团购无忧', '团购无忧', '2010-12-22 00:00:00');
INSERT INTO `easybuy_news` VALUES ('531', '会员特惠月开始了', '会员特惠月开始了', '2010-12-22 00:00:00');
INSERT INTO `easybuy_news` VALUES ('597', '迎双旦促销大酬宾', '迎双旦促销大酬宾', '2010-12-22 00:00:00');
INSERT INTO `easybuy_news` VALUES ('649', '加入会员，赢千万大礼包', '加入会员，赢千万大礼包', '2010-12-22 00:00:00');
INSERT INTO `easybuy_news` VALUES ('650', '新年不夜天，通宵也开张了', '新年不夜天，通宵也开张了', '2010-12-22 00:00:00');
INSERT INTO `easybuy_news` VALUES ('651', '积分兑换开始了', '积分兑换开始了', '2010-12-22 00:00:00');
INSERT INTO `easybuy_news` VALUES ('653', '团购阿迪1折起', '团购阿迪1折起', '2010-12-22 00:00:00');
INSERT INTO `easybuy_news` VALUES ('654', '配货通知', '配货通知', '2010-12-22 00:00:00');

-- ----------------------------
-- Table structure for `easybuy_order`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order`;
CREATE TABLE `easybuy_order` (
  `eo_id` int(10) NOT NULL default '0' COMMENT '自动编号',
  `eo_user_id` varchar(10) NOT NULL,
  `eo_user_name` varchar(20) NOT NULL,
  `eo_user_address` varchar(200) NOT NULL,
  `eo_create-time` datetime NOT NULL,
  `eo_cost` decimal(10,2) NOT NULL,
  `eo_status` int(2) NOT NULL COMMENT '1下单，2审核通过，3配货，4送货中，5收货并确认',
  `eo_type` int(2) NOT NULL COMMENT '1货到付款，2网上支付',
  PRIMARY KEY  (`eo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_order
-- ----------------------------
INSERT INTO `easybuy_order` VALUES ('747', 'black', '小乖', '北京市海淀区中关村大厦202', '2011-02-11 00:00:00', '800.00', '1', '1');

-- ----------------------------
-- Table structure for `easybuy_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_order_detail`;
CREATE TABLE `easybuy_order_detail` (
  `eod_id` int(10) NOT NULL default '0' COMMENT '自动编号',
  `eo_id` int(10) NOT NULL,
  `ep_id` int(10) NOT NULL,
  `eod_quantity` int(10) NOT NULL,
  `eod_cost` decimal(10,2) NOT NULL,
  PRIMARY KEY  (`eod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_order_detail
-- ----------------------------
INSERT INTO `easybuy_order_detail` VALUES ('748', '747', '592', '1', '200.00');
INSERT INTO `easybuy_order_detail` VALUES ('749', '747', '643', '2', '600.00');

-- ----------------------------
-- Table structure for `easybuy_product`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product`;
CREATE TABLE `easybuy_product` (
  `ep_id` int(10) NOT NULL default '0' COMMENT '自动编号',
  `ep_name` varchar(20) NOT NULL,
  `ep_description` varchar(100) default NULL,
  `ep_price` decimal(10,2) NOT NULL,
  `ep_stock` int(10) NOT NULL,
  `epc_id` int(10) NOT NULL,
  `epc_child_id` int(10) default NULL,
  `ep_file_name` varchar(200) NOT NULL,
  PRIMARY KEY  (`ep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_product
-- ----------------------------
INSERT INTO `easybuy_product` VALUES ('591', '画册', '画册', '100.00', '9999', '542', null, '1.jpg');
INSERT INTO `easybuy_product` VALUES ('592', '饭盒', '韩国风格', '100.00', '1997', '545', '626', '2.jpg');
INSERT INTO `easybuy_product` VALUES ('593', '护肤王', '女士专用', '300.00', '29998', '542', null, '3.jpg');
INSERT INTO `easybuy_product` VALUES ('601', '奶粉', '三元', '20.00', '199', '545', null, '10.jpg');
INSERT INTO `easybuy_product` VALUES ('639', '旅行包', '旅行包', '2.00', '0', '545', '628', '8.jpg');
INSERT INTO `easybuy_product` VALUES ('643', '项链', '装饰品', '300.00', '2996', '545', '548', '6.jpg');
INSERT INTO `easybuy_product` VALUES ('645', '丝袜', '女士', '50.00', '500', '545', '548', '5.jpg');
INSERT INTO `easybuy_product` VALUES ('660', '显示器', '三星', '20.00', '2000', '545', '628', '9.jpg');
INSERT INTO `easybuy_product` VALUES ('663', '液晶屏', '纯平液晶显示器', '590.00', '3', '545', '628', '4.jpg');

-- ----------------------------
-- Table structure for `easybuy_product_category`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_product_category`;
CREATE TABLE `easybuy_product_category` (
  `epc_id` int(10) NOT NULL,
  `epc_name` varchar(20) NOT NULL,
  `epc_parent_id` int(10) NOT NULL,
  PRIMARY KEY  (`epc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_product_category
-- ----------------------------
INSERT INTO `easybuy_product_category` VALUES ('542', '图书', '542');
INSERT INTO `easybuy_product_category` VALUES ('545', '生活用品', '545');
INSERT INTO `easybuy_product_category` VALUES ('546', '少儿图书', '542');
INSERT INTO `easybuy_product_category` VALUES ('548', '化妆品', '545');
INSERT INTO `easybuy_product_category` VALUES ('626', '厨房用品', '545');
INSERT INTO `easybuy_product_category` VALUES ('628', '家用电器', '545');

-- ----------------------------
-- Table structure for `easybuy_user`
-- ----------------------------
DROP TABLE IF EXISTS `easybuy_user`;
CREATE TABLE `easybuy_user` (
  `eu_user_id` varchar(10) NOT NULL,
  `eu_user_name` varchar(20) default NULL,
  `eu_password` varchar(20) NOT NULL,
  `eu_sex` char(1) default NULL COMMENT '0位女，1位男',
  `eu_birthday` date default NULL,
  `eu_identity_code` varchar(60) default NULL,
  `eu_email` varchar(80) default NULL,
  `eu_mobile` varchar(11) default NULL,
  `eu_address` varchar(200) default NULL,
  `eu_status` int(2) NOT NULL COMMENT '1普通用户，2管理员',
  PRIMARY KEY  (`eu_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of easybuy_user
-- ----------------------------
INSERT INTO `easybuy_user` VALUES ('admin', '李科宏', 'admin', '男', '2009-05-02', '510502197410124415', 'admin@163.com', '15890903456', '北京市海淀区成府路207号', '2');
INSERT INTO `easybuy_user` VALUES ('alice', '爱丽丝', '22222', '女', '2010-02-01', '510502198910254412', 'alice@163.com', '13956567890', '北京市海淀区成府路120号', '1');
INSERT INTO `easybuy_user` VALUES ('black', '小乖', '44444', '女', '2010-03-23', '510502199412254415', 'black@163.com', '13956567834', '北京市海淀区中关村大厦202号', '1');
INSERT INTO `easybuy_user` VALUES ('green', '格林', '33333', '男', '2009-12-30', '510502197502254415', 'green@163.com', '15890945678', '北京市海淀区成府路200号', '1');
INSERT INTO `easybuy_user` VALUES ('howard', '霍华德', '55555', '男', '2010-04-12', '510502196710164415', 'howard@163.com', '15890903456', '北京市海淀区成府路123号', '1');
INSERT INTO `easybuy_user` VALUES ('mike', '麦克', '11111', '男', '2010-01-01', '510502198512044402', 'mike@163.com', '13867678953', '北京市海淀区中关村大厦200号', '1');
INSERT INTO `easybuy_user` VALUES ('smith', '史密斯', '66666', '男', '2010-01-01', '510502199811254415', 'smith@163.com', '15845456782', '北京市海淀区中关村大厦125号', '1');
