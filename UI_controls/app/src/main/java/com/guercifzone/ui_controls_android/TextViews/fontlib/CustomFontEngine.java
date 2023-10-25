package com.guercifzone.ui_controls_android.TextViews.fontlib;

public class CustomFontEngine {
    private static CustomFontConfiguration mConfiguration = new CustomFontConfiguration.Builder().build();

    public static void setConfiguration(CustomFontConfiguration configuration) {
        mConfiguration = configuration;
    }

    public static CustomFontConfiguration getConfiguration() {
        return mConfiguration;
    }
}
