package com.socialnmobile.colornote.activity;

import android.view.View;
import android.view.View.OnClickListener;

final class ap implements Runnable {
    final /* synthetic */ OnClickListener f794a;
    final /* synthetic */ View f795b;
    final /* synthetic */ SyncActivity f796c;

    ap(SyncActivity syncActivity, OnClickListener onClickListener, View view) {
        this.f796c = syncActivity;
        this.f794a = onClickListener;
        this.f795b = view;
    }

    public final void run() {
        this.f794a.onClick(this.f795b);
    }
}
