package com.socialnmobile.colornote.fragment;

import android.support.v4.app.DialogFragment;

final class cc implements Runnable {
    final /* synthetic */ DialogFragment f1279a;
    final /* synthetic */ NoteListFragment f1280b;

    cc(NoteListFragment noteListFragment, DialogFragment dialogFragment) {
        this.f1280b = noteListFragment;
        this.f1279a = dialogFragment;
    }

    public final void run() {
        if (this.f1280b.f83w) {
            this.f1279a.m85a(this.f1280b.f47B, "dialog");
        }
    }
}
