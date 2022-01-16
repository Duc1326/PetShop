<?php 
 
 $id = $_POST['id'];
 $name = $_POST['name'];
 $email = $_POST['email'];
 $phone = $_POST['phone'];
 $dateofbirth = $_POST['dateofbirth'];
 $adress = $_POST['adress'];

// $id = 6;
//  $name = "Minh";
//  $email = "hoang@gmail.com";
//  $phone = "123456789";
//  $password = "123456";
//  $dateofbirth = "2000-12-12";
//  $adress ="Khu 3 thôn 1";

require_once '../connection.php';

$sql = "UPDATE users SET name='$name', email='$email', phone='$phone',
        dateofbirth='$dateofbirth',address = '$adress' WHERE id='$id'";

$loginQuery = mysqli_query($conn, $sql);
if(mysqli_query($conn, $sql)){

    $result['success'] = "1";
    $result['message'] = "success";
    echo json_encode($result);
}
else{
    echo "Lỗi không cập nhập được";
   
}