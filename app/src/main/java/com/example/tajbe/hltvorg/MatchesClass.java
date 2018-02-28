package com.example.tajbe.hltvorg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    public Image team1Logo;
    public Image team2Logo;

    MatchesClass(String time,String team1, String team2,String event){
        this.time = time;
        this.team1Cell = team1;
        this.team2Cell = team2;
        this.event = event;
    }
    MatchesClass (){}


}
