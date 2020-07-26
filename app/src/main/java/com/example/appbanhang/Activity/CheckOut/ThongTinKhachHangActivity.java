package com.example.appbanhang.Activity.CheckOut;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang.Activity.Fragment.CartFragment;
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.JavaMailAPI.JavaMailAPI;
import com.example.appbanhang.Model.UserAccount;
import com.example.appbanhang.R;
import com.example.appbanhang.Session.SessionManager;
import com.example.appbanhang.Util.AccCountEmail;
import com.example.appbanhang.Util.CheckConnection;
import com.example.appbanhang.Util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ThongTinKhachHangActivity extends AppCompatActivity {
    private EditText editTextTen, edtEmail, edtSdt, edtDiaChi, edtNote;
    private Button btnXacNhan, btnLogin;
    private ImageView btnTroVe;
    private SessionManager sessionManager;
    private String accId;
    private HashMap<String, String> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khach_hang);
        khoiTao();
        user = sessionManager.getUserDetail();
        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (CheckConnection.haveNetworkConnection(ThongTinKhachHangActivity.this)) {
            eventButton();
        } else {
            CheckConnection.showToastShort(getApplicationContext(), "Kiểm tra kết nối Internet");
        }

        if (isLogin()) {
            fillData();
        }
        else
            btnLogin.setVisibility(View.VISIBLE);
    }

    private void fillData() {
        editTextTen.setText(user.get(sessionManager.NAME));
        edtSdt.setText(user.get(sessionManager.PHONE));
        edtDiaChi.setText(user.get(sessionManager.ADDRESS));
        edtEmail.setText(user.get(sessionManager.EMAIL));
        btnLogin.setVisibility(View.INVISIBLE);
    }

    private void eventButton() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ten = editTextTen.getText().toString().trim();
                final String sdt = edtSdt.getText().toString().trim();
                final String email = edtEmail.getText().toString().trim();
                final String address = edtDiaChi.getText().toString().trim();
                final String note = edtNote.getText().toString();
                if (ten.length() > 0 && sdt.length() > 0 && email.length() > 0 && address.length() > 0) {
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.INFOR_CUSTOMER_LINK, new Response.Listener<String>() {
                        @Override
                        public void onResponse(final String maKhachHang) {
                            if (Integer.parseInt(maKhachHang) > 0) {
                                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                                StringRequest request = new StringRequest(Request.Method.POST, Server.ORDER_LINK, new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String maDonHang) {
                                        xuLyChiTietDonHang(maDonHang, ten, email);
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                    }
                                }) {
                                    @Override
                                    protected Map<String, String> getParams() throws AuthFailureError {
                                        HashMap<String, String> hashMap = new HashMap<String, String>();
                                        hashMap.put("maKhachHang", maKhachHang);
                                        hashMap.put("totalPrice", CartFragment.tongtien + "");
                                        hashMap.put("note", note);
                                        if (isLogin()) {
                                            hashMap.put("accId", accId);
                                        } else {
                                            hashMap.put("accId", null);
                                        }

                                        return hashMap;
                                    }
                                };
                                queue.add(request);
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> hashMap = new HashMap<String, String>();
                            hashMap.put("tenkhachhang", ten);
                            hashMap.put("email", email);
                            hashMap.put("diaChi", address);
                            hashMap.put("sodienthoai", sdt);
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                } else {
                    CheckConnection.showToastShort(getApplicationContext(), "Kiểm tra dữ liệu");
                }
            }
        });
    }


    private boolean isLogin() {

        sessionManager.isLogin();

        if (sessionManager.isLogin()) {
            String mName = user.get(sessionManager.NAME);
            String mEmail = user.get(sessionManager.EMAIL);
            accId = user.get(sessionManager.ID_USER);
            return true;
        }
        return false;

    }

    private void xuLyChiTietDonHang(final String maDonHang, final String ten, final String emailCustomer) {
        if (Integer.parseInt(maDonHang) > 0) {
            UserAccount user = new UserAccount(0, null, editTextTen.getText().toString(), edtSdt.getText().toString(), edtDiaChi.getText().toString(), edtEmail.getText().toString());
            final ContentEmail contentEmail = new ContentEmail(MainActivity.mangGioHang, edtNote.getText().toString(), maDonHang, user);
            RequestQueue queueChiTietDonHang = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequestChiTietDonHang = new StringRequest(Request.Method.POST, Server.ORDER_DETAIL_LINK, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("1")) {
                        String messsage = "";

                        for (int i = 0; i < MainActivity.mangGioHang.size(); i++) {

                        }
                        messsage = contentEmail.ContentEmailHtml();
                        JavaMailAPI javaMailAPI = new JavaMailAPI(ThongTinKhachHangActivity.this, emailCustomer, AccCountEmail.SUBJECT, messsage, 0);
                        javaMailAPI.execute();


                        MainActivity.mangGioHang.clear();
                        CheckConnection.showToastShort(ThongTinKhachHangActivity.this, "Đặt hàng thành công");
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        CheckConnection.showToastShort(getApplicationContext(), "Lỗi hệ thống");
                        Log.d("LoiChiTietDonHang", response);
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    JSONArray jsonArray = new JSONArray();
                    for (int i = 0; i < MainActivity.mangGioHang.size(); i++) {
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("madonhang", Integer.parseInt(maDonHang));
                            jsonObject.put("masanpham", MainActivity.mangGioHang.get(i).getIdSp());
                            int donGiaSp = (int) (MainActivity.mangGioHang.get(i).getGiaSp() / MainActivity.mangGioHang.get(i).getSoLuong());
                            jsonObject.put("soluong", MainActivity.mangGioHang.get(i).getSoLuong());
                            jsonObject.put("giasanpham", donGiaSp);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        jsonArray.put(jsonObject);
                    }
                    HashMap<String, String> hashMap = new HashMap<String, String>();
                    hashMap.put("json", jsonArray.toString());
                    Log.d("Param", jsonArray.toString());
                    return hashMap;
                }
            };
            queueChiTietDonHang.add(stringRequestChiTietDonHang);

        } else {
            CheckConnection.showToastShort(getApplicationContext(), "Lỗi dữ liệu !!!");
        }
    }

    private void khoiTao() {
        editTextTen = (EditText) findViewById(R.id.checkout_fullname_txt);
        edtEmail = (EditText) findViewById(R.id.checkout_email_txt);
        edtSdt = (EditText) findViewById(R.id.checkout_phone_txt);
        edtDiaChi = (EditText) findViewById(R.id.checkout_address_txt);
        edtNote = (EditText) findViewById(R.id.checkout_note_txt);
        btnXacNhan = (Button) findViewById(R.id.checkout_ok_btn);
        btnTroVe = (ImageView) findViewById(R.id.checkout_back_btn);
        btnLogin = (Button) findViewById(R.id.checkout_login_btn);
        sessionManager = new SessionManager(this);
    }

}
