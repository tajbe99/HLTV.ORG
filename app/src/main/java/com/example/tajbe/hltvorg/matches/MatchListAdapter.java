package com.example.tajbe.hltvorg.matches;

import android.content.Context;
import android.view.View;

import com.example.tajbe.hltvorg.R;
import com.squareup.picasso.*;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tajbe on 29.10.2017.
 */

public class MatchListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<MatchesClass> mMatchesList;
    private String currentDate = "";

    public MatchListAdapter(Context mContext, ArrayList<MatchesClass> mMatchesList1) {
        this.mContext = mContext;
        this.mMatchesList = new ArrayList<>(mMatchesList1);
    }

    @Override
    public int getCount() {
        return mMatchesList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMatchesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = View.inflate(mContext, R.layout.customlistviewofmatches, null);
        }
        ((TextView)view.findViewById(R.id.MatchTime)).setText(mMatchesList.get(position).time);
        ((TextView)view.findViewById(R.id.Team1Name)).setText(mMatchesList.get(position).team1Cell);
        ((TextView)view.findViewById(R.id.Team2Name)).setText(mMatchesList.get(position).team2Cell);
        ((TextView)view.findViewById(R.id.EventName)).setText(mMatchesList.get(position).event);
        ((TextView)view.findViewById(R.id.VsText)).setText("VS");
        Picasso.with(mContext)
                .load(mMatchesList.get(position).eventLogo)
                .into((ImageView) view.findViewById(R.id.event_Logo));
        if (!mMatchesList.get(position).team1Logo.isEmpty()) {
            Picasso.with(mContext)
                    .load(mMatchesList.get(position).team1Logo)
                    .resize(25,25)
                    .into((ImageView) view.findViewById(R.id.team1_logo));
        }
        if (!mMatchesList.get(position).team2Logo.isEmpty()) {
            Picasso.with(mContext)
                    .load(mMatchesList.get(position).team2Logo)
                    .resize(25,25)
                    .into((ImageView) view.findViewById(R.id.team2_logo));
        }
        view.setTag(position);
        return view;
    }
}
