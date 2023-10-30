package com.guercifzone.ui_controls_android.Buttons;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.ui_controls_android.R;

public class Activity_ImageButton extends AppCompatActivity {
    EditText name;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button);
name = (EditText) findViewById(R.id.name);
result = (TextView) findViewById(R.id.result);
ImageButton btnimg = (ImageButton) findViewById(R.id.format);
btnimg.setOnClickListener(new Button.OnClickListener(){

    @Override
    public void onClick(View v) {
applFormate();
    }


});
    }
    private void applFormate() {
        String format= getString(R.string.funky_format);
        String  simpleresult = String.format(format,
                TextUtils.htmlEncode(name.getText().toString()));
        result.setText(Html.fromHtml(simpleresult));
    }
}