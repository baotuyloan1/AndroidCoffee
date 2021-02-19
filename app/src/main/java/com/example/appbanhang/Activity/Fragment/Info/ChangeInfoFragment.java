package com.example.appbanhang.Activity.Fragment.Info;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang.Activity.Fragment.MainFragment;
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.R;
import com.example.appbanhang.Session.SessionManager;
import com.example.appbanhang.Util.CheckConnection;
import com.example.appbanhang.Util.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangeInfoFragment extends Fragment {


    private EditText edtFullName, edtUserName, edtAddress, edtEmail, edtPhone;
    private Button btnChange;
    private View rootView;

    private SessionManager sessionManager;
    private HashMap<String, String> user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_change_info, container, false);

        if (CheckConnection.haveNetworkConnection(getContext())) {
            sessionManager = new SessionManager(getContext());
            user = sessionManager.getUserDetail();

            edtFullName = (EditText) rootView.findViewById(R.id.change_fullname_edt);
            edtAddress = (EditText) rootView.findViewById(R.id.change_address_edt);
            edtEmail = (EditText) rootView.findViewById(R.id.change_email_edt);
            edtPhone = (EditText) rootView.findViewById(R.id.change_phone_edt);
            btnChange = (Button) rootView.findViewById(R.id.change_info_btn);
            edtUserName = (EditText) rootView.findViewById(R.id.change_username_edt);

//            edtFullName.setText(user.get(sessionManager.NAME));
//            edtAddress.setText(user.get(sessionManager.ADDRESS));
//            edtEmail.setText(user.get(sessionManager.EMAIL));
//            edtPhone.setText(user.get(sessionManager.PHONE));

            getInfo();
            edtUserName.setEnabled(false);


            btnChange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeInfo();
                    getInfo();
                }
            });
        }
        return rootView;
    }

    private void changeInfo() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.CHANGE_INFO_LINK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("1")) {
                    Toast.makeText(getContext(), "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(getContext(), MainActivity.class));


                } else {
                    Toast.makeText(getContext(), "Cập nhật thất bại " + response.toString(), Toast.LENGTH_SHORT).show();
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
                hashMap.put("fullname", edtFullName.getText().toString());
                hashMap.put("email", edtEmail.getText().toString());
                hashMap.put("phone", edtPhone.getText().toString());
                hashMap.put("address", edtAddress.getText().toString());
                hashMap.put("idAccount", user.get(sessionManager.ID_USER));
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
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

                        edtUserName.setText(username);
                        edtFullName.setText(fullName);
                        edtEmail.setText(email);
                        edtAddress.setText(address);
                        edtPhone.setText(phone);
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
