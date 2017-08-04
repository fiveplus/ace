/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50715
 Source Host           : localhost
 Source Database       : db_book

 Target Server Version : 50715
 File Encoding         : utf-8

 Date: 01/20/2017 09:41:30 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sys_group_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_group_permission`;
CREATE TABLE `sys_group_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL,
  `permission_id` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `sys_group_permission`
-- ----------------------------
BEGIN;
INSERT INTO `sys_group_permission` VALUES ('1', '1', 'handle'), ('2', '1', 'user'), ('3', '1', 'group');
COMMIT;

-- ----------------------------
--  Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `parent_id` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_menu` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `class_name` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `menu_index` int(11) DEFAULT NULL,
  `image_url` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `url` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `sys_permission`
-- ----------------------------
BEGIN;
INSERT INTO `sys_permission` VALUES ('admin', 'Admin', null, 'N', null, 'Y', '1', null, null, '1440665159555'), ('group', '组管理', 'main', 'Y', '', 'Y', '3', '', 'admin/group/list/1', '1473391211303'), ('handle', '菜单/权限', 'main', 'Y', '', 'Y', '1', '', 'admin/permission/list/1', '1440666423850'), ('main', '后台管理', 'admin', 'Y', 'icon-desktop', 'Y', '1', '', '', '1440664698162'), ('user', '用户管理', 'main', 'Y', '', 'Y', '2', '', 'admin/user/list/1', '1440665159555');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_permission`;
CREATE TABLE `sys_user_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `tbl_advertisement`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_advertisement`;
CREATE TABLE `tbl_advertisement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `url` text CHARACTER SET utf8,
  `remark` text CHARACTER SET utf8,
  `create_time` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `image` text CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `tbl_advertisement`
-- ----------------------------
BEGIN;
INSERT INTO `tbl_advertisement` VALUES ('1', '秋日读书补元气', '#', '', '1474379961228', 'upload_images/20160923095024.jpg'), ('2', '开学季玩转大学专场', '#', '', '1474595790522', 'upload_images/20160923095627.jpg'), ('3', '新书上线棒棒哒', '#', '', '1474595889406', 'upload_images/20160923095744.jpg'), ('4', '抑郁症至于笔记', '#', '', '1474595918393', 'upload_images/20160923095816.jpg'), ('5', '当时说清楚就好了', '#', '', '1474595955375', 'upload_images/20160923095855.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `tbl_book`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book`;
CREATE TABLE `tbl_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `author` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `copy_right` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double(100,0) DEFAULT NULL,
  `public_house` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `public_time` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `info` text COLLATE utf8_unicode_ci,
  `recommend` text COLLATE utf8_unicode_ci,
  `author_info` text COLLATE utf8_unicode_ci,
  `create_time` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `read_count` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `tbl_book`
-- ----------------------------
BEGIN;
INSERT INTO `tbl_book` VALUES ('1', '我们的世界彼此相爱', '自由极光', null, '0', '长江文艺出版社', '100', '1459440000000', '<span style=\"color: rgb(76, 76, 76); font-family: \'helvetica neue\', helvetica, arial, \'hiragino sans gb\', stheiti; font-size: 14px; background-color: rgb(255, 255, 250);\">我爱你的同时，你也深爱着我，这是多么幸运的事情。这个世界，有我们彼此相爱，就足够了。爱，是这个世界上最强大、最动人的东西，没有什么可以与爱抗衡，两人彼此相爱，就会拥有全世界。整个大学期间，夏小雪一直暗恋自己的男神肖亦凡，她为了他默默地付出了四年，直到大学毕业时夏小雪和他意外发生了关系。小雪本打算一切就此结束，却发现自己怀孕了，不得不和肖亦凡正面面对此事。两人因为这个意外，或是天注定或是发现两个人早就彼此相爱了……命运让他们在一起，但要面对的困难又是那么多，彼此相爱的两个人，要如何面对这些困难，才能最终在一起？</span>', null, null, '1474620118837', '0');
COMMIT;

-- ----------------------------
--  Table structure for `tbl_booktype`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_booktype`;
CREATE TABLE `tbl_booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `is_main` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `tbl_booktype`
-- ----------------------------
BEGIN;
INSERT INTO `tbl_booktype` VALUES ('2', '期刊', '1473663031844', null, 'N'), ('3', '外文', '1473663065475', null, 'N'), ('4', '原创女频', '1473663082936', null, 'N'), ('5', '原创男频', '1473663094360', null, 'N'), ('6', '科技', '1473663102580', null, 'N'), ('7', '社会科技', '1473663117366', null, 'N'), ('8', '文学艺术', '1473663126935', null, 'N'), ('9', '亲子少儿', '1473663137855', null, 'N'), ('10', '生活', '1473663144665', null, 'N'), ('11', '两性情感', '1473663156080', null, 'N'), ('12', '计算机', '1473663163086', null, 'N'), ('13', '历史传记', '1473663171908', null, 'N'), ('14', '成功励志', '1473663180413', null, 'N'), ('15', '经济管理', '1473663190261', null, 'N'), ('16', '小说', '1473663199014', null, 'N'), ('17', '其他', '1473663236368', '2', 'N'), ('18', '其他', '1473663592812', '3', 'N'), ('19', '现代言情', '1473663618805', '4', 'N'), ('20', '婚恋情感', '1473663633133', '4', 'N'), ('21', '古言架空', '1473663655589', '4', 'N'), ('22', '穿越重生', '1473663680229', '4', 'N'), ('23', '浪漫青春', '1473663702669', '4', 'N'), ('24', '武侠仙侠', '1473663719875', '4', 'N'), ('25', '幻想异能', '1473663737825', '4', 'N'), ('26', '其他', '1473663887835', '4', 'N'), ('27', '玄幻奇幻', '1473663903356', '5', 'N'), ('28', '武侠仙侠', '1473663932951', '5', 'N'), ('29', '都市生活', '1473663949968', '5', 'Y'), ('31', '官场商战', '1473663970140', '5', 'N'), ('32', '历史架空', '1473664018755', '5', 'N'), ('33', '军事谍战', '1473664038826', '5', 'N'), ('34', '科幻末日', '1473664063705', '5', 'N'), ('35', '灵异悬疑', '1473664080505', '5', 'N'), ('36', '游戏竞技', '1473664095369', '5', 'N'), ('37', '其他', '1473664105923', '5', 'N'), ('38', '科普读物', '1473664131319', '6', 'N'), ('39', '自然科学', '1473664145615', '6', 'N'), ('40', '医学', '1473664161307', '6', 'N'), ('41', '工业技术', '1473664173095', '6', 'N'), ('42', '其他', '1473664202124', '6', 'N'), ('43', '社会学', '1473664267874', '7', 'N'), ('44', '心理学', '1473664280576', '7', 'N'), ('45', '宗教哲学', '1473664293450', '7', 'N'), ('46', '军事法律', '1473664307674', '7', 'Y'), ('47', '时事政治', '1473664322700', '7', 'N'), ('48', '文化', '1473664335646', '7', 'N'), ('49', '教育考试', '1473664345067', '7', 'Y'), ('50', '其他', '1473664356848', '7', 'N'), ('51', '散文随笔', '1473664372308', '8', 'N'), ('52', '绘本画册', '1473664443306', '8', 'N'), ('53', '设计美术', '1473664457393', '8', 'N'), ('54', '音乐戏剧', '1473664478432', '8', 'N'), ('55', '纪实文学', '1473664521480', '8', 'N'), ('56', '文学理论', '1473664535788', '8', 'N'), ('57', '诗词歌赋', '1473664554327', '8', 'N'), ('58', '国学经典', '1473664565587', '8', 'N'), ('59', '世界名著', '1473664584230', '8', 'Y'), ('60', '其他', '1473664595740', '8', 'N'), ('61', '孕产育儿', '1473664661488', '9', 'N'), ('62', '儿童文学', '1473664674756', '9', 'N'), ('63', '科普百科', '1473664689487', '9', 'N'), ('64', '幼儿启蒙', '1473664720172', '9', 'N'), ('65', '烹调饮食', '1473664739073', '10', 'Y'), ('66', '健康养生', '1473664753089', '10', 'Y'), ('67', '占星风水', '1473664768062', '10', 'Y'), ('68', '时尚摄影', '1473664782604', '10', 'N'), ('69', '旅游地理', '1473664800906', '10', 'N'), ('70', '家居手工', '1473664813889', '10', 'N'), ('71', '美容塑身', '1473664837526', '10', 'Y'), ('72', '运动健身', '1473664853835', '10', 'N'), ('73', '休闲娱乐', '1473664867885', '10', 'N'), ('74', '两性关系', '1473664889697', '11', 'N'), ('75', '婚姻家庭', '1473664905042', '11', 'N'), ('76', '情感恋爱', '1473664915197', '11', 'N'), ('77', '软硬件开发', '1473664931812', '12', 'Y'), ('78', '图形与图像', '1473664947112', '12', 'N'), ('79', '网络与通信', '1473664966567', '12', 'Y'), ('80', '家庭与办公', '1473664988032', '12', 'N'), ('81', 'IT人文', '1473665006170', '12', 'N'), ('82', '其他', '1473665015825', '12', 'N'), ('83', '人物传记', '1473665043807', '13', 'N'), ('84', '普及读物', '1473665058028', '13', 'N'), ('85', '世界各国史', '1473665077491', '13', 'Y'), ('86', '中国史', '1473665093339', '13', 'N'), ('87', '成功学', '1473665107427', '14', 'Y'), ('88', '人在职场', '1473665120145', '14', 'N'), ('89', '演讲口才', '1473665137143', '14', 'N'), ('90', '人际处事', '1473665161231', '14', 'N'), ('91', '心灵修养', '1473665183445', '14', 'Y'), ('92', '性格与情绪', '1473665199286', '14', 'N'), ('93', '青少年励志', '1473665223206', '14', 'N'), ('94', '企业管理', '1473665251697', '15', 'N'), ('95', '经济金融', '1473665271189', '15', 'N'), ('96', '投资理财', '1473665283304', '15', 'N'), ('97', '市场营销', '1473665295710', '15', 'N'), ('98', '财会统计', '1473665330804', '15', 'N'), ('99', '通俗读物', '1473665346990', '15', 'N'), ('100', '言情', '1473665361571', '16', 'N'), ('101', '青春', '1473665373031', '16', 'N'), ('102', '都市', '1473665382842', '16', 'N'), ('103', '历史', '1473665402972', '16', 'N'), ('104', '科幻', '1473665416414', '16', 'N'), ('105', '军事', '1473665435308', '16', 'Y'), ('106', '官场商战', '1473665454674', '16', 'N'), ('107', '悬疑推理', '1473665468993', '16', 'Y'), ('108', '武侠魔幻', '1473665482185', '16', 'Y'), ('109', '灵异恐怖', '1473665497073', '16', 'Y'), ('110', '社会乡土', '1473665523982', '16', 'N'), ('111', '影视文学', '1473665534043', '16', 'N'), ('112', '现当代小说', '1473665542676', '16', 'N'), ('113', '外国文学', '1473665556883', '16', 'Y'), ('114', '其他', '1473665565597', '16', 'N');
COMMIT;

-- ----------------------------
--  Table structure for `tbl_group`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_group`;
CREATE TABLE `tbl_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remark` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `tbl_group`
-- ----------------------------
BEGIN;
INSERT INTO `tbl_group` VALUES ('1', '超级管理', '0', '');
COMMIT;

-- ----------------------------
--  Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL,
  `user_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `login_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `portrait` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remark` text COLLATE utf8_unicode_ci,
  `is_admin` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `tbl_user`
-- ----------------------------
BEGIN;
INSERT INTO `tbl_user` VALUES ('1', '1', '系统管理员', 'admin', 'b594510740d2ac4261c1b2fe87850d08', 'upload_images/admin.jpg', '', 'Y', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
