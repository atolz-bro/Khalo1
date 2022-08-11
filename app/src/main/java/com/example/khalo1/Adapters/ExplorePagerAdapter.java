package com.example.khalo1.Adapters;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.khalo1.CategoryFragment;
import com.example.khalo1.CommunityFragment;
import com.example.khalo1.LatestFragment;
import com.example.khalo1.ViewModels.ExhibitViewModel;

import java.util.ArrayList;

public class ExplorePagerAdapter extends FragmentStateAdapter {
    ExhibitViewModel model;
    public ExplorePagerAdapter(@NonNull Fragment fragment, FragmentActivity activity) {
        super(fragment);
        this.model = new ViewModelProvider(activity).get(ExhibitViewModel.class);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle args = new Bundle();
        Fragment fragment = new CategoryFragment();
        args.putString(CategoryFragment.CATEGORY,model.category[position]);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return model.category.length;
    }
}
