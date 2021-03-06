package com.example.tp05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.tp05.Bases.BaseActivity;
import com.example.tp05.Entidades.SearchMovie;

import javax.xml.transform.Result;

public class MainActivity extends BaseActivity {

    SearchFragment searchFragment;
    MovieFragment movieFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CrearFragments();
        goToFragmentWithReplace(R.id.fraContenedor, searchFragment, false);
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

    public void irAMovieFragment(){
        ReemplazarFragment(movieFragment);
    }

    public void irASearchFragment(SearchMovie movie){
        MovieFragment.setMovie(movie);
        irASearchFragment(movieFragment);

    }

}