package com.example.tp05;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp05.Entidades.SearchMovie;
import com.example.tp05.Entidades.SearchResponse;


public class MovieFragment extends MainActivity {
    TextView tvPelicula, tvDatos, tvDescripcion;
    ImageView ivPoster;
    View rootLayout = null;
    SearchResponse movie = null;

    public MovieFragment(){
    }

    public void setMovie(SearchMovie movie){
        movie = movie;
    }

    public void mostrarMovie(){
        if(movie != null){
        String strTitle = movie.getTitle();
        tvPelicula.setText(strTitle);
        String strDatos = movie.getYear() + " " + movie.getType();
        tvDatos.setText(strDatos);
        String strURLivPoster = movie.getPoster();
        }
        else{
            Toast.makeText(getActivity(), "No existe", Toast.LENGTH_LONG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(rootLayout == null){
            rootLayout = inflater.inflate(R.layout.fragment_movie, container, false);
        }

        ObtenerReferencias();

        SetearListeners();

        this.setTitle("Movie");

        return rootLayout;
    }

    private void ObtenerReferencias(){
        tvPelicula = (TextView) rootLayout.findViewById(R.id.tvPelicula);
        tvDatos = (TextView)rootLayout.findViewById(R.id.tvDatos);
        tvDescripcion = (TextView)rootLayout.findViewById(R.id.tvDescripcion);
        ivPoster = (ImageView)rootLayout.findViewById(R.id.ivPoster);
    }

    private void SetearListeners(){

    }
    }
