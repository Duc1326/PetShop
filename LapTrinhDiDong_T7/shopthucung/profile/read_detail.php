<?php

$id = $_POST['id'];

// $id = "1";

require_once '../connection.php';

$sql = "SELECT * FROM users WHERE id LIKE '$id'";

$response = mysqli_query($conn, $sql);

$result = array();
$result['read'] = array();

if (mysqli_num_rows($response) > 0) {
    if ($row = mysqli_fetch_assoc($response)) {

        $h['name']      = $row['name'];
        $h['email']     = $row['email'];
        $h['phone']     = $row['phone'];
        $h['dateofbirth'] = $row['dateofbirth'];
        $h['photo'] = $row['photo'];

        $h['address']     = $row['address'];
        $h['addressSpecific'] = $row['addressSpecific'];

        array_push($result['read'], $h);

        $result['success'] = "1";
        echo json_encode($result);
    } else {
        echo "error!";

        mysqli_close($conn);
    }
}
