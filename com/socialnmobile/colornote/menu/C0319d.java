package com.socialnmobile.colornote.menu;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* renamed from: com.socialnmobile.colornote.menu.d */
final class C0319d implements OnItemSelectedListener {
    final /* synthetic */ C0318c f1421a;

    C0319d(C0318c c0318c) {
        this.f1421a = c0318c;
    }

    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i != -1) {
            C0320e c0320e = this.f1421a.f1398c;
            if (c0320e != null) {
                c0320e.f1422a = false;
            }
        }
    }

    public final void onNothingSelected(AdapterView adapterView) {
    }
}
