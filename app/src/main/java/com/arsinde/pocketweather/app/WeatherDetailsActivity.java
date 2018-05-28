package com.arsinde.pocketweather.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arsinde.pocketweather.R;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class WeatherDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            WeatherDetailsFragment weatherDetails = new WeatherDetailsFragment();
            weatherDetails.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, weatherDetails).commit();
        }
    }
}
