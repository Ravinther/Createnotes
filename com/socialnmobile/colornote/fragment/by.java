package com.socialnmobile.colornote.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.C0310g;
import com.socialnmobile.colornote.data.C0229s;

final class by implements OnClickListener {
    final /* synthetic */ NoteListFragment f1274a;

    by(NoteListFragment noteListFragment) {
        this.f1274a = noteListFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0229s.m1047a(this.f1274a.f48C, this.f1274a.ad, true);
        if (C0310g.m1616a(this.f1274a.ac)) {
            this.f1274a.m1318e(1018);
        }
    }
}
