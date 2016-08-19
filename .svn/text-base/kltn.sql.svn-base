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

/*Table structure for table `auditingset` */

DROP TABLE IF EXISTS `auditingset`;

CREATE TABLE `auditingset` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `applyNumber` varchar(4) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_auditingset_createrId` (`createrId`),
  KEY `FK_auditingset_belongingId` (`belongingId`),
  CONSTRAINT `FK_auditingset_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_auditingset_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `auditingset` */

LOCK TABLES `auditingset` WRITE;

insert  into `auditingset`(`id`,`createDate`,`updateDate`,`version`,`applyNumber`,`state`,`createrId`,`belongingId`) values (2,'2015-10-04 15:49:31',NULL,1,'1',1,2,2),(3,'2015-10-04 15:49:53',NULL,3,'2',1,2,2);

UNLOCK TABLES;

/*Table structure for table `auditingset_detail` */

DROP TABLE IF EXISTS `auditingset_detail`;

CREATE TABLE `auditingset_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `auditingSetId` bigint(20) DEFAULT NULL,
  `auditorId` bigint(20) DEFAULT NULL,
  `sequence` bigint(20) DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_auditingsetdetail_auditingSetId` (`auditingSetId`),
  KEY `FK_auditingsetdetail_auditorId` (`auditorId`),
  KEY `FK_auditingset_detail_createrId` (`createrId`),
  KEY `FK_auditingset_detail_belongingId` (`belongingId`),
  CONSTRAINT `FK_auditingsetdetail_auditingSetId` FOREIGN KEY (`auditingSetId`) REFERENCES `auditingset` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_auditingsetdetail_auditorId` FOREIGN KEY (`auditorId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_auditingset_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_auditingset_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `auditingset_detail` */

LOCK TABLES `auditingset_detail` WRITE;

insert  into `auditingset_detail`(`id`,`createDate`,`updateDate`,`version`,`auditingSetId`,`auditorId`,`sequence`,`createrId`,`belongingId`) values (2,NULL,NULL,0,2,2,2,2,2),(4,NULL,NULL,0,3,2,2,2,2);

UNLOCK TABLES;

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_brand_createrId` (`createrId`),
  KEY `FK_brand_belongingId` (`belongingId`),
  CONSTRAINT `FK_brand_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_brand_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `brand` */

LOCK TABLES `brand` WRITE;

insert  into `brand`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`name`,`remark`) values (1,0,'2015-10-24 15:40:00',NULL,1,NULL,'第一个品牌',''),(2,0,'2015-10-24 15:40:05',NULL,1,NULL,'第二个品牌',''),(3,0,'2015-10-24 15:40:10',NULL,1,NULL,'第三个品牌',''),(4,0,'2015-10-25 19:10:29',NULL,2,2,'悦碧斯','');

UNLOCK TABLES;

/*Table structure for table `consumption_detail` */

DROP TABLE IF EXISTS `consumption_detail`;

