package com.example.tp05.Bases;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tp05.MainActivity;
import com.example.tp05.R;

public class BaseFragment extends Fragment {

    private static int cuantosClicks=0;

    public void setTitle(String strTitulo){

        MainActivity actividadContenedora;
        actividadContenedora = (MainActivity) getActivity();
        actividadContenedora.setTitle(strTitulo);

    }

}