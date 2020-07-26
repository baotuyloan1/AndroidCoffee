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

public class ProductDiscountAdapter extends RecyclerView.Adapter<ProductDiscountAdapter.ProductDiscountViewHolder> {


    private final ArrayList<SanPham> sanPhamArrayList;
    private Context context;

    public ProductDiscountAdapter(ArrayList<SanPham> sanPhamArrayList, Context context) {
        this.sanPhamArrayList = sanPhamArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ProductDiscountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discount_products_card_design, parent, false);
        ProductDiscountViewHolder productDiscountViewHolder = new ProductDiscountViewHolder(view, sanPhamArrayList, context);
        return productDiscountViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDiscountViewHolder holder, int position) {
        SanPham sanPham = sanPhamArrayList.get(position);

        holder.txtTitle.setText(sanPham.getName());

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");


        SpannableString priceOld = new SpannableString(decimalFormat.format(sanPham.getPrice()));
        priceOld.setSpan(new StrikethroughSpan(), 0, priceOld.length(), 0);

        holder.txtPriceOld.setText(priceOld);
        holder.txtPriceNew.setText(decimalFormat.format(sanPham.getPromotion()));
        Picasso.with(context).load(sanPham.getImage()).placeholder(R.drawable.noimage).error(R.drawable.noimage).into(holder.imageView);

        holder.txtDesc.setMaxLines(4);
        holder.txtDesc.setEllipsize(TextUtils.TruncateAt.END);
        holder.txtDesc.setText(sanPham.getTaste());
    }


    @Override
    public int getItemCount() {
        return sanPhamArrayList.size();
    }

    public static class ProductDiscountViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView txtTitle, txtPriceOld, txtPriceNew, txtDesc;

        public ProductDiscountViewHolder(@NonNull final View itemView, final ArrayList<SanPham> sanPhamArrayList, final Context context) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.products_discount_image);
            txtTitle = (TextView) itemView.findViewById(R.id.products_discount_title);
            txtPriceOld = (TextView) itemView.findViewById(R.id.products_discount_price_old);
            txtPriceNew = (TextView) itemView.findViewById(R.id.products_discount_price_new);
            txtDesc = (TextView) itemView.findViewById(R.id.products_discount_desc);

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
