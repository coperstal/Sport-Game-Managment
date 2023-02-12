package com.example.version10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class fragment_teams_delete extends Fragment {

    EditText deleteText;
    Button deleteButton;



    public fragment_teams_delete() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teams_delete,container,false);
        deleteText = view.findViewById(R.id.team_id);

        deleteButton=view.findViewById(R.id.delete_team);
        deleteButton.setOnClickListener((v)->{

            int Var_team=0;
            try{
                Var_team=Integer.parseInt(deleteText.getText().toString());

            }catch (NumberFormatException ex){
                System.out.println("Could not parse"+ex);

            }
            Team team = new Team();
            team.setId(Var_team);
            MainActivity.myDatabase.myDao().deleteTeam(team);
            Toast.makeText(getActivity(), "Team Deleted successfully", Toast.LENGTH_SHORT).show();
            deleteText.setText("");





        });

    return view;
}

}