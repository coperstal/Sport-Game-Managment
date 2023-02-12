package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;

import java.util.List;


public class fragment_sports_update extends Fragment {

    RadioButton radioButtonMale, radioButtonFemale,radioButtonIndividual,radioButtonTeamSport;
    EditText sport_id,sport_name;
    Button submitSport,uncheckedButton;



    public fragment_sports_update() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sports_update, container, false);
        sport_id= view.findViewById(R.id.sport_id);
        sport_name=view.findViewById(R.id.sport_name);
        submitSport=view.findViewById(R.id.submitSport);
        uncheckedButton=view.findViewById(R.id.uncheckedButton);


        radioButtonMale=(RadioButton)view.findViewById(R.id.maleButton);
        radioButtonFemale=(RadioButton)view.findViewById(R.id.femalebutton);

        radioButtonIndividual=(RadioButton)view.findViewById(R.id.teambutton);
        radioButtonTeamSport=(RadioButton)view.findViewById(R.id.individualbutton);


        uncheckedButton.setOnClickListener((v)->{    //OTAN KANW CLICK SE ENA KOYMPI. DEN TO PIANEI ME TIN PRWTI. ALLA LEITOURGEI
            radioButtonFemale.setChecked(false);
            radioButtonMale.setChecked(false);
            radioButtonIndividual.setChecked(false);
            radioButtonTeamSport.setChecked(false);

        });


        submitSport.setOnClickListener((v)->{

            String Var_gender="";
            String Var_team="";

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
                    Sport sport = new Sport();
                    sport.setId(Var_sport_id);
                    List<Sport>sports=MainActivity.myDatabase.myDao().getSports();
                    for(Sport i:sports){                                //ELENXEI AN TA PAIDIA EINAI KENA, AN EINAI KENA, BAZEI TA UPARXON PEDIA TOY TABLE , ALLIWS OVERRIDE
                        if(Var_sport_id==i.getId()) {
                            if (Var_gender.equals(""))
                                sport.setGender(i.getGender());
                            else sport.setGender(Var_gender);
                            if (Var_name.equals(""))
                                sport.setName(i.getName());
                            else sport.setName(Var_name);
                            if (Var_team.equals(""))
                                sport.setTeam(i.getTeam());
                            else sport.setTeam(Var_team);
                        }
                    }
                    MainActivity.myDatabase.myDao().UpdateSport(sport);
                    Toast.makeText(getActivity(), "Everything OK", Toast.LENGTH_SHORT).show();
                    sport_id.setText("");
                    sport_name.setText("");
                }
        );
        return view;
    }
}