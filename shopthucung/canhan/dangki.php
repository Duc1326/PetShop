<?php

require_once '../connection.php';

$sdt = $_POST["sdt"];
$password = $_POST["psw"];


if ($conn) {
    if(strlen($password) < 6){
        echo "Mật khẩu quá yếu";
    }else{
        $sqlCheckEmail = "SELECT * FROM users WHERE phone LIKE '$sdt'";
        $email_query = mysqli_query($conn,$sqlCheckEmail);

        if (mysqli_num_rows($email_query) > 0){
            echo "Số điện thoại đã được đăng kí";
        }else{
            $sql_register = "INSERT INTO users(phone,password) VALUES('$sdt','$password')";
            if(mysqli_query($conn,$sql_register)){
                echo "";
            }else{
                echo "Đăng kí thất bại";
            }
        }
    }
}else{
    echo "Connection Error";
}