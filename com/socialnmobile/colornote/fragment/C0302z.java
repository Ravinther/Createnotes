package com.socialnmobile.colornote.fragment;

import android.support.v4.app.DialogFragment;

/* renamed from: com.socialnmobile.colornote.fragment.z */
final class C0302z implements Runnable {
    final /* synthetic */ DialogFragment f1348a;
    final /* synthetic */ CalendarFragment f1349b;

    C0302z(CalendarFragment calendarFragment, DialogFragment dialogFragment) {
        this.f1349b = calendarFragment;
        this.f1348a = dialogFragment;
    }

    public final void run() {
        if (this.f1349b.f83w) {
            this.f1348a.m85a(this.f1349b.f47B, "dialog");
        }
    }
}
