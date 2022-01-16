<?php

require_once '../connection.php';

$sql = "SELECT * FROM thucungcho where maTL =7";
$result = mysqli_query($conn, $sql);

    if (mysqli_num_rows($result) > 0) {

        while ($row[] = mysqli_fetch_assoc($result)) {

            $item = $row;

            $json = json_encode($item);
        }
    } else {
        echo "0 results";
    }
    echo $json;
    mysqli_close($conn);