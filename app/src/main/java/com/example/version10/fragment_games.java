package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragment_games extends Fragment implements View.OnClickListener {
    Button insert_button,update_button,delete_button;


    public fragment_games() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_games,container,false);

        insert_button = view.findViewById(R.id.insert_game_button);
        insert_button.setOnClickListener(this);

        update_button = view.findViewById(R.id.update_game_button);
        update_button.setOnClickListener(this);

        delete_button = view.findViewById(R.id.delete_game_button);
        delete_button.setOnClickListener(this);


        return view;
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.insert_game_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new fragment_games_insert()).addToBackStack(null).commit();
                break;
            case R.id.update_game_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new fragment_games_update()).addToBackStack(null).commit();
                break;
            case R.id.delete_game_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new fragment_games_delete()).addToBackStack(null).commit();
                break;

        }
    }

}