package com.deepin.sharepref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    CheckBox chk_savelogin;

    EditText et_username;
    Button bt_login;

    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.android.sharepref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.editText);
        bt_login = findViewById(R.id.button);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putString("USERNAME",et_username.getText().toString());
                preferencesEditor.apply();
            }
        });

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
        String username = mPreferences.getString("USERNAME", null);
        et_username.setText(username);
    }
}
