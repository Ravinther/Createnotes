package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0220j;

final class an implements Runnable {
    final /* synthetic */ boolean f1224a;
    final /* synthetic */ ListEditor f1225b;

    an(ListEditor listEditor, boolean z) {
        this.f1225b = listEditor;
        this.f1224a = z;
    }

    public final void run() {
        int size = this.f1224a ? 0 : this.f1225b.ap.size();
        this.f1225b.ap.add(size, new C0220j("", false));
        this.f1225b.as = size;
        this.f1225b.ab();
        this.f1225b.m1444d(3);
    }
}
