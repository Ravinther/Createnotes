package com.socialnmobile.colornote.fragment;

import android.view.View;

final class cf implements Runnable {
    final /* synthetic */ View f1288a;
    final /* synthetic */ NotesFragment f1289b;

    cf(NotesFragment notesFragment, View view) {
        this.f1289b = notesFragment;
        this.f1288a = view;
    }

    public final void run() {
        if (this.f1288a.isSelected()) {
            this.f1288a.setSelected(false);
        } else {
            this.f1288a.setSelected(true);
        }
        NotesFragment notesFragment = this.f1289b;
        int i = notesFragment.f1184c;
        notesFragment.f1184c = i - 1;
        if (i > 0) {
            this.f1289b.Y.postDelayed(this, 1500);
        } else {
            this.f1288a.setSelected(false);
        }
    }
}
