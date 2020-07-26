package com.example.appbanhang.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanhang.Activity.ChiTietSanPhamActivity;
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.Model.SanPham;
import com.example.appbanhang.R;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageSanPham;
    public TextView txtTenSanPham, txtGiaSanPham;

    public ViewHolder(@NonNull final View itemView, final ArrayList<SanPham> sanPhamArrayList, final Context context) {
        super(itemView);
        imageSanPham = (ImageView) itemView.findViewById(R.id.imageViewSanPham);
        txtGiaSanPham = (TextView) itemView.findViewById(R.id.textViewGiaSanPham);
        txtTenSanPham = (TextView) itemView.findViewById(R.id.textViewTenSanPham);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham", sanPhamArrayList.get(getAdapterPosition()));
                context.startActivity(intent);



            }
        });
    }




}
