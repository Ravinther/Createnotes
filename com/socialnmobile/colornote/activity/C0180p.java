package com.socialnmobile.colornote.activity;

import android.content.Intent;

/* renamed from: com.socialnmobile.colornote.activity.p */
final class C0180p implements Runnable {
    final /* synthetic */ Intent f835a;
    final /* synthetic */ Main f836b;

    C0180p(Main main, Intent intent) {
        this.f836b = main;
        this.f835a = intent;
    }

    public final void run() {
        if (this.f836b.f660y) {
            this.f836b.m721d();
            this.f836b.m712a(this.f835a);
        }
    }
}
