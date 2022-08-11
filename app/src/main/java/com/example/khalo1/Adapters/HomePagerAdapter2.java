package com.example.khalo1.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.khalo1.CommunityFragment;
import com.example.khalo1.LatestFragment;

public class HomePagerAdapter2 extends FragmentStatePagerAdapter {
    public HomePagerAdapter2(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new LatestFragment();
        else
            return new CommunityFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "Latest";
        else
            return "Community";
    }
}
