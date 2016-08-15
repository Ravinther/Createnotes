package com.socialnmobile.util.p011b;

import com.socialnmobile.colornote.sync.cl;
import com.socialnmobile.util.p011b.p016c.C0351e;
import com.socialnmobile.util.p011b.p016c.C0354c;
import com.socialnmobile.util.p011b.p016c.C0468d;

/* renamed from: com.socialnmobile.util.b.g */
public final class C0470g implements C0385e {
    final C0385e f2267a;
    final C0351e f2268b;

    public C0470g(C0385e c0385e, C0354c c0354c) {
        this.f2267a = c0385e;
        this.f2268b = new C0468d(c0354c, c0354c);
    }

    public final Object m2314c() {
        try {
            return this.f2268b.m1779d((String) this.f2267a.m2010c());
        } catch (cl e) {
            return null;
        }
    }

    public final void m2312a(Object obj) {
        this.f2267a.m2008a((String) this.f2268b.m1778c(obj));
    }

    public final void m2313b() {
        this.f2267a.m2009b();
    }
}
