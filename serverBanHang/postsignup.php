<?php
include "connect.php";
$fullname =  $_POST['fullname'];
$username =  $_POST['username'];
$email =  $_POST['email'];
$phone =  $_POST['phone'];
$password =  $_POST['password'];
$address =  $_POST['address'];

$pass = password_hash("$password", PASSWORD_DEFAULT);

$query1 = "SELECT * FROM users WHERE name = '$username' ";
$data = mysqli_query($conn, $query1);

if (mysqli_num_rows($data) == 0) {
  $query = "INSERT INTO users (name, fullName, phoneNumber, address, emailAddress, roleId, password) VALUES ('$username', '$fullname','$phone', '$address', '$email', '3', '$pass')";

$mangacc = array();

if ($conn->query($query) === TRUE) {
  echo "1";
} else {
  echo "0";
}


}else {
  echo "2";
}