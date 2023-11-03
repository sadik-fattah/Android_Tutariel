package com.guercifzone.ui_controls_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.Bars.*;
import com.guercifzone.ui_controls_android.Buttons.*;
import com.guercifzone.ui_controls_android.Spinners.Activity_Sp_FillData_ArrayAdapter;
import com.guercifzone.ui_controls_android.Spinners.Activity_Sp_SelectionListener;
import com.guercifzone.ui_controls_android.TextViews.Activity_Autocomplete;
import com.guercifzone.ui_controls_android.Webviews.*;

public class MainActivity extends AppCompatActivity  implements CompoundButton.OnCheckedChangeListener{
    private RadioButton  btnspinner,btntextview,btn_Button,btnWeb,btnBars;
private LinearLayout btntutariel,spinertutariel,textviewtutariel,webviewtuterial,progressbartuterial;
Button sp3,sp4;
Button txt1,txt2;
Button btn1,btn2,btn3,btn4,btn5;
Button web1,web2,web3,web4,web5,web6,web7;
Button  prog1,prog2,prog3,prog4,prog5,prog6;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //layout
        btntutariel = (LinearLayout)findViewById(R.id.buttontut);
        spinertutariel = (LinearLayout)findViewById(R.id.spinnertut);
         textviewtutariel = (LinearLayout)findViewById(R.id.textviewtut);
        webviewtuterial = (LinearLayout)findViewById(R.id.webviewtut);
        progressbartuterial = (LinearLayout)findViewById(R.id.progressbartut);

      //radio button
        btnspinner =(RadioButton) findViewById(R.id.sptut);
        btntextview=(RadioButton) findViewById(R.id.txttut);
        btn_Button=(RadioButton) findViewById(R.id.btntut);
        btnWeb=(RadioButton) findViewById(R.id.webtut);
       btnBars = (RadioButton)findViewById(R.id.progtut) ;

       //Activity button
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
        prog1 =(Button) findViewById(R.id.prog1);
        prog2  =(Button) findViewById(R.id.prog2);
        prog3  =(Button) findViewById(R.id.prog3);
        prog4  =(Button) findViewById(R.id.prog4);
        prog5  =(Button) findViewById(R.id.prog5);
        prog6 =(Button) findViewById(R.id.prog6);

       //checked tutariel
        btnspinner.setOnCheckedChangeListener (this);
        btntextview.setOnCheckedChangeListener(this);
        btn_Button.setOnCheckedChangeListener(this);
        btnWeb.setOnCheckedChangeListener(this);
        btnBars.setOnCheckedChangeListener(this);

 //region ONCLICK
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
          startActivity(new Intent(MainActivity.this, Activity_Webview_LoadImage.class));
      }
  });
  web6.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Webview Download", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this, Activity_WebviewDownload.class));
      }
  });
  web7.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(MainActivity.this, "Webview LoadHtmlFile", Toast.LENGTH_SHORT).show();
          startActivity(new Intent(MainActivity.this,Activity_Webview_LoadHtmlFile.class));
      }
  });
        prog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Progressbar", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Activity_Progressbar.class));
            }
        });
        prog2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Progressbar Indeterminate", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Activity_progressbar_Indeterminate.class));
                    }
                });
        prog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), " Progressbar Theard", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Activity_Progressbar_Theard.class));
            }
        });
        prog4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Progressbars widgets", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Activity_Progressbars_widgets.class));
                    }
                });
        prog5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Seekbar", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Activity_Seekbar.class));
            }
        });
        prog6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Ratingbar", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Activity_Ratingbar.class));
                    }
                });

  // endregion
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (btnspinner.isChecked() == true){
            spinertutariel.setVisibility(View.VISIBLE);
            textviewtutariel.setVisibility(View.GONE);
            btntutariel.setVisibility(View.GONE);
            webviewtuterial.setVisibility(View.GONE);
            progressbartuterial.setVisibility(View.GONE);
        } else if (btntextview.isChecked() == true) {
            spinertutariel.setVisibility(View.GONE);
            textviewtutariel.setVisibility(View.VISIBLE);
            btntutariel.setVisibility(View.GONE);
            webviewtuterial.setVisibility(View.GONE);
            progressbartuterial.setVisibility(View.GONE);
        } else if (btn_Button.isChecked() == true) {
            spinertutariel.setVisibility(View.GONE);
            textviewtutariel.setVisibility(View.GONE);
            btntutariel.setVisibility(View.VISIBLE);
            webviewtuterial.setVisibility(View.GONE);
            progressbartuterial.setVisibility(View.GONE);
        } else if (btnWeb.isChecked() == true) {
            spinertutariel.setVisibility(View.GONE);
            textviewtutariel.setVisibility(View.GONE);
            btntutariel.setVisibility(View.GONE);
            webviewtuterial.setVisibility(View.VISIBLE);
            progressbartuterial.setVisibility(View.GONE);
        }else if (btnBars.isChecked() == true){
            spinertutariel.setVisibility(View.GONE);
            textviewtutariel.setVisibility(View.GONE);
            btntutariel.setVisibility(View.GONE);
            webviewtuterial.setVisibility(View.GONE);
            progressbartuterial.setVisibility(View.VISIBLE);
        }
    }
}