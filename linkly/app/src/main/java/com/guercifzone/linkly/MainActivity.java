package com.guercifzone.linkly;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListView list;

    String[] urls ={
            "https://www.yoururl1.com/","https://www.yoururl2.com/",
            "https://www.yoururl3.com/","https://www.yoururl4.com/",
            "https://www.yoururl5.com/","https://www.yoururl6.com/",
            "https://www.yoururl7.com/","https://www.yoururl8.com/",
            "https://www.yoururl9.com/","https://www.yoururl19.com/",
    };

    String[] emails ={
            "email_1@mail.com","email_2@mail.com",
            "email_3@mail.com","email_4@gmail.com",
            "email_5@mail.com","email_6@mail.com",
            "email_7@mail.com","email_8@mail.com",
            "email_9@gmail.com","email_10@mail.com"
    };

    String[] phoneNumber ={
            "+(1234)-567","+(1234)-567",
            "7563654321","9475000000","8575000000",
            "+1 (919) 555-1212","+91 (919) 555-1212",
            "6463654321","5475000000","8575000000",
    };

    Integer[] imgid={
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListAdapter adapter=new MyListAdapter(this, urls, emails,phoneNumber,imgid);
        list= findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}