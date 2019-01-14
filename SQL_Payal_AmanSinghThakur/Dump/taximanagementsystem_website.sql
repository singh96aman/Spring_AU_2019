-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: taximanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `website`
--

DROP TABLE IF EXISTS `website`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `website` (
  `name` varchar(50) NOT NULL,
  `taxiNumber` varchar(10) NOT NULL,
  `customerID` varchar(10) NOT NULL,
  `routeTaken` varchar(50) NOT NULL,
  `amountPaid` float NOT NULL,
  PRIMARY KEY (`name`),
  KEY `taxiNumber` (`taxiNumber`),
  KEY `customerID` (`customerID`),
  CONSTRAINT `website_ibfk_1` FOREIGN KEY (`taxiNumber`) REFERENCES `taxi` (`taxinumber`),
  CONSTRAINT `website_ibfk_2` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `website`
--

LOCK TABLES `website` WRITE;
/*!40000 ALTER TABLE `website` DISABLE KEYS */;
INSERT INTO `website` VALUES ('OLA123','CHD1231','af2322','AccoliteToCisco',10000),('OLA23','HR123PQ','as12ss','Bellandur NH4',140),('OLA56','GUJ3242','wq23q','KormanglatoAESClayout',100),('Uber123','BNG2213','pqr123','Marathalli Bridge',200),('Uber321','LKO2312','abc456','PESIT to Accolite',350);
/*!40000 ALTER TABLE `website` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-14 16:16:15
