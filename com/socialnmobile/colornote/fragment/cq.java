package com.socialnmobile.colornote.fragment;

import android.content.ContentUris;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.socialnmobile.colornote.data.C0228r;

final class cq implements OnItemClickListener {
    final /* synthetic */ SearchFragment f1301a;

    cq(SearchFragment searchFragment) {
        this.f1301a = searchFragment;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intent intent = new Intent("android.intent.action.VIEW", ContentUris.withAppendedId(C0228r.f997a, j));
        intent.putExtra("EXTRA_VIEW_FROM", "SEARCH");
        this.f1301a.m54a(intent);
    }
}
