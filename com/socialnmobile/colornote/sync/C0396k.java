package com.socialnmobile.colornote.sync;

import android.content.ContentValues;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0353a;

/* renamed from: com.socialnmobile.colornote.sync.k */
public final class C0396k extends C0353a {
    public final C0384f m2033a(C0366d c0366d) {
        C0361e c0361e = (C0361e) c0366d.f1536u.m2010c();
        C0361e c0361e2 = (C0361e) c0366d.f1535t.m2010c();
        if (c0361e2 == null) {
            throw new C0397l(this);
        } else if (c0361e == null) {
            throw new C0397l(this);
        } else if (c0361e.containsKey("authentication")) {
            return new C0384f(C0402r.f1813a.m2046a(c0361e2), bn.f1572a.m1904a(c0361e));
        } else {
            throw new C0397l(this);
        }
    }

    public static void m2032a(C0384f c0384f, C0366d c0366d) {
        c0366d.f1537v.m2008a(c0384f.f1775a);
        c0366d.f1538w.m2008a(c0384f.f1776b);
    }

    public final /* synthetic */ Object m2034a() {
        C0366d c0366d = new C0366d();
        c0366d.m1850c(new ContentValues());
        return c0366d;
    }
}
