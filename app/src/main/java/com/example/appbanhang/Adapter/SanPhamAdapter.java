package com.example.appbanhang.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanhang.Model.SanPham;
import com.example.appbanhang.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<SanPham> sanPhamArrayList;
    private Context context;



    public SanPhamAdapter(ArrayList<SanPham> sanPhamArrayList, Context context) {
        this.sanPhamArrayList = sanPhamArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dong_san_pham_moi_nhat, null);
        return new ViewHolder(view,sanPhamArrayList , context);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SanPham sanPham = sanPhamArrayList.get(position);
        holder.txtTenSanPham.setText(sanPham.getName());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaSanPham.setText("Giá : " + decimalFormat.format(sanPham.getPrice()) + " Đ");
        Picasso.with(context).load(sanPham.getImage()).placeholder(R.drawable.noimage).error(R.drawable.noimage).into(holder.imageSanPham);

    }



    @Override
    public int getItemCount() {
        return sanPhamArrayList.size();
    }
}
