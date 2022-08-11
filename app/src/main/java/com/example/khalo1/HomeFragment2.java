package com.example.khalo1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Fade;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.khalo1.Adapters.HomePagerAdapter;
import com.example.khalo1.Adapters.HomePagerAdapter2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeFragment2 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new Fade(Fade.IN).setDuration(1000));
        //setExitTransition(new Fade(Fade.OUT).setDuration(1000));
        Log.d("Frag","onCreate");
        //postponeEnterTransition();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Frag","onCreateView");
        return inflater.inflate(R.layout.fragment_home2,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = view.findViewById(R.id.home_tab_layout);
        MyViewPager viewPager = view.findViewById(R.id.homePager);
        viewPager.setAdapter(new HomePagerAdapter2(this.getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        requireActivity().findViewById(R.id.global_toolbar).setVisibility(View.VISIBLE);
        Log.d("Frag","onViewCreated");
        view.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        view.getViewTreeObserver()
                                .removeOnPreDrawListener(this);
                       /* RecyclerView recyclerView = view.findViewById(R.id.upcoming_recycler);
                        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        layoutManager.scrollToPosition(MainActivity.currentPosition);
                        startPostponedEnterTransition();*/
                        return true;
                    }
                }
        );

    }

    @Override
    public void onDestroy() {
        Log.d("Frag","destroyed");
        super.onDestroy();

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Frag","paused");
    }
}
