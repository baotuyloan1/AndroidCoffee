package com.example.appbanhang.Activity.Fragment.Info;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang.Adapter.InforAdapter.OrderAdapter;
import com.example.appbanhang.Model.Order;
import com.example.appbanhang.R;
import com.example.appbanhang.Session.SessionManager;
import com.example.appbanhang.Util.CheckConnection;
import com.example.appbanhang.Util.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderFragment extends Fragment {

    private ArrayList<Order> orders;
    private ListView listViewOrder;
    private OrderAdapter orderAdapter;
    private HashMap<String, String> user;
    private SessionManager sessionManager;

    private TextView txtName, txtPhone, txtAdress, txtEmail;


    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_order, container, false);

        if (CheckConnection.haveNetworkConnection(getContext())) {

            sessionManager = new SessionManager(getContext());
            user = sessionManager.getUserDetail();

            listViewOrder = rootView.findViewById(R.id.order_order_listview);
            txtName = rootView.findViewById(R.id.order_fullname_txt);
            txtPhone = rootView.findViewById(R.id.order_phone_txt);
            txtAdress = rootView.findViewById(R.id.order_address_txt);
            txtEmail = rootView.findViewById(R.id.order_email_txt);

            orders = new ArrayList<Order>();
            orderAdapter = new OrderAdapter(orders, getContext());
            listViewOrder.setAdapter(orderAdapter);

            getInfo();

            getOrder();

        }
        return rootView;
    }



    private void getOrder() {


        Log.d("USER_ID", user.get(sessionManager.ID_USER));
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.GET_ORDER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("RESPONSE", response);
                if (response.equals(0)) {
                    Toast.makeText(getContext(), "Không tồn tại tài khoản", Toast.LENGTH_SHORT).show();
                }
                if (response != null) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            int id = jsonObject.getInt("id");
                            int userId = jsonObject.getInt("cusId");
                            String dateOrder = jsonObject.getString("created_at");
                            Double totalPrice = jsonObject.getDouble("totalPrice");
                            String note = jsonObject.getString("note");
                            if (note.equals(null)) {
                                note = "Không có ghi chú";
                            } else {
                                note = jsonObject.getString("note");
                            }
                            int status = jsonObject.getInt("status");
                            int accId = jsonObject.getInt("accId");
                            orders.add(new Order(id, status, totalPrice, dateOrder, note, userId, accId));
                            orderAdapter.notifyDataSetChanged();
                            Log.d("OrderHistory", "order :" + id);

                        }
                        showOrder();
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
                hashMap.put("accId", user.get(sessionManager.ID_USER));
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);

//        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Server.GET_ORDER, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                Toast.makeText(OrderActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
//                Log.d("JSON_OBJECT",response.toString());
////                try {
////                    JSONArray jsonArray = response.getJSONArray(null);
////                    JSONObject jsonObject = null;
////                    ArrayList<Double> mangNhietDo = new ArrayList<>();
////                    int ptCuoiCung = 0;
////                    for (int a = 0; a < jsonArray.length(); a++) {
////                        jsonObject = jsonArray.getJSONObject(a);
////                        mangNhietDo.add(jsonObject.getDouble("nhietdo"));
////                        mangDoAm.add(jsonObject.getDouble("doam"));
////                        if (a == 19) {
////                            trangThai = jsonObject.getInt("chedo");
////                            Log.d("trangthai", trangThai + "");
////                            if (trangThai == 0) {
////                                textView.setText("off");
////                                if (flagSwitch == false) {
////                                    if (cheDoCu == 1) {
////                                        btnOn.setVisibility(View.VISIBLE);
////                                        btnOff.setVisibility(View.INVISIBLE);
////                                    }
////                                }
////                            }
////                            if (trangThai == 1) {
////                                textView.setText("on");
////                                if (flagSwitch == false) {
////                                    if (cheDoCu == 0) {
////                                        textView.setText("on");
////                                        btnOn.setVisibility(View.INVISIBLE);
////                                        btnOff.setVisibility(View.VISIBLE);
////                                    }
////                                }
////                            }
////                            setSuKien(trangThai, mangNhietDo.get(a), mangDoAm.get(a));
////                        }
////                    }
////                    graphDoAm(mangDoAm);
////                    graphNhietDo(mangNhietDo);
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        })
//            {
//                @Override
//                protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> hashMap = new HashMap<String, String>();
//                hashMap.put("accId",user.get(sessionManager.ID_USER));
//                return hashMap;
//            }
//        };
//        requestQueue.add(jsonObjectRequest);

    }

    private void showOrder() {
//        Toast.makeText(this, orders.size(), Toast.LENGTH_SHORT).show();
    }

    private void getInfo() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.GET_INFO_LINK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("1")) {
                    Toast.makeText(getContext(), "Không tồn tại tài khoản", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String username = jsonObject.getString("name");
                        String fullName = jsonObject.getString("fullName");
                        String email = jsonObject.getString("emailAddress");
                        String address = jsonObject.getString("address");
                        String phone = jsonObject.getString("phoneNumber");


                        txtName.setText(fullName);
                        txtEmail.setText(email);
                        txtAdress.setText(address);
                        txtPhone.setText(phone);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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
                hashMap.put("idAccount", user.get(sessionManager.ID_USER));
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }


}
