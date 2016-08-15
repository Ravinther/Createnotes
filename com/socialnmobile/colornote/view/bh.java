package com.socialnmobile.colornote.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.socialnmobile.colornote.menu.C0329p;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;

final class bh implements OnItemClickListener {
    TopBarSubMenuInfo f2100a;
    final /* synthetic */ NotesOptions f2101b;

    bh(NotesOptions notesOptions, TopBarSubMenuInfo topBarSubMenuInfo) {
        this.f2101b = notesOptions;
        this.f2100a = topBarSubMenuInfo;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0329p c0329p = (C0329p) this.f2100a.f1377b.get(i);
        if (this.f2100a.f1380e != null) {
            this.f2100a.f1380e.m807a(c0329p.f1440a, c0329p.f1443d);
        }
        this.f2101b.f1972b.dismiss();
    }
}
