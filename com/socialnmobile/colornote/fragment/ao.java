package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.view.C0416g;

final class ao implements OnItemClickListener {
    final /* synthetic */ ListEditor f1226a;

    ao(ListEditor listEditor) {
        this.f1226a = listEditor;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0416g c0416g = (C0416g) view.getTag();
        this.f1226a.m1434a(c0416g.f2161b);
        c0416g.m2213a(c0416g.f2161b);
        if (C0212b.m956p(this.f1226a.f48C)) {
            this.f1226a.aa();
        }
    }
}
