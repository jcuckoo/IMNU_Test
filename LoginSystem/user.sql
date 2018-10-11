/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-06-15 08:33:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL DEFAULT '男',
  `home` varchar(255) NOT NULL,
  `info` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('24', '1', '1', 'rgff????', '??', 'fsdt?????');
INSERT INTO `user` VALUES ('25', '435345', '345345', '?', '??', 'sad??????');
INSERT INTO `user` VALUES ('26', '', '', '?', '??', '');
INSERT INTO `user` VALUES ('27', '', '', '?', '??', '212');
INSERT INTO `user` VALUES ('28', '', 'sadasd', '?', '??', '??');
INSERT INTO `user` VALUES ('29', 'a', 'a', 'n', '??', 'a');
