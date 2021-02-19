<?php
include "connect.php";

$json = $_POST['json'];
// $json = '[{"madonhang":120,"masanpham":2,"soluong":5,"giasanpham":1000}]';
$data = json_decode($json, true);
foreach ($data as $value) {
    $madonhang = $value['madonhang'];
    $masanpham = $value['masanpham'];
    $soluong = $value['soluong'];
    $giasanpham = $value['giasanpham'];
    $query = "INSERT INTO orderdetail (id,idOrder,idProduct,quantity,priceProduct) VALUES (null,'$madonhang','$masanpham','$soluong','$giasanpham')";
    $DATA = mysqli_query($conn, $query);
}
if ($DATA) {
    echo "1";
} else {
    echo "0";
}