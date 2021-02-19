<?php
include "connect.php";
$idAccount =    $_POST['idAccount'];

$fullname =  $_POST['fullname'];
$email =      $_POST['email'];
$phone =     $_POST['phone'];
$address =    $_POST['address'];

$query = "UPDATE users SET  fullName = '$fullname', phoneNumber = '$phone' , address = '$address', emailAddress = '$email' WHERE id = '$idAccount' ";


if ($conn->query($query) === TRUE) {
    echo "1";
} else {
    echo "Error updating record: " . $conn->error;
}