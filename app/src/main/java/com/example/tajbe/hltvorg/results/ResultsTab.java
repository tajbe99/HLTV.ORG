package com.example.tajbe.hltvorg.results;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tajbe.hltvorg.R;

/**
 * Created by tajbe on 29.10.2017.
 */

public class ResultsTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.resultstab,container,false);
        return rootView;
    }
}
