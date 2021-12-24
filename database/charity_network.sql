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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bids`
--

LOCK TABLES `bids` WRITE;
/*!40000 ALTER TABLE `bids` DISABLE KEYS */;
INSERT INTO `bids` VALUES (1,500.00,'2021-12-23 17:34:39',1,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'comment1',1,1,'2021-12-23 17:24:27'),(2,'comment2',2,4,'2021-12-23 20:21:31');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,2,1,'2021-12-23 17:18:21'),(2,1,1,'2021-12-23 17:24:18'),(3,1,5,'2021-12-23 22:34:52');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,1,2,'2021-12-23 17:18:21',0,NULL,1,NULL),(2,1,1,'2021-12-23 17:24:18',0,NULL,2,NULL),(3,1,1,'2021-12-23 17:24:27',0,1,NULL,NULL),(4,1,2,'2021-12-23 17:34:39',0,NULL,NULL,1),(5,4,2,'2021-12-23 20:21:31',0,2,NULL,NULL),(6,5,1,'2021-12-23 22:34:52',0,NULL,3,NULL);
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_tags`
--

DROP TABLE IF EXISTS `post_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_tags` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `tag_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `post_tags_posts_post_id_idx` (`post_id`),
  KEY `post_tags_tags_tag_id_idx` (`tag_id`),
  CONSTRAINT `post_tags_posts_post_id` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  CONSTRAINT `post_tags_tags_tag_id` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_tags`
--

LOCK TABLES `post_tags` WRITE;
/*!40000 ALTER TABLE `post_tags` DISABLE KEYS */;
INSERT INTO `post_tags` VALUES (1,5,1),(2,5,2),(3,6,2);
/*!40000 ALTER TABLE `post_tags` ENABLE KEYS */;
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
  `imageUrl` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_post_user_user_id_idx` (`user_id`),
  CONSTRAINT `fk_post_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'testpost1111','post1','2021-12-23 17:18:15',NULL,'2021-12-23 17:18:15',2,'http://res.cloudinary.com/dqrcn7ljx/image/upload/v1640254695/gjj9gm4is5ixcjiuypvv.jpg'),(2,'testpost222222','post2','2021-12-23 19:26:46',NULL,'2021-12-23 19:26:46',1,'http://res.cloudinary.com/dqrcn7ljx/image/upload/v1640262407/jvhf38yz2tw24gt9o9pf.png'),(3,'testpost3333333','post3','2021-12-23 19:38:46',NULL,'2021-12-23 19:38:46',1,'http://res.cloudinary.com/dqrcn7ljx/image/upload/v1640263126/sephjimsbjzoynkxwwgj.jpg'),(4,'post44444444','post4','2021-12-23 19:41:05',NULL,'2021-12-23 19:41:05',1,'http://res.cloudinary.com/dqrcn7ljx/image/upload/v1640263266/sochsaysvfdlptzm9snj.jpg'),(5,'testpost555555','post5','2021-12-23 20:08:42',NULL,'2021-12-23 20:08:42',1,'http://res.cloudinary.com/dqrcn7ljx/image/upload/v1640264924/oocbz2ekvnbhfnjkvksj.jpg'),(6,'testpost666666666666','post6','2021-12-23 22:45:42',NULL,'2021-12-23 22:45:42',1,'http://res.cloudinary.com/dqrcn7ljx/image/upload/v1640274343/hh6nh95ufup2tyleqxzs.jpg');
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
  `reason` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_report_user_id_idx` (`reporter_id`,`reported_id`),
  KEY `fk_report_user_reported_id_idx` (`reported_id`),
  CONSTRAINT `fk_report_user_reported_id` FOREIGN KEY (`reported_id`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_report_user_reporter_id` FOREIGN KEY (`reporter_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (1,1,2,'test report','2021-12-24 10:46:22'),(2,1,2,'test report','2021-12-24 10:46:56'),(3,1,2,'test report','2021-12-24 10:48:31'),(4,1,2,'test report','2021-12-24 10:51:01'),(5,1,2,'test report','2021-12-24 10:52:07'),(6,1,2,'test report','2021-12-24 10:54:21'),(7,1,2,'test report','2021-12-24 10:58:57'),(8,1,2,'test report','2021-12-24 10:59:32'),(9,1,2,'test report','2021-12-24 11:02:35'),(10,1,2,'test report','2021-12-24 11:05:40');
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tags` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES (1,'tag1'),(2,'tag2');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
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
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_role` varchar(50) NOT NULL,
  `is_reported` tinyint(1) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `avatar_url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$ZP/ivgqTD1yc3uOUpcrB4Ohd67lUWsODJbJezbeeTti5vIyLYaTCK','ROLE_ADMIN',0,'2021-12-23 15:01:28','http://res.cloudinary.com/dqrcn7ljx/image/upload/v1640246489/fzf3oqlbkkcqxxa5ozsv.jpg'),(2,'user1','$2a$10$OfpueI8esRY/CaeX/4l0VeiPwCn7JHY.wA4X4OIglHPqdpLq1gtXC','ROLE_USER',0,'2021-12-23 16:10:03','http://res.cloudinary.com/dqrcn7ljx/image/upload/v1640250603/gji9jzogopoqhrmbzwkz.jpg');
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

-- Dump completed on 2021-12-24 12:40:38
