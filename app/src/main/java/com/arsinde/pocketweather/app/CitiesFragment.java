package com.arsinde.pocketweather.app;

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
import android.widget.Toast;

import com.arsinde.pocketweather.R;

import java.util.Objects;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class CitiesFragment extends ListFragment {

    private static final String TAG = CitiesFragment.class.getSimpleName();

    private static final int DEFAULT_POSITION = 0;
    private static final String CURRENT_CITY = "CurrentCity";
    private int currentPosition = 0;
    private boolean landscapeFlag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.Cities, android.R.layout.simple_list_item_activated_1);
        setListAdapter(adapter);

        landscapeFlag = getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE;

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(CURRENT_CITY, DEFAULT_POSITION);
        }

        if (landscapeFlag) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showWeatherDetails();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_CITY, currentPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        currentPosition = position;
        showWeatherDetails();
    }

    private void showWeatherDetails() {
        getListView().setItemChecked(currentPosition, true);
        WeatherDetailsFragment weatherDetails = new WeatherDetailsFragment();

        FragmentTransaction fragmentTransaction;
        if (getFragmentManager() != null) {
            fragmentTransaction = getFragmentManager().beginTransaction();
            if (landscapeFlag) {
                fragmentTransaction.replace(R.id.fl_weather, weatherDetails);
            } else {
                fragmentTransaction.replace(R.id.fr_weather, weatherDetails);
            }
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.serviceError), Toast.LENGTH_LONG).show();
        }
    }
}
