package com.example.appbanhang.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appbanhang.Activity.Fragment.CartFragment;
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.Model.GioHang;
import com.example.appbanhang.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {

    Context context;
    ArrayList<GioHang> arrayGioHang;

    public GioHangAdapter(Context context, ArrayList<GioHang> arrayGioHang) {
        this.context = context;
        this.arrayGioHang = arrayGioHang;
    }

    @Override
    public int getCount() {
        return arrayGioHang.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayGioHang.get(position);
    }


    public class ViewHolder {
        public TextView txtTenGioHang, txtGiaGioHang;
        public ImageView imgGioHang;
        public Button btnMinus, btnPlus, btnValues;

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_gio_hang, null);
            viewHolder.txtTenGioHang = convertView.findViewById(R.id.textViewTenGioHang);
            viewHolder.txtGiaGioHang = convertView.findViewById(R.id.textViewGiaGioHang);
            viewHolder.imgGioHang = convertView.findViewById(R.id.imageViewGioHang);
            viewHolder.btnMinus = convertView.findViewById(R.id.buttonMinus);
            viewHolder.btnPlus = convertView.findViewById(R.id.buttonPlus);
            viewHolder.btnValues = convertView.findViewById(R.id.buttonValues);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GioHang gioHang = (GioHang) getItem(position);
        viewHolder.txtTenGioHang.setText(gioHang.getTenSp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaGioHang.setText(decimalFormat.format(gioHang.getGiaSp()) + " Đ");
        Picasso.with(context).load(gioHang.getHinhAnh()).placeholder(R.drawable.noimage).error(R.drawable.error).into(viewHolder.imgGioHang);
        viewHolder.btnValues.setText(gioHang.getSoLuong() + "");
        int sl = Integer.parseInt(viewHolder.btnValues.getText().toString());
        if (sl >= 20) {
            viewHolder.btnPlus.setVisibility(View.INVISIBLE);
            viewHolder.btnMinus.setVisibility(View.VISIBLE);
        }

        if (sl <= 1) {
            viewHolder.btnMinus.setVisibility(View.INVISIBLE);
            viewHolder.btnPlus.setVisibility(View.VISIBLE);
        }
        if (1 < sl && sl < 20) {
            viewHolder.btnMinus.setVisibility(View.VISIBLE);
            viewHolder.btnPlus.setVisibility(View.VISIBLE);
        }

        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slMoiNhat = Integer.parseInt(finalViewHolder.btnValues.getText().toString()) + 1;
                int slHienTai = MainActivity.mangGioHang.get(position).getSoLuong();
                long giaHt = (long) MainActivity.mangGioHang.get(position).getGiaSp();
                MainActivity.mangGioHang.get(position).setSoLuong(slMoiNhat);
                long giaMoiNhat = giaHt * slMoiNhat / slHienTai;
                MainActivity.mangGioHang.get(position).setGiaSp(giaMoiNhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtGiaGioHang.setText(decimalFormat.format(giaMoiNhat) + " Đ");
                CartFragment.showData();
                if (slMoiNhat > 19) {
                    finalViewHolder.btnPlus.setVisibility(View.INVISIBLE);
                    finalViewHolder.btnMinus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnValues.setText(String.valueOf(slMoiNhat));

                } else {
                    finalViewHolder.btnValues.setText(String.valueOf(slMoiNhat));
                    finalViewHolder.btnPlus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnMinus.setVisibility(View.VISIBLE);
                }
            }

        });
        viewHolder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slMoiNhat = Integer.parseInt(finalViewHolder.btnValues.getText().toString()) - 1;
                int slHienTai = MainActivity.mangGioHang.get(position).getSoLuong();
                long giaHt = (long) MainActivity.mangGioHang.get(position).getGiaSp();
                MainActivity.mangGioHang.get(position).setSoLuong(slMoiNhat);
                long giaMoiNhat = giaHt * slMoiNhat / slHienTai;
                MainActivity.mangGioHang.get(position).setGiaSp(giaMoiNhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtGiaGioHang.setText(decimalFormat.format(giaMoiNhat) + " Đ");
                CartFragment.showData();

                if (slMoiNhat < 2) {
                    finalViewHolder.btnPlus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnMinus.setVisibility(View.INVISIBLE);
                    finalViewHolder.btnValues.setText(String.valueOf(slMoiNhat));
                } else {
                    finalViewHolder.btnPlus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnMinus.setVisibility(View.VISIBLE);
                    finalViewHolder.btnValues.setText(String.valueOf(slMoiNhat));
                }
            }
        });
        return convertView;
    }
}
