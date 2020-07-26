package com.example.appbanhang.Activity.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appbanhang.Adapter.CategoryAdapter.LoaiSpAdapter;
import com.example.appbanhang.Model.LoaiSp;
import com.example.appbanhang.R;

import java.util.ArrayList;

public class ProcessFragment extends Fragment {
    private View rootView;
    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_process, container, false);

        webView = (WebView)rootView.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://seedtomysoul.com/");


        return rootView;
    }
}
