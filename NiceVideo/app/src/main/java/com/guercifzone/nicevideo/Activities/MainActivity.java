package com.guercifzone.nicevideo.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.guercifzone.nicevideo.Adapters.MovieAdapter;
import com.guercifzone.nicevideo.Adapters.SliderPagerAdapter;
import com.guercifzone.nicevideo.Models.Movie;
import com.guercifzone.nicevideo.Models.Slide;
import com.guercifzone.nicevideo.MoviesYears.*;
import com.guercifzone.nicevideo.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

   private List<Slide> lstSlides ;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV2020s,MoviesRV2010s,MoviesRV2000s,MoviesRV1990s,MoviesRV1980s ;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderpager = findViewById(R.id.slider_pager) ;
        MoviesRV2020s = findViewById(R.id.Rv_movies2020s);
        MoviesRV2010s = findViewById(R.id.Rv_movies2010s);
        MoviesRV2000s = findViewById(R.id.Rv_movies2000s);
        MoviesRV1990s = findViewById(R.id.Rv_movies1990s);
        MoviesRV1980s = findViewById(R.id.Rv_movies1980s);

        lstSlides = new ArrayList<>() ;
        lstSlides.add(new Slide(R.drawable.slide1980s,"best movies \nfilms 1980s"));
        lstSlides.add(new Slide(R.drawable.slide1990s,"best movies \nfilms 1990s"));
        lstSlides.add(new Slide(R.drawable.slide2000s,"best movies \nfilms 2000s"));
        lstSlides.add(new Slide(R.drawable.slide2010s,"best movies \nfilms 2010s"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);
        // setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),1000,6000);
        try {
            indicator = findViewById(R.id.indicator);
            indicator.setupWithViewPager(sliderpager,true);
        }catch (Exception e){
            e.printStackTrace();
        }
        //***************************** MoviesRV2020s
        List<Movie> lstMovies2020s = new ArrayList<>();
        lstMovies2020s.add(new Movie("A Quiet Place",R.drawable.a_quiet_place));
        lstMovies2020s.add(new Movie("Mad Max: Fury Road",R.drawable.mad_max_fury_road));
        lstMovies2020s.add(new Movie("Incendies",R.drawable.incendies));
        lstMovies2020s.add(new Movie("Deadpool",R.drawable.deadpool));

        MovieAdapter movieAdapter1 = new MovieAdapter( this, lstMovies2020s,this::onMovieClick1);
        MoviesRV2020s.setAdapter(movieAdapter1);
        MoviesRV2020s.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        //***************************** MoviesRV2010s
       List<Movie> lstMovies2010s = new ArrayList<>();
        lstMovies2010s.add(new Movie("Uncut Gems",R.drawable.uncutgems));
        lstMovies2010s.add(new Movie("The Lighthouse",R.drawable.thelighthouse));
        lstMovies2010s.add(new Movie("1917",R.drawable.the1917));
        lstMovies2010s.add(new Movie("Parasite",R.drawable.parasite));

        MovieAdapter movieAdapter2 = new MovieAdapter( this,lstMovies2010s,this::onMovieClick2);
        MoviesRV2010s.setAdapter(movieAdapter2);
        MoviesRV2010s.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
//********************** MoviesRV2000s
        List<Movie> lstMovies2000s = new ArrayList<>();

        lstMovies2000s.add(new Movie("Gladiator",R.drawable.gladiator));
        lstMovies2000s.add(new Movie("The Dark Knight",R.drawable.thedarkknight));
        lstMovies2000s.add(new Movie("Slumdog Millionaire",R.drawable.slumdogmillionaire));
        lstMovies2000s.add(new Movie("The Departed",R.drawable.thedeparted));

        MovieAdapter movieAdapter3 = new MovieAdapter( this,lstMovies2000s,this::onMovieClick3);
        MoviesRV2000s.setAdapter(movieAdapter3);
        MoviesRV2000s.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        //********************** MoviesRV1990s
        List<Movie> lstMovies1990s = new ArrayList<>();
        lstMovies1990s.add(new Movie(" Pulp Fiction",R.drawable.pulpfiction));
        lstMovies1990s.add(new Movie("Schindler's List",R.drawable.schindlerslist));
        lstMovies1990s.add(new Movie("Malcolm X",R.drawable.malcolmx));
        lstMovies1990s.add(new Movie("Princess Mononoke",R.drawable.princessmononoke));

        MovieAdapter movieAdapter4 = new MovieAdapter( this,lstMovies1990s,this::onMovieClick4);
        MoviesRV1990s.setAdapter(movieAdapter4);
        MoviesRV1990s.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        //*********************** MoviesRV1980s
        List<Movie> lstMovies1980s = new ArrayList<>();
        lstMovies1980s.add(new Movie("Raging Bull",R.drawable.ragingbull));
        lstMovies1980s.add(new Movie("E.T. the Extra-Terrestrial",R.drawable.theextraterrestrial));
        lstMovies1980s.add(new Movie("Raiders of the Lost Ark",R.drawable.raidersofthelostark));
        lstMovies1980s.add(new Movie("Amadeus",R.drawable.amadeus));


        MovieAdapter movieAdapter5= new MovieAdapter( this, lstMovies1980s,this::onMovieClick5);
        MoviesRV1980s.setAdapter(movieAdapter5);
        MoviesRV1980s.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }





    public void onMovieClick1(Movie movie, ImageView movieImageView) {

        startActivity(new Intent(MainActivity.this, Movies2020sActivity.class));


    }
    public void onMovieClick2(Movie movie, ImageView movieImageView) {

        startActivity(new Intent(MainActivity.this, Movies2010sActivity.class));


    }
    public void onMovieClick3(Movie movie, ImageView movieImageView) {

        startActivity(new Intent(MainActivity.this, Movies2000sActivity.class));


    }
    public void onMovieClick4(Movie movie, ImageView movieImageView) {

        startActivity(new Intent(MainActivity.this, Movies1990sActivity.class));


    }
    public void onMovieClick5(Movie movie, ImageView movieImageView) {

        startActivity(new Intent(MainActivity.this, Movies1980sActivity.class));


    }
    class SliderTimer extends TimerTask {
        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });


        }
    }


}