package com.socialnmobile.colornote.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;

final class bo implements OnTouchListener {
    final /* synthetic */ ScreenGridList f2108a;

    bo(ScreenGridList screenGridList) {
        this.f2108a = screenGridList;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.f2108a.f2019x = y;
                this.f2108a.f2020y = false;
                this.f2108a.f2009l = null;
                break;
            case 1:
                this.f2108a.f2020y = false;
                break;
            case 2:
                if (Math.abs(y - this.f2108a.f2019x) > this.f2108a.f1991A || this.f2108a.f2020y) {
                    this.f2108a.f2020y = true;
                    ScreenGridList.m2135a(this.f2108a, (AbsListView) view);
                    break;
                }
        }
        return false;
    }
}
