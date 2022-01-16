<?php
require_once 'connect.php';

$MaKH=$_POST['MaKH'];
$DonGia=$_POST['DonGia'];
$ChiTietDonHang=$_POST['ChiTietDonHang'];


$queryDonHang = 'INSERT INTO `hoadon` (`MaKH`, `DonGia`,`NgayBan`) VALUE ('.$MaKH.','.$DonGia.',Default)';
$resultDonHang = mysqli_query($conn, $queryDonHang);

if ($resultDonHang == true) {
    $queryDonHang = ' SELECT MaHD  FROM `hoadon` WHERE `MaKH` = '.$MaKH.' ORDER BY MaHD DESC LIMIT 1';
    $resultDonHang = mysqli_query($conn, $queryDonHang);

    while ($row = mysqli_fetch_assoc($resultDonHang)){
        $MaHD=$row;
    }
    if(!empty($MaHD))
    {
        $CTDH= json_decode($ChiTietDonHang,true);

        foreach($CTDH as $key => $value) {

            $queryCTDH = 'INSERT INTO `chitietdonhang` (`MaHD`, `MaSP`,`SoLuong`) VALUE ('.$MaHD['MaHD'].','.$value['maSP'].','.$value['numberInCard'].')';
            $resultCTDH= mysqli_query($conn, $queryCTDH);

        }

        if($resultCTDH==true)
        {
            $arr="You are successfully";
       
        }else{
            $arr="Thanh Toan Khong Thanh Cong";

        }
        $json = json_encode($arr);
        echo $json;


    }
    else
    {
        $arr="You are successfully";
        $json = json_encode($arr);
        echo $json;
  
    }
 



        
}