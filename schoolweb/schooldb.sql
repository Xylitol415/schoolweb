/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50635
Source Host           : 127.0.0.1:3306
Source Database       : schooldb

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2019-05-28 10:22:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dangfei
-- ----------------------------
DROP TABLE IF EXISTS `t_dangfei`;
CREATE TABLE `t_dangfei` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `typeid` varchar(50) DEFAULT NULL,
  `typename` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `classname` varchar(50) DEFAULT NULL,
  `dangtype` int(4) DEFAULT NULL,
  `shouyear` varchar(50) DEFAULT NULL,
  `dangfei` double(8,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_dangfei
-- ----------------------------
INSERT INTO `t_dangfei` VALUES ('3', '0', '第一支部', '王明', '15财务管理', '10', '2012', '24.00');
INSERT INTO `t_dangfei` VALUES ('5', '0', '第二支部', '周明', '2016级金融工程', '4', '2018', '9.60');

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `inputdate` varchar(50) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `xiangqing` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('1', '系统更新', '2019-03-16 21:51:55', '系统更新，各学院请按照最新版本上传党员信息', 'admin', '系统更新');
INSERT INTO `t_news` VALUES ('5', '学校第二次党代会', '2019-05-16 14:27:13', '学校将于2019年5月20召开第二次党代会，请各学院遴选两名学生党员代表参会！', 'admin', '学校将于2019年5月20召开第二次党代会，请各学院遴选两名学生党员代表参会！');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typeid` varchar(50) DEFAULT NULL,
  `snum` int(4) DEFAULT '0',
  `runum` int(4) DEFAULT '0',
  `yunum` int(4) DEFAULT '0',
  `zhnum` int(4) DEFAULT '0',
  `username` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('2', '0', '0', '5', '5', '4', '张三', '13455677878');
INSERT INTO `t_notice` VALUES ('3', '1', '0', '2', '0', '0', '李四', '13455677878');
INSERT INTO `t_notice` VALUES ('4', '4', '0', '0', '0', '0', '王五', '12345678909');

-- ----------------------------
-- Table structure for t_sonnotice
-- ----------------------------
DROP TABLE IF EXISTS `t_sonnotice`;
CREATE TABLE `t_sonnotice` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `typeid` varchar(50) DEFAULT NULL,
  `typename` varchar(50) DEFAULT NULL,
  `rusun` int(4) DEFAULT '0',
  `yusun` int(4) DEFAULT '0',
  `dangsun` int(4) DEFAULT '0',
  `ssun` int(4) DEFAULT '0',
  `username` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_sonnotice
-- ----------------------------
INSERT INTO `t_sonnotice` VALUES ('1', '0', '第一支部', '3', '4', '4', '0', '张三', '13455677878', '13900000000', 'xiaoming@163.com');

-- ----------------------------
-- Table structure for t_studentru
-- ----------------------------
DROP TABLE IF EXISTS `t_studentru`;
CREATE TABLE `t_studentru` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `typeid` varchar(50) DEFAULT NULL,
  `typename` varchar(50) DEFAULT NULL,
  `newtid` varchar(50) DEFAULT '0',
  `newtname` varchar(50) DEFAULT NULL,
  `rollstatus` int(4) DEFAULT '0',
  `username` varchar(50) DEFAULT NULL,
  `classname` varchar(50) DEFAULT NULL,
  `nation` varchar(50) DEFAULT NULL,
  `place` varchar(50) DEFAULT NULL,
  `barthday` varchar(50) DEFAULT NULL,
  `fenzhi` varchar(50) DEFAULT NULL,
  `rudate` varchar(50) DEFAULT NULL,
  `fenzhidate` varchar(50) DEFAULT NULL,
  `istrain` varchar(50) DEFAULT NULL,
  `sixiang` varchar(150) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `idcard` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_studentru
-- ----------------------------
INSERT INTO `t_studentru` VALUES ('2', '0', '第二支部', null, null, null, '李明', '15财务管理', '苗族', '皖', '2000-02-24', '是', '2019-02-24', '2019-02-24', '是', '优秀', '男', '340825199710121452');
INSERT INTO `t_studentru` VALUES ('7', '0', '第一支部', null, null, null, 'Tracy', '15财务管理', '汉族', '安徽安庆', '1997-09-08', '是', '2019-04-01', '2019-04-17', '是', '是', '男', '340821199709081245');
INSERT INTO `t_studentru` VALUES ('8', '0', '第一支部', null, null, null, 'Jim', '15财务管理', '汉族', '安徽安庆', '1997-09-08', '是', '2018-05-21', '2019-06-27', '是', '是', '男', '340825199709081874');
INSERT INTO `t_studentru` VALUES ('9', '0', '第一支部', '1', '第一支部', '0', '李旺', '15财务管理', '汉族', '安徽安庆', '1996-07-31', '是', '2016-04-12', '2017-04-03', '是', '是', '男', '340823199607011234');
INSERT INTO `t_studentru` VALUES ('10', '1', '第一支部', null, null, null, '刘明', '15财务管理', '汉族', '安徽安庆', '1995-04-06', '是', '2015-04-08', '2015-05-14', '是', '是', '男', '340825199504061785');
INSERT INTO `t_studentru` VALUES ('11', '1', '第二支部', null, null, null, '柳文', '15汉语言文学', '汉族', '安徽安庆', '1996-04-10', '是', '2017-04-16', '2017-04-20', '是', '是', '男', '340825199604101785');
INSERT INTO `t_studentru` VALUES ('12', '1', '第二支部', null, null, null, '张伟', '15汉语言文学', '汉族', '安徽安庆', '1997-04-08', '是', '2017-04-17', '2017-04-18', '是', '是', '男', '340825199704081785');

-- ----------------------------
-- Table structure for t_studentyu
-- ----------------------------
DROP TABLE IF EXISTS `t_studentyu`;
CREATE TABLE `t_studentyu` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `typeid` varchar(50) DEFAULT NULL,
  `typename` varchar(50) DEFAULT NULL,
  `newtid` varchar(50) DEFAULT NULL,
  `newtname` varchar(50) DEFAULT NULL,
  `rollstatus` int(4) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `classname` varchar(50) DEFAULT NULL,
  `nation` varchar(50) DEFAULT NULL,
  `place` varchar(50) DEFAULT NULL,
  `barthday` varchar(50) DEFAULT NULL,
  `fenzhi` varchar(50) DEFAULT NULL,
  `fadate` varchar(50) DEFAULT NULL,
  `jiedate` varchar(50) DEFAULT NULL,
  `jieuser` varchar(50) DEFAULT NULL,
  `sixiang` varchar(150) DEFAULT NULL,
  `idcard` varchar(20) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `jueyi` varchar(150) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `applyer` varchar(50) DEFAULT NULL,
  `rudate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_studentyu
-- ----------------------------
INSERT INTO `t_studentyu` VALUES ('1', '0', '第二支部', '1', '第二支部', null, '小李', '15金融工程', '汉族', '吉林', '1980-08-12', '2012-07-10', '2013-07-10', '2013-08-22', '张毅', '20', '340825198008121145', '男', '提交信息', '已同意', 'admin', '2012-02-08');
INSERT INTO `t_studentyu` VALUES ('2', '0', '第一支部', null, null, null, '李四', '15国际经济与贸易', '汉族', '安徽安庆', '1998-01-09', '2017-04-10', '2018-04-17', '2019-04-25', '张三', '是', '340825199801091248', '男', '同意', '已同意', 'admin', '2017-04-01');
INSERT INTO `t_studentyu` VALUES ('4', '0', '第一支部', null, null, null, 'zhangsan', '15财务管理', '汉族', '安徽安庆', '2007-09-18', '2019-04-20', '2019-04-27', '2019-05-20', '张三', '是', '340825199710103254', '男', '同意', '已同意', 'admin', '2019-04-26');
INSERT INTO `t_studentyu` VALUES ('5', '0', '第一支部', null, null, null, 'aaaaaaaa', '15财务管理', '汉族', '安徽安庆', '1997-12-23', '2017-04-20', '2018-04-21', '2019-05-20', '张三', '是', '340825199712231785', '男', '同意', '已同意', 'admin', '2017-04-10');
INSERT INTO `t_studentyu` VALUES ('7', '0', '第一支部', null, null, null, 'zhangsan', '15财务管理', '汉族', '安徽安庆', '1997-09-08', '2018-04-26', '2019-05-02', '2019-05-20', '张三', '是', '340821199709081245', '男', '同意', '已同意', 'admin', '2018-04-10');
INSERT INTO `t_studentyu` VALUES ('8', '0', '第一支部', null, null, null, 'Trisirt', '15财务管理', '汉族', '安徽安庆', '1997-09-08', '2018-04-20', '2019-04-20', '2019-04-26', '张三', '是', '340821199709089871', '男', '不予发展', '不同意', 'admin', '2017-01-08');

-- ----------------------------
-- Table structure for t_studentzh
-- ----------------------------
DROP TABLE IF EXISTS `t_studentzh`;
CREATE TABLE `t_studentzh` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `typeid` varchar(50) DEFAULT NULL,
  `typename` varchar(50) DEFAULT NULL,
  `newtid` varchar(50) DEFAULT NULL,
  `newtname` varchar(50) DEFAULT NULL,
  `rollstatus` int(4) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `classname` varchar(50) DEFAULT NULL,
  `nation` varchar(50) DEFAULT NULL,
  `place` varchar(50) DEFAULT NULL,
  `barthday` varchar(50) DEFAULT NULL,
  `fenzhi` varchar(50) DEFAULT NULL,
  `fadate` varchar(50) DEFAULT NULL,
  `jiedate` varchar(50) DEFAULT NULL,
  `zhuandate` varchar(50) DEFAULT NULL,
  `jieuser` varchar(50) DEFAULT NULL,
  `sixiang` varchar(150) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `jueyi` varchar(150) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `applyer` varchar(50) DEFAULT NULL,
  `rudate` varchar(50) DEFAULT NULL,
  `idcard` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_studentzh
-- ----------------------------
INSERT INTO `t_studentzh` VALUES ('1', '0', '第一支部', null, null, null, '张庚', '一班', '汉族', '吉林', '1992-10-15', '2013-08-14', '2014-12-09', '2015-12-25', '2019-05-07', '张毅', '是', '男', '提交信息', '不同意', null, '2012-08-12', '340825199210151785');
INSERT INTO `t_studentzh` VALUES ('2', '0', '第一支部', null, null, null, 'zhangsan', '15财管', '汉族', '安徽安庆', '1996-04-02', '2017-10-19', '2018-10-19', '2019-04-09', '2019-04-29', '张三', '是', '男', '同意', '已同意', null, '2017-10-03', '340825199604021785');
INSERT INTO `t_studentzh` VALUES ('4', '0', '第一支部', null, null, null, 'lisi ', '15财管', '汉族', '安徽安庆', '1996-04-01', '2018-09-21', '2019-11-20', '2019-12-25', '2019-12-27', '张三', '是', '男', '同意', '已同意', null, '2017-01-21', '340825199604011785');
INSERT INTO `t_studentzh` VALUES ('6', '0', '第一支部', null, null, null, '李丽', '15财务管理', '汉族', '安徽安庆', '1997-02-04', '2017-04-12', '2018-04-24', '2018-04-30', '2019-04-29', '张三', '是', '男', '同意', '已同意', null, '2017-04-11', '34082119970204168X');
INSERT INTO `t_studentzh` VALUES ('7', '0', '第一支部', null, null, null, '王阳', '15财务管理', '汉族', '安徽安庆', '1996-04-11', '2017-04-13', '2018-04-18', '2019-04-23', '2019-05-16', '张三', '是', '男', '同意', '已同意', null, '2017-04-05', '340825199604111785');
INSERT INTO `t_studentzh` VALUES ('8', '0', '第四支部', '', '', null, '刘小米', '15财务管理', '汉族', '安徽安庆', '1995-04-12', '2017-04-06', '2018-04-09', '2019-04-15', '2019-05-23', '张三', '是', '男', '同意', '已同意', null, '2017-04-04', '340825199504129578');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) DEFAULT NULL COMMENT '登录名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `realname` varchar(50) DEFAULT NULL COMMENT '姓名',
  `usertype` int(4) DEFAULT NULL COMMENT '角色 0：管理员1：销售员',
  `usernum` varchar(50) DEFAULT NULL COMMENT '编号',
  `atrr` varchar(100) DEFAULT NULL COMMENT '地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `card` varchar(50) DEFAULT NULL COMMENT '身份证',
  `typeid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '小红', '0', null, '中国', '13900000000', '210000000000000000', '100');
INSERT INTO `t_user` VALUES ('4', 'zhangsan', 'E10ADC3949BA59ABBE56E057F20F883E', '张三', '1', '20120331211915', '中国', '13455677878', '21000000000000000', '0');
INSERT INTO `t_user` VALUES ('8', 'lisi', 'E10ADC3949BA59ABBE56E057F20F883E', '李四', '1', '20130328121722', '中国', '13900000000', '210000000000000000', '1');

-- ----------------------------
-- Table structure for t_zuzhi
-- ----------------------------
DROP TABLE IF EXISTS `t_zuzhi`;
CREATE TABLE `t_zuzhi` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `typeid` varchar(50) DEFAULT NULL,
  `typename` varchar(50) DEFAULT NULL,
  `place` varchar(50) DEFAULT NULL,
  `huodate` varchar(50) DEFAULT NULL,
  `csum` varchar(50) DEFAULT NULL,
  `huouser` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `xiangqing` varchar(500) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `applyer` varchar(50) DEFAULT NULL,
  `huoname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_zuzhi
-- ----------------------------
INSERT INTO `t_zuzhi` VALUES ('1', '0', '第一支部', '吉林', '2012-03-05', '100', '王明', '13800000000', '植树', '已同意', 'admin', '植树活动');
INSERT INTO `t_zuzhi` VALUES ('4', '0', '第一支部', '安徽安庆', '2019-04-08', '13', '李四', '13455677878', '大扫除', '已同意', 'admin', '大扫除活动');
INSERT INTO `t_zuzhi` VALUES ('5', '1', '第二支部', '安徽安庆', '2017-04-12', '13', '李四', '13455677878', '敬老院看望老人，陪老人聊天', '待批准', null, '敬老院看望老人');
