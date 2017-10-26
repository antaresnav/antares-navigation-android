package com.antaresnav.navigation.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.antaresnav.maps.AntaresMap;
import com.antaresnav.maps.AntaresMap.OnMapLongClickListener;
import com.antaresnav.maps.model.LatLng;
import com.antaresnav.navigation.AntaresNavigation;
import com.antaresnav.navigation.NavigationView;
import com.antaresnav.navigation.OnNavigationReadyCallback;
import com.antaresnav.navigation.deprecated.routing.antares.AntaresRoutingService;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigationView);
        navigationView.onCreate(savedInstanceState);
        navigationView.getNavigationAsync(new OnNavigationReadyCallback() {

            @Override
            public void onNavigationReady(final AntaresMap antaresMap, final AntaresNavigation antaresNavigation) {
                antaresNavigation.setRoutingService(new AntaresRoutingService());
                antaresMap.setOnMapLongClickListener(new OnMapLongClickListener() {
                    @Override
                    public void onMapLongClick(@NonNull LatLng point) {
                        antaresNavigation.startNavigation(point);
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        navigationView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        navigationView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        navigationView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        navigationView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        navigationView.onLowMemory();
    }

    @Override
    public void onPause() {
        super.onPause();
        navigationView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        navigationView.onResume();
    }
}
