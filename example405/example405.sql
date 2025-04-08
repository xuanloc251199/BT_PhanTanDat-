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
-- Cơ sở dữ liệu: `example405`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_date` longblob DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `image_type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `product_available` bit(1) NOT NULL,
  `release_date` datetime(6) DEFAULT NULL,
  `stock_quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `brand`, `category`, `description`, `image_date`, `image_name`, `image_type`, `name`, `price`, `product_available`, `release_date`, `stock_quantity`) VALUES
(1, 'Tata Motors', 'Cars', 'A compact SUV with excellent safety features and performance.', NULL, NULL, NULL, 'Tata Nexon', 750000.00, b'1', '0000-00-00 00:00:00.000000', 50),
(2, 'Maruti Suzuki', 'Cars', 'A popular hatchback known for its fuel efficiency and reliability.', NULL, NULL, NULL, 'Maruti Suzuki Swift', 550000.00, b'1', '2024-02-01 00:00:00.000000', 100),
(3, 'Hyundai', 'Cars', 'A stylish SUV with advanced features and comfortable interior.', NULL, NULL, NULL, 'Hyundai Creta', 950000.00, b'1', '0000-00-00 00:00:00.000000', 75),
(4, 'Mahindra', 'Cars', 'A rugged off-road SUV with a powerful engine and modern amenities.', NULL, NULL, NULL, 'Mahindra Thar', 1200000.00, b'1', '2024-04-01 00:00:00.000000', 30),
(5, 'Honda', 'Cars', 'A premium sedan with a sleek design and advanced safety features', NULL, NULL, NULL, 'Honda City', 1100000.00, b'1', '2024-05-01 00:00:00.000000', 60);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
