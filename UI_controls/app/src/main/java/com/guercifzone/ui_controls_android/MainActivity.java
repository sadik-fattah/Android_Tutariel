package com.guercifzone.ui_controls_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.Buttons.*;
import com.guercifzone.ui_controls_android.Spinners.Activity_Sp_FillData_ArrayAdapter;
import com.guercifzone.ui_controls_android.Spinners.Activity_Sp_SelectionListener;
import com.guercifzone.ui_controls_android.TextViews.Activity_Autocomplete;
import com.guercifzone.ui_controls_android.Webviews.*;

public class MainActivity extends AppCompatActivity {
    private RadioButton  btnspinner,btntextview,btn_Button,btnWeb;

Button sp3,sp4;
Button txt1,txt2;
Button btn1,btn2,btn3,btn4,btn5;
Button web1,web2,web3,web4,web5,web6,web7;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout btntutariel = (LinearLayout)findViewById(R.id.buttontut);
        LinearLayout spinertutariel = (LinearLayout)findViewById(R.id.spinnertut);
        LinearLayout textviewtutariel = (LinearLayout)findViewById(R.id.textviewtut);
        LinearLayout webviewtuterial = (LinearLayout)findViewById(R.id.webviewtut);
        btnspinner =(RadioButton) findViewById(R.id.sptut);
        btntextview=(RadioButton) findViewById(R.id.txttut);
        btn_Button=(RadioButton) findViewById(R.id.btntut);
        btnWeb=(RadioButton) findViewById(R.id.webtut);
        sp3 = (Button) findViewById(R.id.spinner3);
        sp4 = (Button) findViewById(R.id.spnner4);
       txt1 = (Button)findViewById(R.id.autocoplettut);
       txt2 = (Button)findViewById(R.id.customfonttut);
       btn1 = (Button)findViewById(R.id.example1);
       btn2 = (Button)findViewById(R.id.example2);
       btn3 = (Button)findViewById(R.id.example3);
       btn4 = (Button)findViewById(R.id.example4);
       btn5 = (Button)findViewById(R.id.example5);
       web1 = (Button) findViewById(R.id.webview1);
       web2= (Button) findViewById(R.id.webview2);
       web3= (Button) findViewById(R.id.webview3);
       web4= (Button) findViewById(R.id.webview4);
       web5= (Button) findViewById(R.id.webview5);
       web6= (Button) findViewById(R.id.webview6);
       web7= (Button) findViewById(R.id.webview7);
       if (btnspinner.isChecked() == true){
           btntutariel.setVisibility(View.VISIBLE);
       } else if (btntextview.isChecked() == true) {
           spinertutariel.setVisibility(View.VISIBLE);
       } else if (btnspinner.isChecked() == true) {
           textviewtutariel.setVisibility(View.VISIBLE);
       } else if (btnWeb.isChecked() == true) {
           webviewtuterial.setVisibility(View.VISIBLE);
       }
  sp3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Spinner  Filldata Arrayadapter", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, Activity_Sp_SelectionListener.class));
    }
});
  sp4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Spinner  Selection Listener", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this, Activity_Sp_FillData_ArrayAdapter.class));
      }
  });
  txt1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Textview AutoComplete", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this, Activity_Autocomplete.class));
      }
  });
  txt2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Textview CutomFont", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this,Activity_Autocomplete.class));
      }
  });
  btn1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Image Button", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this,Activity_ImageButton.class));
      }
  });
  btn2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "RadioButton Statment", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this,Activity_RadioButon_statment.class));
      }
  });
  btn3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Simple RadioButton", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this,Activity_RadioButton.class));
      }
  });
  btn4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "RadioButton Get Data", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this,Activity_RadioButton_getdata.class));
      }
  });
  btn5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "ToggleButton", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this,Activity_ToggleButon.class));
      }
  });
  web1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Simple  Webview", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this, Activity_Webview.class));
      }
  });
  web2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Webview Embaded", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this, Activity_Webview_emabed.class));
      }
  });
  web3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Webview injection Code", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this, Activity_WebView_InjectElement.class));
      }
  });
  web4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Webview LoadEditText", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this, Activity_WebView_LoadEditText.class));
      }
  });
  web5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Webview Load Image", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this, Activity_Webview_LoadHtmlFile.class));
      }
  });
  web6.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Webview Download", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this, Activity_Webview_LoadImage.class));
      }
  });
  web7.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Webview LoadHtmlFile", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this,Activity_webviewDownload.class));
      }
  });
    }

}