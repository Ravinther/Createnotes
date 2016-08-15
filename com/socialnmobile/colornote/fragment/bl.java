package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.menu.C0164q;
import com.socialnmobile.colornote.view.ScreenGridList;

final class bl implements C0164q {
    final /* synthetic */ String f1259a;
    final /* synthetic */ NoteListFragment f1260b;

    bl(NoteListFragment noteListFragment, String str) {
        this.f1260b = noteListFragment;
        this.f1259a = str;
    }

    public final boolean m1577a(int i, String str) {
        ScreenGridList A = this.f1260b.m1294A();
        if (this.f1260b.m1278t() == 1) {
            A.m2145a(i, true);
        } else {
            A.m2145a(i, false);
        }
        this.f1260b.m1308a(this.f1259a);
        return true;
    }
}
