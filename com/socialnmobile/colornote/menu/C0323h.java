package com.socialnmobile.colornote.menu;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* renamed from: com.socialnmobile.colornote.menu.h */
final class C0323h implements OnScrollListener {
    final /* synthetic */ C0318c f1426a;

    private C0323h(C0318c c0318c) {
        this.f1426a = c0318c;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.f1426a.m1695d() && this.f1426a.f1396a.getContentView() != null) {
            this.f1426a.f1405j.removeCallbacks(this.f1426a.f1404i);
            this.f1426a.f1404i.run();
        }
    }
}
