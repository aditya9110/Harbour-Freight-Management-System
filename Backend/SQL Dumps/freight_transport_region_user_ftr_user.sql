CREATE DATABASE  IF NOT EXISTS `freight_transport_region_user` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `freight_transport_region_user`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: freight_transport_region_user
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
-- Table structure for table `ftr_user`
--

DROP TABLE IF EXISTS `ftr_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ftr_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `email_id` varchar(30) DEFAULT NULL,
  `mobile_number` bigint DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `nationality` varchar(30) DEFAULT NULL,
  `passport_number` varchar(30) DEFAULT NULL,
  `permanent_address` varchar(200) DEFAULT NULL,
  `office_address` varchar(200) DEFAULT NULL,
  `personal_identification_number` bigint DEFAULT NULL,
  `user_type` bit(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10007 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ftr_user`
--

LOCK TABLES `ftr_user` WRITE;
/*!40000 ALTER TABLE `ftr_user` DISABLE KEYS */;
INSERT INTO `ftr_user` VALUES (10001,'Annie','Thomas','anniethomas@gmail.com',9090987990,'anniethomas!12','Indian','A7878765','295/12, Cross, Lalbagh Road, K S Garden,  Bangalore.','16 , Gandhibazaarmnrd,basavangudi,b-, Basavanagudi, Bangalore.',676767898765,_binary '\0'),(10002,'Mike','Hillyer','mikehillyer@yahoo.com',9090456789,'mikehillyer@12','Indian','H3489098','261/67,\nAngappa Naick St, Parrys, Chennai','260 Mint Street, Periamet, Chennai.',345678902345,_binary '\0'),(10003,'Jon','Stephens','jonstephens@gmail.com',8767890654,'jonstephens!12','Singapore','U7643289','Chao\nChu Kang Crescent, Singapore','1 SENGKANG SQUARE, #02-18 545078, Singapore.',676767854323,_binary '\0');
/*!40000 ALTER TABLE `ftr_user` ENABLE KEYS */;
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
