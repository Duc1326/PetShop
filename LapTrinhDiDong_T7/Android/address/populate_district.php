<?php
require_once "conn.php";
if(isset($_GET['state_name'])){
    $sql = "select district_id, district_name from district where state_id=(select state_id from state where state_name='".$_GET['state_name']."')";
    if(!$conn->query($sql)){
        echo "Error in executing query.";
    }else{
        $result = $conn->query ($sql);
        if($result->num_rows > 0){
            $return_arr['district'] = array();
            while($row = $result->fetch_array()){
                array_push($return_arr['district'], array(
                     'district_id'=>$row['district_id'],
                     'district_name'=>$row['district_name']
                 ));
                }
            echo json_encode($return_arr);
            }
        }
    }