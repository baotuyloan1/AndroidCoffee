<?php
include "connect.php";
$accId = $_POST['accId'];

$mangOrder = array();
$query = "SELECT * FROM orders where accId LIKE '$accId' ";
$data = mysqli_query($conn, $query);

if (mysqli_num_rows($data) == 0) {
    echo 0;
} else {
    while ($row = mysqli_fetch_assoc($data)) {
        array_push($mangOrder, new order(
            $row['id'],
            $row['cusId'],
            $row['created_at'],
            $row['totalPrice'],
            $row['note'],
            $row['delivered'],
            $row['accId']
        ));
     
      
    }
}
echo json_encode($mangOrder);




class order
{
    function order($id, $cusId, $created_at, $totalPrice, $note, $delivered,$accId)
    {
        $this->id = $id;
        $this->cusId = $cusId;
        $this->created_at = $created_at;
        $this->totalPrice = $totalPrice;
        $this->note = $note;
        $this->status = $delivered;
        $this->accId = $accId;
    }
}