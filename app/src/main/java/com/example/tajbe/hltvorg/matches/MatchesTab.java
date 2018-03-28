package com.example.tajbe.hltvorg.matches;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.tajbe.hltvorg.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tajbe on 29.10.2017.
 */

public class MatchesTab extends Fragment {

    public ListView matchList;
    public ProgressBar matchProgress;
    public MatchListAdapter adapter;
    public static ArrayList<MatchesClass> mMatchesList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT < 21){
            View rootView = inflater.inflate(R.layout.matchestab,container,false);
            matchProgress = (ProgressBar)rootView.findViewById(R.id.matchProgressBar);
            matchList = (ListView)rootView.findViewById(R.id.itemsOfMatches);
            matchProgress.setVisibility(ProgressBar.VISIBLE);
            new NewThread().execute();
            adapter = new MatchListAdapter(getContext(),mMatchesList);
            matchList.setAdapter(adapter);
            return rootView;
        } else {
            View rootView = inflater.inflate(R.layout.matchestabv2,container,false);
            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
            mRecyclerView.setHasFixedSize(false);
            matchProgress = (ProgressBar)rootView.findViewById(R.id.matchProgressBarv2);
            matchProgress.setVisibility(ProgressBar.VISIBLE);
            new NewThread().execute();
            mLayoutManager = new LinearLayoutManager(getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new CardViewListAdtapter(mMatchesList);
            mRecyclerView.setAdapter(mAdapter);
             return rootView;
        }
    }

    public class NewThread extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... arg) {
            try {
                Document document = Jsoup.connect("https://www.hltv.org/matches").get();
                Elements matchElements = document
                        .select("a[class$=a-reset block upcoming-match standard-box]");
               for (Element match:matchElements) {
                   List<String> team1 = match
                           .select("td[class$=team-cell]").eachText();
                   String event =  match
                           .select("td[class$=event]")
                           .text();
                   String time = match
                           .select(".time")
                           .get(1)
                           .text();
                   String eventLogoUrl =match
                           .select("td[class$=event]")
                           .select("img[class$=event-logo]")
                           .attr("src");
                   List<String> teamLogoUrl =match
                           .select("td[class$=team-cell]")
                           .select("img[class$=logo]")
                           .eachAttr("src");

                   if ((!event.isEmpty()) && teamLogoUrl.size()>=2){
                       mMatchesList.add(new MatchesClass(
                               time
                               ,team1.get(0)
                               ,team1.get(1)
                               ,event
                               ,eventLogoUrl
                               ,teamLogoUrl.get(0),teamLogoUrl.get(1)
                       ));
                   }
               }

            } catch (IOException e) {
                throw new RuntimeException("Some trabl");
            }
                return null;
        }

        @Override
        protected void onPostExecute(String result){
            if (Build.VERSION.SDK_INT < 21) {
                matchProgress.setVisibility(ProgressBar.INVISIBLE);
                adapter = new MatchListAdapter(getContext(), mMatchesList);
                matchList.setAdapter(adapter);
            } else{
                matchProgress.setVisibility(ProgressBar.INVISIBLE);
                mLayoutManager = new LinearLayoutManager(getContext());
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new CardViewListAdtapter(mMatchesList);
                mRecyclerView.setAdapter(mAdapter);
            }
        }
    }
}
