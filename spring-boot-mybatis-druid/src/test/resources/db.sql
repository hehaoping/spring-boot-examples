/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-04-07 22:21:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `memo` varchar(400) DEFAULT NULL,
  `prop1` varchar(50) DEFAULT NULL,
  `prop2` varchar(50) DEFAULT NULL,
  `adduser` varchar(50) NOT NULL,
  `addtime` datetime NOT NULL,
  `modifyuser` varchar(50) DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '长沙第1中学', null, null, null, null, 'admin', '2018-01-27 16:58:06', null, null);
INSERT INTO `school` VALUES ('2', '长沙第2中学', null, null, null, null, 'admin', '2018-01-27 16:58:06', null, null);
INSERT INTO `school` VALUES ('3', '长沙第3中学', null, null, null, null, 'admin', '2018-01-27 16:58:06', null, null);
INSERT INTO `school` VALUES ('4', 'xxx大学', null, 'memo4', null, null, 'system', '2018-04-06 15:03:46', null, null);
