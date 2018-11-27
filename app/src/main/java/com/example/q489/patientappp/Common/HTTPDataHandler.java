package com.example.q489.patientappp.Common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPDataHandler {
    static String stream = null;

    public DataHandler (){

    }

    public String getHTTPData(String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
