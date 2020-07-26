package com.example.appbanhang.Adapter.HomeAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
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

public class ProductSoldAdapter extends RecyclerView.Adapter<ProductSoldAdapter.ProductSoldViewHolder> {


    private ArrayList<SanPham> sanPhamArrayList;
    private Context context;


    public ProductSoldAdapter(ArrayList<SanPham> mangSanPhamBanChay, Context context) {
        this.sanPhamArrayList = mangSanPhamBanChay;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductSoldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_sold_card_design, parent, false);
        ProductSoldViewHolder productSoldViewHolder = new ProductSoldViewHolder(view, sanPhamArrayList, context);

        return productSoldViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSoldViewHolder holder, int position) {
        final SanPham sanPham = sanPhamArrayList.get(position);

        holder.txtTitle.setText(sanPham.getName());
        holder.txtDesc.setMaxLines(3);
        holder.txtDesc.setEllipsize(TextUtils.TruncateAt.END);
        holder.txtDesc.setText(sanPham.getTaste());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        if (sanPham.getPromotion() > 0 && sanPham.getPromotion() < sanPham.getPrice()) {

            SpannableString priceOld = new SpannableString(decimalFormat.format(sanPham.getPrice()));
            priceOld.setSpan(new StrikethroughSpan(), 0, priceOld.length(), 0);
            holder.txtPrice.setVisibility(View.VISIBLE);
            holder.txtPricePromotion.setTextColor(context.getResources().getColor(R.color.orange));
            holder.txtPricePromotion.setText(decimalFormat.format(sanPham.getPromotion())+ " Đ");
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

    public class ProductSoldViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView txtTitle, txtPrice, txtPricePromotion, txtDesc;
        public LinearLayout content;

        public ProductSoldViewHolder(@NonNull final View itemView, final ArrayList<SanPham> sanPhamArrayList, final Context context) {
            super(itemView);
            imageView = itemView.findViewById(R.id.products_sold_image);
            txtTitle = itemView.findViewById(R.id.products_sold_title);
            txtPrice = itemView.findViewById(R.id.products_sold_price_normal);
            txtPricePromotion = itemView.findViewById(R.id.products_sold_price_promotion);
            txtDesc = itemView.findViewById(R.id.products_sold_desc);

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
