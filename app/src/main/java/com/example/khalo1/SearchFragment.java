package com.example.khalo1;

import android.content.Context;
import android.graphics.Outline;
import android.os.Bundle;
import androidx.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.transition.Fade;
import androidx.viewpager2.widget.ViewPager2;

import com.example.khalo1.Adapters.ExplorePagerAdapter;
import com.example.khalo1.DataModel.Exhibit;
import com.example.khalo1.ViewModels.ExhibitViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class SearchFragment extends Fragment {
    EditText searchView;
    NavController navController;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        requireActivity().getOnBackPressedDispatcher().addCallback(
                this,
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        if(searchView.hasFocus())
                            searchView.clearFocus();
                        else
                            navController.popBackStack();
                    }
                }
        );


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new Fade(Fade.IN).setDuration(1000));
        //setExitTransition(TransitionInflater.from(getContext())
          //      .inflateTransition(R.transition.grid_exit_transition));
        //setExitTransition(new Fade(Fade.OUT).setDuration(1000));
       // requireActivity().findViewById(R.id.global_toolbar).setVisibility(View.GONE);
        //setHasOptionsMenu(false);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        postponeEnterTransition();
        return inflater.inflate(R.layout.fragment_search,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        ExhibitViewModel model = new ViewModelProvider(requireActivity()).get(ExhibitViewModel.class);

        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = view.findViewById(R.id.explore_tab);
        ViewPager2 viewPager2 = view.findViewById(R.id.search_view_pager);
        viewPager2.setAdapter(new ExplorePagerAdapter(this,requireActivity()));
        TabLayoutMediator tabLayoutMediator =
                new TabLayoutMediator(tabLayout,viewPager2,(tab,position)->{
                    tab.setText(model.category[position]);
                });
        tabLayoutMediator.attach();

        navController = Navigation.findNavController(view);

        searchView = view.findViewById(R.id.bar_search);
        searchView.setClipToOutline(true);
        searchView.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(
                        0,0,view.getWidth(),view.getHeight(),10f);


            }
        });

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

}
