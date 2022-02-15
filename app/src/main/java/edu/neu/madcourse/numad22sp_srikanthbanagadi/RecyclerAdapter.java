package edu.neu.madcourse.numad22sp_srikanthbanagadi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder>{
    private final ArrayList<LinkCard> list;
    private ILinkListener listener;

    public RecyclerAdapter(ArrayList<LinkCard> linkList) {
        this.list = linkList;
    }

    public void setOnItemClickListener(ILinkListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_link_collector, parent, false);
        return new RecyclerHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        LinkCard currentItem = list.get(position);
        holder.url.setText(currentItem.getUrl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
