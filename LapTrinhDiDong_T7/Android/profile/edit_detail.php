<?php 
 
 $id = $_POST['id'];
 $name = $_POST['name'];
 $email = $_POST['email'];
 $phone = $_POST['phone'];
 $dateofbirth = $_POST['dateofbirth'];

// $id = 3;
//  $name = "Hoang";
//  $email = "hoang@gmail.com";
//  $phone = "123456789";
//  $password = "123456";
//  $dateofbirth = "2000-12-12";

require_once '../connect.php';

$sql = "UPDATE users SET name='$name', email='$email', phone='$phone',
        dateofbirth='$dateofbirth' WHERE id='$id'";

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