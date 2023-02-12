package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RoomUI_Fragment extends Fragment implements View.OnClickListener {


    Button athletes,sports,teams,queries,games;




    public RoomUI_Fragment() {

        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_room_u_i_,container,false);
        athletes= view.findViewById(R.id.athlete_button);
        athletes.setOnClickListener(this);

        sports=view.findViewById(R.id.sports_button);
        sports.setOnClickListener(this);

        teams=view.findViewById(R.id.teams_button);
        teams.setOnClickListener(this);

        games=view.findViewById(R.id.games_button);
        games.setOnClickListener(this);

        queries=view.findViewById(R.id.query_button);
        queries.setOnClickListener(this);

       // return inflater.inflate(R.layout.fragment_room_u_i_, container, false);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.athlete_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new fragment_athletes()).addToBackStack(null).commit();
                break;

            case R.id.sports_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new fragment_sports()).addToBackStack(null).commit();
                break;


            case R.id.teams_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new fragment_teams()).addToBackStack(null).commit();
                break;


            case R.id.games_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new fragment_games()).addToBackStack(null).commit();
                break;


            case R.id.query_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new fragment_queries()).addToBackStack(null).commit();
                break;



        }


    }

}