package com.guercifzone.ui_controls_android.TextViews;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.guercifzone.ui_controls_android.R;
import com.guercifzone.ui_controls_android.TextViews.fontlib.CustomFontConfiguration;
import com.guercifzone.ui_controls_android.TextViews.fontlib.CustomFontEngine;

import java.util.HashMap;

public class Activit_CustomFont extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);
HashMap<Integer,String> fontTypmap = new HashMap<>();
fontTypmap.put(1,"res/font/fontbold.otf");
        fontTypmap.put(2,"res/font/fontmedium.otf");
        fontTypmap.put(3,"res/font/fontregular.otf");
        CustomFontConfiguration customFontConfiguration = new CustomFontConfiguration.Builder()
                .setResourceDeclareStyleableName(R.styleable.font)
                .setResourceAttr(R.styleable.font_type)
                .setFontTypeMap(fontTypmap)
                .build();
        CustomFontEngine.setConfiguration(customFontConfiguration);

    }
}
