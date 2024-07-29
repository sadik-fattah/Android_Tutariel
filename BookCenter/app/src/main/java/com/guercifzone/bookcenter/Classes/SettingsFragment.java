package com.guercifzone.bookcenter.Classes;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import com.guercifzone.bookcenter.R;
import org.jetbrains.annotations.Nullable;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // below line is used to add preference
        // fragment from our xml folder.
        addPreferencesFromResource(R.xml.preferences);
    }
}
