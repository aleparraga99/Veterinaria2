-- MySQL dump 10.13  Distrib 9.1.0, for Win64 (x86_64)
--
-- Host: localhost    Database: veterinaria2
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adoptante`
--

DROP TABLE IF EXISTS `adoptante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adoptante` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adoptante`
--

LOCK TABLES `adoptante` WRITE;
/*!40000 ALTER TABLE `adoptante` DISABLE KEYS */;
INSERT INTO `adoptante` VALUES (1,'Juan','Pérez','12345678','5551234567','juan.perez@mail.com'),(2,'Ana','Gómez','87654321','5559876543','ana.gomez@mail.com'),(3,'Carlos','López','23456789','5555671234','carlos.lopez@mail.com'),(4,'María','Fernández','34567890','5556783452','maria.fernandez@mail.com');
/*!40000 ALTER TABLE `adoptante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascota` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `especie` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
INSERT INTO `mascota` VALUES (1,'Bobby',1,'Perro'),(2,'Mimi',1,'Gato'),(3,'Luna',0,'Conejo'),(4,'Rex',1,'Perro');
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud_de_adopcion`
--

DROP TABLE IF EXISTS `solicitud_de_adopcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitud_de_adopcion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `estado` varchar(100) NOT NULL,
  `mascota_id` int NOT NULL,
  `adoptante_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mascota_id` (`mascota_id`),
  KEY `adoptante_id` (`adoptante_id`),
  CONSTRAINT `solicitud_de_adopcion_ibfk_1` FOREIGN KEY (`mascota_id`) REFERENCES `mascota` (`id`) ON DELETE CASCADE,
  CONSTRAINT `solicitud_de_adopcion_ibfk_2` FOREIGN KEY (`adoptante_id`) REFERENCES `adoptante` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud_de_adopcion`
--

LOCK TABLES `solicitud_de_adopcion` WRITE;
/*!40000 ALTER TABLE `solicitud_de_adopcion` DISABLE KEYS */;
INSERT INTO `solicitud_de_adopcion` VALUES (1,'2024-11-01','Pendiente',1,1),(2,'2024-11-02','Aprobada',2,2),(3,'2024-11-03','Rechazada',3,3),(4,'2024-11-04','Pendiente',4,4);
/*!40000 ALTER TABLE `solicitud_de_adopcion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-27 18:12:34
