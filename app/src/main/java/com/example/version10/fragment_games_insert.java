package com.example.version10;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.annotation.Documented;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;


public class fragment_games_insert extends Fragment {



    EditText game_id,game_city,game_name,game_country,game_date,onomaomadas1,onomaomadas2,skoromadwn,pr1,pr2,prscore;
    Button submitGame;
    RadioButton radioButtonIndividual, radioButtonTeamSport;
    EditText player1,player2,player3,player4,performance1,performance2,performance3,performance4;


 //   int var_player1,var_player2,var_player3,var_player4;
     String var_performance1, var_performance2, var_performance3, var_performance4;


     int synthimatiko=0;
     public fragment_games_insert() {

     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_games_insert, container,false);
        //View view2=inflater.inflate(R.layout.fragment_teams, container,false);


        game_id = view.findViewById(R.id.game_id);
        game_name=view.findViewById(R.id.game_name);
        game_city=view.findViewById(R.id.game_city);
        game_country=view.findViewById(R.id.game_country);
        game_date=view.findViewById(R.id.game_date);

        radioButtonTeamSport =(RadioButton)view.findViewById(R.id.game_teambutton);
        radioButtonIndividual=(RadioButton)view.findViewById(R.id.game_individualbutton);

        submitGame=view.findViewById(R.id.submitGame);

        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.TeamGroup2);


         // Einai gia individual Sport opws stibos,akontinio ktlp
         player1=(EditText)view.findViewById(R.id.indiv1);  // ID ATHLITI
         performance1=(EditText)view.findViewById(R.id.perf1);// ATOMIKI EPIDOSI
         player2=(EditText)view.findViewById(R.id.indiv2);
         performance2=(EditText)view.findViewById(R.id.perf2);
         player3=(EditText)view.findViewById(R.id.indiv3);
         performance3=(EditText)view.findViewById(R.id.perf3);
         player4=(EditText)view.findViewById(R.id.indiv4);
         performance4=(EditText)view.findViewById(R.id.perf4);


        // einai gia 1 indiv sport , 2 paiktes , 1 score
         pr1 = (EditText)view.findViewById(R.id.game_athelete_id1);
         pr2=(EditText)view.findViewById(R.id.game_athelete_id2);
         prscore=(EditText)view.findViewById(R.id.game_score);



        // einai gia team sport, 2 omades,1 score
        onomaomadas1  = (EditText)view.findViewById(R.id.omada_onoma1);
        onomaomadas2  = (EditText)view.findViewById(R.id.omada_onoma2);
        skoromadwn    = (EditText)view.findViewById(R.id.skor_omadwn);


      radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String var_name=game_name.getText().toString();
                    if(radioButtonTeamSport.isChecked() &&(var_name.equals("Μπάσκετ")||var_name.equals("Ποδόσφαιρο")||var_name.equals("Βόλεϊ"))) {
                        synthimatiko=1;

                        onomaomadas1.setVisibility(view.VISIBLE);
                        onomaomadas2.setVisibility(view.VISIBLE);
                        skoromadwn.setVisibility(view.VISIBLE);
                        pr1.setVisibility(view.GONE);
                        pr2.setVisibility(view.GONE);
                        prscore.setVisibility(view.GONE);
                        player1.setVisibility(view.GONE);
                        performance1.setVisibility(view.GONE);
                        player2.setVisibility(view.GONE);
                        performance2.setVisibility(view.GONE);
                        player3.setVisibility(view.GONE);
                        performance3.setVisibility(view.GONE);
                        player4.setVisibility(view.GONE);
                        performance4.setVisibility(view.GONE);
                        submitGame.setVisibility(view.VISIBLE);
                    }
                    else  if(radioButtonIndividual.isChecked()&&(var_name.equals("Τένις")||var_name.equals("Πίνγκ πόνγκ")||var_name.equals("Βόξ"))){
                        synthimatiko=2;

                        pr1.setVisibility(view.VISIBLE);
                        pr2.setVisibility(view.VISIBLE);
                        prscore.setVisibility(view.VISIBLE);
                        onomaomadas1.setVisibility(view.GONE);
                        onomaomadas2.setVisibility(view.GONE);
                        skoromadwn.setVisibility(view.GONE);
                        player1.setVisibility(view.GONE);
                        performance1.setVisibility(view.GONE);
                        player2.setVisibility(view.GONE);
                        performance2.setVisibility(view.GONE);
                        player3.setVisibility(view.GONE);
                        performance3.setVisibility(view.GONE);
                        player4.setVisibility(view.GONE);
                        performance4.setVisibility(view.GONE);
                        submitGame.setVisibility(view.VISIBLE);
                    }
                    else  if(radioButtonIndividual.isChecked()&&(var_name.equals("Στίβος")||var_name.equals("Ακόντιο")
                            ||var_name.equals("Ποδηλασία")||var_name.equals("Άλμα"))){
                        synthimatiko=3;

                        player1.setVisibility(view.VISIBLE);
                        performance1.setVisibility(view.VISIBLE);
                        player2.setVisibility(view.VISIBLE);
                        performance2.setVisibility(view.VISIBLE);
                        player3.setVisibility(view.VISIBLE);
                        performance3.setVisibility(view.VISIBLE);
                        player4.setVisibility(view.VISIBLE);
                        performance4.setVisibility(view.VISIBLE);
                        pr1.setVisibility(view.GONE);
                        pr2.setVisibility(view.GONE);
                        prscore.setVisibility(view.GONE);
                        onomaomadas1.setVisibility(view.GONE);
                        onomaomadas2.setVisibility(view.GONE);
                        skoromadwn.setVisibility(view.GONE);
                        submitGame.setVisibility(view.VISIBLE);
                    }else {
                        player1.setVisibility(view.GONE);
                        performance1.setVisibility(view.GONE);
                        player2.setVisibility(view.GONE);
                        performance2.setVisibility(view.GONE);
                        player3.setVisibility(view.GONE);
                        performance3.setVisibility(view.GONE);
                        player4.setVisibility(view.GONE);
                        performance4.setVisibility(view.GONE);
                        pr1.setVisibility(view.GONE);
                        pr2.setVisibility(view.GONE);
                        prscore.setVisibility(view.GONE);
                        onomaomadas1.setVisibility(view.GONE);
                        onomaomadas2.setVisibility(view.GONE);
                        skoromadwn.setVisibility(view.GONE);
                        submitGame.setVisibility(view.GONE);
                    }
            }
        });





        submitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    int var_id=0,var_pr1=0,var_pr2=0;
                    int var_player1=0,var_player2=0,var_player3=0,var_player4=0;

                //TA PRWTA 5 PEDIA
                String var_city=game_city.getText().toString();
                String var_name=game_name.getText().toString();
                String var_country=game_country.getText().toString();
                String var_date=game_date.getText().toString();

                //TA STRING GIA TIS OMADES
                String var_omada1=  onomaomadas1.getText().toString();
                String var_omada2=onomaomadas2.getText().toString();
                String var_skoromadwn=skoromadwn.getText().toString();

              //TA ID gia 1 indiv sport , 2 paiktes , 1 score
                try{
                 var_pr1= Integer.parseInt(pr1.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse"+ex);
                }

                try{
                 var_pr2=Integer.parseInt(pr2.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse"+ex);
                }

                String var_prscore=prscore.getText().toString();

                //TA ID gia 1 indiv sport , 5 paiktes , 1 score per paiktis
                try{
                var_player1=Integer.parseInt(player1.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse"+ex);
                }

                try{
                var_player2=Integer.parseInt(player2.getText().toString());
                    }catch (NumberFormatException ex){
                        System.out.println("Could not parse"+ex);
                }
                try{
                var_player3=Integer.parseInt(player3.getText().toString());
                        }catch (NumberFormatException ex){
                            System.out.println("Could not parse"+ex);
                }
                try{
                var_player4=Integer.parseInt(player4.getText().toString());
                            }catch (NumberFormatException ex){
                                System.out.println("Could not parse"+ex);
                }

                var_performance1=performance1.getText().toString();
                var_performance2=performance2.getText().toString();
                var_performance3=performance3.getText().toString();
                var_performance4=performance4.getText().toString();

                try{
                      var_id=Integer.parseInt(game_id.getText().toString());
                 }catch (NumberFormatException ex){
                    System.out.println("Could not parse"+ex);
                 }








                try{

                    if(!(var_city.equals("") || var_name.equals("") || var_country.equals("") ||
                            var_date.equals("") )) {

                        Game games = new Game();

                        games.setId(var_id);
                        games.setCity(var_city);
                        games.setCountry(var_country);
                        games.setName(var_name);
                        games.setDate(var_date);
                        MainActivity.db.
                                collection("Agwnas").
                                document("" + var_id).
                                set(games).
                                addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                      //  Toast.makeText(getActivity(), "Game added.", Toast.LENGTH_LONG).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                       // Toast.makeText(getActivity(), "add operation failed.", Toast.LENGTH_LONG).show();
                                    }

                                });
                    }
                    else
                Toast.makeText(getActivity(), "TRY VALID INSERTS", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }

                try{
                    if(synthimatiko==1) {
                        if (!(var_id == 0 || var_omada1.equals("") || var_omada2.equals("") || var_skoromadwn.equals(""))) {
                            int l=0,m=0;
                            Game_Team teamgames = new Game_Team();

                                List<Team> team=MainActivity.myDatabase.myDao().getTeams();

                                for (Team i: team){
                                if(var_omada1.equals(i.getName()) ){
                                    l++;}
                                if(var_omada2.equals(i.getName()) ){
                                    m++;}
                                }

                            if(l==m) {

                                teamgames.setId_athlimatos(var_id);
                                teamgames.setTeam1(var_omada1);
                                teamgames.setTeam2(var_omada2);
                                teamgames.setScore(var_skoromadwn);
                                MainActivity.db.collection("Team_Agwnas").document("" + var_id).
                                        set(teamgames).
                                        addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(getActivity(), " ADDED OK! ", Toast.LENGTH_LONG).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(getActivity(), "ADD operation failed.", Toast.LENGTH_LONG).show();
                                            }

                                        });

                            }else
                                Toast.makeText(getActivity(), "TRY VALID INSERTS1", Toast.LENGTH_SHORT).show();

                        } else
                            Toast.makeText(getActivity(), "NULL INSERTS", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }
                try{
                    if(synthimatiko==2){
                        if (!(var_id==0 || var_pr1==0||var_pr2==0||var_prscore.equals(""))){


                            int l=0,m=0;
                            Game_Ind_Score ind_score_games = new Game_Ind_Score();

                            List<Athlete> athlete=MainActivity.myDatabase.myDao().getAthletes();

                            for (Athlete i: athlete){
                                if(var_pr1==i.getId()){
                                    l++;}
                                if(var_pr2==i.getId() ){
                                    m++;}
                            }

                            if(l==m) {

                            ind_score_games.setId_athlimatos(var_id);
                            ind_score_games.setId1(var_pr1);
                            ind_score_games.setId2(var_pr2);
                            ind_score_games.setScore(var_prscore);

                            MainActivity.db.collection("Ind_Score_Agwnas").document(""+var_id).
                                    set(ind_score_games).
                                    addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(getActivity(), "  ADD OK! ", Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getActivity(), "ADD operation failed.", Toast.LENGTH_LONG).show();
                                        }
                                    });
                            }else
                                Toast.makeText(getActivity(), "TRY VALID INSERTS2", Toast.LENGTH_SHORT).show();

                        } else
                            Toast.makeText(getActivity(), "NULL INSERTS", Toast.LENGTH_SHORT).show();

                    }} catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }



                try{
                    if(synthimatiko==3) {
                        if (!(var_player1 == 0 || var_player2 == 0 || var_player3 == 0 || var_player4 == 0 || var_performance1.equals("") || var_performance2.equals("") || var_performance3.equals("") || var_performance4.equals(""))) {

                            Game_Ind ind_games = new Game_Ind();
                            List<Athlete> athlete=MainActivity.myDatabase.myDao().getAthletes();
                            int k=0,l=0,m=0,n=0;

                            for (Athlete i: athlete){
                                if(var_player1==i.getId()){
                                    l++;}
                                if(var_player2==i.getId() ){
                                    m++;}
                                if(var_player3==i.getId()){
                                    k++;}
                                if(var_player4==i.getId() ){
                                   n++;}
                            }

                            if(k==1 && l==1 && m==1 && n==1){

                            ind_games.setId_athlimatos(var_id);
                            ind_games.setId1(var_player1);
                            ind_games.setId2(var_player2);
                            ind_games.setId3(var_player3);
                            ind_games.setId4(var_player4);

                            ind_games.setPerformance1(var_performance1);
                            ind_games.setPerformance2(var_performance2);
                            ind_games.setPerformance3(var_performance3);
                            ind_games.setPerformance4(var_performance4);

                            MainActivity.db.collection("Ind_Agwnas").document("" + var_id).
                                    set(ind_games).
                                    addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(getActivity(), " ADD ok! ", Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getActivity(), "ADD operation failed.", Toast.LENGTH_LONG).show();
                                        }

                                    });
                            }else
                                Toast.makeText(getActivity(), "TRY VALID INSERTS3", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getActivity(), "NULL INSERTS", Toast.LENGTH_SHORT).show();

                    } } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }

            }

        });
        game_id.setText("");
        game_date.setText("");
        game_country.setText("");
        game_city.setText("");
        game_name.setText("");

        onomaomadas1.setText("");
        onomaomadas2.setText("");
        skoromadwn.setText("");

        return view;
    }
}