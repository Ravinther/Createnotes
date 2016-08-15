package com.socialnmobile.colornote.menu;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.socialnmobile.colornote.menu.o */
final class C0328o implements OnClickListener {
    final /* synthetic */ C0326m f1439a;

    C0328o(C0326m c0326m) {
        this.f1439a = c0326m;
    }

    public final void onClick(View view) {
        this.f1439a.f1430b = new C0316a(view.getContext(), view, this.f1439a.f1429a);
        this.f1439a.f1430b.m1687a();
    }
}
