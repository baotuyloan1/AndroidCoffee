package com.example.appbanhang.Activity.InforAccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.Adapter.InforAdapter.OrderDetailAdapter;
import com.example.appbanhang.Model.OrderDetail;
import com.example.appbanhang.Model.SanPham;
import com.example.appbanhang.R;
import com.example.appbanhang.Util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderDetailActivity extends AppCompatActivity {

    private ImageView btnBack;
    private ListView listViewOrderDetail;
    private Button btnMain;
    private TextView txtTotal;

    private OrderDetailAdapter orderDetailAdapter;
    private ArrayList<OrderDetail> orderDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnBack = (ImageView) findViewById(R.id.orderDetail_back_btn);
        listViewOrderDetail = (ListView) findViewById(R.id.orderDetail_orderDetail_lv);
        txtTotal = (TextView) findViewById(R.id.orderDetail_totalPrice_txt);
        btnMain = (Button) findViewById(R.id.orderDetail_home_btn);


        getOrderDetail();

        orderDetails = new ArrayList<OrderDetail>();
        orderDetailAdapter = new OrderDetailAdapter(orderDetails, getApplicationContext());
        listViewOrderDetail.setAdapter(orderDetailAdapter);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDetailActivity.super.onBackPressed();
            }
        });


        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        listViewOrderDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtTotal.setText(decimalFormat.format(getIntent().getDoubleExtra("totalPrice", 0)) +" Đ");
    }

    private void getOrderDetail() {

        final int idOrder = getIntent().getIntExtra("idOrder", 0);
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.GET_ORDER_DETAIL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals(0)) {
                    Toast.makeText(OrderDetailActivity.this, "Tài khoản chưa đặt hàng", Toast.LENGTH_SHORT).show();
                }

                if (response != null) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            int idOrderDetail = jsonObject.getInt("id");
                            int idOrder = jsonObject.getInt("idOrder");
                            JSONObject product = jsonObject.getJSONObject("product");
                            getProduct(product);
                            int soLuong = jsonObject.getInt("quantity");
                            int donGia = product.getInt("donGia");
                            OrderDetail orderDetail = new OrderDetail(idOrder, idOrderDetail, donGia, soLuong, getProduct(product));
                            orderDetails.add(orderDetail);
                            orderDetailAdapter.notifyDataSetChanged();
                        }
                        ;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


            }

        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("idOrder", String.valueOf(idOrder));
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    private SanPham getProduct(JSONObject jsonObject) throws JSONException {

        int id = jsonObject.getInt("id");
        String name = jsonObject.getString("tenSp");
        int producerId = jsonObject.getInt("idNhaCungCap");
        int productCateId = jsonObject.getInt("idLoaiSanPham");
        double price = jsonObject.getDouble("donGia");
        int netWeight = jsonObject.getInt("khoiLuong");
        String roast = jsonObject.getString("cachRang");
        String image = jsonObject.getString("imageChinh");
        String shelfLife = jsonObject.getString("hanSuDung");
        String particleSize = jsonObject.getString("kichThuoc");
        String taste = jsonObject.getString("muivi");
        int quantity = jsonObject.getInt("soluong");
        String ingredient = jsonObject.getString("thanhphan");
        int sold = jsonObject.getInt("daban");
        int status = jsonObject.getInt("status");
        double promotion = jsonObject.getDouble("khuyenmai");
        SanPham sanPham = new SanPham(id, name, producerId, productCateId, price, netWeight, roast, image, shelfLife, particleSize, taste, quantity, ingredient, sold, status, promotion);
        return sanPham;
    }
}