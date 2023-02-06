-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: spritle
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `task_description`
--

DROP TABLE IF EXISTS `task_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_description` (
  `task_id` int NOT NULL AUTO_INCREMENT,
  `m_id` int DEFAULT NULL,
  `s_id` int DEFAULT NULL,
  `left_operand` varchar(40) DEFAULT NULL,
  `right_operand` varchar(40) DEFAULT NULL,
  `operator` varchar(40) DEFAULT NULL,
  `task_desc` varchar(500) NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `m_id` (`m_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `task_description_ibfk_1` FOREIGN KEY (`m_id`) REFERENCES `master_table` (`m_id`),
  CONSTRAINT `task_description_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `student_table` (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_description`
--

LOCK TABLES `task_description` WRITE;
/*!40000 ALTER TABLE `task_description` DISABLE KEYS */;
INSERT INTO `task_description` VALUES (1,1,1,'two','four','times','two times four'),(2,1,3,'two','two','minus','two minus two'),(3,2,2,'two','three','minus','two minus three'),(4,1,1,'seven','four','plus','seven plus four'),(5,1,1,'four','three','times','four times three');
/*!40000 ALTER TABLE `task_description` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-18 12:27:23
