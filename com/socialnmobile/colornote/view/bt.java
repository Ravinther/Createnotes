package com.socialnmobile.colornote.view;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.p000a.C0004c;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.fragment.ce;

final class bt extends C0004c {
    boolean f2113u;
    ce f2114v;

    public final /* synthetic */ Object m2199d() {
        return m2200e();
    }

    public bt(Context context, ScreenGridList screenGridList) {
        super(context);
        this.f2114v = screenGridList.f2008k;
        this.f2113u = screenGridList.f1994D;
    }

    public final Cursor m2200e() {
        if (this.f2114v.f1283c == 0) {
            return C0229s.m1038a(this.f2o, this.f2113u, this.f2114v.f1282b, 2, 10000, this.f2114v.f1285e, this.f2114v.f1286f, this.f2114v.f1287g);
        }
        return C0229s.m1038a(this.f2o, this.f2113u, this.f2114v.f1282b, 1, this.f2114v.f1283c, this.f2114v.f1285e, this.f2114v.f1286f, this.f2114v.f1287g);
    }
}
