<?php
include "connect.php";
$idAccount =    $_POST['idAccount'];

$password = $_POST['password'];


$pass = password_hash("$password", PASSWORD_DEFAULT);



$query = "UPDATE users SET  password = '$pass' WHERE  $idAccount =  '$idAccount' ";


if ($conn->query($query) === TRUE) {
    echo "1";
} else {
    echo "Thay đổi thất bại" . $conn->error;
}