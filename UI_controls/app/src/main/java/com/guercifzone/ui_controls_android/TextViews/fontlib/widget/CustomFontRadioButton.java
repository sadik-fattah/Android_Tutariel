package com.guercifzone.ui_controls_android.TextViews.fontlib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class CustomFontRadioButton extends androidx.appcompat.widget.AppCompatRadioButton {
    CustomFontTextView customFontTextView;

    public CustomFontRadioButton(Context context) {
        super(context);
        customFontTextView = new CustomFontTextView(context);
        customFontTextView.init(this, null, 0);
    }

    public CustomFontRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        customFontTextView = new CustomFontTextView(context, attrs);
        customFontTextView.init(this, attrs, 0);
    }

    public CustomFontRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        customFontTextView = new CustomFontTextView(context, attrs, defStyle);
        customFontTextView.init(this, attrs, defStyle);
    }
}
