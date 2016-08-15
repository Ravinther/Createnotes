package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.menu.C0164q;
import com.socialnmobile.colornote.view.ScreenGridList;

final class bk implements C0164q {
    final /* synthetic */ NoteListFragment f1258a;

    bk(NoteListFragment noteListFragment) {
        this.f1258a = noteListFragment;
    }

    public final boolean m1576a(int i, String str) {
        ScreenGridList A = this.f1258a.m1294A();
        if (i != A.f2008k.f1285e) {
            A.setGridListViewOptions(A.f2008k.f1282b, A.f2008k.f1283c, i, A.f2008k.f1286f, A.f2008k.f1287g, A.f2008k.f1284d, true, true);
        }
        this.f1258a.m1295B();
        return true;
    }
}
