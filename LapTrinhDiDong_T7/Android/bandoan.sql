-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 06, 2022 lúc 03:28 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bandoan`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `food`
--

CREATE TABLE `food` (
  `id_food` bigint(20) UNSIGNED NOT NULL,
  `nameFood` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `imgFood` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `calories` int(11) NOT NULL,
  `star` double NOT NULL,
  `price` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `ingredient` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `food`
--

INSERT INTO `food` (`id_food`, `nameFood`, `imgFood`, `calories`, `star`, `price`, `total`, `ingredient`, `description`, `quantity`, `created_at`, `updated_at`) VALUES
(1, 'Bánh kẹp nướng Mexico', 'Android/hinh_anh/banhkepnuong.jpeg', 135, 4.9, 110000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Phô mai, sốt cà chua, nhân gà nướng bơ tỏi, ớt sừng dùng kèm sốt cocktail', '1', NULL, NULL),
(2, 'Bánh mì bơ tỏi', 'Android/hinh_anh/banhmibotoi.jpeg', 135, 4.8, 49000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Một lớp bơ tỏi thơm ngon trên các lát bánh mì nướng', '1', NULL, NULL),
(3, 'Bánh mì que nướng', 'Android/hinh_anh/banhmiquenuong.jpeg', 135, 4.7, 95000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Làm từ đế bột của Pizza và dùng kèm sốt Cocktail', '1', NULL, NULL),
(4, 'Cánh gà nướng', 'Android/hinh_anh/canhganuong.jpeg', 135, 4.6, 95000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Cánh gà nướng thấm vị với lớp da mỏng giòn', '1', NULL, NULL),
(5, 'Cánh gà tẩm bột chiên giòn', 'Android/hinh_anh/canhgatambotchien.png', 135, 4.6, 95000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Phủ bởi lớp bột đặc biệt tạo nên lớp vỏ giòn dai hấp dẫn', '1', NULL, NULL),
(6, 'Đùi gà tẩm bột chiên giòn', 'Android/hinh_anh/duigatambotchien.png', 135, 4.9, 279000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Đùi Gà phủ một lớp bột chiên giòn rụm', '1', NULL, NULL),
(7, 'Gà giòn không xương', 'Android/hinh_anh/gagionkhongxuong.jpeg', 255, 4.7, 99000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Gà giòn tan với sốt Cocktail thơm ngậy', '1', NULL, NULL),
(9, 'Mì hải sản', 'Android/hinh_anh/mihaisai.png', 135, 4.6, 129000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Mỳ Ý rán với các loại hải sản tươi ngon cùng ớt và tỏi', '1', NULL, NULL),
(10, 'Mì Ý thịt bò bằm', 'Android/hinh_anh/miythitbo.png', 135, 4.6, 129000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Sốt thịt bò bằm đặc trưng kết hợp cùng mỳ Ý', '1', NULL, NULL),
(14, 'Mì Ý tôm sốt kem cà chua', 'Android/hinh_anh/miytomsot.png', 135, 4.6, 129000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Sự tươi ngon của tôm kết hợp với sốt kem cà chua', '1', NULL, NULL),
(15, 'Mực chiên giòn', 'Android/hinh_anh/mucchiengion.jpeg', 135, 4.8, 99000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Mực tẩm bột chiên giòn dùng kèm sốt ngò tây', '1', NULL, NULL),
(16, 'Nui bỏ là Gà BBQ sốt hương nhu', 'Android/hinh_anh/nuiboloGa.png', 135, 4.6, 59000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Sự kết hợp hoàn hảo giữa thịt gà BBQ và sốt hương nhu cùng nhiều nguyên liệu tạo mùi thơm hấp dẫn như rau quế, ớt, hành tây, tỏi…', '1', NULL, NULL),
(17, 'Nui bỏ lò Hải sản sốt hương nhu', 'Android/hinh_anh/nuiboloHaisan.png', 135, 4.6, 59000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Đánh thức vị giác với sốt hương nhu độc đáo, kết hợp cùng hải sản tươi ngon đậm đà', '1', NULL, NULL),
(18, 'Pizza Aloha', 'Android/hinh_anh/pizzaAloha.png', 135, 4.6, 119000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Thịt nguội, xúc xích tiêu cay và dứa hòa quyện với sốt Thousand Island', '', NULL, NULL),
(19, 'Pizza hải sản Cocktail', 'Android/hinh_anh/pizzahaisanCocktail.png', 135, 4.6, 129000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Tôm, cua, giăm bông,... với sốt Thousand Island', '1', NULL, NULL),
(20, 'Pizza hải sản Pesto xanh', 'Android/hinh_anh/pizzahaisanPesto.png', 255, 4.7, 169000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Tôm, cua, mực và bông cải xanh tươi ngon trên nền sốt Pesto Xanh', '1', NULL, NULL),
(21, 'Pizza hải sản cao cấp', 'Android/hinh_anh/pizzahaisancaocap.png', 135, 4.5, 129000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Tôm, cua, mực và nghêu với sốt Marinara', '1', NULL, NULL),
(22, 'Pizza thịt xông khói', 'Android/hinh_anh/pizzathitxongkhoi.png', 135, 4.4, 119000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Thịt giăm bông, thịt xông khói và hai loại rau của ớt xanh, cà chua', '1', NULL, NULL),
(23, 'Salad Da cá hồi giòn', 'Android/hinh_anh/saladDacahoi.png', 135, 4.6, 69000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Salad với da cá hồi giòn với bắp cải đỏ, cà chua bi, ngô với sốt Yuzu', '1', NULL, NULL),
(24, 'Salad Gà giòn không xương', 'Android/hinh_anh/saladGagion.png', 255, 4.7, 69000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Salad Gà giòn với trứng cút, thịt xông khói, phô mai parmesan và sốt Thousand Island', '1', NULL, NULL),
(25, 'Salad trộn sốt Caesar', 'Android/hinh_anh/saladtronsotCaesar.png', 135, 4.5, 69000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Rau tươi trộn với sốt Caesar', '1', NULL, NULL),
(26, 'Sườn siêu sao', 'Android/hinh_anh/suonsieusao.png', 135, 4.4, 319000, 0, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a', 'Combo Sườn nướng BBQ dùng với khoai tây chiên và Salad', '1', NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `dateofbirth` date NOT NULL,
  `photo` text COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `addressSpecific` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `phone`, `dateofbirth`, `photo`, `address`, `addressSpecific`, `created_at`, `updated_at`) VALUES
(6, 'Thang', 'thang@gmail.com', '123456', '0123456789', '2000-03-02', 'Android/profile_image/6.jpeg', 'Mân Thái, Sơn Trà, Đà Nẵng', '14 Nam Thọ 4', NULL, NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id_food`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `food`
--
ALTER TABLE `food`
  MODIFY `id_food` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
