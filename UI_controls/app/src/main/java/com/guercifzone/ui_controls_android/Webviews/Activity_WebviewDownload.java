package com.guercifzone.ui_controls_android.Webviews;

import android.Manifest;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.*;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_WebviewDownload extends AppCompatActivity {
WebView dwn;
    String url = "https://drive.google.com/file/d/1eb9weqJNtHQOAcrLQ3V0z0VKhPnKJILR/view?usp=sharing";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_download);
        dwn = (WebView) findViewById(R.id.webview_download);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED) {
                Log.d("permission", "permission denied to WRITE_EXTERNAL_STORAGE - requesting it");
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions, 1);
            }
        }
        dwn.setWebViewClient(new WebViewClient());
        dwn.getSettings().setLoadsImagesAutomatically(true);
        dwn.getSettings().setJavaScriptEnabled(true);
        dwn.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        dwn.loadUrl(url);
        dwn.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(url));
                request.setMimeType(mimeType);
                String cookies = CookieManager.getInstance().getCookie(url);
                request.addRequestHeader("cookie", cookies);
                request.addRequestHeader("User-Agent", userAgent);
                request.setDescription("Downloading File...");
                request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimeType));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(
                        Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(
                                url, contentDisposition, mimeType));
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getApplicationContext(), "Downloading File", Toast.LENGTH_LONG).show();

            }
        });
    }
}