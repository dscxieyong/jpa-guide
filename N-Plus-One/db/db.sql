CREATE DATABASE  IF NOT EXISTS `jpa-n-plus-one` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jpa-n-plus-one`;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `jpa_area`;
CREATE TABLE `jpa_area` (
                        `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        `parent_id` int(10),
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jpa_category`;
CREATE TABLE `jpa_category` (
                             `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                             `name` varchar(255) DEFAULT NULL,
                             `parent_id` int(10),
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

