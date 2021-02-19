package com.example.appbanhang.Adapter.CategoryAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.appbanhang.Activity.Category.CoffeeActivity;
import com.example.appbanhang.Model.LoaiSp;
import com.example.appbanhang.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class LoaiSpAdapter extends BaseAdapter {

    public ArrayList<LoaiSp> arrayListLoaiSp;
    Context context;

    private int[] mangBackground = new int[]{R.drawable.round_bk5, R.drawable.round_bk2, R.drawable.round_bk3, R.drawable.round_bk1, R.drawable.round_bk5, R.drawable.round_bk2};

    public LoaiSpAdapter(ArrayList<LoaiSp> arrayListLoaiSp, Context context) {
        this.arrayListLoaiSp = arrayListLoaiSp;
        this.context = context;
        ;
    }

    @Override
    public int getCount() {
        return arrayListLoaiSp.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListLoaiSp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView txtTenLoaiSanPham;
        public ImageView imgLoaiSp;
        public Button btnExpand;
        public RelativeLayout content;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_loai_sanpham, null);
            viewHolder.content = (RelativeLayout) convertView.findViewById(R.id.relativeCategoryPage);
            viewHolder.txtTenLoaiSanPham = (TextView) convertView.findViewById(R.id.titleCategoryPage);
            viewHolder.imgLoaiSp = (ImageView) convertView.findViewById(R.id.imageCategoryPage);
            viewHolder.btnExpand = (Button) convertView.findViewById(R.id.buttonExpandCategoryPage);
            convertView.setTag(viewHolder);
            int so = (int)(Math.random()*((5)+1))+0;
            viewHolder.content.setBackgroundResource(mangBackground[so]);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        final LoaiSp loaiSp = (LoaiSp) getItem(position);
        viewHolder.txtTenLoaiSanPham.setText(loaiSp.getTenLoaiSp());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CoffeeActivity.class);
                intent.putExtra("idLoaiSanPham",loaiSp.getId());
                context.startActivity(intent);
            }
        });
        Picasso.with(context).load(loaiSp.getHinhLoaiSp()).error(R.drawable.error).into(viewHolder.imgLoaiSp);

        return convertView;
    }
}
