<?php
require_once "conn.php";
$sql =  "select * from state";

if(!$conn->query ($sql)){
    echo "Error in connecting to Database.";
}
else{
    $result = $conn->query ($sql);
    if($result->num_rows > 0){
         $return_arr['state'] = array();
        while($row = $result->fetch_array()){
           array_push($return_arr['state'], array(
                 'state_id'=>$row['state_id'],
                 'state_name'=>$row['state_name']
            ));
        }
        echo json_encode ($return_arr);
    }
}
