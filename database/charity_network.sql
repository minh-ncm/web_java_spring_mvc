-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: charity_network
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `bids`
--

DROP TABLE IF EXISTS `bids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bids` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` decimal(15,2) NOT NULL,
  `created_date` datetime NOT NULL,
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bids_posts_post_id_idx` (`post_id`),
  KEY `fk_bids_users_user_id_idx` (`user_id`),
  CONSTRAINT `fk_bids_posts_post_id` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `fk_bids_users_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bids`
--

LOCK TABLES `bids` WRITE;
/*!40000 ALTER TABLE `bids` DISABLE KEYS */;
INSERT INTO `bids` VALUES (1,3132123.00,'2021-12-16 22:15:29',1,1),(2,343.12,'2021-12-16 22:18:52',4,1);
/*!40000 ALTER TABLE `bids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `text` varchar(200) NOT NULL,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_user_user_id_idx` (`user_id`),
  KEY `fk_comment_post_post_id_idx` (`post_id`),
  CONSTRAINT `fk_comment_post_post_id` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `fk_comment_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'asdfasdf',1,1,'2021-12-16 20:49:15'),(2,'asdfasdf',1,4,'2021-12-16 20:51:24'),(3,'fgsdfgsdfg',1,8,'2021-12-16 20:53:16'),(4,'ghhdgfhdh',1,7,'2021-12-16 20:54:02'),(5,'ghhdgfhdh',1,7,'2021-12-16 21:00:00'),(6,'',1,1,'2021-12-16 21:00:04'),(7,'teadfa',1,1,'2021-12-16 22:34:15'),(8,'testaxfa',1,1,'2021-12-16 22:35:28'),(9,'dfasdfa',1,1,'2021-12-16 22:36:06'),(10,'asdfasdf',1,1,'2021-12-16 22:36:13'),(11,'',1,1,'2021-12-16 22:36:37'),(12,'',1,1,'2021-12-16 22:38:56'),(13,'test',1,1,'2021-12-16 22:39:47'),(14,'',1,4,'2021-12-16 22:53:20');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_like_post_post_id_idx` (`post_id`),
  KEY `fk_like_user_user_id_idx` (`user_id`),
  CONSTRAINT `fk_like_post_post_id` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `fk_like_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,1,1,'2021-12-16 08:24:33'),(2,1,1,'2021-12-16 08:24:53'),(3,1,1,'2021-12-16 08:42:54'),(4,1,5,'2021-12-16 08:54:07'),(5,1,4,'2021-12-16 08:54:16'),(6,1,5,'2021-12-16 13:37:15'),(7,1,4,'2021-12-16 13:38:40'),(8,1,4,'2021-12-16 13:39:13'),(9,1,1,'2021-12-16 14:19:37'),(10,1,1,'2021-12-16 18:26:19'),(11,1,4,'2021-12-16 18:45:52'),(12,1,4,'2021-12-16 18:45:55'),(13,1,4,'2021-12-16 18:45:56'),(14,1,7,'2021-12-16 20:01:47');
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `user_id` int NOT NULL,
  `created_date` datetime NOT NULL,
  `is_read` tinyint(1) DEFAULT '0',
  `comment_id` int DEFAULT NULL,
  `like_id` int DEFAULT NULL,
  `bid_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_notification_post_post_Id_idx` (`post_id`),
  KEY `fk_notification_user_user_id_idx` (`user_id`),
  KEY `fk_notification_comment_comment_id_idx` (`comment_id`),
  KEY `fk_notification_like_like_id_idx` (`like_id`),
  KEY `fk_notifications_bid_bid_id_idx` (`bid_id`),
  CONSTRAINT `fk_notification_comment_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`),
  CONSTRAINT `fk_notification_like_like_id` FOREIGN KEY (`like_id`) REFERENCES `likes` (`id`),
  CONSTRAINT `fk_notification_post_post_Id` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `fk_notification_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_notifications_bid_bid_id` FOREIGN KEY (`bid_id`) REFERENCES `bids` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `winner_id` int DEFAULT NULL,
  `end_date` datetime NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_post_user_user_id_idx` (`user_id`),
  CONSTRAINT `fk_post_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'test description','test title','2021-12-15 12:07:30',NULL,'2021-12-15 12:07:30',1),(4,'test end date','test end date','2021-12-15 14:53:26',NULL,'2021-12-15 14:53:25',1),(5,'testpost33333333333333','testpost3','2021-12-15 23:52:31',NULL,'2021-12-15 23:52:31',1),(6,'testpost44444444','testpost4','2021-12-16 00:04:33',NULL,'2021-12-16 00:04:33',1),(7,'testpost555555555','testpost5','2021-12-16 13:40:40',NULL,'2021-12-16 13:40:40',1),(8,'testpost66666','testpost6','2021-12-16 14:20:02',NULL,'2021-12-16 14:20:02',1);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reports` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reporter_id` int NOT NULL,
  `reported_id` int NOT NULL,
  `reason` int NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_report_user_id_idx` (`reporter_id`,`reported_id`),
  KEY `fk_report_user_reported_id_idx` (`reported_id`),
  CONSTRAINT `fk_report_user_reported_id` FOREIGN KEY (`reported_id`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_report_user_reporter_id` FOREIGN KEY (`reporter_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0',
  `is_reported` tinyint(1) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `avatar_url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'testaccount','testpassword',0,0,'2021-12-15 09:27:21','https://res.cloudinary.com/dqrcn7ljx/image/upload/v1639479467/user_dnxjlf.svg'),(2,'testuser2','testuser2',0,0,'2021-12-15 23:51:37','https://res.cloudinary.com/dqrcn7ljx/image/upload/v1639479467/user_dnxjlf.svg'),(3,'testuser4','testuser4',0,0,'2021-12-15 23:58:55','http://res.cloudinary.com/dqrcn7ljx/image/upload/v1639587535/ok4gxzalugw0uttrz8g2.jpg'),(4,'testuser3','testuser3',0,0,'2021-12-16 00:01:50','https://res.cloudinary.com/dqrcn7ljx/image/upload/v1639479467/user_dnxjlf.svg'),(5,'testuser5','testuser5',0,0,'2021-12-16 14:24:58','https://res.cloudinary.com/dqrcn7ljx/image/upload/v1639479467/user_dnxjlf.svg'),(6,'testuser6','testuser6666',0,0,'2021-12-16 14:32:14','https://res.cloudinary.com/dqrcn7ljx/image/upload/v1639479467/user_dnxjlf.svg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-16 23:31:03
