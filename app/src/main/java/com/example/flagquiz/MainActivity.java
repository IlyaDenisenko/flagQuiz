package com.example.flagquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {

    public static final String CHOICES = "pref_numberOfChoices";
    public static final String REGIONS = "pref_regionsToInclude";

    private boolean phoneDevice = true;
    private boolean preferencesChanged = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Задание значений по умолчанию в файле SharedPreferences
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        //Регистрация слушателя для изменений SharedPreferences
     //   PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(preferencesChangeListener);

        //Определение размера экрана
        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE) // для планшета phoneDevice = false
            phoneDevice = false;
        if (phoneDevice)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // на телефоне разрешена только портретная ориентация
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirstFragment quizFragment = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.quiz_fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT){
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        } else
            return false;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Intent preferenceIntent = new Intent(this, SettingsActivity.class);
        startActivity(preferenceIntent);

        return super.onOptionsItemSelected(item);
    }
}