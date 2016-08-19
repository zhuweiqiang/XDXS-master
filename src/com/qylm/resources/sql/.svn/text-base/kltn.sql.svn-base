/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.1.41-community : Database - kltn
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`kltn` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `kltn`;

/*Table structure for table `entityclass` */

DROP TABLE IF EXISTS `entityclass`;

CREATE TABLE `entityclass` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `cls` varchar(200) DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_entityclass_createrId` (`createrId`),
  KEY `FK_entityclass_belongingId` (`belongingId`),
  CONSTRAINT `FK_entityclass_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_entityclass_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `entityclass` */

/*Table structure for table `filecontrol` */

DROP TABLE IF EXISTS `filecontrol`;

CREATE TABLE `filecontrol` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `originalName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `currentName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `folder` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `entityType` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `entityId` bigint(20) DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `suffix` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sizeLimit` bigint(20) DEFAULT NULL,
  `encryption` bit(1) DEFAULT NULL,
  `encryptionType` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `encryptionPass` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `defaultState` tinyint(1) DEFAULT '0',
  `entityclassId` bigint(20) DEFAULT NULL,
  `objectId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_filecontrol_entityclass` (`entityType`),
  KEY `FK_filecontrol_createrId` (`createrId`),
  KEY `FK_filecontrol_belongingId` (`belongingId`),
  CONSTRAINT `FK_filecontrol_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_filecontrol_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `filecontrol` */

