/*
Navicat MySQL Data Transfer

Source Server         : asd
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : tarvels

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-05-18 13:08:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_place`
-- ----------------------------
DROP TABLE IF EXISTS `t_place`;
CREATE TABLE `t_place` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `picpath` varchar(100) DEFAULT NULL,
  `hottime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hotticket` double(7,2) DEFAULT NULL,
  `dimticket` double(7,2) DEFAULT NULL,
  `placedes` varchar(300) DEFAULT NULL,
  `provinceid` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_place
-- ----------------------------

-- ----------------------------
-- Table structure for `t_province`
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `tags` varchar(80) DEFAULT NULL,
  `placecounts` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_province
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
