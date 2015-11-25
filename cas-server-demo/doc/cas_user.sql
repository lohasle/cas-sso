/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50541
Source Host           : localhost:3306
Source Database       : cas_center

Target Server Type    : MYSQL
Target Server Version : 50541
File Encoding         : 65001

Date: 2015-11-24 17:11:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cas_user
-- ----------------------------
DROP TABLE IF EXISTS `cas_user`;
CREATE TABLE `cas_user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cas_user
-- ----------------------------
INSERT INTO `cas_user` VALUES ('1', 'lohas', 'lohas', '15279113049', '244104850@qq.com');
INSERT INTO `cas_user` VALUES ('2', '中文', '123456', '15279113022', 'days365le@gmail.com');
