package com.arsinde.pocketweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    private TextView tvUserData;
    private TextView tvPressure;
    private TextView tvWet;
    private TextView tvWind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        tvUserData = findViewById(R.id.tv_data_user);
        tvUserData.setText(intent.getStringExtra(MainActivity.USER_ENTER));

        tvPressure = findViewById(R.id.chb_pressure);
        tvWet = findViewById(R.id.chb_wet);
        tvWind = findViewById(R.id.chb_wind);

        if (true) {}
    }
}
