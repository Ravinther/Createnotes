package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.dialog.C0170m;

final class br implements C0170m {
    final /* synthetic */ NoteListFragment f1267a;

    br(NoteListFragment noteListFragment) {
        this.f1267a = noteListFragment;
    }

    public final boolean m1581a(String str) {
        if (!C0213c.m962a(this.f1267a.f48C, str)) {
            return false;
        }
        C0229s.m1046a(this.f1267a.f48C, this.f1267a.ad, this.f1267a.m1296C());
        return true;
    }
}
