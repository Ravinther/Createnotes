package com.socialnmobile.colornote.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.data.C0229s;

final class bw implements OnClickListener {
    final /* synthetic */ NoteListFragment f1272a;

    bw(NoteListFragment noteListFragment) {
        this.f1272a = noteListFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0229s.m1046a(this.f1272a.f48C, this.f1272a.ad, "LIST");
    }
}
