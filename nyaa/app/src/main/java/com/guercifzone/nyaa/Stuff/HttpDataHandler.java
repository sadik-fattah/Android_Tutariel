package com.guercifzone.nyaa.Stuff;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpDataHandler {
    static String stream = null;
    public HttpDataHandler(){

    }


    public  String GetHttpData(String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine()) !=null){
                    sb.append(line);
                    stream = sb.toString();
                    urlConnection.disconnect();
                }
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
            return  ErrorHandler.WRONG_URL_FORMAT;
        }catch (IOException e){
            e.printStackTrace();
           return ErrorHandler.CONNECTION_ERROR;
        }
        return stream;
    }
}
