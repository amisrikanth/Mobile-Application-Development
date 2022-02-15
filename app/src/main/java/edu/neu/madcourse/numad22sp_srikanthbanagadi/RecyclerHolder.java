package edu.neu.madcourse.numad22sp_srikanthbanagadi;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerHolder extends RecyclerView.ViewHolder {
    public TextView url;


    public RecyclerHolder(View itemView, final ILinkListener listener) {
        super(itemView);
        url = itemView.findViewById(R.id.url);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }
}

