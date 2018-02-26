package com.example.tajbe.hltvorg;

import java.util.ArrayList;

/**
 * Created by tajbe on 22.02.2018.
 */

public class MatchesClass {
    public String time;
    public String team1Cell;
    public String team2Cell;
    public String event;

    MatchesClass(String time,String team1, String team2,String event){
        this.time = time;
        this.team1Cell = team1;
        this.team2Cell = team2;
        this.event = event;
    }
    MatchesClass (){}


}
