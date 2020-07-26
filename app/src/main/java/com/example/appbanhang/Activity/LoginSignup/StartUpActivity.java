package com.example.appbanhang.Activity.LoginSignup;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.appbanhang.Activity.Fragment.MainFragment;
import com.example.appbanhang.Activity.MainActivity;
import com.example.appbanhang.R;
import com.example.appbanhang.Session.SessionManager;

import java.util.HashMap;

public class StartUpActivity extends AppCompatActivity {

    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        btnRegister = (Button) findViewById(R.id.start_signup_btn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("flag","SIGNUP");
                startActivity(intent);

            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void callLoginScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("flag","LOGIN");
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.start_login_btn), "transition_login");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(StartUpActivity.this, pairs);
        startActivity(intent, options.toBundle());
    }

    public void continueWithoutAcc(View view) {
        SessionManager sessionManager = new SessionManager(StartUpActivity.this);
        HashMap<String, String> user = sessionManager.getUserDetail();

        if (sessionManager.isLogin()) {
            sessionManager.logout();
        }

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("flag","HOME");
        startActivity(intent);



        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.start_continue_btn), "continue");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(StartUpActivity.this, pairs);

//        startActivity(intent, options.toBundle());




        startActivity(intent);
//        finish();
    }
}