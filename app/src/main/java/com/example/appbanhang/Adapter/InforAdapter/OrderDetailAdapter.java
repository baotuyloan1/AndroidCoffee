package com.example.appbanhang.Adapter.InforAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.appbanhang.Activity.ChiTietSanPhamActivity;
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.Model.OrderDetail;
import com.example.appbanhang.Model.SanPham;
import com.example.appbanhang.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderDetailAdapter extends BaseAdapter {

    private ArrayList<OrderDetail> orderDetails;
    private Context context;


    public OrderDetailAdapter(ArrayList<OrderDetail> orderDetails, Context context) {
        this.orderDetails = orderDetails;
        this.context = context;
    }

    @Override
    public int getCount() {
        return orderDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return orderDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return orderDetails.get(position).getIdOrder();
    }

    public class ViewHolder {
        public ImageView imgSanPham;
        public TextView txtTenSanPham, txtGiaSanPham, txtSoLuong;
        public Button btnChiTiet;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_order_detail, null);
            viewHolder.txtTenSanPham = (TextView) convertView.findViewById(R.id.orderDetail_nameProduct_txt);
            viewHolder.imgSanPham = (ImageView) convertView.findViewById(R.id.orderDetail_product_image);
            viewHolder.txtSoLuong = (TextView) convertView.findViewById(R.id.orderDetail_quantity_txt);
            viewHolder.txtGiaSanPham = (TextView) convertView.findViewById(R.id.orderDetail_price_txt);
            viewHolder.btnChiTiet = (Button) convertView.findViewById(R.id.orderDetail_chitiet_btn);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        OrderDetail orderDetail = (OrderDetail) getItem(position);
        final SanPham sanPham = orderDetail.getSanPham();
        viewHolder.txtTenSanPham.setText(sanPham.getName());

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaSanPham.setText("Giá: " +decimalFormat.format(sanPham.getPrice())+"Đ");

        viewHolder.txtSoLuong.setText("SL: "+orderDetail.getQuantity());
        viewHolder.btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham", sanPham);
                context.startActivity(intent);


            }
        });




        Picasso.with(context).load(sanPham.getImage()).error(R.drawable.error).into(viewHolder.imgSanPham);
        return convertView;
    }
}
