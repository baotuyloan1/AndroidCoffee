-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2020 at 04:50 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project2`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL,
  `idUser` bigint(20) UNSIGNED NOT NULL,
  `idProduct` bigint(11) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `star` int(11) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `idUser`, `idProduct`, `content`, `star`, `created_at`) VALUES
(47, 2, 26, 'hú hú hú', 5, '2020-01-10 14:48:42'),
(48, 35, 26, 'sản phẩm oke', 5, '2020-01-10 15:43:10');

-- --------------------------------------------------------

--
-- Table structure for table `cusinfo`
--

CREATE TABLE `cusinfo` (
  `id` bigint(20) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `userId` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cusinfo`
--

INSERT INTO `cusinfo` (`id`, `fullName`, `email`, `address`, `phone`, `userId`) VALUES
(156, 'Test', 'acccuabao001@gmail.com', ' sgsdf', '93237273273', NULL),
(157, 'cascas', 'acccuabao001@gmail.com', ' sdfsdfsdf', '272227227', NULL),
(158, 'cascasc', 'acccuabao001@gmail.com', ' ccdcwdc', '2722722722', NULL),
(159, 'c cd d', 'acccuabao001@gmail.com', ' csdcdcwec', '33833833', NULL),
(160, 'v dvdf', 'acccuabao001@gmail.com', ' dcsdcsdcds', '833833833', NULL),
(161, 'x zxc', 'acccuabao001@gmail.com', ' sdvsdv', '992992', NULL),
(162, 'dscsdcsd', 'acccuabao001@gmail.com', ' dscsdcsd', '2732732732', NULL),
(163, 'dcsdcs', 'acccuabao001@gmail.com', ' sdcsdc', '2732732', NULL),
(164, 'dcsdcsd', 'acccuabao001@gmail.com', ' dssdcsd', '273273273', NULL),
(165, 'dscsdc', 'acccuabao001@gmail.com', ' csdc', '73273273', NULL),
(166, 'zxczxc', 'acccuabao001@gmail.com', ' zxcxzc', '992992', NULL),
(167, 'xcvxcv', 'acccuabao001@gmail.com', ' xcvxcv', '928928', NULL),
(168, 'dcdsc', 'acccuabao001@gmail.com', ' sdcsd', '372732', NULL),
(169, 'frrécdsc', 'acccuabao001@gmail.com', ' csdcsdcsd', '73273273', NULL),
(170, 'ccc', 'acccuabao001@gmail.com', ' cccc', '22222', NULL),
(171, 'vvvv', 'acccuabao001@gmail.com', ' vvv', '8888', NULL),
(172, 'c xcx', 'acccuabao001@gmail.com', ' vsdvsd', '29 92837', NULL),
(173, 'zxczxc', 'acccuabao001@gmail.com', ' zxczxczx', '99299299299', NULL),
(174, 'gbc', 'acccuabao001@gmail.com', ' cbcg', '22242', NULL),
(175, 'cccc', 'acccuabao001@gmail.com', ' zxczxc', '92992', NULL),
(176, 'v vcxc', 'acccuabao001@gmail.com', ' vsdvsd', '8928', NULL),
(177, 'vvv', 'acccuabao001@gmail.com', ' vv', '888', NULL),
(178, 'cxzcxc', 'acccuabao001@gmail.com', ' zxczxc', '992992992', NULL),
(179, 'xxxx', 'acccuabao001@gmail.com', ' xxx', '999', NULL),
(180, 'vcb', 'acccuabao001@gmail.com', ' cvbcvb', '28228', NULL),
(181, 'bvc', 'acccuabao001@gmail.com', ' cvbcvb', '282282', NULL),
(182, 'cxz', 'acccuabao001@gmail.com', ' czxc', '299299', NULL),
(183, 'cvc', 'acccuabao001@gmail.com', 'Hoa phong Hoa vang', '0788049000', NULL),
(184, 'zdvcx', 'acccuabao001@gmail.com', ' cvxcv', '89289', NULL),
(185, 'cxzcxz', 'acccuabao001@gmail.com', ' xzcxzc', '2992', NULL),
(186, 'xzcxz', 'acccuabao001@gmail.com', ' czxczxc', '299299', NULL),
(187, 'bvn', 'acccuabao001@gmail.com', ' vbnvb', '826826', NULL),
(188, 'Lê Văn A', 'acccuabao001@gmail.com', 'Số 8D Đường 43, P, Khu Phố 7, Thủ Đức, Hồ Chí Minh.', '0888975555', 26),
(189, 'Lê Văn A', 'acccuabao001@gmail.com', 'Số 8D Đường 43, P, Khu Phố 7, Thủ Đức, Hồ Chí Minh.', '0888975555', 26),
(190, 'Nguyen Duc Bao', 'acccuabao001@gmail.com', ' zxc', '0788049042', NULL),
(191, 'van tuan', 'duongvantuan1503@gmail.com', ' tam ky', '0582536376', NULL),
(192, 'Nguyen DUc Bao', 'acccuabao001@gmail.com', ' zxcscc', '3773', NULL),
(193, 'vbv', 'acccuabao001@gmail.com', ' bvbv', '2828', NULL),
(194, 'ccccccc', 'acccuabao001@gmail.com', ' a', '29999', NULL),
(195, 'ccc', 'acccuabao001@gmail.com', ' ccc', '22222', NULL),
(196, 'xx', 'acccuabao001@gmail.com', ' xx', '99', NULL),
(197, 'cxzczxc', 'acccuabao001@gmail.com', ' zxczx', '992992', NULL),
(198, 'sdsd', 'acccuabao001@gmail.com', ' dsds', '73737', NULL),
(199, 'cx', 'acccuabao001@gmail.com', ' zxczx', '929', NULL),
(200, 'xzxzx', 'acccuabao001@gmail.com', ' xzxz', '9999999', NULL),
(201, 'zxzxz', 'acccuabao001@gmail.com', ' xzx', '9999', NULL),
(202, 'xzxz', 'acccuabao001@gmail.com', ' zxzxz', '99999', NULL),
(203, 'vxcvxc', 'acccuabao001@gmail.com', ' xcvxcvxcv', '928928', NULL),
(204, 'xzczx', 'acccuabao001@gmail.com', ' zxczxczx', '2992992', NULL),
(205, 'Nguyen Duc Bao', 'acccuabao001@gmail.com', 'xzczxc', '0788049042', NULL),
(206, 'cxvxcv', 'acccuabao001@gmail.com', ' xcvxcvxcv', '92892892892', NULL),
(207, 'saá', 'acccuabao001@gmail.com', ' dcsdcsd', '2135123', NULL),
(208, 'Nguyễn Đức Bảo', 'acccuabao001@gmail.com', ' Duong lam', '0788049042', NULL),
(209, 'Nguyễn Đức Bảo', 'acccuabao001@gmail.com', ' Duong lam 1 hoa phong hoa vang', '0788049042', NULL),
(210, 'Nguyễn Đức Bảo', 'acccuabao001@gmail.com', ' Duong lam', '0788049042', NULL),
(211, 'Nguyễn Đức Bảo', 'acccuabao001@gmail.com', 'dsfsdf', '0788049042', NULL),
(212, 'fbfb', 'acccuabao001@gmail.com', ' sanduai', '0788049042', NULL),
(213, 'Le Tung Khanh', 'acccuabao001@gmail.com', ' 346 Dong Da, Da Nang', '0788049042', NULL),
(214, 'Nguyễn Đức Bảo', 'admin@gmail.com', ' Dương Lâm 1, Hòa Phong , Hòa Vang , Đà Nẵng', '0788049042', NULL),
(215, 'Nguyễn Đức Bảo', 'acccuabao001@gmail.com', ' Dương Lâm 1, Hòa Phong , Hòa Vang , Đà Nẵng', '0788049042', NULL),
(216, 'Nguyễn Đức Bảo', 'acccuabao001@gmail.com', ' Dương Lâm 1, Hòa Phong , Hòa Vang , Đà Nẵng', '0788049042', NULL),
(217, 'Nguyễn Đức Bảo', 'acccuabao001@gmail.com', ' Dương Lâm 1, Hòa Phong , Hòa Vang , Đà Nẵng', '0788049042', NULL),
(218, 'Đinh Trà Giang', 'tragiangpro312@gmail.com', ' 390 Lê Duẩn', '0962064777', NULL),
(219, 'Nguyen DUc Bao', 'nguyenducbaokey@gmail.com', ' Hoa Phong, Hoa Vang, Da Nang', '0788049042', NULL),
(220, 'Nguyen DUc Bao', 'nguyenducbaokey@gmail.com', ' Hoa Phong, Hoa Vang, Da Nang', '0788049042', NULL),
(221, 'Nguyễn Đức Bảo', 'acccuabao001@gmail.com', ' Hòa Phong, Hòa Vang Đà Nẵng', '0788049042', NULL),
(222, 'Nguyễn Đức Bảo', 'acccuabao001@gmail.com', ' Hòa Phong, Hòa Vang, Đà Nẵng', '0905624652', NULL),
(223, 'hhnhbh', 'hjhjbhhj', ' nhbuhbu', '86677878', NULL),
(224, 'hhnhbh', 'hjhjbhhj@gmail.com', ' nhbuhbu', '86677878', NULL),
(225, 'hhnhbh', 'hjhjbhhj@gmail.com', ' nhbuhbu', '86677878', NULL),
(226, 'cvcxv', 'xcvxcvxc@gmail.com', ' xcvsdvs', '4534534', NULL),
(227, 'cvcxv', 'xcvxcvxc@gmail.com', ' xcvsdvs', '45345344523', NULL),
(228, 'cvcxv', 'xcvxcvxc@gmail.com', ' xcvsdvs', '45345344523', NULL),
(229, 'cvcxv', 'xcvxcvxc@gmail.com', ' xcvsdvs', '45345344523', NULL),
(230, 'cvcxv', 'xcvxcvxc@gmail.com', ' xcvsdvs', '45345344523', NULL),
(231, 'cac', 'acccuabao001@gmail.com', ' xzczxc', '0788049042', NULL),
(232, 'cac', 'acccuabao001@gmail.com', ' xzczxc', '0788049042', NULL),
(233, 'cac', 'acccuabao001@gmail.com', ' xzczxc', '0788049042', NULL),
(234, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(235, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(236, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(237, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(238, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(239, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(240, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(241, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(242, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(243, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(244, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(245, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(246, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(247, 'czxczxc', 'acccuabao001@gmail.com', ' sc', '0788049042', NULL),
(248, 'Bánh Bèo', 'acccuabao001@gmail.com', ' Hoa Phong, Hòa Vang, Đà Nẵng', '0788049042', NULL),
(249, 'Bánh Bèo', 'acccuabao001@gmail.com', ' Hoa Phong, Hòa Vang, Đà Nẵng', '0788049042', NULL),
(250, 'Bánh Bèo', 'acccuabao001@gmail.com', ' Hoa Phong, Hòa Vang, Đà Nẵng', '0788049042', NULL),
(251, 'Bánh Bèo', 'acccuabao001@gmail.com', ' Hoa Phong, Hòa Vang, Đà Nẵng', '0788049042', NULL),
(252, 'Nguyễn Văn A', 'ndbao.18it5@sict.udn.vn', ' Hòa Phong, Hòa Vang, Đà Nẵng', '0788049042', NULL),
(253, 'Nguyễn Văn A', 'ndbao.18it5@sict.udn.vn', ' Hòa Phong, Hòa Vang, Đà Nẵng', '0788049042', NULL),
(254, 'baotuyloan1', 'acccuabao001@gmail.com', ' baotuyloan1', 'baotuyloan1', NULL),
(255, 'Nguyễn Đức Bảo', 'acccuabao001@gmail.com', ' Hòa Phong Đà Nẵng', '0788049042', NULL),
(256, 'baotuyloan1', 'acccuabao001@gmail.com', ' baotuyloan1', '03419283712', NULL),
(257, 'baotuyloan2', 'nguyenducbaokey@gmail.com', ' Hòa Phong, Hòa Vang, Da Nang', '2390123132', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `productId` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`id`, `name`, `productId`) VALUES
(4, 'coffee-tree-so1-2.jpg', 2),
(5, 'coffee-tree-so1-0.jpg', 2),
(6, 'coffee-tree-so1-0.jpg', 3),
(7, 'coffee-tree-so1.jpg', 3),
(10, '2ZWLculi-buon-me-thuot.png', 5),
(11, 'RegCcoffee-tree-so1-2.jpg', 5),
(12, 'dmUJcf-1024x858.jpg', 5),
(13, 'Dw98_robusta-buon-ma-thuot.png', 8),
(14, 'coffee-tree-so1.jpg', 8),
(15, 'ca-phe-coffee-tree-truyen-thong-so-3.png', 7),
(16, 'robusta-buon-ma-thuot.png', 6),
(27, 'coffee-tree-so1-2.jpg', 4),
(28, 'RegCcoffee-tree-so1-2.jpg', 4),
(39, 'coffee-tree-so1-0.jpg', 14),
(43, 'RegCcoffee-tree-so1-2.jpg', 10),
(44, 'hinh-900x900-caphe-robusta.png', 10),
(53, 'img_avatar3.png', 26),
(54, 'img_avatar3.png', 26),
(55, '7baZimg_avatar3.png', 27),
(56, 'aLQrimg_avatar3.png', 27);

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_resets_table', 1);

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `id` bigint(11) NOT NULL,
  `idOrder` bigint(20) NOT NULL,
  `idProduct` bigint(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `priceProduct` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`id`, `idOrder`, `idProduct`, `quantity`, `priceProduct`) VALUES
(214, 125, 27, 1, 2000000),
(215, 126, 26, 1, 510000),
(216, 127, 27, 1, 2000000),
(217, 128, 27, 1, 2000000),
(218, 129, 27, 1, 2000000),
(219, 130, 27, 1, 2000000),
(220, 131, 27, 1, 2000000),
(221, 132, 27, 1, 2000000),
(222, 133, 27, 4, 8000000),
(223, 134, 27, 1, 2000000),
(224, 135, 7, 1, 234),
(225, 136, 27, 1, 2000000),
(226, 137, 27, 1, 2000000),
(227, 137, 10, 1, 200000),
(228, 137, 8, 1, 168),
(229, 138, 27, 1, 2000000),
(230, 138, 7, 1, 234),
(231, 139, 27, 1, 2000000),
(232, 139, 8, 3, 504),
(233, 140, 27, 4, 8000000),
(234, 140, 10, 5, 1000000),
(235, 141, 27, 1, 2000000),
(236, 142, 27, 4, 8000000),
(237, 143, 26, 1, 510000),
(238, 143, 14, 1, 3500000),
(239, 144, 26, 1, 510000),
(240, 144, 10, 1, 200000),
(241, 145, 26, 1, 510000),
(242, 145, 8, 1, 168),
(243, 146, 26, 1, 510000),
(244, 147, 26, 1, 510000),
(245, 148, 26, 1, 510000),
(246, 149, 26, 1, 510000),
(247, 150, 26, 1, 510000),
(248, 151, 26, 1, 510000),
(249, 152, 27, 1, 2000000),
(250, 153, 27, 1, 2000000),
(251, 154, 27, 5, 10000000),
(252, 155, 26, 1, 510000),
(253, 155, 14, 1, 3500000),
(254, 155, 7, 1, 234),
(255, 156, 27, 1, 2000000),
(256, 157, 8, 1, 168000),
(257, 157, 26, 3, 410000),
(258, 157, 7, 2, 234000),
(259, 158, 27, 1, 195000),
(260, 158, 26, 1, 410000),
(261, 159, 10, 5, 1000000),
(262, 160, 14, 2, 700000),
(263, 160, 2, 1, 213000),
(264, 161, 8, 5, 840000),
(265, 161, 10, 6, 1200000),
(266, 162, 27, 1, 2000000),
(267, 163, 27, 4, 8000000),
(268, 164, 10, 4, 800000),
(269, 165, 10, 5, 1000000),
(270, 166, 27, 6, 12000000),
(271, 167, 10, 6, 1200000),
(272, 168, 26, 7, 3570000),
(273, 169, 10, 5, 1000000),
(274, 170, 26, 4, 2040000),
(275, 171, 14, 5, 1750000),
(276, 171, 8, 6, 1008000),
(277, 172, 7, 4, 936000),
(278, 172, 14, 2, 700000),
(279, 173, 14, 5, 1750000),
(280, 173, 8, 2, 336000),
(281, 174, 26, 5, 2550000),
(282, 175, 26, 4, 1640000),
(283, 175, 27, 4, 8000000),
(284, 176, 27, 1, 2000000),
(285, 177, 27, 1, 2000000),
(286, 178, 27, 2, 4000000),
(287, 179, 27, 1, 2000000),
(288, 179, 26, 2, 820000),
(289, 180, 26, 2, 410000),
(290, 181, 27, 2, 2000000),
(291, 181, 26, 2, 410000),
(292, 182, 27, 4, 2000000),
(293, 182, 26, 1, 410000),
(294, 183, 26, 2, 410000),
(295, 183, 14, 2, 300000),
(296, 183, 10, 3, 100000),
(297, 183, 8, 3, 168000),
(298, 184, 27, 2, 2000000),
(299, 184, 14, 1, 300000),
(300, 184, 4, 1, 240000),
(301, 185, 27, 1, 2000000),
(302, 186, 27, 1, 2000000),
(303, 187, 3, 1, 230000),
(304, 187, 14, 2, 300000),
(305, 187, 2, 1, 200000),
(306, 188, 27, 1, 2000000),
(307, 188, 26, 2, 410000),
(308, 189, 27, 4, 2000000),
(309, 189, 26, 5, 410000),
(310, 190, 27, 2, 2000000),
(311, 190, 26, 1, 410000),
(312, 233, 27, 1, 2000000),
(313, 234, 27, 2, 2000000),
(314, 235, 27, 1, 2000000),
(315, 236, 27, 2, 2000000),
(316, 237, 27, 1, 2000000);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `cusId` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `totalPrice` bigint(10) NOT NULL,
  `note` varchar(1000) DEFAULT NULL,
  `accId` bigint(20) UNSIGNED DEFAULT NULL,
  `delivered` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `cusId`, `created_at`, `totalPrice`, `note`, `accId`, `delivered`) VALUES
(125, 156, '2020-06-10 14:57:19', 2000000, 'dsfsdf', 2, 0),
(126, 157, '2020-06-10 15:00:15', 510000, 'ewfwef', 2, 0),
(127, 158, '2020-06-10 15:02:55', 2000000, 'sdcsdc', NULL, 0),
(128, 159, '2020-06-10 15:05:13', 2000000, 'wecwec', NULL, 0),
(129, 160, '2020-06-10 15:08:27', 2000000, '', NULL, 0),
(130, 161, '2020-06-10 15:15:11', 2000000, '', NULL, 0),
(131, 162, '2020-06-10 15:16:10', 2000000, '', NULL, 0),
(132, 163, '2020-06-10 15:20:44', 2000000, '', NULL, 0),
(133, 164, '2020-06-10 15:28:40', 8000000, '', NULL, 0),
(134, 165, '2020-06-10 15:29:48', 2000000, '', NULL, 0),
(135, 166, '2020-06-10 15:31:05', 234, '', NULL, 0),
(136, 167, '2020-06-10 15:33:50', 2000000, '', NULL, 0),
(137, 168, '2020-06-10 15:37:33', 6400168, 'csdc', NULL, 0),
(138, 169, '2020-06-10 15:40:23', 4000234, 'csdc', NULL, 0),
(139, 170, '2020-06-10 15:41:50', 4000504, '', NULL, 0),
(140, 171, '2020-06-10 15:43:23', 29000000, '', NULL, 0),
(141, 172, '2020-06-11 14:40:30', 2000000, 'vsdv', NULL, 0),
(142, 173, '2020-06-11 14:47:41', 20000000, 'czxczxc', NULL, 0),
(143, 174, '2020-06-11 15:11:57', 4520000, 'bcgb', NULL, 0),
(144, 175, '2020-06-11 15:15:28', 1220000, 'zxc', NULL, 0),
(145, 176, '2020-06-11 15:18:53', 1020168, 'csdc', NULL, 0),
(146, 177, '2020-06-11 15:22:02', 510000, 'vvv', NULL, 0),
(147, 178, '2020-06-11 15:23:17', 510000, 'zxcxzc', NULL, 0),
(148, 179, '2020-06-11 15:26:09', 510000, 'xx', NULL, 0),
(149, 180, '2020-06-11 15:28:17', 510000, 'cvb', NULL, 0),
(150, 181, '2020-06-11 15:30:39', 510000, 'cvbcvb', NULL, 0),
(151, 182, '2020-06-11 15:32:10', 510000, 'zxc', NULL, 0),
(152, 183, '2020-06-11 15:43:43', 2000000, 'xcvxcv', NULL, 1),
(153, 184, '2020-06-12 01:06:06', 2000000, 'xcv', NULL, 0),
(154, 185, '2020-06-12 01:15:45', 10000000, '', NULL, 0),
(155, 186, '2020-06-12 01:21:04', 8530234, 'zxcxzc', NULL, 0),
(156, 187, '2020-06-12 01:29:07', 2000000, 'nvbn', NULL, 0),
(157, 188, '2020-06-16 02:47:49', 1866000, NULL, 26, 0),
(158, 189, '2020-06-16 02:51:03', 605000, NULL, 26, 0),
(159, 190, '2020-06-16 03:30:42', 1000000, 'á', NULL, 0),
(160, 191, '2020-06-18 07:08:18', 913000, 'truoc khi giao hang hay goi', NULL, 0),
(161, 192, '2020-06-18 11:40:51', 2040000, 'dqfwqs', NULL, 0),
(162, 193, '2020-06-18 11:47:01', 2000000, 'bvbvb', NULL, 0),
(163, 194, '2020-06-18 11:53:06', 8000000, 'xxxx', NULL, 0),
(164, 195, '2020-06-18 11:54:26', 800000, 'ccc', NULL, 0),
(165, 196, '2020-06-18 11:55:43', 1000000, 'xx', NULL, 0),
(166, 197, '2020-06-18 11:58:49', 12000000, 'czxczxc', NULL, 0),
(167, 198, '2020-06-18 12:00:30', 1200000, 'sdsd', NULL, 0),
(168, 199, '2020-06-18 12:04:34', 3570000, 'czxczxc', NULL, 0),
(169, 200, '2020-06-18 12:07:29', 1000000, 'xzxzx', NULL, 0),
(170, 201, '2020-06-18 12:08:18', 2040000, 'zxzx', NULL, 0),
(171, 202, '2020-06-18 12:11:05', 2758000, 'xzxz', NULL, 0),
(172, 203, '2020-06-18 12:12:53', 1636000, 'xcvxcvxc', NULL, 0),
(173, 204, '2020-06-18 12:14:16', 2086000, 'czxczc', NULL, 0),
(174, 205, '2020-06-30 00:41:26', 2550000, 'zxcxzxc', NULL, 1),
(175, 206, '2020-07-10 13:36:49', 9640000, 'xcvxcvxcv', NULL, 0),
(176, 207, '2020-07-11 03:54:57', 2000000, 'cxz', NULL, 0),
(177, 208, '2020-07-11 04:17:10', 2000000, 'Hihi', NULL, 0),
(178, 209, '2020-07-11 04:18:10', 4000000, 'xin nhe tay', NULL, 0),
(179, 210, '2020-07-11 04:19:17', 2820000, 'Hihi', NULL, 0),
(180, 211, '2020-07-11 08:38:46', 820000, 'cá', NULL, 0),
(181, 212, '2020-07-12 12:57:22', 4820000, 'dascxzc', 2, 0),
(182, 213, '2020-07-22 05:22:50', 8410000, 'giao nhanh len', 39, 0),
(183, 214, '2020-07-23 07:39:13', 2224000, '', 2, 0),
(184, 215, '2020-07-23 07:42:05', 4540000, 'hello giao nhanh len', 2, 0),
(185, 216, '2020-07-23 07:54:44', 2000000, '@', 2, 0),
(186, 217, '2020-07-23 07:58:11', 2000000, '', 2, 0),
(187, 218, '2020-07-23 14:16:54', 1030000, '', 41, 0),
(188, 219, '2020-07-24 02:01:49', 2820000, '', NULL, 0),
(189, 220, '2020-07-24 02:03:08', 10050000, '', NULL, 0),
(190, 221, '2020-07-26 05:48:37', 4410000, 'ghi chú , giao nhanh', 43, 0),
(233, 253, '2020-07-28 16:06:13', 2000000, 'Ghi chú', NULL, 0),
(234, 254, '2020-07-28 16:07:51', 4000000, '', 44, 0),
(235, 255, '2020-07-28 16:14:52', 2000000, 'Ghi chú', NULL, 0),
(236, 256, '2020-07-28 16:16:19', 4000000, '', 44, 0),
(237, 257, '2020-08-27 02:27:26', 2000000, '', 45, 0);

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `producer`
--

CREATE TABLE `producer` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `status` tinyint(2) DEFAULT 0,
  `description` varchar(1000) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `producer`
--

INSERT INTO `producer` (`id`, `email`, `phoneNumber`, `address`, `name`, `status`, `description`, `created_at`) VALUES
(1, 'trungnguyen@gmail.com', '0905624655', 'Hà Nội đã sửa', 'Trung Nguyên', 1, 'Tập đoàn Trung Nguyên là một doanh nghiệp hoạt động trong các lĩnh vực: sản xuất, chế biến, kinh doanh cà phê; nhượng quyền thương hiệu; dịch vụ phân phối, bán lẻ hiện đại và du lịch. Cà phê Trung Nguyên là một trong những thương hiệu nổi tiếng hàng đầu tại Việt Nam và đang có mặt tại hơn 60 quốc gia trên thế giới.', '2019-12-04 07:28:36'),
(2, 'coffeetree.vn@gmail.com', '0906702230', 'Số 25 Ngõ 35, P.Cát Linh, Q.Đống Đa,Hà Nội', 'Coffee Treee 1', 0, 'COFFEETREE LÀ 1 TRONG SỐ ÍT CÔNG TY SỞ HỮU HỆ THỐNG RANG XAY CHUYÊN NGHIỆP NHẬP KHẨU HÀ LAN – một trong những máy rang hiện đại nhất, cho phép kiểm soát chặt chẽ nhiệt độ, thời gian rang, chất lượng các mẻ rang hoàn toàn đồng nhất với nhau.\r\n\r\nTrong 5 năm qua, chúng tôi đã thực hiện sứ mệnh của mình bằng việc giúp đỡ và cung cấp hơn 500+ quán cà phê trên khắp cả nước Việt Nam và nhận những sự hài lòng, phản hồi tốt.', '2019-12-04 07:45:02'),
(3, 'sales@trieunguyencoffee.com', '0968770770', 'Công Ty TNHH Cà Phê Triều Nguyên  Số 120A Lý Thái Tổ, X. Dambri, TP. Bảo Lộc, Lâm Đồng', 'Công Ty TNHH Cà Phê Triều Nguyên', 1, 'Cà Phê Triều Nguyên - Đơn vị sản xuất và chế biến cà phê mang phong cách Á Đông tại vùng đất Lâm Đồng - Trung tâm đặc sản cà phê tại Việt Nam!\r\n➤ Cung cấp:\r\n♥♥ Đa dạng chủng loại: Cà phê Arabica, cà phê Robusta, cà phê Culi, cà phê chồn,..\r\n♥♥ Đa dạng hình thức: Cà phê hạt nhân, cà phê bột, cà phê rang xay.\r\n➤ Cà Phê Triều Nguyên: Hương thơm nhẹ dịu, thanh khiết, vị đắng tự nhiên của cà phê nguyên chất\r\n➤ Đặc biệt: Nhận rang xay cà phê với số lượng lớn.', '2019-12-14 13:06:38'),
(4, 'caphenguyenchat@bizz.com', '0984316292', 'Khu Đô Thị Số 1, P. Đông Ngàn, TX. Từ Sơn, Bắc Ninh', 'Coffee Double T - Nhà Sản Xuất Và Phân Phối Cà Phê Sạch', 1, 'cần tìm đại lý phân phối coffee Double T tại miền Bắc\r\nDouble T - Nhà sản xuất và cung cấp Cà Phê Sạch, Nguyên Chất 100%, Giá Cả Hợp Lý với các sản phẩm chính: Cà phê Arabica, cà phê Robusta Nature, Special, cà phê mít (Liberica - Excelsa), rang mộc pha máy, pha phin,.. đảm bảo:\r\n☑ Rang xay nguyên bản, KHÔNG chất bảo quản, KHÔNG chất phụ gia, KHÔNG hương liệu, giữ được hương vị tự nhiên nhất của cà phê\r\n☑ Hương thơm quyến rũ - Hương vị đậm đà thực thụ cho những người mạnh mẽ\r\n☑ Mẫu mã, thiết kế bao bì có tính thẩm mỹ cao, theo đúng tiêu chuẩn\r\n☑ Đáp ứng đầy đủ mọi nhu cầu của khách hàng về cà phê rang mộc sạch xay cho máy, bất kể số lượng, thời gian giao hàng', '2019-12-14 13:16:03'),
(6, 'vannguyen@avchemera.com', '0912144889', '31 Dân Tộc, P. Tân Thành, Q.Tân Phú, Tp. Hồ Chí Minh (TPHCM)', 'Cà Phê AVC HEMERA', 1, 'Chuyên Sản Xuất, Phân Phối Và Bán Buôn Cà Phê nguyên chất 100%,\r\nSản phẩm: Cà phê Arabica, cà phê Robusta, cà phê Culi, cà phê Chồn, cà phê Espresso, cà phê Moka, cà phê Hazelnut, cà phê Dalat-Gold,..\r\n▲ Phục vụ thị trường trong và ngoài nước như: Đức, Nhật Bản, Nga,..\r\n▲ Đạt giải thưởng Top 100 sản phẩm - dịch vụ tốt nhất vì người tiêu dùng năm 2017\r\n▲ Hương vị thơm ngon, tự nhiên, không chất hóa học, không chất phụ gia độc hại', '2019-12-15 01:48:00');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `producerId` bigint(20) NOT NULL,
  `productCateId` bigint(20) NOT NULL,
  `price` bigint(10) NOT NULL,
  `netWeight` int(11) NOT NULL,
  `roast` varchar(255) DEFAULT NULL,
  `image` varchar(255) NOT NULL,
  `shelfLife` varchar(255) NOT NULL,
  `particleSize` varchar(100) DEFAULT NULL,
  `taste` varchar(2000) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `ingredient` varchar(255) DEFAULT NULL,
  `sold` int(11) NOT NULL DEFAULT 0,
  `status` tinyint(3) NOT NULL,
  `promotion` bigint(10) NOT NULL DEFAULT 0,
  `imgOnline` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `producerId`, `productCateId`, `price`, `netWeight`, `roast`, `image`, `shelfLife`, `particleSize`, `taste`, `quantity`, `ingredient`, `sold`, `status`, `promotion`, `imgOnline`) VALUES
(2, 'Truyền Thống số 1', 2, 4, 213000, 1000, 'Rang nâu', '14jA_EFty_jhemera-moka-flavor32013.png', '6 tháng', 'Hạt sàn 20, tỉ lệ hạt nát 5%.', 'Coffee tree truyền thống số 1 có mùi hương thơm vừa, vị đắng đậm đà thơm ngọt và cafein vừa, chát, hậu vị ngọt.', 87, '100% Cà phê sạch Robusta, Arabica', 12, 1, 200000, 'https://firebasestorage.googleapis.com/v0/b/storagedoanandroid.appspot.com/o/uwen_Iuwo_269045252531.jpg?alt=media&token=dcd84423-1106-4867-a0c7-e6a86930194e'),
(3, 'Truyền Thống số 2', 2, 2, 245000, 1000, 'Rang nâu', '72dH_k895_ca-phe-coffee-tree-truyen-thong-so-3.png', '6 tháng', 'Hạt sàn 20, tỉ lệ hạt nát 5%.', 'Coffee tree truyền thống số 2 có mùi hương thơm nồng nàn quyến rủ, vị đắng vừa thơm ngọt và cafein vừa, chát, hậu vị ngọt.', 96, '100% Cà phê sạch Robusta, Arabica', 4, 1, 230000, 'https://firebasestorage.googleapis.com/v0/b/storagedoanandroid.appspot.com/o/uwen_Iuwo_269045252531.jpg?alt=media&token=dcd84423-1106-4867-a0c7-e6a86930194e'),
(4, 'Arabica Cầu Đất', 2, 2, 245000, 1000, 'Rang Nâu', 'y8wY_k895_ca-phe-coffee-tree-truyen-thong-so-3.png', '6 tháng', 'Sàn 18, hạt nát <3%', 'Cafe Sạch Arabica Nâu Medium có vị ngọt, chua thanh thoảng và mùi hương thơm nồng, mùi vị thơm ngọt kết hợp với vị đăng nhẹ, cafein thấp, hậu vị ngọt.', 93, '70% Cà phê sạch Arabica, 30% Cà phê sạch Robusta', 2, 1, 240000, 'https://firebasestorage.googleapis.com/v0/b/storagedoanandroid.appspot.com/o/geDc_coffeetree-truyen-thong-so-3.png?alt=media&token=3b62f03b-ada7-415c-adfa-9a0743d193b5'),
(5, 'Culi Buôn Mê Thuột', 2, 2, 180000, 1000, 'Rang Nâu', 'uwen_Iuwo_269045252531.jpg', '6 tháng', 'Hạt sàn 18, tỉ lệ hạt nát <3%', 'Cà phê Sạch Culi Special đặc biệt có vị đắng đậm mạnh, mùi hương nồng, cafein vừa, chát, hậu vị ngọt.', 86, '100% Cà phê Sạch Robusta, Arabica', 13, 1, 0, 'https://firebasestorage.googleapis.com/v0/b/storagedoanandroid.appspot.com/o/ZZYE_k895_ca-phe-coffee-tree-truyen-thong-so-3.png?alt=media&token=6fb87c9d-a13a-4649-906c-1197c79413d2'),
(6, 'Robusta', 2, 2, 168000, 1000, 'Rang Nâu', 'hkDU_GQ8q_culi-buon-me-thuot.png', '6 tháng', 'Hạt sàn 18, tỉ lệ hạt nát 5%.', 'Cà phê Sạch Robusta Nâu đặc biệt có vị đắng đậm vừa, mùi hương thơm nhẹ, cafein vừa, chát, hậu vị ngọt.', 1, '100% Café Sạch Robusta', 0, 1, 0, 'https://firebasestorage.googleapis.com/v0/b/storagedoanandroid.appspot.com/o/GQ8q_culi-buon-me-thuot.png?alt=media&token=728ac6b2-20c4-4e98-a326-61150bd8c31f'),
(7, 'Truyền Thống số 3', 2, 2, 234000, 1000, 'Rang Nâu', 'k895_ca-phe-coffee-tree-truyen-thong-so-3.png', '6 tháng', 'Sàn 18, hạt nát <3%', 'Coffee tree truyền thống số 3 có mùi hương thơm nồng nàn quyến rủ, vị đắng đậm đà thơm ngọt và cafein vừa, chát, hậu vị ngọt.', 280, '100% Cà phê sạch Robusta, Arabica', 17, 1, 0, 'https://firebasestorage.googleapis.com/v0/b/storagedoanandroid.appspot.com/o/Dw98_robusta-buon-ma-thuot.png?alt=media&token=7af6cb7d-104a-4aeb-8fe8-8c74ff60cf6a'),
(8, 'Arabica Cầu Đất 1', 2, 2, 168000, 1000, 'Rang Nâu', 'v8um_acoffeetree-truyen-thong-so1.png', '6 tháng', 'Sàn 18, hạt nát <3%', ' Với mùi thơm quyến rũ, nồng nàn, ngào ngạt, nhưng lại thanh nhẹ.', 16, '100 % arabica', 29, 1, 0, 'https://firebasestorage.googleapis.com/v0/b/storagedoanandroid.appspot.com/o/D7WK_Iuwo_269045252531.jpg?alt=media&token=32b3c8d5-d186-4d9c-9674-9bbe541f409c'),
(10, 'Arabica Đặc Biệt 1', 3, 2, 200000, 1000, NULL, 'f3SQ_jhemera-moka-flavor32013.png', '6 tháng', NULL, ' Mùi thơm nồng nàn, có vị hơi chua.', 0, '100 % arabica', 15, 1, 100000, 'https://firebasestorage.googleapis.com/v0/b/storagedoanandroid.appspot.com/o/7auZ_coffeetree-truyen-thong-so1.png?alt=media&token=bdbd9007-a4ec-4a18-a417-963899d05cb5'),
(14, 'CÀ PHÊ CHỒN', 6, 3, 350000, 250, NULL, 'Iuwo_269045252531.jpg', '6 tháng', NULL, 'Đắng gắt, nhưng hương thơm say đắm, đậm đà, nuớc màu đen sánh, không chua. Loại cafe này có hàm lượng cafein cao. Chúng là những hạt cà phê no tròn, đặc biệt là trong một trái chỉ có một hạt.', -1, 'cà phê chồn 100 %', 5, 1, 300000, 'https://firebasestorage.googleapis.com/v0/b/storagedoanandroid.appspot.com/o/5OoT_acoffeetree-truyen-thong-so1.png?alt=media&token=6afd57bd-cc4a-4929-870e-a719671909a4'),
(26, 'Cà phê A', 2, 3, 510000, 1001, 'cách rang sửa', 'fVPq_7auZ_coffeetree-truyen-thong-so1.png', '6 tháng sửa', 'Hạt sàn 20, tỉ lệ hạt nát 5%. sửa', 'Có vị đắng, hương thơm dịu, nước có màu nâu sánh, không có vị chua và hàm lượng cafein vừa đủ.', 92, 'thành phần thêm sửa', 9, 0, 410000, 'https://firebasestorage.googleapis.com/v0/b/storagedoanandroid.appspot.com/o/Dw98_robusta-buon-ma-thuot.png?alt=media&token=7af6cb7d-104a-4aeb-8fe8-8c74ff60cf6a'),
(27, 'abcxd', 1, 3, 2000000, 1000, 'roast', 'ZBKe_GQ8q_culi-buon-me-thuot.png', '6 tháng', 'Hạt sàn 20, tỉ lệ hạt nát 5%.', 'Arabica khi pha sẽ cho nước có màu nâu nhạt sánh, mùi vị đắng nhưng vô cùng đa dạng từ đắng dịu, thơm nhẹ nhàng quyến rũ đến đắng pha chút lẫn hương thơm nồng nàng, đặc biệt vị hơi chua nhưng rất lôi cuốn và thích hợp với khẩu vị của các qúy ông, quý bà.', 96, '100 cà phê sạch', 4, 1, 0, 'https://firebasestorage.googleapis.com/v0/b/bt-sict.appspot.com/o/images%2FEFty_jhemera-moka-flavor32013.png?alt=media&token=d7cec9ac-9f29-4b3b-95d8-11540693669a');

-- --------------------------------------------------------

--
-- Table structure for table `productcategory`
--

CREATE TABLE `productcategory` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `status` tinyint(2) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productcategory`
--

INSERT INTO `productcategory` (`id`, `name`, `description`, `status`) VALUES
(2, 'cà phê Robusta', 'Đặc điểm:Hạt cà phê Robusta hình bàn cầu tròn và thường là 2 hạt trong 1 trái. Trải qua quá trình chế biến trên dây chuyền thiết bị hiện đại với công nghệ cao tạo cho loại cà phê Robusta có mùi thơm dịu, vị đắng gắt, nước có màu nâu sánh, không chua, hàm lượng cafein vừa đủ đã tạo nên một loại cà phê đặc sắc phù hợp với khẩu vị của người dân Việt Nam.', 1),
(3, 'cà phê Culi', 'Đặc điểm: Hạt cà phê Culi là những hạt cà phê no tròn. Đặc biệt là trong một trái chỉ có duy nhất một hạt. Vị đắng gắt, hương thơm say đắm, hàm lượng cafein cao, nuớc màu đen sánh đó là những gì mà Culi  mang đến. Đó là quá trình kết hợp tinh túy của sự duy nhất.', 1),
(4, 'cà phê Cherry', 'Đặc điểm:Hạt cà phê Cherry mang một đặc điểm và hương vị rất khác lạ của một loài cây trưởng thành dưới nắng và gió của Cao Nguyên. Hạt cà phê vàng, sáng bóng rất đẹp. Khi pha tạo ra mùi thơm thoang thoảng, đặc biệt là vị chua của cherry tạo ra một cảm giác thật sảng khoái. Cherry rất thích hợp với sở thích của phái nữ với sự hòa quyện giữa mùi và vị tạo ra một cảm giác dân dã, cao sang quý phái hòa quyện nhau thât sâu sắc.', 0);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `roleName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `roleName`) VALUES
(1, 'ADMIN'),
(2, 'MANAGER'),
(3, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fullName` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phoneNumber` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `emailAddress` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roleId` int(11) NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `fullName`, `phoneNumber`, `address`, `emailAddress`, `roleId`, `email_verified_at`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(2, 'Admin', 'nguyen duc bao key', '0788049042', 'Hoa Phong, Hoa Vang, Da Nang', 'nguyenducbaokey@gmail.com', 1, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, NULL, '2020-01-10 07:51:17'),
(26, 'levana', 'Lê Văn A', '0888975555', 'Số 8D Đường 43, P, Khu Phố 7, Thủ Đức, Hồ Chí Minh.', 'levana@gmail.com', 3, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, '2019-12-31 08:22:01', '2019-12-31 08:22:01'),
(27, 'tranvanb', 'Trần Văn B', '0888975556', 'Số 8D Đường 47, P, Khu Phố 2, Cầu Ván,Hà Nội.', 'tranvanb@gmail.com', 3, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, '2019-12-31 08:23:47', '2019-12-31 08:23:47'),
(28, 'letungkhanh', 'Lê Tùng Khánh sửa', '0888975766', '79 Lê Văn Hiến, Cầu Giấy, Hà Nội', 'letungkhanh@gmail.com', 3, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, '2019-12-31 08:24:28', '2020-01-05 00:59:33'),
(29, 'Manager', 'Nguyễn Đức Khánh', '0888975700', 'Dương Lâm 1, Hòa Phong, Hòa Vang, Đà Nẵng', 'nguyenduckhanh@gmail.com', 2, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, '2019-12-31 08:26:24', '2019-12-31 19:02:44'),
(33, 'usernamedangky', 'Đăng ký', '0905635351', 'dangkydangky', 'dangky@gmail.com', 3, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, '2020-01-05 05:44:14', '2020-01-05 05:44:14'),
(35, 'nguyenvantest', 'Nguyễn Văn Test đã sửa', '0788049001', '38 Hà Lâm, Phú Hòa, Đà Nẵng sửa', 'nguyenvantest@gmail.com', 3, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, '2020-01-10 08:32:39', '2020-01-10 08:39:33'),
(39, 'letungkhanh2', 'Le Tung Khanh', '0788049042', '346 Dong Da, Da Nang', 'letungkhanh@gmail.com', 1, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, NULL, NULL),
(40, 'tungvannguyen', 'test change', 'test change', 'test change', 'test change', 1, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, NULL, NULL),
(41, 'zangdinh.36', 'Đinh Trà Giang', '0962064777', '390 Lê Duẩn', 'tragiangpro312@gmail.com', 1, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, NULL, NULL),
(43, 'nguyenvana', 'Nguyễn Đức Bảo edit', '0788049040', 'Hòa Phong, Hòa Vang Đà Nẵng edit', 'acccuabao001@gmail.com', 3, NULL, '$2y$10$WNcGdx7cwWQAXIvFKUd30Ofz2tfQxahajjbmEXfE3V31EitN4KnSi', NULL, NULL, NULL),
(44, 'baotuyloan1', 'baotuyloan1', 'baotuyloan1', 'baotuyloan1', 'baotuyloan1', 1, NULL, '$2y$10$ZXoyMWLmaHQ17ct8JoAg9OAZIeP39tMsgcUqybjdMUnbQFwP/YVfC', NULL, NULL, NULL),
(45, 'baotuyloan2', 'baotuyloan2', '2390123132', 'Hòa Phong, Hòa Vang, Da Nang', 'nguyenducbaokey@gmail.com', 3, NULL, '$2y$10$wBFXbtHLPrDG8cYDGB39WeM2okEkeuAhgqWbs7HG7BTADBHukptNi', NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idProduct` (`idProduct`),
  ADD KEY `idUser` (`idUser`);

--
-- Indexes for table `cusinfo`
--
ALTER TABLE `cusinfo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`),
  ADD KEY `productId` (`productId`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idProduct` (`idProduct`),
  ADD KEY `idOrder` (`idOrder`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cusId` (`cusId`),
  ADD KEY `accId` (`accId`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indexes for table `producer`
--
ALTER TABLE `producer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `productCateId` (`productCateId`),
  ADD KEY `producerId` (`producerId`);

--
-- Indexes for table `productcategory`
--
ALTER TABLE `productcategory`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `roleId` (`roleId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `cusinfo`
--
ALTER TABLE `cusinfo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=258;

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `orderdetail`
--
ALTER TABLE `orderdetail`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=317;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=238;

--
-- AUTO_INCREMENT for table `producer`
--
ALTER TABLE `producer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `productcategory`
--
ALTER TABLE `productcategory`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`idProduct`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `users` (`id`);

--
-- Constraints for table `cusinfo`
--
ALTER TABLE `cusinfo`
  ADD CONSTRAINT `cusinfo_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`);

--
-- Constraints for table `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `images_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`id`);

--
-- Constraints for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`idOrder`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`idProduct`) REFERENCES `product` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`cusId`) REFERENCES `cusinfo` (`id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`accId`) REFERENCES `users` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`productCateId`) REFERENCES `productcategory` (`id`),
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`producerId`) REFERENCES `producer` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
