-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 15, 2022 at 04:35 AM
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
  `Tuoi` int(10) DEFAULT NULL,
  `soluong` int(11) NOT NULL,
  `MoTa` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `HinhAnh` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `GiaTien` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thucungcho`
--

INSERT INTO `thucungcho` (`Id`, `MaTL`, `Ten`, `Giong`, `GoiTinh`, `CanNang`, `ChieuCao`, `Tuoi`, `soluong`, `MoTa`, `HinhAnh`, `GiaTien`) VALUES
(1, '1', 'chó husky', 'chó mỹ', 'đực', '10 kg', '80 cm', 1, 50, 'chó trắng vàng', 'https://duypets.com/wp-content/uploads/2019/11/meo-my-long-ngan-1.png', 1500000),
(2, '2', 'Thuốc nhỏ trị rận ở chó', '1', '1', '1', '1', 1, 50, 'Thuốc nhỏ trị rận cho chó Fronil Spot là thuốc nhỏ ngoài ra phòng và trị các loại ve, rận, bọ chét ở chó tốc độ nhanh, kéo dài.', 'https://duypets.com/wp-content/uploads/2019/11/meo-my-long-ngan-1.png', 55000),
(3, '3', 'Thức ăn cho các loài chó lớn', '1', '1', '1', '1', 1, 50, 'Trong thức ăn cho chó Smartheart có chứa hàm lượng Protein, hàm lượng chất đạm và chất xơ tương đối cân bằng.\r\nThành phần dinh dưỡng đầy đủ và cân bằng giúp cho cún cưng của gia đình bạn sẽ phát triển một cách toàn diện.', 'https://duypets.com/wp-content/uploads/2019/11/meo-my-long-ngan-1.png', 168000),
(4, '4', 'Mèo mỹ lông ngắn', 'Mèo mỹ', 'cái', '3kg', '30cm', 1, 50, 'Mèo Mỹ lông ngắn có tên tiếng anh là American Shorthair, là một giống mèo quen thuộc với hầu hết những ai yêu mèo vì chúng vô cùng đáng yêu và được nuôi khá phổ biến ở Việt Nam.', 'https://duypets.com/wp-content/uploads/2019/11/meo-my-long-ngan-1.png', 2000000),
(5, '5', 'Thuốc trị sán dây, sản lá ở mèo', '1', '1', '1', '1', 1, 50, 'Thuốc tẩy giun sanpet là loại thuốc chuyên dụng tẩy sạch giun cho chó mèo, 1 viên tẩy cho thể trọng 5kg giá 6k/viên, 1 vỉ thuốc gồm 10 viên', 'https://duypets.com/wp-content/uploads/2019/11/meo-my-long-ngan-1.png', 60000),
(6, '6', 'Thức ăn dành cho mèo', '1', '1', '1', '1', 1, 50, 'Thức ăn khô, ăn nhanh dành cho mèo, đầy đủ chất dinh dưỡng, đang phổ biển nhất hiện nay.', 'http://img.websosanh.vn/v2/users/root_product/images/thuc-an-cho-meo-thuc-an-danh/e7l553wdf2fnb.jpg', 350000),
(7, '7', 'Cá rồng đột biến da đỏ', 'Cá nước ngọt', '1', '1 kg', '50 mm', 1, 50, 'Cá rồng là loài cá được ưa chuộng cả ở Việt Nam và trên Thế giới. Cá rồng huyết long bình thường đã quý hiếm, nhưng cũng có những loài bị dị tật bẩm sinh nên giá thành tương đối cao, thậm chí có thể lên đến hàng nghìn USD.', 'https://icdn.dantri.com.vn/thumb_w/640/2017/ca-canh-1-huyet-long-1491372321458.jpg', 100000000),
(8, '8', 'Thuốc tetra Nhật Bản', '1', '1', '1', '1', 1, 50, 'Thuốc Tetra Nhật Bản: Như tên gọi của thuốc thì Tetra có nguồn gốc ở Nhật Bản và dùng điều trị các bệnh của nấm như thối mang, thối da, đỏ vây, sung huyết, sùi miệng hay cá bị nhiễm trùng do cọ xát.', 'https://storage.googleapis.com/cdn.nhanh.vn/store1/30346/artCT/87066/thuoc_tri_nam_tetra_nhat.jpg', 150000),
(9, '9', 'Bột cám cá', '1', '1', '1', '1', 1, 50, 'Thức ăn cho cá, hay còn gọi là cám cá (dạng viên) có 2 cỡ dành cho cá nhỏ, viên cám kích thước ~1~2mm, Cỡ lớn dành cho cá to viên cám kích thước ~4mm. Thức ăn cho cá chứa đầy đủ thành phần dinh dưỡng cho cá phát triển tốt', 'https://media3.scdn.vn/img3/2019/12_23/ZrDUwu.jpg', 50000),
(10, '10', 'Chào mào mũi đột biến bạch tạng', 'Chim Việt', 'cái', '2', '40', 1, 50, 'Khác với chim Chào Mào thường nhật, và giá cả có thể nói tới bạc triệu trở lên, tùy vào địa phương, nhu cầu và thể chất của con chim.', 'https://vnn-imgs-f.vgcloud.vn/2020/06/14/08/chim-mau-1.jpg', 12000000),
(11, '11', 'Thuốc trị đau chân dành cho chim cảnh', '1', '1', '1', '1', 1, 50, 'Tăng hàm lượng canxi, giúp chimm nhanh phục hồi vết thương như đau chân, xệ cánh.', 'https://cf.shopee.vn/file/c0b5014ff8545c9ef7399fac246dc288', 30000),
(12, '12', 'Thức ăn nhanh dạng bột dành cho chim cảnh', '1', '1', '1', '1', 1, 50, 'Sử dụng thức ăn cho chim được chế biến sẵn sẽ giúp cho người nuôi đỡ vất vã hơn khi tìm kiếm thức ăn tự nhiên nhưng vẫn đảm bảo chất dinh dưỡng', 'https://caresspet.com/wp-content/uploads/2017/01/IMG_4376_zpsd5c46664-1280x720.jpg', 50000),
(13, '13', 'Vòng cổ phản quang', '1', '1', '1', '1', 1, 50, '- Chất liệu: vải\r\n- Tính năng: bền, mềm mại và thân thiện với da của thú cưng.\r\n- Dành cho chó mèo nhỏ\r\n- Có 6 Màu: đỏ / xanh / hồng / xanh / vàng / đen\r\n- Khóa bằng nhựa thóa lắp dễ dàng\r\n', 'https://cf.shopee.vn/file/827905fc63e7f531bdcd2d197e16c179', 20000),
(14, '13', 'Máy sục khí oxy 1 vòi 248', '1', '1', '1', '1', 1, 50, 'Công suất: 3w Lưu lượng khí: 3.5lít/phút Số lượng đầu vòi: 1 Chế độ điều chỉnh lưu lượng khí: có Nguồn điện: 220v-240v/50hz Mức độ gây ồn: trung bình Sản phẩm gồm: Máy sủi Cách sử dụng: Để quả sủi, miếng sủi, thanh sủi,...', 'https://vn-test-11.slatic.net/p/544994b17e602a77b1131a660e3cf2a5.png_800x800Q100.jpg', 48000),
(15, '1', 'Chó cỏ', 'Chó úc', 'Đực', '3kg', '20cm', 4, 4, 'Chó nhà rất hiền', 'https://dean2020.edu.vn/wp-content/uploads/2020/03/anh-cho-con.jpg', 4000000),
(16, '1', 'Chó phốc', 'Chó Mỹ', 'Đực', '2kg', '30cm', 1, 2, 'Chó Phốc thuần Mỹ', 'https://www.thukieng.com/wp-content/uploads/2017/11/pomeranian-boo-1.jpg', 2000000),
(17, '1', 'Shi Ba nhật', 'Nhật', 'Đực', '1kg', '15cm', 0, 12, 'Chó Shiba Nhật mới đẻ 2 tuần', 'https://img4.thuthuatphanmem.vn/uploads/2020/03/08/hinh-anh-nhung-con-cho-de-thuong_092948873.jpg', 300000),
(18, '1', 'Husky ngáo', 'Mỹ', 'Cái', '8kg', '60cm', 2, 1, 'Chó husky siêu ngáo phá nhà như điên', 'https://sieupet.com/sites/default/files/pictures/images/1-1473150685951-5.jpg', 5000000),
(19, '1', 'Corgi nhật mới 2021', 'Nhật', 'Cái', '7kg', '50cm', 2, 2, 'Chó Corgi 2 tuổi cực xinh', 'https://dogily.vn/wp-content/uploads/2019/09/Hinh-anh-ve-cac-chu-cho-dang-yeu-Corgi.jpg', 7000000),
(20, '1', 'piltpull', 'Alasca', 'Đực', '20kg', '70cm', 2, 2, 'PitPull siêu ngầu', 'https://i.pinimg.com/originals/8f/69/b7/8f69b7fa03316077e54652db4622c1ff.jpg', 2000000),
(21, '1', 'Pit pull ông hoàng', 'Mỹ', 'đực', '25kg', '75cm', 2, 3, 'pitpull Mỹ', 'http://i.imgur.com/7Ru3HBT.jpg', 2000000),
(22, '4', 'Mèo xiêm', 'Châu Âu', 'Cái', '1kg', '10cm', 1, 50, 'Mèo xiêm có bộ lông khá ngắn và mượt, chúng cũng có nhiều màu đẹp. Đặc điểm nổi bật nhất trên cơ thể là phần lông ở mặt, đuôi, tai, bàn chân có màu đậm hơn những vị trí khác', 'https://petmaster.vn/petroom/wp-content/uploads/2020/04/meo-canh-2.jpg', 1000000),
(23, '4', 'Mèo Anh lông dài', 'Mèo Anh', 'đực', '1 kg', '10 cm', 1, 50, 'Mèo Anh lông dài được đánh giá là loài mèo cảnh đẹp, có ngoại hình vô cùng xinh xắn, dễ thương với bộ lông dài mềm mại.', 'https://petmaster.vn/petroom/wp-content/uploads/2020/04/meo-canh-4.jpg', 2000000),
(24, '4', 'Mèo Anh lông ngắn', 'Mèo Anh', 'cái', '2 kg ', '12 cm', 1, 50, 'Nhìn bộ lông của chúng tuy ngắn nhưng rất dày, có thể giữ cho cơ thể có nhiệt độ ổn định. Các màu lông phổ biến của chúng là xám, tabby, trắng, silver, golden,…', 'https://petmaster.vn/petroom/wp-content/uploads/2020/04/meo-canh-5.jpg', 7000000),
(25, '4', 'Mèo Ba Tư', 'Mèo Châu Âu', 'cái', '1 kg', '14 cm', 1, 50, 'Ngoại hình sang chảnh nên được giới quý tộc châu Âu hết mực yêu quý, chiều chuộng.', 'https://petmaster.vn/petroom/wp-content/uploads/2020/04/meo-canh-6.jpg', 8000000),
(26, '4', 'Mèo Chinchilla', 'Mèo Ba Tư', 'Đực', '2 kg', '14 cm', 1, 50, 'Mèo Chinchilla là sự lai tạo giữa mèo Ba Tư và giống mèo bản địa của Nam Phi. Vì thế chúng sở hữu bộ lông xinh xắn của mèo Ba Tư và có đôi mắt màu xanh ngọc lục bảo hoang dã của mèo Nam Phi trông vô cùng cuốn hút.', 'https://petmaster.vn/petroom/wp-content/uploads/2020/04/meo-canh-7.jpg', 8000000),
(27, '4', 'Mèo tai cụp Scottish Fold', 'Scotland', 'Đực', '1 kg', '13 cm', 1, 20, 'Mèo Scottish Fold đã khuấy đảo cộng đồng yêu mèo nhờ vào đôi tai cụp và ngoại hình dễ thương của mình.', 'https://petmaster.vn/petroom/wp-content/uploads/2020/04/meo-canh-8.jpg', 12000000),
(28, '4', 'Mèo chân ngắn Munchkin', 'Mỹ', 'Đực', '1 kg', '14 cm', 1, 20, 'Giống mèo lùn khá thân thiện với con người và sống cực kỳ tình cảm. Chúng thích chơi trò đuổi bắt đèn laze, cần câu mèo. Và nếu không có người chơi cùng, mèo Munchkin dành thời gian để ngủ nhiều hơn.', 'https://petmaster.vn/petroom/wp-content/uploads/2020/04/meo-canh-9.jpg', 15000000),
(29, '7', 'Cá ba đuôi nước ngọt dễ nuôi', 'Cá nước ngọt', '1', '400 gram', '50 mm', 1, 100, 'Là loài cá cảnh đẹp thuộc họ cá Chép. Loại cá này dễ thích nghi với điều kiện sống trong bể nuôi từ kích cỡ nhỏ đến to, hòn non bộ, bể cạn, bể kính…Điểm đặc biệt của cá 3 đuôi là loại cá cảnh nước ngọt dễ nuôi.', 'http://xenangphuy.com/upload/images/ca-ba-duoi-lam-canh-dep.jpg', 20000),
(30, '7', 'Cá chép Nhật (cá Koi)', 'Cá nước ngọt', '1', '1 kg', '5 cm', 1, 50, 'Cá Koi là loài cá chép lai tạo, có quan hệ họ hàng gần với cá vàng và được nuôi để làm cảnh. Cá Koi được cho là loại cá kiểng đẹp dễ nuôi mang lại may mắn, thể hiện triển vọng tương lai và cơ hội về tài chính..', 'http://xenangphuy.com/upload/images/ca-koi-ca-canh-dep.jpg', 350000),
(31, '7', 'Cá hồng két', 'Cá nước ngọt', '1', '500 gram', '4 cm', 1, 30, 'Cá hồng két hay còn gọi là cá Két đỏ, cá huyết anh vũ, còn được biết đến với tên gọi tiếng Anh là blood parrot cichlid, parrot cichlid, bloody parrot là một loài cá cảnh đẹp được hình thành do kết quả lai tạo trong họ Cichlid', 'http://xenangphuy.com/upload/images/ca-hong-ket-ca-canh-dep.jpg', 50000),
(32, '7', 'Cá đá', 'Cá nước ngọt', '1', '200 gram', '1 cm', 1, 60, 'Cá đá là loài cá cảnh đẹp, vốn là loài Betta thuần dưỡng lâu đời ở Thái Lan rồi sau đó lan ra khắp thế giới.', 'http://xenangphuy.com/upload/images/ca-da-canh-de-nuoi.jpg', 70000),
(33, '7', 'Cá thanh ngọc', 'Cá nước ngọt', '1', '300 gram', '3 cm', 1, 40, 'Cá thanh ngọc làm cá kiểng đẹp nhờ có chấm dài khoảng 4 – 7 cm. Gai vây hậu môn: 6-8. Có 24-28 tia mềm vây hậu môn phân nhánh, 13 hàng vảy nằm ngang, và từ 2 trở lên các sọc sẫm màu nằm dọc theo thân', 'http://xenangphuy.com/upload/images/ca-thanh-ngoc-dep-de-nuoi.jpg', 10000),
(34, '7', 'Cá lau kiếng', 'Cá nước ngọ', '1', '100 gram', '2 cm', 1, 20, 'cá nuôi kiểng không cần oxy được nhiều người chơi cá cảnh chọn nuôi, chúng sẽ làm vệ sinh cho bể cá cảnh một cách tự nhiên giúp tránh các bệnh thường gặp ở cá cảnh', 'http://xenangphuy.com/upload/images/ca-canh-lau-kieng-de-nuoi.jpg', 15000),
(35, '7', 'Cá tai tượng', 'Cá nước ngọt', '1', '400 gram', '4 cm', 1, 35, 'Cá Tài Phát hay Phát Tài (Tai tượng) là cá kiểng đẹp có kích thước lớn, thường được nuôi không cần oxy chung với cá rồng, cá phát tài trống có đầu gù to lớn rất đẹp.', 'http://xenangphuy.com/upload/images/ca-canh-tai-tuong-de-nuoi.jpg', 120000),
(36, '7', 'Cá thòi lòi', 'Cá nước ngọt', '1', '250 gram', '2 cm', 1, 35, 'Là loại cá cảnh đẹp độc lạ. Nhiều người tưởng rằng chúng là một loài lưỡng cư vì chúng có đôi mắt lồi như mắt ếch và có thể di chuyển dễ dàng trên cạn bằng hai chi trước. ', 'http://xenangphuy.com/upload/images/ca-thoi-loi-dep.jpg', 25000),
(37, '7', 'Cá bảy màu', 'Cá nước ngọt', '1', '100 gram', '1 cm', 1, 25, 'Cá bảy màu là cái tên được người Việt mình gọi dân dã, là loài cá cảnh đẹp, dễ nuôi, không cần oxy. Một phần xuất phát từ màu sắc sặc sỡ bên ngoài.', 'http://xenangphuy.com/upload/images/ca-bay-mau-len-mau-lam-canh-dep.jpg', 8000),
(38, '7', 'Cá thiên đường', 'Cá nước ngọt', '1', '200 gram', '3 cm', 1, 30, 'Cá thiên đường (đuôi cờ, lia thia ruộng) còn gọi là cá lia thia đồng, cá đuôi cờ có nhiều màu sắc đa dạng cùng với vây kỳ căng tròn, tạo nên vẻ đẹp cổ điển trong mọi thời đại.', 'http://xenangphuy.com/upload/images/ca-thien-duong-ca-lam-canh-de-nuoi.jpg', 5000),
(39, '10', 'Chim Sáo', 'Chim Việt', 'Đực', '300 gram', '10 cm', 1, 20, 'Chim Sáo là một trong những loài chim cảnh dễ nuôi nhất của Việt Nam vì đây là một loài chim mang đặc tính thông minh và có thể bắt chước tiếng người.', 'https://cdn.tgdd.vn/Files/2021/04/12/1342859/cac-giong-chim-canh-pho-bien-thuong-duoc-nuoi-tai-viet-nam-202104121950418589.jpg', 400000),
(40, '10', 'Chích Chòe', 'Chim Việt', 'Đực', '200 gram', '7 cm', 1, 25, 'Có một dáng vẻ nhỏ nhắn siêu dễ thương, và cách nuôi chim này cũng khá là dễ dàng', 'https://cdn.tgdd.vn/Files/2021/04/12/1342859/cac-giong-chim-canh-pho-bien-thuong-duoc-nuoi-tai-viet-nam-202104121950542502.jpg', 450000),
(41, '10', 'Chim họa mi', 'Chim Việt', 'Đực', '250 ', '5 cm', 1, 15, 'Loài chim cảnh Việt Nam này khá nhỏ bé, chỉ ngang hoặc bé hơn chim Sơn Ca nhưng bù lại chúng có giọng hót rất hay, trong trẻo.', 'https://cdn.tgdd.vn/Files/2021/04/12/1342859/cac-giong-chim-canh-pho-bien-thuong-duoc-nuoi-tai-viet-nam-202104121951056506.jpg', 150000),
(42, '10', 'Chim Vẹt', 'Chim Việt', 'Cái', '200 ', '5 cm', 1, 10, 'màu sắc bắt mắt, đáng yêu và đặc biệt là khả năng bắt chước tiếng người.', 'https://cdn.tgdd.vn/Files/2021/04/12/1342859/cac-giong-chim-canh-pho-bien-thuong-duoc-nuoi-tai-viet-nam-202104121951172147.jpg', 500000),
(43, '10', 'Chim Khuyên', 'Chim Việt', 'Cái', '250 gram', '6 cm', 1, 20, 'Thân hình của chim Khuyên nhỏ nhắn, đầu chim khá to so với phần thân, trán rộng và cao, mắt hơi xếch nhẹ, mắt có vòng khuyên trắng, có bộ lông màu vàng lục.', 'https://cdn.tgdd.vn/Files/2021/04/12/1342859/cac-giong-chim-canh-pho-bien-thuong-duoc-nuoi-tai-viet-nam-202104121951310007.jpg', 300000),
(44, '10', 'Chim Yến Phụng', 'Chim Việt', 'Đực', '250 gram', '7 cm', 1, 15, 'Chim yến phụng có dáng khoằm, sắc nhọn, mắt tròn, to có một bộ lông hội tụ rất nhiều màu sắc.', 'https://cdn.tgdd.vn/Files/2021/04/12/1342859/cac-giong-chim-canh-pho-bien-thuong-duoc-nuoi-tai-viet-nam-202104121951424406.jpg', 250000),
(45, '10', 'Chim Vàng Anh', 'Chim Việt', 'Cái', '200 gram', '8 cm', 1, 10, 'Chim Vàng Anh có giọng hót khá giống với tiếng chim giẻ cùi nhưng vô cùng thánh thót.', 'https://cdn.tgdd.vn/Files/2021/04/12/1342859/cac-giong-chim-canh-pho-bien-thuong-duoc-nuoi-tai-viet-nam-202104121952116096.jpg', 350000),
(46, '10', 'Chim Cu Gáy', 'Chim Việt', 'Cái', '280 gram', '9  cm', 1, 15, 'Chim Cu Gáy có tiếng hót được ví với tiếng sáo trúc, nghe rất thánh thót.', 'https://cdn.tgdd.vn/Files/2021/04/12/1342859/cac-giong-chim-canh-pho-bien-thuong-duoc-nuoi-tai-viet-nam-202104121953177551.jpg', 700000),
(47, '10', 'Chim Khướu', 'Chim Việt', 'Cái', '350 gram', '10 cm', 1, 10, 'Bộ lông mềm và xốp như bông, phần mào nhô lên khá rõ, trong khi đó phần mắt và mào lại có màu đen nối liền với nhau nhìn khá huyền bí.', 'https://cdn.tgdd.vn/Files/2021/04/12/1342859/cac-giong-chim-canh-pho-bien-thuong-duoc-nuoi-tai-viet-nam-202104121953340301.jpg', 650000),
(48, '10', 'Chim Chìa Vôi', 'Chim ngoại', 'Cái', '320 gram', '11 cm', 1, 20, 'Loài chim cảnh này không quá rực rỡ nhưng lại sở hữu vẻ đẹp giản dị, dễ chịu. Lông chim có màu xám bút chì, phần đầu và đuôi có màu đen đậm nhưng ở giữa bụng, ngực lại có màu trắng.', 'https://cdn.tgdd.vn/Files/2021/04/12/1342859/cac-giong-chim-canh-pho-bien-thuong-duoc-nuoi-tai-viet-nam-202104121953521704.jpg', 800000);

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
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
