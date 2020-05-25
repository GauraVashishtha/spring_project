CREATE DATABASE  IF NOT EXISTS `spring_demo_project` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `spring_demo_project`;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `customer` WRITE;

INSERT INTO `customer` VALUES 
	(1,'David','Adams','david@gmail.com'),
	(2,'John','Doe','john@gmail.com'),
	(3,'Ajay','Rao','ajay@gmail.com'),
	(4,'Mary','Public','mary@gmail.com'),
	(5,'Maxwell','Dixon','max@gmail.com');

UNLOCK TABLES;
