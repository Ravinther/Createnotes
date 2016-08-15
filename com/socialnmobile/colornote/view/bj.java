package com.socialnmobile.colornote.view;

import android.database.ContentObserver;
import android.os.Handler;

final class bj extends ContentObserver {
    final /* synthetic */ ScreenCalendar f2103a;

    bj(ScreenCalendar screenCalendar, Handler handler) {
        this.f2103a = screenCalendar;
        super(handler);
    }

    public final void onChange(boolean z) {
        if (this.f2103a.f1980a.m74h()) {
            this.f2103a.f1980a.m77l().m102a(2, null, this.f2103a);
        }
    }
}
