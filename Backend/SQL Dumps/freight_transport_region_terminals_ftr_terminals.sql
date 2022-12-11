CREATE DATABASE  IF NOT EXISTS `freight_transport_region_terminals` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `freight_transport_region_terminals`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: freight_transport_region_terminals
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
-- Table structure for table `ftr_terminals`
--

DROP TABLE IF EXISTS `ftr_terminals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ftr_terminals` (
  `terminal_id` varchar(20) NOT NULL,
  `available_capacity` bigint NOT NULL,
  `capacity` bigint NOT NULL,
  `country` varchar(255) NOT NULL,
  `harbor_location` varchar(255) NOT NULL,
  `item_type` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `terminal_description` varchar(255) NOT NULL,
  `terminal_name` varchar(255) NOT NULL,
  PRIMARY KEY (`terminal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ftr_terminals`
--

LOCK TABLES `ftr_terminals` WRITE;
/*!40000 ALTER TABLE `ftr_terminals` DISABLE KEYS */;
INSERT INTO `ftr_terminals` VALUES ('T1',10000,30000,'India','Chennai Port','Computer Hardware','Available','T1-\nComputer Hardware','Kakinada'),('T10',20000,94700,'Australia','Sydney Harbor','Electronics','Available','T10-\nElectronics','Fremantle'),('T2',10000,40000,'India','Paradip Port','Oil Container','NotAvailable','T2-Oil\nContainer','Hazira'),('T3',78000,85000,'Singapore','Jurong','Wood','Available','T3-\nWood','Klang'),('T4',73000,85000,'Canada','Port Hawkesbury','Motorcycles','Available','T4-\nMotorcycles','Saint John'),('T5',12000,50000,'Australia','Sydney Harbor','Electronics','NotAvailable','T5-\nElectronics','Brisbane'),('T6',19000,37500,'India','Visakhapatnam Port','Computer Hardware','NotAvailable','T6-\nComputer Hardware','Haldia'),('T7',50000,89000,'Singapore','Tanjong Pagar','Oil Container','Available','T7-Oil\nContainer','Tanjung'),('T8',9900,24900,'South Korea','Busan Port','Wood','NotAvailable','T8-\nWood','Busan'),('T9',24000,87000,'Canada','Halifax','Motorcycles','NotAvailable','T9-\nMotorcycles','Montreal');
/*!40000 ALTER TABLE `ftr_terminals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-25 17:40:24
