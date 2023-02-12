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


public class fragment_teams_update extends Fragment {

    EditText team_id,team_name,team_field_name,team_city,team_country,team_year,team_sport_id;
    Button submitTeam;

    public fragment_teams_update() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_teams_update, container,false);

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



                    Team team= new Team();
                    team.setId(Var_team_id);

                List<Team> teams = MainActivity.myDatabase.myDao().getTeams();
                for (Team i : teams) {
                    if (Var_team_id == i.getId()) {

                        if (Var_name.equals("")) {
                            team.setName(i.getName());
                        } else {           //NAME
                            team.setName(Var_name);
                        }

                        if (Var_year.equals("")) {
                            team.setTeam_year(i.getTeam_year());
                        } else {           //YEAR
                            team.setTeam_year(Var_year);
                        }

                        if (Var_field_name.equals("")) {
                            team.setField_name(i.getField_name());
                        } else {              //FIELD NAME
                            team.setField_name(Var_field_name);
                        }

                        if (Var_city.equals("")) {
                            team.setTeam_city(i.getTeam_city());
                        } else {              //CITY
                            team.setTeam_city(Var_city);
                        }

                        if (Var_country.equals("")) {
                            team.setTeam_country(i.getTeam_country());
                        } else {              //COUNTRY
                            team.setTeam_country(Var_country);
                        }

                        if (Var_country.equals("")) {
                            team.setTeam_country(i.getTeam_country());
                        } else {              //COUNTRY
                            team.setTeam_country(Var_country);
                        }

                        if (Var_team_sport_id == 0) {
                            team.setTeam_sport_id(i.getTeam_sport_id());
                        } else {              //COUNTRY
                            team.setTeam_sport_id(Var_team_sport_id);
                        }


                    }

                    MainActivity.myDatabase.myDao().UpdateTeam(team);
                    Toast.makeText(getActivity(), "Everything OK", Toast.LENGTH_SHORT).show();


                    team_id.setText("");
                    team_name.setText("");
                    team_sport_id.setText("");
                    team_year.setText("");
                    team_city.setText("");
                    team_country.setText("");
                    team_field_name.setText("");


                }
        });


        // Inflate the layout for this fragment
        return view;
    }




}