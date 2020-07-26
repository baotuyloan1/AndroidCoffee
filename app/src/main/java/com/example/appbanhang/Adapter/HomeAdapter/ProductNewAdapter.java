package com.example.appbanhang.Adapter.HomeAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanhang.Activity.ChiTietSanPhamActivity;
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.Model.SanPham;
import com.example.appbanhang.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductNewAdapter extends RecyclerView.Adapter<ProductNewAdapter.ProductNewViewHolder> {

    private ArrayList<SanPham> sanPhamArrayList;
    private Context context;

    public ProductNewAdapter(ArrayList<SanPham> mangSanPham, Context context) {
        this.sanPhamArrayList = mangSanPham;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductNewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_new_card_design, parent, false);
        ProductNewViewHolder productNewViewHolder = new ProductNewViewHolder(view, sanPhamArrayList, context);

        return productNewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductNewViewHolder holder, int position) {
        final SanPham sanPham = sanPhamArrayList.get(position);

        holder.txtTitle.setText(sanPham.getName());
//        holder.content.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, sanPham.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        if (sanPham.getPromotion() > 0 && sanPham.getPromotion() < sanPham.getPrice()) {

            SpannableString priceOld = new SpannableString(decimalFormat.format(sanPham.getPrice()));
            priceOld.setSpan(new StrikethroughSpan(), 0, priceOld.length(), 0);
            holder.txtPrice.setVisibility(View.VISIBLE);
            holder.txtPricePromotion.setTextColor(context.getResources().getColor(R.color.orange));
            holder.txtPricePromotion.setText(decimalFormat.format(sanPham.getPromotion()) + " Đ");
            holder.txtPrice.setVisibility(View.VISIBLE);
            holder.txtPrice.setText(priceOld);
        } else {
            holder.txtPricePromotion.setVisibility(View.INVISIBLE);
            holder.txtPrice.setVisibility(View.VISIBLE);
            holder.txtPrice.setText(decimalFormat.format(sanPham.getPrice()) + " Đ");

        }
        Picasso.with(context).load(sanPham.getImage()).placeholder(R.drawable.noimage).error(R.drawable.noimage).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return sanPhamArrayList.size();
    }


    public static class ProductNewViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView txtTitle, txtPrice, txtPricePromotion;
        public LinearLayout content;

        public ProductNewViewHolder(@NonNull final View itemView, final ArrayList<SanPham> sanPhamArrayList, final Context context) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.products_new_image);
            txtTitle = (TextView) itemView.findViewById(R.id.products_new_title);
            txtPrice = (TextView) itemView.findViewById(R.id.products_new_price);
            content = (LinearLayout) itemView.findViewById(R.id.linearLayoutHome);
            txtPricePromotion = (TextView) itemView.findViewById(R.id.products_promotion_price);

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


}
