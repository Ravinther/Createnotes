package com.socialnmobile.colornote.fragment;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.data.C0228r;

final class cj implements OnItemClickListener {
    final /* synthetic */ RecycleBinFragment f1294a;

    cj(RecycleBinFragment recycleBinFragment) {
        this.f1294a = recycleBinFragment;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Uri withAppendedId = ContentUris.withAppendedId(C0228r.f997a, j);
        Intent intent = new Intent("android.intent.action.VIEW", withAppendedId);
        intent.putExtra("EXTRA_VIEW_FROM", "RECYCLE");
        try {
            this.f1294a.m54a(intent);
        } catch (Exception e) {
            String uri;
            Exception exception = e;
            if (withAppendedId != null) {
                uri = withAppendedId.toString();
            } else {
                uri = "null";
            }
            C0311h.f1370a.m1626b("RECYCLEBIN CLICK", exception.getClass().getSimpleName(), uri);
        }
    }
}
