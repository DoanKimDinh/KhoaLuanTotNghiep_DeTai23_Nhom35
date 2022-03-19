-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: systemrestaurant
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `ban_dat_truoc`
--
CREATE SCHEMA IF NOT EXISTS `systemrestaurant` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `systemrestaurant` ;


DROP TABLE IF EXISTS `ban_dat_truoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ban_dat_truoc` (
  `ma_dat_truoc` int NOT NULL,
  `dat_truoc` int DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `ghi_chu` varchar(255) DEFAULT NULL,
  `ngay_den` varchar(255) DEFAULT NULL,
  `so_nguoi` int NOT NULL,
  `thoi_gian_den` varchar(255) DEFAULT NULL,
  `khach_hang_ma_khach_hang` int DEFAULT NULL,
  PRIMARY KEY (`ma_dat_truoc`),
  KEY `FKlfywokdqv7i8imes4ahbku03r` (`khach_hang_ma_khach_hang`),
  CONSTRAINT `FKlfywokdqv7i8imes4ahbku03r` FOREIGN KEY (`khach_hang_ma_khach_hang`) REFERENCES `khach_hang` (`ma_khach_hang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ban_dat_truoc`
--

LOCK TABLES `ban_dat_truoc` WRITE;
/*!40000 ALTER TABLE `ban_dat_truoc` DISABLE KEYS */;
INSERT INTO `ban_dat_truoc` VALUES (2,1,NULL,'ghi chú 1','2021-05-31',12,'08:30',3),(3,1,NULL,'ghi chú 1','2021-05-31',12,'07:30',1),(5,1,'Gò Vấp','','2021-06-03',1,'16:09',1);
/*!40000 ALTER TABLE `ban_dat_truoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chi_tiet_hoa_don`
--

DROP TABLE IF EXISTS `chi_tiet_hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_tiet_hoa_don` (
  `ma_hoa_don_key` int NOT NULL,
  `ma_mon_an_key` int NOT NULL,
  `don_gia` double NOT NULL,
  `so_luong` int NOT NULL,
  PRIMARY KEY (`ma_hoa_don_key`,`ma_mon_an_key`),
  KEY `FKcmge17m2fg5d3tyenp5qbgs9f` (`ma_mon_an_key`),
  CONSTRAINT `FKcmge17m2fg5d3tyenp5qbgs9f` FOREIGN KEY (`ma_mon_an_key`) REFERENCES `mon_an` (`ma_mon_an`),
  CONSTRAINT `FKij01x01vkbfv99rfyk7s7bjew` FOREIGN KEY (`ma_hoa_don_key`) REFERENCES `hoa_don` (`ma_hoa_don`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_hoa_don`
--

LOCK TABLES `chi_tiet_hoa_don` WRITE;
/*!40000 ALTER TABLE `chi_tiet_hoa_don` DISABLE KEYS */;
INSERT INTO `chi_tiet_hoa_don` VALUES (1,1,350000,3),(1,2,200000,5),(1,3,250000,12),(2,5,120000,3),(3,2,200000,3),(3,6,400000,5),(4,3,250000,3),(4,6,400000,5),(5,1,350000,7),(5,3,250000,1),(6,1,350000,4),(6,2,200000,2),(7,2,200000,2),(7,3,250000,1),(8,1,350000,2),(8,3,250000,1),(9,3,250000,1),(9,4,150000,1),(10,1,350000,1),(11,1,350000,2),(11,2,200000,4),(12,7,120000,2),(12,8,32000,2);
/*!40000 ALTER TABLE `chi_tiet_hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chi_tiet_mon_dat_truoc`
--

DROP TABLE IF EXISTS `chi_tiet_mon_dat_truoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_tiet_mon_dat_truoc` (
  `don_gia` double NOT NULL,
  `so_luong` int NOT NULL,
  `ban_dat_truoc_ma_dat_truoc` int NOT NULL,
  `mon_an_ma_mon_an` int NOT NULL,
  PRIMARY KEY (`ban_dat_truoc_ma_dat_truoc`,`mon_an_ma_mon_an`),
  KEY `FK42akqf1skxiunghbphxaknloc` (`mon_an_ma_mon_an`),
  CONSTRAINT `FK42akqf1skxiunghbphxaknloc` FOREIGN KEY (`mon_an_ma_mon_an`) REFERENCES `mon_an` (`ma_mon_an`),
  CONSTRAINT `FK4th7knbq3mhoax78v62nqg3tb` FOREIGN KEY (`ban_dat_truoc_ma_dat_truoc`) REFERENCES `ban_dat_truoc` (`ma_dat_truoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_tiet_mon_dat_truoc`
--

LOCK TABLES `chi_tiet_mon_dat_truoc` WRITE;
/*!40000 ALTER TABLE `chi_tiet_mon_dat_truoc` DISABLE KEYS */;
INSERT INTO `chi_tiet_mon_dat_truoc` VALUES (200000,4,2,2),(150000,1,5,4),(120000,1,5,5);
/*!40000 ALTER TABLE `chi_tiet_mon_dat_truoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don` (
  `ma_hoa_don` int NOT NULL,
  `ghi_chu` varchar(255) DEFAULT NULL,
  `ngay_den` datetime DEFAULT NULL,
  `ngay_lap_hoa_don` datetime DEFAULT NULL,
  `tinh_trang` varchar(255) DEFAULT NULL,
  `khach_hang_ma_khach_hang` int DEFAULT NULL,
  `nhan_vien_ma_nhan_vien` int DEFAULT NULL,
  PRIMARY KEY (`ma_hoa_don`),
  KEY `FKisrff4nodo0abxj44r5b4sxo0` (`khach_hang_ma_khach_hang`),
  KEY `FKrctr8rluy1e7okuc9167936a9` (`nhan_vien_ma_nhan_vien`),
  CONSTRAINT `FKisrff4nodo0abxj44r5b4sxo0` FOREIGN KEY (`khach_hang_ma_khach_hang`) REFERENCES `khach_hang` (`ma_khach_hang`),
  CONSTRAINT `FKrctr8rluy1e7okuc9167936a9` FOREIGN KEY (`nhan_vien_ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don`
--

LOCK TABLES `hoa_don` WRITE;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
INSERT INTO `hoa_don` VALUES (1,'khách đến trễ 20\'','2021-04-21 08:07:00','2021-04-21 08:07:00','DaThanhToan',1,1),(2,'khách thanh toán sau','2021-04-22 09:07:00','2021-04-22 10:08:00','DaThanhToan',2,1),(3,'','2021-05-02 09:07:00','2021-05-02 10:08:00','DaThanhToan',1,3),(4,'','2021-05-03 09:07:00','2021-05-03 11:08:00','DaThanhToan',2,2),(5,'','2021-05-04 13:07:00','2021-05-04 13:30:00','DaThanhToan',2,2),(6,'','2021-05-04 12:07:00','2021-05-04 13:30:00','DaThanhToan',1,2),(7,'','2021-05-05 12:07:00','2021-05-05 13:30:00','DaThanhToan',5,2),(8,'','2021-05-06 12:07:00','2021-05-06 13:30:00','DaThanhToan',8,1),(9,'','2021-05-07 12:07:00','2021-05-07 13:30:00','DaThanhToan',7,2),(10,'','2021-05-08 12:07:00','2021-05-08 13:30:00','DaThanhToan',6,2),(11,'ghi chú 1','2021-05-31 00:00:00','2021-05-31 17:36:19','DaThanhToan',2,1),(12,'','2021-06-02 00:00:00','2021-05-31 17:36:25','DaThanhToan',1,1);
/*!40000 ALTER TABLE `hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khach_hang` (
  `ma_khach_hang` int NOT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `ten_khach_hang` varchar(255) DEFAULT NULL,
  `ten_tai_khoan` varchar(255) DEFAULT NULL,
  `quyen_truy_cap_ma_quyen_truy_cap` int DEFAULT NULL,
  PRIMARY KEY (`ma_khach_hang`),
  KEY `FKcmqqatdcr28w7r8tkcqmh50wg` (`quyen_truy_cap_ma_quyen_truy_cap`),
  CONSTRAINT `FKcmqqatdcr28w7r8tkcqmh50wg` FOREIGN KEY (`quyen_truy_cap_ma_quyen_truy_cap`) REFERENCES `quyen_truy_cap` (`ma_quyen_truy_cap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` VALUES (1,'Gò Vấp','kimdinh@gmail.com','123456','0123456789','Đoàn Kim Định','doankimdinh',1),(2,'Quận 1','minhtruc@gmail.com','123456','0123456781','Trần Minh Trúc','tranminhtruc',1),(3,'Quận 2','baothy@gmail.com','123456','0123456782','Nguyễn Bảo Thy','nguyenbaothy',1),(4,'Quận 4','dinhquoc@gmail.com','123456','0123456783','Nguyễn Đình Quốc','nguyendinhquoc',1),(5,'Quận 5','vanhoang@gmail.com','123456','0123456784','Nguyễn Văn Hoàng','nguyenvanhoang',1),(6,'Quận 6','thienchi@gmail.com','123456','0123456785','Nguyễn Thiên Chí','nguyenthienchi',1),(7,'Quận 5','thienhai@gmail.com','123456','0123456786','Dương Thiện Hải','duongthienhai',1),(8,'Quận 2','nguyenvanvuong@gmail.com','123456','0123456787','Nguyễn Văn Vương','nguyenvanvuong',1),(9,'Quận 3','chaunhatdang@gmail.com','123456','0123456788','Châu Nhật Đăng','chaunhatdang',1);
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai_mon_an`
--

DROP TABLE IF EXISTS `loai_mon_an`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_mon_an` (
  `ma_loai_mon_an` int NOT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten_loai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_loai_mon_an`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_mon_an`
--

LOCK TABLES `loai_mon_an` WRITE;
/*!40000 ALTER TABLE `loai_mon_an` DISABLE KEYS */;
INSERT INTO `loai_mon_an` VALUES (1,'Lẩu Tươi Sống','Lẫu'),(2,'Hải Sản Tươi','Hải Sản'),(3,'Gỏi Nhẹ','Gỏi');
/*!40000 ALTER TABLE `loai_mon_an` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_dat_truoc_seq`
--

DROP TABLE IF EXISTS `ma_dat_truoc_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ma_dat_truoc_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_dat_truoc_seq`
--

LOCK TABLES `ma_dat_truoc_seq` WRITE;
/*!40000 ALTER TABLE `ma_dat_truoc_seq` DISABLE KEYS */;
INSERT INTO `ma_dat_truoc_seq` VALUES (6);
/*!40000 ALTER TABLE `ma_dat_truoc_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_hoa_don_seq`
--

DROP TABLE IF EXISTS `ma_hoa_don_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ma_hoa_don_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_hoa_don_seq`
--

LOCK TABLES `ma_hoa_don_seq` WRITE;
/*!40000 ALTER TABLE `ma_hoa_don_seq` DISABLE KEYS */;
INSERT INTO `ma_hoa_don_seq` VALUES (13);
/*!40000 ALTER TABLE `ma_hoa_don_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_khach_hang_seq`
--

DROP TABLE IF EXISTS `ma_khach_hang_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ma_khach_hang_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_khach_hang_seq`
--

LOCK TABLES `ma_khach_hang_seq` WRITE;
/*!40000 ALTER TABLE `ma_khach_hang_seq` DISABLE KEYS */;
INSERT INTO `ma_khach_hang_seq` VALUES (10);
/*!40000 ALTER TABLE `ma_khach_hang_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_loai_mon_an_seq`
--

DROP TABLE IF EXISTS `ma_loai_mon_an_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ma_loai_mon_an_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_loai_mon_an_seq`
--

LOCK TABLES `ma_loai_mon_an_seq` WRITE;
/*!40000 ALTER TABLE `ma_loai_mon_an_seq` DISABLE KEYS */;
INSERT INTO `ma_loai_mon_an_seq` VALUES (4);
/*!40000 ALTER TABLE `ma_loai_mon_an_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_nhan_vien_seq`
--

DROP TABLE IF EXISTS `ma_nhan_vien_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ma_nhan_vien_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_nhan_vien_seq`
--

LOCK TABLES `ma_nhan_vien_seq` WRITE;
/*!40000 ALTER TABLE `ma_nhan_vien_seq` DISABLE KEYS */;
INSERT INTO `ma_nhan_vien_seq` VALUES (4);
/*!40000 ALTER TABLE `ma_nhan_vien_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ma_quyen_truy_cap_seq`
--

DROP TABLE IF EXISTS `ma_quyen_truy_cap_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ma_quyen_truy_cap_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ma_quyen_truy_cap_seq`
--

LOCK TABLES `ma_quyen_truy_cap_seq` WRITE;
/*!40000 ALTER TABLE `ma_quyen_truy_cap_seq` DISABLE KEYS */;
INSERT INTO `ma_quyen_truy_cap_seq` VALUES (4);
/*!40000 ALTER TABLE `ma_quyen_truy_cap_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mon_an`
--

DROP TABLE IF EXISTS `mon_an`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mon_an` (
  `ma_mon_an` int NOT NULL,
  `don_gia` double NOT NULL,
  `hinh_anh` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ten_mon_an` varchar(255) DEFAULT NULL,
  `tinh_trang` varchar(255) DEFAULT NULL,
  `loai_mon_an_ma_loai_mon_an` int DEFAULT NULL,
  PRIMARY KEY (`ma_mon_an`),
  KEY `FKq4jp4gedkhuebhv80l9026872` (`loai_mon_an_ma_loai_mon_an`),
  CONSTRAINT `FKq4jp4gedkhuebhv80l9026872` FOREIGN KEY (`loai_mon_an_ma_loai_mon_an`) REFERENCES `loai_mon_an` (`ma_loai_mon_an`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_an`
--

LOCK TABLES `mon_an` WRITE;
/*!40000 ALTER TABLE `mon_an` DISABLE KEYS */;
INSERT INTO `mon_an` VALUES (1,350000,'lau_thai.jpg','Lẫu là món ăn thơm ngon và bổ dưỡng. Nguyên liệu bao gồm: Thịt bò, mực, tôm, bạch tuột, nghêu, bún tươi, mì hoặc miếng.','Lẩu Thái','DangKinhDoanh',1),(2,200000,'lau-hai-san-1.jpg','Nguyên liệu chính bao gồm: 500gr tôm tươi, 500gr mực tươi, 1 bát con ngao, 1 bó nấm kim châm, 1 thìa bột me,2 cái xương ức gà, 500gr cá phi lê, 1 ít giò cá viên, Vài miếng đậu phụ non','Lẫu hải sản','DangKinhDoanh',1),(3,250000,'lau-ca-keo-1.jpg','Cá kèo nguyên con được làm sạch, cùng với các loại gia vị khác tạo nên món lẫu có kèo thơm ngon','Lẩu Cá Kèo','DangKinhDoanh',1),(4,150000,'img-06.jpg','Nguyên liệu chính bao gồm: thịt ba chỉ, salad, cà chua bi, quả ô-liu, bơ lạt, trứng gà.','Salad Hoàng đế','DangKinhDoanh',2),(5,120000,'img-05.jpg','Nguyên liệu: Thịt bò 400gram, hành ngò, lá bạc hà, dưa leo, hành tây, cà chua','Salad thịt bò','DangKinhDoanh',2),(6,400000,'img-08.jpg','Phù hợp với 2 người ăn. Bao gồm: kimchi, thịt kho, trứng chiên, cá kho.','Combo món Việt','DangKinhDoanh',2),(7,120000,'img-07.jpg','Thành phần bao gồm: socola, kem tươi, sữa giúp tăng cảm giác ngon miệng khi ăn','Kem socola','DangKinhDoanh',2),(8,32000,'img-08.jpg','Món Ăn Hà Nội','Gỏi Cá Trích','NgungKinhDoanh',3),(9,40000,'img-09.jpg','Món Ăn Hà Nội','Gỏi Tiến Vua','NgungKinhDoanh',3),(10,120000,'sup-ngheu-kem-sua.jpg','Thành phần bao gồm: 200g nghêu, 150ml sữa tươi, 150g cooking cream và một số gia vị khác','Soup nghêu kem sửa','DangKinhDoanh',2);
/*!40000 ALTER TABLE `mon_an` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mon_an_seq`
--

DROP TABLE IF EXISTS `mon_an_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mon_an_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_an_seq`
--

LOCK TABLES `mon_an_seq` WRITE;
/*!40000 ALTER TABLE `mon_an_seq` DISABLE KEYS */;
INSERT INTO `mon_an_seq` VALUES (11);
/*!40000 ALTER TABLE `mon_an_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_vien` (
  `ma_nhan_vien` int NOT NULL,
  `chung_minh_nhan_dan` varchar(255) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gioi_tinh` int DEFAULT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `ten_nhan_vien` varchar(255) DEFAULT NULL,
  `ten_tai_khoan` varchar(255) DEFAULT NULL,
  `quyen_truy_cap_ma_quyen_truy_cap` int DEFAULT NULL,
  PRIMARY KEY (`ma_nhan_vien`),
  KEY `FKqmcy0035418u588ygh3ovw3t6` (`quyen_truy_cap_ma_quyen_truy_cap`),
  CONSTRAINT `FKqmcy0035418u588ygh3ovw3t6` FOREIGN KEY (`quyen_truy_cap_ma_quyen_truy_cap`) REFERENCES `quyen_truy_cap` (`ma_quyen_truy_cap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES (1,'342356443','Quan 1','linh@gmail.com',0,'123456','0123432323','Nguyen Tien Linh','nguyentienlinh',2),(2,'342356445','Quan 2','quan@gmail.com',0,'123456','0234232323','Mac Hong Quan','machongquan',2),(3,'342356466','Quan 3','hoang@gmail.com',1,'123456','0464232323','Nguyen Trong Hoang','nguyentronghoang',3);
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quyen_truy_cap`
--

DROP TABLE IF EXISTS `quyen_truy_cap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quyen_truy_cap` (
  `ma_quyen_truy_cap` int NOT NULL,
  `ten_quyen_truy_cap` int DEFAULT NULL,
  PRIMARY KEY (`ma_quyen_truy_cap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quyen_truy_cap`
--

LOCK TABLES `quyen_truy_cap` WRITE;
/*!40000 ALTER TABLE `quyen_truy_cap` DISABLE KEYS */;
INSERT INTO `quyen_truy_cap` VALUES (1,2),(2,1),(3,0);
/*!40000 ALTER TABLE `quyen_truy_cap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'systemrestaurant'
--

--
-- Dumping routines for database 'systemrestaurant'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-02  9:48:00
