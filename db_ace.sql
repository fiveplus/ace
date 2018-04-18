# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.21)
# Database: db_ace
# Generation Time: 2018-04-18 15:46:44 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table sys_group_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_group_permission`;

CREATE TABLE `sys_group_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) DEFAULT NULL,
  `permission_id` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `sys_group_permission` WRITE;
/*!40000 ALTER TABLE `sys_group_permission` DISABLE KEYS */;

INSERT INTO `sys_group_permission` (`id`, `group_id`, `permission_id`)
VALUES
	(1,1,'handle'),
	(2,1,'user'),
	(3,1,'group');

/*!40000 ALTER TABLE `sys_group_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_permission
# ------------------------------------------------------------

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

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;

INSERT INTO `sys_permission` (`id`, `name`, `parent_id`, `is_menu`, `class_name`, `status`, `menu_index`, `image_url`, `url`, `create_time`)
VALUES
	('admin','Admin',NULL,'N',NULL,'Y',1,NULL,NULL,'1440665159555'),
	('group','组管理','main','Y','','Y',3,'','admin/group/list/1','1473391211303'),
	('handle','菜单/权限','main','Y','','Y',1,'','admin/permission/list/1','1440666423850'),
	('main','后台管理','admin','Y','icon-desktop','Y',1,'','','1440664698162'),
	('user','用户管理','main','Y','','Y',2,'','admin/user/list/1','1440665159555');

/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table sys_user_permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_user_permission`;

CREATE TABLE `sys_user_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;



# Dump of table tbl_group
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tbl_group`;

CREATE TABLE `tbl_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_time` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remark` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `tbl_group` WRITE;
/*!40000 ALTER TABLE `tbl_group` DISABLE KEYS */;

INSERT INTO `tbl_group` (`id`, `name`, `create_time`, `remark`)
VALUES
	(1,'超级管理','0','');

/*!40000 ALTER TABLE `tbl_group` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tbl_user
# ------------------------------------------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;

INSERT INTO `tbl_user` (`id`, `group_id`, `user_name`, `login_name`, `password`, `portrait`, `remark`, `is_admin`, `create_time`)
VALUES
	(1,1,'系统管理员','admin','b594510740d2ac4261c1b2fe87850d08','upload_images/admin.jpg','','Y','0');

/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
