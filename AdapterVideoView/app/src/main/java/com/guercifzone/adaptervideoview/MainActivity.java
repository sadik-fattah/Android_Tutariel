package com.guercifzone.adaptervideoview;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.guercifzone.adaptervideoview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  VideoView video_view;
    private ListView list_view;
    private MediaPlayer media_player;
    ArrayList<String> video_list;
    ArrayAdapter adapter;
    String  video1 ="https://scontent.frba4-3.fna.fbcdn.net/v/t42.1790-2/10000000_338149485427624_3579931041743687779_n.mp4?_nc_cat=102&ccb=1-7&_nc_sid=55d0d3&efg=eyJ2ZW5jb2RlX3RhZyI6InN2ZV9zZCJ9&_nc_eui2=AeGYI56V87cnfXBpWAU5zw66im-CuFKNonaKb4K4Uo2iduGZu_xQc4TlSbw7hh1ObMm59wKXdbD_k-KuJnkJXiMN&_nc_ohc=9fE0O5oqrEIAX_h2zQW&_nc_rml=0&_nc_ht=scontent.frba4-3.fna&oh=00_AfC2h2K6p1oIv0T_RX0L3AGyq5JPD2rjtHJAI6D-p9v4ZA&oe=65367BB7",
            video2="https://scontent.frba4-1.fna.fbcdn.net/v/t42.1790-2/10000000_1428490621042527_4189696018787484157_n.mp4?_nc_cat=109&ccb=1-7&_nc_sid=55d0d3&efg=eyJ2ZW5jb2RlX3RhZyI6InN2ZV9zZCJ9&_nc_eui2=AeEqO7lZUr_bgb55fM2fEvi9HIcZcDoSJacchxlwOhIlp9Alo-w0WEkWzUo4J5KJwCAUIS95DV0PhgSYEBiCbfIb&_nc_ohc=aBKBIFeJLZwAX_jDaBv&_nc_rml=0&_nc_ht=scontent.frba4-1.fna&oh=00_AfDaibNmrJwVXrz76fqMDH56wQzEQY-QEhihxtD2JIPnOA&oe=653661EC",
            video3="https://scontent.frba4-1.fna.fbcdn.net/v/t42.1790-2/10000000_895768265494713_4244913410464135917_n.mp4?_nc_cat=105&ccb=1-7&_nc_sid=55d0d3&efg=eyJ2ZW5jb2RlX3RhZyI6InN2ZV9zZCJ9&_nc_eui2=AeEg2fxjNHhugZ8c1qznyuod9ZVMB27lbqf1lUwHbuVup7hDiAZj4nIgTVPfpl7yO-F_G8ZFjEg7Zb7OP6ok69UE&_nc_ohc=YehH_pASh4cAX8FTD3d&_nc_rml=0&_nc_ht=scontent.frba4-1.fna&oh=00_AfAiClraAAon7oe9x_Be0NfBci8NGjDZmtEig2EIz1xNuA&oe=653730EE",
            video4="https://scontent.frba4-3.fna.fbcdn.net/v/t42.1790-2/10000000_652986416961129_7137215101806612276_n.mp4?_nc_cat=101&ccb=1-7&_nc_sid=55d0d3&efg=eyJ2ZW5jb2RlX3RhZyI6InN2ZV9zZCJ9&_nc_eui2=AeGMwRVEf7r4cDTidsxKB_P6NZLo85VNvyY1kujzlU2_JkOpe0SfrF0g2R2Ee4OkFivCI7W0NT3ojzJqk9XITTTy&_nc_ohc=9lWxVxYPNTcAX9kFaWs&_nc_rml=0&_nc_ht=scontent.frba4-3.fna&oh=00_AfAw7VbRWYQUoeaQH6muaEzuvrHeqBqz5TpUj3kxPrWgwg&oe=6537361A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
video_view = (VideoView) findViewById(R.id.videoview);
list_view = (ListView) findViewById(R.id.listview);
releaseMedia();
video_list = new ArrayList<>();
        video_list.add("الفيديو  الأول تم حجز متغير");
        video_list.add("الفيديو الثاني رابط مباشر");
        video_list.add("الفيديو الثالث تم حجز متغير");
        video_list.add("الفيديو الرابع رابط مباشر");
        video_list.add("الفيديو الخامس تم حجز متغير");
        video_list.add("الفيديو السادس رابط مباشر");
        video_list.add("الفيديو السابع  تم حجز متغير");
        video_list.add("الفيديو الثامن رابط مباشر");
