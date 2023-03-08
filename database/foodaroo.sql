/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云轻量服务器
 Source Server Type    : MySQL
 Source Server Version : 50741
 Source Host           : 42.193.219.12:3306
 Source Schema         : foodaroo

 Target Server Type    : MySQL
 Target Server Version : 50741
 File Encoding         : 65001

 Date: 09/03/2023 03:26:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address_book
-- ----------------------------
DROP TABLE IF EXISTS `address_book`;
CREATE TABLE `address_book` (
  `id` bigint(20) NOT NULL COMMENT 'Primary key',
  `user_id` bigint(20) NOT NULL COMMENT 'User id',
  `consignee` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'Consignee',
  `sex` tinyint(4) NOT NULL COMMENT 'Sex 0 female 1 male',
  `phone` varchar(11) COLLATE utf8_bin NOT NULL COMMENT 'phone number',
  `province_code` varchar(12) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'provincial division code',
  `province_name` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'province name',
  `city_code` varchar(12) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'city division number',
  `city_name` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'city name',
  `district_code` varchar(12) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'District-level division number',
  `district_name` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'District-level name',
  `detail` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'detailed address',
  `label` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'label',
  `is_default` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'default 0 no 1 yes',
  `create_time` datetime NOT NULL COMMENT 'create time',
  `update_time` datetime NOT NULL COMMENT 'update time',
  `create_user` bigint(20) NOT NULL COMMENT 'Creator',
  `update_user` bigint(20) NOT NULL COMMENT 'modifier',
  `is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT 'Whether to delete',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Address management';

-- ----------------------------
-- Records of address_book
-- ----------------------------
BEGIN;
INSERT INTO `address_book` (`id`, `user_id`, `consignee`, `sex`, `phone`, `province_code`, `province_name`, `city_code`, `city_name`, `district_code`, `district_name`, `detail`, `label`, `is_default`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1417414526093082626, 1417012167126876162, 'Xiaoming', 1, '13812345678', NULL, NULL, NULL, NULL, NULL, NULL, 'Jinyanlong Office Building, Changping District', 'Company', 1, '2021-07-20 17:22:12', '2021-07-20 17:26:33', 1417012167126876162, 1417012167126876162, 0);
INSERT INTO `address_book` (`id`, `user_id`, `consignee`, `sex`, `phone`, `province_code`, `province_name`, `city_code`, `city_name`, `district_code`, `district_name`, `detail`, `label`, `is_default`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1417414926166769666, 1417012167126876162, 'Xiao Li', 1, '13512345678', NULL, NULL, NULL, NULL, NULL, NULL, 'test', 'home', 0, '2021-07-20 17:23:47', '2021-07-20 17:23:47', 1417012167126876162, 1417012167126876162, 0);
INSERT INTO `address_book` (`id`, `user_id`, `consignee`, `sex`, `phone`, `province_code`, `province_name`, `city_code`, `city_name`, `district_code`, `district_name`, `detail`, `label`, `is_default`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633145883293220866, 1633137741348065282, 'Kilo', 1, '18737281983', NULL, NULL, NULL, NULL, NULL, NULL, 'Tseung Kwan O', 'Home', 1, '2023-03-08 00:41:36', '2023-03-08 00:41:40', 1633137741348065282, 1633137741348065282, 0);
COMMIT;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL COMMENT 'primary key',
  `type` int(11) DEFAULT NULL COMMENT 'Type 1 dish classification 2 set meal classification',
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'category name',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT 'order',
  `create_time` datetime NOT NULL COMMENT 'create time',
  `update_time` datetime NOT NULL COMMENT 'update time',
  `create_user` bigint(20) NOT NULL COMMENT 'Creator',
  `update_user` bigint(20) NOT NULL COMMENT 'modifier',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_category_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Classification of dishes and packages';

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` (`id`, `type`, `name`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1413341197421846529, 1, 'Cofe', 11, '2021-07-09 11:36:15', '2023-03-09 03:02:59', 1, 1);
INSERT INTO `category` (`id`, `type`, `name`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1413342269393674242, 2, 'Business Package', 5, '2021-07-09 11:40:30', '2021-07-09 14:43:45', 1, 1);
INSERT INTO `category` (`id`, `type`, `name`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1413386191767674881, 2, 'Children\'s package', 6, '2021-07-09 14:35:02', '2021-07-09 14:39:05', 1, 1);
INSERT INTO `category` (`id`, `type`, `name`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1633534566529847297, 1, 'Burgers', 1, '2023-03-09 02:26:05', '2023-03-09 02:26:05', 1, 1);
INSERT INTO `category` (`id`, `type`, `name`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1633534612247760897, 1, 'Breakfast', 2, '2023-03-09 02:26:16', '2023-03-09 02:26:16', 1, 1);
INSERT INTO `category` (`id`, `type`, `name`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1633541826962345985, 1, 'Fries & Sides', 3, '2023-03-09 02:54:56', '2023-03-09 02:54:56', 1, 1);
INSERT INTO `category` (`id`, `type`, `name`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1633543094900445186, 1, 'Bakery', 4, '2023-03-09 02:59:58', '2023-03-09 02:59:58', 1, 1);
INSERT INTO `category` (`id`, `type`, `name`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1633543914287091713, 1, 'Beverages', 5, '2023-03-09 03:03:14', '2023-03-09 03:03:14', 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
  `id` bigint(20) NOT NULL COMMENT 'primary key',
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'dish name',
  `category_id` bigint(20) NOT NULL COMMENT 'dish category id',
  `price` decimal(10,2) DEFAULT NULL COMMENT 'dish price',
  `code` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'commodity code',
  `image` varchar(200) COLLATE utf8_bin NOT NULL COMMENT 'image',
  `description` varchar(400) COLLATE utf8_bin DEFAULT NULL COMMENT 'description',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0 stop selling 1 start selling',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT 'order',
  `create_time` datetime NOT NULL COMMENT 'create time',
  `update_time` datetime NOT NULL COMMENT 'update time',
  `create_user` bigint(20) NOT NULL COMMENT 'Creator',
  `update_user` bigint(20) NOT NULL COMMENT 'modifier',
  `is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT 'Whether to delete',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_dish_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='dish management';

-- ----------------------------
-- Records of dish
-- ----------------------------
BEGIN;
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633535152541224962, 'Big Mac', 1633534566529847297, 3500.00, '', '79c404c0-0799-41b1-a2ea-bf2268fe376b.jpeg', '', 1, 0, '2023-03-09 02:28:25', '2023-03-09 02:28:25', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633535499263365122, 'Quarter Pounder', 1633534566529847297, 3300.00, '', '674dfc09-175a-4959-b30b-f324d014b66c.jpeg', '', 1, 0, '2023-03-09 02:29:47', '2023-03-09 02:29:47', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633535739525681154, 'Double Quarter', 1633534566529847297, 3900.00, '', '0062b61d-97bc-4d1e-856d-9d0b0b7f19fa.jpeg', '', 1, 0, '2023-03-09 02:30:45', '2023-03-09 02:30:45', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633536326656937986, 'Quarter Deluxe', 1633534566529847297, 3600.00, '', 'bc463cee-dcff-436a-8de4-e34769d312f2.jpeg', '', 1, 0, '2023-03-09 02:33:05', '2023-03-09 02:33:05', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633536463684849666, 'McDouble', 1633534566529847297, 3000.00, '', '30c6bad2-e90c-43fd-9c43-5930355f1b1f.jpeg', '', 1, 0, '2023-03-09 02:33:37', '2023-03-09 02:33:37', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633536586758311937, 'Cheeseburger', 1633534566529847297, 3200.00, '', 'fc1b1a1d-5f0a-4e3a-aea1-c376fbcc07fb.jpeg', '', 1, 0, '2023-03-09 02:34:07', '2023-03-09 02:34:07', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633537939886919682, 'Caramel Macchiato', 1413341197421846529, 1500.00, '', 'a56ccdc5-3bf5-470a-b02d-0345edaa1d3f.jpeg', '', 1, 0, '2023-03-09 02:39:29', '2023-03-09 02:39:29', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538079083286530, 'Cappuccino', 1413341197421846529, 1800.00, '', '5b5fd481-1f76-46ae-b729-c663e90e4e0d.jpeg', '', 1, 0, '2023-03-09 02:40:02', '2023-03-09 02:40:02', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538517270614017, 'Mediumlced Mocha', 1413341197421846529, 2500.00, '', '7cb9c446-4f19-4da5-96dc-cc48eb5fbf4c.jpeg', '', 1, 0, '2023-03-09 02:41:47', '2023-03-09 02:41:47', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538649248583681, 'Medium Cappuccino', 1413341197421846529, 1600.00, '', '1c36ead2-b79f-4033-85ba-73f38338dcb3.jpeg', '', 1, 0, '2023-03-09 02:42:18', '2023-03-09 02:42:18', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538822137794562, 'Ice Cappuccino', 1413341197421846529, 2300.00, '', '6f1463fe-6d78-4090-938e-07acf724068e.jpeg', '', 1, 0, '2023-03-09 02:43:00', '2023-03-09 02:43:00', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538952630980609, 'Medium Americano', 1413341197421846529, 1800.00, '', 'a6d46b01-16e8-4658-af6c-9935a613b06f.jpeg', '', 1, 0, '2023-03-09 02:43:31', '2023-03-09 02:43:31', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633539034340216834, 'Medium Mocha', 1413341197421846529, 2200.00, '', '806d1964-36ab-4f3b-ba5a-6129b3b5533c.jpeg', '', 1, 0, '2023-03-09 02:43:50', '2023-03-09 02:43:50', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633539470828851201, 'Cheese Biscuit', 1633534612247760897, 2200.00, '', 'b6e3c245-7228-406d-833b-7244d30b589b.jpeg', '', 1, 0, '2023-03-09 02:45:34', '2023-03-09 02:45:34', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633539582804185089, 'SausageBiscuit', 1633534612247760897, 2800.00, '', '412e6033-f846-4c08-9a71-bc50ab103bcc.jpeg', '', 1, 0, '2023-03-09 02:46:01', '2023-03-09 02:46:01', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633539685757571073, 'McMuffin', 1633534612247760897, 1700.00, '', 'e2504424-e87c-44c5-a9d1-a911fbf78f44.jpeg', '', 1, 0, '2023-03-09 02:46:25', '2023-03-09 02:46:25', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633539775079469058, 'HashBrowns', 1633534612247760897, 1600.00, '', 'cd8f58fa-52c2-4c95-bba7-7e53ce67c852.jpeg', '', 1, 0, '2023-03-09 02:46:47', '2023-03-09 02:46:47', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633539872806752257, 'SausageBurrito', 1633534612247760897, 2200.00, '', 'e8925567-8021-43cf-9155-a1ae8a29b6b6.jpeg', '', 1, 0, '2023-03-09 02:47:10', '2023-03-09 02:47:10', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633539983758675969, 'HotCakes', 1633534612247760897, 1500.00, '', 'a01301ef-77eb-479e-8500-1ec72e1601f0.jpeg', '', 1, 0, '2023-03-09 02:47:36', '2023-03-09 02:47:36', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633540109885591554, 'Oatmeal Fruit', 1633534612247760897, 1600.00, '', '34fee0f8-baac-4626-b369-a6e9b5467d8d.jpeg', '', 1, 0, '2023-03-09 02:48:07', '2023-03-09 02:48:07', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633540221001093122, 'McGriddle', 1633534612247760897, 2200.00, '', '9c3b31c9-8b20-4a76-9c61-4d1e1ba3466f.jpeg', '', 1, 0, '2023-03-09 02:48:33', '2023-03-09 02:48:33', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633542255859290114, 'Fries', 1633541826962345985, 1000.00, '', '56cee3dd-a9e1-4478-b7e3-65cdbf279761.jpeg', '', 1, 0, '2023-03-09 02:56:38', '2023-03-09 02:56:38', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633542361220206593, 'Apple Side', 1633541826962345985, 600.00, '', 'd2aaaed8-9edf-4501-bfad-ba38a9e9b3dd.jpeg', '', 1, 0, '2023-03-09 02:57:03', '2023-03-09 02:57:03', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633542434394034178, 'TangyBBQ', 1633541826962345985, 100.00, '', '1ac1b498-3d72-4ae4-9a81-11d305a0dd38.jpeg', '', 1, 0, '2023-03-09 02:57:21', '2023-03-09 02:57:21', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633542551264120833, 'CreamyRanch', 1633541826962345985, 100.00, '', '4414216e-2344-46d0-ae78-94260ac9a004.jpeg', '', 1, 0, '2023-03-09 02:57:49', '2023-03-09 02:57:49', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633542623540367361, 'SpicyBuffalo', 1633541826962345985, 100.00, '', '8c36b26f-75b4-4f4d-90dd-51588859bd4c.jpeg', '', 1, 0, '2023-03-09 02:58:06', '2023-03-09 02:58:06', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633542716129628161, 'HoneyMustard', 1633541826962345985, 100.00, '', '273fe07a-b64a-464a-bcb1-3e9c8f9ab824.jpeg', '', 1, 0, '2023-03-09 02:58:28', '2023-03-09 02:58:28', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633543471951597570, 'Apple Fritter', 1633543094900445186, 2200.00, '', '0ae291bf-e1b5-488d-96f7-c95c5059d9f5.jpeg', '', 1, 0, '2023-03-09 03:01:28', '2023-03-09 03:01:28', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633543559688048641, 'Blueberry Muffin', 1633543094900445186, 600.00, '', '97df9626-5828-4a3c-b73d-bcbbb453a428.jpeg', '', 1, 0, '2023-03-09 03:01:49', '2023-03-09 03:01:49', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633543639111389185, 'Cinnamon Roll', 1633543094900445186, 2000.00, '', '62d0c6e8-0910-4dee-933e-9526ef6f5958.jpeg', '', 1, 0, '2023-03-09 03:02:08', '2023-03-09 03:02:08', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633544516819832834, 'Hot Chocolate', 1633543914287091713, 1000.00, '', '87eeaf6a-1512-484f-b961-b9f2146559c3.jpeg', '', 1, 0, '2023-03-09 03:05:37', '2023-03-09 03:05:37', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633544735875747842, 'Strawberry Smoothie', 1633543914287091713, 1600.00, '', 'd0fb8a51-807e-4ad8-9068-758bde59938f.jpeg', '', 1, 0, '2023-03-09 03:06:29', '2023-03-09 03:06:29', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633544811415162882, 'Sweet Tea', 1633543914287091713, 300.00, '', 'dc3efc91-d91c-4608-a11c-3cf25bca0fe0.jpeg', '', 1, 0, '2023-03-09 03:06:47', '2023-03-09 03:06:47', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633544888493887489, 'Bottled Water', 1633543914287091713, 100.00, '', 'be3ecee6-37ad-477c-a147-6c3a6312f7a0.jpeg', '', 1, 0, '2023-03-09 03:07:06', '2023-03-09 03:07:06', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633545040168308737, 'Coca-Cola', 1633543914287091713, 300.00, '', '4524f31e-ee4e-45a8-94b0-eef05881e72d.jpeg', '', 1, 0, '2023-03-09 03:07:42', '2023-03-09 03:08:24', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633545141074874370, 'Fanta', 1633543914287091713, 300.00, '', '45396421-89a6-4936-8c87-6dd2b28f9d60.jpeg', '', 1, 0, '2023-03-09 03:08:06', '2023-03-09 03:08:06', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633545424051982337, 'FROZEN Fanta', 1633543914287091713, 600.00, '', 'dc9b043d-00df-4ef2-8169-502f68d28857.jpeg', '', 1, 0, '2023-03-09 03:09:14', '2023-03-09 03:09:14', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633545491005657090, 'Orange Juice', 1633543914287091713, 300.00, '', 'bdcbe6ba-fe1c-4412-82d7-5e931290b9d7.jpeg', '', 1, 0, '2023-03-09 03:09:30', '2023-03-09 03:09:30', 1, 1, 0);
INSERT INTO `dish` (`id`, `name`, `category_id`, `price`, `code`, `image`, `description`, `status`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633545566708649986, 'Sprite', 1633543914287091713, 300.00, '', '2c8118c4-e606-4eed-b300-4d9abe3dc97b.jpeg', '', 1, 0, '2023-03-09 03:09:48', '2023-03-09 03:09:48', 1, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for dish_flavor
-- ----------------------------
DROP TABLE IF EXISTS `dish_flavor`;
CREATE TABLE `dish_flavor` (
  `id` bigint(20) NOT NULL COMMENT 'primary key',
  `dish_id` bigint(20) NOT NULL COMMENT 'dish',
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'flavor name',
  `value` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT 'taste data list',
  `create_time` datetime NOT NULL COMMENT 'create time',
  `update_time` datetime NOT NULL COMMENT 'update time',
  `create_user` bigint(20) NOT NULL COMMENT 'Creator',
  `update_user` bigint(20) NOT NULL COMMENT 'modifier',
  `is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT 'Whether to delete',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relationship Table of Dishes and Tastes';

-- ----------------------------
-- Records of dish_flavor
-- ----------------------------
BEGIN;
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397849417888346113, 1397849417854791681, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:37:27', '2021-05-27 09:37:27', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397849739297861633, 1397849739276890114, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 09:38:43', '2021-05-27 09:38:43', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397849739323027458, 1397849739276890114, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:38:43', '2021-05-27 09:38:43', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397849936421761025, 1397849936404983809, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 09:39:30', '2021-05-27 09:39:30', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397849936438538241, 1397849936404983809, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:39:30', '2021-05-27 09:39:30', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397850141015715841, 1397850140982161409, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 09:40:19', '2021-05-27 09:40:19', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397850141040881665, 1397850140982161409, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:40:19', '2021-05-27 09:40:19', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397850392120307713, 1397850392090947585, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:41:19', '2021-05-27 09:41:19', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397850392137084929, 1397850392090947585, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:41:19', '2021-05-27 09:41:19', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397850630734262274, 1397850630700707841, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 09:42:16', '2021-05-27 09:42:16', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397850630755233794, 1397850630700707841, 'Spiciness', '[\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:42:16', '2021-05-27 09:42:16', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397851099523231745, 1397851099502260226, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 09:44:08', '2021-05-27 09:44:08', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397851099527426050, 1397851099502260226, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\"]', '2021-05-27 09:44:08', '2021-05-27 09:44:08', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397851370483658754, 1397851370462687234, 'Temperature', '[\"hot drink\",\"room temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2021-05-27 09:45:12', '2021-05-27 09:45:12', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397851370483658755, 1397851370462687234, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 09:45:12', '2021-05-27 09:45:12', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397851370483658756, 1397851370462687234, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:45:12', '2021-05-27 09:45:12', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397851668283437058, 1397851668262465537, 'Temperature', '[\"hot drink\",\"room temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2021-05-27 09:46:23', '2021-05-27 09:46:23', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397852391180120065, 1397852391150759938, 'Avoid certain foods', '[\"no green onions\",\"no cilantro\",\"no spicy\"]', '2021-05-27 09:49:16', '2021-05-27 09:49:16', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397852391196897281, 1397852391150759938, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"heavy spicy\"]', '2021-05-27 09:49:16', '2021-05-27 09:49:16', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397853183307984898, 1397853183287013378, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:52:24', '2021-05-27 09:52:24', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397853423486414850, 1397853423461249026, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:53:22', '2021-05-27 09:53:22', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397853709126905857, 1397853709101740034, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 09:54:30', '2021-05-27 09:54:30', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397853890283089922, 1397853890262118402, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:55:13', '2021-05-27 09:55:13', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397854133632413697, 1397854133603053569, 'Temperature', '[\"hot drink\",\"room temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2021-05-27 09:56:11', '2021-05-27 09:56:11', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397854652623007745, 1397854652581064706, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 09:58:15', '2021-05-27 09:58:15', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397854652635590658, 1397854652581064706, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:58:15', '2021-05-27 09:58:15', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397854865735593986, 1397854865672679425, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 09:59:06', '2021-05-27 09:59:06', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397855742303186946, 1397855742273826817, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 10:02:35', '2021-05-27 10:02:35', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397855906497605633, 1397855906468245506, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 10:03:14', '2021-05-27 10:03:14', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397856190573621250, 1397856190540066818, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 10:04:21', '2021-05-27 10:04:21', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397859056709316609, 1397859056684150785, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 10:15:45', '2021-05-27 10:15:45', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397859277837217794, 1397859277812051969, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 10:16:37', '2021-05-27 10:16:37', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397859487502086146, 1397859487476920321, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 10:17:27', '2021-05-27 10:17:27', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397859757061615618, 1397859757036449794, 'Sweetness', '[\"No sugar\",\"Less sugar\",\"Half sugar\",\"Poly sugar\",\"Full sugar\"]', '2021-05-27 10:18:32', '2021-05-27 10:18:32', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397860242086735874, 1397860242057375745, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 10:20:27', '2021-05-27 10:20:27', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397860963918065665, 1397860963880316929, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 10:23:19', '2021-05-27 10:23:19', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397861135754506242, 1397861135733534722, 'Sweetness', '[\"No sugar\",\"Less sugar\",\"Half sugar\",\"Poly sugar\",\"Full sugar\"]', '2021-05-27 10:24:00', '2021-05-27 10:24:00', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397861370035744769, 1397861370010578945, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-27 10:24:56', '2021-05-27 10:24:56', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397861683459305474, 1397861683434139649, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 10:26:11', '2021-05-27 10:26:11', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397861898467717121, 1397861898438356993, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 10:27:02', '2021-05-27 10:27:02', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397862198054268929, 1397862198033297410, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-27 10:28:14', '2021-05-27 10:28:14', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1397862477835317250, 1397862477831122945, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\"]', '2021-05-27 10:29:20', '2021-05-27 10:29:20', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398089545865015297, 1398089545676271617, 'Temperature', '[\"hot drink\",\"room temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2021-05-28 01:31:38', '2021-05-28 01:31:38', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398089782323097601, 1398089782285348866, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-28 01:32:34', '2021-05-28 01:32:34', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398090003262255106, 1398090003228700673, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-28 01:33:27', '2021-05-28 01:33:27', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398090264554811394, 1398090264517062657, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-28 01:34:29', '2021-05-28 01:34:29', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398090455399837698, 1398090455324340225, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-28 01:35:14', '2021-05-28 01:35:14', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398090685449023490, 1398090685419663362, 'Temperature', '[\"hot drink\",\"room temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2021-05-28 01:36:09', '2021-05-28 01:36:09', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398090825358422017, 1398090825329061889, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-28 01:36:43', '2021-05-28 01:36:43', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398091007051476993, 1398091007017922561, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-28 01:37:26', '2021-05-28 01:37:26', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398091296164851713, 1398091296131297281, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-28 01:38:35', '2021-05-28 01:38:35', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398091546531246081, 1398091546480914433, 'Avoid certain foods', '[\"no green onions\",\"no garlic\",\"no cilantro\",\"no spicy\"]', '2021-05-28 01:39:35', '2021-05-28 01:39:35', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398091729809747969, 1398091729788776450, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-28 01:40:18', '2021-05-28 01:40:18', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398091889499484161, 1398091889449152513, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-28 01:40:56', '2021-05-28 01:40:56', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398092095179763713, 1398092095142014978, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-28 01:41:45', '2021-05-28 01:41:45', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398092283877306370, 1398092283847946241, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-28 01:42:30', '2021-05-28 01:42:30', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398094018939236354, 1398094018893099009, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-28 01:49:24', '2021-05-28 01:49:24', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1398094391494094850, 1398094391456346113, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-05-28 01:50:53', '2021-05-28 01:50:53', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1399574026165727233, 1399305325713600514, 'Spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2021-06-01 03:50:25', '2021-06-01 03:50:25', 1399309715396669441, 1399309715396669441, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1413389684020682754, 1413342036832100354, 'Temperature', '[\"room temperature\",\"refrigeration\"]', '2021-07-09 15:12:18', '2021-07-09 15:12:18', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1632067392623710210, 1632067392531435522, 'sweetness', '[\"no sugar\",\"less sugar\",\"half sugar\",\"poly sugar\",\"full sugar\"]', '2023-03-05 01:16:03', '2023-03-05 01:16:03', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1632067392627904513, 1632067392531435522, 'spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2023-03-05 01:16:03', '2023-03-05 01:16:03', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633535152805466113, 1633535152541224962, 'diet', '[\"no onion\",\"no garlic\",\"no parsley\",\"no spicy\"]', '2023-03-09 02:28:25', '2023-03-09 02:28:25', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633535499439525890, 1633535499263365122, 'sweetness', '[\"no sugar\",\"less sugar\",\"half sugar\",\"poly sugar\",\"full sugar\"]', '2023-03-09 02:29:47', '2023-03-09 02:29:47', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633535499452108801, 1633535499263365122, 'diet', '[\"no onion\",\"no garlic\",\"no parsley\",\"no spicy\"]', '2023-03-09 02:29:47', '2023-03-09 02:29:47', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633535739747979266, 1633535739525681154, 'diet', '[\"no onion\",\"no garlic\",\"no parsley\",\"no spicy\"]', '2023-03-09 02:30:45', '2023-03-09 02:30:45', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633535739768950786, 1633535739525681154, 'spiciness', '[\"not spicy\",\"slightly spicy\",\"medium spicy\",\"heavy spicy\"]', '2023-03-09 02:30:45', '2023-03-09 02:30:45', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633536326812127234, 1633536326656937986, 'diet', '[\"no onion\",\"no garlic\",\"no parsley\",\"no spicy\"]', '2023-03-09 02:33:05', '2023-03-09 02:33:05', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633536463944896513, 1633536463684849666, 'diet', '[\"no onion\",\"no garlic\",\"no parsley\",\"no spicy\"]', '2023-03-09 02:33:37', '2023-03-09 02:33:37', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633536587009970177, 1633536586758311937, 'diet', '[\"no onion\",\"no garlic\",\"no parsley\",\"no spicy\"]', '2023-03-09 02:34:07', '2023-03-09 02:34:07', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633537940012748801, 1633537939886919682, 'sweetness', '[\"no sugar\",\"less sugar\",\"half sugar\",\"poly sugar\",\"full sugar\"]', '2023-03-09 02:39:29', '2023-03-09 02:39:29', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633537940016943105, 1633537939886919682, 'temperature', '[\"hot drink\",\"normal temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2023-03-09 02:39:29', '2023-03-09 02:39:29', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538079653711873, 1633538079083286530, 'sweetness', '[\"no sugar\",\"less sugar\",\"half sugar\",\"poly sugar\",\"full sugar\"]', '2023-03-09 02:40:03', '2023-03-09 02:40:03', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538079657906178, 1633538079083286530, 'temperature', '[\"hot drink\",\"normal temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2023-03-09 02:40:03', '2023-03-09 02:40:03', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538822251040769, 1633538822137794562, 'temperature', '[\"hot drink\",\"normal temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2023-03-09 02:43:00', '2023-03-09 02:43:00', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538822255235073, 1633538822137794562, 'sweetness', '[\"no sugar\",\"less sugar\",\"half sugar\",\"poly sugar\",\"full sugar\"]', '2023-03-09 02:43:00', '2023-03-09 02:43:00', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538952748421122, 1633538952630980609, 'sweetness', '[\"no sugar\",\"less sugar\",\"half sugar\",\"poly sugar\",\"full sugar\"]', '2023-03-09 02:43:31', '2023-03-09 02:43:31', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633538952748421123, 1633538952630980609, 'temperature', '[\"hot drink\",\"normal temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2023-03-09 02:43:31', '2023-03-09 02:43:31', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633539470950486017, 1633539470828851201, 'diet', '[\"no onion\",\"no garlic\",\"no parsley\",\"no spicy\"]', '2023-03-09 02:45:34', '2023-03-09 02:45:34', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633539984547205121, 1633539983758675969, 'sweetness', '[\"no sugar\",\"less sugar\",\"half sugar\",\"poly sugar\",\"full sugar\"]', '2023-03-09 02:47:37', '2023-03-09 02:47:37', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633543559830654977, 1633543559688048641, 'sweetness', '[\"no sugar\",\"less sugar\",\"half sugar\",\"poly sugar\",\"full sugar\"]', '2023-03-09 03:01:49', '2023-03-09 03:01:49', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633544517004382210, 1633544516819832834, 'temperature', '[\"hot drink\",\"normal temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2023-03-09 03:05:37', '2023-03-09 03:05:37', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633544736014159873, 1633544735875747842, 'temperature', '[\"no ice\",\"less ice\",\"more ice\"]', '2023-03-09 03:06:30', '2023-03-09 03:06:30', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633545141246840834, 1633545141074874370, 'temperature', '[\"hot drink\",\"normal temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2023-03-09 03:08:06', '2023-03-09 03:08:06', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633545217138577409, 1633545040168308737, 'temperature', '[\"normal temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2023-03-09 03:08:24', '2023-03-09 03:08:24', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633545424207171585, 1633545424051982337, 'sweetness', '[\"no sugar\",\"less sugar\",\"half sugar\",\"poly sugar\",\"full sugar\"]', '2023-03-09 03:09:14', '2023-03-09 03:09:14', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633545424207171586, 1633545424051982337, 'temperature', '[\"hot drink\",\"normal temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2023-03-09 03:09:14', '2023-03-09 03:09:14', 1, 1, 0);
INSERT INTO `dish_flavor` (`id`, `dish_id`, `name`, `value`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633545566884810754, 1633545566708649986, 'temperature', '[\"normal temperature\",\"no ice\",\"less ice\",\"more ice\"]', '2023-03-09 03:09:48', '2023-03-09 03:09:48', 1, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL COMMENT 'primary key',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'name',
  `username` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'username',
  `password` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'password',
  `phone` varchar(11) COLLATE utf8_bin NOT NULL COMMENT 'phone number',
  `sex` varchar(2) COLLATE utf8_bin NOT NULL COMMENT 'sex',
  `id_number` varchar(18) COLLATE utf8_bin NOT NULL COMMENT 'ID number',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT 'status 0: disabled, 1: normal',
  `create_time` datetime NOT NULL COMMENT 'create time',
  `update_time` datetime NOT NULL COMMENT 'update time',
  `create_user` bigint(20) NOT NULL COMMENT 'Creator',
  `update_user` bigint(20) NOT NULL COMMENT 'modifier',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='employee information';

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
INSERT INTO `employee` (`id`, `name`, `username`, `password`, `phone`, `sex`, `id_number`, `status`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1, 'admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '13812312312', '1', '110101199001010047', 1, '2021-05-06 17:20:07', '2021-05-10 02:24:09', 1, 1);
INSERT INTO `employee` (`id`, `name`, `username`, `password`, `phone`, `sex`, `id_number`, `status`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1631333409141084162, 'Guo Zhaochen', 'Guo Zhaochen', 'e10adc3949ba59abbe56e057f20f883e', '18543179785', '1', '220104199903143313', 1, '2023-03-03 00:39:28', '2023-03-07 00:46:22', 1, 1);
INSERT INTO `employee` (`id`, `name`, `username`, `password`, `phone`, `sex`, `id_number`, `status`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1631359822401466370, 'LiJida', 'LiJida', 'e10adc3949ba59abbe56e057f20f883e', '18633323377', '1', '220104199801313313', 1, '2023-03-03 02:24:26', '2023-03-04 00:09:18', 1, 1);
INSERT INTO `employee` (`id`, `name`, `username`, `password`, `phone`, `sex`, `id_number`, `status`, `create_time`, `update_time`, `create_user`, `update_user`) VALUES (1631689261471502337, 'Jiang Yuanxin', 'Jiang Yuanxin', 'e10adc3949ba59abbe56e057f20f883e', '18856565656', '1', '210102199990313333', 1, '2023-03-04 00:13:30', '2023-03-06 22:49:55', 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL COMMENT 'primary key',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'name',
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'image',
  `order_id` bigint(20) NOT NULL COMMENT 'order id',
  `dish_id` bigint(20) DEFAULT NULL COMMENT 'dish id',
  `setmeal_id` bigint(20) DEFAULT NULL COMMENT 'meal id',
  `dish_flavor` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'flavor',
  `number` int(11) NOT NULL DEFAULT '1' COMMENT 'number',
  `amount` decimal(10,2) NOT NULL COMMENT 'amount',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='order details';

-- ----------------------------
-- Records of order_detail
-- ----------------------------
BEGIN;
INSERT INTO `order_detail` (`id`, `name`, `image`, `order_id`, `dish_id`, `setmeal_id`, `dish_flavor`, `number`, `amount`) VALUES (1633509697184460801, 'Shaoyang Pig Blood Balls', '2a50628e-7758-4c51-9fbb-d37c61cdacad.jpg', 1633509696840527873, NULL, 1397851370462687234, NULL, 1, 138.00);
INSERT INTO `order_detail` (`id`, `name`, `image`, `order_id`, `dish_id`, `setmeal_id`, `dish_flavor`, `number`, `amount`) VALUES (1633509697201238018, 'taste snake', '0f4bd884-dc9c-4cf9-b59e-7d5958fec3dd.jpg', 1633509696840527873, NULL, 1397851668262465537, NULL, 1, 168.00);
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL COMMENT 'primary key',
  `number` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'order number',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT 'Order status 1 pending payment, 2 pending delivery, 3 delivered, 4 completed, 5 canceled',
  `user_id` bigint(20) NOT NULL COMMENT 'order user',
  `address_book_id` bigint(20) NOT NULL COMMENT 'address id',
  `order_time` datetime NOT NULL COMMENT 'order time',
  `checkout_time` datetime NOT NULL COMMENT 'checkout time',
  `pay_method` int(11) NOT NULL DEFAULT '1' COMMENT 'Payment method 1 WeChat, 2 Alipay',
  `amount` decimal(10,2) NOT NULL COMMENT 'Amount received',
  `remark` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'remark',
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `consignee` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='order table';

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` (`id`, `number`, `status`, `user_id`, `address_book_id`, `order_time`, `checkout_time`, `pay_method`, `amount`, `remark`, `phone`, `address`, `user_name`, `consignee`) VALUES (1633509698467917825, '1633509696840527873', 3, 1633137741348065282, 1633145883293220866, '2023-03-09 00:47:16', '2023-03-09 00:47:16', 1, 306.00, '', '18737281983', 'Tseung Kwan O', 'Kevin Kimi', 'Kilo');
COMMIT;

-- ----------------------------
-- Table structure for setmeal
-- ----------------------------
DROP TABLE IF EXISTS `setmeal`;
CREATE TABLE `setmeal` (
  `id` bigint(20) NOT NULL COMMENT 'primary key',
  `category_id` bigint(20) NOT NULL COMMENT 'dish category id',
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'package name',
  `price` decimal(10,2) NOT NULL COMMENT 'package price',
  `status` int(11) DEFAULT NULL COMMENT 'Status 0: disabled 1: enabled',
  `code` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'encode',
  `description` varchar(512) COLLATE utf8_bin DEFAULT NULL COMMENT 'description',
  `image` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'image',
  `create_time` datetime NOT NULL COMMENT 'create time',
  `update_time` datetime NOT NULL COMMENT 'update time',
  `create_user` bigint(20) NOT NULL COMMENT 'Creator',
  `update_user` bigint(20) NOT NULL COMMENT 'modifier',
  `is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT 'Whether to delete',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_setmeal_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='package';

-- ----------------------------
-- Records of setmeal
-- ----------------------------
BEGIN;
INSERT INTO `setmeal` (`id`, `category_id`, `name`, `price`, `status`, `code`, `description`, `image`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633540916429279233, 1413342269393674242, 'Simple Morning', 3000.00, 1, '', '', '72dbc73b-db47-4ec4-8d3c-802786e99ef8.jpeg', '2023-03-09 02:51:19', '2023-03-09 02:51:19', 1, 1, 0);
INSERT INTO `setmeal` (`id`, `category_id`, `name`, `price`, `status`, `code`, `description`, `image`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633541340838318082, 1413342269393674242, 'Luxurious Morning', 5900.00, 1, '', '', '528607bc-5d73-4b63-99dd-61c6dff61ccf.jpeg', '2023-03-09 02:53:00', '2023-03-09 02:53:00', 1, 1, 0);
INSERT INTO `setmeal` (`id`, `category_id`, `name`, `price`, `status`, `code`, `description`, `image`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633541523777081345, 1413342269393674242, 'Healthy Morning', 4600.00, 1, '', '', '0b769bfd-564c-4f7f-80f4-7332b604ae9a.jpeg', '2023-03-09 02:53:44', '2023-03-09 02:53:44', 1, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for setmeal_dish
-- ----------------------------
DROP TABLE IF EXISTS `setmeal_dish`;
CREATE TABLE `setmeal_dish` (
  `id` bigint(20) NOT NULL COMMENT 'primary key',
  `setmeal_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'meal id',
  `dish_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'dish id',
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'Dish name (redundant field)',
  `price` decimal(10,2) DEFAULT NULL COMMENT 'Original price of dishes (redundant field)',
  `copies` int(11) NOT NULL COMMENT 'number of copies',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT 'sort',
  `create_time` datetime NOT NULL COMMENT 'create time',
  `update_time` datetime NOT NULL COMMENT 'update time',
  `create_user` bigint(20) NOT NULL COMMENT 'Creator',
  `update_user` bigint(20) NOT NULL COMMENT 'modifier',
  `is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT 'Whether to delete',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Set meal relationship';

-- ----------------------------
-- Records of setmeal_dish
-- ----------------------------
BEGIN;
INSERT INTO `setmeal_dish` (`id`, `setmeal_id`, `dish_id`, `name`, `price`, `copies`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633540916559302657, '1633540916429279233', '1633540221001093122', 'McGriddle', 2200.00, 1, 0, '2023-03-09 02:51:19', '2023-03-09 02:51:19', 1, 1, 0);
INSERT INTO `setmeal_dish` (`id`, `setmeal_id`, `dish_id`, `name`, `price`, `copies`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633540916559302658, '1633540916429279233', '1633539775079469058', 'HashBrowns', 1600.00, 1, 0, '2023-03-09 02:51:19', '2023-03-09 02:51:19', 1, 1, 0);
INSERT INTO `setmeal_dish` (`id`, `setmeal_id`, `dish_id`, `name`, `price`, `copies`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633540916559302659, '1633540916429279233', '1633538952630980609', 'Medium Americano', 1800.00, 1, 0, '2023-03-09 02:51:19', '2023-03-09 02:51:19', 1, 1, 0);
INSERT INTO `setmeal_dish` (`id`, `setmeal_id`, `dish_id`, `name`, `price`, `copies`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633541340951564289, '1633541340838318082', '1633539775079469058', 'HashBrowns', 1600.00, 1, 0, '2023-03-09 02:53:00', '2023-03-09 02:53:00', 1, 1, 0);
INSERT INTO `setmeal_dish` (`id`, `setmeal_id`, `dish_id`, `name`, `price`, `copies`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633541341027061761, '1633541340838318082', '1633539872806752257', 'SausageBurrito', 2200.00, 2, 0, '2023-03-09 02:53:00', '2023-03-09 02:53:00', 1, 1, 0);
INSERT INTO `setmeal_dish` (`id`, `setmeal_id`, `dish_id`, `name`, `price`, `copies`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633541341039644673, '1633541340838318082', '1633538079083286530', 'Cappuccino', 1800.00, 1, 0, '2023-03-09 02:53:00', '2023-03-09 02:53:00', 1, 1, 0);
INSERT INTO `setmeal_dish` (`id`, `setmeal_id`, `dish_id`, `name`, `price`, `copies`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633541523894521858, '1633541523777081345', '1633540109885591554', 'Oatmeal Fruit', 1600.00, 1, 0, '2023-03-09 02:53:44', '2023-03-09 02:53:44', 1, 1, 0);
INSERT INTO `setmeal_dish` (`id`, `setmeal_id`, `dish_id`, `name`, `price`, `copies`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633541523923881986, '1633541523777081345', '1633539775079469058', 'HashBrowns', 1600.00, 1, 0, '2023-03-09 02:53:44', '2023-03-09 02:53:44', 1, 1, 0);
INSERT INTO `setmeal_dish` (`id`, `setmeal_id`, `dish_id`, `name`, `price`, `copies`, `sort`, `create_time`, `update_time`, `create_user`, `update_user`, `is_deleted`) VALUES (1633541523923881987, '1633541523777081345', '1633539582804185089', 'SausageBiscuit', 2800.00, 1, 0, '2023-03-09 02:53:44', '2023-03-09 02:53:44', 1, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` bigint(20) NOT NULL COMMENT 'primary key',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'name',
  `image` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'image',
  `user_id` bigint(20) NOT NULL COMMENT 'primary key',
  `dish_id` bigint(20) DEFAULT NULL COMMENT 'dish id',
  `setmeal_id` bigint(20) DEFAULT NULL COMMENT 'meal id',
  `dish_flavor` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'flavor',
  `number` int(11) NOT NULL DEFAULT '1' COMMENT 'number',
  `amount` decimal(10,2) NOT NULL COMMENT 'amount',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='shopping cart';

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT 'primary key',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'name',
  `phone` varchar(100) COLLATE utf8_bin NOT NULL COMMENT 'phone number',
  `sex` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT 'sex',
  `id_number` varchar(18) COLLATE utf8_bin DEFAULT NULL COMMENT 'ID number',
  `avatar` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT 'avatar',
  `status` int(11) DEFAULT '0' COMMENT 'status 0: disabled, 1: normal',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User Information';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `phone`, `sex`, `id_number`, `avatar`, `status`) VALUES (1633137741348065282, NULL, '18737281983', NULL, NULL, NULL, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
