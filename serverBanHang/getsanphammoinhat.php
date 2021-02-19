<?php

include "connect.php";
$mangspmoinhat = array();
$query = "SELECT * FROM product ORDER BY id DESC LIMIT 6 ";
$data = mysqli_query($conn, $query);
while ($row = mysqli_fetch_assoc($data)) {
    array_push($mangspmoinhat, new SanPhamMoiNhat(
        $row['id'],
        $row['name'],
        $row['producerId'],
        $row['productCateId'],
        $row['price'],
        $row['netWeight'],
        $row['roast'],
        $row['imgOnline'],
        $row['shelfLife'],
        $row['particleSize'],
        $row['taste'],
        $row['quantity'],
        $row['ingredient'],
        $row['sold'],
        $row['status'],
        $row['promotion']

    ));
}
echo json_encode($mangspmoinhat);


class SanPhamMoiNhat
{
    function SanPhamMoiNhat($id, $tenSP, $idNhaCungCap, $idLoaiSanPham, $donGia, $khoiLuong, $cachRang, $imageChinh, $hanSuDung, $kichThuoc, $muivi, $soluong, $thanhphan, $daban, $status, $khuyenmai)
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