package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class fragment_sports_insert extends Fragment {

    EditText sport_id,sport_name;
    Button submitSport;
    RadioButton radioButtonMale, radioButtonFemale,radioButtonIndividual,radioButtonTeamSport;

    public fragment_sports_insert() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sports_insert, container, false);
        sport_id= view.findViewById(R.id.sport_id);
        sport_name=view.findViewById(R.id.sport_name);
        radioButtonMale=(RadioButton)view.findViewById(R.id.maleButton);
        radioButtonFemale=(RadioButton)view.findViewById(R.id.femalebutton);
        radioButtonIndividual=(RadioButton)view.findViewById(R.id.teambutton);
        radioButtonTeamSport=(RadioButton)view.findViewById(R.id.individualbutton);
        submitSport=view.findViewById(R.id.submitSport);

        submitSport.setOnClickListener((v)->{

            String Var_gender="Male";
            String Var_team="Team";

            if(radioButtonMale.isChecked())
                Var_gender="Male";

            if (radioButtonFemale.isChecked())
                Var_gender="Female";

            if(radioButtonTeamSport.isChecked())
                Var_team="Individual";              //EINAI ANAPODA, UPARXEI KOLPO (KAPOY EBAZA TEAM KAI MOY EBGAINE INDIVIDUAL)
                                                    //ETSI LEITOURGEI SWSTA
            if(radioButtonIndividual.isChecked())
                Var_team="Team";

            int Var_sport_id=0;
                    try{
                        Var_sport_id=Integer.parseInt(sport_id.getText().toString());
                    }catch (NumberFormatException ex){
                        System.out.println("Could not parse"+ex);
                    }
                    String Var_name=sport_name.getText().toString();
            try {

                if(!(Var_name.equals("") )) {

                    Sport sport = new Sport();
                    sport.setId(Var_sport_id);
                    sport.setName(Var_name);
                    sport.setTeam(Var_team);
                    sport.setGender(Var_gender);
                    MainActivity.myDatabase.myDao().AddSport(sport);
                    Toast.makeText(getActivity(), "Everything OK"+Var_team , Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getActivity(), "TRY VALID INSERTS", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                String message = e.getMessage();
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
                    sport_id.setText("");
                    sport_name.setText("");
                }

        );
        return view;
    }
}