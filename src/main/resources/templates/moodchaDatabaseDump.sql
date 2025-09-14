-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: moodcha
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `juice_recipes`
--

DROP TABLE IF EXISTS `juice_recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `juice_recipes` (
  `id` char(36) NOT NULL,
  `mood` varchar(30) DEFAULT NULL,
  `flavour` varchar(30) DEFAULT NULL,
  `temperature` varchar(30) NOT NULL,
  `syrup` varchar(30) DEFAULT NULL,
  `supplements` varchar(255) DEFAULT NULL,
  `allergies` varchar(255) DEFAULT NULL,
  `juice` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juice_recipes`
--

LOCK TABLES `juice_recipes` WRITE;
/*!40000 ALTER TABLE `juice_recipes` DISABLE KEYS */;
INSERT INTO `juice_recipes` VALUES ('1caa49d5-4377-4af1-9f23-3ed9f8c7a0b4','ENERGETIC','BITTER','ICED','STRAWBERRY',NULL,NULL,'COW'),('e7a4c1b2-2d4b-4d6a-b6c0-0aef9f2e45d3','ANXIOUS','SWEET','ICED','BLUEBERRY','PROTEIN',NULL,'COCONUT');
/*!40000 ALTER TABLE `juice_recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milk_recipes`
--

DROP TABLE IF EXISTS `milk_recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `milk_recipes` (
  `id` char(36) NOT NULL,
  `mood` varchar(30) DEFAULT NULL,
  `flavour` varchar(30) DEFAULT NULL,
  `temperature` varchar(30) NOT NULL,
  `syrup` varchar(30) DEFAULT NULL,
  `supplements` varchar(255) DEFAULT NULL,
  `allergies` varchar(255) DEFAULT NULL,
  `milk` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milk_recipes`
--

LOCK TABLES `milk_recipes` WRITE;
/*!40000 ALTER TABLE `milk_recipes` DISABLE KEYS */;
INSERT INTO `milk_recipes` VALUES ('9f5e22b4-9a9a-4b67-8e9f-86c1f2a3f7e0','CALM','SWEET','HOT','VANILLA','MAGNESIUM',NULL,'RICE'),('b3c7d8a0-55d1-4d0d-9b2e-6f2d5b63c2fa','HAPPY','FRUITY','ICED','MANGO',NULL,NULL,'OAT');
/*!40000 ALTER TABLE `milk_recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `water_recipes`
--

DROP TABLE IF EXISTS `water_recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `water_recipes` (
  `id` char(36) NOT NULL,
  `mood` varchar(30) DEFAULT NULL,
  `flavour` varchar(30) DEFAULT NULL,
  `temperature` varchar(30) NOT NULL,
  `syrup` varchar(30) DEFAULT NULL,
  `supplements` varchar(255) DEFAULT NULL,
  `allergies` varchar(255) DEFAULT NULL,
  `water` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `water_recipes`
--

LOCK TABLES `water_recipes` WRITE;
/*!40000 ALTER TABLE `water_recipes` DISABLE KEYS */;
INSERT INTO `water_recipes` VALUES ('a6f19c3d-8e7c-4c1b-b9b7-2c06d48d36ab','TIRED','NUTTY','HOT','AGAVE','IRON',NULL,'STILL'),('d4f0e5b7-3a20-46d1-94e8-1b0cecc82461','SAD','SWEET','HOT','PISTACHIO','VITAMIN-B12','DAIRY','SOY');
/*!40000 ALTER TABLE `water_recipes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-14 19:16:36
