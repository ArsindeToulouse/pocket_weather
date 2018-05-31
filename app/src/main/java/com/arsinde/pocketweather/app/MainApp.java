package com.arsinde.pocketweather.app;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arsinde.pocketweather.R;

public class MainApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);

        FragmentManager fr = getSupportFragmentManager();
        FragmentTransaction ft = fr.beginTransaction();

        Fragment fragment;

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragment = new WeatherDetailsFragment();
            ft.replace(R.id.fl_weather, fragment);
        } else {
            fragment = new CitiesFragment();
            ft.replace(R.id.fr_weather, fragment);
        }

        ft.addToBackStack(null);
        ft.commit();

    }
}
