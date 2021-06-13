package com.example.tp05;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MovieFragment extends BaseFragment {
    TextView tvPelicula, tvDatos, tvDescripcion;
    ImageView ivPoster;

    View rootLayout;
    public MovieFragment(){

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
