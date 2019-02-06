package com.deepin.sharepref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    CheckBox chk_savelogin;
    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.android.sharepref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk_savelogin = findViewById(R.id.chk_savelogin);
        chk_savelogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                if (isChecked) {
                    preferencesEditor.putBoolean("ISSAVE", true);
                }else {
                    preferencesEditor.putBoolean("ISSAVE", false);
                }
                preferencesEditor.apply();
            }
        });

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        boolean isSave = mPreferences.getBoolean("ISSAVE", false);
        if (isSave){
            chk_savelogin.setChecked(true);

        }else {
            chk_savelogin.setChecked(false);
        }
    }
}
