package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.C0310g;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.dialog.C0170m;

final class bs implements C0170m {
    final /* synthetic */ NoteListFragment f1268a;

    bs(NoteListFragment noteListFragment) {
        this.f1268a = noteListFragment;
    }

    public final boolean m1582a(String str) {
        if (!C0213c.m962a(this.f1268a.f48C, str)) {
            return false;
        }
        C0229s.m1047a(this.f1268a.f48C, this.f1268a.ad, true);
        if (!C0310g.m1616a(this.f1268a.ac)) {
            return true;
        }
        this.f1268a.m1318e(1018);
        return true;
    }
}
