package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class fragment_sports_delete extends Fragment {

    EditText deleteText;
    Button deleteButton;



    public fragment_sports_delete() {

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sports_delete,container,false);
        deleteText = view.findViewById(R.id.sport_id);

        deleteButton=view.findViewById(R.id.delete_sport);
        deleteButton.setOnClickListener((v)->{

                    int Var_sport=0;
                    try{
                        Var_sport=Integer.parseInt(deleteText.getText().toString());

                    }catch (NumberFormatException ex){
                        System.out.println("Could not parse"+ex);
                    }
                    Sport sport =new Sport();
                    sport.setId(Var_sport);
                    MainActivity.myDatabase.myDao().deleteSport(sport);
                    Toast.makeText(getActivity(), "Sport Deleted successfully", Toast.LENGTH_SHORT).show();
                    deleteText.setText("");
                }
        );










        return view;





    }
}