package com.socialnmobile.colornote.dialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.socialnmobile.colornote.data.C0221k;

/* renamed from: com.socialnmobile.colornote.dialog.b */
final class C0238b implements OnItemClickListener {
    final /* synthetic */ C0237a f1065a;

    C0238b(C0237a c0237a) {
        this.f1065a = c0237a;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1065a.f1053g.m1309b(((C0221k) this.f1065a.f1055i.getItem(i)).f970b);
        this.f1065a.dismiss();
    }
}
