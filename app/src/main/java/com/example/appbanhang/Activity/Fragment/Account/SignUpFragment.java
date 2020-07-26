package com.example.appbanhang.Activity.Fragment.Account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.R;
import com.example.appbanhang.Util.Server;

import java.util.HashMap;
import java.util.Map;

public class SignUpFragment extends Fragment {

    private View rootView;
    private Button btnCreate, btnHome;

    private TextView titleText;
    private EditText edtFullName, edtUserName, edtPassword1, edtPassword2, edtEmail, edtPhone, edtAddress;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_signup, container, false);

        btnCreate = rootView.findViewById(R.id.signup_create_button);
        btnHome = rootView.findViewById(R.id.signup_home_button);
        titleText = rootView.findViewById(R.id.signup_title_text);
        edtFullName = rootView.findViewById(R.id.signup_fullname_txt);
        edtUserName = rootView.findViewById(R.id.signup_username_txt);
        edtPassword1 = rootView.findViewById(R.id.signup_password_txt);
        edtPassword2 = rootView.findViewById(R.id.signup_password_txt2);
        edtEmail = rootView.findViewById(R.id.signup_email_txt);
        edtAddress = rootView.findViewById(R.id.signup_address_txt);
        edtPhone = rootView.findViewById(R.id.signup_phone_txt);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtFullName.getText().toString().matches("") && !edtUserName.getText().toString().matches("") && !edtEmail.getText().toString().matches("") && !edtPhone.getText().toString().matches("") && !edtPassword1.getText().toString().matches("") && !edtAddress.getText().toString().matches("")) {
                    if (edtPassword1.getText().toString().equals(edtPassword2.getText().toString())) {
                        postDataUser();
                    } else {
                        Toast.makeText(getContext(), "Mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Vui lòng điền đẩy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    public void postDataUser() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.SIGNUP_LINK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("0")) {
                    Toast.makeText(getContext(), "Lỗi chưa xác định, vui lòng thử lại sau", Toast.LENGTH_SHORT).show();
                }

                if (response.equals("1")) {
                    Toast.makeText(getContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }
                if (response.equals("2")) {
                    Toast.makeText(getContext(), "Tồn tài tài khoản", Toast.LENGTH_SHORT).show();
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
                hashMap.put("username", edtUserName.getText().toString());
                hashMap.put("email", edtEmail.getText().toString());
                hashMap.put("phone", edtPhone.getText().toString());
                hashMap.put("password", edtPassword1.getText().toString());
                hashMap.put("address", edtAddress.getText().toString());
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

//    public void callNextSignupScreen(View view) {
//        Intent intent = new Intent(getContext(), SignUp2ndActivity.class);
//
//        //transition
//        Pair[] pairs = new Pair[4];
//
//        pairs[0] = new Pair<View, String>(backBtn, "transition_back_btn_signup");
////        pairs[1] = new Pair<View, String>(nextBtn, "transition_next_btn");
////        pairs[2] = new Pair<View, String>(loginBtn, "transition_login_btn");
//        pairs[3] = new Pair<View, String>(titleText, "signup_title_text");
//
//        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpActivity.this, pairs);
//        startActivity(intent, options.toBundle());
//    }

}
