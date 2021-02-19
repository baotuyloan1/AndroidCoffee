<?php
include "connect.php";
$tenkhachhang = $_POST['tenkhachhang'];
$email =  $_POST['email'];
$diaChi =  $_POST['diaChi'];
$sodienthoai =  $_POST['sodienthoai'];
$userId = "";
if (strlen($tenkhachhang) > 0 && strlen($email) > 0 && strlen($sodienthoai) > 0 && strlen($diaChi) > 0) {
    if ($userId == "") {
        $queryCus = "INSERT INTO cusinfo(id,fullName,email,address,phone,userId) VALUES (null,'$tenkhachhang','$email',' $diaChi','$sodienthoai',null)";
        if (mysqli_query($conn, $queryCus)) {
            $idKhachHang = $conn->insert_id;

            echo $idKhachHang;
        } else {
            echo "Thất bại";
        }
    }
} else {
    echo "Kiểm tra dữ liệu";
}