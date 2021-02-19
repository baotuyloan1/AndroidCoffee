package com.example.appbanhang.Activity.Fragment;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.Activity.MapsActivity;
import com.example.appbanhang.Adapter.HomeAdapter.ProductDiscountAdapter;
import com.example.appbanhang.Adapter.HomeAdapter.ProductNewAdapter;
import com.example.appbanhang.Adapter.HomeAdapter.ProductSoldAdapter;
import com.example.appbanhang.Model.SanPham;
import com.example.appbanhang.R;
import com.example.appbanhang.Util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    //View
    private View rootView;
    private RelativeLayout mainMapIcon;
    private RelativeLayout mainContactIcon;
    private RelativeLayout mainShowMoreIcon;
    private RelativeLayout mainTinTucIcon;
    //Recycler
    private RecyclerView productNewRecycler;
    private RecyclerView productDiscountRecycler;
    private RecyclerView productSoldRecycler;

    //Adapter
    private ProductNewAdapter sanPhamMoiAdapter;
    private ProductDiscountAdapter sanPhamKhuyenMaiAdapter;
    private ProductSoldAdapter sanPhamBanChayAdapter;


    //Mang
    private ArrayList<SanPham> mangSanPhamMoi;
    private ArrayList<SanPham> mangSanPhamKhuyenMai;
    private ArrayList<SanPham> mangSanPhamBanChay;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        productNewRecycler = rootView.findViewById(R.id.products_new_recycler);
        productDiscountRecycler = rootView.findViewById(R.id.products_discount_recycler);
        productSoldRecycler = rootView.findViewById(R.id.main_spbanchay_recycler);

        mainMapIcon = (RelativeLayout) rootView.findViewById(R.id.main_relative_map_btn);
        mainContactIcon = (RelativeLayout) rootView.findViewById(R.id.main_relative_contact_btn);
        mainShowMoreIcon = (RelativeLayout) rootView.findViewById(R.id.main_show_relative);
        mainTinTucIcon = (RelativeLayout)rootView.findViewById(R.id.main_relative_tintuc_btn);

        productNewRecycler();
        productDiscountRecycler();
        productSoldRecycler();

        mainContactIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactFragment contactFragment = new ContactFragment();
                FragmentManager fragmentManager = ((MainActivity) getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_content_frame,contactFragment);
                fragmentTransaction.commit();
            }
        });

        mainMapIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Đã phát triển", Toast.LENGTH_SHORT).show();
            }
        });

        mainShowMoreIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllCategoryFragment fragment = new AllCategoryFragment();
                FragmentManager fragmentManager = ((MainActivity) getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_content_frame,fragment);
                fragmentTransaction.commit();
            }
        });

        mainTinTucIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProcessFragment processFragment = new ProcessFragment();
                FragmentManager fragmentManager = ((MainActivity) getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_content_frame,processFragment);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

    private void productDiscountRecycler() {
        productDiscountRecycler.setHasFixedSize(true);
        productDiscountRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mangSanPhamKhuyenMai = new ArrayList<SanPham>();
        getProductsDiscount();
        sanPhamKhuyenMaiAdapter = new ProductDiscountAdapter(mangSanPhamKhuyenMai, getContext());
        productDiscountRecycler.setAdapter(sanPhamKhuyenMaiAdapter);
    }


    private void productSoldRecycler() {
        productSoldRecycler.setHasFixedSize(true);
        productSoldRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mangSanPhamBanChay = new ArrayList<SanPham>();
        getProductsSold();
        sanPhamBanChayAdapter = new ProductSoldAdapter(mangSanPhamBanChay, getContext());
        productSoldRecycler.setAdapter(sanPhamBanChayAdapter);
    }


    private void productNewRecycler() {
        productNewRecycler.setHasFixedSize(true);
        productNewRecycler.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mangSanPhamMoi = new ArrayList<SanPham>();
        getProductsNew();
        sanPhamMoiAdapter = new ProductNewAdapter(mangSanPhamMoi, rootView.getContext());
        productNewRecycler.setAdapter(sanPhamMoiAdapter);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
    }

    private void getProductsNew() {
        RequestQueue requestQueue = Volley.newRequestQueue(rootView.getContext());
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.PRODUCTS_NEW_LINK, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = response.getJSONObject(i);
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
                            mangSanPhamMoi.add(new SanPham(id, name, producerId, productCateId, price, netWeight, roast, image, shelfLife, particleSize, taste, quantity, ingredient, sold, status, promotion));
                            sanPhamMoiAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                } else {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        requestQueue.add(jsonArrayRequest);
    }

    private void getProductsDiscount() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.PRODUCTS_DISCOUNT_LINK, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
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
                            mangSanPhamKhuyenMai.add(new SanPham(id, name, producerId, productCateId, price, netWeight, roast, image, shelfLife, particleSize, taste, quantity, ingredient, sold, status, promotion));
                            sanPhamKhuyenMaiAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void getProductsSold() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.PRODUCTS_SOLD_LINK, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = response.getJSONObject(i);
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
                            mangSanPhamBanChay.add(new SanPham(id, name, producerId, productCateId, price, netWeight, roast, image, shelfLife, particleSize, taste, quantity, ingredient, sold, status, promotion));
                            sanPhamBanChayAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                } else {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}
