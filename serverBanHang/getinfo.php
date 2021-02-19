<?php
include "connect.php";
$idAccount = $_POST['idAccount'];


$query = "SELECT * FROM users where id LIKE '$idAccount' ";
$data = mysqli_query($conn, $query);

if (mysqli_num_rows($data) == 0) {
    echo 0;
} else {
    while ($row = mysqli_fetch_assoc($data)) {
        $account = new account(
            $row['id'],
            $row['name'],
            $row['fullName'],
            $row['phoneNumber'],
            $row['address'],
            $row['emailAddress']
        );
        echo json_encode($account);
    }
}




class account
{
    function account($id, $name, $fullName, $phoneNumber, $address, $emailAddress)
    {
        $this->id = $id;
        $this->name = $name;
        $this->fullName = $fullName;
        $this->phoneNumber = $phoneNumber;
        $this->address = $address;
        $this->emailAddress = $emailAddress;
    }
}