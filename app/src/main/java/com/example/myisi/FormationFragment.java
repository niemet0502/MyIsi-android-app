package com.example.myisi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        //Gerer l'évenement click sur lun élément de la liste
        listFormation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    formation = tabFormation[position];
                    details   = tabDetails[position];
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.mipmap.ic_launcher);//icone
                dialog.setTitle(formation);//titre de la boite de dialogue
                dialog.setMessage(details);//détails de la boite de dialogue
                String cancel = getString(R.string.cancel);//le nom du boutton à gauche
                String inscription = getString(R.string.inscription);//le nom du boutton à droite
                dialog.setNegativeButton(cancel, null);//revenir sur la liste des formations
                dialog.setPositiveButton(inscription, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //On peut appeler la page d'inscription

                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.nav_host_fragment,
                                        new InscriptionFragment())
                                .addToBackStack(null)
                                .commit();//chargement de la page

                    }
                });
                dialog.show(); //Afficher la boite de dialogue

            }
        });

        return view;
    }
}
