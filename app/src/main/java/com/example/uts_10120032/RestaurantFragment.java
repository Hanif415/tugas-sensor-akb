package com.example.uts_10120032;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

// NIM : 10120032
// NAMA : HANIF AMRULLAH ALMUHARAM
// KELAS : IF 1
public class RestaurantFragment extends Fragment {

    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restauran, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.my_map);

        getLocation();
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(location -> {
            if(location != null){
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        LatLng lokasi1 = new LatLng(-6.887011363636281, 107.58152902987906);
                        MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Mrs Karee");
                        googleMap.addMarker(options1);
                        LatLng lokasi2 = new LatLng(-6.886845663862189, 107.57956677985462);
                        MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("Rumah Makan Bivana");
                        googleMap.addMarker(options2);
                        LatLng lokasi3 = new LatLng(-6.8856454583652535, 107.58156511723584);
                        MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Tempat nogkrong");
                        googleMap.addMarker(options3);
                        LatLng lokasi4 = new LatLng(-6.887535332811297, 107.57927357008083);
                        MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Pak gombloh cibogo");
                        googleMap.addMarker(options4);
                        LatLng lokasi5 = new LatLng(-6.886738182896697, 107.57773985741802);
                        MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Kampung Cerbonan");
                        googleMap.addMarker(options5);
                        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi2,16));
                    }
                });
            }
        });
    }
}