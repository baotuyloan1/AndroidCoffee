package com.example.appbanhang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.appbanhang.Activity.Fragment.Account.SignUpFragment;
import com.example.appbanhang.Activity.Fragment.AllCategoryFragment;
import com.example.appbanhang.Activity.Fragment.CartFragment;
import com.example.appbanhang.Activity.Fragment.Account.LoginFragment;
import com.example.appbanhang.Activity.Fragment.ContactFragment;
import com.example.appbanhang.Activity.Fragment.Info.ChangeInfoFragment;
import com.example.appbanhang.Activity.Fragment.Info.ChangePasswordFragment;
import com.example.appbanhang.Activity.Fragment.Info.OrderFragment;
import com.example.appbanhang.Activity.Fragment.MainFragment;
import com.example.appbanhang.Model.GioHang;
import com.example.appbanhang.R;
import com.example.appbanhang.Session.SessionManager;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static float END_SCALE = 0.7f;


    public static ArrayList<GioHang> mangGioHang;
    private SessionManager sessionManager;
    private HashMap<String, String> user;


    private LinearLayout contentView;
    //Drawer Menu
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private TextView menu_slogan;


    private ImageView menuIcon;

    private ImageView cartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        if (mangGioHang != null) {
        } else {
            mangGioHang = new ArrayList<>();
        }

        sessionManager = new SessionManager(this);
        user = sessionManager.getUserDetail();


        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawerLayout);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.linearMain);
        menu_slogan = findViewById(R.id.menu_slogan);
        cartBtn = (ImageView) findViewById(R.id.main_cart_btn);


        navigationDrawer();


        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setCheckedItem(navigationView.getMenu().findItem(R.id.nav_cart));
                CartFragment fragment = new CartFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_content_frame, fragment);
                fragmentTransaction.commit();

            }
        });


        String flag = getIntent().getStringExtra("flag");
        if (flag != null) {
            if (flag.equals("HOME")) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = new MainFragment();
                fragmentTransaction.replace(R.id.main_content_frame, fragment);
                fragmentTransaction.commit();
            }
            if (flag.equals("LOGIN")) {
                if (isLogin()) {
                    navigationView.setCheckedItem(navigationView.getMenu().findItem(R.id.nav_home));
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Fragment fragment = new MainFragment();
                    fragmentTransaction.replace(R.id.main_content_frame, fragment);
                    fragmentTransaction.commit();
                } else {
                    cartBtn.setVisibility(View.INVISIBLE);
                    navigationView.setCheckedItem(navigationView.getMenu().findItem(R.id.nav_login));
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    LoginFragment fragment = new LoginFragment();
                    fragmentTransaction.replace(R.id.main_content_frame, fragment);
                    fragmentTransaction.commit();
                }
            }
            if (flag.equals("SIGNUP")) {
                cartBtn.setVisibility(View.INVISIBLE);
                navigationView.setCheckedItem(navigationView.getMenu().findItem(R.id.nav_signup));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SignUpFragment fragment = new SignUpFragment();
                fragmentTransaction.replace(R.id.main_content_frame, fragment);
                fragmentTransaction.commit();
            }

        } else {
            navigationView.setCheckedItem(navigationView.getMenu().findItem(R.id.nav_home));
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment fragment = new MainFragment();
            fragmentTransaction.replace(R.id.main_content_frame, fragment);
            fragmentTransaction.commit();
        }

//        //Menu
//
////        AnhXa();
//        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {


//
//
//            productNewRecycler();
//            productDiscountRecycler();

//            productSoldRecycler();

