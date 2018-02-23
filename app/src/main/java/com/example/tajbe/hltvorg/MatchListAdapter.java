package com.example.tajbe.hltvorg;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tajbe on 29.10.2017.
 */

public class MatchListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<MatchesClass> mMatchesLists;

    public MatchListAdapter(Context mContext, ArrayList<MatchesClass> mMatchesList) {
        this.mContext = mContext;
        this.mMatchesLists = new ArrayList<>(mMatchesList);
    }

    @Override
    public int getCount() {
        return mMatchesLists.size();
    }

    @Override
    public Object getItem(int position) {
        return mMatchesLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext,R.layout.customlistviewofmatches,null);
        TextView matchTime = (TextView)view.findViewById(R.id.MatchTime);
        TextView team1Name = (TextView)view.findViewById(R.id.Team1Name);
        TextView team2Name = (TextView)view.findViewById(R.id.Team2Name);
        TextView event = (TextView)view.findViewById(R.id.EventName);
        TextView vs = (TextView)view.findViewById(R.id.VsText);
        matchTime.setText(mMatchesLists.get(position).getTime());
        team1Name.setText(mMatchesLists.get(position).getTeam1Cell());
        team2Name.setText(mMatchesLists.get(position).getTeam2Cell());
        event.setText(mMatchesLists.get(position).getEvent());
        vs.setText("VS");
        return view;
    }
}
