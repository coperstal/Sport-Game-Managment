package com.example.version10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class about_fragment extends Fragment {
    TextView queryText;

    public about_fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment, container, false);
        queryText = view.findViewById(R.id.textView9);
        String result="Η Εφαρμογή δημιουργήθηκε από τους φοιτητές Μιλτιάδη Παπαμαυρουδή και" +
                " Σταύρο Σαρηκυριακίδη στο πλαίσιο του" +
                "μαθήματος Προηγμένα Θέματα Αλληλεπίδρασης (Προγραμματισμός Κινητών Συσκευών)" +
                " του τμήματος Μηχανικών Πληροφορικής και Ηλεκτρονικών Συστημάτων.\n\n" +
                "-Εαρινό εξάμηνο 2021-";

        queryText.setText(result);
        return view;
    }
}

