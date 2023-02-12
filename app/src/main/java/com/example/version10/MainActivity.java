package com.example.version10;

//VERSION 4.9

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

//import android.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
// import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;


public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
    public static FirebaseFirestore db;
    public static FragmentManager fragmentManager;
    public static MyDatabase myDatabase;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private GoogleMap mMap;
    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ImageView imageView=findViewById(R.id.image_view);

        db= FirebaseFirestore.getInstance();
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "AthleteBD").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container,new RoomUI_Fragment()).commit();

        }


        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(findViewById(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container,new RoomUI_Fragment()).commit();

        }



    }

    @Override
    public void onBackPressed() {
        drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
        }if(fragment instanceof RoomUI_Fragment){
            super.onBackPressed();
        }
        else {
            showHome();
        }


    }
    public void exited () {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.exit:{
                exited();               //Exit the app
                     break;
            }
            case R.id.home:{            //Home
                fragmentManager.beginTransaction().replace(R.id.fragment_container,new RoomUI_Fragment()).commit();
                break;
            }
            case R.id.about:{               //About the app
                fragmentManager.beginTransaction().replace(R.id.fragment_container,new about_fragment()).commit();
                break;
            }
            case R.id.contact:{             //Contact us
                fragmentManager.beginTransaction().replace(R.id.fragment_container,new fragment_email()).commit();
                break;
            }
            case R.id.search:{             //Search
                fragmentManager.beginTransaction().replace(R.id.fragment_container,new fragment_search()).commit();
                break;
            }case R.id.theMap:{           //Map
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
                break;
            }
    }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
}

    private void showHome(){
        Fragment fragment= new RoomUI_Fragment();
        if(fragment!=null){
            FragmentManager manager=getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container,new RoomUI_Fragment()).commit();
        }

    }



    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}