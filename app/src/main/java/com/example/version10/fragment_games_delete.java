package com.example.version10;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Source;

public class fragment_games_delete extends Fragment {

    EditText deleteText;
    Button deleteButton;
    DocumentReference docRef,docRef2,docRef3,docRef4;
    int flag=0;


    public fragment_games_delete() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_games_delete, container, false);
        deleteText = view.findViewById(R.id.game_id);

        deleteButton = view.findViewById(R.id.delete_game_button);
        deleteButton.setOnClickListener((v) -> {

            int Var_game_id = 0;
            try {
                Var_game_id = Integer.parseInt(deleteText.getText().toString());

            } catch (NumberFormatException ex) {
                System.out.println("Could not parse" + ex);

            }
            Game game = new Game();








           docRef = MainActivity.db.collection("Agwnas").document(""+Var_game_id);



            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){




                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task){
                    if (task.isSuccessful()) {
                       DocumentSnapshot document = task.getResult();
                    if (!document.exists()) {
                        flag++;
                      //  Toast.makeText(getActivity(), "Error Deleting", Toast.LENGTH_SHORT).show();
                    }
                    else{docRef.delete()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                  //  Toast.makeText(getActivity(), "Game Deleted successfully", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    } }});



            docRef2 = MainActivity.db.collection("Ind_Agwnas").document(""+Var_game_id);

            docRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task){
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (!document.exists()) {
                            flag++;
                            //Toast.makeText(getActivity(), "Error Deleting", Toast.LENGTH_SHORT).show();
                        }
                        else{docRef2.delete()

                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                        // Toast.makeText(getActivity(), "Game Deleted successfully", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        }
                    } }});

            docRef3 = MainActivity.db.collection("Ind_Score_Agwnas").document(""+Var_game_id);
            docRef3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task){
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (!document.exists()) {
                            flag++;
                           // Toast.makeText(getActivity(), "Error Deleting", Toast.LENGTH_SHORT).show();
                        }
                        else{docRef3.delete()

                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                       // Toast.makeText(getActivity(), "Game Deleted successfully", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        }
                    } }});

            docRef4 = MainActivity.db.collection("Team_Agwnas").document(""+Var_game_id);

            docRef4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>(){
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task){
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (!document.exists()) {
                            flag++;
                            //Toast.makeText(getActivity(), "Error Deleting", Toast.LENGTH_SHORT).show();
                        }
                        else{docRef4.delete()

                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                       // Toast.makeText(getActivity(), "Game Deleted successfully", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        }
                    } }});


                if(flag>0)
                    Toast.makeText(getActivity(), " Deleted ERROR!!!!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), "Game Deleted successfully!", Toast.LENGTH_SHORT).show();





        });
        return view;

    }
}