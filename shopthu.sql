-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2022 at 12:37 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopthu`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(11) NOT NULL,
  `MaSP` varchar(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `danhmuc`
--

CREATE TABLE `danhmuc` (
  `maDM` varchar(11) NOT NULL,
  `tenDM` varchar(100) NOT NULL,
  `mota` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`maDM`, `tenDM`, `mota`) VALUES
('1', 'cho', 'danh muc cho'),
('2', 'meo', 'danh muc meo'),
('3', 'ca', 'danh muc ca'),
('4', 'chim', 'danh muc chim'),
('5', 'phu kien', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(11) NOT NULL,
  `MaKH` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgayLap` datetime NOT NULL,
  `SDT` varchar(20) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `PhuongThucTT` varchar(20) NOT NULL,
  `TongTien` float NOT NULL,
  `TrangThai` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `phanquyen`
--

CREATE TABLE `phanquyen` (
  `MaQuyen` int(11) NOT NULL,
  `TenPhanQuyen` varchar(20) NOT NULL,
  `ChiTietQuyen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE `theloai` (
  `MaTL` varchar(11) NOT NULL,
  `MaDM` varchar(11) NOT NULL,
  `TenTL` varchar(100) NOT NULL,
  `Mota` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`MaTL`, `MaDM`, `TenTL`, `Mota`) VALUES
('1', '1', 'san pham cho', NULL),
('10', '4', 'thu chim', NULL),
('11', '4', 'thuoc chim', NULL),
('12', '4', 'thuc an chim', NULL),
('13', '5', 'phu kien', NULL),
('2', '1', 'thuoc cho', NULL),
('3', '1', 'thuc an cho', NULL),
('4', '2', 'thu meo', NULL),
('5', '2', 'thuoc meo', NULL),
('6', '2', 'thuc an meo', NULL),
('7', '3', 'thu ca', NULL),
('8', '3', 'thuoc ca', NULL),
('9', '3', 'thuc an ca', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `thucungcho`
--

CREATE TABLE `thucungcho` (
  `Id` int(11) NOT NULL,
  `MaTL` varchar(11) CHARACTER SET utf8mb4 NOT NULL,
  `Ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Giong` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GoiTinh` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CanNang` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ChieuCao` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Tuoi` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MoTa` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `HinhAnh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `GiaTien` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thucungcho`
--

INSERT INTO `thucungcho` (`Id`, `MaTL`, `Ten`, `Giong`, `GoiTinh`, `CanNang`, `ChieuCao`, `Tuoi`, `MoTa`, `HinhAnh`, `GiaTien`) VALUES
(1, '1', 'chó husky', 'chó mỹ', 'đực', '10 kg', '80 cm', '1 tuổi', 'chó trắng vàng', 'http://www.elle.vn/wp-content/uploads/2017/07/25/hinh-anh-dep-1.jpg', '1500000'),
(2, '2', 'Thuốc nhỏ trị rận ở chó', NULL, NULL, NULL, NULL, NULL, 'Thuốc nhỏ trị rận cho chó Fronil Spot là thuốc nhỏ ngoài ra phòng và trị các loại ve, rận, bọ chét ở chó tốc độ nhanh, kéo dài.', 'https://meocun.com/wp-content/uploads/Thuo%CC%82%CC%81c-nho%CC%89-tri%CC%A3-ra%CC%A3%CC%82n-cho-cho%CC%81-Fronil-Spot-e1635328182211.jpg', '55000'),
(3, '3', 'Thức ăn cho các loài chó lớn', NULL, NULL, NULL, NULL, NULL, 'Trong thức ăn cho chó Smartheart có chứa hàm lượng Protein, hàm lượng chất đạm và chất xơ tương đối cân bằng.\r\nThành phần dinh dưỡng đầy đủ và cân bằng giúp cho cún cưng của gia đình bạn sẽ phát triển một cách toàn diện.', 'https://www.vietpet.net/wp-content/uploads/2019/01/thuc-an-cho-cho-con-ofresh.jpg', '168000'),
(4, '4', 'Mèo mỹ lông ngắn', 'Mèo mỹ', 'cái', '6', '30', '1', 'Mèo Mỹ lông ngắn có tên tiếng anh là American Shorthair, là một giống mèo quen thuộc với hầu hết những ai yêu mèo vì chúng vô cùng đáng yêu và được nuôi khá phổ biến ở Việt Nam.', 'https://duypets.com/wp-content/uploads/2019/11/meo-my-long-ngan-1.png', '2000000'),
(5, '5', 'Thuốc trị sán dây, sản lá ở mèo', NULL, NULL, NULL, NULL, NULL, 'Thuốc tẩy giun sanpet là loại thuốc chuyên dụng tẩy sạch giun cho chó mèo, 1 viên tẩy cho thể trọng 5kg giá 6k/viên, 1 vỉ thuốc gồm 10 viên', 'https://vinpet.com.vn/wp-content/uploads/2020/12/Thuoc-tay-giun-sanpet.jpg', '60000'),
(6, '6', 'Thức ăn dành cho mèo', NULL, NULL, NULL, NULL, NULL, 'Thức ăn khô, ăn nhanh dành cho mèo, đầy đủ chất dinh dưỡng, đang phổ biển nhất hiện nay.', 'http://img.websosanh.vn/v2/users/root_product/images/thuc-an-cho-meo-thuc-an-danh/e7l553wdf2fnb.jpg', '350000'),
(7, '7', 'Cá rồng đột biến da đỏ', 'Cá nước ngọt', NULL, NULL, NULL, NULL, 'Cá rồng là loài cá được ưa chuộng cả ở Việt Nam và trên Thế giới. Cá rồng huyết long bình thường đã quý hiếm, nhưng cũng có những loài bị dị tật bẩm sinh nên giá thành tương đối cao, thậm chí có thể lên đến hàng nghìn USD.', 'https://icdn.dantri.com.vn/thumb_w/640/2017/ca-canh-1-huyet-long-1491372321458.jpg', '100000000'),
(8, '8', 'Thuốc tetra Nhật Bản', NULL, NULL, NULL, NULL, NULL, 'Thuốc Tetra Nhật Bản: Như tên gọi của thuốc thì Tetra có nguồn gốc ở Nhật Bản và dùng điều trị các bệnh của nấm như thối mang, thối da, đỏ vây, sung huyết, sùi miệng hay cá bị nhiễm trùng do cọ xát.', 'https://storage.googleapis.com/cdn.nhanh.vn/store1/30346/artCT/87066/thuoc_tri_nam_tetra_nhat.jpg', '150000'),
(9, '9', 'Bột cám cá', NULL, NULL, NULL, NULL, NULL, 'Thức ăn cho cá, hay còn gọi là cám cá (dạng viên) có 2 cỡ dành cho cá nhỏ, viên cám kích thước ~1~2mm, Cỡ lớn dành cho cá to viên cám kích thước ~4mm. Thức ăn cho cá chứa đầy đủ thành phần dinh dưỡng cho cá phát triển tốt', 'https://media3.scdn.vn/img3/2019/12_23/ZrDUwu.jpg', '50000'),
(10, '10', 'Chào mào mũi đột biến bạch tạng', 'Chim Việt', 'cái', '2', '40', '1', 'Khác với chim Chào Mào thường nhật, và giá cả có thể nói tới bạc triệu trở lên, tùy vào địa phương, nhu cầu và thể chất của con chim.', 'https://vnn-imgs-f.vgcloud.vn/2020/06/14/08/chim-mau-1.jpg', '12000000'),
(11, '11', 'Thuốc trị đau chân dành cho chim cảnh', NULL, NULL, NULL, NULL, NULL, 'Tăng hàm lượng canxi, giúp chimm nhanh phục hồi vết thương như đau chân, xệ cánh.', 'https://cf.shopee.vn/file/c0b5014ff8545c9ef7399fac246dc288', '30000'),
(12, '12', 'Thức ăn nhanh dạng bột dành cho chim cảnh', NULL, NULL, NULL, NULL, NULL, 'Sử dụng thức ăn cho chim được chế biến sẵn sẽ giúp cho người nuôi đỡ vất vã hơn khi tìm kiếm thức ăn tự nhiên nhưng vẫn đảm bảo chất dinh dưỡng', 'https://caresspet.com/wp-content/uploads/2017/01/IMG_4376_zpsd5c46664-1280x720.jpg', '50000'),
(13, '13', 'Vòng cổ phản quang', NULL, NULL, NULL, NULL, NULL, '- Chất liệu: vải\r\n- Tính năng: bền, mềm mại và thân thiện với da của thú cưng.\r\n- Dành cho chó mèo nhỏ\r\n- Có 6 Màu: đỏ / xanh / hồng / xanh / vàng / đen\r\n- Khóa bằng nhựa thóa lắp dễ dàng\r\n', 'https://cf.shopee.vn/file/827905fc63e7f531bdcd2d197e16c179', '20000'),
(14, '13', 'Máy sục khí oxy 1 vòi 248', NULL, NULL, NULL, NULL, NULL, 'Công suất: 3w Lưu lượng khí: 3.5lít/phút Số lượng đầu vòi: 1 Chế độ điều chỉnh lưu lượng khí: có Nguồn điện: 220v-240v/50hz Mức độ gây ồn: trung bình Sản phẩm gồm: Máy sủi Cách sử dụng: Để quả sủi, miếng sủi, thanh sủi,...', 'https://vn-test-11.slatic.net/p/544994b17e602a77b1131a660e3cf2a5.png_800x800Q100.jpg', '48000');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
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
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `phone`, `dateofbirth`, `photo`, `address`, `addressSpecific`, `created_at`, `updated_at`) VALUES
(6, 'Thang', 'thang@gmail.com', '123456', '0123456789', '2000-03-02', 'Android/profile_image/6.jpeg', 'Mân Thái, Sơn Trà, Đà Nẵng', '14 Nam Thọ 4', NULL, NULL),
(7, 'minh', 'minh@gmail.com', '123456', '0987767344', '2022-01-10', 'Android/profile_image/6.jpeg', 'khu 3', 'aaaa', NULL, NULL),
(9, '', NULL, '0987654321', '0987654321', '0000-00-00', '', '', '', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD KEY `MaHD` (`MaHD`),
  ADD KEY `MaSP` (`MaSP`);

--
-- Indexes for table `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`maDM`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `MaKH` (`MaKH`);

--
-- Indexes for table `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`MaQuyen`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`MaTL`),
  ADD KEY `MaDM` (`MaDM`);

--
-- Indexes for table `thucungcho`
--
ALTER TABLE `thucungcho`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `MaTL` (`MaTL`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `thucungcho`
--
ALTER TABLE `thucungcho`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `theloai`
--
ALTER TABLE `theloai`
  ADD CONSTRAINT `theloai_ibfk_1` FOREIGN KEY (`MaDM`) REFERENCES `danhmuc` (`maDM`);

--
-- Constraints for table `thucungcho`
--
ALTER TABLE `thucungcho`
  ADD CONSTRAINT `thucungcho_ibfk_1` FOREIGN KEY (`MaTL`) REFERENCES `theloai` (`MaTL`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
