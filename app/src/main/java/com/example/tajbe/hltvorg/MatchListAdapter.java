package com.example.tajbe.hltvorg;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tajbe on 29.10.2017.
 */

public class MatchListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<MatchesClass> mMatchesList;

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
        view.setTag(position);
        return view;
    }
}
