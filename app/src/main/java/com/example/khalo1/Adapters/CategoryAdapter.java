package com.example.khalo1.Adapters;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.khalo1.DataModel.Exhibit;
import com.example.khalo1.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryExhibitViewHolder> {

    List<Exhibit> exhibit_category;
    Activity activity;

    public CategoryAdapter(List<Exhibit> exhibit_category, Activity activity){
       this.exhibit_category = exhibit_category;
       this.activity = activity;
    }
    @NonNull
    @Override
    public CategoryExhibitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_exhibit_view,parent,false);
        return new CategoryExhibitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryExhibitViewHolder holder, int position) {
        Exhibit exhibit = exhibit_category.get(position);
        //holder.getImageView().setImageResource(exhibit.img);
        Glide.with(holder.getImageView().getContext()).load(exhibit.img).skipMemoryCache(true)
                .placeholder(R.color.hash).into(holder.getImageView());
        ViewCompat.setTransitionName(holder.getImageView(), exhibit.title);
        holder.getExhibitTitleView().setText(exhibit.title);
        holder.getExhibitDescriptionView().setText(activity.getResources().getString(exhibit.description));
        holder.itemView.setOnClickListener(
                view -> {
                   /* FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                            .addSharedElement(holder.getImageView(), "overview_image")
                            .build();*/
                    Bundle args = new Bundle();
                    args.putInt("Image_Resource",exhibit.img);
                    Navigation.findNavController(view)
                            .navigate(R.id.action_global_overviewFragment,args);
                }
        );
    }

    @Override
    public int getItemCount() {
        return exhibit_category.size();
    }
}

class CategoryExhibitViewHolder extends RecyclerView.ViewHolder{

    View itemView;
    public CategoryExhibitViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    ImageView getImageView(){
        return itemView.findViewById(R.id.exhibit_image);
    }

    TextView getExhibitTitleView(){
        return itemView.findViewById(R.id.exhibit_title);
    }

    TextView getExhibitDescriptionView(){
        return itemView.findViewById(R.id.exhibit_description);
    }
}
