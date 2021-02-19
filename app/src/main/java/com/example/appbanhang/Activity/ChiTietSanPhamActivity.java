package com.example.appbanhang.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.appbanhang.Model.GioHang;
import com.example.appbanhang.Model.SanPham;
import com.example.appbanhang.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ChiTietSanPhamActivity extends AppCompatActivity {

    private Toolbar toolBarChiTiet;
    private ImageView imgChiTiet, btnBack;
    private Spinner spinner;
    private Button btnDatMua, btnIncrease, btnDecrease, btnValue;
    private TextView txtKhoiLuong, txtCachRang, txtHSD, txtThanhPhan, txtStatus, txtTenSp, txtGia, txtMota, txtTitle, txtPromotion;
    private int idSp;
    private double donGia;
    private String tenSp;
    private String img;
    private String muivi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        khoiTao();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        acctionToolBar();
//        getInformation();
//        catchEventSpinner();
//        eventButton();


        getData();
        eventButtonAdd();
    }

    private void getData() {
        SanPham sanPham = (SanPham) getIntent().getSerializableExtra("thongtinsanpham");
        idSp = sanPham.getId();
        tenSp = sanPham.getName();

        int khoiLuong = sanPham.getNetWeight();
        String cachRang = sanPham.getRoast();
        img = sanPham.getImage();
        String hanSuDung = sanPham.getShelfLife();
        muivi = sanPham.getTaste();
        int status = sanPham.getStatus();
        double promotion = sanPham.getPromotion();
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");


        if (promotion > 0 && promotion < sanPham.getPrice()) {
            SpannableString priceOld = new SpannableString(decimalFormat.format(sanPham.getPrice())+" Đ");
            priceOld.setSpan(new StrikethroughSpan(), 0, priceOld.length(), 0);
            txtPromotion.setVisibility(View.VISIBLE);
            txtPromotion.setTextColor(getResources().getColor(R.color.orange));
            txtPromotion.setText(decimalFormat.format(promotion)+ " Đ");
            txtGia.setVisibility(View.VISIBLE);
            txtGia.setText(priceOld);
            donGia = sanPham.getPromotion();
        } else {
            donGia = sanPham.getPrice();
            txtPromotion.setVisibility(View.INVISIBLE);
            txtGia.setVisibility(View.VISIBLE);
            txtGia.setText(decimalFormat.format(donGia) + " Đ");

        }
        txtTenSp.setText(tenSp);


        if (!cachRang.equals(null))
            txtCachRang.setText(cachRang + "");
        else
            txtCachRang.setText("Đang cập nhật");
        txtHSD.setText(hanSuDung);
        Picasso.with(getApplicationContext()).load(img).placeholder(R.drawable.noimage).error(R.drawable.error).into(imgChiTiet);
        if (status == 1) {
            txtStatus.setTextColor(Color.GREEN);
            txtStatus.setText("OK");
        } else {
            txtStatus.setTextColor(Color.RED);
            txtStatus.setText("NOT OK");
        }
        txtKhoiLuong.setText(khoiLuong + "");
        txtMota.setText(muivi);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChiTietSanPhamActivity.super.onBackPressed();
            }
        });
    }


    private void eventButtonAdd() {
        int sl = Integer.parseInt(btnValue.getText().toString());
        if (sl >= 20) {
            btnIncrease.setVisibility(View.INVISIBLE);
            btnDecrease.setVisibility(View.VISIBLE);
        }

        if (sl <= 1) {
            btnDecrease.setVisibility(View.INVISIBLE);
            btnIncrease.setVisibility(View.VISIBLE);
        }
        if (1 < sl && sl < 20) {
            btnIncrease.setVisibility(View.VISIBLE);
            btnDecrease.setVisibility(View.VISIBLE);
        }

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slMoiNhat = Integer.parseInt(btnValue.getText().toString()) + 1;
                btnValue.setText(slMoiNhat + "");
                if (slMoiNhat > 19) {
                    btnIncrease.setVisibility(View.INVISIBLE);
                    btnDecrease.setVisibility(View.VISIBLE);
                    btnValue.setText(String.valueOf(slMoiNhat));

                } else {
                    btnValue.setText(String.valueOf(slMoiNhat));
                    btnIncrease.setVisibility(View.VISIBLE);
                    btnDecrease.setVisibility(View.VISIBLE);
                }
            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slMoiNhat = Integer.parseInt(btnValue.getText().toString()) - 1;
                btnValue.setText(slMoiNhat + "");

                if (slMoiNhat < 2) {
                    btnIncrease.setVisibility(View.VISIBLE);
                    btnDecrease.setVisibility(View.INVISIBLE);
                    btnValue.setText(String.valueOf(slMoiNhat));
                } else {
                    btnIncrease.setVisibility(View.VISIBLE);
                    btnDecrease.setVisibility(View.VISIBLE);
                    btnValue.setText(String.valueOf(slMoiNhat));
                }
            }
        });

        btnDatMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.mangGioHang.size() > 0) {
                    int sl = Integer.parseInt(btnValue.getText().toString());
                    boolean exists = false;
                    for (int i = 0; i < MainActivity.mangGioHang.size(); i++) {
                        if (MainActivity.mangGioHang.get(i).getIdSp() == idSp) {
                            MainActivity.mangGioHang.get(i).setSoLuong(MainActivity.mangGioHang.get(i).getSoLuong() + sl);
                            MainActivity.mangGioHang.get(i).setGiaSp(donGia * MainActivity.mangGioHang.get(i).getSoLuong());
                            exists = true;
                        }
                    }
                    if (exists == false) {
                        int soLuong = Integer.parseInt(btnValue.getText().toString());
                        double giaMoi = soLuong * donGia;
                        MainActivity.mangGioHang.add(new GioHang(idSp, tenSp, giaMoi, img, soLuong));
                    }
                } else {
                    int soLuong = Integer.parseInt(btnValue.getText().toString());
                    double giaMoi = soLuong * donGia;
                    MainActivity.mangGioHang.add(new GioHang(idSp, tenSp, giaMoi, img, soLuong));
                }
                Toast.makeText(ChiTietSanPhamActivity.this, "Thêm giỏ hàng thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void eventButton() {
        btnDatMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.mangGioHang.size() > 0) {
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exists = false;
                    for (int i = 0; i < MainActivity.mangGioHang.size(); i++) {
                        if (MainActivity.mangGioHang.get(i).getIdSp() == idSp) {
                            MainActivity.mangGioHang.get(i).setSoLuong(MainActivity.mangGioHang.get(i).getSoLuong() + sl);
                            if (MainActivity.mangGioHang.get(i).getSoLuong() >= 20) {
                                MainActivity.mangGioHang.get(i).setSoLuong(20);
                            }
                            MainActivity.mangGioHang.get(i).setGiaSp(donGia * MainActivity.mangGioHang.get(i).getSoLuong());
                            exists = true;
                        }
                    }
                    if (exists == false) {
                        int soLuong = Integer.parseInt(spinner.getSelectedItem().toString());
                        double giaMoi = soLuong * donGia;
                        MainActivity.mangGioHang.add(new GioHang(idSp, tenSp, giaMoi, img, soLuong));
                    }

                } else {
                    int soLuong = Integer.parseInt(spinner.getSelectedItem().toString());
                    double giaMoi = soLuong * donGia;
                    MainActivity.mangGioHang.add(new GioHang(idSp, tenSp, giaMoi, img, soLuong));
                }
                Toast.makeText(ChiTietSanPhamActivity.this, "Thêm giỏ hàng thành công", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void catchEventSpinner() {
        Integer[] soluong = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, soluong);
        spinner.setAdapter(arrayAdapter);
    }

    private void getInformation() {

    }

    private void acctionToolBar() {
        setSupportActionBar(toolBarChiTiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBarChiTiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void khoiTao() {
        txtTitle = (TextView) findViewById(R.id.txt_title_desc);
        imgChiTiet = (ImageView) findViewById(R.id.img_desc);
        txtGia = (TextView) findViewById(R.id.textViewPrice);
        btnDatMua = (Button) findViewById(R.id.buttonAdd);
        btnIncrease = (Button) findViewById(R.id.buttonIncrease);
        btnDecrease = (Button) findViewById(R.id.buttonDecrease);
        btnValue = (Button) findViewById(R.id.buttonValues);
        txtHSD = (TextView) findViewById(R.id.textViewHSD);
        txtKhoiLuong = (TextView) findViewById(R.id.textViewKhoiLuong);
        txtStatus = (TextView) findViewById(R.id.textViewStatus);
        txtTenSp = (TextView) findViewById(R.id.txtTenSanPham);
        txtGia = (TextView) findViewById(R.id.textViewPrice);
        txtMota = (TextView) findViewById(R.id.textViewTase);
        txtCachRang = (TextView) findViewById(R.id.textViewCachRang);
        btnBack = (ImageView) findViewById(R.id.menu_icon);
        txtPromotion = (TextView) findViewById(R.id.textViewPricePromotion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}