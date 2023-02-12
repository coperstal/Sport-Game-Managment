package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class QUERY1 extends Fragment {


    TextView textquery1;

    public QUERY1() { }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_q_u_e_r_y1, container,false);

        textquery1=view.findViewById(R.id.textView_query1);
            List<Athlete> athlete=MainActivity.myDatabase.myDao().getQuery11();
            String result1="";

            for (Athlete i: athlete){
                int code = i.getId();
                String name= i.getName();
                String surname= i.getSurname();
                String city= i.getCity();
                String country=i.getCountry();
                String birth_date=i.getBirth_date();
                int sport_code=i.getSport_id();

                result1=result1 +"\n Id: "+code+"\n Name: "+name+"\n Surname: "+surname+
                        "\n City: "+city+"\n Country: "+country+"\n Birth Date: "
                        +birth_date+"\n Sport Id: "+sport_code+"\n";

            }
        textquery1.setText(result1);
        return view;
    }
}
