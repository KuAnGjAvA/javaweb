/*
Navicat MySQL Data Transfer

Source Server         : mysql57
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2022-06-22 15:11:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_address`
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `user_id` char(11) NOT NULL COMMENT '用户编号（用户手机号）',
  `address` varchar(50) NOT NULL COMMENT '地址',
  `added` datetime NOT NULL COMMENT '添加日期/时间',
  `receiver` varchar(30) NOT NULL COMMENT '收件人（姓名）',
  `receiver_phone` char(11) NOT NULL COMMENT '收件人电话',
  PRIMARY KEY (`rid`),
  KEY `fk_address_user` (`user_id`),
  CONSTRAINT `fk_address_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户地址表';

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES ('1', '12345678901', '武汉市洪山区雄楚大道悦活里3楼331室', '2017-06-27 22:50:18', '刘铁蛋', '12345678901');
INSERT INTO `tb_address` VALUES ('2', '12345678901', '武汉市洪山区雄楚大道悦活里坤广场E座10层10017室', '2017-08-15 17:15:37', '王翠花', '12345678901');
INSERT INTO `tb_address` VALUES ('3', '12345678901', '上海市杨浦区南京东路66号余庆里2弄6号', '2017-08-15 23:59:36', '陈二狗', '12345678801');

-- ----------------------------
-- Table structure for `tb_banner`
-- ----------------------------
DROP TABLE IF EXISTS `tb_banner`;
CREATE TABLE `tb_banner` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `product` char(13) NOT NULL COMMENT '商品（商品编号）',
  PRIMARY KEY (`rid`),
  KEY `fk_banner_book` (`product`),
  CONSTRAINT `fk_banner_book` FOREIGN KEY (`product`) REFERENCES `tb_book` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='banner记录表';

-- ----------------------------
-- Records of tb_banner
-- ----------------------------
INSERT INTO `tb_banner` VALUES ('5', '9787111526285');
INSERT INTO `tb_banner` VALUES ('2', '9787111563891');
INSERT INTO `tb_banner` VALUES ('3', '9787111564805');
INSERT INTO `tb_banner` VALUES ('4', '9787115353528');
INSERT INTO `tb_banner` VALUES ('1', '9787121281556');

-- ----------------------------
-- Table structure for `tb_book`
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `isbn` char(13) NOT NULL COMMENT '图书编号',
  `title` varchar(80) NOT NULL COMMENT '标题（书名）',
  `author` varchar(80) NOT NULL COMMENT '作者',
  `price` double(9,2) NOT NULL COMMENT '价格',
  `press` varchar(50) NOT NULL COMMENT '出版社',
  `edition` int(11) NOT NULL DEFAULT '1' COMMENT '版次',
  `published` datetime NOT NULL COMMENT '出版日期/时间',
  `pages` int(11) NOT NULL DEFAULT '0' COMMENT '页数',
  `words` int(11) NOT NULL DEFAULT '0' COMMENT '字数',
  `packaging` varchar(10) NOT NULL DEFAULT '平装' COMMENT '包装',
  `format` varchar(6) NOT NULL DEFAULT '16开' COMMENT '开本',
  `form` varchar(10) NOT NULL DEFAULT '胶版纸' COMMENT '用纸',
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图书信息表';

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `tb_book` VALUES ('9787111213826', 'Java编程思想', '[美] 埃克尔，译者：陈昊鹏 编', '86.40', '机械工业出版社', '4', '2007-06-01 00:00:00', '880', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787111526285', 'Go程序设计语言（英文版）', '[美] 艾伦A.A.多诺万 等 著', '64.70', '机械工业出版社 ', '1', '2016-01-01 00:00:00', '366', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787111532644', '架构即未来', '[美] 马丁L.阿伯特（MartinL.Abbott），迈克尔T.费舍尔（MichaelT.Fisher） 著；陈斌 译', '81.00', '机械工业出版社', '1', '2016-04-01 00:00:00', '660', '0', '平装', '32开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787111545682', 'Linux运维最佳实践', '胥峰，杨俊俊 著', '56.50', '机械工业出版社', '1', '2016-09-01 00:00:00', '325', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787111563891', '面向机器智能的TensorFlow实践', '[美] 山姆·亚伯拉罕（Sam Abrahams），丹尼亚尔·哈夫纳（Danijar Hafner），埃里克·厄威特，阿里尔·斯卡尔皮内里 著；段菲，陈澎 译', '56.50', '机械工业出版社', '1', '2017-05-01 00:00:00', '212', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787111564805', '企业IT架构转型之道', '钟华 著', '53.80', '机械工业出版社', '1', '2017-05-01 00:00:00', '229', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787115130228', 'C Primer Plus', '[美] 普拉塔（Prata S.） 著；云巅工作室 编 ', '49.80', '人民邮电出版社', '5', '2017-06-27 22:44:28', '626', '1298000', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787115335500', '深入浅出Node.js', '朴灵 著', '57.30', '人民邮电出版社', '1', '2013-12-01 00:00:00', '348', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787115353528', 'Python基础教程', '[挪] Magnus Lie Hetland 著；司维，曾军崴，谭颖华 译', '65.60', '人民邮电出版社', '2', '2014-06-01 00:00:00', '470', '727000', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787115386397', 'Spring MVC学习指南', '[美] 戴克（Paul Deck） 著；林仪明，崔毅 译', '40.70', '人民邮电出版社 ', '1', '2015-05-01 00:00:00', '274', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787115388025', '图解机器学习 ', '[日] 杉山将 著；许永伟 译', '40.70', '人民邮电出版社', '1', '2015-04-01 00:00:00', '226', '0', '平装', '32开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787115435101', 'Python数据科学指南', '印度，Gopi，Subramanian，萨伯拉曼尼安 著；方延风，刘丹 译', '66.20', '人民邮电出版社', '1', '2016-11-01 00:00:00', '380', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787121281556', 'Hadoop 2.X HDFS源码剖析', '徐鹏 著', '86.40', '电子工业出版社', '1', '2016-03-01 00:00:00', '554', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787121291609', 'Go语言学习笔记 ', '雨痕　 著', '73.90', '电子工业出版社', '1', '2016-07-01 00:00:00', '468', '552000', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787302383666', 'MongoDB大数据处理权威指南', '[美] David Hows，Eelco Plugge，Peter Mem 著；王肖峰 译', '42.00', '清华大学出版社', '2', '2014-11-01 00:00:00', '269', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787302435167', '大数据架构师指南', '朱进云 著', '38.30', '清华大学出版社', '1', '2016-06-01 00:00:00', '271', '0', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787302459873', '数据挖掘与预测分析', '[美] Daniel T.Larose，Chantal D.Larose 著', '84.10', '清华大学出版社', '2', '2017-03-01 00:00:00', '725', '1144000', '平装', '16开', '胶版纸');
INSERT INTO `tb_book` VALUES ('9787508344980', 'Head First Java（涵盖Java5.0）', '[美] 塞若（Sierra K.），[美] 贝茨（Bates B.） 著', '53.90', '中国电力出版社', '2', '2007-02-01 00:00:00', '689', '983000', '平装', '16开', '胶版纸');

-- ----------------------------
-- Table structure for `tb_cart_item`
-- ----------------------------
DROP TABLE IF EXISTS `tb_cart_item`;
CREATE TABLE `tb_cart_item` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `user_id` char(11) NOT NULL COMMENT '用户编号（用户手机号）',
  `product` char(13) NOT NULL COMMENT '商品（商品编号）',
  `count` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`rid`),
  KEY `fk_cart_item_book` (`product`),
  KEY `fk_cart_item_user` (`user_id`),
  CONSTRAINT `fk_cart_item_book` FOREIGN KEY (`product`) REFERENCES `tb_book` (`isbn`),
  CONSTRAINT `fk_cart_item_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='购物车信息表';

-- ----------------------------
-- Records of tb_cart_item
-- ----------------------------
INSERT INTO `tb_cart_item` VALUES ('1', '12345678901', '9787302383666', '3');
INSERT INTO `tb_cart_item` VALUES ('2', '12345678901', '9787111213826', '2');
INSERT INTO `tb_cart_item` VALUES ('3', '12345678901', '9787115130228', '1');

-- ----------------------------
-- Table structure for `tb_collect`
-- ----------------------------
DROP TABLE IF EXISTS `tb_collect`;
CREATE TABLE `tb_collect` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `user_id` char(11) NOT NULL COMMENT '用户编号（用户手机号）',
  `product` char(13) NOT NULL COMMENT '商品（商品编号）',
  PRIMARY KEY (`rid`),
  KEY `fk_collect_user` (`user_id`),
  KEY `fk_collect_book` (`product`),
  CONSTRAINT `fk_collect_book` FOREIGN KEY (`product`) REFERENCES `tb_book` (`isbn`),
  CONSTRAINT `fk_collect_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户收藏表';

-- ----------------------------
-- Records of tb_collect
-- ----------------------------
INSERT INTO `tb_collect` VALUES ('1', '12345678901', '9787302383666');
INSERT INTO `tb_collect` VALUES ('2', '12345678901', '9787115130228');
INSERT INTO `tb_collect` VALUES ('3', '12345678901', '9787111532644');
INSERT INTO `tb_collect` VALUES ('4', '12345678901', '9787111545682');
INSERT INTO `tb_collect` VALUES ('5', '12345678901', '9787115335500');
INSERT INTO `tb_collect` VALUES ('6', '12345678901', '9787302435167');

-- ----------------------------
-- Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `user_id` char(11) NOT NULL COMMENT '用户编号（用户手机号）',
  `order_id` char(15) NOT NULL COMMENT '订单编号（手机号后3位+yyyyMMddHHmm）',
  `sta` varchar(10) NOT NULL COMMENT '订单状态（待处理；处理中；已发货；已交付）',
  `address_id` int(11) DEFAULT NULL COMMENT '收货地址',
  `payment` double(9,2) DEFAULT NULL COMMENT '支付金额',
  `placed` datetime DEFAULT NULL COMMENT '下单时间',
  `receipt` datetime DEFAULT NULL COMMENT '接单时间',
  `deliver` datetime DEFAULT NULL COMMENT '发货时间',
  `handover` datetime DEFAULT NULL COMMENT '交付时间',
  PRIMARY KEY (`rid`),
  UNIQUE KEY `uni_order` (`order_id`),
  KEY `fk_order_user` (`user_id`),
  KEY `fk_order_address` (`address_id`),
  CONSTRAINT `fk_order_address` FOREIGN KEY (`address_id`) REFERENCES `tb_address` (`rid`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单信息表';

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('1', '12345678901', '901202206221506', '寰呭鐞�', '1', '81.40', '2022-06-22 15:06:37', null, null, null);

-- ----------------------------
-- Table structure for `tb_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_item`;
CREATE TABLE `tb_order_item` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `product` char(13) NOT NULL COMMENT '商品（商品编号）',
  `price` double(9,2) NOT NULL COMMENT '价格',
  `count` int(11) NOT NULL COMMENT '数量',
  `order_id` char(15) NOT NULL COMMENT '订单编号',
  PRIMARY KEY (`rid`),
  KEY `fk_order_item_order` (`order_id`),
  KEY `fk_order_item_book` (`product`),
  CONSTRAINT `fk_order_item_book` FOREIGN KEY (`product`) REFERENCES `tb_book` (`isbn`),
  CONSTRAINT `fk_order_item_order` FOREIGN KEY (`order_id`) REFERENCES `tb_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单项目表';

-- ----------------------------
-- Records of tb_order_item
-- ----------------------------
INSERT INTO `tb_order_item` VALUES ('1', '9787115386397', '40.70', '2', '901202206221506');

-- ----------------------------
-- Table structure for `tb_recommended`
-- ----------------------------
DROP TABLE IF EXISTS `tb_recommended`;
CREATE TABLE `tb_recommended` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录编号',
  `product` char(13) NOT NULL COMMENT '商品（商品编号）',
  PRIMARY KEY (`rid`),
  KEY `fk_recommended_book` (`product`),
  CONSTRAINT `fk_recommended_book` FOREIGN KEY (`product`) REFERENCES `tb_book` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品推荐表';

-- ----------------------------
-- Records of tb_recommended
-- ----------------------------
INSERT INTO `tb_recommended` VALUES ('4', '9787111213826');
INSERT INTO `tb_recommended` VALUES ('3', '9787111545682');
INSERT INTO `tb_recommended` VALUES ('2', '9787115335500');
INSERT INTO `tb_recommended` VALUES ('1', '9787302435167');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `phone` char(11) NOT NULL COMMENT '电话（手机号）',
  `uname` varchar(30) NOT NULL COMMENT '用户名',
  `upwd` varchar(30) NOT NULL DEFAULT '000000' COMMENT '密码',
  `email` varchar(30) NOT NULL COMMENT '邮箱',
  `role` int(1) NOT NULL DEFAULT '0' COMMENT '角色（1表示管理员）',
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('12345678900', 'admin', '111111', 'admin@abc', '1');
INSERT INTO `tb_user` VALUES ('12345678901', 'user01', '000000', 'user01@abc', '0');
INSERT INTO `tb_user` VALUES ('12345678902', 'user02', '000000', 'user02@abc', '0');
