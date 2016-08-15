package com.socialnmobile.colornote.fragment;

import android.support.v4.app.DialogFragment;

final class cm implements Runnable {
    final /* synthetic */ DialogFragment f1297a;
    final /* synthetic */ RecycleBinFragment f1298b;

    cm(RecycleBinFragment recycleBinFragment, DialogFragment dialogFragment) {
        this.f1298b = recycleBinFragment;
        this.f1297a = dialogFragment;
    }

    public final void run() {
        if (this.f1298b.f83w) {
            this.f1297a.m85a(this.f1298b.f47B, "dialog");
        }
    }
}
