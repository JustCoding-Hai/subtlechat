/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : subtlechat

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-11-08 16:12:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '登录账号',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `user_profile` varchar(255) DEFAULT NULL COMMENT '管理员头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '系统管理员', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1784117537,3335593911&fm=26&gp=0.jpg');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('055b47a8-b29d-4a38-98dd-16e34e09bc5f', '1', 'huang', '王路飞', '!good job!!!');
INSERT INTO `feedback` VALUES ('1a46c7a4-5b29-4409-ae1f-ecab8996e254', '1', 'huang', '王路飞', '!!!!good job!!!!wow');
INSERT INTO `feedback` VALUES ('1fb83166-e4d0-49b2-bb9e-a2849e8ff4bc', '1', 'huang', '王路飞', 'good job');
INSERT INTO `feedback` VALUES ('3d73af3e-dc4d-44c8-84cc-787d001482c5', '1', 'huang', '王路飞', '!!!!good job!!!');
INSERT INTO `feedback` VALUES ('509dd4d6-2672-40f9-840c-d93f5d577dc5', '1', 'huang', '王路飞', '!!!!good job!!!!wow');
INSERT INTO `feedback` VALUES ('6d403812-7759-4c07-9616-c9ed900a8bdf', '1', 'huang', '王路飞', '!!!!good job!!!!wow');
INSERT INTO `feedback` VALUES ('980ade45-98c8-4baa-8bcb-c2bc99187608', '1', 'huang', '王路飞', 'woooww！！！man,this is great!');
INSERT INTO `feedback` VALUES ('9a2bd6d5-b42e-4381-ad1b-dc170778c9b5', '1', 'huang', '王路飞', '!good job!!!');
INSERT INTO `feedback` VALUES ('b4e6f36e-a42a-4edf-a7ec-d6748ea9c418', '1', 'huang', '王路飞', '!good job!');
INSERT INTO `feedback` VALUES ('b61c873c-3d3e-4991-b9e6-78eeae23c205', '1', 'huang', '王路飞', '!!!!good job!!!!wow');
INSERT INTO `feedback` VALUES ('c2121704-e610-4fd7-9e11-fa4057df9b3b', '1', 'huang', '王路飞', '!good job!!!');
INSERT INTO `feedback` VALUES ('d009a2a6-c7a3-4b29-b32b-848fca278c45', '1', 'huang', '王路飞', '!!!!good job!!!!wow');
INSERT INTO `feedback` VALUES ('d1741d1e-8151-44eb-ba32-c83cfe107361', '1', 'huang', '王路飞', '!good job!!');
INSERT INTO `feedback` VALUES ('ed70f54e-7748-4d36-adc8-c9131875e6f5', '1', 'huang', '王路飞', '!good job!!!');

-- ----------------------------
-- Table structure for group_msg_content
-- ----------------------------
DROP TABLE IF EXISTS `group_msg_content`;
CREATE TABLE `group_msg_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息内容编号',
  `from_id` int(11) DEFAULT NULL COMMENT '发送者的编号',
  `from_name` varchar(20) DEFAULT NULL COMMENT '发送者的昵称',
  `from_profile` varchar(255) DEFAULT NULL COMMENT '发送者的头像',
  `create_time` datetime DEFAULT NULL COMMENT '消息发送时间',
  `content` text COMMENT '消息内容',
  `message_type_id` int(11) DEFAULT NULL COMMENT '消息类型编号',
  PRIMARY KEY (`id`),
  KEY `group_ibfk_1` (`from_id`),
  KEY `group_ibfk_2` (`message_type_id`),
  CONSTRAINT `group_ibfk_1` FOREIGN KEY (`from_id`) REFERENCES `user` (`id`),
  CONSTRAINT `group_ibfk_2` FOREIGN KEY (`message_type_id`) REFERENCES `message_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_msg_content
