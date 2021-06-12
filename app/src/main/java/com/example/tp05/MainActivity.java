package com.example.tp05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SearchFragment searchFragment;
    MovieFragment movieFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CrearFragments();

       // goToFragmenWithReplace(R.id.fraContenedor, searchFragment, false);

    }

    private void CrearFragments() {
        searchFragment = new SearchFragment();
        movieFragment = new MovieFragment();
    }


}