package com.example.appbanhang.Adapter.CategoryAdapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appbanhang.Model.SanPham;
import com.example.appbanhang.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

public class CoffeeAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SanPham> arrayList;

    private ArrayList<SanPham> searchList;

    public CoffeeAdapter(Context context, ArrayList<SanPham> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

        this.searchList = new ArrayList<SanPham>();
        this.searchList.addAll(arrayList);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    //get ra những thuộc tính bên trong mảng
    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        public TextView txtTenCoffee, txtGiaCoffee, txtMoTaCoffee;
        public ImageView imageCoffee;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_coffee, null);
            viewHolder.txtTenCoffee = (TextView) convertView.findViewById(R.id.textViewTenCoffee);
            viewHolder.txtGiaCoffee = (TextView) convertView.findViewById(R.id.textViewGiaCoffee);
            viewHolder.txtMoTaCoffee = (TextView) convertView.findViewById(R.id.textViewMoTaCoffee);
            viewHolder.imageCoffee = (ImageView) convertView.findViewById(R.id.imageViewCoffee);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SanPham sanPham = (SanPham) getItem(position);
        viewHolder.txtTenCoffee.setText(sanPham.getName());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaCoffee.setText(String.format("Giá : " + decimalFormat.format(sanPham.getPrice()) ));
        //chỉ hiển thị 2 dòng
        viewHolder.txtMoTaCoffee.setMaxLines(2);
        //hơn 2 dòng thì dấu ...
        viewHolder.txtMoTaCoffee.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtMoTaCoffee.setText(sanPham.getTaste());
        Picasso.with(context).load(sanPham.getImage()).placeholder(R.drawable.noimage).error(R.drawable.error).into(viewHolder.imageCoffee);
        return convertView;
    }


    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        arrayList.clear();
        if (charText.length() == 0){
            arrayList.addAll(searchList);
        }else{
            for (SanPham coffee : searchList){
                if(removeAccent(coffee.getName()).toLowerCase(Locale.getDefault()).contains(charText))
                    arrayList.add(coffee);
            }
        }
        notifyDataSetChanged();
    }


    public static String removeAccent(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

}
