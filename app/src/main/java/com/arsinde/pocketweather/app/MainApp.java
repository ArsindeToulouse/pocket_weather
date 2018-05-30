package com.arsinde.pocketweather.app;

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

        CitiesFragment cities = new CitiesFragment();
        ft.add(R.id.fr_weather, cities);
        ft.commit();
    }
}
