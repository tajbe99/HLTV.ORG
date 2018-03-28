package com.example.tajbe.hltvorg.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tajbe.hltvorg.R;
import com.example.tajbe.hltvorg.news.NewsCardAdapter;
import com.example.tajbe.hltvorg.news.NewsCLass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tajbe on 3/28/18.
 */

public class NewsCardAdapter extends RecyclerView.Adapter<NewsCardAdapter.ViewHolder>{
    private ArrayList<NewsCLass> newsArray;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView headLine;
        public TextView headerText;
        public ImageView newsImage;

        public ViewHolder(View v) {
            super(v);
            headerText = (TextView) v.findViewById(R.id.headertext);
            headLine = (TextView) v.findViewById(R.id.headline);
            newsImage= (ImageView) v.findViewById(R.id.news_image);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public NewsCardAdapter(ArrayList<NewsCLass> myDataset) {
        newsArray = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public NewsCardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_card_item, parent, false);
        NewsCardAdapter.ViewHolder vh = new NewsCardAdapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(NewsCardAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.headLine.setText(newsArray.get(position).headLine);
        holder.headerText.setText(newsArray.get(position).headerText);
        if (!newsArray.get(position).urlNews.isEmpty()) {
            Picasso.with(holder.newsImage.getContext())
                    .load(newsArray.get(position).urlNews)
                    .into( holder.newsImage);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return newsArray.size();
    }

}
