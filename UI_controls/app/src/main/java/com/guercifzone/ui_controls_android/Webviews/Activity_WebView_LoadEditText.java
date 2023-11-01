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
    // "google.com","github.com/orgs/guercifzone/repositories","guercifzone-ar.blogspot.com"
    private AutoCompleteTextView autoCompleteTextView;
    private Button goButton;

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_load_edit_text);
autoCompleteTextView =(AutoCompleteTextView) findViewById(R.id.url_field);
goButton = (Button) findViewById(R.id.go_button);
webView =(WebView) findViewById(R.id.web_view);
ArrayAdapter<String> adapter = new ArrayAdapter<String >(this,
        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
        website);
autoCompleteTextView.setAdapter(adapter);
autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER){
            openbrowser();
            return true;
        }
        return false;
    }


});
    }
    static final  String[] website = new String[]{
            "google.com","github.com/orgs/guercifzone/repositories","guercifzone-ar.blogspot.com"
    };
private void openbrowser(){
    webView.loadUrl(autoCompleteTextView.getText().toString());
    webView.setWebViewClient(new WebViewClient());
    webView.getSettings().setJavaScriptEnabled(true);
    webView.requestFocus();

}
}