package com.example.tajbe.hltvorg;

import android.os.AsyncTask;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by tajbe on 10.12.2017.
 */

public class ParseUpcomingMatch extends AsyncTask<Void,Void,HashMap<String,String>> {


    @Override
    protected HashMap<String, String> doInBackground(Void... params) {
        Connection.Response resp = null;
        ArrayList<MatchesClass> matchList = new ArrayList<>();
        try {
            resp = Jsoup.connect("https://www.hltv.org/matches")
                    .timeout(5000)
                    .referrer("")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
                    .method(Connection.Method.GET)
                    .execute();
            Document document = resp.parse();
            Elements matchElements = document.getElementsByAttributeValue("class", "table");
            for (Element match : matchElements) {
                MatchesClass matchEl = new MatchesClass();
                matchEl.setTime(match.child(0).child(0).child(0).child(0).text());
                matchEl.setTeam1Cell(match.child(0).child(0).child(0).child(1).text());
                matchEl.setTeam2Cell(match.child(0).child(0).child(0).child(3).text());
                matchEl.setEvent(match.child(0).child(0).child(0).child(4).text());
                matchList.add(matchEl);
            }
        } catch (IOException e1) {
            throw new RuntimeException("Error");
        }
        return null;
    }
}
