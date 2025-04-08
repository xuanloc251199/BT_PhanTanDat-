-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 14, 2025 lúc 03:01 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `example17`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `category_name` text NOT NULL,
  `category_description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `parent_id`, `category_name`, `category_description`) VALUES
(1, NULL, 'Phone', 'Mobile phone or Cell phone'),
(2, NULL, 'Laptop', 'Portable personal computer');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories_seq`
--

CREATE TABLE `categories_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `categories_seq`
--

INSERT INTO `categories_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `title`, `description`, `photo`, `price`) VALUES
(5, 'iPhone 14 Pro Max', 'Màn hình: OLED 6.7\"Super Retina XDR, Chip: Apple A16 Bionic, RAM:6 GB, Dung lượng: 128 GB\r\n', 'product01.png', 25999000),
(6, 'iPhone 15 Pro Max', 'Màn hình: OLED 6.7\" Super Retina XDR, Chip: Apple A16 Bionic, RAM: 6 GB, Dung lượng: 128 GB', 'product02.png ', 25999000),
(7, 'Samsung Galaxy S23 Ultra', 'Màn hình: Dynamic AMOLED 2X 6.8\", Chip: Snapdragon 8 Gen 2, RAM: 12 GB, Dung lượng: 256 GB', 'samsung_s23ultra.png', 30999000),
(8, 'Dell XPS 13', 'Màn hình: 13.4\", FHD+ InfinityEdge, Chip: Intel Core i7-1365U, RAM: 16 GB, Dung lượng: 512 GB SSD', 'dell_xps13.png', 28999000),
(9, 'ASUS ZenBook 14 OLED', 'Màn hình: OLED 14\", 2.8K, Chip: Intel Core i7-12700H, RAM: 16 GB, Dung lượng: 512 GB SSD', 'asus_zenbook14_oled.png', 23999000),
(10, 'Xiaomi Mi 11 Ultra', 'Màn hình: AMOLED 6.81\", 120Hz, Chip: Snapdragon 888, RAM: 12 GB, Dung lượng: 256 GB', 'xiaomi_mi11ultra.png', 17999000),
(11, 'HP Spectre x360 14', 'Màn hình: 13.5\", 3K2K OLED, Chip: Intel Core i7-1165G7, RAM: 16 GB, Dung lượng: 512 GB SSD', 'hp_spectrex360.png', 34999000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `parent_id` (`parent_id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_3js1i7yi3wj8eps0rqfytmcgm` (`photo`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `categories`
--
ALTER TABLE `categories`
  ADD CONSTRAINT `categories_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
