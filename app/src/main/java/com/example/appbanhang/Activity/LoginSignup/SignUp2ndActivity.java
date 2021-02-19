package com.example.appbanhang.Activity.LoginSignup;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbanhang.R;

public class SignUp2ndActivity extends AppCompatActivity {
    private ImageView backBtn;
    private Button nextBtn, loginBtn;
    TextView titleText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2nd);


        backBtn = findViewById(R.id.signup_back_button);
        nextBtn = findViewById(R.id.signup_next_button);
        loginBtn = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
    }
    public void callNextSignupScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUp2ndActivity.class);

        //transition
        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View, String>(backBtn, "transition_back_btn_signup");
        pairs[1] = new Pair<View, String>(nextBtn, "transition_next_btn");
        pairs[2] = new Pair<View, String>(loginBtn, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "signup_title_text");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2ndActivity.this, pairs);
        startActivity(intent, options.toBundle());
    }
}