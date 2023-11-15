package com.example.bit_cube;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class Principal extends AppCompatActivity {

    AnimatedBottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        bottomBar = findViewById(R.id.bottom_bar);
        replace(new HomeFragment());

        bottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NonNull AnimatedBottomBar.Tab tab1) {
                if(tab1.getId()==R.id.home){
                    replace(new HomeFragment());
                } else if (tab1.getId()==R.id.info) {
                    replace(new infoFragment());
                } else if (tab1.getId()==R.id.infante) {
                    replace(new InfanteFragment());
                } else if (tab1.getId()==R.id.perfil) {
                    replace(new ProfileFragment());

                }
            }

            @Override
            public void onTabReselected(int i, @NonNull AnimatedBottomBar.Tab tab) {

            }
        });


    }

    private void replace(Fragment fragment){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);

        transaction.commit();

    }
}
