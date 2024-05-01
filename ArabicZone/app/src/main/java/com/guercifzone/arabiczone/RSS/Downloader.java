package com.guercifzone.arabiczone.RSS;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class Downloader extends AsyncTask<Void,Void,Object> {

    Context c;
    String urlAddress;
    RecyclerView rv;

    ProgressDialog pd;

    public Downloader(Context c, String urlAddress, RecyclerView rv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Fetch Article");
        pd.setMessage("Fetching...Please wait");
        pd.show();
    }

    @Override
    protected Object doInBackground(Void... params) {
        return downloadData();
    }

    @Override
    protected void onPostExecute(Object data) {
        super.onPostExecute(data);

        pd.dismiss();

        if(data.toString().startsWith("Error"))
        {
            Toast.makeText(c, data.toString(), Toast.LENGTH_SHORT).show();
        }else {
            //PARSE

            new RSSParser(c, (InputStream) data,rv).execute();
        }
    }
    private Object downloadData()
    {
        Object connection=Connector.connect(urlAddress);
        if(connection.toString().startsWith("Error"))
        {
            return connection.toString();
        }

        try
        {
            HttpURLConnection con= (HttpURLConnection) connection;
            int responseCode=con.getResponseCode();

            if(responseCode==con.HTTP_OK)
            {
                InputStream is=new BufferedInputStream(con.getInputStream());
                return is;
            }

            return ErrorTracker.RESPONSE_EROR + con.getResponseMessage();


        } catch (IOException e) {
            e.printStackTrace();
            return ErrorTracker.IO_EROR;
        }
    }
}