//
//        } else {
//            CheckConnection.showToastShort(getApplicationContext(), "Kiểm tra kết nối Internet");
//            finish();
//        }


    }


    private void navigationDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        Menu menu = navigationView.getMenu();

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        if (isLogin()) {
            Toast.makeText(this, "Đã đăng nhập", Toast.LENGTH_SHORT).show();
            menu.findItem(R.id.nav_login).setVisible(false);
            menu.findItem(R.id.nav_logout).setVisible(true);
            menu.findItem(R.id.nav_profile).setVisible(true);
            menu.findItem(R.id.nav_signup).setVisible(false);
            menu.findItem(R.id.nav_change_pass).setVisible(true);
            menu.findItem(R.id.nav_change_profile).setVisible(true);
        } else {
            Toast.makeText(this, "Chưa đăng nhập", Toast.LENGTH_SHORT).show();
            menu.findItem(R.id.nav_login).setVisible(true);
            menu.findItem(R.id.nav_logout).setVisible(false);
            menu.findItem(R.id.nav_profile).setVisible(false);
            menu.findItem(R.id.nav_signup).setVisible(true);
            menu.findItem(R.id.nav_change_pass).setVisible(false);
            menu.findItem(R.id.nav_change_profile).setVisible(false);
        }
        animateNavigationDrawer();
    }

    //animation cho menu and content
    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorAccent));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                //Scale the view based on current slide offset
                //Chia tỷ lệ khung nhìn dựa trên bù trượt hiện tại
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the view , accounting for the scaled width
                //Dịch chế độ xem, chiếm tỷ lệ chiều rộng
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);

            }
        });
    }

    //    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else
//            super.onBackPressed();
//
//    }
//
//

    private boolean isLogin() {

        sessionManager.isLogin();

        if (sessionManager.isLogin()) {
            String mName = user.get(sessionManager.NAME);
            String mEmail = user.get(sessionManager.EMAIL);
            return true;


        }
        return false;

    }
////
////
//
//    private void getCategoriesAll() {
//
//    }
//

//

//

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.nav_home:
                fragment = new MainFragment();
                break;
            case R.id.nav_coffee:
                fragment = new AllCategoryFragment();
                break;
            case R.id.nav_login:
                cartBtn.setVisibility(View.INVISIBLE);
                fragment = new LoginFragment();
                break;
            case R.id.nav_logout:
                sessionManager.logout();
                break;
            case R.id.nav_profile:
                fragment = new OrderFragment();
                break;

            case R.id.nav_signup:
                fragment = new SignUpFragment();
                break;
            case R.id.nav_lienhe:
                fragment = new ContactFragment();
                break;

            case R.id.nav_map:
                Intent intentMap = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intentMap);
                break;

            case R.id.nav_cart:
                fragment = new CartFragment();
                break;
            case R.id.nav_change_pass:
                fragment = new ChangePasswordFragment();
                break;
            case  R.id.nav_change_profile:
                fragment = new ChangeInfoFragment();
        }

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        if (fragment != null) {
            fragmentTransaction.replace(R.id.main_content_frame, fragment);
            fragmentTransaction.commit();
        }
        return true;
    }


