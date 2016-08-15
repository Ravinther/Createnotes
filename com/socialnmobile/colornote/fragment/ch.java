package com.socialnmobile.colornote.fragment;

import android.support.v4.app.DialogFragment;

final class ch implements Runnable {
    final /* synthetic */ DialogFragment f1291a;
    final /* synthetic */ NotesFragment f1292b;

    ch(NotesFragment notesFragment, DialogFragment dialogFragment) {
        this.f1292b = notesFragment;
        this.f1291a = dialogFragment;
    }

    public final void run() {
        if (this.f1292b.f83w) {
            this.f1291a.m85a(this.f1292b.f47B, "dialog");
        }
    }
}
