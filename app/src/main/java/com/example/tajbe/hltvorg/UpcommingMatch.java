package com.example.tajbe.hltvorg;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by tajbe on 29.10.2017.
 */

public class UpcommingMatch {
    private String matchTime;
    private String team1Name;
    private String team2Name;
    private Bitmap team1Image;
    private Bitmap team2Image;

    public UpcommingMatch(String matchTime, String team1Name, String team2Name, Bitmap team1Image, Bitmap team2Image) {
        this.matchTime = matchTime;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.team1Image = team1Image;
        this.team2Image = team2Image;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public Bitmap getTeam1Image() {
        return team1Image;
    }

    public void setTeam1Image(Bitmap team1Image) {
        this.team1Image = team1Image;
    }

    public Bitmap getTeam2Image() {
        return team2Image;
    }

    public void setTeam2Image(Bitmap team2Image) {
        this.team2Image = team2Image;
    }
}
