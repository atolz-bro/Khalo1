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
import androidx.transition.Fade;
import androidx.viewpager2.widget.ViewPager2;

import com.example.khalo1.Adapters.HomePagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new Fade(Fade.IN).setDuration(1000));
        //setExitTransition(new Fade(Fade.OUT).setDuration(1000));
        Log.d("Frag","onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Frag","onCreateView");
        return inflater.inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        postponeEnterTransition();
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = view.findViewById(R.id.home_tab_layout);
        ViewPager2 viewPager2 = view.findViewById(R.id.homePager);
        viewPager2.setAdapter(new HomePagerAdapter(this));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                      tab.setText("Latest");
                }
                if(position == 1){
                    tab.setText("Community");
                }
            }
        });
        tabLayoutMediator.attach();
        requireActivity().findViewById(R.id.global_toolbar).setVisibility(View.VISIBLE);
        Log.d("Frag","onViewCreated");
        view.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        view.getViewTreeObserver()
                                .removeOnPreDrawListener(this);
                        startPostponedEnterTransition();
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
