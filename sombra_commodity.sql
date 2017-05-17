-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sombra
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `material_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrl43ktbo3id0lg7l64jvgdynd` (`category_id`),
  KEY `FKoh5he0crq454d2gujypo5hxal` (`country_id`),
  KEY `FKfdshmqatstiirr093ngq42ar9` (`material_id`),
  CONSTRAINT `FKfdshmqatstiirr093ngq42ar9` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  CONSTRAINT `FKoh5he0crq454d2gujypo5hxal` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `FKrl43ktbo3id0lg7l64jvgdynd` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (1,'Золота каблучка',1500,1,2,1),(2,'Срібна каблучка',800,1,2,2),(3,'Золотий ланцюжок',1700,3,2,1),(4,'Срібний ланцюжок',1000,3,2,2),(5,'Золоті сережки',5000,2,2,1),(6,'Срібні сережки',4000,2,2,2),(7,'Золота підвіска',4000,4,2,1),(8,'Срібна підвіска',3000,4,2,2);
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-17 22:36:30
