package com.example.mydit5;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class UniversityFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_university, container, false);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng isiMere = new LatLng(14.6862722,-17.4570579);
        mMap.addMarker(new MarkerOptions().position(isiMere)
                .title("ISI Mère")
                .snippet("Contact: 338221981, Site: groupeisi.com"));//Ajouter une description pour le marker

        LatLng isiKM = new LatLng(14.786461,-17.2889386);
        mMap.addMarker(new MarkerOptions().position(isiKM)
                .title("ISI Keur MASSAR")
                .snippet("Contact: 338784349, Site: groupeisi.com"));//Ajouter une description pour le marker

        LatLng ucad = new LatLng(14.6911552,-17.4728325);
        mMap.addMarker(new MarkerOptions().position(ucad)
                .title("UCAD")
                .snippet("Contact: 784946215, Site: ucad.sn"));//Ajouter une description pour le marker

        CircleOptions co = new CircleOptions()
                .center(isiMere) //le centre du cercle
                .radius(700) //diametre
                .fillColor(Color.BLUE)//Couleur de la surface du cercle
                .strokeWidth(Color.BLACK)//Couleur du contour du cercle
                .strokeWidth(7);//Epaisseur du fil qui entoure le cercle

        mMap.addCircle(co);//Ajout du cercle sur la carte

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                if(marker.getTitle().equalsIgnoreCase("ISI Mère"))
                {

                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:774148870"));
                    startActivity(intent);
                }
                if(marker.getTitle().equalsIgnoreCase("UCAD"))
                {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:774148870"));
                    intent.putExtra("sms_body", "Bonsoir LPGL les grands Devs Android");
                    startActivity(intent);
                }
                return false;
            }
        });
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(isiMere, 12));


    }
}