adapter = new ArrayAdapter(this,
        androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
        video_list);
list_view.setAdapter(adapter);
list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:

                video_view.setVideoPath(video1);
                video_view.start();
                break;
            case 1:
                video_view.setVideoPath("https://scontent.frba4-3.fna.fbcdn.net/v/t42.1790-2/10000000_338149485427624_3579931041743687779_n.mp4?_nc_cat=102&ccb=1-7&_nc_sid=55d0d3&efg=eyJ2ZW5jb2RlX3RhZyI6InN2ZV9zZCJ9&_nc_eui2=AeGYI56V87cnfXBpWAU5zw66im-CuFKNonaKb4K4Uo2iduGZu_xQc4TlSbw7hh1ObMm59wKXdbD_k-KuJnkJXiMN&_nc_ohc=9fE0O5oqrEIAX_h2zQW&_nc_rml=0&_nc_ht=scontent.frba4-3.fna&oh=00_AfC2h2K6p1oIv0T_RX0L3AGyq5JPD2rjtHJAI6D-p9v4ZA&oe=65367BB7");
                video_view.start();
                break;
            case 2:
                video_view.setVideoPath(video2.toString());
                video_view.start();
                break;
            case 3:
                video_view.setVideoPath("https://scontent.frba4-1.fna.fbcdn.net/v/t42.1790-2/10000000_1428490621042527_4189696018787484157_n.mp4?_nc_cat=109&ccb=1-7&_nc_sid=55d0d3&efg=eyJ2ZW5jb2RlX3RhZyI6InN2ZV9zZCJ9&_nc_eui2=AeEqO7lZUr_bgb55fM2fEvi9HIcZcDoSJacchxlwOhIlp9Alo-w0WEkWzUo4J5KJwCAUIS95DV0PhgSYEBiCbfIb&_nc_ohc=aBKBIFeJLZwAX_jDaBv&_nc_rml=0&_nc_ht=scontent.frba4-1.fna&oh=00_AfDaibNmrJwVXrz76fqMDH56wQzEQY-QEhihxtD2JIPnOA&oe=653661EC");
                video_view.start();
                break;
            case 4:
                video_view.setVideoPath(video3.toString());
                video_view.start();
                break;
            case 5:
                video_view.setVideoPath("https://scontent.frba4-1.fna.fbcdn.net/v/t42.1790-2/10000000_895768265494713_4244913410464135917_n.mp4?_nc_cat=105&ccb=1-7&_nc_sid=55d0d3&efg=eyJ2ZW5jb2RlX3RhZyI6InN2ZV9zZCJ9&_nc_eui2=AeEg2fxjNHhugZ8c1qznyuod9ZVMB27lbqf1lUwHbuVup7hDiAZj4nIgTVPfpl7yO-F_G8ZFjEg7Zb7OP6ok69UE&_nc_ohc=YehH_pASh4cAX8FTD3d&_nc_rml=0&_nc_ht=scontent.frba4-1.fna&oh=00_AfAiClraAAon7oe9x_Be0NfBci8NGjDZmtEig2EIz1xNuA&oe=653730EE");
                video_view.start();
                break;
            case 6:
                video_view.setVideoPath(video4.toString());
                video_view.start();
                break;
            case 7:
                video_view.setVideoPath("https://scontent.frba4-3.fna.fbcdn.net/v/t42.1790-2/10000000_652986416961129_7137215101806612276_n.mp4?_nc_cat=101&ccb=1-7&_nc_sid=55d0d3&efg=eyJ2ZW5jb2RlX3RhZyI6InN2ZV9zZCJ9&_nc_eui2=AeGMwRVEf7r4cDTidsxKB_P6NZLo85VNvyY1kujzlU2_JkOpe0SfrF0g2R2Ee4OkFivCI7W0NT3ojzJqk9XITTTy&_nc_ohc=9lWxVxYPNTcAX9kFaWs&_nc_rml=0&_nc_ht=scontent.frba4-3.fna&oh=00_AfAw7VbRWYQUoeaQH6muaEzuvrHeqBqz5TpUj3kxPrWgwg&oe=6537361A");
                video_view.start();
                break;
        }
        video_view.setMediaController(new MediaController(MainActivity.this));
        video_view.requestFocus();
        }
});
    }

    private void releaseMedia() {
        if (media_player != null){
            media_player.release();
            media_player= null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        video_view.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        video_view.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMedia();
    }
}