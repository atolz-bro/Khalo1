package com.example.khalo1;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class MyViewPager extends ViewPager {
    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

   /* @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        RecyclerView rec = findViewById(R.id.upcoming_recycler);
        View v = findViewById(R.id.upcoiming_exhibit);
        if(v != null) {
            Rect rect = new Rect();
            v.getHitRect(rect);

            if (rect.contains((int) ev.getX(), (int) ev.getY())) {
                return false;
            }
        }
        System.out.println(ev.getX()+"  "+ev.getY());
        System.out.println("Raw"+ev.getRawX()+"  "+ev.getRawY());

        return super.onInterceptTouchEvent(ev);
    }*/
}
