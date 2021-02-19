<?php

include "connect.php";
$idloaisp = $_POST['idnhasanxuat'];
$query = "SELECT * FROM producer WHERE producerId = $idnhasanxuat";
$data = mysqli_query($conn, $query);
$mangloaisp = array();
while ($row = mysqli_fetch_assoc($data)) {
    array_push($mangloaisp, new Loaisp(
        $row['id'],
        $row['name'],
        $row['description'],
        $row['status']
    ));
}

echo json_encode($mangloaisp);
class Nhasanxuat
{
    function Loaisp($id, $tenloaisp, $mota, $status)
    {
        $this->id = $id;
        $this->tenloaisp = $tenloaisp;
        $this->mota = $mota;
        $this->status = $status;
    }
}