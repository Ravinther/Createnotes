package com.socialnmobile.util.p011b;

import com.socialnmobile.colornote.sync.cl;
import com.socialnmobile.util.p011b.p016c.C0351e;

/* renamed from: com.socialnmobile.util.b.i */
public final class C0471i implements C0385e {
    final C0385e f2269a;
    final C0351e f2270b;

    public C0471i(C0385e c0385e, C0351e c0351e) {
        this.f2269a = c0385e;
        this.f2270b = c0351e;
    }

    public final Object m2317c() {
        try {
            return this.f2270b.m1779d(this.f2269a.m2010c());
        } catch (cl e) {
            return null;
        }
    }

    public final void m2315a(Object obj) {
        this.f2269a.m2008a(this.f2270b.m1778c(obj));
    }

    public final void m2316b() {
        this.f2269a.m2009b();
    }
}
