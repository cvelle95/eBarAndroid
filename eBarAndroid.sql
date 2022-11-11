/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 127.0.0.1:3306
 Source Schema         : eBarAndroid

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 26/08/2021 13:04:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for artikal
-- ----------------------------
DROP TABLE IF EXISTS `artikal`;
CREATE TABLE `artikal` (
  `artikal_id` int unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `cena` float(5,2) unsigned NOT NULL,
  `kategorija_id` int unsigned NOT NULL,
  PRIMARY KEY (`artikal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of artikal
-- ----------------------------
BEGIN;
INSERT INTO `artikal` VALUES (1, 'Coca Cola 0.5l', 150.00, 1);
INSERT INTO `artikal` VALUES (2, 'Coca Cola 1l', 280.00, 1);
INSERT INTO `artikal` VALUES (3, 'Sok Borovnica', 400.00, 1);
INSERT INTO `artikal` VALUES (4, 'Sok Breskva', 200.00, 1);
INSERT INTO `artikal` VALUES (5, 'Somersby', 300.00, 2);
INSERT INTO `artikal` VALUES (6, 'Jelen pivo 0.5', 200.00, 2);
INSERT INTO `artikal` VALUES (7, 'Tuborg 0.33', 200.00, 2);
COMMIT;

-- ----------------------------
-- Table structure for korisnik
-- ----------------------------
DROP TABLE IF EXISTS `korisnik`;
CREATE TABLE `korisnik` (
  `korisnik_id` int unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`korisnik_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of korisnik
-- ----------------------------
BEGIN;
INSERT INTO `korisnik` VALUES (1, 'ivan', 'vani', '1234');
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int unsigned NOT NULL AUTO_INCREMENT,
  `ukupno` float(5,2) unsigned DEFAULT NULL,
  `table_id` int unsigned NOT NULL,
  `status` varchar(30) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'active',
  PRIMARY KEY (`order_id`),
  KEY `INDEX_sto_id` (`table_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES (1, 800.00, 1, 'active');
COMMIT;

-- ----------------------------
-- Table structure for stavka
-- ----------------------------
DROP TABLE IF EXISTS `stavka`;
CREATE TABLE `stavka` (
  `stavka_id` int unsigned NOT NULL AUTO_INCREMENT,
  `artikal_id` int unsigned NOT NULL,
  `kolicina` float(5,2) unsigned NOT NULL,
  `cena` float(6,2) unsigned DEFAULT NULL,
  `order_id` int unsigned NOT NULL,
  PRIMARY KEY (`stavka_id`),
  KEY `FK_stavka_artikal_artikalId` (`artikal_id`),
  KEY `FK_stavka_order_orderId` (`order_id`),
  CONSTRAINT `FK_stavka_artikal_artikalId` FOREIGN KEY (`artikal_id`) REFERENCES `artikal` (`artikal_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_stavka_order_orderId` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of stavka
-- ----------------------------
BEGIN;
INSERT INTO `stavka` VALUES (1, 3, 1.00, 400.00, 1);
INSERT INTO `stavka` VALUES (2, 6, 2.00, 400.00, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
