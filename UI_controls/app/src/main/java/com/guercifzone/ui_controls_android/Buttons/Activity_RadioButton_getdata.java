package com.guercifzone.ui_controls_android.Buttons;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_RadioButton_getdata extends AppCompatActivity {
    Restaurant r = new Restaurant();
    private RadioButton  sitedown,tackout,delivery;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_getdata);
        Button save = (Button) findViewById(R.id.save);
        sitedown = (RadioButton) findViewById(R.id.sit_down);
        tackout = (RadioButton) findViewById(R.id.take_out);
        delivery = (RadioButton) findViewById(R.id.deli_very);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name);
                EditText address = (EditText) findViewById(R.id.addr);
                r.setName(name.getText().toString());
                r.setAddress(address.getText().toString());
                RadioGroup types = (RadioGroup) findViewById(R.id.types);
                if (sitedown.isChecked() == true){
                            r.setType("sit_down");
                            Toast.makeText(Activity_RadioButton_getdata.this, "sit_down  "+name.getText()+address.getText(), Toast.LENGTH_SHORT).show();
                        }else if (tackout.isChecked() == true){
                            r.setType("tack-out");
                            Toast.makeText(Activity_RadioButton_getdata.this, "tack-out  "+name.getText()+address.getText(), Toast.LENGTH_SHORT).show();
                        }else if (delivery.isChecked() == true){
                            r.setType("delivery");
                            Toast.makeText(Activity_RadioButton_getdata.this, "delivery  "+name.getText()+address.getText(), Toast.LENGTH_SHORT).show();
                        }

                }

        });

    }

}
class Restaurant {
    private String name = "";
    private String address = "";
    private String type = "";

    public String getName() {
        return (name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return (address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return (type);
    }

    public void setType(String type) {
        this.type = type;
    }
}