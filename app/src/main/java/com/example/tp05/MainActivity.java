package com.example.tp05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SearchFragment searchFragment;
    MovieFragment movieFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CrearFragments();

        ReemplazarFragment(searchFragment);
    }

    private void CrearFragments() {
        searchFragment = new SearchFragment();
        movieFragment = new MovieFragment();
    }

    public void ReemplazarFragment (Fragment fragmento){
        FragmentManager manager;
        FragmentTransaction transaction;

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fraContenedor, fragmento,null);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void irMovieFragment(){
        ReemplazarFragment(movieFragment);
    }

    public void irASearchFragment(){
        ReemplazarFragment(searchFragment);
    }

}