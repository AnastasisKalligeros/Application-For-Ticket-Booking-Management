CREATE DATABASE  IF NOT EXISTS `cinema_last` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cinema_last`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema_last
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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `ID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `username` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`,`username`),
  KEY `fk_ADMINS_user1_idx` (`username`),
  CONSTRAINT `fk_ADMINS_user1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES (2,'Maria','admaria'),(3,'Chris','adchris'),(4,'Makis','makis');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinemas`
--

DROP TABLE IF EXISTS `cinemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinemas` (
  `ID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `SEATS` varchar(45) NOT NULL,
  `3D` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinemas`
--

LOCK TABLES `cinemas` WRITE;
/*!40000 ALTER TABLE `cinemas` DISABLE KEYS */;
INSERT INTO `cinemas` VALUES (1,'Αίθουσα 1','380','No'),(3,'Αίθουσα 3','230','Yes');
/*!40000 ALTER TABLE `cinemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_admin`
--

DROP TABLE IF EXISTS `content_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content_admin` (
  `ID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `username` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`,`username`),
  KEY `fk_CONTENT_ADMIN_user1_idx` (`username`),
  CONSTRAINT `fk_CONTENT_ADMIN_user1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_admin`
--

LOCK TABLES `content_admin` WRITE;
/*!40000 ALTER TABLE `content_admin` DISABLE KEYS */;
INSERT INTO `content_admin` VALUES (1,'Takis','takis'),(4,'Spyros','conspyros');
/*!40000 ALTER TABLE `content_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `ID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `username` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`,`username`),
  KEY `fk_CUSTOMERS_user1_idx` (`username`),
  CONSTRAINT `fk_CUSTOMERS_user1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Kwstas','kpap'),(12312,'Panagiwtis','panos');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `ID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `CONTENT` varchar(45) NOT NULL,
  `LENGTH` int NOT NULL,
  `TYPE` varchar(45) NOT NULL,
  `SUMMARY` varchar(600) NOT NULL,
  `DIRECTOR` varchar(45) NOT NULL,
  `CONTENT_ADMIN_ID` int NOT NULL,
  `CINEMAS_ID` int NOT NULL,
  `TIME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`,`NAME`,`CONTENT_ADMIN_ID`),
  KEY `fk_MOVIES_CONTENT_ADMIN1_idx` (`CONTENT_ADMIN_ID`),
  KEY `fk_CINEMAS_ID_idx` (`CINEMAS_ID`),
  CONSTRAINT `fk_CINEMAS_ID` FOREIGN KEY (`CINEMAS_ID`) REFERENCES `cinemas` (`ID`),
  CONSTRAINT `fk_MOVIES_CONTENT_ADMIN1` FOREIGN KEY (`CONTENT_ADMIN_ID`) REFERENCES `content_admin` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Titanic','Teen',194,'Drama','The RMS Titanic, a luxury steamship, sank in ','James Cameron',1,1,'20:00'),(2,'Shark','R',90,'Violence','A shark is going berserk but the Alpha force ','George Lucas',4,3,'22:00');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provoles`
--

