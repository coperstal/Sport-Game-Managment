package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class fragment_athletes_delete extends Fragment {

    EditText deleteText;
    Button deleteButton;



    public fragment_athletes_delete() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_athletes_delete,container,false);
        deleteText = view.findViewById(R.id.athlete_id);

        deleteButton=view.findViewById(R.id.delete_athlete);
        deleteButton.setOnClickListener((v)->{

            int Var_athlete=0;
            try{
                Var_athlete=Integer.parseInt(deleteText.getText().toString());

            }catch (NumberFormatException ex){
                System.out.println("Could not parse"+ex);

            }
            Athlete athlete = new Athlete();
            athlete.setId(Var_athlete);
            MainActivity.myDatabase.myDao().deleteAthlete(athlete);
            Toast.makeText(getActivity(), "Athlete Deleted successfully", Toast.LENGTH_SHORT).show();
            deleteText.setText("");





                }
        );










        return view;


    }







}