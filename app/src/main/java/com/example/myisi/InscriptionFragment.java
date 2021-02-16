package com.example.myisi;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionFragment extends Fragment {
//Declarer les variables qui vont représenter celles
//de l'interface graphique
private EditText txtFirstName, txtLastName;
private CheckBox cbOLevel, cbBachelor, cbMaster;
private Button btnSave;
private String firstName, lastName, degrees;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inscription, container, false);
//Lier les variables Java aux composants d l'interface graphique  fragment_inscription.xml
 txtFirstName = view.findViewById(R.id.txtFirstName);
 txtLastName = view.findViewById(R.id.txtLastName);
 cbOLevel = view.findViewById(R.id.cbOLevel);
 cbBachelor = view.findViewById(R.id.cbBachelor);
 cbMaster = view.findViewById(R.id.cbMaster);
 btnSave = view.findViewById(R.id.btnSave);

 //Gerer le click sur le bouton save, Gestion d'évenement Click (Listener)
btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//récupération des éléments saisis dans les zones de texte
   firstName = txtFirstName.getText().toString().trim();
   lastName = txtLastName.getText().toString().trim();
//récupération des diplomes cochés
        degrees = "";
        if(cbOLevel.isChecked()) {
            degrees += cbOLevel.getText().toString()+" ";
        }
        if(cbBachelor.isChecked()){
            degrees+=cbBachelor.getText().toString()+" ";
        }
        if(cbMaster.isChecked()){
            degrees+=cbMaster.getText().toString()+" ";
        }

        if(firstName.isEmpty()||lastName.isEmpty()||degrees.isEmpty())
        {
            Toast.makeText(getActivity(), getString(R.string.error_fields), Toast.LENGTH_SHORT).show();
        }
        else{
            String resume = firstName+"\n\n"+lastName+"\n\n"+degrees;
            Toast.makeText(getActivity(), resume, Toast.LENGTH_SHORT).show();
        }


    }
});
        return view;
    }
}
