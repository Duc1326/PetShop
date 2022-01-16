<?php

require_once '../connect.php';

$username = $_POST["username"];
$email = $_POST["email"];
$password = $_POST["psw"];

$isValidEmail = filter_var($email, FILTER_VALIDATE_EMAIL);
if ($conn) {
    if(strlen($password) < 6){
        echo "Mật khẩu quá yếu";
    }else if($isValidEmail == false){
        echo "Email không hợp lệ";
    }else {
        $sqlCheckEmail = "SELECT * FROM users WHERE name LIKE '$username'";
        $usernameQuery = mysqli_query($conn, $sqlCheckEmail);

        $sqlCheckEmail = "SELECT * FROM users WHERE email LIKE '$email'";
        $email_query = mysqli_query($conn,$sqlCheckEmail);

        if (mysqli_num_rows($usernameQuery) > 0) {
            echo "User name allready used type another one";
        }else if(mysqli_num_rows($email_query) > 0){
            echo "This Email is allready registered";
        }else{
            $sql_register = "INSERT INTO users(name,email,password) VALUES('$username','$email','$password')";
            if(mysqli_query($conn,$sql_register)){
                echo "You are registered successfully";
            }else{
                echo "Failed to register you account";
            }
        }
    }
}else{
    echo "Connection Error";
}