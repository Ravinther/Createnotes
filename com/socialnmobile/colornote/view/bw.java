package com.socialnmobile.colornote.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.socialnmobile.colornote.data.C0210a;

final class bw implements OnClickListener {
    final /* synthetic */ bv f2133a;

    bw(bv bvVar) {
        this.f2133a = bvVar;
    }

    public final void onClick(View view) {
        if (C0210a.m894a(view.getContext(), "PREF_TITLE_NOTI_NUMBER") <= 0) {
            C0210a.m897a(view.getContext(), "PREF_TITLE_NOTI_NUMBER", 1);
            this.f2133a.f2127c.setVisibility(8);
        }
        if (this.f2133a.f2132h != null) {
            this.f2133a.f2132h.onClick(view);
        }
    }
}
