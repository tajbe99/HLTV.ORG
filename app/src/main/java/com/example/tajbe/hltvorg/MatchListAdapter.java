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
    private ArrayList<MatchesClass> mMatchesList;

    public MatchListAdapter(Context mContext, ArrayList<MatchesClass> mMatchesList) {
        this.mContext = mContext;
        this.mMatchesList = new ArrayList<>(mMatchesList);
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
        View view = View.inflate(mContext,R.layout.customlistviewofmatches,null);
        TextView matchTime = (TextView)view.findViewById(R.id.MatchTime);
        TextView team1Name = (TextView)view.findViewById(R.id.Team1Name);
        TextView team2Name= (TextView)view.findViewById(R.id.Team2Name);
        TextView vs = (TextView)view.findViewById(R.id.VsText);
        matchTime.setText(mMatchesList.get(position).getTime());
        team1Name.setText(mMatchesList.get(position).getTeam1Cell());
        team2Name.setText(mMatchesList.get(position).getTeam2Cell());
        vs.setText("VS");
        return view;
    }
}
