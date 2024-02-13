package com.example.ganadariasplus;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Principal extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        navigation = findViewById(R.id.navigationBar);

        navigation.setOnNavigationItemSelectedListener(this);

        navigation.setSelectedItemId(R.id.explotacion);

    }

    FirstFragmenExplotaciones fragmenExplotaciones = new FirstFragmenExplotaciones();
    ThirdFragmentUsuario fragmentUsuario = new ThirdFragmentUsuario();


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.explotacion){
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragmenExplotaciones).commit();
            return true;
        } else if (item.getItemId() == R.id.ganadero){
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fragmentUsuario).commit();
            return true;
        }
        return false;
    }
}
