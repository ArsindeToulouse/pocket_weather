package com.arsinde.pocketweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String USER_ENTER = "user_enter";
    public static final String PRESSURE = "pressure";
    public static final String WET = "wet";
    public static final String WIND = "wind";

    private EditText cityName;
    private Button btnEnter;
    private CheckBox pressure;
    private CheckBox wet;
    private CheckBox wind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = findViewById(R.id.et_city_name);
        btnEnter = findViewById(R.id.btn_enter);
        pressure = findViewById(R.id.chb_pressure);
        wet = findViewById(R.id.chb_wet);
        wind = findViewById(R.id.chb_wind);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(USER_ENTER, cityName.getText().toString());
                intent.putExtra(PRESSURE, pressure.isChecked());
                intent.putExtra(WET, wet.isChecked());
                intent.putExtra(WIND, wind.isChecked());
                startActivity(intent);
            }
        });
    }
}
