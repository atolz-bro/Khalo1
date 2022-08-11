package com.example.khalo1;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

public class MyViewOutlineProvider extends ViewOutlineProvider {
    @Override
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(
                0,
                0,
                view.getWidth(),
                view.getHeight(), view.getWidth()/2.0f);
        outline.setAlpha((float) 0.9);

        /* Rect rect = new Rect();
        view.getDrawingRect(rect);
        outline.setRoundRect(
                rect,view.getWidth()/2f);
        outline.setAlpha((float) 0);*/
    }


}
