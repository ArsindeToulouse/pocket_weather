package com.arsinde.pocketweather.app;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arsinde.pocketweather.R;

public class WeatherDetailsFragment extends Fragment {

//    public static WeatherDetailsFragment create(int index) {
//        WeatherDetailsFragment w = new WeatherDetailsFragment();
//
//        Bundle args = new Bundle();
//        args.putInt("index", index);
//        w.setArguments(args);
//        return w;
//    }
//
//    public int getIndex() {
//        int index = getArguments().getInt("index");
//        return index;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View weatherDetails = inflater.inflate(R.layout.fragment_weather_details, container, false);

        return weatherDetails;
    }
}
