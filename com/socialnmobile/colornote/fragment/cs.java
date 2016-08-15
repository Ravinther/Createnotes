package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.HashMap;

final class cs implements OnItemClickListener {
    final /* synthetic */ SideMenuFragment f1303a;

    cs(SideMenuFragment sideMenuFragment) {
        this.f1303a = sideMenuFragment;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1303a.f1205h.m697a(((Integer) ((HashMap) this.f1303a.f1204g.get(i)).get("MENUID")).intValue());
    }
}