DROP TABLE IF EXISTS `provoles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provoles` (
  `MOVIES_ID` int NOT NULL,
  `MOVIES_NAME` varchar(45) NOT NULL,
  `CINEMAS_ID` int NOT NULL,
  `ID` varchar(45) NOT NULL,
  `CONTENT_ADMIN_ID` int NOT NULL,
  `time` varchar(45) NOT NULL,
  PRIMARY KEY (`MOVIES_ID`,`MOVIES_NAME`,`CINEMAS_ID`,`CONTENT_ADMIN_ID`),
  KEY `fk_MOVIES_has_CINEMAS_CINEMAS1_idx` (`CINEMAS_ID`),
  KEY `fk_MOVIES_has_CINEMAS_MOVIES_idx` (`MOVIES_ID`,`MOVIES_NAME`),
  KEY `fk_PROVOLES_CONTENT_ADMIN1_idx` (`CONTENT_ADMIN_ID`),
  CONSTRAINT `fk_MOVIES_has_CINEMAS_CINEMAS1` FOREIGN KEY (`CINEMAS_ID`) REFERENCES `cinemas` (`ID`),
  CONSTRAINT `fk_MOVIES_has_CINEMAS_MOVIES` FOREIGN KEY (`MOVIES_ID`, `MOVIES_NAME`) REFERENCES `movies` (`ID`, `NAME`),
  CONSTRAINT `fk_PROVOLES_CONTENT_ADMIN1` FOREIGN KEY (`CONTENT_ADMIN_ID`) REFERENCES `content_admin` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provoles`
--

LOCK TABLES `provoles` WRITE;
/*!40000 ALTER TABLE `provoles` DISABLE KEYS */;
INSERT INTO `provoles` VALUES (1,'Titanic',1,'1',1,'20:00');
/*!40000 ALTER TABLE `provoles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `MOVIES_ID` int NOT NULL,
  `MOVIES_NAME` varchar(45) NOT NULL,
  `CINEMAS_ID` int NOT NULL,
  `CUSTOMERS_ID` int NOT NULL,
  `NUMBER_OF_SEATS` int NOT NULL,
  PRIMARY KEY (`MOVIES_ID`,`MOVIES_NAME`,`CINEMAS_ID`,`CUSTOMERS_ID`),
  KEY `fk_PROVOLES_has_CUSTOMERS_CUSTOMERS1_idx` (`CUSTOMERS_ID`),
  KEY `fk_PROVOLES_has_CUSTOMERS_PROVOLES1_idx` (`MOVIES_ID`,`MOVIES_NAME`,`CINEMAS_ID`),
  CONSTRAINT `fk_PROVOLES_has_CUSTOMERS_CUSTOMERS1` FOREIGN KEY (`CUSTOMERS_ID`) REFERENCES `customers` (`ID`),
  CONSTRAINT `fk_PROVOLES_has_CUSTOMERS_PROVOLES1` FOREIGN KEY (`MOVIES_ID`, `MOVIES_NAME`, `CINEMAS_ID`) REFERENCES `provoles` (`MOVIES_ID`, `MOVIES_NAME`, `CINEMAS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,'Titanic',1,12312,5);
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timestamps`
--

DROP TABLE IF EXISTS `timestamps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timestamps` (
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timestamps`
--

LOCK TABLES `timestamps` WRITE;
/*!40000 ALTER TABLE `timestamps` DISABLE KEYS */;
/*!40000 ALTER TABLE `timestamps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(32) NOT NULL,
  `email` varchar(32) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `salt` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('adchris','chris@admin.com','e3984e206ee6d61c77dea2b4951a05667f2ba973','2023-06-12 10:03:05','o2zhmB1EtSF1ZkmU','admin'),('admaria','maria@admin.gr','29eb39b7ba5e25a606e86f7c02931a25992f0e5f','2023-06-16 09:53:46','fsOugFnBcOm8uUFO','admin'),('conspyros','spyrosk@content.gr','e3984e206ee6d61c77dea2b4951a05667f2ba973','2023-06-16 19:03:29','o2zhmB1EtSF1ZkmU','contentadmin'),('kpap','kp@gmail.com','5b032c1c0ce260262b14ed04a0684f2a89b248af','2023-06-19 11:53:08','NgAMvuZtL5dt4EOJ','customer'),('makis','mak@gmail.com','5b032c1c0ce260262b14ed04a0684f2a89b248af','2023-06-16 12:47:47','NgAMvuZtL5dt4EOJ','admin'),('panos','panoss@gmail.com','e3984e206ee6d61c77dea2b4951a05667f2ba973','2023-06-18 12:15:47','o2zhmB1EtSF1ZkmU','customer'),('takis','tak@gmail.com','5b032c1c0ce260262b14ed04a0684f2a89b248af','2023-06-16 12:48:17','NgAMvuZtL5dt4EOJ','contentadmin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-20 15:14:20
