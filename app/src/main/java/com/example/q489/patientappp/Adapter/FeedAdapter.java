package com.example.q489.patientappp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.q489.patientappp.Interface.ItemClickListener;
import com.example.q489.patientappp.Model.Feed;
import com.example.q489.patientappp.Model.RSSFeed;
import com.example.q489.patientappp.R;

class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener
{

    public TextView txtTitle, txtPubDate, txtContent;
    private ItemClickListener itemClickListener;

    public FeedViewHolder(View itemView) {
        super(itemView);

        txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
        txtPubDate = (TextView)itemView.findViewById(R.id.txtPubDate);
        txtContent = (TextView)itemView.findViewById(R.id.txtContent);

        //set events
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setTxtTitle(TextView txtTitle) {
        this.txtTitle = txtTitle;
    }

    public void setTxtPubDate(TextView txtPubDate) {
        this.txtPubDate = txtPubDate;
    }

    public void setTxtContent(TextView txtContent) {
        this.txtContent = txtContent;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v, getAdapterPosition(), false);

    }

    public boolean onLongClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), true);

        return true;
    }
    }

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private RSSFeed rssObject;
    private Context mContext;
    private LayoutInflater inflater;

    public FeedAdapter(RSSFeed rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = inflater.inflate(R.layout.row, parent, false);
        return new FeedViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder feedViewHolder, int position) {

        feedViewHolder.txtTitle.setText(rssObject.getItems().get(position).getTitle());
        feedViewHolder.txtPubDate.setText(rssObject.getItems().get(position).getPubDate());
        feedViewHolder.txtContent.setText(rssObject.getItems().get(position).getContent());


    }

    @Override
    public int getItemCount() {

        return rssObject.items.size();
    }
}
