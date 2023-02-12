package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class QUERY3 extends Fragment {
 TextView textquery3;

    public QUERY3() { }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_q_u_e_r_y3, container,false);

        textquery3=view.findViewById(R.id.textView_query3);

        List<Sport>sport=MainActivity.myDatabase.myDao().getQuery33();
        String result2="";
        for (Sport i:sport){
            String name=i.getName();
            String gender=i.getGender();
            String teams=i.getTeam();
            int code=i.getId();

            result2=result2 +"\n Id: "+code+"\nName: "+name+"\nGender: "+gender+"\nTeams: "+teams;
        }
        textquery3.setText(result2);

        return view;
    }
}