-- ----------------------------
INSERT INTO `group_msg_content` VALUES ('1', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 03:02:28', '大家好', '1');
INSERT INTO `group_msg_content` VALUES ('2', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 03:04:24', '大家好！', '1');
INSERT INTO `group_msg_content` VALUES ('3', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 04:51:56', 'hello', '1');
INSERT INTO `group_msg_content` VALUES ('4', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 12:55:32', '88', '1');
INSERT INTO `group_msg_content` VALUES ('6', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 13:28:44', '321', '1');
INSERT INTO `group_msg_content` VALUES ('14', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 22:05:00', '三刀流', '1');
INSERT INTO `group_msg_content` VALUES ('15', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-17 22:17:10', '其他人呢？', '1');
INSERT INTO `group_msg_content` VALUES ('16', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 22:46:09', '不知道', '1');
INSERT INTO `group_msg_content` VALUES ('17', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-17 22:47:35', '???', '1');
INSERT INTO `group_msg_content` VALUES ('18', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 22:47:59', '？', '1');
INSERT INTO `group_msg_content` VALUES ('19', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 23:02:46', '111', '1');
INSERT INTO `group_msg_content` VALUES ('20', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-17 23:03:20', '111', '1');
INSERT INTO `group_msg_content` VALUES ('21', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-17 23:03:33', '111', '1');
INSERT INTO `group_msg_content` VALUES ('22', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-17 23:07:52', '2', '1');
INSERT INTO `group_msg_content` VALUES ('23', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 23:08:36', '33', '1');
INSERT INTO `group_msg_content` VALUES ('24', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 23:14:51', '111', '1');
INSERT INTO `group_msg_content` VALUES ('25', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 23:18:18', 'awsl', '1');
INSERT INTO `group_msg_content` VALUES ('26', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 23:36:23', 'wa', '1');
INSERT INTO `group_msg_content` VALUES ('27', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-17 23:37:04', 'waaaa\n', '1');
INSERT INTO `group_msg_content` VALUES ('28', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-17 23:37:20', 'lallala', '1');
INSERT INTO `group_msg_content` VALUES ('29', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-17 23:37:29', '666', '1');
INSERT INTO `group_msg_content` VALUES ('30', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-18 14:29:52', '55555', '1');
INSERT INTO `group_msg_content` VALUES ('31', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-18 14:30:10', '444444', '1');
INSERT INTO `group_msg_content` VALUES ('32', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-18 14:30:23', '22222', '1');
INSERT INTO `group_msg_content` VALUES ('33', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-18 14:36:53', '666', '1');
INSERT INTO `group_msg_content` VALUES ('34', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-18 14:37:01', '啦啦啦啦', '1');
INSERT INTO `group_msg_content` VALUES ('35', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-18 14:37:30', 'eee', '1');
INSERT INTO `group_msg_content` VALUES ('36', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-18 14:47:31', '啊啊啊', '1');
INSERT INTO `group_msg_content` VALUES ('37', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-18 16:21:07', '拉拉', '1');
INSERT INTO `group_msg_content` VALUES ('38', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-18 16:22:13', '啦啦啦啦', '1');
INSERT INTO `group_msg_content` VALUES ('39', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-18 16:52:52', 'aaaaa', '1');
INSERT INTO `group_msg_content` VALUES ('40', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-19 10:55:49', '6.19', '1');
INSERT INTO `group_msg_content` VALUES ('41', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-19 10:56:29', '6.18', '1');
INSERT INTO `group_msg_content` VALUES ('42', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-19 11:00:40', '6.17', '1');
INSERT INTO `group_msg_content` VALUES ('43', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-19 11:01:11', '6.16', '1');
INSERT INTO `group_msg_content` VALUES ('44', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-19 17:46:49', '我要砍死你', '1');
INSERT INTO `group_msg_content` VALUES ('45', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-19 17:47:12', '瓦力瓦力', '1');
INSERT INTO `group_msg_content` VALUES ('46', '6', 'aaa', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7vNk6AI5ncAAZrF3kx8E4062.jpg', '2020-06-21 21:57:51', '666', '1');
INSERT INTO `group_msg_content` VALUES ('47', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-21 22:00:33', '!!!', '1');
INSERT INTO `group_msg_content` VALUES ('48', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-21 22:03:12', '!!!!!!!!!!!!!', '1');
INSERT INTO `group_msg_content` VALUES ('49', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-21 22:55:36', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7vdOmARAv9AAZhj13MNZc018.jpg', '2');
INSERT INTO `group_msg_content` VALUES ('51', '6', 'aaa', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7vNk6AI5ncAAZrF3kx8E4062.jpg', '2020-06-22 10:43:06', 'ssss', '1');
INSERT INTO `group_msg_content` VALUES ('52', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-22 10:44:50', '123', '1');
INSERT INTO `group_msg_content` VALUES ('53', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-22 10:47:50', '我胡汉三又回来了', '1');
INSERT INTO `group_msg_content` VALUES ('54', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-06-22 10:48:40', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wHAmAIRtPAA4Q9d1YCi8462.jpg', '2');
INSERT INTO `group_msg_content` VALUES ('55', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-22 10:50:50', '88', '1');
INSERT INTO `group_msg_content` VALUES ('56', '7', '罗', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wHOaAVoqUAAEnxFEdf9A80.jpeg', '2020-06-22 10:53:05', '...', '1');
INSERT INTO `group_msg_content` VALUES ('57', '10', '乔巴', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wPomAWB44AACPzYoUMyE376.jpg', '2020-06-22 13:18:16', 'lalalal', '1');
INSERT INTO `group_msg_content` VALUES ('58', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-25 00:25:37', '&#129315;', '1');
INSERT INTO `group_msg_content` VALUES ('59', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-25 00:25:52', 'nihao', '1');
INSERT INTO `group_msg_content` VALUES ('60', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-25 00:26:01', '大家好', '1');
INSERT INTO `group_msg_content` VALUES ('61', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-25 11:28:41', '&#128535;太好了！&#129310;', '1');
INSERT INTO `group_msg_content` VALUES ('62', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-25 11:43:34', '&#9784;️', '1');
INSERT INTO `group_msg_content` VALUES ('63', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-25 11:43:54', '&#128585;&#128585;&#128585;&#128139;&#128140;&#128152;', '1');
INSERT INTO `group_msg_content` VALUES ('64', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-06-25 11:48:31', '&#128169;', '1');
INSERT INTO `group_msg_content` VALUES ('68', '7', '罗', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wHOaAVoqUAAEnxFEdf9A80.jpeg', '2020-07-01 12:30:52', '&#128544;滚', '1');
INSERT INTO `group_msg_content` VALUES ('69', '7', '罗', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wHOaAVoqUAAEnxFEdf9A80.jpeg', '2020-07-01 12:31:41', 'http://39.108.169.57/group1/M00/00/00/J2ypOV78Ea6AWq5hAAPr-MGWs8o676.jpg', '2');
INSERT INTO `group_msg_content` VALUES ('70', '7', '罗', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wHOaAVoqUAAEnxFEdf9A80.jpeg', '2020-07-01 14:58:05', '有人吗？\n', '1');
INSERT INTO `group_msg_content` VALUES ('71', '7', '罗', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wHOaAVoqUAAEnxFEdf9A80.jpeg', '2020-07-01 15:19:09', 'http://39.108.169.57/group1/M00/00/00/J2ypOV78OO-AUwQdAA4Q9d1YCi8766.jpg', '2');
INSERT INTO `group_msg_content` VALUES ('72', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-07-01 15:20:28', '222', '1');
INSERT INTO `group_msg_content` VALUES ('74', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-07-01 15:32:15', 'http://39.108.169.57/group1/M00/00/00/J2ypOV78PAGAY-yKAA14IFomF20918.gif', '2');
INSERT INTO `group_msg_content` VALUES ('75', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-07-01 15:32:35', 'http://39.108.169.57/group1/M00/00/00/J2ypOV78PBSAJK0CAAeXVP-WpTQ029.gif', '2');
INSERT INTO `group_msg_content` VALUES ('79', '17', 'lol', 'http://39.108.169.57/group1/M00/00/00/J2ypOV78RRGATCo6AA4Q9d1YCi8203.jpg', '2020-07-01 16:11:30', '?', '1');
INSERT INTO `group_msg_content` VALUES ('80', '18', 'abc', 'http://39.108.169.57/group1/M00/00/00/J2ypOV78qMyAeQV2AA4eYWQZmQA183.jpg', '2020-07-01 23:16:57', '大家好', '1');
INSERT INTO `group_msg_content` VALUES ('81', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-07-01 23:17:21', '你好&#128578;哈', '1');
INSERT INTO `group_msg_content` VALUES ('83', '20', 'qwe', 'http://39.108.169.57/group1/M00/00/00/J2ypOV79ZYaAcPRzAAEnxFEdf9A79.jpeg', '2020-07-02 12:42:05', '大家好啊', '1');
INSERT INTO `group_msg_content` VALUES ('84', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-07-02 12:42:30', '你好啊&#128556;', '1');
INSERT INTO `group_msg_content` VALUES ('85', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-07-02 12:42:46', '欢迎\n', '1');
INSERT INTO `group_msg_content` VALUES ('87', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-07-02 19:43:54', '有人吗？', '1');
INSERT INTO `group_msg_content` VALUES ('88', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-07-07 21:48:20', '??', '1');
INSERT INTO `group_msg_content` VALUES ('89', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-07-07 21:48:35', '&#128590;', '1');
INSERT INTO `group_msg_content` VALUES ('90', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-07-07 21:48:48', 'http://39.108.169.57/group1/M00/00/00/J2ypOV8EfUGAOAkwAABXIkocmK4137.gif', '2');
INSERT INTO `group_msg_content` VALUES ('91', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-10-01 13:07:38', '123\n', '1');
INSERT INTO `group_msg_content` VALUES ('92', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-10-01 13:10:24', '&#128558;', '1');
INSERT INTO `group_msg_content` VALUES ('93', '2', '刘索隆', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2020-10-01 13:10:46', 'http://39.108.169.57/group1/M00/00/00/J2ypOV91ZNWAH5_UAAAr1YNW1TU52.jpeg', '2');
INSERT INTO `group_msg_content` VALUES ('94', '22', 'lin', 'http://39.108.169.57/group1/M00/00/00/J2ypOV91Z_uADljOAAANuXp4Wt8245.jpg', '2020-10-01 13:24:46', 'wow\n', '1');
INSERT INTO `group_msg_content` VALUES ('95', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-10-01 18:09:24', '&#128530;', '1');
INSERT INTO `group_msg_content` VALUES ('96', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-10-01 18:09:31', 'http://39.108.169.57/group1/M00/00/00/J2ypOV91qtuAdB0EAAARihKoLCw540.jpg', '2');
INSERT INTO `group_msg_content` VALUES ('97', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-10-01 18:29:19', '&#129316;', '1');
INSERT INTO `group_msg_content` VALUES ('98', '1', '王路飞', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2020-10-01 18:29:34', 'http://39.108.169.57/group1/M00/00/00/J2ypOV91r42AbuiYAAARihKoLCw482.jpg', '2');

-- ----------------------------
-- Table structure for mail_send_log
-- ----------------------------
DROP TABLE IF EXISTS `mail_send_log`;
CREATE TABLE `mail_send_log` (
  `msg_id` varchar(255) NOT NULL,
  `content_type` tinyint(2) DEFAULT NULL COMMENT '0:反馈，1:验证码',
  `content` varchar(255) DEFAULT NULL,
  `mail_address` varchar(64) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL COMMENT '0-投递中，1-成功，2-失败',
  `route_key` varchar(128) DEFAULT NULL,
  `exchange` varchar(128) DEFAULT NULL,
  `count` tinyint(2) DEFAULT NULL,
  `try_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mail_send_log
-- ----------------------------
INSERT INTO `mail_send_log` VALUES ('03b8ee38-ab30-45d3-87d9-5b344411ae0c', '1', '{\"content\":\"!good job!!!\",\"id\":\"9a2bd6d5-b42e-4381-ad1b-dc170778c9b5\",\"nickname\":\"王路飞\",\"userId\":\"1\",\"username\":\"huang\"}', null, '1', 'mail-route-feedback', 'mail-exchange', '2', '2020-10-02 22:42:22', '2020-10-02 22:42:16', '2020-10-02 22:42:30');
INSERT INTO `mail_send_log` VALUES ('040da7c8-2195-49a4-91a9-4c6244320df6', '2', '2106', null, '1', 'mail-route-verifyCode', 'mail-exchange', '2', '2020-10-03 00:03:37', '2020-10-03 00:03:27', '2020-10-03 00:03:40');
INSERT INTO `mail_send_log` VALUES ('061dab12-079f-46f1-aa47-dce5f9e37d6f', '2', '8056', null, '1', 'mail-route-verifyCode', 'mail-exchange', '1', '2020-10-03 12:51:17', '2020-10-03 12:51:07', '2020-10-03 12:51:07');
INSERT INTO `mail_send_log` VALUES ('06e15d8f-8434-45bf-9b6e-5330a68f0026', '2', '9765', null, '1', 'mail-route-verifyCode', 'mail-exchange', '1', '2020-10-03 13:11:52', '2020-10-03 13:11:42', '2020-10-03 13:11:42');
INSERT INTO `mail_send_log` VALUES ('1a882fa4-9fee-4229-a443-b05e6f6666b6', '1', '{\"content\":\"!!!!good job!!!\",\"id\":\"3d73af3e-dc4d-44c8-84cc-787d001482c5\",\"nickname\":\"王路飞\",\"userId\":\"1\",\"username\":\"huang\"}', null, '2', 'mail-route-feedback', 'mail-exchange', '4', '2020-10-02 22:43:54', '2020-10-02 22:43:48', '2020-10-02 22:44:20');
INSERT INTO `mail_send_log` VALUES ('1f1bfa9c-2166-4500-b9ad-1a67f384855e', '1', '{\"content\":\"!!!!good job!!!!wow\",\"id\":\"509dd4d6-2672-40f9-840c-d93f5d577dc5\",\"nickname\":\"王路飞\",\"userId\":\"1\",\"username\":\"huang\"}', null, '1', 'mail-route-feedback', 'mail-exchange', '1', '2020-10-03 13:08:59', '2020-10-03 13:07:59', '2020-10-03 13:07:59');
INSERT INTO `mail_send_log` VALUES ('209d58d4-287b-49c4-b91f-cfb3a821f765', '1', '{\"content\":\"!!!!good job!!!!wow\",\"id\":\"6d403812-7759-4c07-9616-c9ed900a8bdf\",\"nickname\":\"王路飞\",\"userId\":\"1\",\"username\":\"huang\"}', null, '1', 'mail-route-feedback', 'mail-exchange', '2', '2020-10-03 00:22:37', '2020-10-03 00:21:37', '2020-10-03 00:22:40');
INSERT INTO `mail_send_log` VALUES ('27d6c889-97ce-4cd0-a923-59b0e90ce86f', '1', '{\"content\":\"!good job!!!\",\"id\":\"ed70f54e-7748-4d36-adc8-c9131875e6f5\",\"nickname\":\"王路飞\",\"userId\":\"1\",\"username\":\"huang\"}', null, '1', 'mail-route-feedback', 'mail-exchange', '1', '2020-10-02 22:37:55', '2020-10-02 22:37:49', '2020-10-02 22:37:49');
INSERT INTO `mail_send_log` VALUES ('69894861-0b20-46ed-845b-144c5a44e525', '2', '6633', null, '1', 'mail-route-verifyCode', 'mail-exchange', '1', '2020-10-03 13:05:53', '2020-10-03 13:05:43', '2020-10-03 13:05:43');
INSERT INTO `mail_send_log` VALUES ('72a77382-7f6a-4e49-b6c7-e9c7b849c957', '2', '5041', null, '1', 'mail-route-verifyCode', 'mail-exchange', '1', '2020-10-03 13:04:19', '2020-10-03 13:04:09', '2020-10-03 13:04:09');
INSERT INTO `mail_send_log` VALUES ('77e48304-8b35-4ff8-b492-72265a0f0325', '2', '0991', null, '1', 'mail-route-verifyCode', 'mail-exchange', '2', '2020-10-03 00:15:08', '2020-10-03 00:14:58', '2020-10-03 00:15:10');
INSERT INTO `mail_send_log` VALUES ('8359eb87-1026-402f-a7a5-04273bd44870', '2', '4577', null, '1', 'mail-route-verifyCode', 'mail-exchange', '2', '2020-10-03 00:05:01', '2020-10-03 00:04:51', '2020-10-03 00:05:10');
INSERT INTO `mail_send_log` VALUES ('999bfa86-d8b7-459a-898e-d3f3dbe07892', '1', '{\"content\":\"!!!!good job!!!!wow\",\"id\":\"b61c873c-3d3e-4991-b9e6-78eeae23c205\",\"nickname\":\"王路飞\",\"userId\":\"1\",\"username\":\"huang\"}', null, '1', 'mail-route-feedback', 'mail-exchange', '2', '2020-10-02 22:59:01', '2020-10-02 22:58:55', '2020-10-02 22:59:10');
INSERT INTO `mail_send_log` VALUES ('a4f5cba5-28e8-4de8-a2ed-117cf9a0f89a', '1', '{\"content\":\"woooww！！！man,this is great!\",\"id\":\"980ade45-98c8-4baa-8bcb-c2bc99187608\",\"nickname\":\"王路飞\",\"userId\":\"1\",\"username\":\"huang\"}', null, '1', 'mail-route-feedback', 'mail-exchange', '2', '2020-10-03 00:13:25', '2020-10-03 00:12:25', '2020-10-03 00:13:30');
INSERT INTO `mail_send_log` VALUES ('b9a02d0c-8df0-4b02-a90d-96ee8b19dcf6', '1', '{\"content\":\"!!!!good job!!!!wow\",\"id\":\"1a46c7a4-5b29-4409-ae1f-ecab8996e254\",\"nickname\":\"王路飞\",\"userId\":\"1\",\"username\":\"huang\"}', null, '1', 'mail-route-feedback', 'mail-exchange', '1', '2020-10-03 12:54:32', '2020-10-03 12:53:32', '2020-10-03 12:53:32');
INSERT INTO `mail_send_log` VALUES ('bb4c1cc9-ea22-44f3-b850-c39072235334', '1', '{\"content\":\"!good job!!!\",\"id\":\"055b47a8-b29d-4a38-98dd-16e34e09bc5f\",\"nickname\":\"王路飞\",\"userId\":\"1\",\"username\":\"huang\"}', null, '2', 'mail-route-feedback', 'mail-exchange', '4', '2020-10-02 22:36:05', '2020-10-02 22:35:59', '2020-10-02 22:36:30');
INSERT INTO `mail_send_log` VALUES ('c5a91cee-5b36-43a7-9c9f-dbca189d69e1', '2', '2853', null, '1', 'mail-route-verifyCode', 'mail-exchange', '1', '2020-10-03 12:57:46', '2020-10-03 12:57:36', '2020-10-03 12:57:36');
INSERT INTO `mail_send_log` VALUES ('d4085092-3a02-400c-a99a-6473bb213241', '2', '1952', null, '1', 'mail-route-verifyCode', 'mail-exchange', '2', '2020-10-02 23:58:14', '2020-10-02 23:58:04', '2020-10-02 23:58:20');
INSERT INTO `mail_send_log` VALUES ('d4d8aa1b-a9a9-41e9-ac87-872ec6b105db', '2', '0596', null, '1', 'mail-route-verifyCode', 'mail-exchange', '1', '2020-10-03 13:13:12', '2020-10-03 13:13:02', '2020-10-03 13:13:02');
INSERT INTO `mail_send_log` VALUES ('ec878a67-08ba-4fea-b44f-dab5c80eedc1', '1', '{\"content\":\"!!!!good job!!!!wow\",\"id\":\"d009a2a6-c7a3-4b29-b32b-848fca278c45\",\"nickname\":\"王路飞\",\"userId\":\"1\",\"username\":\"huang\"}', null, '1', 'mail-route-feedback', 'mail-exchange', '2', '2020-10-02 22:56:45', '2020-10-02 22:56:39', '2020-10-02 22:56:50');

-- ----------------------------
-- Table structure for message_type
-- ----------------------------
DROP TABLE IF EXISTS `message_type`;
CREATE TABLE `message_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息类型编号',
  `name` varchar(20) DEFAULT NULL COMMENT '消息类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_type
-- ----------------------------
INSERT INTO `message_type` VALUES ('1', '文本');
INSERT INTO `message_type` VALUES ('2', '图片');
INSERT INTO `message_type` VALUES ('3', '文件');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '登录账号',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `user_profile` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `user_state_id` int(11) DEFAULT '2' COMMENT '用户状态id',
  `is_enabled` tinyint(1) DEFAULT '1' COMMENT '是否可用',
  `is_locked` tinyint(1) DEFAULT '0' COMMENT '是否被锁定',
  PRIMARY KEY (`id`),
  KEY `user_ibfk_1` (`user_state_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`user_state_id`) REFERENCES `user_state` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'huang', '王路飞', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1405813947,3985685597&fm=26&gp=0.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('2', 'suolong', '刘索隆', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1449253785,508542562&fm=26&gp=0.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('3', 'hongfa', '面子王', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=170596679,2573810813&fm=26&gp=0.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('4', '22', '23', '$2a$10$hvoriOXwQYpn2m/UWK.bR.LdGQNkwzts0dWcMz0LwuSgcY3fkFTZK', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7vNk6AI5ncAAZrF3kx8E4062.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('5', 'luojie', '罗杰', '$2a$10$oE39aG10kB/rFu2vQeCJTu/V/v4n6DRR0f8WyXRiAYvBpmadoOBE.', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7vNk6AI5ncAAZrF3kx8E4062.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('6', 'aaa', 'aaa', '$2a$10$bLgMwYJLbsBTcFVxXhuu3e9CyCCN.e61f1eB6zGp0pELIyT4c340e', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7vNk6AI5ncAAZrF3kx8E4062.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('7', 'luo', '罗', '$2a$10$Jp7.h24JQvLL3/OinvaU7uqUhYxa3m4oZO8PFuASE/wJMame8G5de', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wHOaAVoqUAAEnxFEdf9A80.jpeg', '2', '1', '0');
INSERT INTO `user` VALUES ('8', 'nami', '娜美', '$2a$10$otFiIxguKGRhgJL..tlJeepm/HVwnnXWmzjL22t0QFVVm5vt1uI5C', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wMJyAOreGAAA2xgw9uGE356.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('9', 'wusuopu', '乌索普', '$2a$10$LFAydsgrxtV0ZuguQfBePOogHQ904DazLqCsgp7sizz4lORobRYbq', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wMhqABTHdAAD2VGh43MM28.jpeg', '2', '1', '1');
INSERT INTO `user` VALUES ('10', 'qiaoba', '乔巴', '$2a$10$rgUdpi.2mXAhSa/1GR2atO.lXiJXYpp7cp2r1q7Us/y2Pr7p1RNiO', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wPomAWB44AACPzYoUMyE376.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('11', 'luobin', '罗宾', '$2a$10$UfzZSYfd3GrJQO23EomEbeIFKwUdp6HnuTcvLtYV2LbdDQj9KHstK', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wP0-AEZHOAAILbcn5GEM095.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('12', 'fulanqi', '弗兰奇', '$2a$10$3rGgRBJaUAEK2g.1.xVHVuGtKzT2NLqLX2Re9IVwsEbYCv/6vPtRi', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wP3aARozEAAttN5Gqf1U999.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('13', 'buluke', '布鲁克', '$2a$10$b5qMiWVWbB4YyZsxO.XOFuvY5VB4P4FGbwGdCyZVYj7VPUWeQEALW', 'http://39.108.169.57/group1/M00/00/00/J2ypOV7wP8mAa9liAAMm-dSmxOo65.jpeg', '2', '1', '0');
INSERT INTO `user` VALUES ('17', 'lol', 'lol', '$2a$10$LFQ7S8dkTq42Z2bNVaZ8bOxv0jp4d6NBuSLjjPkWfQBbZCBTTqQwi', 'http://39.108.169.57/group1/M00/00/00/J2ypOV78RRGATCo6AA4Q9d1YCi8203.jpg', '1', '1', '0');
INSERT INTO `user` VALUES ('18', 'abc', 'abc', '$2a$10$LlSBK0N9m4Yvyh6giZta7O979HJzubUrscwu3.0WlIhpUO/bo8Cku', 'http://39.108.169.57/group1/M00/00/00/J2ypOV78qMyAeQV2AA4eYWQZmQA183.jpg', '2', '1', '0');
INSERT INTO `user` VALUES ('19', 'uuu', 'uuu', '$2a$10$L4VTh./yerVndATzbf7WeectaYOC0MPNcbaYAevVMmgkBSowDaXay', 'http://39.108.169.57/group1/M00/00/00/J2ypOV78r8-AUw8OAAD2VGh43MM26.jpeg', '1', '1', '0');
INSERT INTO `user` VALUES ('20', 'qwe', 'qwe', '$2a$10$XPvEXzuAeQD14hOGJzJL6uIsLWdDUYa1B4oFU0WUR1yNV2fctYcYS', 'http://39.108.169.57/group1/M00/00/00/J2ypOV79ZYaAcPRzAAEnxFEdf9A79.jpeg', '2', '1', '0');
INSERT INTO `user` VALUES ('21', '老板', 'boss', '$2a$10$R.MqNOALIQSYWlbJdGgAiOXL4nWPbFgrRfvbOnruaEq2R0MVHLNfi', 'http://39.108.169.57/group1/M00/00/00/J2ypOV91ZzuAQ3QIAABuVAcCVPk458.gif', '2', '1', '0');
INSERT INTO `user` VALUES ('22', 'lin', 'lin', '$2a$10$kKbT3vueBUBY9ACgatYfd.6tKVG.j/ObrBIELfv8A/5Cab0CX.1a.', 'http://39.108.169.57/group1/M00/00/00/J2ypOV91Z_uADljOAAANuXp4Wt8245.jpg', '2', '1', '0');

-- ----------------------------
-- Table structure for user_state
-- ----------------------------
DROP TABLE IF EXISTS `user_state`;
CREATE TABLE `user_state` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL COMMENT '状态名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_state
-- ----------------------------
INSERT INTO `user_state` VALUES ('1', '在线');
INSERT INTO `user_state` VALUES ('2', '离线');
INSERT INTO `user_state` VALUES ('3', '已注销');
