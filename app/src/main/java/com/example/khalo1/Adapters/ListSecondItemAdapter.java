package com.example.khalo1.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.khalo1.DataModel.UpcomingExhibit;
import com.example.khalo1.DataSource.Repo;
import com.example.khalo1.MainActivity;
import com.example.khalo1.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListSecondItemAdapter extends RecyclerView.Adapter<ListSecondItemAdapter.ViewHolder>{
    ArrayList<UpcomingExhibit> items = Repo.getUpcomingExhibit();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_exhibition_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UpcomingExhibit upcomingExhibit = items.get(position);
        //holder.img.setImageResource(upcomingExhibit.img);
        Glide.with(holder.itemView).load(upcomingExhibit.img).placeholder(R.color.hash)
                .into(holder.img);
        holder.title.setText(upcomingExhibit.title);
        holder.time.setText(upcomingExhibit.time);
        ViewCompat.setTransitionName(holder.img, upcomingExhibit.img+"");
        //The below code does not allow viewpager2 to work properly in terms of scroll--embeded in
        //HomeFragment ,HomeFragment2 works properly
        holder.itemView.setOnClickListener((view1 -> {
            /*FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                    .addSharedElement(holder.img, "overview_image")
                    .build();*/
            Bundle args = new Bundle();
            args.putInt("Image_Resource",upcomingExhibit.img);
            Navigation.findNavController(view1)
                    .navigate(R.id.action_global_overviewFragment,args);
            MainActivity.currentPosition = holder.getAdapterPosition();
    }));


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        ImageView img;
        TextView title;
        TextView time;
        ViewHolder(View itemView){
            super(itemView);
            this.itemView = itemView;
            img = itemView.findViewById(R.id.exhibit_image);
            title = itemView.findViewById(R.id.title);
            time = itemView.findViewById(R.id.time);
        }
    }

}
