package com.example.version10;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;


public class fragment_email extends Fragment {
    String random;
    Button button;
    EditText subject_text, body_text;
    RatingBar ratingBar;
  //  private boolean isReached = false;
    public fragment_email() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_email, container,false);
        body_text=view.findViewById(R.id.body_text);
        subject_text=view.findViewById(R.id.subject_text);
        button=view.findViewById(R.id.button_feedback);
        ratingBar=view.findViewById(R.id.simpleRatingBar);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                    String body;
                    String stars;
                    String username = subject_text.getText().toString();
                    if (body_text.equals(""))
                        body = " Δεν εβαλε";
                    else
                        body = body_text.getText().toString();
                    stars = "" + ratingBar.getRating();
                    String newbody = "O Χρήστης έβαλε: " + stars + " Αστέρια. Κείμενο: " + body;
                    Rating ratings = new Rating();
                    ratings.setUsername(username);
                    ratings.setBody(newbody);
                    random = GeneratePassword.randomString(30);
                    MainActivity.db.
                            collection("Ratings").
                            document("" + random).set(ratings).
                            addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getActivity(), "Rating Added", Toast.LENGTH_LONG).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(), "Rating Stars operation failed.", Toast.LENGTH_LONG).show();
                                }
                            });
            }
        });
        ratingBar.setNumStars(0);
        subject_text.setText("");
        body_text.setText("");



        return view;



    }

}


