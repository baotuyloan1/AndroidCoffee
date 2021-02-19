package com.example.appbanhang.Activity.Category;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang.Activity.ChiTietSanPhamActivity;
import com.example.appbanhang.Adapter.CategoryAdapter.CoffeeAdapter;
import com.example.appbanhang.Model.SanPham;
import com.example.appbanhang.R;
import com.example.appbanhang.Util.CheckConnection;
import com.example.appbanhang.Util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoffeeActivity extends AppCompatActivity {

    private Toolbar toolBarCoffee;
    private ListView lvCoffee;
    private CoffeeAdapter coffeeAdapter;
    private ArrayList<SanPham> mangCoffee;
    private View footerView;
    int idCoffee = 0;
    int page = 1;
    private boolean isLoading;
    private mHandler mHandler;
    private boolean limitData = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        khoiTao();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getIdLoaiSanPham();
            actionToolBar();
            getData(page);
            loadMoreData();

        } else {
            CheckConnection.showToastShort(getApplicationContext(), "Bạn hãy kiểm tra lại Internet");
            finish();
        }
    }

    private void loadMoreData() {
        lvCoffee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(CoffeeActivity.this, ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham", mangCoffee.get(position));
                startActivity(intent);

            }
        });

        lvCoffee.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //nếu vị trí đầu tiên + só lượng ta có thể nhìn thấy trong cái item của mình = totalItemcount  thì nó đứng ở vị trí cuối cùng
                //total lần đầu tiên run lên = 0
                //cờ isLoading tránh kéo liên tục -> die app
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0 && isLoading == false && limitData == false) {
                    isLoading = true;
                    ThreadData threadData = new ThreadData();
                    threadData.start();
                }
            }
        });
    }

    private void getData(int page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongDan = Server.COFFEE_LINK + String.valueOf(page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongDan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null && response.length() != 2) {
                    lvCoffee.removeFooterView(footerView);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int id = jsonObject.getInt("id");
                            String tenSp = jsonObject.getString("tenSp");
                            int idNhaCungCap = jsonObject.getInt("idNhaCungCap");
                            int idLoaiSanPham = jsonObject.getInt("idLoaiSanPham");
                            double donGia = jsonObject.getDouble("donGia");
                            int khoiLuong = jsonObject.getInt("khoiLuong");
                            String cachRang = jsonObject.getString("cachRang");
                            String img = jsonObject.getString("imageChinh");
                            String hanSuDung = jsonObject.getString("hanSuDung");
                            String kichThuoc = jsonObject.getString("kichThuoc");
                            String muivi = jsonObject.getString("muivi");
                            int soluong = jsonObject.getInt("soluong");
                            String thanhphan = jsonObject.getString("thanhphan");
                            int daban = jsonObject.getInt("daban");
                            int status = jsonObject.getInt("status");
                            double khuyenmai = jsonObject.getDouble("khuyenmai");
                            mangCoffee.add(new SanPham(id, tenSp, idNhaCungCap, idLoaiSanPham, donGia,
                                    khoiLuong, cachRang, img, hanSuDung, kichThuoc, muivi,
                                    soluong, thanhphan, daban, status, khuyenmai));
                        }
                        coffeeAdapter = new CoffeeAdapter(CoffeeActivity.this, mangCoffee);
                        lvCoffee.setAdapter(coffeeAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    limitData = true;
                    lvCoffee.removeFooterView(footerView);
                    CheckConnection.showToastShort(getApplicationContext(), "Đã hết dữ liệu");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("idloaisanpham", idCoffee + "");
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void actionToolBar() {
        setSupportActionBar(toolBarCoffee);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBarCoffee.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getIdLoaiSanPham() {
        idCoffee = getIntent().getIntExtra("idLoaiSanPham", -1);
        Log.d("Giá trị loại sản phẩm", idCoffee + "");
    }

    private void khoiTao() {
        toolBarCoffee = findViewById(R.id.toolBarCoffee);
        lvCoffee = findViewById(R.id.listViewCoffee);
        mangCoffee = new ArrayList<>();
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerView = inflater.inflate(R.layout.progressbar, null);
        mHandler = new mHandler();
    }


    public class mHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 0:
                    lvCoffee.addFooterView(footerView);
                    break;
                case 1:
                    getData(++page);
                    isLoading = false;
                    break;
            }
            super.handleMessage(msg);
        }
    }

    public class ThreadData extends Thread {
        @Override
        public void run() {
            //gửi msg = 0 cho handle
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //obtainMessage là 1 phương thức liên kết các thread với handle
            //liên kết tiếp nên phải dùng cái này
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchSp).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(CoffeeActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                coffeeAdapter.filter(newText.trim());
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}
