package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

/* renamed from: com.socialnmobile.colornote.fragment.w */
final class C0299w implements OnItemSelectedListener {
    final /* synthetic */ ArchiveFragment f1345a;

    C0299w(ArchiveFragment archiveFragment) {
        this.f1345a = archiveFragment;
    }

    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            this.f1345a.f1163d.m2144a(-1);
        } else if (i == 1) {
            this.f1345a.f1163d.m2144a(0);
        } else if (i == 2) {
            this.f1345a.f1163d.m2144a(16);
        }
    }

    public final void onNothingSelected(AdapterView adapterView) {
    }
}
