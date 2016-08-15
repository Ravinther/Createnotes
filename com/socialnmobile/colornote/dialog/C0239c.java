package com.socialnmobile.colornote.dialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.socialnmobile.colornote.data.C0221k;

/* renamed from: com.socialnmobile.colornote.dialog.c */
final class C0239c implements OnItemLongClickListener {
    final /* synthetic */ C0237a f1066a;

    C0239c(C0237a c0237a) {
        this.f1066a = c0237a;
    }

    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        C0221k c0221k = (C0221k) this.f1066a.f1055i.getItem(i);
        if (c0221k.f970b == 0) {
            return false;
        }
        if (this.f1066a.f1049c != -1) {
            this.f1066a.f1053g.m1302a(this.f1066a.f1049c, c0221k.f970b);
        }
        return true;
    }
}