CREATE TABLE `consumption_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `entityType` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `entityId` bigint(20) DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `consumptionRegisterId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_consumption_detail_consumptionRegisterId` (`consumptionRegisterId`),
  KEY `FK_consumption_detail_createrId` (`createrId`),
  KEY `FK_consumption_detail_belongingId` (`belongingId`),
  KEY `FK_consumption_detail_customInfoId` (`customInfoId`),
  CONSTRAINT `FK_consumption_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_consumption_detail_consumptionRegisterId` FOREIGN KEY (`consumptionRegisterId`) REFERENCES `consumptionregister` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_consumption_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_consumption_detail_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*Data for the table `consumption_detail` */

LOCK TABLES `consumption_detail` WRITE;

insert  into `consumption_detail`(`id`,`version`,`createDate`,`updateDate`,`entityType`,`entityId`,`createrId`,`belongingId`,`consumptionRegisterId`,`customInfoId`,`date`,`money`,`number`) values (11,1,'2015-11-10 10:57:12',NULL,'customInfo',5,2,2,16,5,'2015-11-10','555.00',NULL),(12,1,'2015-11-10 10:57:12',NULL,'customLeaguerDetail',7,2,2,16,5,'2015-11-10','1000.00',NULL),(13,1,'2015-11-10 10:57:12',NULL,'customLeaguerDetail',16,2,2,16,5,'2015-11-10','1000.00',NULL),(14,1,'2015-11-10 10:57:12',NULL,'customLeaguerDetail',20,2,2,16,5,'2015-11-10','1000.00',NULL),(15,1,'2015-11-10 10:57:12',NULL,'customLeaguerDetail',23,2,2,16,5,'2015-11-10','1000.00',NULL),(16,1,'2015-11-10 10:57:12',NULL,NULL,NULL,2,2,16,5,'2015-11-10','1000.00',NULL),(17,1,'2015-11-10 13:31:42',NULL,'customInfo',5,2,2,17,5,'2015-11-10','5800.00',NULL),(19,1,'2015-11-10 16:19:58',NULL,'customInfo',5,2,2,19,5,'2015-11-10','380.00',NULL),(20,1,'2015-11-10 19:16:25',NULL,'customInfo',5,2,2,20,5,'2015-11-10','425.00',NULL),(21,1,'2015-11-10 19:16:25',NULL,'customLeaguerDetail',22,2,2,20,5,'2015-11-10','1135.00',NULL),(22,1,'2015-11-10 20:42:46',NULL,'customLeaguerDetail',20,2,2,21,5,'2015-11-10','2077.00',NULL),(24,1,'2015-11-14 14:00:42',NULL,'customLeaguerDetail',27,2,2,23,5,'2015-11-14','580.00',NULL),(27,1,'2015-11-15 15:59:20',NULL,'customLeaguerDetail',27,2,2,26,5,'2015-11-15','1920.00',NULL),(28,1,'2015-11-15 16:00:15',NULL,'customLeaguerDetail',27,2,2,27,5,'2015-11-15','280.00',NULL),(29,0,'2015-11-15 16:00:35',NULL,'customLeaguerDetail',27,2,2,27,5,'2015-11-15','280.00',NULL),(30,1,'2015-11-15 19:13:56',NULL,NULL,NULL,2,2,28,7,'2015-11-15','1000.00',NULL),(31,1,'2015-11-15 19:16:37',NULL,NULL,NULL,2,2,29,7,'2015-11-15','3000.00',NULL),(32,1,'2015-11-15 19:18:31',NULL,'customLeaguerDetail',36,2,2,30,7,'2015-11-15','5000.00',NULL),(33,1,'2015-11-15 19:19:36',NULL,'customLeaguerDetail',36,2,2,31,7,'2015-11-15','199.00',NULL),(34,1,'2015-11-15 19:26:51',NULL,'customLeaguerDetail',27,2,2,36,5,'2015-11-15','580.00',NULL),(36,1,'2015-11-15 19:33:12',NULL,NULL,NULL,2,2,38,7,'2015-11-15','4644.00',NULL),(37,1,'2015-11-15 19:52:24',NULL,'customLeaguerDetail',39,2,2,39,7,'2015-11-15','380.00',NULL),(38,1,'2015-11-15 20:10:44',NULL,'customLeaguerDetail',37,2,2,40,7,'2015-11-15','3800.00',NULL),(39,1,'2015-11-15 20:10:44',NULL,'customLeaguerDetail',38,2,2,40,7,'2015-11-15','1000.00',NULL),(42,1,'2015-11-16 18:29:22',NULL,'customLeaguerDetail',36,2,2,52,7,'2015-11-16','4.00',NULL),(43,1,'2015-11-16 18:29:22',NULL,NULL,NULL,2,2,52,7,'2015-11-16','1500.00',NULL),(44,1,'2015-11-16 18:30:17',NULL,'customLeaguerDetail',27,2,2,53,5,'2015-11-16','846.00',NULL),(45,1,'2015-11-16 18:31:48',NULL,'customInfo',5,2,2,54,5,'2015-11-16','46.00',NULL),(46,1,'2015-11-16 18:31:48',NULL,'customLeaguerDetail',27,2,2,54,5,'2015-11-16','400.00',NULL),(47,1,'2015-11-16 18:31:48',NULL,NULL,NULL,2,2,54,5,'2015-11-16','400.00',NULL),(48,1,'2015-11-16 19:13:29',NULL,'customInfo',5,2,2,55,5,'2015-11-16','1024.00',NULL),(49,1,'2015-11-16 19:17:43',NULL,'customInfo',5,2,2,56,5,'2015-11-16','1224.00',NULL),(50,1,'2015-11-16 19:39:28',NULL,'customInfo',5,2,2,57,5,'2015-11-16','1224.00',NULL),(51,1,'2015-11-17 19:31:42',NULL,'customInfo',7,2,2,60,7,'2015-11-17','14000.00',NULL);

UNLOCK TABLES;

/*Table structure for table `consumptionregister` */

DROP TABLE IF EXISTS `consumptionregister`;

CREATE TABLE `consumptionregister` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `personnelInfoId` bigint(20) DEFAULT NULL,
  `realityMoney` decimal(10,2) DEFAULT NULL,
  `debt` decimal(10,2) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `repayment` decimal(10,2) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  `adviserId` bigint(20) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL,
  `rebate` decimal(10,1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_consumptionregister_createrId` (`createrId`),
  KEY `FK_consumptionregister_belongingId` (`belongingId`),
  KEY `FK_consumptionregister_customInfoId` (`customInfoId`),
  KEY `FK_consumptionregister_personnelInfoId` (`personnelInfoId`),
  KEY `FK_consumptionregister_adviserId` (`adviserId`),
  CONSTRAINT `FK_consumptionregister_adviserId` FOREIGN KEY (`adviserId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_personnelInfoId` FOREIGN KEY (`personnelInfoId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

/*Data for the table `consumptionregister` */

LOCK TABLES `consumptionregister` WRITE;

insert  into `consumptionregister`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`customInfoId`,`date`,`money`,`personnelInfoId`,`realityMoney`,`debt`,`state`,`repayment`,`balance`,`adviserId`,`type`,`rebate`) values (4,1,'2015-10-25 15:30:39',NULL,NULL,NULL,5,'2015-10-25','5555.00',NULL,'5555.00','0.00',1,NULL,'52445.00',NULL,NULL,NULL),(5,1,'2015-10-25 19:32:45',NULL,NULL,NULL,5,'2015-10-25','4000.00',1,'5555.00','1555.00',1,NULL,'50445.00',NULL,NULL,NULL),(11,1,'2015-11-08 22:24:12',NULL,2,2,5,'2015-11-08','6555.00',1,'6555.00','0.00',1,NULL,'19770.00',2,NULL,NULL),(12,1,'2015-11-09 15:34:44',NULL,2,2,5,'2015-11-09','6555.00',1,'6555.00','0.00',1,NULL,'19270.00',2,NULL,NULL),(14,0,'2015-11-10 09:50:23',NULL,2,2,5,'2015-11-10','6000.00',1,'6555.00','555.00',1,NULL,'7715.00',2,NULL,NULL),(16,0,'2015-11-10 10:57:12',NULL,2,2,5,'2015-11-10','5555.00',1,'5555.00','0.00',1,NULL,NULL,2,NULL,NULL),(17,0,'2015-11-10 13:31:42',NULL,2,2,5,'2015-11-10','5800.00',1,'5800.00','0.00',1,NULL,'805.00',2,NULL,NULL),(19,0,'2015-11-10 16:19:58',NULL,2,2,5,'2015-11-10','380.00',1,'380.00','0.00',1,NULL,'425.00',2,NULL,NULL),(20,0,'2015-11-10 19:16:25',NULL,2,2,5,'2015-11-10','1560.00',1,'1560.00','0.00',1,NULL,'0.00',2,NULL,NULL),(21,0,'2015-11-10 20:42:46',NULL,2,2,5,'2015-11-10','2077.00',1,'2079.00','2.00',1,NULL,'0.00',2,NULL,NULL),(23,0,'2015-11-14 14:00:42',NULL,2,2,5,'2015-11-14','580.00',1,'580.00','0.00',1,NULL,'0.00',2,'5',NULL),(26,0,'2015-11-15 15:59:20',NULL,2,2,5,'2015-11-15','1920.00',1,'1920.00','0.00',1,NULL,'0.00',2,'5',NULL),(27,0,'2015-11-15 16:00:15',NULL,2,2,5,'2015-11-15','280.00',1,'280.00','0.00',1,NULL,'0.00',2,'5',NULL),(28,0,'2015-11-15 19:13:56',NULL,2,2,7,'2015-11-15','1000.00',1,'5555.00','4555.00',1,NULL,NULL,2,'1',NULL),(29,0,'2015-11-15 19:16:37',NULL,2,2,7,'2015-11-15','3000.00',1,'3980.00','980.00',1,NULL,NULL,2,'2',NULL),(30,0,'2015-11-15 19:18:31',NULL,2,2,7,'2015-11-15','5000.00',1,'5000.00','0.00',1,NULL,NULL,2,'3',NULL),(31,0,'2015-11-15 19:19:36',NULL,2,2,7,'2015-11-15','199.00',1,'199.00','0.00',1,NULL,NULL,2,'4',NULL),(36,0,'2015-11-15 19:26:51',NULL,2,2,5,'2015-11-15','580.00',1,'580.00','0.00',1,NULL,'0.00',2,'5',NULL),(38,0,'2015-11-15 19:33:12',NULL,2,2,7,'2015-11-15','4644.00',1,'5000.00','356.00',1,NULL,NULL,2,'1',NULL),(39,0,'2015-11-15 19:52:24',NULL,2,2,7,'2015-11-15','380.00',1,'380.00','0.00',1,NULL,NULL,2,'5',NULL),(40,0,'2015-11-15 20:10:44',NULL,2,2,7,'2015-11-15','4800.00',1,'4800.00','0.00',1,NULL,NULL,2,'3',NULL),(52,0,'2015-11-16 18:29:22',NULL,2,2,7,'2015-11-16','1504.00',1,'1880.00','0.00',1,NULL,NULL,2,'4',NULL),(53,0,'2015-11-16 18:30:17',NULL,2,2,5,'2015-11-16','846.00',1,'1880.00','0.00',1,NULL,'8888.00',2,'4',NULL),(54,0,'2015-11-16 18:31:48',NULL,2,2,5,'2015-11-16','846.00',1,'1880.00','0.00',1,NULL,'8842.00',2,'4',NULL),(55,0,'2015-11-16 19:13:29',NULL,2,2,5,'2015-11-16','1024.00',1,'1280.00','256.00',1,NULL,'7818.00',2,'5',NULL),(56,0,'2015-11-16 19:17:43',NULL,2,2,5,'2015-11-16','1224.00',1,'1440.00','216.00',1,NULL,'6594.00',2,'5',NULL),(57,0,'2015-11-16 19:39:28',NULL,2,2,5,'2015-11-16','1224.00',1,'2720.00','0.00',1,NULL,'5370.00',2,'5',NULL),(58,0,'2015-11-17 19:16:26',NULL,2,2,7,'2015-11-17','0.00',1,'0.00','0.00',1,NULL,'22580.00',2,'5','8.0'),(59,0,'2015-11-17 19:16:57',NULL,2,2,7,'2015-11-17','0.00',1,'0.00','0.00',1,NULL,'22580.00',2,'5','8.0'),(60,0,'2015-11-17 19:31:42',NULL,2,2,7,'2015-11-17','14000.00',1,'14000.00','0.00',1,NULL,'20180.00',2,'3',NULL),(61,0,'2015-11-17 19:32:15',NULL,2,2,7,'2015-11-17','0.00',1,'0.00','0.00',1,NULL,'20180.00',2,'5','8.0'),(63,0,'2015-11-17 19:48:38',NULL,2,2,7,'2015-11-17','0.00',1,'0.00','0.00',1,NULL,'20180.00',2,'5','8.0'),(64,0,'2015-11-17 19:55:43',NULL,2,2,7,'2015-11-17','0.00',1,'0.00','0.00',1,NULL,'20180.00',2,'5','8.0');

UNLOCK TABLES;

/*Table structure for table `consumptionregister_detail` */

DROP TABLE IF EXISTS `consumptionregister_detail`;

CREATE TABLE `consumptionregister_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `consumptionRegisterId` bigint(20) DEFAULT NULL,
  `marketingProjectId` bigint(20) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `debt` decimal(10,2) DEFAULT NULL,
  `customLeaguerDetailId` bigint(20) DEFAULT NULL,
  `productStockId` bigint(20) DEFAULT NULL,
  `temporaryActivityId` bigint(20) DEFAULT NULL,
  `projectBuyDetailId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `consumptionNumber` bigint(20) DEFAULT NULL,
  `types` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_consumptionregister_detail_createrId` (`createrId`),
  KEY `FK_consumptionregister_detail_belongingId` (`belongingId`),
  KEY `FK_consumptionregister_detail_consumptionRegisterId` (`consumptionRegisterId`),
  KEY `FK_consumptionregister_detail_marketingProjectId` (`marketingProjectId`),
  KEY `FK_consumptionregister_detail_productStockId` (`productStockId`),
  KEY `FK_consumptionregister_detail_temporaryActivityId` (`temporaryActivityId`),
  KEY `FK_consumptionregister_detail_customLeaguerDetailId` (`customLeaguerDetailId`),
  KEY `FK_consumptionregister_detail_projectBuyDetailId` (`projectBuyDetailId`),
  CONSTRAINT `FK_consumptionregister_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_detail_consumptionRegisterId` FOREIGN KEY (`consumptionRegisterId`) REFERENCES `consumptionregister` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_detail_customLeaguerDetailId` FOREIGN KEY (`customLeaguerDetailId`) REFERENCES `customleaguer_detail` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_detail_marketingProjectId` FOREIGN KEY (`marketingProjectId`) REFERENCES `marketingproject` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_detail_productStockId` FOREIGN KEY (`productStockId`) REFERENCES `productstock` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_detail_projectBuyDetailId` FOREIGN KEY (`projectBuyDetailId`) REFERENCES `projectbuy_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_consumptionregister_detail_temporaryActivityId` FOREIGN KEY (`temporaryActivityId`) REFERENCES `temporaryactivity` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

/*Data for the table `consumptionregister_detail` */

LOCK TABLES `consumptionregister_detail` WRITE;

insert  into `consumptionregister_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`consumptionRegisterId`,`marketingProjectId`,`money`,`debt`,`customLeaguerDetailId`,`productStockId`,`temporaryActivityId`,`projectBuyDetailId`,`number`,`consumptionNumber`,`types`) values (3,0,'2015-10-25 15:30:39',NULL,NULL,NULL,4,NULL,'5555.00',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(4,0,'2015-10-25 19:32:46',NULL,NULL,NULL,5,NULL,'2000.00',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(5,0,'2015-10-25 19:32:46',NULL,NULL,NULL,5,NULL,'1000.00',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(6,0,'2015-10-25 19:32:46',NULL,NULL,NULL,5,NULL,'1000.00',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(12,0,'2015-11-08 22:24:12',NULL,2,2,11,NULL,'5555.00',NULL,16,NULL,NULL,NULL,NULL,0,NULL),(13,0,'2015-11-08 22:24:12',NULL,2,2,11,NULL,'1000.00',NULL,17,NULL,NULL,NULL,NULL,0,NULL),(14,0,'2015-11-09 15:34:44',NULL,2,2,12,NULL,'5555.00',NULL,18,NULL,NULL,NULL,NULL,0,NULL),(15,0,'2015-11-09 15:34:44',NULL,2,2,12,NULL,'1000.00',NULL,19,NULL,NULL,NULL,NULL,0,NULL),(17,0,'2015-11-10 09:50:23',NULL,2,2,14,NULL,'5555.00',NULL,23,NULL,NULL,NULL,NULL,0,NULL),(18,0,'2015-11-10 09:50:23',NULL,2,2,14,NULL,'1000.00',NULL,24,NULL,NULL,NULL,NULL,0,NULL),(20,0,'2015-11-10 10:57:12',NULL,2,2,16,NULL,'5555.00',NULL,26,NULL,NULL,NULL,NULL,0,NULL),(21,0,'2015-11-10 13:31:42',NULL,2,2,17,NULL,'5800.00',NULL,27,NULL,NULL,NULL,NULL,0,NULL),(23,0,'2015-11-10 16:19:58',NULL,2,2,19,NULL,'380.00',NULL,NULL,NULL,3,NULL,NULL,0,NULL),(24,1,'2015-11-10 19:16:25',NULL,2,2,20,NULL,'1280.00',NULL,NULL,NULL,NULL,8,NULL,0,NULL),(25,1,'2015-11-10 19:16:25',NULL,2,2,20,NULL,'280.00',NULL,NULL,NULL,NULL,9,NULL,0,NULL),(26,0,'2015-11-10 20:42:46',NULL,2,2,21,NULL,'199.00',NULL,NULL,4,NULL,NULL,NULL,0,NULL),(27,0,'2015-11-10 20:42:46',NULL,2,2,21,NULL,'1880.00',NULL,NULL,5,NULL,NULL,NULL,0,NULL),(32,0,'2015-11-14 14:00:42',NULL,2,2,23,8,'1280.00',NULL,NULL,NULL,NULL,NULL,1,1,'2'),(33,0,'2015-11-14 14:00:42',NULL,2,2,23,9,'280.00',NULL,NULL,NULL,NULL,NULL,1,1,'4'),(34,0,'2015-11-14 14:00:42',NULL,2,2,23,10,'580.00',NULL,NULL,NULL,NULL,NULL,1,1,'2'),(35,0,'2015-11-14 14:00:42',NULL,2,2,23,11,'580.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(46,0,'2015-11-15 15:59:20',NULL,2,2,26,8,'1280.00',NULL,NULL,NULL,NULL,NULL,1,1,'2,5,5'),(47,0,'2015-11-15 15:59:20',NULL,2,2,26,9,'280.00',NULL,NULL,NULL,NULL,NULL,1,0,'4,4'),(48,0,'2015-11-15 15:59:20',NULL,2,2,26,10,'580.00',NULL,NULL,NULL,NULL,NULL,1,0,'2,2,2'),(49,0,'2015-11-15 15:59:20',NULL,2,2,26,11,'580.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(50,0,'2015-11-15 15:59:20',NULL,2,2,26,12,'480.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(51,0,'2015-11-15 16:00:15',NULL,2,2,27,8,'1280.00',NULL,NULL,NULL,NULL,NULL,1,1,'5'),(52,0,'2015-11-15 16:00:15',NULL,2,2,27,9,'280.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(53,0,'2015-11-15 19:13:56',NULL,2,2,28,NULL,'5555.00',NULL,36,NULL,NULL,NULL,NULL,0,NULL),(54,0,'2015-11-15 19:16:37',NULL,2,2,29,NULL,'3980.00',NULL,NULL,NULL,4,NULL,NULL,0,NULL),(55,1,'2015-11-15 19:18:31',NULL,2,2,30,NULL,'6800.00',NULL,NULL,NULL,NULL,10,NULL,0,NULL),(56,0,'2015-11-15 19:19:36',NULL,2,2,31,NULL,'199.00',NULL,NULL,4,NULL,NULL,NULL,0,NULL),(61,0,'2015-11-15 19:26:51',NULL,2,2,36,8,'1280.00',NULL,NULL,NULL,NULL,NULL,1,1,'2'),(62,0,'2015-11-15 19:26:51',NULL,2,2,36,9,'280.00',NULL,NULL,NULL,NULL,NULL,1,1,'4'),(63,0,'2015-11-15 19:26:51',NULL,2,2,36,10,'580.00',NULL,NULL,NULL,NULL,NULL,1,1,'2'),(64,0,'2015-11-15 19:26:51',NULL,2,2,36,11,'580.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(66,0,'2015-11-15 19:33:12',NULL,2,2,38,NULL,'5000.00',NULL,37,NULL,NULL,NULL,NULL,0,NULL),(67,0,'2015-11-15 19:52:24',NULL,2,2,39,14,'380.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(68,1,'2015-11-15 20:10:44',NULL,2,2,40,NULL,'4800.00',NULL,NULL,NULL,NULL,11,NULL,0,NULL),(80,0,'2015-11-16 18:29:22',NULL,2,2,52,NULL,'1880.00',NULL,NULL,5,NULL,NULL,NULL,0,NULL),(81,0,'2015-11-16 18:30:17',NULL,2,2,53,NULL,'1880.00',NULL,NULL,5,NULL,NULL,NULL,0,NULL),(82,0,'2015-11-16 18:31:48',NULL,2,2,54,NULL,'1880.00',NULL,NULL,5,NULL,NULL,NULL,0,NULL),(83,0,'2015-11-16 19:13:29',NULL,2,2,55,8,'1280.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(84,0,'2015-11-16 19:13:29',NULL,2,2,55,9,'280.00',NULL,NULL,NULL,NULL,NULL,1,1,'4'),(85,0,'2015-11-16 19:13:29',NULL,2,2,55,10,'580.00',NULL,NULL,NULL,NULL,NULL,1,1,'2'),(86,0,'2015-11-16 19:17:43',NULL,2,2,56,8,'1280.00',NULL,NULL,NULL,NULL,NULL,1,1,'2'),(87,0,'2015-11-16 19:17:43',NULL,2,2,56,9,'280.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(88,0,'2015-11-16 19:17:43',NULL,2,2,56,10,'580.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(89,0,'2015-11-16 19:17:43',NULL,2,2,56,11,'580.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(90,0,'2015-11-16 19:39:28',NULL,2,2,57,8,'1280.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(91,0,'2015-11-16 19:39:28',NULL,2,2,57,9,'280.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(92,0,'2015-11-16 19:39:28',NULL,2,2,57,10,'580.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(93,0,'2015-11-16 19:39:28',NULL,2,2,57,11,'580.00',NULL,NULL,NULL,NULL,NULL,1,0,NULL),(94,0,'2015-11-17 19:16:26',NULL,2,2,58,17,'680.00',NULL,NULL,NULL,NULL,NULL,1,1,'4'),(95,0,'2015-11-17 19:16:57',NULL,2,2,59,17,'680.00',NULL,NULL,NULL,NULL,NULL,1,1,'4'),(96,1,'2015-11-17 19:31:42',NULL,2,2,60,NULL,'12000.00',NULL,NULL,NULL,NULL,12,NULL,0,NULL),(97,1,'2015-11-17 19:31:42',NULL,2,2,60,NULL,'2000.00',NULL,NULL,NULL,NULL,13,NULL,0,NULL),(98,0,'2015-11-17 19:32:15',NULL,2,2,61,8,'1280.00',NULL,NULL,NULL,NULL,NULL,1,1,'4'),(99,0,'2015-11-17 19:32:15',NULL,2,2,61,9,'280.00',NULL,NULL,NULL,NULL,NULL,1,1,'4'),(102,0,'2015-11-17 19:48:38',NULL,2,2,63,8,'1280.00',NULL,NULL,NULL,NULL,NULL,1,1,'4'),(103,0,'2015-11-17 19:48:38',NULL,2,2,63,9,'280.00',NULL,NULL,NULL,NULL,NULL,1,1,'4'),(104,0,'2015-11-17 19:55:43',NULL,2,2,64,8,'1280.00',NULL,NULL,NULL,NULL,NULL,1,1,'4'),(105,0,'2015-11-17 19:55:43',NULL,2,2,64,9,'280.00',NULL,NULL,NULL,NULL,NULL,1,1,'4');

UNLOCK TABLES;

/*Table structure for table `conversiontreatment` */

DROP TABLE IF EXISTS `conversiontreatment`;

CREATE TABLE `conversiontreatment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `personnelInfoId` bigint(20) DEFAULT NULL,
  `adviserId` bigint(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_conversiontreatment_createrId` (`createrId`),
  KEY `FK_conversiontreatment_belongingId` (`belongingId`),
  KEY `FK_conversiontreatment_customInfoId` (`customInfoId`),
  KEY `FK_conversiontreatment_personnelInfoId` (`personnelInfoId`),
  KEY `FK_conversiontreatment_adviserId` (`adviserId`),
  CONSTRAINT `FK_conversiontreatment_adviserId` FOREIGN KEY (`adviserId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_conversiontreatment_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_conversiontreatment_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_conversiontreatment_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_conversiontreatment_personnelInfoId` FOREIGN KEY (`personnelInfoId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `conversiontreatment` */

LOCK TABLES `conversiontreatment` WRITE;

insert  into `conversiontreatment`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`customInfoId`,`personnelInfoId`,`adviserId`,`date`,`state`) values (1,3,NULL,'2015-11-15 19:26:51',2,2,5,1,2,'2015-11-15',1),(2,0,'2015-11-17 10:13:47',NULL,2,2,7,1,2,'2015-11-17',1),(3,0,'2015-11-17 10:26:31',NULL,2,2,7,1,2,'2015-11-17',1),(5,0,'2015-11-17 10:34:31',NULL,2,2,7,1,2,'2015-11-17',1),(8,0,'2015-11-17 15:00:58',NULL,2,2,7,1,2,'2015-11-17',1),(9,0,'2015-11-17 15:02:56',NULL,2,2,5,1,2,'2015-11-17',1),(10,0,'2015-11-17 19:19:00',NULL,2,2,7,1,2,'2015-11-17',1),(11,0,'2015-11-17 19:20:07',NULL,2,2,7,1,2,'2015-11-17',1),(12,0,'2015-11-17 19:57:48',NULL,2,2,7,1,2,'2015-11-17',1);

UNLOCK TABLES;

/*Table structure for table `conversiontreatment_detail` */

DROP TABLE IF EXISTS `conversiontreatment_detail`;

CREATE TABLE `conversiontreatment_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `conversionTreatmentId` bigint(20) DEFAULT NULL,
  `marketingProjectId` bigint(20) DEFAULT NULL,
  `typeId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `type` bigint(20) DEFAULT NULL,
  `surplusNumber` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_conversiontreatment_detail_createrId` (`createrId`),
  KEY `FK_conversiontreatment_detail_belongingId` (`belongingId`),
  KEY `FK_conversiontreatment_detail_conversionTreatmentId` (`conversionTreatmentId`),
  KEY `FK_conversiontreatment_detail_marketingProjectId` (`marketingProjectId`),
  CONSTRAINT `FK_conversiontreatment_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_conversiontreatment_detail_conversionTreatmentId` FOREIGN KEY (`conversionTreatmentId`) REFERENCES `conversiontreatment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_conversiontreatment_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_conversiontreatment_detail_marketingProjectId` FOREIGN KEY (`marketingProjectId`) REFERENCES `marketingproject` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `conversiontreatment_detail` */

LOCK TABLES `conversiontreatment_detail` WRITE;

insert  into `conversiontreatment_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`conversionTreatmentId`,`marketingProjectId`,`typeId`,`number`,`money`,`type`,`surplusNumber`) values (1,0,'2015-11-15 15:42:43',NULL,2,2,1,10,85,1,'580.00',2,1),(2,0,'2015-11-15 15:42:43',NULL,2,2,1,10,124,1,'580.00',2,1),(3,0,'2015-11-15 15:42:43',NULL,2,2,1,10,163,1,'580.00',2,1),(4,0,'2015-11-15 15:42:43',NULL,2,2,1,10,202,1,'580.00',2,1),(5,0,'2015-11-15 15:42:43',NULL,2,2,1,10,203,1,'580.00',2,1),(6,0,'2015-11-15 15:42:43',NULL,2,2,1,10,242,1,'580.00',2,1),(7,0,'2015-11-15 15:42:43',NULL,2,2,1,10,243,1,'580.00',2,1),(8,0,'2015-11-15 15:42:43',NULL,2,2,1,43,9,1,'198.00',3,1),(9,0,'2015-11-15 15:42:43',NULL,2,2,1,44,10,1,'398.00',3,1),(10,0,'2015-11-15 15:42:43',NULL,2,2,1,40,11,1,'198.00',3,1),(11,0,'2015-11-15 15:42:43',NULL,2,2,1,41,12,1,'268.00',3,1),(12,0,'2015-11-17 10:13:47',NULL,2,2,2,46,32,2,'3490.00',3,5),(13,0,'2015-11-17 10:26:31',NULL,2,2,3,46,32,1,'3490.00',3,5),(15,0,'2015-11-17 10:34:31',NULL,2,2,5,46,32,1,'3490.00',3,5),(16,0,'2015-11-17 10:34:31',NULL,2,2,5,17,10,1,'680.00',4,10),(21,0,'2015-11-17 15:00:58',NULL,2,2,8,46,32,2,'3490.00',3,5),(22,0,'2015-11-17 15:00:58',NULL,2,2,8,18,11,2,'480.00',4,10),(23,0,'2015-11-17 15:02:56',NULL,2,2,9,10,124,1,'580.00',2,1),(24,0,'2015-11-17 15:02:56',NULL,2,2,9,10,163,1,'580.00',2,1),(25,0,'2015-11-17 19:19:00',NULL,2,2,10,17,10,10,'680.00',4,10),(26,0,'2015-11-17 19:20:07',NULL,2,2,11,18,11,10,'480.00',4,10),(27,0,'2015-11-17 19:57:48',NULL,2,2,12,8,12,1,'1200.00',4,6),(28,0,'2015-11-17 19:57:48',NULL,2,2,12,9,13,1,'200.00',4,8);

UNLOCK TABLES;

/*Table structure for table `custominfo` */

DROP TABLE IF EXISTS `custominfo`;

CREATE TABLE `custominfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `leaguerId` bigint(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `leaguerNumber` varchar(20) DEFAULT NULL,
  `spouse` varchar(20) DEFAULT NULL,
  `issue` varchar(20) DEFAULT NULL,
  `maritalStatus` varchar(20) DEFAULT NULL,
  `maritalDeta` date DEFAULT NULL,
  `provinceId` bigint(20) DEFAULT NULL,
  `cityId` bigint(20) DEFAULT NULL,
  `districtId` bigint(20) DEFAULT NULL,
  `zipCode` varchar(6) DEFAULT NULL,
  `addressDetail` varchar(100) DEFAULT NULL,
  `occupation` varchar(100) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `skinType` varchar(100) DEFAULT NULL,
  `ocularRegionState` varchar(100) DEFAULT NULL,
  `faceState` varchar(100) DEFAULT NULL,
  `faceNeed` varchar(100) DEFAULT NULL,
  `dietPractice` varchar(100) DEFAULT NULL,
  `yjkzt` varchar(100) DEFAULT NULL,
  `skinType1` varchar(100) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `hljy` tinyint(1) DEFAULT NULL,
  `yearNumber` decimal(10,2) DEFAULT NULL,
  `impressions` varchar(100) DEFAULT NULL,
  `shiftShopCause` varchar(100) DEFAULT NULL,
  `purpose` varchar(100) DEFAULT NULL,
  `nurse` varchar(1000) DEFAULT NULL,
  `healthState` varchar(100) DEFAULT NULL,
  `bloodGroup` varchar(100) DEFAULT NULL,
  `stapleFood` varchar(100) DEFAULT NULL,
  `repast` varchar(100) DEFAULT NULL,
  `addSeasonings` varchar(100) DEFAULT NULL,
  `xhwd` varchar(100) DEFAULT NULL,
  `yzsw` varchar(100) DEFAULT NULL,
  `dietaryBias` varchar(100) DEFAULT NULL,
  `diet` varchar(100) DEFAULT NULL,
  `pac` varchar(100) DEFAULT NULL,
  `money` decimal(20,2) DEFAULT NULL,
  `arrearage` decimal(20,2) DEFAULT NULL,
  `leaguer` varchar(4) DEFAULT NULL,
  `leaguerSource` varchar(20) DEFAULT NULL,
  `personnelInfo1Id` bigint(20) DEFAULT NULL,
  `personnelInfo2Id` bigint(20) DEFAULT NULL,
  `emergencyContact` varchar(20) DEFAULT NULL,
  `emergencyMobile` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_custominfo_cityId` (`cityId`),
  KEY `FK_custominfo_belongingId` (`belongingId`),
  KEY `FK_custominfo_leaguerId` (`leaguerId`),
  KEY `FK_custominfo_createrId` (`createrId`),
  KEY `FK_custominfo_personnelInfo1Id` (`personnelInfo1Id`),
  KEY `FK_custominfo_personnelInfo2Id` (`personnelInfo2Id`),
  CONSTRAINT `FK_custominfo_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_custominfo_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_custominfo_leaguerId` FOREIGN KEY (`leaguerId`) REFERENCES `leaguer` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_custominfo_personnelInfo1Id` FOREIGN KEY (`personnelInfo1Id`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_custominfo_personnelInfo2Id` FOREIGN KEY (`personnelInfo2Id`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `custominfo` */

LOCK TABLES `custominfo` WRITE;

insert  into `custominfo`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`leaguerId`,`name`,`birthday`,`leaguerNumber`,`spouse`,`issue`,`maritalStatus`,`maritalDeta`,`provinceId`,`cityId`,`districtId`,`zipCode`,`addressDetail`,`occupation`,`mobile`,`skinType`,`ocularRegionState`,`faceState`,`faceNeed`,`dietPractice`,`yjkzt`,`skinType1`,`remark`,`hljy`,`yearNumber`,`impressions`,`shiftShopCause`,`purpose`,`nurse`,`healthState`,`bloodGroup`,`stapleFood`,`repast`,`addSeasonings`,`xhwd`,`yzsw`,`dietaryBias`,`diet`,`pac`,`money`,`arrearage`,`leaguer`,`leaguerSource`,`personnelInfo1Id`,`personnelInfo2Id`,`emergencyContact`,`emergencyMobile`) values (5,45,'2015-10-09 10:22:35','2015-11-16 19:39:28',2,2,11,'周明珠','1966-09-12','276','有','','1','2015-10-01',330000,330700,330702,NULL,'丹溪路436金叶小区','','15336929939','5','4,5','12','1,3,6','2','18','','啊速度发撒旦法时代发生地方爱上对方爱上对方爱上对方地方爱上对方啊萨芬打撒',0,'10.00','','','',' * * * * * * * * * * * * * * * * * * * * ','',NULL,'1','2','','6','','2','1','7','5370.00','432.00','1','现金充值',1,2,'张有位','234324234324'),(6,0,'2015-11-01 15:30:17',NULL,3,3,NULL,'撒点粉','1981-11-01','277','撒点粉',NULL,'1','2011-11-04',130000,130100,130102,NULL,'爱上对方撒点粉',NULL,'32123123213123213',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',0,NULL,NULL,NULL,NULL,' * * * * * * * * * * * * * * * * * * * * ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','277',1,2,'爱上对方','3241242143'),(7,25,'2015-11-15 19:12:48','2015-11-17 19:57:48',2,2,NULL,'李思','1991-10-19','','',NULL,'1',NULL,330000,330700,330702,NULL,'',NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',0,NULL,NULL,NULL,NULL,' * * * * * * * * * * * * * * * * * * * * ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'21580.00','752.00','1','',1,2,'','');

UNLOCK TABLES;

/*Table structure for table `customleaguer_detail` */

DROP TABLE IF EXISTS `customleaguer_detail`;

CREATE TABLE `customleaguer_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `leaguerId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `rebate` decimal(10,1) DEFAULT NULL,
  `giveInfoId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_customleaguer_detail_createrId` (`createrId`),
  KEY `FK_customleaguer_detail_belongingId` (`belongingId`),
  KEY `FK_customleaguer_detail_customInfoId` (`customInfoId`),
  KEY `FK_customleaguer_detail_leaguerId` (`leaguerId`),
  KEY `FK_customleaguer_detail_giveInfoId` (`giveInfoId`),
  CONSTRAINT `FK_customleaguer_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_customleaguer_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_customleaguer_detail_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_customleaguer_detail_giveInfoId` FOREIGN KEY (`giveInfoId`) REFERENCES `giveinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_customleaguer_detail_leaguerId` FOREIGN KEY (`leaguerId`) REFERENCES `leaguer` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Data for the table `customleaguer_detail` */

LOCK TABLES `customleaguer_detail` WRITE;

insert  into `customleaguer_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`leaguerId`,`customInfoId`,`money`,`rebate`,`giveInfoId`,`number`) values (1,14,'2015-10-25 14:11:43','2015-11-04 18:41:39',NULL,NULL,11,5,'0.00','8.0',NULL,NULL),(2,14,'2015-10-25 14:11:43','2015-11-04 18:48:01',NULL,NULL,12,5,'0.00','6.0',NULL,NULL),(6,14,'2015-10-25 15:30:39','2015-11-04 19:37:31',NULL,NULL,11,5,'0.00','8.0',NULL,NULL),(7,18,'2015-10-25 19:32:45','2015-11-15 20:07:49',NULL,NULL,11,5,'0.00','8.0',NULL,NULL),(8,15,'2015-11-01 14:07:14','2015-11-04 19:36:41',NULL,NULL,11,5,'6666.00','8.0',NULL,NULL),(9,11,'2015-11-01 14:07:14',NULL,NULL,NULL,NULL,5,'1000.00','10.0',1,NULL),(10,11,'2015-11-01 14:07:14',NULL,NULL,NULL,NULL,5,'2000.00','8.0',3,NULL),(12,11,'2015-11-07 13:35:43',NULL,3,3,13,5,'5800.00','4.5',NULL,NULL),(13,10,'2015-11-07 13:50:48','2015-11-10 20:52:46',3,3,13,5,'5356.00','4.5',NULL,NULL),(14,6,'2015-11-07 13:50:48',NULL,3,3,NULL,5,'480.00',NULL,6,1),(15,6,'2015-11-07 13:50:48',NULL,3,3,NULL,5,'480.00',NULL,7,1),(16,10,'2015-11-08 22:24:11',NULL,2,2,11,5,'5555.00','8.0',NULL,NULL),(17,7,'2015-11-08 22:24:12',NULL,2,2,NULL,5,'1000.00','10.0',1,NULL),(18,10,'2015-11-09 15:34:44',NULL,2,2,11,5,'5555.00','8.0',NULL,NULL),(19,7,'2015-11-09 15:34:44',NULL,2,2,NULL,5,'1000.00','10.0',1,NULL),(20,10,'2015-11-09 16:36:15','2015-11-10 20:42:46',2,2,11,5,'3478.00','8.0',NULL,NULL),(21,7,'2015-11-09 16:36:15',NULL,2,2,NULL,5,'1000.00','10.0',1,NULL),(22,10,'2015-11-10 09:45:15','2015-11-10 19:16:25',2,2,11,5,'4420.00','8.0',NULL,NULL),(23,10,'2015-11-10 09:50:21',NULL,2,2,11,5,'5555.00','8.0',NULL,NULL),(24,7,'2015-11-10 09:50:22',NULL,2,2,NULL,5,'1000.00','10.0',1,NULL),(25,10,'2015-11-10 10:50:02',NULL,2,2,11,5,'5555.00','8.0',NULL,NULL),(26,10,'2015-11-10 10:57:12',NULL,2,2,11,5,'5555.00','8.0',NULL,NULL),(27,14,'2015-11-10 13:31:42','2015-11-16 18:31:48',2,2,13,5,'914.00','4.5',NULL,NULL),(28,6,'2015-11-10 13:31:42',NULL,2,2,NULL,5,'480.00',NULL,6,1),(29,6,'2015-11-10 13:31:42',NULL,2,2,NULL,5,'480.00',NULL,7,1),(33,5,'2015-11-14 17:08:31',NULL,2,2,NULL,5,'1000.00',NULL,6,NULL),(34,5,'2015-11-14 17:11:00',NULL,2,2,NULL,5,'1000.00',NULL,6,NULL),(35,5,'2015-11-14 17:37:47',NULL,2,2,NULL,5,'480.00',NULL,7,NULL),(36,9,'2015-11-15 19:13:56','2015-11-16 18:29:22',2,2,11,7,'352.00','8.0',NULL,NULL),(37,10,'2015-11-15 19:33:12','2015-11-16 18:15:15',2,2,14,7,'0.00','8.0',NULL,NULL),(38,4,'2015-11-15 19:33:12','2015-11-15 20:10:44',2,2,NULL,7,'0.00',NULL,6,NULL),(39,5,'2015-11-15 19:48:29','2015-11-15 19:52:24',2,2,NULL,7,'100.00',NULL,7,NULL),(40,0,'2015-11-18 10:29:58',NULL,2,2,NULL,5,'1000.00',NULL,1,NULL),(41,0,'2015-11-18 10:30:07',NULL,2,2,NULL,5,'2000.00',NULL,3,NULL),(42,0,'2015-11-18 10:30:19',NULL,2,2,NULL,5,'2000.00',NULL,3,NULL),(43,0,'2015-11-18 10:30:36',NULL,2,2,NULL,5,'2000.00',NULL,3,NULL),(44,0,'2015-11-18 10:30:57',NULL,2,2,NULL,7,'1000.00',NULL,1,NULL);

UNLOCK TABLES;

/*Table structure for table `customleagueroperation` */

DROP TABLE IF EXISTS `customleagueroperation`;

CREATE TABLE `customleagueroperation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customLeaguerDetailId` bigint(20) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `personnelInfoId` bigint(20) DEFAULT NULL,
  `adviserId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `depositId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_customleagueroperation_createrId` (`createrId`),
  KEY `FK_customleagueroperation_belongingId` (`belongingId`),
  KEY `FK_customleagueroperation_customLeaguerDetailId` (`customLeaguerDetailId`),
  KEY `FK_customleagueroperation_personnelInfoId` (`personnelInfoId`),
  KEY `FK_customleagueroperation_adviserId` (`adviserId`),
  KEY `FK_customleagueroperation_depositId` (`depositId`),
  CONSTRAINT `FK_customleagueroperation_adviserId` FOREIGN KEY (`adviserId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_customleagueroperation_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_customleagueroperation_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_customleagueroperation_customLeaguerDetailId` FOREIGN KEY (`customLeaguerDetailId`) REFERENCES `customleaguer_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_customleagueroperation_depositId` FOREIGN KEY (`depositId`) REFERENCES `customleaguer_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_customleagueroperation_personnelInfoId` FOREIGN KEY (`personnelInfoId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `customleagueroperation` */

LOCK TABLES `customleagueroperation` WRITE;

insert  into `customleagueroperation`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`customLeaguerDetailId`,`money`,`state`,`type`,`remark`,`date`,`personnelInfoId`,`adviserId`,`customInfoId`,`depositId`) values (1,0,NULL,NULL,3,3,1,NULL,1,'1',NULL,NULL,1,2,5,NULL),(2,0,NULL,NULL,3,3,2,'58000',1,'1','爱的色放萨芬的撒范德萨发撒地方撒点粉爱上对方士大夫',NULL,1,2,5,NULL),(5,0,NULL,NULL,3,3,6,'4444',1,'2','',NULL,1,2,5,7),(6,0,NULL,NULL,3,3,7,'1111',1,'2','撒地方地方撒点粉爱上对方第三方','2015-11-04',1,2,5,8),(7,0,NULL,NULL,3,3,6,'1111',1,'3','','2015-11-04',1,2,5,NULL),(10,0,NULL,NULL,2,2,7,'8888',1,'1','','2015-11-15',1,2,5,NULL);

UNLOCK TABLES;

/*Table structure for table `depotinfo` */

DROP TABLE IF EXISTS `depotinfo`;

CREATE TABLE `depotinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_depotinfo_createrId` (`createrId`),
  KEY `FK_depotinfo_belongingId` (`belongingId`),
  CONSTRAINT `FK_depotinfo_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_depotinfo_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `depotinfo` */

LOCK TABLES `depotinfo` WRITE;

insert  into `depotinfo`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`name`,`remark`) values (1,1,'2015-10-02 22:57:09','2015-10-09 00:00:00',2,2,'别墅店',''),(2,1,'2015-10-02 22:57:24','2015-10-09 00:00:00',2,2,'保集店',''),(3,1,'2015-10-02 22:57:42','2015-10-09 00:00:00',2,2,'江北店','');

UNLOCK TABLES;

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

LOCK TABLES `entityclass` WRITE;

UNLOCK TABLES;

/*Table structure for table `feedbackrecord` */

DROP TABLE IF EXISTS `feedbackrecord`;

CREATE TABLE `feedbackrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  `marketingProjectId` bigint(20) DEFAULT NULL,
  `productStockId` bigint(20) DEFAULT NULL,
  `personnelInfoId` bigint(20) DEFAULT NULL,
  `adviserId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_feedbackrecord_createrId` (`createrId`),
  KEY `FK_feedbackrecord_belongingId` (`belongingId`),
  KEY `FK_feedbackrecord_customInfoId` (`customInfoId`),
  KEY `FK_feedbackrecord_marketingProjectId` (`marketingProjectId`),
  KEY `FK_feedbackrecord_productStockId` (`productStockId`),
  KEY `FK_feedbackrecord_personnelInfoId` (`personnelInfoId`),
  KEY `FK_feedbackrecord_adviserId` (`adviserId`),
  CONSTRAINT `FK_feedbackrecord_adviserId` FOREIGN KEY (`adviserId`) REFERENCES `personnelinfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_feedbackrecord_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_feedbackrecord_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_feedbackrecord_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_feedbackrecord_marketingProjectId` FOREIGN KEY (`marketingProjectId`) REFERENCES `marketingproject` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_feedbackrecord_personnelInfoId` FOREIGN KEY (`personnelInfoId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_feedbackrecord_productStockId` FOREIGN KEY (`productStockId`) REFERENCES `productstock` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `feedbackrecord` */

LOCK TABLES `feedbackrecord` WRITE;

insert  into `feedbackrecord`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`customInfoId`,`date`,`remark`,`marketingProjectId`,`productStockId`,`personnelInfoId`,`adviserId`) values (1,0,'2015-11-02 13:48:30',NULL,3,3,5,'2015-11-02','',38,4,1,NULL),(2,0,'2015-11-15 19:30:37',NULL,2,2,7,'2015-11-15','回复诶回复IE',46,NULL,1,NULL);

UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `filecontrol` */

LOCK TABLES `filecontrol` WRITE;

insert  into `filecontrol`(`id`,`version`,`createDate`,`updateDate`,`originalName`,`currentName`,`folder`,`type`,`description`,`entityType`,`entityId`,`url`,`suffix`,`sizeLimit`,`encryption`,`encryptionType`,`encryptionPass`,`createrId`,`defaultState`,`entityclassId`,`objectId`,`belongingId`) values (3,0,NULL,NULL,'18.jpg','com.qylm.entity.GeneralIntroduction_2_f07c36f3-f1f3-4a1a-9e14-62b7078a272d.jpg',NULL,'1',NULL,'generalIntroduction',2,'fileUpload\\GeneralIntroduction\\com.qylm.entity.GeneralIntroduction_2_f07c36f3-f1f3-4a1a-9e14-62b7078a272d.jpg','jpg',137324,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(4,0,NULL,NULL,'5.jpg','com.qylm.entity.GeneralDeeds_1_42265dcf-85a5-42fd-bdb7-c8e6c66989b1.jpg',NULL,'1',NULL,NULL,1,'fileUpload\\GeneralDeeds\\com.qylm.entity.GeneralDeeds_1_42265dcf-85a5-42fd-bdb7-c8e6c66989b1.jpg','jpg',189556,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(5,4,NULL,NULL,'5.jpg','com.qylm.entity.Brand_1_b4faae74-c1e1-490d-b617-91af5c626926.jpg',NULL,'1',NULL,'brand',1,'fileUpload\\Brand\\com.qylm.entity.Brand_1_b4faae74-c1e1-490d-b617-91af5c626926.jpg','jpg',189556,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(6,3,'2015-04-05 11:34:47',NULL,'18.jpg','com.qylm.entity.Brand_1_90167986-d3d0-4b46-bcdb-f76e786b88cf.jpg',NULL,'1',NULL,'brand',1,'fileUpload\\Brand\\com.qylm.entity.Brand_1_90167986-d3d0-4b46-bcdb-f76e786b88cf.jpg','jpg',137324,'\0',NULL,NULL,NULL,1,NULL,NULL,NULL),(7,1,'2015-04-05 12:16:43',NULL,'6.jpg','com.qylm.entity.Brand_2_0cd31d89-af36-40a7-90b4-9bb16ad0394f.jpg',NULL,'1',NULL,'brand',2,'fileUpload\\Brand\\com.qylm.entity.Brand_2_0cd31d89-af36-40a7-90b4-9bb16ad0394f.jpg','jpg',156734,'\0',NULL,NULL,NULL,1,NULL,NULL,NULL),(13,0,'2015-04-05 12:46:13',NULL,'13.jpg','com.qylm.entity.Brand_2_df64d865-f4b3-462f-9fb1-596c09379115.jpg',NULL,'1',NULL,'brand',2,'fileUpload\\Brand\\com.qylm.entity.Brand_2_df64d865-f4b3-462f-9fb1-596c09379115.jpg','jpg',106023,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(14,0,'2015-04-05 12:49:19',NULL,'1.jpg','com.qylm.entity.Brand_3_01f84581-2e55-4516-95f1-4946de4c4b6f.jpg',NULL,'1',NULL,'brand',3,'fileUpload\\Brand\\com.qylm.entity.Brand_3_01f84581-2e55-4516-95f1-4946de4c4b6f.jpg','jpg',161239,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(15,0,'2015-04-05 19:07:11',NULL,'13.jpg','com.qylm.entity.Brand_3_9e681769-1347-4b38-bc34-a9b44a6bc63a.jpg',NULL,'1',NULL,'brand',3,'fileUpload\\Brand\\com.qylm.entity.Brand_3_9e681769-1347-4b38-bc34-a9b44a6bc63a.jpg','jpg',106023,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(18,2,'2015-10-03 20:39:11',NULL,'2.jpg','com.qylm.entity.ProductStock_1_6da0ce7b-3b42-4498-b712-62c8b504aacb.jpg',NULL,'1',NULL,'productStock',1,'fileUpload\\ProductStock\\com.qylm.entity.ProductStock_1_6da0ce7b-3b42-4498-b712-62c8b504aacb.jpg','jpg',201231,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(19,2,'2015-10-03 20:39:11',NULL,'3.jpg','com.qylm.entity.ProductStock_1_27c63f86-33b3-4966-ae3b-a24c1df78f0d.jpg',NULL,'1',NULL,'productStock',1,'fileUpload\\ProductStock\\com.qylm.entity.ProductStock_1_27c63f86-33b3-4966-ae3b-a24c1df78f0d.jpg','jpg',71667,'\0',NULL,NULL,NULL,1,NULL,NULL,NULL),(20,2,'2015-10-03 20:39:11',NULL,'1.jpg','com.qylm.entity.ProductStock_1_239ec3a2-83ab-487d-b2e8-583353afca29.jpg',NULL,'1',NULL,'productStock',1,'fileUpload\\ProductStock\\com.qylm.entity.ProductStock_1_239ec3a2-83ab-487d-b2e8-583353afca29.jpg','jpg',99401,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(21,1,'2015-10-03 21:13:41',NULL,'2.jpg','com.qylm.entity.ProductStock_2_ce97362c-d457-4037-904c-d1afb58412cd.jpg',NULL,'1',NULL,'productStock',2,'fileUpload\\ProductStock\\com.qylm.entity.ProductStock_2_ce97362c-d457-4037-904c-d1afb58412cd.jpg','jpg',201231,'\0',NULL,NULL,NULL,1,NULL,NULL,NULL),(22,1,'2015-10-03 21:13:44',NULL,'1.jpg','com.qylm.entity.ProductStock_2_1f415b51-4648-40cf-bc76-acd43f67eb91.jpg',NULL,'1',NULL,'productStock',2,'fileUpload\\ProductStock\\com.qylm.entity.ProductStock_2_1f415b51-4648-40cf-bc76-acd43f67eb91.jpg','jpg',99401,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL),(23,0,'2015-10-24 15:47:44',NULL,'2.jpg','com.qylm.entity.ProductStock_4_042f5985-0b61-495d-a244-473dfa3d8b08.jpg',NULL,'1',NULL,'productStock',4,'fileUpload\\ProductStock\\com.qylm.entity.ProductStock_4_042f5985-0b61-495d-a244-473dfa3d8b08.jpg','jpg',201231,'\0',NULL,NULL,NULL,0,NULL,NULL,NULL);

UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

/*Data for the table `function` */

LOCK TABLES `function` WRITE;

insert  into `function`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`treeItemId`,`label`,`enable`,`rank`,`belongingId`) values (2,0,'2015-04-01 00:00:00',NULL,1,9,'添加',0,1,NULL),(3,0,'2015-04-01 00:00:00',NULL,1,9,'修改',0,2,NULL),(4,0,'2015-04-01 00:00:00',NULL,1,9,'删除',0,3,NULL),(5,0,'2015-04-01 00:00:00',NULL,1,2,'添加',0,1,NULL),(6,0,'2015-04-01 00:00:00',NULL,1,2,'删除',0,2,NULL),(7,0,'2015-04-01 00:00:00',NULL,1,3,'添加',0,1,NULL),(8,0,'2015-04-01 00:00:00',NULL,1,3,'删除',0,2,NULL),(9,0,'2015-04-01 00:00:00',NULL,1,12,'添加',0,1,NULL),(10,0,'2015-04-01 00:00:00',NULL,1,12,'修改',0,2,NULL),(11,0,'2015-04-01 00:00:00',NULL,1,12,'删除',0,3,NULL),(12,0,'2015-11-01 00:00:00',NULL,1,63,'添加',0,1,NULL),(13,0,'2015-11-01 00:00:00',NULL,1,63,'修改',0,2,NULL),(14,0,'2015-11-01 00:00:00',NULL,1,63,'删除',0,3,NULL),(15,0,'2015-11-01 00:00:00',NULL,1,64,'添加',0,1,NULL),(16,0,'2015-11-01 00:00:00',NULL,1,64,'修改',0,2,NULL),(17,0,'2015-11-01 00:00:00',NULL,1,64,'删除',0,3,NULL),(18,0,'2015-11-01 00:00:00',NULL,1,63,'查询',0,4,NULL),(19,0,'2015-11-01 00:00:00',NULL,1,64,'查询',0,4,NULL),(20,0,'2015-11-01 00:00:00',NULL,1,66,'添加',0,1,NULL),(21,0,'2015-11-01 00:00:00',NULL,1,66,'修改',0,2,NULL),(22,0,'2015-11-01 00:00:00',NULL,1,66,'删除',0,3,NULL),(23,0,'2015-11-01 00:00:00',NULL,1,66,'查询',0,4,NULL),(24,0,'2015-11-01 00:00:00',NULL,1,65,'添加',0,1,NULL),(25,0,'2015-11-01 00:00:00',NULL,1,65,'修改',0,2,NULL),(26,0,'2015-11-01 00:00:00',NULL,1,65,'删除',0,3,NULL),(27,0,'2015-11-01 00:00:00',NULL,1,65,'查询',0,4,NULL),(28,0,'2015-11-01 00:00:00',NULL,1,67,'添加',0,1,NULL),(29,0,'2015-11-01 00:00:00',NULL,1,67,'修改',0,2,NULL),(30,0,'2015-11-01 00:00:00',NULL,1,67,'删除',0,3,NULL),(31,0,'2015-11-01 00:00:00',NULL,1,67,'查询',0,4,NULL),(32,0,'2015-11-01 00:00:00',NULL,1,68,'添加',0,1,NULL),(33,0,'2015-11-01 00:00:00',NULL,1,68,'修改',0,2,NULL),(34,0,'2015-11-01 00:00:00',NULL,1,68,'删除',0,3,NULL),(35,0,'2015-11-01 00:00:00',NULL,1,68,'查询',0,4,NULL),(36,0,'2015-11-01 00:00:00',NULL,1,69,'添加',0,1,NULL),(37,1,'2015-11-01 00:00:00',NULL,1,69,'修改',0,2,NULL),(38,0,'2015-11-01 00:00:00',NULL,1,69,'删除',0,3,NULL),(39,0,'2015-11-01 00:00:00',NULL,1,69,'查询',0,4,NULL),(40,0,'2015-11-01 00:00:00',NULL,1,72,'添加',0,1,NULL),(41,0,'2015-11-01 00:00:00',NULL,1,72,'修改',0,2,NULL),(42,0,'2015-11-01 00:00:00',NULL,1,72,'删除',0,3,NULL),(43,0,'2015-11-01 00:00:00',NULL,1,72,'查询',0,4,NULL),(44,0,'2015-11-01 00:00:00',NULL,1,73,'添加',0,1,NULL),(45,0,'2015-11-01 00:00:00',NULL,1,73,'修改',0,2,NULL),(46,0,'2015-11-01 00:00:00',NULL,1,73,'删除',0,3,NULL),(47,0,'2015-11-01 00:00:00',NULL,1,73,'查询',0,4,NULL),(48,0,'2015-11-01 00:00:00',NULL,1,70,'添加',0,1,NULL),(49,0,'2015-11-01 00:00:00',NULL,1,70,'修改',0,2,NULL),(50,0,'2015-11-01 00:00:00',NULL,1,70,'删除',0,3,NULL),(51,0,'2015-11-01 00:00:00',NULL,1,70,'查询',0,4,NULL),(52,0,'2015-11-01 00:00:00',NULL,1,70,'转店',0,5,NULL),(53,0,'2015-11-01 00:00:00',NULL,1,51,'添加',0,1,NULL),(54,0,'2015-11-01 00:00:00',NULL,1,51,'修改',0,2,NULL),(55,0,'2015-11-01 00:00:00',NULL,1,51,'删除',0,3,NULL),(56,0,'2015-11-01 00:00:00',NULL,1,51,'查询',0,4,NULL),(57,0,'2015-11-01 00:00:00',NULL,1,16,'',1,NULL,NULL),(58,0,'2015-11-01 00:00:00',NULL,1,16,'',0,NULL,NULL),(59,0,'2015-11-01 00:00:00',NULL,1,45,'删除',0,1,NULL),(60,0,'2015-11-01 00:00:00',NULL,1,45,'查询',0,2,NULL),(61,0,'2015-11-01 00:00:00',NULL,1,46,'删除',0,1,NULL),(62,0,'2015-11-01 00:00:00',NULL,1,46,'查询',0,2,NULL),(63,0,'2015-11-01 00:00:00',NULL,1,47,'删除',0,1,NULL),(64,0,'2015-11-01 00:00:00',NULL,1,47,'查询',0,2,NULL),(65,0,'2015-11-01 00:00:00',NULL,1,48,'删除',0,1,NULL),(66,0,'2015-11-01 00:00:00',NULL,1,48,'查询',0,2,NULL),(67,0,'2015-11-01 00:00:00',NULL,1,49,'删除',0,1,NULL),(68,0,'2015-11-01 00:00:00',NULL,1,49,'查询',0,2,NULL),(69,0,'2015-11-01 00:00:00',NULL,1,58,'删除',0,1,NULL),(70,0,'2015-11-01 00:00:00',NULL,1,58,'查询',0,2,NULL),(71,0,'2015-11-01 00:00:00',NULL,1,59,'删除',0,1,NULL),(72,0,'2015-11-01 00:00:00',NULL,1,59,'查询',0,2,NULL),(73,0,'2015-11-01 00:00:00',NULL,1,60,'删除',0,1,NULL),(74,0,'2015-11-01 00:00:00',NULL,1,60,'查询',0,2,NULL);

UNLOCK TABLES;

/*Table structure for table `giveinfo` */

DROP TABLE IF EXISTS `giveinfo`;

CREATE TABLE `giveinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `rebate` decimal(10,1) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL,
  `giveInfoId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_giveinfo_createrId` (`createrId`),
  KEY `FK_giveinfo_belongingId` (`belongingId`),
  KEY `FK_giveinfo_giveInfoId` (`giveInfoId`),
  CONSTRAINT `FK_giveinfo_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_giveinfo_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_giveinfo_giveInfoId` FOREIGN KEY (`giveInfoId`) REFERENCES `giveinfo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `giveinfo` */

LOCK TABLES `giveinfo` WRITE;

insert  into `giveinfo`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`title`,`money`,`rebate`,`type`,`giveInfoId`) values (1,0,'2015-10-24 16:04:25',NULL,1,NULL,'1000体验卡','1000.00','10.0','1',NULL),(3,0,'2015-10-24 16:04:57',NULL,1,NULL,'2000体验卡','2000.00','8.0','1',NULL),(5,1,'2015-10-31 14:29:21','2015-10-31 00:00:00',2,2,'1000体验卡','1000.00',NULL,'1',NULL),(6,0,'2015-10-31 14:29:34',NULL,2,2,'1000现金卷','1000.00',NULL,'2',NULL),(7,0,'2015-10-31 14:30:02',NULL,2,2,'480身体卷','480.00',NULL,'3',NULL);

UNLOCK TABLES;

/*Table structure for table `giveinfo_detail` */

DROP TABLE IF EXISTS `giveinfo_detail`;

CREATE TABLE `giveinfo_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `giveInfoId` bigint(20) DEFAULT NULL,
  `marketingProjectId` bigint(20) DEFAULT NULL,
  `productStockDetailId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_giveinfo_detail_createrId` (`createrId`),
  KEY `FK_giveinfo_detail_belongingId` (`belongingId`),
  KEY `FK_giveinfo_detail_giveInfoId` (`giveInfoId`),
  KEY `FK_giveinfo_detail_marketingProjectId` (`marketingProjectId`),
  KEY `FK_giveinfo_detail_productStockDetailId` (`productStockDetailId`),
  CONSTRAINT `FK_giveinfo_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_giveinfo_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_giveinfo_detail_giveInfoId` FOREIGN KEY (`giveInfoId`) REFERENCES `giveinfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_giveinfo_detail_marketingProjectId` FOREIGN KEY (`marketingProjectId`) REFERENCES `marketingproject` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_giveinfo_detail_productStockDetailId` FOREIGN KEY (`productStockDetailId`) REFERENCES `productstock_detail` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8;

/*Data for the table `giveinfo_detail` */

LOCK TABLES `giveinfo_detail` WRITE;

insert  into `giveinfo_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`giveInfoId`,`marketingProjectId`,`productStockDetailId`,`number`) values (1,0,NULL,NULL,1,NULL,1,8,NULL,NULL),(2,0,NULL,NULL,1,NULL,1,9,NULL,NULL),(3,0,NULL,NULL,1,NULL,1,10,NULL,NULL),(4,0,NULL,NULL,1,NULL,1,11,NULL,NULL),(5,0,NULL,NULL,1,NULL,1,12,NULL,NULL),(6,0,NULL,NULL,1,NULL,1,14,NULL,NULL),(7,0,NULL,NULL,1,NULL,1,15,NULL,NULL),(8,0,NULL,NULL,1,NULL,1,16,NULL,NULL),(9,0,NULL,NULL,1,NULL,1,17,NULL,NULL),(10,0,NULL,NULL,1,NULL,1,18,NULL,NULL),(11,0,NULL,NULL,1,NULL,1,19,NULL,NULL),(12,0,NULL,NULL,1,NULL,1,20,NULL,NULL),(13,0,NULL,NULL,1,NULL,1,21,NULL,NULL),(14,0,NULL,NULL,1,NULL,1,22,NULL,NULL),(15,0,NULL,NULL,1,NULL,1,23,NULL,NULL),(16,0,NULL,NULL,1,NULL,1,24,NULL,NULL),(17,0,NULL,NULL,1,NULL,1,25,NULL,NULL),(18,0,NULL,NULL,1,NULL,1,26,NULL,NULL),(19,0,NULL,NULL,1,NULL,1,27,NULL,NULL),(20,0,NULL,NULL,1,NULL,1,28,NULL,NULL),(21,0,NULL,NULL,1,NULL,1,29,NULL,NULL),(22,0,NULL,NULL,1,NULL,1,30,NULL,NULL),(23,0,NULL,NULL,1,NULL,1,31,NULL,NULL),(24,0,NULL,NULL,1,NULL,1,32,NULL,NULL),(25,0,NULL,NULL,1,NULL,1,33,NULL,NULL),(26,0,NULL,NULL,1,NULL,1,34,NULL,NULL),(27,0,NULL,NULL,1,NULL,1,35,NULL,NULL),(28,0,NULL,NULL,1,NULL,1,36,NULL,NULL),(29,0,NULL,NULL,1,NULL,1,37,NULL,NULL),(30,0,NULL,NULL,1,NULL,1,38,NULL,NULL),(31,0,NULL,NULL,1,NULL,1,39,NULL,NULL),(32,0,NULL,NULL,1,NULL,1,40,NULL,NULL),(33,0,NULL,NULL,1,NULL,1,41,NULL,NULL),(34,0,NULL,NULL,1,NULL,1,42,NULL,NULL),(35,0,NULL,NULL,1,NULL,1,43,NULL,NULL),(36,0,NULL,NULL,1,NULL,1,44,NULL,NULL),(37,0,NULL,NULL,1,NULL,1,46,NULL,NULL),(38,0,NULL,NULL,1,NULL,1,47,NULL,NULL),(39,0,NULL,NULL,1,NULL,3,8,NULL,NULL),(40,0,NULL,NULL,1,NULL,3,9,NULL,NULL),(41,0,NULL,NULL,1,NULL,3,10,NULL,NULL),(42,0,NULL,NULL,1,NULL,3,11,NULL,NULL),(43,0,NULL,NULL,1,NULL,3,12,NULL,NULL),(44,0,NULL,NULL,1,NULL,3,14,NULL,NULL),(45,0,NULL,NULL,1,NULL,3,15,NULL,NULL),(46,0,NULL,NULL,1,NULL,3,16,NULL,NULL),(47,0,NULL,NULL,1,NULL,3,17,NULL,NULL),(48,0,NULL,NULL,1,NULL,3,18,NULL,NULL),(49,0,NULL,NULL,1,NULL,3,19,NULL,NULL),(50,0,NULL,NULL,1,NULL,3,20,NULL,NULL),(51,0,NULL,NULL,1,NULL,3,21,NULL,NULL),(52,0,NULL,NULL,1,NULL,3,22,NULL,NULL),(53,0,NULL,NULL,1,NULL,3,23,NULL,NULL),(54,0,NULL,NULL,1,NULL,3,24,NULL,NULL),(55,0,NULL,NULL,1,NULL,3,25,NULL,NULL),(56,0,NULL,NULL,1,NULL,3,26,NULL,NULL),(57,0,NULL,NULL,1,NULL,3,27,NULL,NULL),(58,0,NULL,NULL,1,NULL,3,28,NULL,NULL),(59,0,NULL,NULL,1,NULL,3,29,NULL,NULL),(60,0,NULL,NULL,1,NULL,3,30,NULL,NULL),(61,0,NULL,NULL,1,NULL,3,31,NULL,NULL),(62,0,NULL,NULL,1,NULL,3,32,NULL,NULL),(63,0,NULL,NULL,1,NULL,3,33,NULL,NULL),(64,0,NULL,NULL,1,NULL,3,34,NULL,NULL),(65,0,NULL,NULL,1,NULL,3,35,NULL,NULL),(66,0,NULL,NULL,1,NULL,3,36,NULL,NULL),(67,0,NULL,NULL,1,NULL,3,37,NULL,NULL),(68,0,NULL,NULL,1,NULL,3,38,NULL,NULL),(69,0,NULL,NULL,1,NULL,3,39,NULL,NULL),(70,0,NULL,NULL,1,NULL,3,40,NULL,NULL),(71,0,NULL,NULL,1,NULL,3,41,NULL,NULL),(72,0,NULL,NULL,1,NULL,3,42,NULL,NULL),(73,0,NULL,NULL,1,NULL,3,43,NULL,NULL),(74,0,NULL,NULL,1,NULL,3,44,NULL,NULL),(75,0,NULL,NULL,1,NULL,3,46,NULL,NULL),(76,0,NULL,NULL,1,NULL,3,47,NULL,NULL),(147,1,'2015-10-31 20:07:05',NULL,2,1,5,41,NULL,1),(148,1,'2015-10-31 20:07:05',NULL,2,1,5,42,NULL,1),(149,1,'2015-10-31 20:07:05',NULL,2,1,5,43,NULL,1),(151,1,'2015-10-31 20:07:05',NULL,2,1,5,46,NULL,1),(152,1,'2015-10-31 20:07:05',NULL,2,1,5,47,NULL,1),(153,0,NULL,NULL,2,1,6,8,NULL,NULL),(154,0,NULL,NULL,2,1,6,9,NULL,NULL),(155,0,NULL,NULL,2,1,6,10,NULL,NULL),(156,0,NULL,NULL,2,1,6,11,NULL,NULL),(157,0,NULL,NULL,2,1,6,12,NULL,NULL),(158,0,NULL,NULL,2,1,6,14,NULL,NULL),(159,0,NULL,NULL,2,1,6,15,NULL,NULL),(160,0,NULL,NULL,2,1,6,16,NULL,NULL),(161,0,NULL,NULL,2,1,6,17,NULL,NULL),(162,0,NULL,NULL,2,1,6,18,NULL,NULL),(163,0,NULL,NULL,2,1,6,19,NULL,NULL),(164,0,NULL,NULL,2,1,6,20,NULL,NULL),(165,0,NULL,NULL,2,1,6,21,NULL,NULL),(166,0,NULL,NULL,2,1,6,22,NULL,NULL),(167,0,NULL,NULL,2,1,6,23,NULL,NULL),(168,0,NULL,NULL,2,1,6,24,NULL,NULL),(169,0,NULL,NULL,2,1,6,25,NULL,NULL),(170,0,NULL,NULL,2,1,6,26,NULL,NULL),(171,0,NULL,NULL,2,1,6,27,NULL,NULL),(172,0,NULL,NULL,2,1,6,28,NULL,NULL),(173,0,NULL,NULL,2,1,6,29,NULL,NULL),(174,0,NULL,NULL,2,1,6,30,NULL,NULL),(175,0,NULL,NULL,2,1,6,31,NULL,NULL),(176,0,NULL,NULL,2,1,6,32,NULL,NULL),(177,0,NULL,NULL,2,1,6,33,NULL,NULL),(178,0,NULL,NULL,2,1,6,34,NULL,NULL),(179,0,NULL,NULL,2,1,6,35,NULL,NULL),(180,0,NULL,NULL,2,1,6,36,NULL,NULL),(181,0,NULL,NULL,2,1,6,37,NULL,NULL),(182,0,NULL,NULL,2,1,6,38,NULL,NULL),(183,0,NULL,NULL,2,1,6,39,NULL,NULL),(184,0,NULL,NULL,2,1,6,40,NULL,NULL),(185,0,NULL,NULL,2,1,6,41,NULL,NULL),(186,0,NULL,NULL,2,1,6,42,NULL,NULL),(187,0,NULL,NULL,2,1,6,43,NULL,NULL),(188,0,NULL,NULL,2,1,6,44,NULL,NULL),(189,0,NULL,NULL,2,1,6,46,NULL,NULL),(190,0,NULL,NULL,2,1,6,47,NULL,NULL),(191,0,NULL,NULL,2,1,7,8,NULL,NULL),(192,0,NULL,NULL,2,1,7,9,NULL,NULL),(193,0,NULL,NULL,2,1,7,10,NULL,NULL),(194,0,NULL,NULL,2,1,7,11,NULL,NULL),(195,0,NULL,NULL,2,1,7,12,NULL,NULL),(196,0,NULL,NULL,2,1,7,14,NULL,NULL),(197,0,NULL,NULL,2,1,7,15,NULL,NULL),(198,0,NULL,NULL,2,1,7,16,NULL,NULL),(199,0,NULL,NULL,2,1,7,17,NULL,NULL),(200,0,NULL,NULL,2,1,7,18,NULL,NULL),(201,0,NULL,NULL,2,1,7,19,NULL,NULL),(202,0,NULL,NULL,2,1,7,20,NULL,NULL),(203,0,NULL,NULL,2,1,7,21,NULL,NULL),(204,0,NULL,NULL,2,1,7,22,NULL,NULL),(205,0,NULL,NULL,2,1,7,23,NULL,NULL),(206,0,NULL,NULL,2,1,7,24,NULL,NULL),(207,0,NULL,NULL,2,1,7,25,NULL,NULL),(208,0,NULL,NULL,2,1,7,26,NULL,NULL),(209,0,NULL,NULL,2,1,7,27,NULL,NULL),(210,0,NULL,NULL,2,1,7,28,NULL,NULL),(211,0,NULL,NULL,2,1,7,29,NULL,NULL),(212,0,NULL,NULL,2,1,7,30,NULL,NULL),(213,0,NULL,NULL,2,1,7,31,NULL,NULL),(214,0,NULL,NULL,2,1,7,32,NULL,NULL),(215,0,NULL,NULL,2,1,7,33,NULL,NULL),(216,0,NULL,NULL,2,1,7,34,NULL,NULL),(217,0,NULL,NULL,2,1,7,35,NULL,NULL),(218,0,NULL,NULL,2,1,7,36,NULL,NULL),(219,0,NULL,NULL,2,1,7,37,NULL,NULL),(220,0,NULL,NULL,2,1,7,38,NULL,NULL),(221,0,NULL,NULL,2,1,7,39,NULL,NULL),(222,0,NULL,NULL,2,1,7,40,NULL,NULL),(223,0,NULL,NULL,2,1,7,41,NULL,NULL),(224,0,NULL,NULL,2,1,7,42,NULL,NULL),(225,0,NULL,NULL,2,1,7,43,NULL,NULL),(226,0,NULL,NULL,2,1,7,44,NULL,NULL),(227,0,NULL,NULL,2,1,7,46,NULL,NULL),(228,0,NULL,NULL,2,1,7,47,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `largessrecord` */

DROP TABLE IF EXISTS `largessrecord`;

CREATE TABLE `largessrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `marketingProjectId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `surplusNumber` bigint(20) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  `personnelInfo1Id` bigint(20) DEFAULT NULL,
  `personnelInfo2Id` bigint(20) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_largessrecord_createrId` (`createrId`),
  KEY `FK_largessrecord_belongingId` (`belongingId`),
  KEY `FK_largessrecord_customInfoId` (`customInfoId`),
  KEY `FK_largessrecord_marketingProjectId` (`marketingProjectId`),
  KEY `FK_largessrecord_personnelInfo1Id` (`personnelInfo1Id`),
  KEY `FK_largessrecord_personnelInfo2Id` (`personnelInfo2Id`),
  CONSTRAINT `FK_largessrecord_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_largessrecord_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_largessrecord_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_largessrecord_marketingProjectId` FOREIGN KEY (`marketingProjectId`) REFERENCES `marketingproject` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_largessrecord_personnelInfo1Id` FOREIGN KEY (`personnelInfo1Id`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_largessrecord_personnelInfo2Id` FOREIGN KEY (`personnelInfo2Id`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=utf8;

/*Data for the table `largessrecord` */

LOCK TABLES `largessrecord` WRITE;

insert  into `largessrecord`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`customInfoId`,`date`,`marketingProjectId`,`number`,`money`,`surplusNumber`,`balance`,`personnelInfo1Id`,`personnelInfo2Id`,`remark`) values (81,0,'2015-11-07 13:35:44',NULL,3,3,NULL,NULL,8,1,'1280.00',1,NULL,NULL,NULL,NULL),(84,1,'2015-11-07 13:50:48','2015-11-16 19:17:43',3,3,5,NULL,8,1,'1280.00',0,NULL,NULL,NULL,NULL),(85,1,'2015-11-08 22:24:12','2015-11-16 19:13:29',2,2,5,NULL,10,1,'580.00',0,NULL,NULL,NULL,NULL),(86,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(87,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(88,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(89,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(90,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(91,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(92,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(93,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,16,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(94,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,17,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(95,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,18,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(96,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,19,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(97,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,20,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(98,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,21,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(99,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,22,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(100,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,23,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(101,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,24,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(102,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,25,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(103,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,26,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(104,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,27,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(105,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,28,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(106,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,29,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(107,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,30,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(108,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,31,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(109,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,32,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(110,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,33,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(111,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,34,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(112,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,35,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(113,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,36,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(114,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,37,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(115,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,38,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(116,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,39,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(117,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,40,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(118,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,41,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(119,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,42,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(120,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,43,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(121,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,44,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(122,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,46,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(123,0,'2015-11-08 22:24:12',NULL,2,2,5,NULL,47,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(124,1,'2015-11-09 15:34:44','2015-11-17 15:03:11',2,2,5,NULL,10,1,'580.00',0,NULL,NULL,NULL,NULL),(125,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(126,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(127,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(128,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(129,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(130,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(131,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(132,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,16,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(133,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,17,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(134,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,18,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(135,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,19,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(136,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,20,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(137,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,21,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(138,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,22,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(139,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,23,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(140,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,24,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(141,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,25,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(142,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,26,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(143,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,27,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(144,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,28,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(145,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,29,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(146,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,30,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(147,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,31,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(148,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,32,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(149,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,33,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(150,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,34,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(151,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,35,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(152,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,36,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(153,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,37,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(154,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,38,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(155,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,39,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(156,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,40,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(157,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,41,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(158,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,42,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(159,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,43,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(160,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,44,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(161,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,46,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(162,0,'2015-11-09 15:34:44',NULL,2,2,5,NULL,47,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(163,1,'2015-11-09 16:36:15','2015-11-17 15:03:14',2,2,5,NULL,10,1,'580.00',0,NULL,NULL,NULL,NULL),(164,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(165,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(166,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(167,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(168,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(169,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(170,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(171,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,16,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(172,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,17,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(173,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,18,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(174,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,19,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(175,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,20,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(176,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,21,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(177,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,22,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(178,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,23,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(179,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,24,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(180,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,25,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(181,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,26,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(182,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,27,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(183,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,28,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(184,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,29,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(185,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,30,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(186,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,31,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(187,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,32,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(188,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,33,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(189,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,34,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(190,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,35,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(191,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,36,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(192,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,37,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(193,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,38,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(194,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,39,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(195,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,40,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(196,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,41,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(197,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,42,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(198,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,43,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(199,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,44,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(200,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,46,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201,0,'2015-11-09 16:36:15',NULL,2,2,5,NULL,47,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(202,0,'2015-11-10 09:45:16',NULL,2,2,5,NULL,10,1,'580.00',1,NULL,NULL,NULL,NULL),(203,0,'2015-11-10 09:50:21',NULL,2,2,5,NULL,10,1,'580.00',1,NULL,NULL,NULL,NULL),(204,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(205,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(206,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(207,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(208,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,12,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(209,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,14,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(210,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,15,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(211,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,16,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(212,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,17,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(213,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,18,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(214,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,19,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(215,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,20,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(216,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,21,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(217,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,22,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(218,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,23,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(219,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,24,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(220,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,25,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(221,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,26,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(222,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,27,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(223,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,28,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(224,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,29,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(225,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,30,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(226,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,31,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(227,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,32,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(228,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,33,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(229,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,34,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(230,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,35,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(231,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,36,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(232,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,37,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(233,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,38,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(234,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,39,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(235,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,40,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(236,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,41,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(237,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,42,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(238,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,43,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(239,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,44,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(240,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,46,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(241,0,'2015-11-10 09:50:22',NULL,2,2,5,NULL,47,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(242,0,'2015-11-10 10:50:02',NULL,2,2,5,NULL,10,1,'580.00',1,NULL,NULL,NULL,NULL),(243,0,'2015-11-10 10:57:12',NULL,2,2,5,NULL,10,1,'580.00',1,NULL,NULL,NULL,NULL),(244,0,'2015-11-10 13:31:42',NULL,2,2,5,NULL,8,1,'1280.00',1,NULL,NULL,NULL,NULL),(245,1,'2015-11-15 19:13:56','2015-11-16 09:02:40',2,2,7,NULL,10,1,'580.00',0,NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `leaguer` */

DROP TABLE IF EXISTS `leaguer`;

CREATE TABLE `leaguer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `level` varchar(20) DEFAULT NULL,
  `rebate` decimal(10,1) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_leaguer_createrId` (`createrId`),
  KEY `FK_leaguer_belongingId` (`belongingId`),
  CONSTRAINT `FK_leaguer_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `leaguer` */

LOCK TABLES `leaguer` WRITE;

insert  into `leaguer`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`level`,`rebate`,`belongingId`,`money`) values (11,8,'2015-10-09 10:00:47','2015-10-31 00:00:00',2,'会员卡','8.0',2,'5555'),(12,1,'2015-10-24 15:53:44','2015-10-25 00:00:00',1,'综合卡','6.0',NULL,'58000'),(13,0,'2015-11-07 13:17:33',NULL,2,'综合卡 ','4.5',2,'5800'),(14,0,'2015-11-15 19:32:04',NULL,2,'5000充值卡','8.0',2,'5000');

UNLOCK TABLES;

/*Table structure for table `leaguer_detail` */

DROP TABLE IF EXISTS `leaguer_detail`;

CREATE TABLE `leaguer_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `leaguerId` bigint(20) DEFAULT NULL,
  `marketingProjectId` bigint(20) DEFAULT NULL,
  `rebate` decimal(10,2) DEFAULT NULL,
  `productStockId` bigint(20) DEFAULT NULL,
  `state` tinyint(1) DEFAULT '0',
  `number` bigint(20) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `giveInfoId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_leaguer_detail_leaguerId` (`leaguerId`),
  KEY `FK_leaguer_detail_marketingProjectId` (`marketingProjectId`),
  KEY `FK_leaguer_detail_createrId` (`createrId`),
  KEY `FK_leaguer_detail_belongingId` (`belongingId`),
  KEY `FK_leaguer_detail_productStockId` (`productStockId`),
  KEY `FK_leaguer_detail_giveInfoId` (`giveInfoId`),
  CONSTRAINT `FK_leaguer_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_detail_giveInfoId` FOREIGN KEY (`giveInfoId`) REFERENCES `giveinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_detail_leaguerId` FOREIGN KEY (`leaguerId`) REFERENCES `leaguer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_detail_marketingProjectId` FOREIGN KEY (`marketingProjectId`) REFERENCES `marketingproject` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_detail_productStockId` FOREIGN KEY (`productStockId`) REFERENCES `productstock` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8;

/*Data for the table `leaguer_detail` */

LOCK TABLES `leaguer_detail` WRITE;

insert  into `leaguer_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`leaguerId`,`marketingProjectId`,`rebate`,`productStockId`,`state`,`number`,`money`,`giveInfoId`) values (31,2,'2015-10-31 19:39:43',NULL,2,1,11,8,NULL,NULL,0,NULL,NULL,NULL),(32,2,'2015-10-31 19:39:43',NULL,2,1,11,9,NULL,NULL,0,NULL,NULL,NULL),(33,2,'2015-10-31 19:39:43',NULL,2,1,11,10,NULL,NULL,0,NULL,NULL,NULL),(34,2,'2015-10-31 19:39:43',NULL,2,1,11,11,NULL,NULL,0,NULL,NULL,NULL),(35,2,'2015-10-31 19:39:43',NULL,2,1,11,12,NULL,NULL,0,NULL,NULL,NULL),(36,2,'2015-10-31 19:39:43',NULL,2,1,11,14,NULL,NULL,0,NULL,NULL,NULL),(37,2,'2015-10-31 19:39:43',NULL,2,1,11,15,NULL,NULL,0,NULL,NULL,NULL),(38,2,'2015-10-31 19:39:43',NULL,2,1,11,16,NULL,NULL,0,NULL,NULL,NULL),(39,2,'2015-10-31 19:39:43',NULL,2,1,11,17,NULL,NULL,0,NULL,NULL,NULL),(40,2,'2015-10-31 19:39:43',NULL,2,1,11,18,NULL,NULL,0,NULL,NULL,NULL),(41,2,'2015-10-31 19:39:43',NULL,2,1,11,19,NULL,NULL,0,NULL,NULL,NULL),(42,2,'2015-10-31 19:39:43',NULL,2,1,11,20,NULL,NULL,0,NULL,NULL,NULL),(43,2,'2015-10-31 19:39:43',NULL,2,1,11,21,NULL,NULL,0,NULL,NULL,NULL),(44,2,'2015-10-31 19:39:43',NULL,2,1,11,22,NULL,NULL,0,NULL,NULL,NULL),(45,2,'2015-10-31 19:39:43',NULL,2,1,11,23,NULL,NULL,0,NULL,NULL,NULL),(46,2,'2015-10-31 19:39:43',NULL,2,1,11,24,NULL,NULL,0,NULL,NULL,NULL),(47,2,'2015-10-31 19:39:43',NULL,2,1,11,25,NULL,NULL,0,NULL,NULL,NULL),(48,2,'2015-10-31 19:39:43',NULL,2,1,11,26,NULL,NULL,0,NULL,NULL,NULL),(49,2,'2015-10-31 19:39:43',NULL,2,1,11,27,NULL,NULL,0,NULL,NULL,NULL),(50,2,'2015-10-31 19:39:43',NULL,2,1,11,28,NULL,NULL,0,NULL,NULL,NULL),(51,2,'2015-10-31 19:39:43',NULL,2,1,11,29,NULL,NULL,0,NULL,NULL,NULL),(52,2,'2015-10-31 19:39:43',NULL,2,1,11,30,NULL,NULL,0,NULL,NULL,NULL),(53,2,'2015-10-31 19:39:43',NULL,2,1,11,31,NULL,NULL,0,NULL,NULL,NULL),(54,2,'2015-10-31 19:39:43',NULL,2,1,11,32,NULL,NULL,0,NULL,NULL,NULL),(55,2,'2015-10-31 19:39:43',NULL,2,1,11,33,NULL,NULL,0,NULL,NULL,NULL),(56,2,'2015-10-31 19:39:43',NULL,2,1,11,34,NULL,NULL,0,NULL,NULL,NULL),(57,2,'2015-10-31 19:39:43',NULL,2,1,11,35,NULL,NULL,0,NULL,NULL,NULL),(58,2,'2015-10-31 19:39:43',NULL,2,1,11,36,NULL,NULL,0,NULL,NULL,NULL),(59,2,'2015-10-31 19:39:43',NULL,2,1,11,37,NULL,NULL,0,NULL,NULL,NULL),(60,2,'2015-10-31 19:39:43',NULL,2,1,11,38,NULL,NULL,0,NULL,NULL,NULL),(61,2,'2015-10-31 19:39:43',NULL,2,1,11,39,NULL,NULL,0,NULL,NULL,NULL),(62,2,'2015-10-31 19:39:43',NULL,2,1,11,40,NULL,NULL,0,NULL,NULL,NULL),(63,2,'2015-10-31 19:39:43',NULL,2,1,11,41,NULL,NULL,0,NULL,NULL,NULL),(64,2,'2015-10-31 19:39:43',NULL,2,1,11,42,NULL,NULL,0,NULL,NULL,NULL),(65,2,'2015-10-31 19:39:43',NULL,2,1,11,43,NULL,NULL,0,NULL,NULL,NULL),(66,2,'2015-10-31 19:39:43',NULL,2,1,11,44,NULL,NULL,0,NULL,NULL,NULL),(67,2,'2015-10-31 19:39:43',NULL,2,1,11,46,NULL,NULL,0,NULL,NULL,NULL),(68,2,'2015-10-31 19:39:43',NULL,2,1,11,47,NULL,NULL,0,NULL,NULL,NULL),(71,2,'2015-10-31 19:39:43',NULL,2,1,11,NULL,NULL,4,0,NULL,NULL,NULL),(72,1,'2015-10-25 09:37:28',NULL,1,NULL,12,8,'5.00',NULL,0,NULL,NULL,NULL),(73,1,'2015-10-25 09:37:28',NULL,1,NULL,12,9,'6.00',NULL,0,NULL,NULL,NULL),(74,1,'2015-10-25 09:37:28',NULL,1,NULL,12,10,'7.00',NULL,0,NULL,NULL,NULL),(75,1,'2015-10-25 09:37:28',NULL,1,NULL,12,11,NULL,NULL,0,NULL,NULL,NULL),(76,1,'2015-10-25 09:37:28',NULL,1,NULL,12,12,NULL,NULL,0,NULL,NULL,NULL),(77,1,'2015-10-25 09:37:28',NULL,1,NULL,12,14,NULL,NULL,0,NULL,NULL,NULL),(78,1,'2015-10-25 09:37:28',NULL,1,NULL,12,15,NULL,NULL,0,NULL,NULL,NULL),(79,1,'2015-10-25 09:37:28',NULL,1,NULL,12,16,NULL,NULL,0,NULL,NULL,NULL),(80,1,'2015-10-25 09:37:28',NULL,1,NULL,12,17,NULL,NULL,0,NULL,NULL,NULL),(81,1,'2015-10-25 09:37:28',NULL,1,NULL,12,18,NULL,NULL,0,NULL,NULL,NULL),(82,1,'2015-10-25 09:37:28',NULL,1,NULL,12,19,NULL,NULL,0,NULL,NULL,NULL),(83,1,'2015-10-25 09:37:28',NULL,1,NULL,12,20,NULL,NULL,0,NULL,NULL,NULL),(84,1,'2015-10-25 09:37:28',NULL,1,NULL,12,21,NULL,NULL,0,NULL,NULL,NULL),(85,1,'2015-10-25 09:37:28',NULL,1,NULL,12,22,NULL,NULL,0,NULL,NULL,NULL),(86,1,'2015-10-25 09:37:28',NULL,1,NULL,12,23,NULL,NULL,0,NULL,NULL,NULL),(87,1,'2015-10-25 09:37:28',NULL,1,NULL,12,24,NULL,NULL,0,NULL,NULL,NULL),(88,1,'2015-10-25 09:37:28',NULL,1,NULL,12,25,NULL,NULL,0,NULL,NULL,NULL),(89,1,'2015-10-25 09:37:28',NULL,1,NULL,12,26,NULL,NULL,0,NULL,NULL,NULL),(90,1,'2015-10-25 09:37:28',NULL,1,NULL,12,27,NULL,NULL,0,NULL,NULL,NULL),(91,1,'2015-10-25 09:37:28',NULL,1,NULL,12,28,NULL,NULL,0,NULL,NULL,NULL),(92,1,'2015-10-25 09:37:28',NULL,1,NULL,12,29,NULL,NULL,0,NULL,NULL,NULL),(93,1,'2015-10-25 09:37:28',NULL,1,NULL,12,30,NULL,NULL,0,NULL,NULL,NULL),(94,1,'2015-10-25 09:37:28',NULL,1,NULL,12,31,NULL,NULL,0,NULL,NULL,NULL),(95,1,'2015-10-25 09:37:28',NULL,1,NULL,12,32,NULL,NULL,0,NULL,NULL,NULL),(96,1,'2015-10-25 09:37:28',NULL,1,NULL,12,33,NULL,NULL,0,NULL,NULL,NULL),(97,1,'2015-10-25 09:37:28',NULL,1,NULL,12,34,NULL,NULL,0,NULL,NULL,NULL),(98,1,'2015-10-25 09:37:28',NULL,1,NULL,12,35,NULL,NULL,0,NULL,NULL,NULL),(99,1,'2015-10-25 09:37:28',NULL,1,NULL,12,36,NULL,NULL,0,NULL,NULL,NULL),(100,1,'2015-10-25 09:37:28',NULL,1,NULL,12,37,NULL,NULL,0,NULL,NULL,NULL),(101,1,'2015-10-25 09:37:28',NULL,1,NULL,12,38,NULL,NULL,0,NULL,NULL,NULL),(102,1,'2015-10-25 09:37:28',NULL,1,NULL,12,39,NULL,NULL,0,NULL,NULL,NULL),(103,1,'2015-10-25 09:37:28',NULL,1,NULL,12,40,NULL,NULL,0,NULL,NULL,NULL),(104,1,'2015-10-25 09:37:28',NULL,1,NULL,12,41,NULL,NULL,0,NULL,NULL,NULL),(105,1,'2015-10-25 09:37:28',NULL,1,NULL,12,42,NULL,NULL,0,NULL,NULL,NULL),(106,1,'2015-10-25 09:37:28',NULL,1,NULL,12,43,NULL,NULL,0,NULL,NULL,NULL),(107,1,'2015-10-25 09:37:28',NULL,1,NULL,12,44,NULL,NULL,0,NULL,NULL,NULL),(108,1,'2015-10-25 09:37:28',NULL,1,NULL,12,46,NULL,NULL,0,NULL,NULL,NULL),(109,1,'2015-10-25 09:37:28',NULL,1,NULL,12,47,NULL,NULL,0,NULL,NULL,NULL),(112,1,'2015-10-25 09:37:28',NULL,1,NULL,12,NULL,NULL,4,0,NULL,NULL,NULL),(113,0,'2015-10-25 09:37:28',NULL,1,NULL,12,8,NULL,NULL,1,1,'1280.00',NULL),(114,0,'2015-10-25 09:37:28',NULL,1,NULL,12,9,NULL,NULL,1,1,'280.00',NULL),(115,1,'2015-10-31 19:39:43',NULL,2,1,11,NULL,NULL,5,0,NULL,NULL,NULL),(117,1,'2015-10-31 19:39:43',NULL,2,1,11,NULL,NULL,NULL,0,3,NULL,7),(118,0,'2015-10-31 19:39:43',NULL,2,1,11,10,NULL,NULL,1,1,'580.00',NULL),(119,0,'2015-11-07 13:17:33',NULL,2,2,13,8,NULL,NULL,0,NULL,NULL,NULL),(120,0,'2015-11-07 13:17:33',NULL,2,2,13,9,NULL,NULL,0,NULL,NULL,NULL),(121,0,'2015-11-07 13:17:33',NULL,2,2,13,10,NULL,NULL,0,NULL,NULL,NULL),(122,0,'2015-11-07 13:17:33',NULL,2,2,13,11,NULL,NULL,0,NULL,NULL,NULL),(123,0,'2015-11-07 13:17:33',NULL,2,2,13,12,NULL,NULL,0,NULL,NULL,NULL),(124,0,'2015-11-07 13:17:33',NULL,2,2,13,14,NULL,NULL,0,NULL,NULL,NULL),(125,0,'2015-11-07 13:17:33',NULL,2,2,13,15,NULL,NULL,0,NULL,NULL,NULL),(126,0,'2015-11-07 13:17:33',NULL,2,2,13,16,NULL,NULL,0,NULL,NULL,NULL),(127,0,'2015-11-07 13:17:33',NULL,2,2,13,17,NULL,NULL,0,NULL,NULL,NULL),(128,0,'2015-11-07 13:17:33',NULL,2,2,13,18,NULL,NULL,0,NULL,NULL,NULL),(129,0,'2015-11-07 13:17:33',NULL,2,2,13,19,NULL,NULL,0,NULL,NULL,NULL),(130,0,'2015-11-07 13:17:33',NULL,2,2,13,20,NULL,NULL,0,NULL,NULL,NULL),(131,0,'2015-11-07 13:17:33',NULL,2,2,13,21,NULL,NULL,0,NULL,NULL,NULL),(132,0,'2015-11-07 13:17:33',NULL,2,2,13,22,NULL,NULL,0,NULL,NULL,NULL),(133,0,'2015-11-07 13:17:33',NULL,2,2,13,23,NULL,NULL,0,NULL,NULL,NULL),(134,0,'2015-11-07 13:17:33',NULL,2,2,13,24,NULL,NULL,0,NULL,NULL,NULL),(135,0,'2015-11-07 13:17:33',NULL,2,2,13,25,NULL,NULL,0,NULL,NULL,NULL),(136,0,'2015-11-07 13:17:33',NULL,2,2,13,26,NULL,NULL,0,NULL,NULL,NULL),(137,0,'2015-11-07 13:17:33',NULL,2,2,13,27,NULL,NULL,0,NULL,NULL,NULL),(138,0,'2015-11-07 13:17:33',NULL,2,2,13,28,NULL,NULL,0,NULL,NULL,NULL),(139,0,'2015-11-07 13:17:33',NULL,2,2,13,29,NULL,NULL,0,NULL,NULL,NULL),(140,0,'2015-11-07 13:17:33',NULL,2,2,13,30,NULL,NULL,0,NULL,NULL,NULL),(141,0,'2015-11-07 13:17:33',NULL,2,2,13,31,NULL,NULL,0,NULL,NULL,NULL),(142,0,'2015-11-07 13:17:33',NULL,2,2,13,32,NULL,NULL,0,NULL,NULL,NULL),(143,0,'2015-11-07 13:17:33',NULL,2,2,13,33,NULL,NULL,0,NULL,NULL,NULL),(144,0,'2015-11-07 13:17:33',NULL,2,2,13,34,NULL,NULL,0,NULL,NULL,NULL),(145,0,'2015-11-07 13:17:33',NULL,2,2,13,35,NULL,NULL,0,NULL,NULL,NULL),(146,0,'2015-11-07 13:17:33',NULL,2,2,13,36,NULL,NULL,0,NULL,NULL,NULL),(147,0,'2015-11-07 13:17:33',NULL,2,2,13,37,NULL,NULL,0,NULL,NULL,NULL),(148,0,'2015-11-07 13:17:33',NULL,2,2,13,38,NULL,NULL,0,NULL,NULL,NULL),(149,0,'2015-11-07 13:17:33',NULL,2,2,13,39,NULL,NULL,0,NULL,NULL,NULL),(150,0,'2015-11-07 13:17:33',NULL,2,2,13,40,NULL,NULL,0,NULL,NULL,NULL),(151,0,'2015-11-07 13:17:33',NULL,2,2,13,41,NULL,NULL,0,NULL,NULL,NULL),(152,0,'2015-11-07 13:17:33',NULL,2,2,13,42,NULL,NULL,0,NULL,NULL,NULL),(153,0,'2015-11-07 13:17:33',NULL,2,2,13,43,NULL,NULL,0,NULL,NULL,NULL),(154,0,'2015-11-07 13:17:33',NULL,2,2,13,44,NULL,NULL,0,NULL,NULL,NULL),(155,0,'2015-11-07 13:17:33',NULL,2,2,13,46,NULL,NULL,0,NULL,NULL,NULL),(156,0,'2015-11-07 13:17:33',NULL,2,2,13,47,NULL,NULL,0,NULL,NULL,NULL),(157,0,'2015-11-07 13:17:33',NULL,2,2,13,NULL,NULL,4,0,NULL,NULL,NULL),(158,0,'2015-11-07 13:17:33',NULL,2,2,13,NULL,NULL,5,0,NULL,NULL,NULL),(159,0,'2015-11-07 13:17:33',NULL,2,2,13,8,NULL,NULL,1,1,'1280.00',NULL),(160,0,'2015-11-07 13:17:33',NULL,2,2,13,NULL,NULL,NULL,1,1,NULL,6),(161,0,'2015-11-07 13:17:33',NULL,2,2,13,NULL,NULL,NULL,1,1,NULL,7),(162,0,'2015-11-15 19:32:04',NULL,2,2,14,8,NULL,NULL,0,NULL,NULL,NULL),(163,0,'2015-11-15 19:32:04',NULL,2,2,14,9,NULL,NULL,0,NULL,NULL,NULL),(164,0,'2015-11-15 19:32:04',NULL,2,2,14,10,NULL,NULL,0,NULL,NULL,NULL),(165,0,'2015-11-15 19:32:04',NULL,2,2,14,11,NULL,NULL,0,NULL,NULL,NULL),(166,0,'2015-11-15 19:32:04',NULL,2,2,14,12,NULL,NULL,0,NULL,NULL,NULL),(167,0,'2015-11-15 19:32:04',NULL,2,2,14,14,NULL,NULL,0,NULL,NULL,NULL),(168,0,'2015-11-15 19:32:04',NULL,2,2,14,15,NULL,NULL,0,NULL,NULL,NULL),(169,0,'2015-11-15 19:32:04',NULL,2,2,14,16,NULL,NULL,0,NULL,NULL,NULL),(170,0,'2015-11-15 19:32:04',NULL,2,2,14,17,NULL,NULL,0,NULL,NULL,NULL),(171,0,'2015-11-15 19:32:04',NULL,2,2,14,18,NULL,NULL,0,NULL,NULL,NULL),(172,0,'2015-11-15 19:32:04',NULL,2,2,14,19,NULL,NULL,0,NULL,NULL,NULL),(173,0,'2015-11-15 19:32:04',NULL,2,2,14,20,NULL,NULL,0,NULL,NULL,NULL),(174,0,'2015-11-15 19:32:04',NULL,2,2,14,21,NULL,NULL,0,NULL,NULL,NULL),(175,0,'2015-11-15 19:32:04',NULL,2,2,14,22,NULL,NULL,0,NULL,NULL,NULL),(176,0,'2015-11-15 19:32:04',NULL,2,2,14,23,NULL,NULL,0,NULL,NULL,NULL),(177,0,'2015-11-15 19:32:04',NULL,2,2,14,24,NULL,NULL,0,NULL,NULL,NULL),(178,0,'2015-11-15 19:32:04',NULL,2,2,14,25,NULL,NULL,0,NULL,NULL,NULL),(179,0,'2015-11-15 19:32:04',NULL,2,2,14,26,NULL,NULL,0,NULL,NULL,NULL),(180,0,'2015-11-15 19:32:04',NULL,2,2,14,27,NULL,NULL,0,NULL,NULL,NULL),(181,0,'2015-11-15 19:32:04',NULL,2,2,14,28,NULL,NULL,0,NULL,NULL,NULL),(182,0,'2015-11-15 19:32:04',NULL,2,2,14,29,NULL,NULL,0,NULL,NULL,NULL),(183,0,'2015-11-15 19:32:04',NULL,2,2,14,30,NULL,NULL,0,NULL,NULL,NULL),(184,0,'2015-11-15 19:32:04',NULL,2,2,14,31,NULL,NULL,0,NULL,NULL,NULL),(185,0,'2015-11-15 19:32:04',NULL,2,2,14,32,NULL,NULL,0,NULL,NULL,NULL),(186,0,'2015-11-15 19:32:04',NULL,2,2,14,33,NULL,NULL,0,NULL,NULL,NULL),(187,0,'2015-11-15 19:32:04',NULL,2,2,14,34,NULL,NULL,0,NULL,NULL,NULL),(188,0,'2015-11-15 19:32:04',NULL,2,2,14,35,NULL,NULL,0,NULL,NULL,NULL),(189,0,'2015-11-15 19:32:04',NULL,2,2,14,36,NULL,NULL,0,NULL,NULL,NULL),(190,0,'2015-11-15 19:32:04',NULL,2,2,14,37,NULL,NULL,0,NULL,NULL,NULL),(191,0,'2015-11-15 19:32:04',NULL,2,2,14,38,NULL,NULL,0,NULL,NULL,NULL),(192,0,'2015-11-15 19:32:04',NULL,2,2,14,39,NULL,NULL,0,NULL,NULL,NULL),(193,0,'2015-11-15 19:32:04',NULL,2,2,14,40,NULL,NULL,0,NULL,NULL,NULL),(194,0,'2015-11-15 19:32:04',NULL,2,2,14,41,NULL,NULL,0,NULL,NULL,NULL),(195,0,'2015-11-15 19:32:04',NULL,2,2,14,42,NULL,NULL,0,NULL,NULL,NULL),(196,0,'2015-11-15 19:32:04',NULL,2,2,14,43,NULL,NULL,0,NULL,NULL,NULL),(197,0,'2015-11-15 19:32:04',NULL,2,2,14,44,NULL,NULL,0,NULL,NULL,NULL),(198,0,'2015-11-15 19:32:04',NULL,2,2,14,46,NULL,NULL,0,NULL,NULL,NULL),(199,0,'2015-11-15 19:32:04',NULL,2,2,14,47,NULL,NULL,0,NULL,NULL,NULL),(200,0,'2015-11-15 19:32:04',NULL,2,2,14,NULL,NULL,4,0,NULL,NULL,NULL),(201,0,'2015-11-15 19:32:04',NULL,2,2,14,NULL,NULL,5,0,NULL,NULL,NULL),(202,0,'2015-11-15 19:32:04',NULL,2,2,14,NULL,NULL,NULL,1,1,NULL,6);

UNLOCK TABLES;

/*Table structure for table `marketingproject` */

DROP TABLE IF EXISTS `marketingproject`;

CREATE TABLE `marketingproject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `project` varchar(100) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_marketingproject_createrId` (`createrId`),
  KEY `FK_marketingproject_belongingId` (`belongingId`),
  CONSTRAINT `FK_marketingproject_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_marketingproject_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `marketingproject` */

LOCK TABLES `marketingproject` WRITE;

insert  into `marketingproject`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`project`,`money`,`remark`,`state`,`type`) values (8,6,'2015-10-09 10:42:07','2015-10-25 19:14:50',2,2,'美塑仪疗法','1280.00','',1,'1'),(9,3,'2015-10-09 10:42:26','2015-10-24 15:45:59',2,2,'光波理疗','280.00','',1,'2'),(10,3,'2015-10-09 10:42:52','2015-10-24 15:45:58',2,2,'纯氧丰胸仪疗法','580.00','',1,'2'),(11,3,'2015-10-09 10:44:21','2015-10-24 15:45:57',2,2,'蒂美姿乳腺保养','580.00','',1,'2'),(12,3,'2015-10-09 10:45:13','2015-10-24 15:45:56',2,2,'四象乳腺调理','480.00','',1,'2'),(14,3,'2015-10-09 10:46:25','2015-10-24 15:45:56',2,2,'腿部疗法','380.00','',1,'2'),(15,3,'2015-10-09 10:46:47','2015-10-24 15:45:55',2,2,'头部芳香疗法','480.00','',1,'1'),(16,3,'2015-10-09 10:47:04','2015-10-24 15:45:54',2,2,'芳香背部抗压','240.00','',1,'2'),(17,3,'2015-10-09 10:48:13','2015-10-24 15:45:53',2,2,'足疗','680.00','',1,'2'),(18,3,'2015-10-09 10:48:29','2015-10-24 15:45:52',2,2,'卵保','480.00','',1,'2'),(19,3,'2015-10-09 10:48:49','2015-10-24 15:45:51',2,2,'肾保','480.00','',1,'2'),(20,3,'2015-10-09 10:49:17','2015-10-24 15:45:51',2,2,'肩颈调理','380.00','',1,'2'),(21,3,'2015-10-09 10:50:04','2015-10-24 15:45:50',2,2,'脾胃养护','580.00','',1,'2'),(22,3,'2015-10-09 10:50:22','2015-10-24 15:45:49',2,2,'盆底肌保养','100.00','',1,'2'),(23,3,'2015-10-09 10:50:40','2015-10-24 15:45:49',2,2,'肝胆养护','580.00','',1,'2'),(24,6,'2015-10-09 10:51:01','2015-11-15 20:18:05',2,2,'π元素','680.00','',0,'2'),(25,0,'2015-10-09 10:51:14',NULL,2,2,'子午疗法','780.00','',1,NULL),(26,0,'2015-10-09 10:51:27',NULL,2,2,'淋巴排毒','580.00','',1,NULL),(27,0,'2015-10-09 10:51:44',NULL,2,2,'芳瑶','580.00','',1,NULL),(28,0,'2015-10-09 10:51:56',NULL,2,2,'瑶浴','380.00','',1,NULL),(29,0,'2015-10-09 10:52:06',NULL,2,2,'艾灸','380.00','',1,NULL),(30,0,'2015-10-09 10:52:19',NULL,2,2,'肠道排毒','680.00','',1,NULL),(31,0,'2015-10-09 10:52:33',NULL,2,2,'洗刷刷','780.00','',1,NULL),(32,0,'2015-10-09 10:53:06',NULL,2,2,'睛喜明眸眼部保养','450.00','',1,NULL),(33,0,'2015-10-09 10:53:51',NULL,2,2,'眼雕（眼温）','380.00','',1,NULL),(34,0,'2015-10-09 10:54:04',NULL,2,2,'克缇水疗','120.00','',1,NULL),(35,0,'2015-10-09 10:54:18',NULL,2,2,'美颈','450.00','',1,NULL),(36,0,'2015-10-09 10:54:28',NULL,2,2,'美手','450.00','',1,NULL),(37,0,'2015-10-09 10:57:09',NULL,2,2,'克丽缇娜面部护理','350.00','',1,NULL),(38,0,'2015-10-09 10:57:28',NULL,2,2,'颈侧淋巴排毒','280.00','',1,NULL),(39,0,'2015-10-09 10:57:44',NULL,2,2,'气血循环','380.00','',1,NULL),(40,0,'2015-10-09 10:58:02',NULL,2,2,'光纤皮肤检测','198.00','',1,NULL),(41,0,'2015-10-09 10:58:19',NULL,2,2,'CT检测','268.00','',1,NULL),(42,0,'2015-10-09 10:58:41',NULL,2,2,'定穴深灸','198.00','',1,NULL),(43,0,'2015-10-09 10:58:53',NULL,2,2,'中药熏蒸','198.00','',1,NULL),(44,0,'2015-10-09 10:59:07',NULL,2,2,'腹部太极养生','398.00','',1,NULL),(46,0,'2015-10-09 11:29:26',NULL,2,2,'NB无龄护理','698.00','',1,NULL),(47,0,'2015-10-09 12:27:26',NULL,2,2,'魔镜','980.00','',1,NULL);

UNLOCK TABLES;

/*Table structure for table `marketingrecord` */

DROP TABLE IF EXISTS `marketingrecord`;

CREATE TABLE `marketingrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `personnelInfoId` bigint(20) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `adviserId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_marketingrecord_createrId` (`createrId`),
  KEY `FK_marketingrecord_belongingId` (`belongingId`),
  KEY `FK_marketingrecord_customInfoId` (`customInfoId`),
  KEY `FK_marketingrecord_personnelInfoId` (`personnelInfoId`),
  KEY `FK_marketingrecord_adviserId` (`adviserId`),
  CONSTRAINT `FK_marketingrecord_adviserId` FOREIGN KEY (`adviserId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_marketingrecord_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_marketingrecord_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_marketingrecord_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_marketingrecord_personnelInfoId` FOREIGN KEY (`personnelInfoId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `marketingrecord` */

LOCK TABLES `marketingrecord` WRITE;

insert  into `marketingrecord`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`customInfoId`,`date`,`money`,`personnelInfoId`,`state`,`adviserId`) values (1,0,NULL,NULL,2,2,5,'2015-11-10 00:00:00','2079.00',1,1,2),(2,0,NULL,NULL,2,2,7,'2015-11-15 00:00:00','199.00',1,1,2),(3,0,NULL,NULL,2,2,7,'2015-11-16 00:00:00','1880.00',1,1,2),(4,0,NULL,NULL,2,2,7,'2015-11-16 00:00:00','1880.00',1,1,2),(5,0,NULL,NULL,2,2,5,'2015-11-16 00:00:00','1880.00',1,1,2),(6,0,NULL,NULL,2,2,5,'2015-11-16 00:00:00','1880.00',1,1,2);

UNLOCK TABLES;

/*Table structure for table `marketingrecord_detail` */

DROP TABLE IF EXISTS `marketingrecord_detail`;

CREATE TABLE `marketingrecord_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `marketingRecordId` bigint(20) DEFAULT NULL,
  `depotInfoId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `productStockId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_marketingrecord_detail_createrId` (`createrId`),
  KEY `FK_marketingrecord_detail_belongingId` (`belongingId`),
  KEY `FK_marketingrecord_detail_marketingRecordId` (`marketingRecordId`),
  KEY `FK_marketingrecord_detail_productStockDetailId` (`depotInfoId`),
  CONSTRAINT `FK_marketingrecord_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_marketingrecord_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_marketingrecord_detail_marketingRecordId` FOREIGN KEY (`marketingRecordId`) REFERENCES `marketingrecord` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `marketingrecord_detail` */

LOCK TABLES `marketingrecord_detail` WRITE;

insert  into `marketingrecord_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`marketingRecordId`,`depotInfoId`,`number`,`money`,`productStockId`) values (1,0,'2015-11-10 20:42:46',NULL,2,2,1,NULL,1,'199.00',4),(2,0,'2015-11-10 20:42:46',NULL,2,2,1,NULL,1,'1880.00',5),(3,0,'2015-11-15 19:19:36',NULL,2,2,2,NULL,1,'199.00',4),(4,0,'2015-11-16 18:15:15',NULL,2,2,3,NULL,1,'1880.00',5),(5,0,'2015-11-16 18:29:22',NULL,2,2,4,NULL,1,'1880.00',5),(6,0,'2015-11-16 18:30:17',NULL,2,2,5,NULL,1,'1880.00',5),(7,0,'2015-11-16 18:31:48',NULL,2,2,6,NULL,1,'1880.00',5);

UNLOCK TABLES;

/*Table structure for table `mealbuyrecord` */

DROP TABLE IF EXISTS `mealbuyrecord`;

CREATE TABLE `mealbuyrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `temporaryActivityId` bigint(20) DEFAULT NULL,
  `personnelInfoId` bigint(20) DEFAULT NULL,
  `adviserId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `realityMoney` decimal(10,2) DEFAULT NULL,
  `state` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_mealbuyrecord_createrId` (`createrId`),
  KEY `FK_mealbuyrecord_belongingId` (`belongingId`),
  KEY `FK_mealbuyrecord_customInfoId` (`customInfoId`),
  KEY `FK_mealbuyrecord_temporaryActivityId` (`temporaryActivityId`),
  KEY `FK_mealbuyrecord_adviserId` (`adviserId`),
  KEY `FK_mealbuyrecord_personnelInfoId` (`personnelInfoId`),
  CONSTRAINT `FK_mealbuyrecord_adviserId` FOREIGN KEY (`adviserId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_mealbuyrecord_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_mealbuyrecord_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_mealbuyrecord_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_mealbuyrecord_personnelInfoId` FOREIGN KEY (`personnelInfoId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_mealbuyrecord_temporaryActivityId` FOREIGN KEY (`temporaryActivityId`) REFERENCES `temporaryactivity` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `mealbuyrecord` */

LOCK TABLES `mealbuyrecord` WRITE;

insert  into `mealbuyrecord`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`customInfoId`,`date`,`temporaryActivityId`,`personnelInfoId`,`adviserId`,`number`,`realityMoney`,`state`) values (4,0,'2015-10-09 12:18:50',NULL,2,2,5,'2015-10-01 12:17:00',4,NULL,NULL,NULL,NULL,0),(5,0,NULL,NULL,2,2,5,'2015-11-10 16:18:00',3,1,2,1,'380.00',1),(6,0,NULL,NULL,2,2,5,'2015-11-10 20:52:00',3,1,2,1,'380.00',1),(7,0,NULL,NULL,2,2,7,'2015-11-15 19:15:00',4,1,2,1,'3980.00',1);

UNLOCK TABLES;

/*Table structure for table `mealbuyrecord_detail` */

DROP TABLE IF EXISTS `mealbuyrecord_detail`;

CREATE TABLE `mealbuyrecord_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `mealBuyRecordId` bigint(20) DEFAULT NULL,
  `marketingProjectId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `surplusNumber` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mealbuyrecord_detail_createrId` (`createrId`),
  KEY `FK_mealbuyrecord_detail_belongingId` (`belongingId`),
  KEY `FK_mealbuyrecord_detail_mealBuyRecordId` (`mealBuyRecordId`),
  KEY `FK_mealbuyrecord_detail_marketingProjectId` (`marketingProjectId`),
  CONSTRAINT `FK_mealbuyrecord_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_mealbuyrecord_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_mealbuyrecord_detail_marketingProjectId` FOREIGN KEY (`marketingProjectId`) REFERENCES `marketingproject` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_mealbuyrecord_detail_mealBuyRecordId` FOREIGN KEY (`mealBuyRecordId`) REFERENCES `mealbuyrecord` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `mealbuyrecord_detail` */

LOCK TABLES `mealbuyrecord_detail` WRITE;

insert  into `mealbuyrecord_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`mealBuyRecordId`,`marketingProjectId`,`number`,`money`,`surplusNumber`) values (5,0,'2015-10-09 12:18:50',NULL,2,2,4,46,5,'3490.00',5),(6,0,'2015-10-09 12:18:50',NULL,2,2,4,38,20,'3960.00',20),(7,0,'2015-10-09 12:18:50',NULL,2,2,4,37,15,'5250.00',15),(8,0,'2015-10-09 12:18:50',NULL,2,2,4,39,20,'7600.00',20),(9,0,'2015-10-09 12:18:50',NULL,2,2,4,43,1,'198.00',1),(10,0,'2015-10-09 12:18:50',NULL,2,2,4,44,1,'398.00',1),(11,0,'2015-10-09 12:18:50',NULL,2,2,4,40,1,'198.00',1),(12,0,'2015-10-09 12:18:50',NULL,2,2,4,41,1,'268.00',1),(13,0,'2015-10-09 12:18:50',NULL,2,2,4,42,1,'198.00',1),(14,0,'2015-11-10 16:19:58',NULL,2,2,5,37,1,'350.00',1),(15,1,'2015-11-10 16:19:58','2015-11-17 10:34:31',2,2,5,38,1,'280.00',0),(16,0,'2015-11-10 16:19:58',NULL,2,2,5,39,1,'380.00',1),(17,0,'2015-11-10 16:19:58',NULL,2,2,5,40,1,'198.00',1),(18,0,'2015-11-10 16:19:58',NULL,2,2,5,41,1,'268.00',1),(19,0,'2015-11-10 16:19:58',NULL,2,2,5,42,1,'198.00',1),(20,0,'2015-11-10 16:19:58',NULL,2,2,5,43,1,'198.00',1),(21,0,'2015-11-10 16:19:58',NULL,2,2,5,44,1,'398.00',1),(22,0,'2015-11-10 16:19:58',NULL,2,2,5,16,1,'240.00',1),(23,0,'2015-11-10 20:52:46',NULL,2,2,6,37,1,'350.00',1),(24,0,'2015-11-10 20:52:46',NULL,2,2,6,38,1,'280.00',1),(25,0,'2015-11-10 20:52:46',NULL,2,2,6,39,1,'380.00',1),(26,0,'2015-11-10 20:52:46',NULL,2,2,6,40,1,'198.00',1),(27,0,'2015-11-10 20:52:46',NULL,2,2,6,41,1,'268.00',1),(28,0,'2015-11-10 20:52:46',NULL,2,2,6,42,1,'198.00',1),(29,0,'2015-11-10 20:52:46',NULL,2,2,6,43,1,'198.00',1),(30,0,'2015-11-10 20:52:46',NULL,2,2,6,44,1,'398.00',1),(31,0,'2015-11-10 20:52:46',NULL,2,2,6,16,1,'240.00',1),(32,1,'2015-11-15 19:16:37','2015-11-17 15:01:27',2,2,7,46,5,'3490.00',3),(33,1,'2015-11-15 19:16:37','2015-11-16 09:29:35',2,2,7,38,20,'3960.00',19),(34,0,'2015-11-15 19:16:37',NULL,2,2,7,37,15,'5250.00',15),(35,0,'2015-11-15 19:16:37',NULL,2,2,7,39,20,'7600.00',20),(36,0,'2015-11-15 19:16:37',NULL,2,2,7,43,1,'198.00',1),(37,0,'2015-11-15 19:16:37',NULL,2,2,7,44,1,'398.00',1),(38,0,'2015-11-15 19:16:37',NULL,2,2,7,40,1,'198.00',1),(39,0,'2015-11-15 19:16:37',NULL,2,2,7,41,1,'268.00',1),(40,0,'2015-11-15 19:16:37',NULL,2,2,7,42,1,'198.00',1);

UNLOCK TABLES;

/*Table structure for table `personnelinfo` */

DROP TABLE IF EXISTS `personnelinfo`;

CREATE TABLE `personnelinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `workNumber` varchar(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `workState` varchar(4) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `politicalStatus` varchar(4) DEFAULT NULL,
  `nation` varchar(4) DEFAULT NULL,
  `marriage` varchar(4) DEFAULT NULL,
  `identification` varchar(18) DEFAULT NULL,
  `formalSchooling` varchar(4) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_personnelinfo_createrId` (`createrId`),
  KEY `FK_personnelinfo_belongingId` (`belongingId`),
  CONSTRAINT `FK_personnelinfo_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_personnelinfo_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `personnelinfo` */

LOCK TABLES `personnelinfo` WRITE;

insert  into `personnelinfo`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`workNumber`,`name`,`workState`,`sex`,`birthDate`,`politicalStatus`,`nation`,`marriage`,`identification`,`formalSchooling`,`type`,`mobile`) values (1,4,'2015-10-02 10:34:58','2015-10-10 15:52:12',2,2,'20150001','张四','1','1','1987-07-01','2','1','2','330721198707116607','4','1','13735678905'),(2,0,'2015-10-02 15:59:39',NULL,2,2,'20150002','李七','1','2','1991-10-04','3','1','2','330721198767225514','5','2','13745678910'),(3,0,'2015-11-01 15:02:40',NULL,2,2,'20150002','王五','1','1','2015-11-13','1','3','1','342214124312431234','1','3','');

UNLOCK TABLES;

/*Table structure for table `productdepotallot` */

DROP TABLE IF EXISTS `productdepotallot`;

CREATE TABLE `productdepotallot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `depotInfoId` bigint(20) DEFAULT NULL,
  `productStockDetailId` bigint(20) DEFAULT NULL,
  `allotDepotInfoId` bigint(20) DEFAULT NULL,
  `allotProductStockDetailId` bigint(20) DEFAULT NULL,
  `number` decimal(10,0) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_productdepotallot_createrId` (`createrId`),
  KEY `FK_productdepotallot_belongingId` (`belongingId`),
  KEY `FK_productdepotallot_depotInfoId` (`depotInfoId`),
  KEY `FK_productdepotallot_productStockDetailId` (`productStockDetailId`),
  KEY `FK_productdepotallot_allotDepotInfoId` (`allotDepotInfoId`),
  KEY `FK_productdepotallot_allotProductStockDetailId` (`allotProductStockDetailId`),
  CONSTRAINT `FK_productdepotallot_allotDepotInfoId` FOREIGN KEY (`allotDepotInfoId`) REFERENCES `depotinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_productdepotallot_allotProductStockDetailId` FOREIGN KEY (`allotProductStockDetailId`) REFERENCES `productstock_detail` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_productdepotallot_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_productdepotallot_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_productdepotallot_depotInfoId` FOREIGN KEY (`depotInfoId`) REFERENCES `depotinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_productdepotallot_productStockDetailId` FOREIGN KEY (`productStockDetailId`) REFERENCES `productstock_detail` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `productdepotallot` */

LOCK TABLES `productdepotallot` WRITE;

UNLOCK TABLES;

/*Table structure for table `productstock` */

DROP TABLE IF EXISTS `productstock`;

CREATE TABLE `productstock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `introduce` varchar(100) DEFAULT NULL,
  `money` decimal(10,3) DEFAULT NULL,
  `cost` decimal(10,3) DEFAULT NULL,
  `brandId` bigint(20) DEFAULT NULL,
  `seriesId` bigint(20) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK_name` (`name`,`belongingId`),
  KEY `FK_productstock_createrId` (`createrId`),
  KEY `FK_productstock_belongingId` (`belongingId`),
  KEY `FK_productstock_brandId` (`brandId`),
  KEY `FK_productstock_seriesId` (`seriesId`),
  CONSTRAINT `FK_productstock_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_productstock_brandId` FOREIGN KEY (`brandId`) REFERENCES `brand` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_productstock_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_productstock_seriesId` FOREIGN KEY (`seriesId`) REFERENCES `series` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `productstock` */

LOCK TABLES `productstock` WRITE;

insert  into `productstock`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`name`,`remark`,`introduce`,`money`,`cost`,`brandId`,`seriesId`,`unit`) values (4,2,'2015-10-09 12:34:51','2015-10-24 15:49:54',2,2,'克丽缇娜EPO洁容霜','','洁容霜50G','199.000','119.000',1,1,'瓶'),(5,0,'2015-10-25 19:12:45',NULL,2,2,'黛梦保湿修护液','',NULL,'1880.000','940.000',4,6,'');

UNLOCK TABLES;

/*Table structure for table `productstock_detail` */

DROP TABLE IF EXISTS `productstock_detail`;

CREATE TABLE `productstock_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `depotInfoId` bigint(20) DEFAULT NULL,
  `productStockId` bigint(20) DEFAULT NULL,
  `number` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_productstock_detail_createrId` (`createrId`),
  KEY `FK_productstock_detail_belongingId` (`belongingId`),
  KEY `FK_productstock_detail_depotInfoId` (`depotInfoId`),
  KEY `FK_productstock_detail_productStockId` (`productStockId`),
  CONSTRAINT `FK_productstock_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_productstock_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_productstock_detail_depotInfoId` FOREIGN KEY (`depotInfoId`) REFERENCES `depotinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_productstock_detail_productStockId` FOREIGN KEY (`productStockId`) REFERENCES `productstock` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `productstock_detail` */

LOCK TABLES `productstock_detail` WRITE;

UNLOCK TABLES;

/*Table structure for table `projectbuy` */

DROP TABLE IF EXISTS `projectbuy`;

CREATE TABLE `projectbuy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `personnelInfoId` bigint(20) DEFAULT NULL,
  `adviserId` bigint(20) DEFAULT NULL,
  `state` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_projectbuy_createrId` (`createrId`),
  KEY `FK_projectbuy_belongingId` (`belongingId`),
  KEY `FK_projectbuy_customInfoId` (`customInfoId`),
  KEY `FK_projectbuy_personnelInfoId` (`personnelInfoId`),
  KEY `FK_projectbuy_adviserId` (`adviserId`),
  CONSTRAINT `FK_projectbuy_adviserId` FOREIGN KEY (`adviserId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_projectbuy_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_projectbuy_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_projectbuy_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_projectbuy_personnelInfoId` FOREIGN KEY (`personnelInfoId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `projectbuy` */

LOCK TABLES `projectbuy` WRITE;

insert  into `projectbuy`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`customInfoId`,`date`,`money`,`personnelInfoId`,`adviserId`,`state`) values (3,0,'2015-10-09 12:30:21',NULL,2,2,5,'2015-10-09 12:29:00','5980.00',NULL,NULL,0),(4,0,NULL,NULL,2,2,5,'2015-11-10 19:15:00','1560.00',1,2,1),(5,0,NULL,NULL,2,2,7,'2015-11-15 19:17:00','5000.00',1,2,1),(6,0,NULL,NULL,2,2,7,'2015-11-15 20:09:00','4800.00',1,2,1),(7,0,NULL,NULL,2,2,7,'2015-11-17 19:31:00','14000.00',1,2,1);

UNLOCK TABLES;

/*Table structure for table `projectbuy_detail` */

DROP TABLE IF EXISTS `projectbuy_detail`;

CREATE TABLE `projectbuy_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `projectBuyId` bigint(20) DEFAULT NULL,
  `marketingProjectId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `surplusNumber` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_projectbuy_detail_createrId` (`createrId`),
  KEY `FK_projectbuy_detail_belongingId` (`belongingId`),
  KEY `FK_projectbuy_detail_projectBuyId` (`projectBuyId`),
  KEY `FK_projectbuy_detail_marketingProjectId` (`marketingProjectId`),
  CONSTRAINT `FK_projectbuy_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_projectbuy_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_projectbuy_detail_marketingProjectId` FOREIGN KEY (`marketingProjectId`) REFERENCES `marketingproject` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_projectbuy_detail_projectBuyId` FOREIGN KEY (`projectBuyId`) REFERENCES `projectbuy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `projectbuy_detail` */

LOCK TABLES `projectbuy_detail` WRITE;

insert  into `projectbuy_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`projectBuyId`,`marketingProjectId`,`number`,`money`,`surplusNumber`) values (7,0,'2015-10-09 12:30:21',NULL,2,2,3,37,10,'3500.00',10),(8,0,'2015-11-10 19:16:25',NULL,2,2,4,8,1,'1280.00',1),(9,1,'2015-11-10 19:16:25','2015-11-16 19:13:29',2,2,4,9,1,'280.00',0),(10,3,'2015-11-15 19:18:31','2015-11-17 19:19:08',2,2,5,17,10,'680.00',-2),(11,2,'2015-11-15 20:10:44','2015-11-17 19:20:07',2,2,6,18,10,'480.00',-2),(12,4,'2015-11-17 19:31:42','2015-11-17 19:57:48',2,2,7,8,10,'1200.00',5),(13,3,'2015-11-17 19:31:42','2015-11-17 19:57:48',2,2,7,9,10,'200.00',7);

UNLOCK TABLES;

/*Table structure for table `projectoperation` */

DROP TABLE IF EXISTS `projectoperation`;

CREATE TABLE `projectoperation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `personnelInfoId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_projectoperation_createrId` (`createrId`),
  KEY `FK_projectoperation_belongingId` (`belongingId`),
  KEY `FK_projectoperation_customInfoId` (`customInfoId`),
  KEY `FK_projectoperation_personnelInfoId` (`personnelInfoId`),
  CONSTRAINT `FK_projectoperation_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_projectoperation_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_projectoperation_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_projectoperation_personnelInfoId` FOREIGN KEY (`personnelInfoId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `projectoperation` */

LOCK TABLES `projectoperation` WRITE;

UNLOCK TABLES;

/*Table structure for table `projectoperation_detail` */

DROP TABLE IF EXISTS `projectoperation_detail`;

CREATE TABLE `projectoperation_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `projectOperationId` bigint(20) DEFAULT NULL,
  `marketingProjectId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_projectoperation_detail_createrId` (`createrId`),
  KEY `FK_projectoperation_detail_belongingId` (`belongingId`),
  KEY `FK_projectoperation_detail_projectOperationId` (`projectOperationId`),
  KEY `FK_projectoperation_detail_marketingProjectId` (`marketingProjectId`),
  CONSTRAINT `FK_projectoperation_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_projectoperation_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_projectoperation_detail_marketingProjectId` FOREIGN KEY (`marketingProjectId`) REFERENCES `marketingproject` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_projectoperation_detail_projectOperationId` FOREIGN KEY (`projectOperationId`) REFERENCES `projectoperation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `projectoperation_detail` */

LOCK TABLES `projectoperation_detail` WRITE;

UNLOCK TABLES;

/*Table structure for table `recharge` */

DROP TABLE IF EXISTS `recharge`;

CREATE TABLE `recharge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `rechargeDate` datetime DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_recharge_createrId` (`createrId`),
  KEY `FK_recharge_belongingId` (`belongingId`),
  KEY `FK_recharge_customInfoId` (`customInfoId`),
  CONSTRAINT `FK_recharge_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_recharge_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_recharge_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `recharge` */

LOCK TABLES `recharge` WRITE;

insert  into `recharge`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`customInfoId`,`rechargeDate`,`money`,`state`) values (7,0,'2015-10-09 12:06:07',NULL,2,2,5,'2015-10-09 12:05:00','58000.00',1),(8,0,'2015-10-25 15:21:12',NULL,1,NULL,5,'2015-10-25 15:21:00','58000.00',1),(9,0,'2015-11-04 20:04:10',NULL,3,3,5,'2015-11-04 20:04:00','40000.00',1);

UNLOCK TABLES;

/*Table structure for table `repaymentrecord` */

DROP TABLE IF EXISTS `repaymentrecord`;

CREATE TABLE `repaymentrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `customInfoId` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `personnelInfoId` bigint(20) DEFAULT NULL,
  `adviserId` bigint(20) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  `readyMoney` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_repaymentrecord_customInfoId` (`customInfoId`),
  KEY `FK_repaymentrecord_createrId` (`createrId`),
  KEY `FK_repaymentrecord_belongingId` (`belongingId`),
  KEY `FK_repaymentrecord_personnelInfoId` (`personnelInfoId`),
  KEY `FK_repaymentrecord_adviserId` (`adviserId`),
  CONSTRAINT `FK_repaymentrecord_adviserId` FOREIGN KEY (`adviserId`) REFERENCES `personnelinfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_repaymentrecord_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_repaymentrecord_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_repaymentrecord_customInfoId` FOREIGN KEY (`customInfoId`) REFERENCES `custominfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_repaymentrecord_personnelInfoId` FOREIGN KEY (`personnelInfoId`) REFERENCES `personnelinfo` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `repaymentrecord` */

LOCK TABLES `repaymentrecord` WRITE;

insert  into `repaymentrecord`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`customInfoId`,`date`,`money`,`personnelInfoId`,`adviserId`,`remark`,`state`,`balance`,`readyMoney`) values (1,0,'2015-11-04 20:01:39',NULL,3,3,5,'2015-11-04 00:00:00','65110.00',1,2,NULL,0,'65110.00',NULL),(2,0,'2015-11-04 20:02:38',NULL,3,3,5,'2015-11-04 00:00:00','65110.00',1,2,NULL,0,'31480.00','33630.00'),(3,0,'2015-11-04 20:04:25',NULL,3,3,5,'2015-11-04 00:00:00','33630.00',1,2,NULL,0,'2630.00','31000.00'),(4,0,'2015-11-15 19:56:07',NULL,2,2,7,'2015-11-15 00:00:00','200.00',1,2,NULL,0,NULL,'200.00');

UNLOCK TABLES;

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
  CONSTRAINT `FK_leaguer_role_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_role_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

LOCK TABLES `role` WRITE;

insert  into `role`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`roleName`,`description`,`belongingId`) values (1,7,'2015-10-04 00:00:00','2015-11-17 00:00:00',1,'美容公司用户','',NULL),(2,8,'2015-10-04 00:00:00','2015-11-17 00:00:00',2,'店铺管理者','',2),(3,3,'2015-10-04 00:00:00','2015-11-17 00:00:00',2,'公司主管','',2);

UNLOCK TABLES;

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
  CONSTRAINT `FK_leaguer_roledetail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_roledetail_functionId` FOREIGN KEY (`functionId`) REFERENCES `function` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_roledetail_roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_roledetail_treeItemId` FOREIGN KEY (`treeItemId`) REFERENCES `treeitem` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_role_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=835 DEFAULT CHARSET=utf8;

/*Data for the table `role_detail` */

LOCK TABLES `role_detail` WRITE;

insert  into `role_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`treeItemId`,`functionId`,`roleId`,`belongingId`) values (591,0,'2015-11-17 16:03:53',NULL,1,8,NULL,1,NULL),(592,0,'2015-11-17 16:03:53',NULL,1,9,2,1,NULL),(593,0,'2015-11-17 16:03:53',NULL,1,9,3,1,NULL),(594,0,'2015-11-17 16:03:53',NULL,1,9,4,1,NULL),(595,0,'2015-11-17 16:03:53',NULL,1,12,9,1,NULL),(596,0,'2015-11-17 16:03:53',NULL,1,12,10,1,NULL),(597,0,'2015-11-17 16:03:53',NULL,1,12,11,1,NULL),(598,0,'2015-11-17 16:03:53',NULL,1,15,NULL,1,NULL),(599,0,'2015-11-17 16:03:53',NULL,1,45,59,1,NULL),(600,0,'2015-11-17 16:03:53',NULL,1,45,60,1,NULL),(601,0,'2015-11-17 16:03:53',NULL,1,46,61,1,NULL),(602,0,'2015-11-17 16:03:53',NULL,1,46,62,1,NULL),(603,0,'2015-11-17 16:03:53',NULL,1,47,63,1,NULL),(604,0,'2015-11-17 16:03:53',NULL,1,47,64,1,NULL),(605,0,'2015-11-17 16:03:53',NULL,1,48,65,1,NULL),(606,0,'2015-11-17 16:03:53',NULL,1,48,66,1,NULL),(607,0,'2015-11-17 16:03:53',NULL,1,49,67,1,NULL),(608,0,'2015-11-17 16:03:53',NULL,1,49,68,1,NULL),(609,0,'2015-11-17 16:03:53',NULL,1,50,NULL,1,NULL),(610,0,'2015-11-17 16:03:53',NULL,1,51,53,1,NULL),(611,0,'2015-11-17 16:03:53',NULL,1,51,54,1,NULL),(612,0,'2015-11-17 16:03:53',NULL,1,51,55,1,NULL),(613,0,'2015-11-17 16:03:53',NULL,1,51,56,1,NULL),(614,0,'2015-11-17 16:03:53',NULL,1,58,69,1,NULL),(615,0,'2015-11-17 16:03:53',NULL,1,58,70,1,NULL),(616,0,'2015-11-17 16:03:53',NULL,1,59,71,1,NULL),(617,0,'2015-11-17 16:03:53',NULL,1,59,72,1,NULL),(618,0,'2015-11-17 16:03:53',NULL,1,60,73,1,NULL),(619,0,'2015-11-17 16:03:53',NULL,1,60,74,1,NULL),(620,0,'2015-11-17 16:03:53',NULL,1,62,NULL,1,NULL),(621,0,'2015-11-17 16:03:53',NULL,1,63,12,1,NULL),(622,0,'2015-11-17 16:03:53',NULL,1,63,13,1,NULL),(623,0,'2015-11-17 16:03:53',NULL,1,63,14,1,NULL),(624,0,'2015-11-17 16:03:53',NULL,1,63,18,1,NULL),(625,0,'2015-11-17 16:03:53',NULL,1,64,15,1,NULL),(626,0,'2015-11-17 16:03:53',NULL,1,64,16,1,NULL),(627,0,'2015-11-17 16:03:53',NULL,1,64,17,1,NULL),(628,0,'2015-11-17 16:03:53',NULL,1,64,19,1,NULL),(629,0,'2015-11-17 16:03:53',NULL,1,65,24,1,NULL),(630,0,'2015-11-17 16:03:53',NULL,1,65,25,1,NULL),(631,0,'2015-11-17 16:03:53',NULL,1,65,26,1,NULL),(632,0,'2015-11-17 16:03:53',NULL,1,65,27,1,NULL),(633,0,'2015-11-17 16:03:53',NULL,1,66,20,1,NULL),(634,0,'2015-11-17 16:03:53',NULL,1,66,21,1,NULL),(635,0,'2015-11-17 16:03:53',NULL,1,66,22,1,NULL),(636,0,'2015-11-17 16:03:53',NULL,1,66,23,1,NULL),(637,0,'2015-11-17 16:03:53',NULL,1,67,28,1,NULL),(638,0,'2015-11-17 16:03:53',NULL,1,67,29,1,NULL),(639,0,'2015-11-17 16:03:53',NULL,1,67,30,1,NULL),(640,0,'2015-11-17 16:03:53',NULL,1,67,31,1,NULL),(641,0,'2015-11-17 16:03:53',NULL,1,68,32,1,NULL),(642,0,'2015-11-17 16:03:53',NULL,1,68,33,1,NULL),(643,0,'2015-11-17 16:03:53',NULL,1,68,34,1,NULL),(644,0,'2015-11-17 16:03:53',NULL,1,68,35,1,NULL),(645,0,'2015-11-17 16:03:53',NULL,1,69,36,1,NULL),(646,0,'2015-11-17 16:03:53',NULL,1,69,37,1,NULL),(647,0,'2015-11-17 16:03:53',NULL,1,69,38,1,NULL),(648,0,'2015-11-17 16:03:53',NULL,1,69,39,1,NULL),(649,0,'2015-11-17 16:03:53',NULL,1,70,48,1,NULL),(650,0,'2015-11-17 16:03:53',NULL,1,70,49,1,NULL),(651,0,'2015-11-17 16:03:53',NULL,1,70,50,1,NULL),(652,0,'2015-11-17 16:03:53',NULL,1,70,51,1,NULL),(653,0,'2015-11-17 16:03:53',NULL,1,70,52,1,NULL),(654,0,'2015-11-17 16:03:53',NULL,1,72,40,1,NULL),(655,0,'2015-11-17 16:03:53',NULL,1,72,41,1,NULL),(656,0,'2015-11-17 16:03:53',NULL,1,72,42,1,NULL),(657,0,'2015-11-17 16:03:53',NULL,1,72,43,1,NULL),(658,0,'2015-11-17 16:03:53',NULL,1,73,44,1,NULL),(659,0,'2015-11-17 16:03:53',NULL,1,73,45,1,NULL),(660,0,'2015-11-17 16:03:53',NULL,1,73,46,1,NULL),(661,0,'2015-11-17 16:03:53',NULL,1,73,47,1,NULL),(698,0,'2015-11-17 16:05:40',NULL,2,8,NULL,3,NULL),(699,0,'2015-11-17 16:05:40',NULL,2,9,2,3,NULL),(700,0,'2015-11-17 16:05:40',NULL,2,9,3,3,NULL),(701,0,'2015-11-17 16:05:40',NULL,2,9,4,3,NULL),(702,0,'2015-11-17 16:05:40',NULL,2,12,9,3,NULL),(703,0,'2015-11-17 16:05:40',NULL,2,12,10,3,NULL),(704,0,'2015-11-17 16:05:40',NULL,2,12,11,3,NULL),(705,0,'2015-11-17 16:05:40',NULL,2,15,NULL,3,NULL),(706,0,'2015-11-17 16:05:40',NULL,2,45,59,3,NULL),(707,0,'2015-11-17 16:05:40',NULL,2,45,60,3,NULL),(708,0,'2015-11-17 16:05:40',NULL,2,46,61,3,NULL),(709,0,'2015-11-17 16:05:40',NULL,2,46,62,3,NULL),(710,0,'2015-11-17 16:05:40',NULL,2,47,63,3,NULL),(711,0,'2015-11-17 16:05:40',NULL,2,47,64,3,NULL),(712,0,'2015-11-17 16:05:40',NULL,2,48,65,3,NULL),(713,0,'2015-11-17 16:05:40',NULL,2,48,66,3,NULL),(714,0,'2015-11-17 16:05:40',NULL,2,49,67,3,NULL),(715,0,'2015-11-17 16:05:40',NULL,2,49,68,3,NULL),(716,0,'2015-11-17 16:05:40',NULL,2,50,NULL,3,NULL),(717,0,'2015-11-17 16:05:40',NULL,2,51,53,3,NULL),(718,0,'2015-11-17 16:05:40',NULL,2,51,54,3,NULL),(719,0,'2015-11-17 16:05:40',NULL,2,51,55,3,NULL),(720,0,'2015-11-17 16:05:40',NULL,2,51,56,3,NULL),(721,0,'2015-11-17 16:05:40',NULL,2,58,69,3,NULL),(722,0,'2015-11-17 16:05:40',NULL,2,58,70,3,NULL),(723,0,'2015-11-17 16:05:40',NULL,2,59,71,3,NULL),(724,0,'2015-11-17 16:05:40',NULL,2,59,72,3,NULL),(725,0,'2015-11-17 16:05:40',NULL,2,60,73,3,NULL),(726,0,'2015-11-17 16:05:40',NULL,2,60,74,3,NULL),(727,0,'2015-11-17 16:05:40',NULL,2,62,NULL,3,NULL),(728,0,'2015-11-17 16:05:40',NULL,2,63,12,3,NULL),(729,0,'2015-11-17 16:05:40',NULL,2,63,13,3,NULL),(730,0,'2015-11-17 16:05:40',NULL,2,63,14,3,NULL),(731,0,'2015-11-17 16:05:40',NULL,2,63,18,3,NULL),(732,0,'2015-11-17 16:05:40',NULL,2,64,15,3,NULL),(733,0,'2015-11-17 16:05:40',NULL,2,64,16,3,NULL),(734,0,'2015-11-17 16:05:40',NULL,2,64,17,3,NULL),(735,0,'2015-11-17 16:05:40',NULL,2,64,19,3,NULL),(736,0,'2015-11-17 16:05:40',NULL,2,65,24,3,NULL),(737,0,'2015-11-17 16:05:40',NULL,2,65,25,3,NULL),(738,0,'2015-11-17 16:05:40',NULL,2,65,26,3,NULL),(739,0,'2015-11-17 16:05:40',NULL,2,65,27,3,NULL),(740,0,'2015-11-17 16:05:40',NULL,2,66,20,3,NULL),(741,0,'2015-11-17 16:05:40',NULL,2,66,21,3,NULL),(742,0,'2015-11-17 16:05:40',NULL,2,66,22,3,NULL),(743,0,'2015-11-17 16:05:40',NULL,2,66,23,3,NULL),(744,0,'2015-11-17 16:05:40',NULL,2,67,28,3,NULL),(745,0,'2015-11-17 16:05:40',NULL,2,67,29,3,NULL),(746,0,'2015-11-17 16:05:40',NULL,2,67,30,3,NULL),(747,0,'2015-11-17 16:05:40',NULL,2,67,31,3,NULL),(748,0,'2015-11-17 16:05:40',NULL,2,68,32,3,NULL),(749,0,'2015-11-17 16:05:40',NULL,2,68,33,3,NULL),(750,0,'2015-11-17 16:05:40',NULL,2,68,34,3,NULL),(751,0,'2015-11-17 16:05:40',NULL,2,68,35,3,NULL),(752,0,'2015-11-17 16:05:40',NULL,2,69,36,3,NULL),(753,0,'2015-11-17 16:05:40',NULL,2,69,37,3,NULL),(754,0,'2015-11-17 16:05:40',NULL,2,69,38,3,NULL),(755,0,'2015-11-17 16:05:40',NULL,2,69,39,3,NULL),(756,0,'2015-11-17 16:05:40',NULL,2,70,48,3,NULL),(757,0,'2015-11-17 16:05:40',NULL,2,70,49,3,NULL),(758,0,'2015-11-17 16:05:40',NULL,2,70,50,3,NULL),(759,0,'2015-11-17 16:05:40',NULL,2,70,51,3,NULL),(760,0,'2015-11-17 16:05:40',NULL,2,70,52,3,NULL),(761,0,'2015-11-17 16:05:40',NULL,2,72,40,3,NULL),(762,0,'2015-11-17 16:05:40',NULL,2,72,41,3,NULL),(763,0,'2015-11-17 16:05:40',NULL,2,72,42,3,NULL),(764,0,'2015-11-17 16:05:40',NULL,2,72,43,3,NULL),(765,0,'2015-11-17 16:05:40',NULL,2,73,44,3,NULL),(766,0,'2015-11-17 16:05:40',NULL,2,73,45,3,NULL),(767,0,'2015-11-17 16:05:40',NULL,2,73,46,3,NULL),(768,0,'2015-11-17 16:05:40',NULL,2,73,47,3,NULL),(769,0,'2015-11-17 20:23:08',NULL,2,8,NULL,2,NULL),(770,0,'2015-11-17 20:23:08',NULL,2,9,2,2,NULL),(771,0,'2015-11-17 20:23:08',NULL,2,9,3,2,NULL),(772,0,'2015-11-17 20:23:08',NULL,2,9,4,2,NULL),(773,0,'2015-11-17 20:23:08',NULL,2,12,9,2,NULL),(774,0,'2015-11-17 20:23:08',NULL,2,12,10,2,NULL),(775,0,'2015-11-17 20:23:08',NULL,2,12,11,2,NULL),(776,0,'2015-11-17 20:23:08',NULL,2,15,NULL,2,NULL),(777,0,'2015-11-17 20:23:08',NULL,2,45,59,2,NULL),(778,0,'2015-11-17 20:23:08',NULL,2,45,60,2,NULL),(779,0,'2015-11-17 20:23:08',NULL,2,46,61,2,NULL),(780,0,'2015-11-17 20:23:08',NULL,2,46,62,2,NULL),(781,0,'2015-11-17 20:23:08',NULL,2,47,63,2,NULL),(782,0,'2015-11-17 20:23:08',NULL,2,47,64,2,NULL),(783,0,'2015-11-17 20:23:08',NULL,2,48,65,2,NULL),(784,0,'2015-11-17 20:23:08',NULL,2,48,66,2,NULL),(785,0,'2015-11-17 20:23:08',NULL,2,49,67,2,NULL),(786,0,'2015-11-17 20:23:08',NULL,2,49,68,2,NULL),(787,0,'2015-11-17 20:23:08',NULL,2,50,NULL,2,NULL),(788,0,'2015-11-17 20:23:08',NULL,2,51,53,2,NULL),(789,0,'2015-11-17 20:23:08',NULL,2,51,54,2,NULL),(790,0,'2015-11-17 20:23:08',NULL,2,51,55,2,NULL),(791,0,'2015-11-17 20:23:08',NULL,2,51,56,2,NULL),(792,0,'2015-11-17 20:23:08',NULL,2,58,69,2,NULL),(793,0,'2015-11-17 20:23:08',NULL,2,58,70,2,NULL),(794,0,'2015-11-17 20:23:08',NULL,2,59,71,2,NULL),(795,0,'2015-11-17 20:23:08',NULL,2,59,72,2,NULL),(796,0,'2015-11-17 20:23:08',NULL,2,60,73,2,NULL),(797,0,'2015-11-17 20:23:08',NULL,2,60,74,2,NULL),(798,0,'2015-11-17 20:23:08',NULL,2,62,NULL,2,NULL),(799,0,'2015-11-17 20:23:08',NULL,2,63,12,2,NULL),(800,0,'2015-11-17 20:23:08',NULL,2,63,18,2,NULL),(801,0,'2015-11-17 20:23:08',NULL,2,64,19,2,NULL),(802,0,'2015-11-17 20:23:08',NULL,2,65,24,2,NULL),(803,0,'2015-11-17 20:23:08',NULL,2,65,25,2,NULL),(804,0,'2015-11-17 20:23:08',NULL,2,65,26,2,NULL),(805,0,'2015-11-17 20:23:08',NULL,2,65,27,2,NULL),(806,0,'2015-11-17 20:23:08',NULL,2,66,20,2,NULL),(807,0,'2015-11-17 20:23:08',NULL,2,66,21,2,NULL),(808,0,'2015-11-17 20:23:08',NULL,2,66,22,2,NULL),(809,0,'2015-11-17 20:23:08',NULL,2,66,23,2,NULL),(810,0,'2015-11-17 20:23:08',NULL,2,67,28,2,NULL),(811,0,'2015-11-17 20:23:08',NULL,2,67,29,2,NULL),(812,0,'2015-11-17 20:23:08',NULL,2,67,30,2,NULL),(813,0,'2015-11-17 20:23:08',NULL,2,67,31,2,NULL),(814,0,'2015-11-17 20:23:08',NULL,2,68,32,2,NULL),(815,0,'2015-11-17 20:23:08',NULL,2,68,33,2,NULL),(816,0,'2015-11-17 20:23:08',NULL,2,68,34,2,NULL),(817,0,'2015-11-17 20:23:08',NULL,2,68,35,2,NULL),(818,0,'2015-11-17 20:23:08',NULL,2,69,36,2,NULL),(819,0,'2015-11-17 20:23:08',NULL,2,69,37,2,NULL),(820,0,'2015-11-17 20:23:08',NULL,2,69,38,2,NULL),(821,0,'2015-11-17 20:23:08',NULL,2,69,39,2,NULL),(822,0,'2015-11-17 20:23:08',NULL,2,70,48,2,NULL),(823,0,'2015-11-17 20:23:08',NULL,2,70,49,2,NULL),(824,0,'2015-11-17 20:23:08',NULL,2,70,50,2,NULL),(825,0,'2015-11-17 20:23:08',NULL,2,70,51,2,NULL),(826,0,'2015-11-17 20:23:08',NULL,2,70,52,2,NULL),(827,0,'2015-11-17 20:23:08',NULL,2,72,40,2,NULL),(828,0,'2015-11-17 20:23:08',NULL,2,72,41,2,NULL),(829,0,'2015-11-17 20:23:08',NULL,2,72,42,2,NULL),(830,0,'2015-11-17 20:23:08',NULL,2,72,43,2,NULL),(831,0,'2015-11-17 20:23:08',NULL,2,73,44,2,NULL),(832,0,'2015-11-17 20:23:08',NULL,2,73,45,2,NULL),(833,0,'2015-11-17 20:23:08',NULL,2,73,46,2,NULL),(834,0,'2015-11-17 20:23:08',NULL,2,73,47,2,NULL);

UNLOCK TABLES;

/*Table structure for table `series` */

DROP TABLE IF EXISTS `series`;

CREATE TABLE `series` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `brandId` bigint(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_series_createrId` (`createrId`),
  KEY `FK_series_belongingId` (`belongingId`),
  KEY `FK_series_brandId` (`brandId`),
  CONSTRAINT `FK_series_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_series_brandId` FOREIGN KEY (`brandId`) REFERENCES `brand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_series_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `series` */

LOCK TABLES `series` WRITE;

insert  into `series`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`brandId`,`name`,`remark`) values (1,0,'2015-10-24 15:42:28',NULL,1,NULL,1,'第一个品牌列表一',''),(2,0,'2015-10-24 15:42:38',NULL,1,NULL,1,'第一个品牌系列二',''),(3,0,'2015-10-24 15:42:51',NULL,1,NULL,2,'第二个品牌系列一',''),(4,0,'2015-10-24 15:43:01',NULL,1,NULL,2,'第二个品牌系列二',''),(5,0,'2015-10-24 15:43:11',NULL,1,NULL,3,'第三个品牌系列一',''),(6,0,'2015-10-25 19:10:52',NULL,2,2,4,'钻石系列',''),(7,0,'2015-10-25 19:11:08',NULL,2,2,4,'修复系列','');

UNLOCK TABLES;

/*Table structure for table `shopapple` */

DROP TABLE IF EXISTS `shopapple`;

CREATE TABLE `shopapple` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `number` varchar(10) DEFAULT NULL,
  `depotInfoId` bigint(20) DEFAULT NULL,
  `appleDate` date DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  `appleState` varchar(4) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK_number` (`number`,`belongingId`),
  KEY `FK_shopapple_createrId` (`createrId`),
  KEY `FK_shopapple_belongingId` (`belongingId`),
  KEY `FK_shopapple_userId` (`userId`),
  KEY `FK_shopapple_depotInfoId` (`depotInfoId`),
  CONSTRAINT `FK_shopapple_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_shopapple_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_shopapple_depotInfoId` FOREIGN KEY (`depotInfoId`) REFERENCES `depotinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_shopapple_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shopapple` */

LOCK TABLES `shopapple` WRITE;

UNLOCK TABLES;

/*Table structure for table `shopapple_detail` */

DROP TABLE IF EXISTS `shopapple_detail`;

CREATE TABLE `shopapple_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `productStockId` bigint(20) DEFAULT NULL,
  `number` decimal(10,0) DEFAULT NULL,
  `shopAppleId` bigint(20) DEFAULT NULL,
  `realityNumber` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_shopapple_detail_createrId` (`createrId`),
  KEY `FK_shopapple_detail_belongingId` (`belongingId`),
  KEY `FK_shopapple_detail_shopAppleId` (`shopAppleId`),
  KEY `FK_shopapple_detail_productStockId` (`productStockId`),
  CONSTRAINT `FK_shopapple_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_shopapple_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_shopapple_detail_productStockId` FOREIGN KEY (`productStockId`) REFERENCES `productstock` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_shopapple_detail_shopAppleId` FOREIGN KEY (`shopAppleId`) REFERENCES `shopapple` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shopapple_detail` */

LOCK TABLES `shopapple_detail` WRITE;

UNLOCK TABLES;

/*Table structure for table `shopauditing` */

DROP TABLE IF EXISTS `shopauditing`;

CREATE TABLE `shopauditing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `shopAppleId` bigint(20) DEFAULT NULL,
  `auditorId` bigint(20) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `state` varchar(4) DEFAULT NULL,
  `sequence` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_shopauditing_createrId` (`createrId`),
  KEY `FK_shopauditing_belongingId` (`belongingId`),
  KEY `FK_shopauditing_shopAppleId` (`shopAppleId`),
  KEY `FK_shopauditing_auditorId` (`auditorId`),
  CONSTRAINT `FK_shopauditing_auditorId` FOREIGN KEY (`auditorId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_shopauditing_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_shopauditing_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_shopauditing_shopAppleId` FOREIGN KEY (`shopAppleId`) REFERENCES `shopapple` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shopauditing` */

LOCK TABLES `shopauditing` WRITE;

UNLOCK TABLES;

/*Table structure for table `temporaryactivity` */

DROP TABLE IF EXISTS `temporaryactivity`;

CREATE TABLE `temporaryactivity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_temporaryactivity_createrId` (`createrId`),
  KEY `FK_temporaryactivity_belongingId` (`belongingId`),
  CONSTRAINT `FK_temporaryactivity_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_temporaryactivity_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `temporaryactivity` */

LOCK TABLES `temporaryactivity` WRITE;

insert  into `temporaryactivity`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`name`,`remark`,`state`,`money`) values (3,0,'2015-10-09 11:02:51',NULL,2,2,'380元团购卡特享','',1,'380.00'),(4,0,'2015-10-09 11:33:27',NULL,2,2,'觅知音，享女王','',1,'3980.00');

UNLOCK TABLES;

/*Table structure for table `temporaryactivity_detail` */

DROP TABLE IF EXISTS `temporaryactivity_detail`;

CREATE TABLE `temporaryactivity_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  `temporaryActivityId` bigint(20) DEFAULT NULL,
  `marketingProjectId` bigint(20) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_temporaryactivity_detail_createrId` (`createrId`),
  KEY `FK_temporaryactivity_detail_belongingId` (`belongingId`),
  KEY `FK_temporaryactivity_detail_temporaryActivityId` (`temporaryActivityId`),
  KEY `FK_temporaryactivity_detail_marketingProjectId` (`marketingProjectId`),
  CONSTRAINT `FK_temporaryactivity_detail_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_temporaryactivity_detail_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_temporaryactivity_detail_marketingProjectId` FOREIGN KEY (`marketingProjectId`) REFERENCES `marketingproject` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_temporaryactivity_detail_temporaryActivityId` FOREIGN KEY (`temporaryActivityId`) REFERENCES `temporaryactivity` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `temporaryactivity_detail` */

LOCK TABLES `temporaryactivity_detail` WRITE;

insert  into `temporaryactivity_detail`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`belongingId`,`temporaryActivityId`,`marketingProjectId`,`number`,`money`) values (9,0,'2015-10-09 11:02:51',NULL,2,2,3,37,1,'350.00'),(10,0,'2015-10-09 11:02:51',NULL,2,2,3,38,1,'280.00'),(11,0,'2015-10-09 11:02:51',NULL,2,2,3,39,1,'380.00'),(12,0,'2015-10-09 11:02:51',NULL,2,2,3,40,1,'198.00'),(13,0,'2015-10-09 11:02:51',NULL,2,2,3,41,1,'268.00'),(14,0,'2015-10-09 11:02:51',NULL,2,2,3,42,1,'198.00'),(15,0,'2015-10-09 11:02:51',NULL,2,2,3,43,1,'198.00'),(16,0,'2015-10-09 11:02:51',NULL,2,2,3,44,1,'398.00'),(17,0,'2015-10-09 11:02:51',NULL,2,2,3,16,1,'240.00'),(18,0,'2015-10-09 11:33:27',NULL,2,2,4,46,5,'3490.00'),(19,0,'2015-10-09 11:33:27',NULL,2,2,4,38,20,'3960.00'),(20,0,'2015-10-09 11:33:27',NULL,2,2,4,37,15,'5250.00'),(21,0,'2015-10-09 11:33:27',NULL,2,2,4,39,20,'7600.00'),(22,0,'2015-10-09 11:33:27',NULL,2,2,4,43,1,'198.00'),(23,0,'2015-10-09 11:33:27',NULL,2,2,4,44,1,'398.00'),(24,0,'2015-10-09 11:33:27',NULL,2,2,4,40,1,'198.00'),(25,0,'2015-10-09 11:33:27',NULL,2,2,4,41,1,'268.00'),(26,0,'2015-10-09 11:33:27',NULL,2,2,4,42,1,'198.00');

UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

/*Data for the table `treeitem` */

LOCK TABLES `treeitem` WRITE;

insert  into `treeitem`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`nodeId`,`displayChildRen`,`label`,`action`,`target`,`sequence`,`belongingId`,`nodeType`) values (1,2,NULL,NULL,NULL,'system',0,'系统管理',NULL,'',99,NULL,'1'),(2,2,NULL,NULL,NULL,'system_treeItem',0,'模块管理','#{treeItemManageBean.getAll}','mainFrame',1,NULL,'1'),(3,3,NULL,NULL,1,'system_function',0,'功能管理','#{functionManageBean.getAll}','mainFrame',2,NULL,'1'),(8,3,'2014-10-01 00:00:00',NULL,1,'company',0,'用户管理',NULL,'',98,NULL,'1'),(9,3,'2014-10-01 00:00:00',NULL,1,'company_user',0,'用户管理','#{userManageBean.getAll}','mainFrame',1,NULL,'1'),(12,3,'2014-10-01 00:00:00',NULL,1,'company_role',0,'角色管理','#{roleManageBean.getAll}','mainFrame',2,NULL,'1'),(15,2,'2015-09-01 00:00:00',NULL,1,'custom',0,'客户档案管理',NULL,'',10,NULL,'1'),(27,2,'2015-09-01 00:00:00',NULL,1,'depot',1,'库存管理',NULL,'',70,NULL,'1'),(28,5,'2015-09-01 00:00:00',NULL,1,'depot_productStock',0,'产品库存管理','#{productStockManageBean.getAll}','mainFrame',2,NULL,'1'),(29,0,'2015-09-01 00:00:00',NULL,1,'depot_depotInfo',0,'仓库管理','#{depotInfoManageBean.getAll}','mainFrame',1,NULL,'1'),(30,1,'2015-09-01 00:00:00',NULL,1,'depot_depotImport',0,'库存导入','#{depotImportManageBean.getAll}','mainFrame',4,NULL,'1'),(31,1,'2015-09-01 00:00:00',NULL,1,'prepareGoods',1,'配货管理',NULL,'',80,NULL,'1'),(32,0,'2015-09-01 00:00:00',NULL,1,'prepareGoods_shopApple',0,'店铺申请配货','#{shopAppleManageBean.getAll}','mainFrame',1,NULL,'1'),(34,1,'2015-09-01 00:00:00',NULL,1,'purchase',1,'采购管理',NULL,'',90,NULL,'1'),(35,0,'2015-09-01 00:00:00',NULL,1,'purchase_productPurchase',0,'产品采购申请','#{productPurchaseManageBean.getAll}','mainFrame',1,NULL,'1'),(37,1,'2015-09-01 00:00:00',NULL,1,'auditing',1,'审核管理',NULL,'',91,NULL,'1'),(38,0,'2015-09-01 00:00:00',NULL,1,'auditing_purchaseAuditing',0,'产品采购审核','#{purchaseAuditingManageBean.getAll}','mainFrame',1,NULL,'1'),(39,0,'2015-09-01 00:00:00',NULL,1,'auditing_shopAuditing',0,'店铺配货审核','#{shopAuditingManageBean.getAll}','mainFrame',2,NULL,'1'),(40,1,'2015-09-01 00:00:00',NULL,1,'auditing_auditingSet',0,'审核流程配置','#{auditingSetManageBean.getAll}','mainFrame',3,NULL,'1'),(41,2,'2015-09-01 00:00:00',NULL,1,'shop',1,'店铺管理',NULL,'',9,NULL,'1'),(42,0,'2015-09-01 00:00:00',NULL,1,'shop_leaguer',0,'会员卡管理','#{leaguerManageBean.getAll}','mainFrame',1,NULL,'1'),(43,1,'2015-09-01 00:00:00',NULL,1,'shop_marketingProject',0,'营销项目管理','#{marketingProjectManageBean.getAll}','mainFrame',2,NULL,'1'),(44,2,'2015-09-01 00:00:00',NULL,1,'shop_temporaryActivity',0,'活动套餐','#{temporaryActivityManageBean.getAll}','mainFrame',3,NULL,'1'),(45,0,'2015-09-01 00:00:00',NULL,1,'custom_feedbackRecord',0,'客户反馈记录','#{feedbackRecordManageBean.getAll}','mainFrame',2,NULL,'1'),(46,0,'2015-09-01 00:00:00',NULL,1,'custom_consumptionRegister',0,'个人消费登记','#{consumptionRegisterManageBean.getAll}','mainFrame',3,NULL,'1'),(47,0,'2015-09-01 00:00:00',NULL,1,'custom_projectOperation',0,'项目操作记录','#{projectOperationManageBean.getAll}','mainFrame',4,NULL,'1'),(48,0,'2015-09-01 00:00:00',NULL,1,'custom_largessRecord',0,'赠送项目记录','#{largessRecordManageBean.getAll}','mainFrame',5,NULL,'1'),(49,0,'2015-09-01 00:00:00',NULL,1,'custom_marketingRecord',0,'产品销售记录','#{marketingRecordManageBean.getAll}','mainFrame',6,NULL,'1'),(50,0,'2015-09-01 00:00:00',NULL,1,'personnel',0,'人事管理',NULL,'',20,NULL,'1'),(51,1,'2015-09-01 00:00:00',NULL,1,'personnel_personnelInfo',0,'员工信息管理','#{personnelInfoManageBean.getAll}','mainFrame',1,NULL,'1'),(52,1,'2015-09-01 00:00:00',NULL,1,'statistics',1,'报表统计',NULL,'',92,NULL,'1'),(53,0,'2015-09-01 00:00:00',NULL,1,'statistics_customerSheet',0,'客户总报表','#{customerSheetManageBean.getAll}','mainFrame',1,NULL,'1'),(54,0,'2015-09-01 00:00:00',NULL,1,'statistics_personnelWork',0,'美容师工作表','#{personnelWorkManageBean.getAll}','mainFrame',2,NULL,'1'),(55,0,'2015-09-01 00:00:00',NULL,1,'shop_projectChange',0,'项目转换','#{projectChangeManageBean.getAll}','mainFrame',4,NULL,'1'),(56,0,'2015-09-01 00:00:00',NULL,1,'depot_productDepotAllot',0,'产品库存调拨','#{productDepotAllotManageBean.getAll}','mainFrame',3,NULL,'1'),(57,0,'2015-09-01 00:00:00',NULL,1,'purchase_supplier',0,'供货商信息','#{supplierManageBean.getAll}','mainFrame',2,NULL,'1'),(58,1,'2015-09-01 00:00:00',NULL,1,'custom_recharge',0,'个人充值记录','#{rechargeManageBean.getAll}','mainFrame',7,NULL,'1'),(59,0,'2015-10-01 00:00:00',NULL,1,'custom_mealBuyRecord',0,'套餐购买记录','#{mealBuyRecordManageBean.getAll}','mainFrame',8,NULL,'1'),(60,0,'2015-10-01 00:00:00',NULL,1,'custom_projectBuy',0,'项目购买记录','#{projectBuyManageBean.getAll}','mainFrame',9,NULL,'1'),(62,0,'2015-10-01 00:00:00',NULL,1,'baseSet',0,'基础配置',NULL,'',1,NULL,'1'),(63,0,'2015-10-01 00:00:00',NULL,1,'baseSet_brand',0,'品牌管理','#{brandManageBean.getAll}','mainFrame',1,NULL,'1'),(64,0,'2015-10-01 00:00:00',NULL,1,'baseSet_series',0,'系列设定','#{seriesManageBean.getAll}','mainFrame',2,NULL,'1'),(65,1,'2015-10-01 00:00:00',NULL,1,'baseSet_marketingProject',0,'服务管理','#{marketingProjectManageBean.getAll}','mainFrame',4,NULL,'1'),(66,1,'2015-10-01 00:00:00',NULL,1,'baseSet_productStock',0,'产品管理','#{productStockManageBean.getAll}','mainFrame',3,NULL,'1'),(67,0,'2015-10-01 00:00:00',NULL,1,'baseSet_temporaryActivity',0,'套餐管理','#{temporaryActivityManageBean.getAll}','mainFrame',5,NULL,'1'),(68,0,'2015-10-01 00:00:00',NULL,1,'baseSet_leaguer',0,'卡项管理','#{leaguerManageBean.getAll}','mainFrame',6,NULL,'1'),(69,0,'2015-10-01 00:00:00',NULL,1,'baseSet_giveInfo',0,'体验卡','#{giveInfoManageBean.getAll}','mainFrame',7,NULL,'1'),(70,2,'2015-10-01 00:00:00',NULL,1,'baseSet_customInfo',0,'客户信息','#{customInfoManageBean.getAll}','mainFrame',10,NULL,'1'),(72,0,'2015-10-01 00:00:00',NULL,1,'baseSet_cashRoll',0,'现金卷','#{giveInfoManageBean.getAllCashRoll}','mainFrame',8,NULL,'1'),(73,0,'2015-10-01 00:00:00',NULL,1,'baseSet_bodyVolume',0,'身体卷','#{giveInfoManageBean.getAllBodyVolume}','mainFrame',9,NULL,'1');

UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

LOCK TABLES `user` WRITE;

insert  into `user`(`id`,`version`,`userName`,`loginName`,`password`,`stop`,`userTel`,`userMobile1`,`lastLoginTime`,`loginTime`,`createDate`,`updateDate`,`createrId`,`belongingId`,`userlevel`) values (1,248,'系统管理员','zjls','HzfrdDg28Hc=','2','89898989898','23423423423',NULL,'2015-11-17 16:03:41',NULL,'2015-10-28 11:19:54',NULL,NULL,'1'),(2,314,'香度香生','xdxs','PIN4pWuHaGM=','2','057989898989','13745678910',NULL,'2015-11-18 14:34:10','2015-10-04 10:53:14','2015-10-28 13:59:32',1,1,'2'),(3,89,'第一店','jnd','WpVRg6fMrxA=','2','','',NULL,'2015-11-07 20:25:00','2015-10-28 20:50:00','2015-10-28 20:50:47',2,2,'4'),(4,2,'公司主管','gszg','XRpU60Ad+dU=','2','','',NULL,'2015-11-01 17:09:53','2015-10-28 20:50:18',NULL,2,2,'3'),(5,0,'第一店管理远','dygly','oE832CrzpB4=','2','','',NULL,NULL,'2015-10-28 20:51:33',NULL,3,3,'5'),(6,2,'xdxs2','xdxs2','e6qZ8x+HKLo=','2','','',NULL,'2015-11-01 15:26:35','2015-10-29 13:59:54',NULL,1,1,'2'),(7,0,'张三','zs','gz3JKbdhDBA=','2','','',NULL,NULL,'2015-10-29 14:00:24',NULL,6,6,'3'),(8,0,'下属公司','xsgs','0nMFC6zLonQ=','2','','',NULL,NULL,'2015-10-29 14:00:40',NULL,6,6,'4'),(9,1,'第二家美容店','dej','wVKWsU5KcYc=','2','','',NULL,NULL,'2015-11-01 15:16:58',NULL,1,1,'2'),(10,2,'第二家店','jbd','739BNZidwUE=','2','','',NULL,'2015-11-05 14:52:26','2015-11-01 15:28:20',NULL,2,2,'4');

UNLOCK TABLES;

/*Table structure for table `user_depot` */

DROP TABLE IF EXISTS `user_depot`;

CREATE TABLE `user_depot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `createrId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `depotInfoId` bigint(20) DEFAULT NULL,
  `belongingId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_depot_createrId` (`createrId`),
  KEY `FK_user_depot_belongingId` (`belongingId`),
  KEY `FK_user_depot_userId` (`userId`),
  KEY `FK_user_depot_depotInfoId` (`depotInfoId`),
  CONSTRAINT `FK_user_depot_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_depot_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_user_depot_depotInfoId` FOREIGN KEY (`depotInfoId`) REFERENCES `depotinfo` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_user_depot_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_depot` */

LOCK TABLES `user_depot` WRITE;

UNLOCK TABLES;

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
  CONSTRAINT `FK_leaguer_userrole_createrId` FOREIGN KEY (`createrId`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_userrole_roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_leaguer_userrole_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_role_belongingId` FOREIGN KEY (`belongingId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

LOCK TABLES `user_role` WRITE;

insert  into `user_role`(`id`,`version`,`createDate`,`updateDate`,`createrId`,`userId`,`roleId`,`belongingId`) values (15,0,'2015-10-28 13:59:32',NULL,2,2,1,NULL),(18,0,'2015-10-28 20:50:18',NULL,2,4,3,NULL),(19,0,'2015-10-28 20:50:47',NULL,2,3,2,NULL),(20,0,'2015-10-29 13:59:54',NULL,1,6,1,NULL),(21,0,'2015-11-01 15:16:58',NULL,1,9,1,NULL),(22,0,'2015-11-01 15:28:20',NULL,2,10,2,NULL);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
