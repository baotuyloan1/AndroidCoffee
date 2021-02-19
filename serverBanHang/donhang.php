<?php
include "connect.php";

$maKhachHang =  $_POST['maKhachHang'];
$totalPrice =   $_POST['totalPrice'];
$accId =   $_POST['accId'];
$note = $_POST['note'];
if ($accId == "0") {
    $query = "INSERT INTO orders(id,cusId,created_at,totalPrice,note,accId,delivered) VALUES (null,'$maKhachHang',null,'$totalPrice','$note',null,0)";
} else {
    $query = "INSERT INTO orders(id,cusId,created_at,totalPrice,note,accId,delivered) VALUES (null,'$maKhachHang',null,'$totalPrice','$note','$accId',0)";
}

$DATA = mysqli_query($conn, $query);
if ($DATA) {
    $idKhachHang = $conn->insert_id;
    echo $idKhachHang;
} else {
    echo "0";
}