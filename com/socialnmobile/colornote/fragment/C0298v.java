package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* renamed from: com.socialnmobile.colornote.fragment.v */
final class C0298v implements OnItemSelectedListener {
    final /* synthetic */ ArchiveFragment f1344a;

    C0298v(ArchiveFragment archiveFragment) {
        this.f1344a = archiveFragment;
    }

    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            this.f1344a.f1163d.m2151b(-1);
        } else if (i == 1) {
            this.f1344a.f1163d.m2151b(0);
        } else if (i == 2) {
            this.f1344a.f1163d.m2151b(16);
        }
    }

    public final void onNothingSelected(AdapterView adapterView) {
    }
}
