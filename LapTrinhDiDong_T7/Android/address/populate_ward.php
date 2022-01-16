<?php
require_once "conn.php";
if(isset($_GET['district_name'])){
    $sql = "select ward_id, ward_name from ward where district_id=(select district_id from district where district_name='".$_GET['district_name']."')";
    if(!$conn->query($sql)){
        echo "Error in executing query.";
    }else{
        $result = $conn->query ($sql);
        if($result->num_rows > 0){
            $return_arr['ward'] = array();
            while($row = $result->fetch_array()){
                array_push($return_arr['ward'], array(
                     'ward_id'=>$row['ward_id'],
                     'ward_name'=>$row['ward_name']
                 ));
                }
            echo json_encode($return_arr);
            }
        }
    }