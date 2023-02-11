

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`airline-ticket-spb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `airline-ticket-spb`;

/*Table structure for table `a_airport` */

DROP TABLE IF EXISTS `a_airport`;

CREATE TABLE `a_airport` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime DEFAULT NULL,
  `address` varchar(225) DEFAULT NULL,
  `city` varchar(225) DEFAULT NULL,
  `code` varchar(225) DEFAULT NULL,
  `country` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `state` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `a_airport` */

insert  into `a_airport`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`address`,`city`,`code`,`country`,`name`,`state`) values (1,NULL,NULL,NULL,NULL,'sadcwdsvcwerfc','indon','12345','India','Devijo','Mp'),(2,NULL,NULL,NULL,NULL,'Proident deserunt m','Officia iste dolor r','585466552','Magnam iusto dolorem','Walker Cotton','Ab necessitatibus qu'),(3,NULL,NULL,NULL,NULL,'','','','','','');

/*Table structure for table `f_flight` */

DROP TABLE IF EXISTS `f_flight`;

CREATE TABLE `f_flight` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime DEFAULT NULL,
  `pnr` varchar(225) DEFAULT NULL,
  `flight_no` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `f_flight` */

insert  into `f_flight`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`pnr`,`flight_no`,`name`) values (1,NULL,NULL,NULL,NULL,'ascsad','123456','Indigo');

/*Table structure for table `f_invoice` */

DROP TABLE IF EXISTS `f_invoice`;

CREATE TABLE `f_invoice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime DEFAULT NULL,
  `arrival_date` varchar(255) DEFAULT NULL,
  `departure_date` varchar(255) DEFAULT NULL,
  `flight_name` varchar(255) DEFAULT NULL,
  `flight_no` varchar(255) DEFAULT NULL,
  `invoice_no` bigint(20) NOT NULL,
  `nop` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `total_price` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `total_amount` varchar(255) DEFAULT NULL,
  `no_of_person` varchar(225) DEFAULT NULL,
  `arrival_city` varchar(225) DEFAULT NULL,
  `departure_city` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `f_invoice` */

insert  into `f_invoice`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`arrival_date`,`departure_date`,`flight_name`,`flight_no`,`invoice_no`,`nop`,`price`,`total_price`,`user_id`,`user_name`,`total_amount`,`no_of_person`,`arrival_city`,`departure_city`) values (20,NULL,NULL,NULL,NULL,'2022-01-09',NULL,'Indigo','123456',5712,NULL,'2000',NULL,2,'Hari Om','4000','2','Bharat','Pakistan'),(19,NULL,NULL,NULL,NULL,'2022-01-09',NULL,'Indigo','123456',31915,NULL,'2000',NULL,2,'Hari Om','6000','3','Indore','Bhopal'),(18,NULL,NULL,NULL,NULL,'2022-01-09',NULL,'Indigo','123456',21057,NULL,'2000',NULL,2,'Hari Om','6000','3','Indore','Bhopal');

/*Table structure for table `f_invoice_detail` */

DROP TABLE IF EXISTS `f_invoice_detail`;

