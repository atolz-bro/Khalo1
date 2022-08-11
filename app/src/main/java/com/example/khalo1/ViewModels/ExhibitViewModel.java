package com.example.khalo1.ViewModels;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.khalo1.DataModel.Exhibit;
import com.example.khalo1.DataSource.Repo;

import java.util.List;

public class ExhibitViewModel extends ViewModel {
    public Repo myRepo = new Repo();
    public String [] category = {"All","Modern","Renaissance","Classical","Post-Modern"};
    private  final MutableLiveData<List<Exhibit>> exhibits =
            new MutableLiveData<>(myRepo.getAll());

    @RequiresApi(api = Build.VERSION_CODES.N)
    public LiveData<List<Exhibit>> getExhibitByCategory(String category){
        return new MutableLiveData<>(myRepo.getExhibitsByCategory(category));
    }

    public LiveData<List<Exhibit>> getAll(){
        return exhibits;
    }
}
