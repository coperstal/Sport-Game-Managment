package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class QUERY2 extends Fragment {
    TextView textquery2;

    public QUERY2() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


            View view = inflater.inflate(R.layout.fragment_q_u_e_r_y2, container,false);

            textquery2=view.findViewById(R.id.textView_query2);

          List<Team>team=MainActivity.myDatabase.myDao().getQuery22();

        String result3="";
        for (Team i:team){
            int code=i.getId();
            String name=i.getName();
            String field_name=i.getField_name();
            String city=i.getTeam_city();
            String country=i.getTeam_country();
            String year=i.getTeam_year();
            int sport_id= i.getTeam_sport_id();
            result3=result3 +"\n Id: "+code+"\nName: "+name+"\nCity: "+city+"\nField_Name: "+field_name
                    +"\nCountry: "+country+"\nYear Establishment: "+year+"\nSport ID: "+sport_id;

            }
            textquery2.setText(result3);
        return view;
    }
}
