package com.example.khalo1.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.khalo1.DataModel.Highlight;
import com.example.khalo1.DataModel.UpcomingExhibit;
import com.example.khalo1.DataSource.Repo;
import com.example.khalo1.R;

import java.util.ArrayList;

public class ListThirdItemAdapter extends RecyclerView.Adapter<ListThirdItemAdapter.ViewHolder>{
    ArrayList<Highlight> items = Repo.getHighlights();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.highlights_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Highlight highlight = items.get(position);
        //holder.img.setImageResource(highlight.img);
        Glide.with(holder.itemView).load(highlight.img).placeholder(R.color.black)
                .into(holder.img);
        holder.title.setText(highlight.title);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        ViewHolder(View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.exhibit_image);
            title = itemView.findViewById(R.id.title);
        }
    }

}
