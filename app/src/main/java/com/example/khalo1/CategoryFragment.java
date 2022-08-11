package com.example.khalo1;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Fade;

import com.example.khalo1.Adapters.CategoryAdapter;
import com.example.khalo1.DataModel.Exhibit;
import com.example.khalo1.ViewModels.ExhibitViewModel;

import java.util.List;

public class CategoryFragment extends Fragment {
    public static final String CATEGORY = "category";
    ExhibitViewModel sharedViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setEnterTransition(new Fade(Fade.IN).setDuration(1000));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sharedViewModel = new ViewModelProvider(requireActivity()).get(ExhibitViewModel .class);
        return inflater.inflate(R.layout.fragment_category,container,false);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String category = getArguments().getString(CATEGORY);
        List<Exhibit> exhibits;
        if(category.equals("All"))
            exhibits = sharedViewModel.getAll().getValue();
        else
            exhibits = sharedViewModel.getExhibitByCategory(category).getValue();

        CategoryAdapter categoryAdapter = new CategoryAdapter(
                exhibits,requireActivity());
        RecyclerView recyclerView = view.findViewById(R.id.category_recyclerview);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        );
    }
}
