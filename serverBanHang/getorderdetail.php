<?php
include "connect.php";
$idOrder = $_POST['idOrder'];

$mangOrderDetail = array();
$query = "SELECT * FROM orderdetail where idOrder LIKE '$idOrder' ";




$data = mysqli_query($conn, $query);


if (mysqli_num_rows($data) == 0) {
    echo 0;
} else {
    while ($row = mysqli_fetch_assoc($data)) {


        $id = $row['idProduct'];

        $query1 = "SELECT * FROM product WHERE id LIKE '$id'";
        $data1 = mysqli_query($conn, $query1);
        while ($row1 = mysqli_fetch_assoc($data1)) {
            $sanpham = new Sanpham(
                   $row1['id'],
                   $row1['name'],
                   $row1['producerId'],
                   $row1['productCateId'],
                   $row1['price'],
                   $row1['netWeight'],
                   $row1['roast'],
                   $row1['imgOnline'],
                   $row1['shelfLife'],
                   $row1['particleSize'],
                   $row1['taste'],
                   $row1['quantity'],
                   $row1['ingredient'],
                   $row1['sold'],
                   $row1['status'],
                   $row1['promotion']
               );
           }
        array_push($mangOrderDetail, new orderDetail(
            $row['id'],
            $row['idOrder'],
            $sanpham,
            $row['quantity'],
            $row['priceProduct']
        ));
        
  

    }
}
echo json_encode($mangOrderDetail);




class orderDetail

{


    function orderDetail($id, $idOrder, $product, $quantity, $priceProduct)
    {
        $this->id = $id;
        $this->idOrder = $idOrder;
        $this->product = $product;
        $this->quantity = $quantity;
        $this->priceProduct = $priceProduct;
    }
}

class Sanpham
{
    function Sanpham($id, $tenSP, $idNhaCungCap, $idLoaiSanPham, $donGia, $khoiLuong, $cachRang, $imageChinh, $hanSuDung, $kichThuoc, $muivi, $soluong, $thanhphan, $daban, $status, $khuyenmai)
    {
        $this->id = $id;
        $this->tenSp = $tenSP;
        $this->idNhaCungCap = $idNhaCungCap;
        $this->idLoaiSanPham = $idLoaiSanPham;
        $this->donGia = $donGia;
        $this->khoiLuong = $khoiLuong;
        $this->cachRang = $cachRang;
        $this->imageChinh = $imageChinh;
        $this->hanSuDung = $hanSuDung;
        $this->kichThuoc = $kichThuoc;
        $this->muivi = $muivi;
        $this->soluong = $soluong;
        $this->thanhphan = $thanhphan;
        $this->daban = $daban;
        $this->status = $status;
        $this->khuyenmai = $khuyenmai;
    }
}