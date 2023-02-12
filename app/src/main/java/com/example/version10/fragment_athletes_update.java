package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class fragment_athletes_update extends Fragment {



    EditText athlete_id,athlete_name,athlete_surname,athlete_city,athlete_country,athlete_birt_date, athlete_sport_id;
    Button submitAthlete;


    public fragment_athletes_update() {
        // Required empty public constructor
    }




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_athletes_update, container,false);
        athlete_id=view.findViewById(R.id.athlete_id);
        athlete_name=view.findViewById(R.id.athlete_name);
        athlete_surname=view.findViewById(R.id.athlete_surname);
        athlete_city=view.findViewById(R.id.athlete_city);
        athlete_country=view.findViewById(R.id.athlete_country);
        athlete_birt_date=view.findViewById(R.id.athlete_birth_date);
        athlete_sport_id=view.findViewById(R.id.athlete_sport_id);
        submitAthlete=view.findViewById(R.id.submitAthlete);
        submitAthlete.setOnClickListener((v)->{
                    int Var_athlete_id=0;
                    try{
                        Var_athlete_id=Integer.parseInt(athlete_id.getText().toString());
                    }catch (NumberFormatException ex){
                        System.out.println("Could not parse"+ex);
                    }
                    String Var_name=athlete_name.getText().toString();
                    String Var_surname=athlete_surname.getText().toString();
                    String Var_city=athlete_city.getText().toString();
                    String Var_country=athlete_country.getText().toString();
                    String Var_birth_date=athlete_birt_date.getText().toString();
                    int Var_athlete_sport_id=0;
                    try{
                        Var_athlete_sport_id=Integer.parseInt(athlete_sport_id.getText().toString());
                    }catch (NumberFormatException ex){
                        System.out.println("Could not parse"+ex);
                    }
                    Athlete athlete= new Athlete();
                    athlete.setId(Var_athlete_id);
                    List<Athlete>athletes=MainActivity.myDatabase.myDao().getAthletes();
                    for(Athlete i:athletes) {
                       if(Var_athlete_id==i.getId()){
                        if (Var_name.equals(""))
                            athlete.setName(i.getName());
                                else  athlete.setName(Var_name);
                        if(Var_surname.equals(""))
                            athlete.setName(i.getSurname());
                                else  athlete.setSurname(Var_surname);
                         if(Var_city.equals(""))
                             athlete.setCity(i.getCity());
                                else athlete.setCity(Var_city);
                         if(Var_country.equals(""))
                             athlete.setCountry(i.getCountry());
                                else athlete.setCountry(Var_country);
                         if(Var_birth_date.equals(""))
                             athlete.setBirth_date(i.getBirth_date());
                                else athlete.setBirth_date(Var_birth_date);
                         if(Var_athlete_sport_id==0) //Kanonika thelw na elenksw AN TO PEIDIO SPORT ID EINAI KENO, NA PAIRNW APO TO TABLE TO UPARXWN SPORT ID, ALLIWS OVERIDE
                             athlete.setSport_id(i.getSport_id());
                                else athlete.setSport_id(Var_athlete_sport_id);
                       }
                    }
                    MainActivity.myDatabase.myDao().updateAthlete(athlete);
                    Toast.makeText(getActivity(), " Update ID: "+Var_athlete_id+" Everything OK", Toast.LENGTH_SHORT).show();
                    athlete_id.setText("");
                    athlete_name.setText("");
                    athlete_surname.setText("");
                    athlete_city.setText("");
                    athlete_country.setText("");
                    athlete_sport_id.setText("");
                    athlete_birt_date.setText("");
                }
        );
        return view;
    }
}