package com.example.tp05;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.ConditionVariable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tp05.Entidades.SearchMovie;
import com.example.tp05.Utilities.LogHelper;
import com.example.tp05.Utilities.OMDBHelper;
import com.example.tp05.Utilities.StreamHelper;
import com.example.tp05.Utilities.ValidacionesHelpers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class SearchFragment extends Fragment {
    Button btnBuscar;
    EditText edtTexto;
    ListView lvResultado;

    View rootLayout;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootLayout == null){
            rootLayout = inflater.inflate(R.layout.fragment_search, container, false);
        }

        ObtenerReferencias();

        SetearListeners();

        return rootLayout;
    }

    private void ObtenerReferencias() {
        btnBuscar = (Button) rootLayout.findViewById(R.id.btnBuscar);
        edtTexto = (EditText) rootLayout.findViewById(R.id.edtTexto);
        lvResultado = (ListView) rootLayout.findViewById(R.id.lvResultado);
    }

    private void SetearListeners() {
        btnBuscar.setOnClickListener(btnBuscar_Click);
    }

    View.OnClickListener btnBuscar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tareaAsincronicaSearchMovie miTarea;
            String strSearchText;

            if (DatosValidos()){
                strSearchText = edtTexto.getText().toString();
                miTarea = new tareaAsincronicaSearchMovie(getActivity());
                miTarea.getSearchMovies(strSearchText);
            }
        }
    };

    private boolean DatosValidos() {
        boolean blnRetorno = true;
        String strMensaje= "";

        if (ValidacionesHelpers.esUnStringValido(edtTexto)){
            strMensaje += "Ingrese titulo de pelicula:\n";
            blnRetorno = false;
        }
        if (!blnRetorno){
            LogHelper.d("");
        }
        return blnRetorno;
    }

    private class tareaAsincronicaSearchMovie extends AsyncTask<Void, String,String> {
        private ProgressDialog dialog;
        private Context context;
        private String strURL;

        public tareaAsincronicaSearchMovie(Context context){
            this.context = context;
            dialog = new ProgressDialog(context);
        }

        private void setURL(String setURL) {this.strURL = setURL;}

        public void getSearchMovies (String strSearch){
            String strURL;
            strURL = OMDBHelper.getSearchURL(strSearch);
            setURL(strURL);
            execute();
        }

        @Override
        protected void onPreExecute(){
            this.dialog.setMessage("Buscando la informacion...");
            this.dialog.show();
        }

        @Override
        protected String doInBackground(Void ...parametros){
            HttpURLConnection miconexion = null;
            URL urlApi;
            String strResultado = "";

            LogHelper.d("doInBackground");

            try {
                urlApi = new URL(this.strURL);
                miconexion = (HttpURLConnection) urlApi.openConnection();
                miconexion.setRequestMethod("GET");
                if (miconexion.getResponseCode() == 200) {

                    strResultado = StreamHelper.GetFullStringFromInputReader(miconexion.getInputStream());
                    Thread.sleep(500);
                    publishProgress("conectando");
                    Thread.sleep(500);
                    publishProgress("leyendo");
                    Thread.sleep(500);
                    publishProgress("comparando");
                    Thread.sleep(500);
                    publishProgress("cerrando");
                } else {

                }
            } catch (Exception e){
                LogHelper.d ("al Conectar o procesar ocurrio un error" + e.getMessage());
            } finally {
                if (miconexion !=null){
                    miconexion.disconnect();
                }
            }
            return strResultado;
        }

        @Override
        protected void onPostExecute(String resultado){
            super.onPostExecute(resultado);
            ArrayList<SearchMovie> listMovie;
            listMovie = JSON(resultado);
            ArrayAdapter<SearchMovie> arrayAdapterMovie;
            arrayAdapterMovie = new ArrayAdapter<SearchMovie>(getContext(), android.R.layout.simple_list_item_1, listMovie);
            lvResultado.setAdapter(arrayAdapterMovie);

            if (listMovie.size()==0){
                Toast.makeText(getActivity(), "Error, No hay peliculas",Toast.LENGTH_LONG);
            }
            else{
                Toast.makeText(getActivity(), "Se encontraron [" + listMovie.size() + "]", Toast.LENGTH_LONG);
            }
        }

        private ArrayList <SearchMovie> JSON (String resultado) {
            ArrayList<SearchMovie> listReturn;
            SearchMovie movie;
            JSONObject jsonResponse;
            JSONArray searchoJsonArray;
            int intTotalResults, intYear;
            boolean blnResponse;
            String strTitle, strYear, strImdbID, srtType, strPoster;
            listReturn = new ArrayList<SearchMovie>();

        }
    }
}