package com.example.tajbe.hltvorg;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tajbe on 29.10.2017.
 */

public class MatchesTab extends Fragment {

    private ListView matchList;
    private MatchListAdapter adapter;
    public static ArrayList<MatchesClass> mMatchesList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.matchestab,container,false);
        matchList = (ListView)rootView.findViewById(R.id.itemsOfMatches);
        new NewThread().execute();
        adapter = new MatchListAdapter(getContext(),mMatchesList);
        return rootView;
    }

    public class NewThread extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... arg) {
            try {
                Document document = Jsoup.connect("https://www.hltv.org/matches").get();
                Elements matchElements = document.select("a[class$=a-reset block upcoming-match standard-box]");
               for (Element match:matchElements) {
                   String[] teams = match.select("td[class$=team-cell]").text().split(" ");
                   mMatchesList.add(new MatchesClass (
                           match.select(".time").get(1).text(),
                           teams[0],
                           teams[0],
                           match.select("td[class$=event]").text()));
               }
            } catch (IOException e) {
                throw new RuntimeException("Ошибка подключения");
            }
                return null;
        }

        @Override
        protected void onPostExecute(String result){
            adapter = new MatchListAdapter(getContext(),mMatchesList);
            matchList.setAdapter(adapter);
        }
    }
}
