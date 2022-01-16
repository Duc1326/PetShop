<?php 
 
 $id = $_POST['id'];
 $photo = $_POST['photo'];
 

// $id = 3;
// $photo = "Hoang";

$pathHA = "../profile_image/$id.jpeg";
$path = "profile_image/$id.jpeg";
$finalPath = "Android/".$path;

require_once '../connect.php';

$sql = "UPDATE users SET photo='$finalPath' WHERE id='$id'";

if(mysqli_query($conn,$sql)){

    if(file_put_contents($pathHA,base64_decode($photo))){

    $result["success"] = "1";
    $result['message'] = "success";

    echo json_encode($result);
    mysqli_close($conn);
    }
}
else{
    echo "error!";

    mysqli_close($conn);
}