package com.socialnmobile.colornote.fragment;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.socialnmobile.colornote.menu.C0164q;
import com.socialnmobile.colornote.view.ScreenGridList;

final class bm implements C0164q {
    final /* synthetic */ String f1261a;
    final /* synthetic */ NoteListFragment f1262b;

    bm(NoteListFragment noteListFragment, String str) {
        this.f1262b = noteListFragment;
        this.f1261a = str;
    }

    public final boolean m1578a(int i, String str) {
        ScreenGridList A = this.f1262b.m1294A();
        Editor edit = PreferenceManager.getDefaultSharedPreferences(A.getContext()).edit();
        edit.putInt("LIST_VIEW_TYPE", i);
        edit.commit();
        if (i != A.f2008k.f1284d) {
            A.setGridListViewOptions(A.f2008k.f1282b, A.f2008k.f1283c, A.f2008k.f1285e, A.f2008k.f1286f, A.f2008k.f1287g, i, true, true);
        }
        this.f1262b.m1311b(this.f1261a);
        return true;
    }
}
