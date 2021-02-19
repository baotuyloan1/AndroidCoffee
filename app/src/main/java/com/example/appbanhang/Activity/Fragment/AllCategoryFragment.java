package com.example.appbanhang.Activity.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang.Adapter.CategoryAdapter.LoaiSpAdapter;
import com.example.appbanhang.Model.LoaiSp;
import com.example.appbanhang.R;
import com.example.appbanhang.Util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AllCategoryFragment extends Fragment {

    private View rootView;

    private ListView listViewCategories;
    private ArrayList<LoaiSp> mangLoaiSanPham;


    private LoaiSpAdapter loaiSpAdapter;
    private ImageView search;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_all_category, container, false);


        listViewCategories = rootView.findViewById(R.id.listViewCategoriesPage);
        mangLoaiSanPham = new ArrayList<LoaiSp>();
        loaiSpAdapter = new LoaiSpAdapter(mangLoaiSanPham, getContext());

        getDuLieuLoaiSp();
        listViewCategories.setAdapter(loaiSpAdapter);



        return rootView;
    }


    private void getDuLieuLoaiSp() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.PRODUCT_CATE_LINK, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            int id = 0;
                            String tenLoaiSp = "";
                            String moTaLoaiSp = "";
                            int statusLoaiSp = 0;
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenLoaiSp = jsonObject.getString("tenloaisp");
                            moTaLoaiSp = jsonObject.getString("mota");
                            statusLoaiSp = jsonObject.getInt("status");
                            mangLoaiSanPham.add(new LoaiSp(id, tenLoaiSp, moTaLoaiSp, statusLoaiSp, "https://firebasestorage.googleapis.com/v0/b/bt-sict.appspot.com/o/categories_robustar_icon.png?alt=media&token=024c6880-5021-4045-8c8b-30c3b0dbd405"));
                            loaiSpAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

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
