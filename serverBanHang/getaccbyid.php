<?php
include "connect.php";
$id = $_POST['idAccount'];
$password = $_POST['password'];


$query = "SELECT * FROM users where id LIKE '$id' ";
$data = mysqli_query($conn, $query);
$mangacc = array();

if (mysqli_num_rows($data) == 0) {
   echo 0;
} else {
    while ($row = mysqli_fetch_assoc($data)) {
        if (password_verify($password, $row['password'])) {
            $account = new account(
                $row['id'],
                $row['name'],
                $row['fullName'],
                $row['password'],
                $row['phoneNumber'],
                $row['address'],
                $row['emailAddress']
            );
            echo json_encode($account);
           
        }
        else echo 2;
    }
}




class account
{
    function account($id, $name, $fullName, $password, $phoneNumber, $address, $emailAddress)
    {
        $this->id = $id;
        $this->name = $name;
        $this->fullName = $fullName;
        $this->password = $password;
        $this->phoneNumber = $phoneNumber;
        $this->address = $address;
        $this->emailAddress = $emailAddress;
    }
}