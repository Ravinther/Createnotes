package com.socialnmobile.colornote.sync;

import android.content.ContentValues;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

/* renamed from: com.socialnmobile.colornote.sync.e */
public final class C0383e extends C0354c {
    public static final C0383e f1774a;

    public final /* synthetic */ Object m2006a(Object obj) {
        C0361e c0361e = (C0361e) obj;
        C0366d c0366d = new C0366d();
        c0366d.m1850c(new ContentValues());
        c0366d.f1528m.m2008a(Long.valueOf(c0361e.m1841g("id").longValue()));
        c0366d.f1521f.m2008a(c0361e.m1842h("clientUUID"));
        c0366d.f1522g.m2008a(Long.valueOf(c0361e.m1841g("repositoryBuilt").longValue()));
        c0366d.f1531p.m2008a(Long.valueOf(c0361e.m1841g("baseRevision").longValue()));
        c0366d.f1520e.m2008a(c0361e.m1842h("authToken"));
        c0366d.f1533r.m2008a(c0361e.m1842h(AccountColumns.EMAIL));
        c0366d.f1534s.m2008a(c0361e.m1842h("username"));
        c0366d.f1526k.m2008a(c0361e.m1842h("fbat"));
        c0366d.f1527l.m2008a(c0361e.m1842h("fbpn"));
        return c0366d;
    }

    public final /* bridge */ /* synthetic */ void m2007a(Object obj, Object obj2) {
        C0366d c0366d = (C0366d) obj;
        C0361e c0361e = (C0361e) obj2;
        try {
            c0361e.m1833a("id", c0366d.f1519d);
        } catch (Exception e) {
        }
        try {
            c0361e.m1833a("clientUUID", c0366d.f1521f);
        } catch (Exception e2) {
        }
        try {
            c0361e.m1833a("repositoryBuilt", c0366d.f1522g);
        } catch (Exception e3) {
        }
        try {
            c0361e.m1833a("baseRevision", c0366d.f1523h);
        } catch (Exception e4) {
        }
        try {
            c0361e.m1833a("authToken", c0366d.f1520e);
        } catch (Exception e5) {
        }
        try {
            c0361e.m1833a(AccountColumns.EMAIL, c0366d.f1524i);
        } catch (Exception e6) {
        }
        try {
            c0361e.m1833a("username", c0366d.f1525j);
        } catch (Exception e7) {
        }
        try {
            c0361e.m1833a("fbat", c0366d.f1526k);
        } catch (Exception e8) {
        }
        try {
            c0361e.m1833a("fbpn", c0366d.f1527l);
        } catch (Exception e9) {
        }
    }

    static {
        f1774a = new C0383e();
    }
}
