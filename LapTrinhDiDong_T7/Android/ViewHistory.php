<?php

require_once 'connect.php';

$MaKH=$_POST['MaKH'];
// $MaKH='6';

$sql = "SELECT  CTHD.SoLuong ,SP.nameFood, SP.imgFood , HD.NgayBan ,SP.price * CTHD.SoLuong AS GiaTong FROM hoadon AS HD , chitietdonhang AS CTHD, food AS SP WHERE CTHD.MaSP = SP.id_food AND CTHD.MaHD = HD.MaHD AND HD.MaKH = '$MaKH'";

$result = mysqli_query($conn, $sql);


if (mysqli_num_rows($result) > 0) {
    while ($row[] = mysqli_fetch_assoc($result)) {
        $donhang = $row;
        $json = json_encode($donhang);
    }
} else {
    echo "0 results";
}

echo $json;
mysqli_close($conn);
