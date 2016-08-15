package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.dialog.C0170m;

final class bu implements C0170m {
    final /* synthetic */ NoteListFragment f1270a;

    bu(NoteListFragment noteListFragment) {
        this.f1270a = noteListFragment;
    }

    public final boolean m1583a(String str) {
        if (!C0213c.m962a(this.f1270a.f48C, str)) {
            return false;
        }
        C0229s.m1047a(this.f1270a.f48C, this.f1270a.ad, false);
        return true;
    }
}
