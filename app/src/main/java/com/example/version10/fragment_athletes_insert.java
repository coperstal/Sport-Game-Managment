package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fragment_athletes_insert extends Fragment {


    EditText athlete_id,athlete_name,athlete_surname,athlete_city,athlete_country,athlete_birt_date, athlete_sport_id;
    Button submitAthlete;


    public fragment_athletes_insert() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_athletes_insert, container,false);

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

        try {

            if(!(Var_name.equals("") || Var_surname.equals("") || Var_city.equals("") ||
                    Var_country.equals("") || Var_birth_date.equals("") )) {


            Athlete athlete= new Athlete();
            athlete.setId(Var_athlete_id);
            athlete.setName(Var_name);
            athlete.setSurname(Var_surname);
            athlete.setCity(Var_city);
            athlete.setCountry(Var_country);
            athlete.setBirth_date(Var_birth_date);
            athlete.setSport_id(Var_athlete_sport_id);

           MainActivity.myDatabase.myDao().AddAthlete(athlete);
            Toast.makeText(getActivity(), "Everything OK", Toast.LENGTH_SHORT).show();

            }
            else
            Toast.makeText(getActivity(), "TRY VALID INSERTS", Toast.LENGTH_SHORT).show();


            } catch (Exception e) {
            String message = e.getMessage();
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }

            athlete_id.setText("");
            athlete_name.setText("");
            athlete_surname.setText("");
            athlete_city.setText("");
            athlete_country.setText("");
            athlete_sport_id.setText("");
            athlete_birt_date.setText("");


        });



        return view;

    }



}



































