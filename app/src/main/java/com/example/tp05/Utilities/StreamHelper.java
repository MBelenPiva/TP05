package com.example.tp05.Utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamHelper {
    public static String GetFullStringFromInputReader (InputStream straemDeEntrada){
        BufferedReader responseReader;
        String responseLine;
        String strResultado = null;
        StringBuilder sbResponse;

        try{
            responseReader = new BufferedReader(new InputStreamReader(straemDeEntrada));
            sbResponse = new StringBuilder();
            while ((responseLine = responseReader.readLine()) !=null){
                sbResponse.append(responseLine);
            }
            responseReader.close();

            strResultado = sbResponse.toString();
        } catch (Exception e){
        }
        return strResultado;
    }
}
