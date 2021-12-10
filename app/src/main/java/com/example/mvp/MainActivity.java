package com.example.mvp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mvp.Adapters.GarageAdapter;
import com.example.mvp.Fragments.Home;
import com.example.mvp.Fragments.Profile;
import com.example.mvp.Fragments.Search;
import com.example.mvp.models.Garage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    BottomNavigationView bottomNavigationView;
    private RecyclerView  garageRv;
    private ArrayList<Garage> garageArrayList;

    @BindView(R.id.bookings)
    TextView bookings;

    @BindView(R.id.getservice) TextView services;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        garageRv = findViewById(R.id.idRVgarage);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        garageArrayList = new ArrayList<>();
        garageArrayList.add(new Garage("Toyota Kenya", 4, R.drawable.attalogo));
        garageArrayList.add(new Garage("Maxluga Auto", 5, R.drawable.attalogo));
        garageArrayList.add(new Garage("Unity Auto Garage", 4, R.drawable.attalogo));
        garageArrayList.add(new Garage("Tj and U Garage", 5, R.drawable.attalogo));
        garageArrayList.add(new Garage("Auto Centre Buruburu", 4, R.drawable.attalogo));
        garageArrayList.add(new Garage("A One Auto Car Garage", 3, R.drawable.attalogo));

        Adapter GarageAdapter = (Adapter) new GarageAdapter(this, garageArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        garageRv.setLayoutManager(linearLayoutManager);
        garageRv.setAdapter((RecyclerView.Adapter) GarageAdapter);



        bottomNavigationView = findViewById(R.id.bottom_nav_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.profile);


     bookings.setOnClickListener(this);
     services.setOnClickListener(this);


    }



    Home firstFragment = new Home();
    Profile secondFragment = new Profile();
    Search thirdFragment = new Search();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
                return true;

            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                return true;

            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
                return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()) {
        case R.id.bookings:
            startActivity(new Intent(this, Bookings.class));
            break;

        case R.id.service:
            startActivity(new Intent(this, Services.class));
            break;
    }
        }
    }
