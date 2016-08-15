package com.socialnmobile.colornote.view;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class bq implements OnScrollListener {
    final /* synthetic */ ScreenGridList f2110a;

    bq(ScreenGridList screenGridList) {
        this.f2110a = screenGridList;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f2110a.f2020y || this.f2110a.f2021z) {
            ScreenGridList.m2135a(this.f2110a, absListView);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            ScreenGridList.m2135a(this.f2110a, absListView);
            this.f2110a.f2021z = false;
        } else if (i == 2) {
            this.f2110a.f2021z = true;
        }
    }
}
