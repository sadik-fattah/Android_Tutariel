package com.guercifzone.arabiczone.RSS;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.guercifzone.arabiczone.DataObject.Article;
import com.guercifzone.arabiczone.UI.MyAdapter;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RSSParser extends AsyncTask<Void,Void,Boolean> {

    Context c;
    InputStream is;
    RecyclerView rv;

    ProgressDialog pd;
    ArrayList<Article> articles=new ArrayList<>();

    public RSSParser(Context c, InputStream is, RecyclerView rv) {
        this.c = c;
        this.is = is;
        this.rv = rv;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseRSS();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        pd.dismiss();
        if(isParsed)
        {
            //BIND
            rv.setAdapter(new MyAdapter(c,articles));

        }else {
            Toast.makeText(c,"Unable To Parse",Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parseRSS()
    {
        try
        {
            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            XmlPullParser parser=factory.newPullParser();

            parser.setInput(is,null);
            int event=parser.getEventType();

            String tagValue=null;
            Boolean isSiteMeta=true;

            articles.clear();
            Article article=new Article();

            do {

                String tagName=parser.getName();

                switch (event)
                {
                    case XmlPullParser.START_TAG:
                        if(tagName.equalsIgnoreCase("item"))
                        {
                            article=new Article();
                            isSiteMeta=false;
                        }
                        break;

                    case XmlPullParser.TEXT:
                        tagValue=parser.getText();
                        break;

                    case XmlPullParser.END_TAG:

                        if(!isSiteMeta)
                        {
                            if(tagName.equalsIgnoreCase("title"))
                            {
                                article.setTitle(tagValue);
                            }else if(tagName.equalsIgnoreCase("description"))
                            {
                                String desc=tagValue;
                                article.setDescription(desc.substring(desc.indexOf("/>")+2));

                                //EXTRACT IMAGE FROM DESC
                                String imageUrl=desc.substring(desc.indexOf("src=")+5,desc.indexOf("png")+3);
                                article.setImageUrl(imageUrl);


                            }else if(tagName.equalsIgnoreCase("pubDate"))
                            {
                                article.setDate(tagValue);
                            }

                        }

                        if(tagName.equalsIgnoreCase("item"))
                        {
                            articles.add(article);
                            isSiteMeta=true;
                        }

                        break;

                }



                event=parser.next();

            }while (event != XmlPullParser.END_DOCUMENT);

            return true;

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }












}