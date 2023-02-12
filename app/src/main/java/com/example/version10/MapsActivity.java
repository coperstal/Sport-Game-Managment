package com.example.version10;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class
MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    static final LatLng THESSALONIKI = new LatLng(40.6333, 22.9500);
    static final LatLng ATHENS = new LatLng(37.9794,   23.7161);
    static final LatLng PARIS = new LatLng(48.8566 ,2.3522);
    static final LatLng BARCELONA = new LatLng(41.3825,    2.1769);
    static final LatLng LONDON = new LatLng(51.5072,   -0.1275);
    static final LatLng BERLIN = new LatLng(52.5167,   13.3833);
    static final LatLng MADRID = new LatLng(40.4189,   -3.6919);
    static final LatLng MILAN = new LatLng(45.4669,    9.1900);
    static final LatLng ROME = new LatLng(41.8931, 12.4828);
    static final LatLng MANCHESTER = new LatLng(53.4794,   -2.2453);


    Query docRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    //THESSALONIKI
    ArrayList <String>athlete_thes=new  ArrayList<String>();
    ArrayList <String> omades_thes=new  ArrayList<String>();
    String at_thes;
    String om_thes;

    //ATHENS
    ArrayList <String>athlete_ath=new  ArrayList<String>();
    ArrayList <String> omades_ath=new  ArrayList<String>();
    String at_ath;
    String om_ath;

    //PARIS
    ArrayList <String>athlete_pari=new  ArrayList<String>();
    ArrayList <String> omades_pari=new  ArrayList<String>();
    String at_pari;
    String om_pari;

    //BARCELONA
    ArrayList <String>athlete_barc=new  ArrayList<String>();
    ArrayList <String> omades_barc=new  ArrayList<String>();
    String at_barc;
    String om_barc;

    //LONDON
    ArrayList <String>athlete_lond=new  ArrayList<String>();
    ArrayList <String> omades_lond=new  ArrayList<String>();
    String at_lond;
    String om_lond;

    //BERLIN
    ArrayList <String>athlete_berl=new  ArrayList<String>();
    ArrayList <String> omades_berl=new  ArrayList<String>();
    String at_berl;
    String om_berl;

    //MADRID
    ArrayList <String>athlete_madrid=new  ArrayList<String>();
    ArrayList <String> omades_madrid=new  ArrayList<String>();
    String at_mad;
    String om_mad;

    //MILAN
    ArrayList <String>athlete_milan=new  ArrayList<String>();
    ArrayList <String> omades_milan=new  ArrayList<String>();
    String at_mila;
    String om_mila;

    //ROME
    ArrayList <String>athlete_rome=new  ArrayList<String>();
    ArrayList <String> omades_rome=new  ArrayList<String>();
    String at_rom;
    String om_rom;

    //MANCHESTER
    ArrayList <String>athlete_machester=new  ArrayList<String>();
    ArrayList <String> omades_manchester=new  ArrayList<String>();
    String at_manch;
    String om_manch;


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //THESSALONIKI
        List<Athlete> athlete1=MainActivity.myDatabase.myDao().getAthletes();
        List<Team>team1=MainActivity.myDatabase.myDao().getTeams();

        //ATHENS
        List<Athlete> athlete2=MainActivity.myDatabase.myDao().getAthletes();
        List<Team>team2=MainActivity.myDatabase.myDao().getTeams();

        //BARCELONA
        List<Athlete> athlete3=MainActivity.myDatabase.myDao().getAthletes();
        List<Team>team3=MainActivity.myDatabase.myDao().getTeams();

        //LONDON
        List<Athlete> athlete4=MainActivity.myDatabase.myDao().getAthletes();
        List<Team>team4=MainActivity.myDatabase.myDao().getTeams();

        //BERLIN
        List<Athlete> athlete5=MainActivity.myDatabase.myDao().getAthletes();
        List<Team>team5=MainActivity.myDatabase.myDao().getTeams();

        //PARIS
        List<Athlete> athlete6=MainActivity.myDatabase.myDao().getAthletes();
        List<Team>team6=MainActivity.myDatabase.myDao().getTeams();



        //MADRID
        List<Athlete> athlete7=MainActivity.myDatabase.myDao().getAthletes();
        List<Team>team7=MainActivity.myDatabase.myDao().getTeams();

        //MILAN
        List<Athlete> athlete8=MainActivity.myDatabase.myDao().getAthletes();
        List<Team>team8=MainActivity.myDatabase.myDao().getTeams();

        //ROME
        List<Athlete> athlete9=MainActivity.myDatabase.myDao().getAthletes();
        List<Team>team9=MainActivity.myDatabase.myDao().getTeams();

        //MANCHESTER
        List<Athlete> athlete10=MainActivity.myDatabase.myDao().getAthletes();
        List<Team>team10=MainActivity.myDatabase.myDao().getTeams();








             try {   //THESSALONIKI
            for (Athlete i : athlete1) {
                if (i.getCity().equals("Θεσσαλονίκη"))
                    athlete_thes.add(i.getName());
            }

            for (Team j:team1){
                if(j.getTeam_city().equals("Θεσσαλονίκη"))
                    omades_thes.add(j.getName());}


            //ATHENS
            for (Athlete i : athlete2) {
                if (i.getCity().equals("Αθήνα"))
                    athlete_ath.add(i.getName());
            }

            for (Team j:team2){
                if(j.getTeam_city().equals("Αθήνα"))
                    omades_ath.add(j.getName());}

            //BARCELONA
            for (Athlete i : athlete3) {
                if (i.getCity().equals("Βαρκελώνη"))
                    athlete_barc.add(i.getName()); }


            for (Team j:team3){
                if(j.getTeam_city().equals("Βαρκελώνη"))
                    omades_barc.add(j.getName());}


            //LONDON
            for (Athlete i : athlete4) {
                if (i.getCity().equals("Λονδίνο"))
                    athlete_lond.add(i.getName()); }


            for (Team j:team4){
                if(j.getTeam_city().equals("Λονδίνο"))
                    omades_lond.add(j.getName());}


            //BERLIN
            for (Athlete i : athlete5) {
                if (i.getCity().equals("Βερολίνο"))
                    athlete_berl.add(i.getName()); }


            for (Team j:team5){
                if(j.getTeam_city().equals("Βερολίνο"))
                    omades_berl.add(j.getName());}



            //PARIS
            for (Athlete i : athlete6) {
                if (i.getCity().equals("Παρίσι"))
                    athlete_pari.add(i.getName()); }


            for (Team j:team6){
                if(j.getTeam_city().equals("Παρίσι"))
                    omades_pari.add(j.getName()); }




            //MADRID
            for (Athlete i : athlete7) {
                if (i.getCity().equals("Μαδρήτη"))
                    athlete_madrid.add(i.getName());
            }

            for (Team j:team7){
                if(j.getTeam_city().equals("Μαδρήτη"))
                    omades_madrid.add(j.getName());}
            //MILAN
            for (Athlete i : athlete8) {
                if (i.getCity().equals("Μιλάνο"))
                    athlete_milan.add(i.getName());
            }

            for (Team j:team8){
                if(j.getTeam_city().equals("Μιλάνο"))
                    omades_milan.add(j.getName());}
            //ROME
            for (Athlete i : athlete9) {
                if (i.getCity().equals("Ρώμη"))
                    athlete_rome.add(i.getName());
            }

            for (Team j:team9){
                if(j.getTeam_city().equals("Ρώμη"))
                    omades_rome.add(j.getName());}

            //MANCHESTER
            for (Athlete i : athlete10) {
                if (i.getCity().equals("Μάντσεστερ"))
                    athlete_machester.add(i.getName());
            }

            for (Team j:team10){
                if(j.getTeam_city().equals("Μάντσεστερ"))
                    omades_manchester.add(j.getName());}


            if((athlete_thes != null) && (omades_thes != null)) {
                //THESSALONIKI
                String var_ath_1[] = new String[athlete_thes.size()];
                for (int i = 0; i < var_ath_1.length; i++) {
                    var_ath_1[i] = athlete_thes.get(i) ;
                }

                at_thes = Arrays.toString(var_ath_1);
                at_thes = at_thes.substring(1, at_thes.length() - 1);


                String var_ath_2[] = new String[omades_thes.size()];
                for (int i = 0; i < var_ath_2.length; i++) {
                    var_ath_2[i] = omades_thes.get(i);
                }

                om_thes = Arrays.toString(var_ath_2);
                om_thes = om_thes.substring(1, om_thes.length() - 1);


                //ATHENS
                String var_ath_3[] = new String[athlete_ath.size()];
                for (int i = 0; i < var_ath_3.length; i++) {
                    var_ath_3[i] = athlete_ath.get(i) ;
                }

                at_ath = Arrays.toString(var_ath_3);
                at_ath = at_ath.substring(1, at_ath.length() - 1);


                String var_ath_4[] = new String[omades_ath.size()];
                for (int i = 0; i < var_ath_4.length; i++) {
                    var_ath_4[i] = omades_ath.get(i);
                }

                om_ath = Arrays.toString(var_ath_4);
                om_ath = om_ath.substring(1, om_ath.length() - 1);







                //BARCELONA
                String var_ath_5[] = new String[athlete_barc.size()];
                for (int i = 0; i < var_ath_5.length; i++) {
                    var_ath_5[i] = athlete_barc.get(i) ;
                }

                at_barc = Arrays.toString(var_ath_5);
                at_barc = at_barc.substring(1, at_barc.length() - 1);


                String var_ath_6[] = new String[omades_barc.size()];
                for (int i = 0; i < var_ath_6.length; i++) {
                    var_ath_6[i] = omades_barc.get(i);
                }

                om_barc= Arrays.toString(var_ath_6);
                om_barc = om_barc.substring(1, om_barc.length() - 1);


                //LONDON
                String var_ath_7[] = new String[athlete_lond.size()];
                for (int i = 0; i < var_ath_7.length; i++) {
                    var_ath_7[i] = athlete_lond.get(i) ;
                }

                at_lond = Arrays.toString(var_ath_7);
                at_lond = at_lond.substring(1, at_lond.length() - 1);


                String var_ath_8[] = new String[omades_lond.size()];
                for (int i = 0; i < var_ath_8.length; i++) {
                    var_ath_8[i] = omades_lond.get(i);
                }

                om_lond = Arrays.toString(var_ath_8);
                om_lond = om_lond.substring(1, om_lond.length() - 1);



                //BERLIN
                String var_ath_9[] = new String[athlete_berl.size()];
                for (int i = 0; i < var_ath_9.length; i++) {
                    var_ath_9[i] = athlete_berl.get(i) ;
                }

                at_berl = Arrays.toString(var_ath_9);
                at_berl = at_berl.substring(1, at_berl.length() - 1);


                String var_ath_10[] = new String[omades_berl.size()];
                for (int i = 0; i < var_ath_10.length; i++) {
                    var_ath_10[i] = omades_berl.get(i);
                }

                om_berl = Arrays.toString(var_ath_10);
                om_berl = om_berl.substring(1, om_berl.length() - 1);


                //PARIS
                String var_ath_11[] = new String[athlete_pari.size()];
                for (int i = 0; i < var_ath_11.length; i++) {
                    var_ath_11[i] = athlete_pari.get(i) ;
                }

                at_pari = Arrays.toString(var_ath_11);
                at_pari = at_pari.substring(1, at_pari.length() - 1);


                String var_ath_12[] = new String[omades_pari.size()];
                for (int i = 0; i < var_ath_12.length; i++) {
                    var_ath_12[i] = omades_pari.get(i);
                }

                om_pari = Arrays.toString(var_ath_12);
                om_pari = om_pari.substring(1, om_pari.length() - 1);



                //MADRID
                String var_ath_14[] = new String[athlete_madrid.size()];
                for (int i = 0; i < var_ath_14.length; i++) {
                    var_ath_14[i] = athlete_madrid.get(i) ;
                }

                at_mad = Arrays.toString(var_ath_14);
                at_mad = at_mad.substring(1, at_mad.length() - 1);


                String var_ath_15[] = new String[omades_madrid.size()];
                for (int i = 0; i < var_ath_4.length; i++) {
                    var_ath_15[i] = omades_madrid.get(i);
                }

                om_mad = Arrays.toString(var_ath_15);
                om_mad = om_mad.substring(1, om_mad.length() - 1);


                //MILAN
                String var_ath_16[] = new String[athlete_milan.size()];
                for (int i = 0; i < var_ath_16.length; i++) {
                    var_ath_16[i] = athlete_milan.get(i) ;
                }

                at_mila = Arrays.toString(var_ath_16);
                at_mila = at_mila.substring(1, at_mila.length() - 1);


                String var_ath_17[] = new String[omades_milan.size()];
                for (int i = 0; i < var_ath_17.length; i++) {
                    var_ath_17[i] = omades_milan.get(i);
                }

                om_mila = Arrays.toString(var_ath_17);
                om_mila = om_mila.substring(1, om_mila.length() - 1);


                //ROME
                String var_ath_18[] = new String[athlete_rome.size()];
                for (int i = 0; i < var_ath_18.length; i++) {
                    var_ath_18[i] = athlete_rome.get(i) ;
                }

                at_rom = Arrays.toString(var_ath_18);
                at_rom = at_rom.substring(1, at_rom.length() - 1);


                String var_ath_19[] = new String[omades_rome.size()];
                for (int i = 0; i < var_ath_19.length; i++) {
                    var_ath_19[i] = omades_rome.get(i);
                }

                om_rom = Arrays.toString(var_ath_19);
                om_rom = om_rom.substring(1, om_rom.length() - 1);



                //MANCHESTER
                String var_ath_20[] = new String[athlete_machester.size()];
                for (int i = 0; i < var_ath_20.length; i++) {
                    var_ath_20[i] = athlete_machester.get(i) ;
                }

                at_manch = Arrays.toString(var_ath_20);
                at_manch = at_manch.substring(1, at_manch.length() - 1);


                String var_ath_21[] = new String[omades_manchester.size()];
                for (int i = 0; i < var_ath_21.length; i++) {
                    var_ath_21[i] = omades_manchester.get(i);
                }

                om_manch= Arrays.toString(var_ath_21);
                om_manch = om_manch.substring(1, om_manch.length() - 1);




            }

            mMap.addMarker(new MarkerOptions().position(THESSALONIKI).title("Αθλητές & Όμάδες").snippet(at_thes+" "+om_thes).draggable(true));
            mMap.addMarker(new MarkerOptions().position(ATHENS).title("Αθλητές & Όμάδες").snippet(at_ath+" "+om_ath).draggable(true));
            mMap.addMarker(new MarkerOptions().position(PARIS).title("Αθλητές & Όμάδες").snippet(at_pari+" "+om_pari).draggable(true));
            mMap.addMarker(new MarkerOptions().position(BARCELONA).title("Αθλητές & Όμάδες").snippet(at_barc+" "+om_barc).draggable(true));
            mMap.addMarker(new MarkerOptions().position(BERLIN).title("Αθλητές & Όμάδες").snippet(at_berl+" "+om_berl).draggable(true));
            mMap.addMarker(new MarkerOptions().position(LONDON).title("Αθλητές & Όμάδες").snippet(at_lond+" "+om_lond).draggable(true));
            mMap.addMarker(new MarkerOptions().position(MADRID).title("Αθλητές & Όμάδες").snippet(at_mad+" "+om_mad).draggable(true));
            mMap.addMarker(new MarkerOptions().position(MILAN).title("Αθλητές & Όμάδες").snippet(at_mila+" "+om_mila).draggable(true));
            mMap.addMarker(new MarkerOptions().position(ROME).title("Αθλητές & Όμάδες").snippet(at_rom+" "+om_rom).draggable(true));
            mMap.addMarker(new MarkerOptions().position(MANCHESTER).title("Αθλητές & Όμάδες").snippet(at_manch+" "+om_manch).draggable(true));

            mMap.moveCamera(CameraUpdateFactory.newLatLng(MANCHESTER));

        } catch (Exception e) {
            String message = e.getMessage();
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
    }


}