CREATE TABLE `f_invoice_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime DEFAULT NULL,
  `arrival_city` varchar(225) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `departure_city` varchar(225) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `flight_name` varchar(225) DEFAULT NULL,
  `flight_no` varchar(225) DEFAULT NULL,
  `gender` varchar(225) DEFAULT NULL,
  `invoice_no` bigint(20) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `price` varchar(225) DEFAULT NULL,
  `seat_no` varchar(225) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `f_invoice_detail` */

insert  into `f_invoice_detail`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`arrival_city`,`date`,`departure_city`,`dob`,`flight_name`,`flight_no`,`gender`,`invoice_no`,`name`,`price`,`seat_no`,`user_id`) values (31,NULL,NULL,NULL,NULL,'Bharat','2020-10-15','Pakistan',NULL,'Indigo','123456','Voluptatem repudiand',5712,'Wynter Byers','2000',NULL,2),(30,NULL,NULL,NULL,NULL,'Bharat','2020-10-15','Pakistan',NULL,'Indigo','123456','Quod nulla rerum sun',5712,'Elliott Sanchez','2000',NULL,2),(29,NULL,NULL,NULL,NULL,'Indore','2020-10-15','Bhopal','2002-10-20','Indigo','123456','Expedita rem eligend',31915,'Clark Franklin','2000',NULL,2),(28,NULL,NULL,NULL,NULL,'Indore','2020-10-15','Bhopal','2003-10-20','Indigo','123456','Recusandae Tenetur ',31915,'Aretha Barr','2000',NULL,2),(27,NULL,NULL,NULL,NULL,'Indore','2020-10-15','Bhopal','2004-10-20','Indigo','123456','Aut recusandae Eum ',31915,'Rogan Rios','2000',NULL,2),(26,NULL,NULL,NULL,NULL,'Indore','2020-10-15','Bhopal','2004-08-20','Indigo','123456','Distinctio Nihil ei',21057,'Fletcher Campbell','2000',NULL,2),(25,NULL,NULL,NULL,NULL,'Indore','2020-10-15','Bhopal','2002-08-20','Indigo','123456','Eaque dolor et dolor',21057,'Alexis Stephenson','2000',NULL,2),(24,NULL,NULL,NULL,NULL,'Indore','2020-10-15','Bhopal','2003-08-20','Indigo','123456','Sed unde quaerat vol',21057,'Hakeem Barnett','2000',NULL,2);

/*Table structure for table `f_manage_flight` */

DROP TABLE IF EXISTS `f_manage_flight`;

CREATE TABLE `f_manage_flight` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime DEFAULT NULL,
  `arrival_airport_id` bigint(20) DEFAULT NULL,
  `arrival_airport_name` varchar(225) DEFAULT NULL,
  `arrival_date` date DEFAULT NULL,
  `arrival_time` varchar(225) DEFAULT NULL,
  `departure_airport_id` bigint(20) DEFAULT NULL,
  `departure_airport_name` varchar(225) DEFAULT NULL,
  `departure_date` date DEFAULT NULL,
  `departure_time` varchar(225) DEFAULT NULL,
  `flight_id` bigint(20) DEFAULT NULL,
  `flight_name` varchar(225) DEFAULT NULL,
  `flight_no` varchar(225) DEFAULT NULL,
  `price` varchar(225) DEFAULT NULL,
  `arrival_city` varchar(225) DEFAULT NULL,
  `departure_city` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `f_manage_flight` */

insert  into `f_manage_flight`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`arrival_airport_id`,`arrival_airport_name`,`arrival_date`,`arrival_time`,`departure_airport_id`,`departure_airport_name`,`departure_date`,`departure_time`,`flight_id`,`flight_name`,`flight_no`,`price`,`arrival_city`,`departure_city`) values (1,NULL,NULL,NULL,NULL,1,'Devijo','2022-01-09','10 : 00 AM',2,'Walker Cotton','2022-02-09','9 : 00 PM',1,'Indigo','123456','2000','Afganistan','Japan'),(2,NULL,NULL,NULL,NULL,1,'Devijo','2022-01-09','10 : 00 AM',2,'Walker Cotton','2022-02-09','9 : 00 PM',1,'Indigo','123456','2000','Indore','Bhopal'),(3,NULL,NULL,NULL,NULL,1,'Devijo','2022-01-09','10 : 00 AM',2,'Walker Cotton','2022-02-09','9 : 00 PM',1,'Indigo','123456','2000','Bharat','Pakistan');

/*Table structure for table `l_user` */

DROP TABLE IF EXISTS `l_user`;

CREATE TABLE `l_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `first_name` varchar(225) DEFAULT NULL,
  `gender` varchar(225) DEFAULT NULL,
  `last_name` varchar(225) DEFAULT NULL,
  `login` varchar(225) DEFAULT NULL,
  `mobile_no` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `city` varchar(225) DEFAULT NULL,
  `country` varchar(225) DEFAULT NULL,
  `state` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `l_user` */

insert  into `l_user`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`dob`,`email`,`first_name`,`gender`,`last_name`,`login`,`mobile_no`,`password`,`role_id`,`city`,`country`,`state`) values (1,NULL,NULL,NULL,NULL,NULL,'gopozu@mailinator.com','Cameron','Female','Sharpe','Admin@gmail.com','Et consequatur nemo ','Admin@123',1,'Exercitation et temp','Est repellendus Et','Aut earum expedita v'),(2,NULL,NULL,NULL,NULL,'2020-10-10','Hariom@gmail.com','Hari','Male','Om','Hari123','9685456585','Hari@123',2,'Indore','India','M.P');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
