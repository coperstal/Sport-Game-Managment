package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragment_sports extends Fragment implements View.OnClickListener {

    Button insert_button,delete_button,update_button;

    public fragment_sports() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_sports,container,false);

        insert_button = view.findViewById(R.id.insert_sport_button);
        insert_button.setOnClickListener(this);

        update_button= view.findViewById(R.id.update_sport_button);
        update_button.setOnClickListener(this);

        delete_button = view.findViewById(R.id.delete_sport_button);
        delete_button.setOnClickListener(this);

        return view;

    }

    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.insert_sport_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new fragment_sports_insert()).addToBackStack(null).commit();
                break;

            case R.id.update_sport_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new fragment_sports_update()).addToBackStack(null).commit();
                break;

            case R.id.delete_sport_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new fragment_sports_delete()).addToBackStack(null).commit();
                break;


        }


    }









}