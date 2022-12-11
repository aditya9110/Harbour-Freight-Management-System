CREATE DATABASE  IF NOT EXISTS `freight_transport_region_vehicles` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `freight_transport_region_vehicles`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: freight_transport_region_vehicles
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
-- Table structure for table `ftr_vehicles`
--

DROP TABLE IF EXISTS `ftr_vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ftr_vehicles` (
  `vehicle_number` varchar(20) NOT NULL,
  `vehicle_name` varchar(50) DEFAULT NULL,
  `max_lifting_capacity` bigint DEFAULT NULL,
  `retire_date` date DEFAULT NULL,
  `vehicle_status` varchar(30) DEFAULT NULL,
  `harbor_location` varchar(30) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`vehicle_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ftr_vehicles`
--

LOCK TABLES `ftr_vehicles` WRITE;
/*!40000 ALTER TABLE `ftr_vehicles` DISABLE KEYS */;
INSERT INTO `ftr_vehicles` VALUES ('BH2343','Aerial crane',1000,'2022-01-21','InProgress','Sydney Harbor','Australia'),('CT7867','Crawler crane',550,'2024-05-27','InActive','Busan Port','South\nKorea'),('DG8986','Double treadwheel crane',3,'2025-03-22','InProgress','Jurong','Singapore'),('ER5849','Deck crane',40,'2032-09-28','Active','Halifax','Canada'),('KY8876','Tower crane',20,'2030-06-29','InActive','Sydney Harbor','Australia'),('NM1012','Fireplace crane',3,'2025-03-22','InActive','Visakhapatnam Port','India'),('SD3456','Double treadwheel crane',3,'2030-12-26','Active','Tanjong Pagar','Singapore'),('UE7890','Tower crane',20,'2030-12-20','Active','Chennai Port','India'),('UE7891','Tower crane',20,'2030-12-20','Active','Chennai Port','India'),('VQ7890','Crawler crane',250,'2030-12-23','InProgress','Port Hawkesbury','Canada'),('WK7876','Fireplace crane',7100,'2022-01-21','InProgress','Paradip Port','India');
/*!40000 ALTER TABLE `ftr_vehicles` ENABLE KEYS */;
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
