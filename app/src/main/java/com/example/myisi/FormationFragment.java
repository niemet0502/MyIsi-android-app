package com.example.myisi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FormationFragment extends Fragment {

    private String  [] tabFormation, tabDetails;
    private String formation, details;
    private ListView listFormation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_formation, container, false);

        listFormation = view.findViewById(R.id.listFormation);
        tabFormation = getActivity().getResources().getStringArray(R.array.tab_formation);
        tabDetails = getActivity().getResources().getStringArray(R.array.tab_details);

        ArrayAdapter<String> adapter =  new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, tabFormation);
        listFormation.setAdapter(adapter); //Chargement des données sur la liste
        return view;
    }
}
