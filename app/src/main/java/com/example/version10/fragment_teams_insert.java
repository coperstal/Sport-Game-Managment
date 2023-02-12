package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class fragment_teams_insert extends Fragment {

    EditText team_id,team_name,team_field_name,team_city,team_country,team_year,team_sport_id;
    Button submitTeam;



    public fragment_teams_insert() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_teams_insert, container,false);

        team_id=view.findViewById(R.id.team_id);
        team_name=view.findViewById(R.id.team_name);
        team_field_name=view.findViewById(R.id.team_field_name);
        team_city=view.findViewById(R.id.team_city);
        team_country=view.findViewById(R.id.team_country);
        team_year=view.findViewById(R.id.team_year);
        team_sport_id=view.findViewById(R.id.team_sport_id);



        submitTeam=view.findViewById(R.id.submitTeam);
        submitTeam.setOnClickListener((v)->{


            int Var_team_id=0;
            try{
                Var_team_id=Integer.parseInt(team_id.getText().toString());
            }catch (NumberFormatException ex){
                System.out.println("Could not parse"+ex);
            }

            String Var_name=team_name.getText().toString();
            String Var_field_name=team_field_name.getText().toString();
            String Var_city=team_city.getText().toString();
            String Var_country=team_country.getText().toString();
            String Var_year=team_year.getText().toString();

           // String Var_team_sport_id=team_sport_id.getText().toString();


            int Var_team_sport_id=0;
            try{
                Var_team_sport_id=Integer.parseInt(team_sport_id.getText().toString());
            }catch (NumberFormatException ex){
                System.out.println("Could not parse"+ex);
            }

            try{

            if(!(Var_name.equals("")||Var_city.equals("")||Var_country.equals("")||Var_field_name.equals("")||Var_year.equals("")))
            {

            Team team= new Team();
            team.setId(Var_team_id);
            team.setName(Var_name);
            team.setTeam_year(Var_year);
            team.setField_name(Var_field_name);
            team.setTeam_city(Var_city);
            team.setTeam_country(Var_country);
            team.setTeam_sport_id(Var_team_sport_id);



            MainActivity.myDatabase.myDao().AddTeam(team);
            Toast.makeText(getActivity(), "Everything OK", Toast.LENGTH_SHORT).show();

            }else
                Toast.makeText(getActivity(), "TRY VALID INSERTS", Toast.LENGTH_SHORT).show();


        } catch (Exception e){
            String message = e.getMessage();
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }

            team_id.setText("");
            team_name.setText("");
            team_sport_id.setText("");
            team_year.setText("");
            team_city.setText("");
            team_country.setText("");
            team_field_name.setText("");



        });


        // Inflate the layout for this fragment
        return view;
    }
}