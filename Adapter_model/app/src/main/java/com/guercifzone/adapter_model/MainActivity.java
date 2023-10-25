package com.guercifzone.adapter_model;

import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private MediaPlayer mediaPlayer, music;
private ImageView background1;
private ListView listView;
private boolean backPressed;
protected static boolean VISIBLE_BACLGROUND = false,playmusic=false;
private MediaPlayer.OnCompletionListener completionListener= new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        releadsmedia();
        if (background1.getDrawable()!= null){
            background1.animate().alpha(0).setDuration(1000);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    music.start();
                    playmusic = true;
                    background1.setImageDrawable(null);
                }
            },2000);
        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
music  =MediaPlayer.create(this,R.raw.background_voice);
music.setLooping(false);
backPressed = false;

background1 = findViewById(R.id.display_data_background);
listView = findViewById(R.id.list_view);

if (!VISIBLE_BACLGROUND){
    background1.animate().alpha(0).setDuration(1000);
    VISIBLE_BACLGROUND = true;
    mediaPlayer = MediaPlayer.create(this,R.raw.background_voice);
    mediaPlayer.setVolume(0,0);
    mediaPlayer.start();
    mediaPlayer.setOnCompletionListener(completionListener);
}
final  ArrayList<Data>  arrayList = new ArrayList<Data>();
        arrayList.add(new Data(R.raw.main_letter_ba,R.drawable.letter_b,R.drawable.letter_a,"ba"));
        arrayList.add(new Data(R.raw.main_letter_be,R.drawable.letter_b,R.drawable.letter_e,"be"));
        arrayList.add(new Data(R.raw.main_letter_bi,R.drawable.letter_b,R.drawable.letter_i,"bi"));
        arrayList.add(new Data(R.raw.main_letter_bo,R.drawable.letter_b,R.drawable.letter_o,"bo"));
        arrayList.add(new Data(R.raw.main_letter_bu,R.drawable.letter_b,R.drawable.letter_u,"bu"));

        arrayList.add(new Data(R.raw.main_letter_ca,R.drawable.letter_c,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_ce,R.drawable.letter_c,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_ci,R.drawable.letter_c,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_co,R.drawable.letter_c,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_cu,R.drawable.letter_c,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_da,R.drawable.letter_d,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_de,R.drawable.letter_d,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_di,R.drawable.letter_d,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_do,R.drawable.letter_d,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_du,R.drawable.letter_d,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_fa,R.drawable.letter_f,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_fe,R.drawable.letter_f,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_fi,R.drawable.letter_f,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_fo,R.drawable.letter_f,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_fu,R.drawable.letter_f,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_ga,R.drawable.letter_g,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_ge,R.drawable.letter_g,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_gi,R.drawable.letter_g,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_go,R.drawable.letter_g,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_gu,R.drawable.letter_g,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_ha,R.drawable.letter_h,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_he,R.drawable.letter_h,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_hi,R.drawable.letter_h,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_ho,R.drawable.letter_h,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_hu,R.drawable.letter_h,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_ja,R.drawable.letter_j,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_je,R.drawable.letter_j,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_ji,R.drawable.letter_j,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_jo,R.drawable.letter_j,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_ju,R.drawable.letter_j,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_ka,R.drawable.letter_k,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_ke,R.drawable.letter_k,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_ki,R.drawable.letter_k,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_ko,R.drawable.letter_k,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_ku,R.drawable.letter_k,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_la,R.drawable.letter_l,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_le,R.drawable.letter_l,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_li,R.drawable.letter_l,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_lo,R.drawable.letter_l,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_lu,R.drawable.letter_l,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_ma,R.drawable.letter_m,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_me,R.drawable.letter_m,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_mi,R.drawable.letter_m,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_mo,R.drawable.letter_m,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_mu,R.drawable.letter_m,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_na,R.drawable.letter_n,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_ne,R.drawable.letter_n,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_ni,R.drawable.letter_n,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_no,R.drawable.letter_n,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_nu,R.drawable.letter_n,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_pa,R.drawable.letter_p,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_pe,R.drawable.letter_p,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_pi,R.drawable.letter_p,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_po,R.drawable.letter_p,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_pu,R.drawable.letter_p,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_ka,R.drawable.letter_q,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_ke,R.drawable.letter_q,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_ki,R.drawable.letter_q,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_ko,R.drawable.letter_q,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_ku,R.drawable.letter_q,R.drawable.letter_u,""));


        arrayList.add(new Data(R.raw.main_letter_ra,R.drawable.letter_r,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_re,R.drawable.letter_r,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_ri,R.drawable.letter_r,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_ro,R.drawable.letter_r,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_ru,R.drawable.letter_r,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_sa,R.drawable.letter_s,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_se,R.drawable.letter_s,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_si,R.drawable.letter_s,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_so,R.drawable.letter_s,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_su,R.drawable.letter_s,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_ta,R.drawable.letter_t,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_te,R.drawable.letter_t,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_ti,R.drawable.letter_t,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_to,R.drawable.letter_t,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_tu,R.drawable.letter_t,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_va,R.drawable.letter_v,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_ve,R.drawable.letter_v,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_vi,R.drawable.letter_v,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_vo,R.drawable.letter_v,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_vu,R.drawable.letter_v,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_wa,R.drawable.letter_w,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_we,R.drawable.letter_w,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_wi,R.drawable.letter_w,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_wo,R.drawable.letter_w,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_wu,R.drawable.letter_w,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_xa,R.drawable.letter_x,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_xe,R.drawable.letter_x,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_xi,R.drawable.letter_x,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_xo,R.drawable.letter_x,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_xu,R.drawable.letter_x,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_ya,R.drawable.letter_y,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_ye,R.drawable.letter_y,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_yi,R.drawable.letter_y,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_yo,R.drawable.letter_y,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_yu,R.drawable.letter_y,R.drawable.letter_u,""));

        arrayList.add(new Data(R.raw.main_letter_za,R.drawable.letter_z,R.drawable.letter_a,""));
        arrayList.add(new Data(R.raw.main_letter_ze,R.drawable.letter_z,R.drawable.letter_e,""));
        arrayList.add(new Data(R.raw.main_letter_zi,R.drawable.letter_z,R.drawable.letter_i,""));
        arrayList.add(new Data(R.raw.main_letter_zo,R.drawable.letter_z,R.drawable.letter_o,""));
        arrayList.add(new Data(R.raw.main_letter_zu,R.drawable.letter_z,R.drawable.letter_u,""));
AdapterLetter adapter  = new AdapterLetter(this,arrayList);
listView.setAdapter(adapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releadsmedia();
                mediaPlayer = MediaPlayer.create(MainActivity.this,arrayList.get(position).getRaw_ID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(completionListener);
        }
});

    }

        private void releadsmedia() {
            if (mediaPlayer != null){
                    mediaPlayer.release();
                    mediaPlayer= null;
            }
        }
private  void releaseMusic(){
            music.release();
            music= null;
}

        @Override
        protected void onResume() {
                super.onResume();
                if (playmusic)
                        music.start();
        }

        @Override
        protected void onPause() {
                super.onPause();
                if (!backPressed)
                        music.pause();
        }

        @Override
        public void onBackPressed() {
                super.onBackPressed();
                finish();
                releadsmedia();
                releaseMusic();
                backPressed = true;
        }

        @Override
        protected void onDestroy() {
                super.onDestroy();
                if (!backPressed){
                        releadsmedia();
                releaseMusic();}
        }
}