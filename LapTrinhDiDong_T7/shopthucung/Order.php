<?php

use function PHPSTORM_META\elementType;

require_once 'connection.php';

$MaKH=$_POST['MaKH'];
$DonGia=$_POST['DonGia'];
$ChiTietDonHang=$_POST['ChiTietDonHang'];


$queryDonHang = "INSERT INTO hoadon (MaKH, DonGia, NgayLap ) VALUE ( $MaKH ,$DonGia, Default)";
$resultDonHang = mysqli_query($conn, $queryDonHang);

if($resultDonHang == true){
    $queryDonHang = "SELECT MaHD  FROM hoadon WHERE MaKH = $MaKH ORDER BY MaHD DESC LIMIT 1";
            $MaHD=$conn->insert_id;
            if(!empty($MaHD))
            {
                $CTDH= json_decode($ChiTietDonHang,true);
                foreach($CTDH as $key => $value) {
                    $maSP = $value['maSP'];
                    $soluong = $value['numberInCard'];
        
                    $queryCTDH = "INSERT INTO chitiethoadon (MaHD, MaSP, SoLuong) VALUES ( '$MaHD', '$maSP','$soluong' )";
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



   


 



        
