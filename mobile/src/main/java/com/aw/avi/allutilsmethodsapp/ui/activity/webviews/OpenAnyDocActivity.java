package com.aw.avi.allutilsmethodsapp.ui.activity.webviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.aw.avi.allutilsmethodsapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OpenAnyDocActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_any_doc);
        ButterKnife.bind(this);

        String url = "http://www.adobe" +
                ".com/content/dam/acom/en/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
        String googleDoc = "http://drive.google.com/viewerng/viewer?embedded=true&url=";


        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setPluginsEnabled(true);
        webView.getSettings().setAllowFileAccess(true);

//        String doc="<iframe src='http://docs.google.com/viewer?url=+location to your PDF File+'
//        width='100%' height='100%'
//        style='border: none;'></iframe>";


        final Activity activity = this;

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                activity.setProgress(progress * 1000);
            }
        });


        webView.loadUrl(googleDoc + url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }


        });
    }
}
