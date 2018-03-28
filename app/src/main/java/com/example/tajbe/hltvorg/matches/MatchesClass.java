package com.example.tajbe.hltvorg.matches;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;

import java.io.File;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by tajbe on 22.02.2018.
 */

public class MatchesClass {
    public String time;
    public String team1Cell;
    public String team2Cell;
    public String event;
    public String team1Logo;
    public String team2Logo;
    public String eventLogo;

    MatchesClass(String time,String team1, String team2,String event
            ,String eventLogo,String team1Logo,String team2Logo
    ){
        this.time = time;
        this.team1Cell = team1;
        this.team2Cell = team2;
        this.event = event;
        this.eventLogo = eventLogo;
        this.team1Logo = team1Logo;
        this.team2Logo = team2Logo;
    }
    MatchesClass (){}


}
