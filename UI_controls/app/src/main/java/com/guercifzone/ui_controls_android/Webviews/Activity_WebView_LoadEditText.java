package com.guercifzone.ui_controls_android.Webviews;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_WebView_LoadEditText extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;
    private Button goButton;

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_load_edit_text);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.url_field);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,website);
       autoCompleteTextView.setAdapter(adapter);
        goButton = (Button) findViewById(R.id.go_button);
        webView = (WebView) findViewById(R.id.web_view);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrowser();
            }
        });
        autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    openBrowser();
                    return true;
                }
                return false;
            }
        });
    }
    static final String[] website = new String[]{
            "google.com","github.com/orgs/guercifzone/repositories","guercifzone-ar.blogspot.com"
    };

    private void openBrowser(){
        webView.loadUrl(autoCompleteTextView.getText().toString());
        webView.setWebViewClient(new WebViewClient());
        webView.requestFocus();
    }
}