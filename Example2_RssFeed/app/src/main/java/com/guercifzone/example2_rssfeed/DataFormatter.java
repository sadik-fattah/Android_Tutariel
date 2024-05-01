package com.guercifzone.example2_rssfeed;

import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class DataFormatter {
    private static final String TAG = "DataFormatter";
    ArrayList<RssFeed> feedData;
    public DataFormatter(){
        feedData= new ArrayList<>();
    }
    public ArrayList<RssFeed>getfeeDdATA(){
        return  feedData;
    }
    public boolean format(String s){
        boolean status = true;
        boolean inItem = false;
        RssFeed cdata = null;
        String value = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(s));
            int event  = parser.getEventType();
         while (event != XmlPullParser.END_DOCUMENT) {
                String tName = parser.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        if ("item".equalsIgnoreCase(tName)) {
                            inItem = true;
                            cdata = new RssFeed();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        value = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (inItem) {
                            if ("item".equalsIgnoreCase(tName)) {
                                inItem = false;
                                feedData.add(cdata);
                            } else if ("title".equalsIgnoreCase(tName)) {
                                cdata.setTitle(value);
                            } else if ("description".equalsIgnoreCase(tName)) {
                                cdata.setDescription(value);
                            } else if ("pubdata".equalsIgnoreCase(tName)) {
                                cdata.setPubDate(value);
                            }

                        }

                        break;
                }
                event= parser.next();
            }
        }catch (Exception e){
            Log.d(TAG,"format"+e);
            status = false;
        }
        return status;
    }
}
