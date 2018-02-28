package com.example.tajbe.hltvorg;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tajbe on 28.02.2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MatchesClass> matchesArray;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView time;
        public TextView teamCell1;
        public TextView teamCell2;
        public TextView event;

        public ViewHolder(View v) {
            super(v);
            time = (TextView) v.findViewById(R.id.m_time_match);
            teamCell1 = (TextView) v.findViewById(R.id.m_team1_cell_match);
            teamCell2 = (TextView) v.findViewById(R.id.m_team2_cell);
            event = (TextView) v.findViewById(R.id.m_event_match);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<MatchesClass> myDataset) {
        matchesArray = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.time.setText(matchesArray.get(position).time);
        holder.teamCell1.setText(matchesArray.get(position).team1Cell);
        holder.teamCell2.setText(matchesArray.get(position).team2Cell);
        holder.event.setText(matchesArray.get(position).event);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return matchesArray.size();
    }

}