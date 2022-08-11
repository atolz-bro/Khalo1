package com.example.khalo1;

import android.graphics.Outline;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.Fade;

public class TicketsFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnterTransition(new Fade(Fade.IN).setDuration(1000));
        //setExitTransition(new Fade(Fade.OUT).setDuration(1000));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tickets,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //view.findViewById(R.id.imageView2).invalidateOutline();
       /* view.findViewById(R.id.imageView2).setOutlineProvider(new MyViewOutlineProvider());
        view.findViewById(R.id.imageView2).setClipToOutline(true);
        view.findViewById(R.id.textv).setClipToOutline(true);
        view.findViewById(R.id.textv).setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(
                        0,0,view.getWidth(),view.getHeight(),10f);
            }
        });*/


    }
}
