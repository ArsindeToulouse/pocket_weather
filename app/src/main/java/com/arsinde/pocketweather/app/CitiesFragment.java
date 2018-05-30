package com.arsinde.pocketweather.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.arsinde.pocketweather.R;

public class CitiesFragment extends ListFragment {

    private static final String TAG = CitiesFragment.class.getSimpleName();

    private boolean isExistWeatherDetails;
    private int currentPosition = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Cities, android.R.layout.simple_list_item_activated_1);
        setListAdapter(adapter);

        View detailsFrame = getActivity().findViewById(R.id.fl_weather_details);
        isExistWeatherDetails = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("CurrentCity", 0);
        }

        if (isExistWeatherDetails) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showWeatherDetails();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CurrentCity", currentPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        currentPosition = position;
        showWeatherDetails();
    }

    private void showWeatherDetails() {
//        if (isExistWeatherDetails) {
            getListView().setItemChecked(currentPosition, true);
            WeatherDetailsFragment weatherDetails = new WeatherDetailsFragment();

//            if (weatheDetails == null || weatheDetails.getIndex() != currentPosition) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fr_weather, weatherDetails);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
//            }
//        }
    }
}
