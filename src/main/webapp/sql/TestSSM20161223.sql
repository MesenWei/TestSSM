/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.26 : Database - wms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wms`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `CNO` varchar(5) NOT NULL,
  `CNAME` varchar(10) NOT NULL,
  `TNO` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`CNO`,`CNAME`,`TNO`) values ('3-105','计算机导论','825'),('3-245','操作系统','804'),('6-166','数据电路','856'),('9-888','高等数学','100');

/*Table structure for table `my_class` */

DROP TABLE IF EXISTS `my_class`;

CREATE TABLE `my_class` (
  `id` varchar(255) NOT NULL,
  `class_name` varchar(50) DEFAULT NULL,
  `student_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `my_class` */

/*Table structure for table `my_course` */

DROP TABLE IF EXISTS `my_course`;

CREATE TABLE `my_course` (
  `id` varchar(255) NOT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `my_course` */

insert  into `my_course`(`id`,`student_id`,`name`,`note`) values ('1','a','语文',NULL),('2','a','数学',NULL),('3','b','英语',NULL),('4','b','生物',NULL),('5','c','历史',NULL),('6','c','地理',NULL);

/*Table structure for table `my_student` */

DROP TABLE IF EXISTS `my_student`;

CREATE TABLE `my_student` (
  `id` varchar(255) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `classid` varchar(255) DEFAULT NULL,
  `yuwen` decimal(10,0) DEFAULT NULL,
  `shuxue` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `my_student` */

insert  into `my_student`(`id`,`name`,`classid`,`yuwen`,`shuxue`) values ('a','阿堂','1','96','90'),('b','茂盛','1','95','99'),('c','燕红','2','93','98');

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `SNO` varchar(3) NOT NULL,
  `CNO` varchar(5) NOT NULL,
  `DEGREE` decimal(10,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `score` */

insert  into `score`(`SNO`,`CNO`,`DEGREE`) values ('103','3-245','86.0'),('105','3-245','75.0'),('109','3-245','68.0'),('103','3-105','92.0'),('105','3-105','88.0'),('109','3-105','76.0'),('101','3-105','64.0'),('107','3-105','91.0'),('108','3-105','78.0'),('101','6-166','85.0'),('107','6-106','79.0'),('108','6-166','80.0');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `SNO` varchar(3) NOT NULL,
  `SNAME` varchar(4) NOT NULL,
  `SSEX` varchar(2) NOT NULL,
  `SBIRTHDAY` datetime DEFAULT NULL,
  `CLASS` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`SNO`,`SNAME`,`SSEX`,`SBIRTHDAY`,`CLASS`) values ('108','曾华','男','0000-00-00 00:00:00','95033'),('105','匡明','男','0000-00-00 00:00:00','95031'),('107','王丽','女','0000-00-00 00:00:00','95033'),('101','李军','男','0000-00-00 00:00:00','95033'),('109','王芳','女','0000-00-00 00:00:00','95031'),('103','陆君','男','0000-00-00 00:00:00','95031');

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`name`) values ('1','bookkkkkkkkkkkkk');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `TNO` varchar(3) NOT NULL,
  `TNAME` varchar(4) NOT NULL,
  `TSEX` varchar(2) NOT NULL,
  `TBIRTHDAY` datetime NOT NULL,
  `PROF` varchar(6) DEFAULT NULL,
  `DEPART` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`TNO`,`TNAME`,`TSEX`,`TBIRTHDAY`,`PROF`,`DEPART`) values ('804','李诚','男','1958-12-02 00:00:00','副教授','计算机系'),('856','张旭','男','1969-03-12 00:00:00','讲师','电子工程系'),('825','王萍','女','1972-05-05 00:00:00','助教','计算机系'),('831','刘冰','女','1977-08-14 00:00:00','助教','电子工程系');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
