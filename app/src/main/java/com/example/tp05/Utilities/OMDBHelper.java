package com.example.tp05.Utilities;

public class OMDBHelper {
    private static final String APIKey = "81a327d5";
    private static final String BaseURL = "https://www.omdbapi.com/";

    public static String getSearchURL(String strSearch){
        String strReturnValue;
        strReturnValue = String.format("%s?apikey=%s&s=%s",BaseURL, APIKey, strSearch);
        return strReturnValue;
    }

    public static String getMovieURL(String strId){
        String strReturnValue;
        strReturnValue = String.format("%s?apikey=%s&i=%s",BaseURL, APIKey, strId);
        return strReturnValue;
    }

}
