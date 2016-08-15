package com.socialnmobile.colornote.view;

import android.database.DataSetObserver;

final class ap extends DataSetObserver {
    final /* synthetic */ MyViewPager f2036a;

    private ap(MyViewPager myViewPager) {
        this.f2036a = myViewPager;
    }

    public final void onChanged() {
        this.f2036a.m2123a();
    }

    public final void onInvalidated() {
        this.f2036a.m2123a();
    }
}
