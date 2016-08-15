package com.socialnmobile.colornote.view;

import android.database.DataSetObserver;

final class bs extends DataSetObserver {
    final /* synthetic */ ScreenGridList f2112a;

    bs(ScreenGridList screenGridList) {
        this.f2112a = screenGridList;
    }

    public final void onChanged() {
        this.f2112a.m2153c();
    }
}
