package com.example.khalo1.DataSource;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.khalo1.DataModel.Exhibit;
import com.example.khalo1.DataModel.Highlight;
import com.example.khalo1.DataModel.UpcomingExhibit;
import com.example.khalo1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repo {
    ArrayList<Exhibit> exhibits = new ArrayList<>();
    public String [] category = {"All","Modern","Renaissance","Classical","Post-Modern"};
    public Repo(){
        exhibits.add(new Exhibit(
                R.drawable.birding,
                "Modern","Birding",R.string.description));
        exhibits.add(new Exhibit(
                R.drawable.the_annunciation,
                "Modern","Title Here!",R.string.description));
        exhibits.add(new Exhibit(
                R.drawable.fragment_queen,
                "Modern","Moais, Easter Islands",R.string.description));
        //Modern
        exhibits.add(new Exhibit(
                R.drawable.arms_and_armor_marquee,
                "Classical","The Annunciation",R.string.description));
        exhibits.add(new Exhibit(
                R.drawable.adrianna_geo,
                "Classical","Andriana",R.string.description));
        exhibits.add(new Exhibit(
                R.drawable.fragment_queen,
                "Classical","Anubis, Ancient Egypt",R.string.description));

        //Renaissance
        exhibits.add(new Exhibit(
                R.drawable.school_of_attens,
                "Renaissance","The School Of Athens",R.string.description));
        exhibits.add(new Exhibit(
                R.drawable.nineveh,
                "Renaissance","Royal Gate, Nineveh",R.string.description));
        exhibits.add(new Exhibit(
                R.drawable.profile,
                "Renaissance","Pedestal Plate, Ancient Americas",R.string.description));

        //Post-Mordern
        exhibits.add(new Exhibit(
                R.drawable.monalisa,
                "Post-Modern","Mona Lisa-Leo DaVinci, 1800",R.string.description));
        exhibits.add(new Exhibit(
                R.drawable.adrianna_geo,
                "Post-Modern","Pot Paintings, Ancient Greece",R.string.description));
        exhibits.add(new Exhibit(
                R.drawable.fragment_queen,
                "Post-Modern","Laocoon and his sons, Greece",R.string.description));
        exhibits.add(new Exhibit(
                R.drawable.hi1,
                "Post-Modern","Saint John- Donatello, 1511",R.string.description));


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Exhibit> getExhibitsByCategory(String category){
        return exhibits.stream()
                .filter((exhibit)->exhibit.category.equals(category))
        .collect(Collectors.toList());
    }

    public List<Exhibit> getAll(){
        return exhibits;
    }

    static public ArrayList<Highlight> getHighlights(){
        ArrayList<Highlight> highlights = new ArrayList<>();
        highlights.add(new Highlight(R.drawable.the_annunciation,"Frankie Cordoba is heading for the limelights at this years FLANN."));
        highlights.add(new Highlight(R.drawable.profile,"Frankie Cordoba is heading for the limelights at this years FLANN."));
        highlights.add(new Highlight(R.drawable.adrianna_geo,"The Art of fashion \nSome interviewee takes us through the years, from the 1700 till now"));
        return highlights;
    }

    static public ArrayList<UpcomingExhibit> getUpcomingExhibit(){
        ArrayList<UpcomingExhibit> upcomingExhibits = new ArrayList<>();
        upcomingExhibits.add(new UpcomingExhibit(R.drawable.birding, "The Italian Renaissance: Da-Vinci's codex","STARTS TODAY"));
        upcomingExhibits.add(new UpcomingExhibit(R.drawable.adrianna_geo, "The Italian Renaissance: Da-Vinci's codex","Still Screening, 1pm - 8pm"));
        upcomingExhibits.add(new UpcomingExhibit(R.drawable.arms_and_armor_marquee, "The Grate War of Camelot","Still Screening, 1pm - 8pm"));
        upcomingExhibits.add(new UpcomingExhibit(R.drawable.profile, "The Italian Renaissance: Da-Vinci's codex","Thursday, 1pm - 8pm"));
        upcomingExhibits.add(new UpcomingExhibit(R.drawable.timon_klauser, "An Interesting Title","Friday, 1pm - 8pm"));
        return upcomingExhibits;

    }

}
