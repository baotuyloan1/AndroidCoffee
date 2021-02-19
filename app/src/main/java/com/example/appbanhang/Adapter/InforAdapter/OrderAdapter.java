package com.example.appbanhang.Adapter.InforAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appbanhang.Activity.InforAccount.OrderDetailActivity;
import com.example.appbanhang.Model.Order;
import com.example.appbanhang.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderAdapter extends BaseAdapter {

    private ArrayList<Order> orders;
    private Context context;

    public OrderAdapter(ArrayList<Order> orders, Context context) {
        this.orders = orders;
        this.context = context;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_order, null);
            viewHolder.txtDateOrder = (TextView) convertView.findViewById(R.id.dong_order_date_order);
            viewHolder.txtGiaTien = (TextView) convertView.findViewById(R.id.dong_order_giatien_txt);
            viewHolder.txtNote = (TextView) convertView.findViewById(R.id.dong_order_note_txt);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        final Order order = (Order) getItem(position);
        viewHolder.txtDateOrder.setText(order.getDateOrder());
        viewHolder.txtGiaTien.setText(decimalFormat.format(order.getTotalPrice()) +"Đ");
        viewHolder.txtNote.setText(order.getNote());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra("idOrder",order.getId());
                Toast.makeText(context, order.getTotalPrice()+"", Toast.LENGTH_SHORT).show();
                intent.putExtra("totalPrice",order.getTotalPrice());
                context.startActivity(intent);
            }
        });
        return convertView;
    }


    public class ViewHolder {
        TextView txtDateOrder, txtStatus, txtGiaTien, txtNote;
    }
}
