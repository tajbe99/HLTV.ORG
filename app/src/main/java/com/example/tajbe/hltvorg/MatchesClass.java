package com.example.tajbe.hltvorg;

import java.util.ArrayList;

/**
 * Created by tajbe on 22.02.2018.
 */

public class MatchesClass {
    public static String time;
    public static String team1Cell;
    public static String team2Cell;
    public static String event;

    MatchesClass(String time,String team1, String team2,String event){
        this.time = time;
        this.team1Cell = team1;
        this.team2Cell = team2;
        this.event = event;
    }
    MatchesClass (){}


    public static String getTime() {
        return time;
    }

    public static String getTeam1Cell() {
        return team1Cell;
    }

    public static String getTeam2Cell() {
        return team2Cell;
    }

    public static String getEvent() {
        return event;
    }

    public static void setTime(String time) {
        MatchesClass.time = time;
    }

    public static void setTeam1Cell(String team1Cell) {
        MatchesClass.team1Cell = team1Cell;
    }

    public static void setTeam2Cell(String team2Cell) {
        MatchesClass.team2Cell = team2Cell;
    }

    public static void setEvent(String event) {
        MatchesClass.event = event;
    }
}