//
//    private void GetDuLieuLoaiSp() {
//        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.duongDanLoaiSanPham, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                if (response != null) {
//                    for (int i = 0; i < response.length(); i++) {
//                        try {
//                            int id = 0;
//                            String tenLoaiSp = "";
//                            String moTaLoaiSp = "";
//                            int statusLoaiSp = 0;
//                            JSONObject jsonObject = response.getJSONObject(i);
//                            id = jsonObject.getInt("id");
//                            tenLoaiSp = jsonObject.getString("tenloaisp");
//                            moTaLoaiSp = jsonObject.getString("mota");
//                            statusLoaiSp = jsonObject.getInt("status");
//                            mangLoaiSp.add(new LoaiSp(id, tenLoaiSp, moTaLoaiSp, statusLoaiSp, Server.COFFEE_ICON_LINK));
//                            loaiSpAdapter.notifyDataSetChanged();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    mangLoaiSp.add(0, new LoaiSp(0, "TRANG CHÍNH", "Mô tả", 0, Server.HOME_ICON_LINK));
//                    mangLoaiSp.add(1, new LoaiSp(0, "LIÊN HỆ", "Mô tả", 0, Server.CONTACT_ICON_LINK));
//                    mangLoaiSp.add(2, new LoaiSp(0, "MAP", "Mô tả", 0, Server.MAP_ICON_LINK));
//                    if (user.get(sessionManager.NAME) != null) {
//                        String mName = user.get(sessionManager.NAME);
//                        String mEmail = user.get(sessionManager.EMAIL);
////                        CatchOnItemListView();
//                        mangLoaiSp.add(3, new LoaiSp(0, "THÔNG TIN", "Mô tả", 0, Server.INFO_ICON_LINK));
//                        mangLoaiSp.add(4, new LoaiSp(0, "ĐĂNG XUẤT", "Mô tả", 0, Server.SIGNOUT_ICON_LINK));
//                    } else {
//                        mangLoaiSp.add(3, new LoaiSp(0, "ĐĂNG KÝ", "Mô tả", 0, Server.REGISTRATION_ICON_LINK));
//                        mangLoaiSp.add(4, new LoaiSp(0, "ĐĂNG NHẬP", "Mô tả", 0, Server.LOGIN_ICON_LINK));
//                    }
//
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                CheckConnection.showToastShort(getApplicationContext(), error.toString());
//            }
//        });
//        requestQueue.add(jsonArrayRequest);
//    }
//
//    private void ActionViewFlipper() {
//        ArrayList<String> mangquangcao = new ArrayList<>();
//        mangquangcao.add("https://firebasestorage.googleapis.com/v0/b/bt-sict.appspot.com/o/images%2Fimages%2F1588859832122.jpg?alt=media&token=d1801570-9b45-4c0e-91fe-52a6d8fdd465");
//        mangquangcao.add("https://firebasestorage.googleapis.com/v0/b/bt-sict.appspot.com/o/images%2Fimages%2F1588859832122.jpg?alt=media&token=d1801570-9b45-4c0e-91fe-52a6d8fdd465");
//        for (int i = 0; i < mangquangcao.size(); i++) {
//            ImageView imageView = new ImageView(getApplicationContext());
//            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            viewFlipper.addView(imageView);
//        }
//        viewFlipper.setFlipInterval(5000);
//        viewFlipper.setAutoStart(true);
//        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
//        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
//        viewFlipper.setInAnimation(animation_slide_in);
//        viewFlipper.setOutAnimation(animation_slide_out);
//    }
//
//    private void ActionBar() {
//        setSupportActionBar(toolbar);
//        //cho biết đang chọn cái nào
//        navigationView.bringToFront();
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_open);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.setCheckedItem(R.id.nav_home);
//        Menu menu = navigationView.getMenu();
//        menu.findItem(R.id.nav_logout).setVisible(false);
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//
//    }
//
//    private void AnhXa() {
////        toolbar = (Toolbar) findViewById(R.id.toolBarManHinhChinh);
////        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
////        recyclerViewManHinhCHinh = (RecyclerView) findViewById(R.id.recyclerView);
////        navigationView = (NavigationView) findViewById(R.id.navigationView);
////        listViewManHinhChinh = (ListView) findViewById(R.id.listViewManHinhChinh);
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
//        mangLoaiSp = new ArrayList<>();
//        loaiSpAdapter = new LoaiSpAdapter(mangLoaiSp, getApplicationContext());
////        listViewManHinhChinh.setAdapter(loaiSpAdapter);
//        mangSanPham = new ArrayList<>();
//        sanPhamAdapter = new SanPhamAdapter(mangSanPham, this);
//        recyclerViewManHinhCHinh.setHasFixedSize(true);
//        recyclerViewManHinhCHinh.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
//        recyclerViewManHinhCHinh.setAdapter(sanPhamAdapter);
//        sessionManager = new SessionManager(this);
//        user = sessionManager.getUserDetail();
//        if (mangGioHang != null) {
//        } else {
//            mangGioHang = new ArrayList<>();
//        }
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.top_menu, menu);
//        MenuItem item = (MenuItem) menu.findItem(R.id.searchSp);
//        item.setVisible(false);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menuGioHang:
//                Intent intent = new Intent(this, GioHangActivity.class);
//                startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.nav_home:
//                break;
//            case R.id.nav_login:
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//                break;
//
//            case R.id.nav_map:
//                Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent1);
//                break;
//        }
//        int id = item.getItemId();
//        Toast.makeText(this, id + "", Toast.LENGTH_SHORT).show();
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }


}
