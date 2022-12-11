CREATE DATABASE  IF NOT EXISTS `freight_transport_region_workitems` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `freight_transport_region_workitems`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: freight_transport_region_workitems
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ftr_workitems`
--

DROP TABLE IF EXISTS `ftr_workitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ftr_workitems` (
  `workitem_id` varchar(20) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `item_name` varchar(200) DEFAULT NULL,
  `item_type` varchar(200) DEFAULT NULL,
  `item_description` varchar(200) DEFAULT NULL,
  `message_to_recipient` varchar(200) DEFAULT NULL,
  `quantity` varchar(100) DEFAULT NULL,
  `source_country` varchar(30) DEFAULT NULL,
  `destination_country` varchar(30) DEFAULT NULL,
  `selected_harbor_location` varchar(200) DEFAULT NULL,
  `shipping_date` date DEFAULT NULL,
  `amount` bigint DEFAULT NULL,
  `origin_harbor_location` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`workitem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ftr_workitems`
--

LOCK TABLES `ftr_workitems` WRITE;
/*!40000 ALTER TABLE `ftr_workitems` DISABLE KEYS */;
INSERT INTO `ftr_workitems` VALUES ('J2012',10001,'UPS','Computer Hardware','Luminous Inverter battery','Please confirm once\nreceived.','7500','India','Singapore',NULL,'2022-07-23',119992500,NULL),('J2013',10001,'Aviation Turbine Fuel','Oil Container','Fuel for Jet','Please confirm once received.','9200 lit','Singapore','Malaysia','Johor Port','2022-08-24',207368,NULL),('J2014',10003,'Round pole milling machine','Wood','EMTEX 20mm Drilling and Milling Machine\nDM20','Please confirm once received.','1500','India','Australia','Sydney Harbor','2020-10-17',195000000,NULL),('J2015',10004,'Honda Dio','Motorcycles','Honda','Please confirm once received.','1331','India','Canada','Port Hawkesbury','2020-11-04',84300216,NULL),('J2016',10005,'Washing Machine','Electronics','Whirlpool 6.5 Kg Fully-Automatic Top Load','Please\nconfirm once received.','3000','India','Singapore','Jurong','2020-11-09',40470000,NULL);
/*!40000 ALTER TABLE `ftr_workitems` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-25 17:44:29
