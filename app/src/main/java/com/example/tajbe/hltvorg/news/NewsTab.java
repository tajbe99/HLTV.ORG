package com.example.tajbe.hltvorg.news;

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
import android.widget.Toast;

import com.example.tajbe.hltvorg.R;
import com.example.tajbe.hltvorg.matches.CardViewListAdtapter;
import com.example.tajbe.hltvorg.matches.MatchListAdapter;
import com.example.tajbe.hltvorg.matches.MatchesClass;
import com.example.tajbe.hltvorg.matches.MatchesTab;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.tajbe.hltvorg.matches.MatchesTab.mMatchesList;

/**
 * Created by tajbe on 29.10.2017.
 */

public class NewsTab extends Fragment {
    public ProgressBar newsProgress;
    public static ArrayList<NewsCLass> newsList = new ArrayList<>();
    private RecyclerView nRecyclerView;
    private RecyclerView.Adapter nAdapter;
    private RecyclerView.LayoutManager nLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.newstab,container,false);
        nRecyclerView = (RecyclerView) rootView.findViewById(R.id.newstabRecView);
        nRecyclerView.setHasFixedSize(false);
        newsProgress = (ProgressBar)rootView.findViewById(R.id.newsProgressBar);
        newsProgress.setVisibility(ProgressBar.VISIBLE);
        new NewsTab.NewThread().execute();
        nLayoutManager = new LinearLayoutManager(getContext());
        nRecyclerView.setLayoutManager(nLayoutManager);
        nAdapter = new NewsCardAdapter(newsList);
        nRecyclerView.setAdapter(nAdapter);
        return rootView;
    }
    public class NewThread extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... arg) {
            try {
                Document document = Jsoup.connect("https://www.hltv.org/").get();
                Elements newsElements = document
                        .select("a[class$=newsline]");
                ArrayList<Document> newsURL = new ArrayList<Document>();
                for (Element fullnews:newsElements) {
                    Document simpleNews = Jsoup.connect("https://www.hltv.org"+
                                    fullnews.attr("href")).get();
                   newsURL.add( simpleNews);
                }
                for (Document fullNewsDoc:newsURL) {
                    newsList.add(new NewsCLass(
                            fullNewsDoc.select("div[class$=newsitem standard-box]").text(),
                            fullNewsDoc.select("p[class$=headertext]").text(),
                            fullNewsDoc.select("a[class$=image-con block a-reset]")
                                    .select("img[class$=image]")
                                    .attr("src")));
                }

            } catch (IOException e) {
                throw new RuntimeException("Some trabl");
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result){
            Toast.makeText(getContext(),newsList.get(0).urlNews,Toast.LENGTH_LONG).show();
                newsProgress.setVisibility(ProgressBar.INVISIBLE);
                nLayoutManager = new LinearLayoutManager(getContext());
                nRecyclerView.setLayoutManager(nLayoutManager);
                nAdapter = new NewsCardAdapter(newsList);
                nRecyclerView.setAdapter(nAdapter);
        }
    }
}