insert  into `filecontrol`(`id`,`version`,`createDate`,`updateDate`,`originalName`,`currentName`,`folder`,`type`,`description`,`entityType`,`entityId`,`url`,`suffix`,`sizeLimit`,`encryption`,`encryptionType`,`encryptionPass`,`createrId`,`defaultState`,`entityclassId`,`objectId`,`belongingId`) values (3,0,NULL,NULL,'18.jpg','com.qylm.entity.GeneralIntroduction_2_f07c36f3-f1f3-4a1a-9e14-62b7078a272d.jpg',NULL,'1',NULL,'generalIntroduction',2,'fileUpload\\GeneralIntroduction\\com.qylm.entity.GeneralIntroduction_2_f07c36f3-f1f3-4a1a-9e14-62b7078a272d.jpg','jpg',137324,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(4,0,NULL,NULL,'5.jpg','com.qylm.entity.GeneralDeeds_1_42265dcf-85a5-42fd-bdb7-c8e6c66989b1.jpg',NULL,'1',NULL,NULL,1,'fileUpload\\GeneralDeeds\\com.qylm.entity.GeneralDeeds_1_42265dcf-85a5-42fd-bdb7-c8e6c66989b1.jpg','jpg',189556,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(5,4,NULL,NULL,'5.jpg','com.qylm.entity.Brand_1_b4faae74-c1e1-490d-b617-91af5c626926.jpg',NULL,'1',NULL,'brand',1,'fileUpload\\Brand\\com.qylm.entity.Brand_1_b4faae74-c1e1-490d-b617-91af5c626926.jpg','jpg',189556,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(6,3,'2015-04-05 11:34:47',NULL,'18.jpg','com.qylm.entity.Brand_1_90167986-d3d0-4b46-bcdb-f76e786b88cf.jpg',NULL,'1',NULL,'brand',1,'fileUpload\\Brand\\com.qylm.entity.Brand_1_90167986-d3d0-4b46-bcdb-f76e786b88cf.jpg','jpg',137324,'\0',NULL,NULL,NULL,1,NULL,NULL,NULL),(7,1,'2015-04-05 12:16:43',NULL,'6.jpg','com.qylm.entity.Brand_2_0cd31d89-af36-40a7-90b4-9bb16ad0394f.jpg',NULL,'1',NULL,'brand',2,'fileUpload\\Brand\\com.qylm.entity.Brand_2_0cd31d89-af36-40a7-90b4-9bb16ad0394f.jpg','jpg',156734,'\0',NULL,NULL,NULL,1,NULL,NULL,NULL),(13,0,'2015-04-05 12:46:13',NULL,'13.jpg','com.qylm.entity.Brand_2_df64d865-f4b3-462f-9fb1-596c09379115.jpg',NULL,'1',NULL,'brand',2,'fileUpload\\Brand\\com.qylm.entity.Brand_2_df64d865-f4b3-462f-9fb1-596c09379115.jpg','jpg',106023,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(14,0,'2015-04-05 12:49:19',NULL,'1.jpg','com.qylm.entity.Brand_3_01f84581-2e55-4516-95f1-4946de4c4b6f.jpg',NULL,'1',NULL,'brand',3,'fileUpload\\Brand\\com.qylm.entity.Brand_3_01f84581-2e55-4516-95f1-4946de4c4b6f.jpg','jpg',161239,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(15,0,'2015-04-05 19:07:11',NULL,'13.jpg','com.qylm.entity.Brand_3_9e681769-1347-4b38-bc34-a9b44a6bc63a.jpg',NULL,'1',NULL,'brand',3,'fileUpload\\Brand\\com.qylm.entity.Brand_3_9e681769-1347-4b38-bc34-a9b44a6bc63a.jpg','jpg',106023,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL);

/*Table structure for table `function` */

DROP TABLE IF EXISTS `function`;

CREATE TABLE `function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `treeItemId` bigint(20) DEFAULT NULL,
  `label` varchar(100) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  `rank` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_function_belongingId` (`belongingId`),
  CONSTRAINT `FK_function_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `function` */

insert  into `function`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`treeItemId`,`label`,`enable`,`rank`,`belongingId`) values (2,0,'2015-04-01 00:00:00',NULL,1,9,'添加',0,1,NULL),(3,0,'2015-04-01 00:00:00',NULL,1,9,'修改',0,2,NULL),(4,0,'2015-04-01 00:00:00',NULL,1,9,'删除',0,3,NULL),(5,0,'2015-04-01 00:00:00',NULL,1,2,'添加',0,1,NULL),(6,0,'2015-04-01 00:00:00',NULL,1,2,'删除',0,2,NULL),(7,0,'2015-04-01 00:00:00',NULL,1,3,'添加',0,1,NULL),(8,0,'2015-04-01 00:00:00',NULL,1,3,'删除',0,2,NULL),(9,0,'2015-04-01 00:00:00',NULL,1,12,'添加',0,1,NULL),(10,0,'2015-04-01 00:00:00',NULL,1,12,'修改',0,2,NULL),(11,0,'2015-04-01 00:00:00',NULL,1,12,'删除',0,3,NULL);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `roleName` varchar(20) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_leaguer_role_createrId` (`createrId`),
  KEY `FK_role_belongingId` (`belongingId`),
  CONSTRAINT `FK_role_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_role_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`roleName`,`description`,`belongingId`) values (1,14,'2015-02-11 00:00:00','2015-03-18 00:00:00',1,'理发店用户','理发店管理员',NULL),(2,13,'2015-02-12 00:00:00','2015-04-05 00:00:00',1,'系统管理员','管理整个系统',NULL);

/*Table structure for table `role_detail` */

DROP TABLE IF EXISTS `role_detail`;

CREATE TABLE `role_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `treeItemId` bigint(20) DEFAULT NULL,
  `functionId` bigint(20) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_leaguer_role_createrId` (`createrId`),
  KEY `FK_leaguer_roledetail_treeItemId` (`treeItemId`),
  KEY `FK_leaguer_roledetail_functionId` (`functionId`),
  KEY `FK_leaguer_roledetail_roleId` (`roleId`),
  KEY `FK_role_detail_belongingId` (`belongingId`),
  CONSTRAINT `FK_role_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_roledetail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_roledetail_functionId` FOREIGN KEY (`functionId`) REFERENCES `function` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_roledetail_roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_roledetail_treeItemId` FOREIGN KEY (`treeItemId`) REFERENCES `treeitem` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=393 DEFAULT CHARSET=utf8;

/*Data for the table `role_detail` */

insert  into `role_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`treeItemId`,`functionId`,`roleId`,`belongingId`) values (347,0,'2015-04-05 12:59:56',NULL,1,1,NULL,2,NULL),(348,0,'2015-04-05 12:59:56',NULL,1,2,5,2,NULL),(349,0,'2015-04-05 12:59:56',NULL,1,2,6,2,NULL),(350,0,'2015-04-05 12:59:56',NULL,1,3,7,2,NULL),(351,0,'2015-04-05 12:59:56',NULL,1,3,8,2,NULL),(352,0,'2015-04-05 12:59:56',NULL,1,8,NULL,2,NULL),(353,0,'2015-04-05 12:59:56',NULL,1,9,2,2,NULL),(354,0,'2015-04-05 12:59:56',NULL,1,9,3,2,NULL),(355,0,'2015-04-05 12:59:56',NULL,1,9,4,2,NULL),(356,0,'2015-04-05 12:59:56',NULL,1,12,9,2,NULL),(357,0,'2015-04-05 12:59:56',NULL,1,12,10,2,NULL),(358,0,'2015-04-05 12:59:56',NULL,1,12,11,2,NULL);

/*Table structure for table `treeitem` */

DROP TABLE IF EXISTS `treeitem`;

CREATE TABLE `treeitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `nodeId` varchar(200) DEFAULT NULL,
  `displayChildRen` tinyint(1) DEFAULT NULL,
  `label` varchar(50) DEFAULT NULL,
  `action` varchar(200) DEFAULT NULL,
  `target` varchar(50) DEFAULT NULL,
  `sequence` bigint(20) DEFAULT '0',
  `belongingId` bigint(20) DEFAULT NULL,
  `nodeType` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nodeId` (`nodeId`),
  KEY `FK_system_treeitem_createrId` (`createrId`),
  KEY `FK_treeitem_belongingId` (`belongingId`),
  CONSTRAINT `FK_system_treeitem_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_treeitem_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

/*Data for the table `treeitem` */

insert  into `treeitem`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`nodeId`,`displayChildRen`,`label`,`action`,`target`,`sequence`,`belongingId`,`nodeType`) values (1,2,NULL,NULL,NULL,'system',0,'系统管理',NULL,'',99,NULL,NULL),(2,2,NULL,NULL,NULL,'system_treeItem',0,'模块管理','#{treeItemManageBean.getAll}','mainFrame',1,NULL,NULL),(3,3,NULL,NULL,1,'system_function',0,'功能管理','#{functionManageBean.getAll}','mainFrame',2,NULL,NULL),(8,3,'2014-10-01 00:00:00',NULL,1,'company',0,'用户管理',NULL,'',98,NULL,NULL),(9,3,'2014-10-01 00:00:00',NULL,1,'company_user',0,'用户管理','#{userManageBean.getAll}','mainFrame',1,NULL,NULL),(12,3,'2014-10-01 00:00:00',NULL,1,'company_role',0,'角色管理','#{roleManageBean.getAll}','mainFrame',2,NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `loginName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `stop` varchar(4) NOT NULL,
  `userTel` varchar(255) DEFAULT NULL,
  `userMobile1` varchar(255) DEFAULT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `loginTime` datetime DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `userlevel` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK_user_loginName` (`loginName`),
  KEY `FK_leaguer_user_createrId` (`createrId`),
  KEY `FK_user_belongingId` (`belongingId`),
  CONSTRAINT `FK_leaguer_user_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_user_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`version`,`userName`,`loginName`,`password`,`stop`,`userTel`,`userMobile1`,`lastLoginTime`,`loginTime`,`createDate`,`updateDate`,`createrId`,`belongingId`,`userlevel`) values (1,22,'系统管理员','zjls','HzfrdDg28Hc=','2','89898989898','23423423423',NULL,'2015-09-24 23:55:24',NULL,'2015-09-24 23:53:10',NULL,NULL,NULL);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_leaguer_userrole_createrId` (`createrId`),
  KEY `FK_leaguer_userrole_roleId` (`roleId`),
  KEY `FK_leaguer_userrole_userId` (`userId`),
  KEY `FK_user_role_belongingId` (`belongingId`),
  CONSTRAINT `FK_user_role_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_userrole_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_userrole_roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_userrole_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`userId`,`roleId`,`belongingId`) values (14,0,'2015-04-04 20:14:00',NULL,1,1,2,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
