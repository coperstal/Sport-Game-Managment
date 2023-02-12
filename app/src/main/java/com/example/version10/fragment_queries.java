package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentReference;

import java.util.List;


public class fragment_queries extends Fragment implements View.OnClickListener{
        Button query1,query2,query3;

    public fragment_queries(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fragment_queries,container,false);

        query1= view.findViewById(R.id.QUERY_1);
        query1.setOnClickListener(this);

        query2= view.findViewById(R.id.QUERY_2);
        query2.setOnClickListener(this);


        query3= view.findViewById(R.id.QUERY_3);
        query3.setOnClickListener(this);




        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.QUERY_1:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new QUERY1()).addToBackStack(null).commit();
                break;

            case R.id.QUERY_2:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new QUERY2()).addToBackStack(null).commit();
                break;

            case R.id.QUERY_3:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new QUERY3()).addToBackStack(null).commit();
                break;

        }
}}