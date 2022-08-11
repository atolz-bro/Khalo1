package com.example.khalo1.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khalo1.R;

public class LatestRecyclerAdapter extends RecyclerView.Adapter<LatestRecyclerAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        ViewHolder viewHolder = null;
        if(viewType == R.layout.latest_first_item){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_first_item,parent,false);
            viewHolder = new ViewHolder(view,R.layout.latest_first_item);
        }
        if(viewType == R.layout.latest_second_item){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_second_item,parent,false);
            viewHolder = new ViewHolder(view,R.layout.latest_second_item);
        }
        if(viewType == R.layout.latest_third_item){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_third_item,parent,false);
            viewHolder = new ViewHolder(view,R.layout.latest_third_item);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(holder.upcoming_exhibit_recycler != null){
            holder.upcoming_exhibit_recycler.setAdapter(new ListSecondItemAdapter());
        }
        if(holder.highlights != null)
            holder.highlights.setAdapter(new ListThirdItemAdapter());
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView upcoming_exhibit_recycler;
        RecyclerView highlights;

        ViewHolder(View itemView, int type){
            super(itemView);
            if(type == R.layout.latest_second_item){
                upcoming_exhibit_recycler = itemView.findViewById(R.id.upcoming_recycler);
            }
            if(type == R.layout.latest_third_item){
                highlights = itemView.findViewById(R.id.highlights_recycler);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        //return super.getItemViewType(position);
        if(position == 0)
            return R.layout.latest_first_item;
        if (position == 1)
            return R.layout.latest_second_item;
        if (position == 2)
            return R.layout.latest_third_item;
        return super.getItemViewType(position);

    }
}
