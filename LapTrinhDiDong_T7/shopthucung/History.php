<?php

require_once 'connection.php';

$MaKH=$_POST['MaKH'];
//  $MaKH='6';

$sql = "SELECT  CTHD.SoLuong ,SP.Ten, SP.HinhAnh , HD.NgayLap ,SP.GiaTien * CTHD.SoLuong AS GiaTong 
FROM hoadon AS HD , chitiethoadon AS CTHD, thucungcho AS SP WHERE CTHD.MaSP = SP.Id AND CTHD.MaHD = HD.MaHD AND HD.MaKH = '$MaKH'";

$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) {

    while ($row[] = mysqli_fetch_assoc($result)) {

        $item = $row;

        $json = json_encode($item);
    }
} else {
    echo "0 results";
}
echo $json;
