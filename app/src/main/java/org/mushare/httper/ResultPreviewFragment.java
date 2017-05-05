package org.mushare.httper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.UnsupportedEncodingException;

/**
 * Created by dklap on 5/4/2017.
 */

public class ResultPreviewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        WebView webview = (WebView) inflater.inflate(R.layout.fragment_preview_result, container,
                false);
        webview.setInitialScale(1);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        Bundle bundle = getArguments();
        byte[] data;
        if (bundle != null && (data = bundle.getByteArray("content")) != null)
            try {
                webview.loadDataWithBaseURL(bundle.getString("baseUrl"), new String(data,
                        "UTF-8"), "text/html", null, null);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        return webview;
    }
}
