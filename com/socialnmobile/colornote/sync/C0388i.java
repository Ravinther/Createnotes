package com.socialnmobile.colornote.sync;

import android.content.Context;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.sync.p018b.C0358b;
import com.socialnmobile.colornote.sync.p018b.C0361e;

/* renamed from: com.socialnmobile.colornote.sync.i */
public final class C0388i {
    final C0366d f1781a;
    final Context f1782b;
    final C0361e f1783c;
    final C0361e f1784d;
    final C0405u f1785e;

    public C0388i(C0366d c0366d, Context context) {
        this.f1782b = context;
        this.f1781a = c0366d;
        this.f1783c = (C0361e) c0366d.f1535t.m2010c();
        this.f1784d = (C0361e) c0366d.f1536u.m2010c();
        if (this.f1784d == null) {
            throw new C0389j(this);
        }
        try {
            String d = this.f1784d.m1838d("auth_method");
            this.f1785e = C0405u.m2057a(d);
            if (this.f1785e == null) {
                throw new cl("unsupported authority: " + d);
            }
        } catch (C0358b e) {
            throw new C0389j(this);
        } catch (Throwable e2) {
            throw new cl(e2);
        }
    }

    final ci m2024a(cj cjVar) {
        try {
            return (ci) cjVar.m1783d(m2022c());
        } catch (Exception e) {
            return null;
        }
    }

    final cf m2023a(cg cgVar) {
        try {
            return (cf) cgVar.m1783d(m2022c());
        } catch (Exception e) {
            return null;
        }
    }

    final cq m2025a() {
        try {
            if (this.f1783c != null) {
                return (cq) this.f1783c.m1832a("NEK", cr.f1642a);
            }
            if (this.f1782b != null) {
                return new C0400p(this.f1781a.m1860h(), this.f1782b).m2045a();
            }
            return null;
        } catch (Throwable e) {
            C0311h.f1370a.m1625a("", e, (C0361e) C0383e.f1774a.m1782c(this.f1781a));
        }
    }

    private C0361e m2022c() {
        return this.f1784d.m1839e("creds");
    }

    final C0361e m2026b() {
        return this.f1784d.m1844j("external_userinfo");
    }
}
