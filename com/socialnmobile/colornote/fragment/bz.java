package com.socialnmobile.colornote.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.data.C0229s;

final class bz implements OnClickListener {
    final /* synthetic */ NoteListFragment f1275a;

    bz(NoteListFragment noteListFragment) {
        this.f1275a = noteListFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0229s.m1047a(this.f1275a.f48C, this.f1275a.ad, false);
    }
}
