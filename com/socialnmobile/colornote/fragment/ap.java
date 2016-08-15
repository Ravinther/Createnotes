package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class ap implements OnItemClickListener {
    final /* synthetic */ ListEditor f1227a;

    ap(ListEditor listEditor) {
        this.f1227a = listEditor;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (j != -1) {
            this.f1227a.m1447g((int) j);
        } else if (i == 0) {
            this.f1227a.m1251a(new an(true.f1217a.f1216b, true));
        } else {
            this.f1227a.m1251a(new an(false.f1217a.f1216b, false));
        }
    }
}
