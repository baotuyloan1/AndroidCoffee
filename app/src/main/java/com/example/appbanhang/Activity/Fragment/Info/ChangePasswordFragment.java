package com.example.appbanhang.Activity.Fragment.Info;

import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
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
import com.example.appbanhang.Session.SessionManager;
import com.example.appbanhang.Util.CheckConnection;
import com.example.appbanhang.Util.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangePasswordFragment extends Fragment {

    private View rootView;

    private EditText editTextPassOld, editTextPassNew, editTextPassNew1;
    private Button btnChange;

    private SessionManager sessionManager;
    private HashMap<String, String> user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_change_password, container, false);
        if (CheckConnection.haveNetworkConnection(getContext())) {
            sessionManager = new SessionManager(getContext());
            user = sessionManager.getUserDetail();

            editTextPassOld = (EditText) rootView.findViewById(R.id.change_passsword_pass_old);
            editTextPassNew = (EditText) rootView.findViewById(R.id.change_password_pass_new_edt);
            editTextPassNew1 = (EditText) rootView.findViewById(R.id.change_password_pass_new1_edt);
            btnChange = (Button) rootView.findViewById(R.id.change_password_btn);


            btnChange.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!editTextPassNew.getText().toString().equals(editTextPassNew1.getText().toString())) {
                        Toast.makeText(getContext(), "2 mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
                    } else {
                        getInfo();
                    }
                }
            });


        }
        return rootView;
    }


    private void getInfo() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.CHECK_PASS_BY_ID_LINK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("0")) {
                    Toast.makeText(getContext(), "Không tồn tại tài khoản", Toast.LENGTH_SHORT).show();
                }
                if (response.equals("2")) {
                    Toast.makeText(getContext(), "Mật khẩu cũ không chính xác", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        //                        String username = jsonObject.getString("name");
                        //                        String fullName = jsonObject.getString("fullName");
                        //                        String email = jsonObject.getString("emailAddress");
                        //                        String address = jsonObject.getString("address");
                        //                        String phone = jsonObject.getString("phoneNumber");
                        //                        String passOld  = editTextPassOld.getText().toString();
                        changePassword();
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
                hashMap.put("password", editTextPassOld.getText().toString());
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void changePassword() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.CHANGE_PASS_LINK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("1")) {
                    Toast.makeText(getContext(), "Thay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    showDialog();
                } else {
                    Toast.makeText(getContext(), "Thay đổi thất bại " + response, Toast.LENGTH_SHORT).show();

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
                hashMap.put("password", editTextPassNew.getText().toString());
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void showDialog() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        sessionManager.logout();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        startActivity(new Intent(getContext(), MainActivity.class));
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Bạn có muốn đăng xuất").setPositiveButton("Có", dialogClickListener)
                .setNegativeButton("Không", dialogClickListener).show();
    }
}
