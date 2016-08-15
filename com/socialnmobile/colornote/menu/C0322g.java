package com.socialnmobile.colornote.menu;

import android.database.DataSetObserver;

/* renamed from: com.socialnmobile.colornote.menu.g */
final class C0322g extends DataSetObserver {
    final /* synthetic */ C0318c f1425a;

    private C0322g(C0318c c0318c) {
        this.f1425a = c0318c;
    }

    public final void onChanged() {
        if (this.f1425a.f1396a.isShowing()) {
            this.f1425a.m1692a();
        }
    }

    public final void onInvalidated() {
        this.f1425a.m1693b();
    }
}
