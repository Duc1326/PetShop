<?php 
 
 $id = $_POST['id'];
 $addressSpecific = $_POST['addressSpecific'];
 $address = $_POST['address'];
 
//  $id = 3;
//  $addressSpecific = "17 Hoàng Diệu";
//  $address = "Phường Mân Thái,Quận Sơn Trà,Đà Nẵng";

require_once '../connect.php';

$sql = "UPDATE users SET address='$address', addressSpecific='$addressSpecific' WHERE id='$id'";

if(mysqli_query($conn,$sql)){

    $result["success"] = "1";
    $result['message'] = "succes";

    echo json_encode($result);
    mysqli_close($conn);
}
else{
    echo "error!";

    mysqli_close($conn);
}