package com.example.version10;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.errorprone.annotations.Var;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;


import org.w3c.dom.Document;

import java.util.List;


public class fragment_search extends Fragment {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView querytextView, querytextresult;
    Button bnqueryrun;
    EditText editText;
    int test;
    String result = "";

    DocumentReference documentReference1,documentReference2,documentReference3,documentReference4;


    //Xrisimpoiounte gia to case 4 , opou prepei na parw apo ALLO document.
    double id;
    String name;


    public fragment_search() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        final String[] queryArray = getResources().getStringArray(R.array.queries_description_array);
        querytextView = view.findViewById(R.id.txtquery);
        spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.queries_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        editText = view.findViewById(R.id.editText);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                querytextView.setText(queryArray[position]);
                test = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        querytextresult = view.findViewById(R.id.txtqueryresult);
        bnqueryrun = view.findViewById(R.id.queryrun);


            bnqueryrun.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    querytextresult.setText(""); // na to katharisei
                    switch (test) {
                        case 1:
                            List<ResultStringInt> strings = MainActivity.myDatabase.myDao().getQuery3();
                            String Var_sport = editText.getText().toString();
                            for (ResultStringInt i : strings) {
                                if (Var_sport.equals(i.getField5())) {
                                    String name = i.getField2();
                                    String surname = i.getField3();
                                    String team = i.getField6(); // individual or team sport
                                    result = result + "\nName: " + name + "\nSurname: " + surname + "\nTeam: " + team;
                                }

                            }
                            if (result.equals(""))
                                Toast.makeText(getActivity(), "This Sport: " + Var_sport + " Does not exist", Toast.LENGTH_LONG).show();
                            else  querytextresult.setText(result);

                            break;

                        case 2:
                            List<ResultStringInt> strings2 = MainActivity.myDatabase.myDao().getQuery2();
                            String Var_gender = editText.getText().toString();
                            for (ResultStringInt i : strings2) {
                                if (Var_gender.equals(i.getField5())) {
                                    String athlete_name = i.getField1();
                                    String athlete_surname = i.getField2();
                                    String team_name = i.getField3();
                                    String sport_name = i.getField4();
                                    String sport_gender = i.getField5();
                                    result = result + "\nName: " + athlete_name + "\nSurname: " + athlete_surname + "\nGender: " + sport_gender
                                            + "\nTeam name: " + team_name + "\nSport name: " + sport_name;
                                }
                            }

                            if (result.equals(""))
                                Toast.makeText(getActivity(), "This Gender: " + Var_gender + " Does not exist", Toast.LENGTH_LONG).show();
                            else querytextresult.setText(result);

                            break;

                            case 3:
                            List<ResultStringInt> strings3 = MainActivity.myDatabase.myDao().getQuery3();
                            String Var_athlete_id = editText.getText().toString();
                            for (ResultStringInt i : strings3) {
                                if (Var_athlete_id.equals(i.getField1())) {

                                    String athlete_id = i.getField1();
                                    String athletes_name = i.getField2();
                                    String athlete_surname = i.getField3();
                                    String birth = i.getField4();
                                    String sport_name = i.getField5();
                                    result = result + "\nAthlete ID: " + athlete_id + "\nName: " + athletes_name + "\nSurname: " + athlete_surname + "\nBirth Date: " + birth + "\nSport: " + sport_name;
                                }
                            }

                            if (result.equals(""))
                                Toast.makeText(getActivity(), "this ID: " + Var_athlete_id + " Does not exist", Toast.LENGTH_LONG).show();
                                else
                                querytextresult.setText(result);

                            break;

                        case 4:
                            String var_id = editText.getText().toString();

                            try {

                                documentReference1 = MainActivity.db.
                                        collection("Agwnas").
                                        document("" + var_id);

                                documentReference2 = MainActivity.db.
                                        collection("Team_Agwnas").
                                        document("" + var_id);

                                documentReference3=MainActivity.db.
                                        collection("Ind_Score_Agwnas").
                                        document(""+var_id);

                                documentReference4=MainActivity.db.
                                        collection("Ind_Agwnas").
                                        document(""+var_id);

                            /*
                            doCity=MainActivity.db.document("Agwnas/"+var_id+"/city");
                            String nameCity=doCity.getId();
                            Toast.makeText(getActivity(), "document City: "+nameCity, Toast.LENGTH_LONG).show();
                             */


                                documentReference1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        if (documentSnapshot.exists()) {
                                            id = documentSnapshot.getDouble("id"); // arxikopoinute epanw
                                            String city = documentSnapshot.getString("city");
                                            String date = documentSnapshot.getString("date");
                                            name = documentSnapshot.getString("name");
                                            String country = documentSnapshot.getString("country");
                                            result = result + "\nCity: " + city + "\nId: " + id + "\nCountry: " + country + "\nDate: " + date + "\nName: " + name;




                                            if (name.equals("Μπάσκετ")||name.equals("Βόλεϊ")||name.equals("Ποδόσφαιρο")||name.equals("Βόλεϊ") ) {      // gia omadika athlimata
                                                documentReference2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                                                    @Override
                                                    public void onSuccess(DocumentSnapshot documentSnapshot) {

                                                        if (documentSnapshot.exists()) {
                                                            String score = documentSnapshot.getString("score");
                                                            String team1 = documentSnapshot.getString("team1");
                                                            String team2 = documentSnapshot.getString("team2");

                                                            result = result + "\nScore: " + score + "\nTeam1: " + team1 + "\nTeam2: " + team2;
                                                            querytextresult.setText(result);
                                                        } else {

                                                        }
                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(getActivity(), "document does not exist.", Toast.LENGTH_LONG).show();
                                                    }
                                                });


                                            }

                                            if (name.equals("Βόξ")||name.equals("Πίνγκ πόνγκ")||name.equals("Τένις")) { // gia omadika athlimata
                                                documentReference3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                    @Override
                                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                        if (documentSnapshot.exists()) {
                                                            String score = documentSnapshot.getString("score");
                                                            Double id1 = documentSnapshot.getDouble("id1");
                                                            Double id2 = documentSnapshot.getDouble("id2");
                                                            result = result + "\nScore: "+score+"\nId1: "+id1+"\nId2: " +id2;
                                                            querytextresult.setText(result);
                                                        } else {

                                                        }
                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(getActivity(), "document does not exist.", Toast.LENGTH_LONG).show();
                                                    }
                                                });

                                            }

                                            if (name.equals("Στίβος")||name.equals("Άλμα")||name.equals("Ακόντιο")||name.equals("Ποδηλασία") ) { // gia omadika athlimata
                                                documentReference4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                    @Override
                                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                        if (documentSnapshot.exists()) {
                                                            //  Double id_athlimatos = documentSnapshot.getDouble("id");
                                                            Double id1 = documentSnapshot.getDouble("id1");
                                                            Double id2 = documentSnapshot.getDouble("id2");
                                                            Double id3 = documentSnapshot.getDouble("id3");
                                                            Double id4 = documentSnapshot.getDouble("id4");
                                                            String performance1 = documentSnapshot.getString("performance1");
                                                            String performance2 = documentSnapshot.getString("performance2");
                                                            String performance3 = documentSnapshot.getString("performance3");
                                                            String performance4 = documentSnapshot.getString("performance4");
                                                            result = result + "\nId1: " + id1 + "\nId2: " + id2 + "\nId3: " + id3 + "\nId4: " + id4 + "\nPerformance1: " + performance1
                                                                    + "\nPerformance2: " + performance2 + "\nPerformance3: " + performance3 + "\nPerformance4: " + performance4;

                                                            querytextresult.setText(result);
                                                        } else {

                                                        }
                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(getActivity(), "document does not exist.", Toast.LENGTH_LONG).show();
                                                    }
                                                });

                                            }
                                        } else {
                                            Toast.makeText(getActivity(), "GAME does not exist with this ID: " + var_id, Toast.LENGTH_LONG).show();
                                        }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                    }
                                });

                            } catch (Exception ex) {
                                querytextresult.setText("Αποτελέσματα");
                            }
                            break;

                        case 5:
                            List<Athlete> athlete=MainActivity.myDatabase.myDao().getAthletes();
                            for (Athlete i: athlete){
                                int code = i.getId();
                                String name= i.getName();
                                String surname= i.getSurname();
                                String city= i.getCity();
                                String country=i.getCountry();
                                String birth_date=i.getBirth_date();
                                int sport_code=i.getSport_id();
                                result=result +"\n Id: "+code+"\n Name: "+name+"\n Surname: "+surname+
                                        "\n City: "+city+"\n Country: "+country+"\n Birth Date: "
                                        +birth_date+"\n Sport Id: "+sport_code+"\n";


                            }
                            querytextresult.setText("");
                            querytextresult.setText(result);
                            break;

                        case 6:
                            List<Sport>sport=MainActivity.myDatabase.myDao().getSports();
                            for (Sport i:sport){
                                String name=i.getName();
                                String gender=i.getGender();
                                String teams=i.getTeam();
                                int code=i.getId();
                                result=result +"\n Id: "+code+"\nName: "+name+"\nGender: "+gender+"\nTeams: "+teams;

                            }
                            querytextresult.setText("");
                            querytextresult.setText(result);
                            break;
                        case 7:
                            List<Team>team=MainActivity.myDatabase.myDao().getTeams();
                            for (Team i:team){
                                int code=i.getId();
                                String name=i.getName();
                                String field_name=i.getField_name();
                                String city=i.getTeam_city();
                                String country=i.getTeam_country();
                                String year=i.getTeam_year();
                                int sport_id= i.getTeam_sport_id();
                                result=result+"\n Id: "+code+"\nName: "+name+"\nCity: "+city+"\nField_Name: "+field_name
                                        +"\nCountry: "+country+"\nYear Establishment: "+year+"\nSport ID: "+sport_id;
                            }
                            querytextresult.setText("");
                            querytextresult.setText(result);
                            break;
                    }
                    result = "";
                    editText.setText("");
                    editText.onEditorAction(EditorInfo.IME_ACTION_DONE);
                }
            });

            return view;

        }


    }

