package com.socialnmobile.colornote.menu;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.socialnmobile.colornote.menu.n */
final class C0327n implements OnClickListener {
    final /* synthetic */ C0326m f1438a;

    C0327n(C0326m c0326m) {
        this.f1438a = c0326m;
    }

    public final void onClick(View view) {
        C0329p c0329p;
        switch (view.getId()) {
            case 2131624088:
                c0329p = (C0329p) this.f1438a.f1432d.get(0);
                this.f1438a.f1429a.m807a(c0329p.f1440a, c0329p.f1443d);
            case 2131624089:
                c0329p = (C0329p) this.f1438a.f1432d.get(1);
                this.f1438a.f1429a.m807a(c0329p.f1440a, c0329p.f1443d);
            case 2131624090:
                if (this.f1438a.m1700a()) {
                    c0329p = this.f1438a.m1701b();
                    this.f1438a.f1429a.m807a(c0329p.f1440a, c0329p.f1443d);
                    return;
                }
                this.f1438a.f1430b = new C0316a(view.getContext(), view, this.f1438a.f1429a);
                this.f1438a.f1430b.m1687a();
            default:
        }
    }
}
