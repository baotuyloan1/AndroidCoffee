package com.example.appbanhang.Activity.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.appbanhang.Activity.CheckOut.ThongTinKhachHangActivity;
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.Adapter.GioHangAdapter;
import com.example.appbanhang.R;
import com.example.appbanhang.Util.CheckConnection;

import java.text.DecimalFormat;

public class CartFragment extends Fragment {

    private View rootView;
    private ListView lvGioHang;
    private TextView txtThongBao;
    public static TextView txtTongTien;
    private Button btnThanhToan, btnTiepTucMua;
    private GioHangAdapter gioHangAdapter;
    public static double tongtien = 0;
    private ImageView imgBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_cart, container, false);
        khoiTao();
        checkData();
        showData();
        cachOnItemListView();
        eventButton();
        return rootView;
    }


    private void eventButton() {
        btnTiepTucMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.mangGioHang.size() > 0) {
                    Intent intent = new Intent(getContext(), ThongTinKhachHangActivity.class);
                    startActivity(intent);
                } else {
                    CheckConnection.showToastShort(getContext(), "Giỏ hàng của bạn chưa có sản phẩm");
                }
            }
        });


    }

    private void cachOnItemListView() {
        lvGioHang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có muốn xóa sản phẩm này ?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (MainActivity.mangGioHang.size() <= 0) {
                            txtThongBao.setVisibility(View.VISIBLE);
                        } else {
                            MainActivity.mangGioHang.remove(position);
                            gioHangAdapter.notifyDataSetChanged();
                            showData();
                            if (MainActivity.mangGioHang.size() <= 0) {
                                txtThongBao.setVisibility(View.VISIBLE);
                            } else {
                                gioHangAdapter.notifyDataSetChanged();
                                showData();
                                txtThongBao.setVisibility(View.INVISIBLE);
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gioHangAdapter.notifyDataSetChanged();
                        showData();
                    }
                });
                builder.show();
                return true;
            }
        });
    }

    public static void showData() {
        tongtien = 0;
        for (int i = 0; i < MainActivity.mangGioHang.size(); i++) {
            tongtien = tongtien + MainActivity.mangGioHang.get(i).getGiaSp();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtTongTien.setText(decimalFormat.format(tongtien) + " Đ");
    }


    private void checkData() {
        if (MainActivity.mangGioHang.size() <= 0) {
            gioHangAdapter.notifyDataSetChanged();
            txtThongBao.setVisibility(View.VISIBLE);
            lvGioHang.setVisibility(View.INVISIBLE);
        } else {
            gioHangAdapter.notifyDataSetChanged();
            txtThongBao.setVisibility(View.INVISIBLE);
            lvGioHang.setVisibility(View.VISIBLE);
        }
    }


    private void khoiTao() {
        lvGioHang = (ListView) rootView.findViewById(R.id.listViewGioHang);
        txtThongBao = (TextView) rootView.findViewById(R.id.textViewThongBao);
        txtTongTien = (TextView) rootView.findViewById(R.id.textViewTongTien);
        btnThanhToan = (Button) rootView.findViewById(R.id.buttonThanhToanGioHang);
        btnTiepTucMua = (Button) rootView.findViewById(R.id.buttonTiepTucMua);
        gioHangAdapter = new GioHangAdapter(getContext(), MainActivity.mangGioHang);
        lvGioHang.setAdapter(gioHangAdapter);
    }


}
