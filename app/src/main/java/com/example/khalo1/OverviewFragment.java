package com.example.khalo1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;

import com.example.khalo1.ViewModels.ExhibitViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OverviewFragment extends Fragment {
    ExhibitViewModel sharedViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*    setEnterTransition(new Fade(Fade.IN).setDuration(1000));
        setExitTransition(new Fade(Fade.OUT).setDuration(1000));*/
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sharedViewModel = new ViewModelProvider(requireActivity()).get(ExhibitViewModel.class);
        View view = inflater.inflate(R.layout.fragment_overview_2,container,false);
        /*Transition transition = TransitionInflater.from(requireContext())
                .inflateTransition(R.transition.shared_image);
        setSharedElementEnterTransition(transition);*/
       /* BottomNavigationView btmNav = requireActivity().findViewById(R.id.bottom_nav_view);
        btmNav.setVisibility(View.GONE)*/;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        MaterialToolbar toolbar = view.findViewById(R.id.overviewToolbar);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(
                toolbar, navController, appBarConfiguration);

        ImageView imageView = view.findViewById(R.id.overview_image);
        imageView.setImageResource(getArguments().getInt("Image_Resource"));

    }

    @Override
    public void onPause() {

        super.onPause();
    }

    @Override
    public void onDestroy() {
        /*BottomNavigationView btmNav = requireActivity().findViewById(R.id.bottom_nav_view);
        btmNav.setVisibility(View.VISIBLE);*/
        super.onDestroy();
    }
}
