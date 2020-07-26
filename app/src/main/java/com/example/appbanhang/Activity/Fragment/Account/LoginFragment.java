package com.example.appbanhang.Activity.Fragment.Account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
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

import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.Model.UserAccount;
import com.example.appbanhang.R;
import com.example.appbanhang.Session.SessionManager;
import com.example.appbanhang.Util.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends Fragment {

    private View rootView;

    private ImageView buttonBack;
    private Button btnLogin, btnSignUp;
    private EditText edtUserName, edtPassword;
    private SessionManager sessionManager;
    private CheckBox cbRemember;

    public static UserAccount userAccount;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        khoiTao();
        eventButton();
        return rootView;
    }


    private void eventButton() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("flag", "SINGUP");
                startActivity(intent);
            }
        });

    }

    private void login() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.LOGIN_LINK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("0")) {
                    Toast.makeText(getContext(), "Không tồn tại tài khoản", Toast.LENGTH_SHORT).show();
                }

                if (response.equals("2")) {
                    Toast.makeText(getContext(), "Sai mật khẩu", Toast.LENGTH_SHORT).show();
                }
                if (response != null && response.length() != 0) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String name = jsonObject.getString("name");
                        String fullName = jsonObject.getString("fullName");
                        String email = jsonObject.getString("emailAddress");
                        String address = jsonObject.getString("address");
                        String phone = jsonObject.getString("phoneNumber");
                        int id = jsonObject.getInt("id");
                        sessionManager.createSession(id, fullName, email, address, phone);
                        Intent i = new Intent(getContext(), MainActivity.class);
                        startActivity(i);
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
                hashMap.put("username", edtUserName.getText().toString());
                hashMap.put("password", edtPassword.getText().toString());
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }


    private void khoiTao() {
        cbRemember = rootView.findViewById(R.id.login_savepass_checkbox);
        edtUserName = rootView.findViewById(R.id.login_username_edt);
        edtPassword = rootView.findViewById(R.id.login_password_edt);
        btnSignUp = rootView.findViewById(R.id.login_signup_btn);
        btnLogin = rootView.findViewById(R.id.login_login_btn);
        sessionManager = new SessionManager(getContext());
    }
}
