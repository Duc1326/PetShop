<?php
    
    $email = $_POST['email'];
    $password = $_POST['psw'];

    // $email = "thang@gmail.com";
    // $password = "123456";
    
    require_once '../connect.php';

    $sqlCheckEmail = "SELECT * FROM users WHERE email LIKE '$email'";

    $response = mysqli_query($conn,$sqlCheckEmail);

    $result = array();
    $result['login'] = array();

    if(mysqli_num_rows($response) > 0){

        $sqlLogin = "SELECT * FROM users WHERE password LIKE '$password'";
        $loginQuery = mysqli_query($conn, $sqlLogin);

        if(mysqli_num_rows($loginQuery) > 0){

            $row = mysqli_fetch_assoc($response);

            $index['name'] = $row['name'];
            $index['email'] = $row['email'];
            $index['phone'] = $row['phone'];
            $index['dateofbirth'] = $row['dateofbirth'];

            $index['address'] = $row['address'];
            $index['addressSpecific'] = $row['addressSpecific'];

            $index['id'] = $row['id'];

            array_push($result['login'],$index);

            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);

            mysqli_close($conn);
        }else{
            echo "Mật khẩu không đúng!";
        }
    }else {
        echo "Email không đúng!";
    }

