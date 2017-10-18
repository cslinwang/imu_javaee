/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : imu_work6

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-12 11:30:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `login_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `login_datetime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '1', '192.168.12.7', '2017-10-11 21:30:30');
INSERT INTO `log` VALUES ('2', '1', '192.168.12.7', '2017-10-11 21:37:26');
INSERT INTO `log` VALUES ('3', '1', '192.168.12.7', '2017-10-11 21:37:40');
INSERT INTO `log` VALUES ('4', '1', '192.168.12.7', '2017-10-11 21:37:53');
INSERT INTO `log` VALUES ('5', '1', '0:0:0:0:0:0:0:1', '2017-10-11 22:03:17');
INSERT INTO `log` VALUES ('6', '1', '0:0:0:0:0:0:0:1', '2017-10-11 22:03:23');
INSERT INTO `log` VALUES ('7', '1', '0:0:0:0:0:0:0:1', '2017-10-11 22:03:26');
INSERT INTO `log` VALUES ('8', '1', '0:0:0:0:0:0:0:1', '2017-10-11 22:03:27');
INSERT INTO `log` VALUES ('9', '1', '0:0:0:0:0:0:0:1', '2017-10-12 08:46:39');
INSERT INTO `log` VALUES ('10', '1', '0:0:0:0:0:0:0:1', '2017-10-12 08:47:30');
INSERT INTO `log` VALUES ('11', '1', '0:0:0:0:0:0:0:1', '2017-10-12 08:49:07');
INSERT INTO `log` VALUES ('12', '1', '0:0:0:0:0:0:0:1', '2017-10-12 08:50:01');
INSERT INTO `log` VALUES ('13', '1', '0:0:0:0:0:0:0:1', '2017-10-12 11:01:09');
INSERT INTO `log` VALUES ('14', '1', '0:0:0:0:0:0:0:1', '2017-10-12 11:01:59');
INSERT INTO `log` VALUES ('15', '1', '0:0:0:0:0:0:0:1', '2017-10-12 11:02:01');
INSERT INTO `log` VALUES ('16', '1', '0:0:0:0:0:0:0:1', '2017-10-12 11:03:22');
INSERT INTO `log` VALUES ('17', '1', '0:0:0:0:0:0:0:1', '2017-10-12 11:04:46');
INSERT INTO `log` VALUES ('18', '1', '0:0:0:0:0:0:0:1', '2017-10-12 11:05:24');
INSERT INTO `log` VALUES ('19', '1', '0:0:0:0:0:0:0:1', '2017-10-12 11:06:01');
INSERT INTO `log` VALUES ('20', '1', '0:0:0:0:0:0:0:1', '2017-10-12 11:06:35');
INSERT INTO `log` VALUES ('21', '1', '0:0:0:0:0:0:0:1', '2017-10-12 11:06:49');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  `last_visit` date DEFAULT NULL,
  `last_ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', '105', '2017-10-12', '0:0:0:0:0:0:0:1');
