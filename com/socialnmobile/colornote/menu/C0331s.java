package com.socialnmobile.colornote.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.socialnmobile.colornote.menu.s */
final class C0331s implements OnClickListener {
    final /* synthetic */ TopBarSubMenuInfo f1449a;

    C0331s(TopBarSubMenuInfo topBarSubMenuInfo) {
        this.f1449a = topBarSubMenuInfo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0329p c0329p = (C0329p) this.f1449a.f1377b.get(i);
        if (this.f1449a.f1380e != null) {
            this.f1449a.f1380e.m807a(c0329p.f1440a, c0329p.f1443d);
        }
    }
}
