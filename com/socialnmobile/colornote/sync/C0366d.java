package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p020d.C0376a;
import com.socialnmobile.colornote.sync.p020d.C0377b;
import com.socialnmobile.util.p011b.C0364k;
import com.socialnmobile.util.p011b.C0385e;
import com.socialnmobile.util.p011b.C0470g;
import com.socialnmobile.util.p011b.C0471i;
import com.socialnmobile.util.p011b.p017b.C0465h;
import com.socialnmobile.util.p011b.p017b.C0466i;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.socialnmobile.colornote.sync.d */
public class C0366d extends C0364k implements C0365m {
    public final C0385e f1519d;
    public final C0385e f1520e;
    public final C0385e f1521f;
    public final C0385e f1522g;
    public final C0385e f1523h;
    public final C0385e f1524i;
    public final C0385e f1525j;
    public final C0385e f1526k;
    public final C0385e f1527l;
    public final C0385e f1528m;
    public final C0385e f1529n;
    public final C0385e f1530o;
    public final C0385e f1531p;
    public final C0385e f1532q;
    public final C0385e f1533r;
    public final C0385e f1534s;
    public final C0385e f1535t;
    public final C0385e f1536u;
    public final C0385e f1537v;
    public final C0385e f1538w;
    public final C0386g f1539x;

    public C0366d() {
        this.f1519d = m1849a(y);
        this.f1520e = m1849a(C);
        this.f1521f = m1849a(z);
        this.f1522g = m1849a(A);
        this.f1523h = m1849a(B);
        this.f1524i = m1849a(D);
        this.f1525j = m1849a(E);
        this.f1526k = m1849a(F);
        this.f1527l = m1849a(G);
        this.f1528m = this.f1519d;
        this.f1529n = new C0471i(this.f1521f, C0466i.f2261a);
        this.f1530o = new C0471i(this.f1522g, bg.f1557e);
        this.f1531p = this.f1523h;
        this.f1532q = new C0470g(this.f1520e, am.f1491a);
        this.f1533r = this.f1524i;
        this.f1534s = this.f1525j;
        this.f1535t = new C0471i(this.f1527l, C0465h.f2260a);
        this.f1536u = new C0471i(this.f1526k, C0465h.f2260a);
        this.f1537v = new C0471i(this.f1535t, C0402r.f1813a);
        this.f1538w = new C0471i(this.f1536u, bn.f1572a);
        this.f1539x = new C0386g(this);
    }

    public final void m1856d() {
        if (this.f1528m.m2010c() == null) {
            C0311h.f1370a.m1622a("AccountData problem", "id is null", (C0361e) C0383e.f1774a.m1782c(this));
            throw new RuntimeException("Account.id is null");
        } else if (this.f1532q.m2010c() == null) {
            C0311h.f1370a.m1622a("AccountData problem", "AuthToken is null", (C0361e) C0383e.f1774a.m1782c(this));
            throw new RuntimeException("Account.authToken is null");
        }
    }

    public final HashMap m1854a(C0405u c0405u) {
        return this.f1539x.m2012a().f1775a.f1809g.m2062a(c0405u);
    }

    final void m1855b(C0376a c0376a, C0377b c0377b) {
        C0409z c0409z;
        Iterator it;
        Object obj;
        try {
            cl.m1829a(c0377b.f1706a);
            cl.m1829a(c0377b.f1706a.f1804b);
            cl.m1829a(c0377b.f1706a.f1809g);
            cl.m1829a(c0377b.f1707b);
            cl.m1829a(c0377b.f1707b.f1570e);
            cl.m1829a(c0377b.f1707b.f1569d);
            cl.m1829a(c0377b.f1707b.f1569d.f1498a);
            cl.m1829a(c0377b.f1707b.f1569d.f1499b);
        } catch (Throwable e) {
            C0311h.f1370a.m1625a("", e, (C0361e) C0383e.f1774a.m1782c(this));
        }
        c0377b.f1707b.f1569d.f1500c = c0376a.f1702d;
        this.f1528m.m2008a(Long.valueOf(c0377b.f1706a.f1803a));
        this.f1532q.m2008a(c0377b.f1707b.f1570e);
        this.f1537v.m2008a(c0377b.f1706a);
        this.f1538w.m2008a(c0377b.f1707b);
        this.f1530o.m2008a(c0377b.f1706a.f1807e);
        C0401q c0401q = c0377b.f1706a;
        if (c0401q.f1809g != null) {
            c0409z = c0401q.f1809g;
            if (c0409z.f1828d != null) {
                it = C0409z.m2061a(c0409z.f1828d.keySet()).iterator();
                if (it.hasNext()) {
                    obj = (String) it.next();
                }
            }
            obj = null;
        } else {
            obj = null;
        }
        this.f1534s.m2008a(obj);
        as asVar = c0377b.f1707b.f1569d;
        if (asVar.f1498a == C0405u.f1818a || asVar.f1498a == C0405u.f1820c) {
            obj = asVar.f1499b;
        } else {
            String str = null;
        }
        if (obj == null) {
            c0401q = c0377b.f1706a;
            if (c0401q.f1809g != null) {
                c0409z = c0401q.f1809g;
                if (c0409z.f1826b != null) {
                    Iterator it2 = C0409z.m2061a(c0409z.f1826b.keySet()).iterator();
                    if (it2.hasNext()) {
                        str = (String) it2.next();
                    }
                }
                if (c0409z.f1825a != null) {
                    it = C0409z.m2061a(c0409z.f1825a.keySet()).iterator();
                    if (it.hasNext()) {
                        str = (String) it.next();
                    }
                }
                obj = null;
            } else {
                obj = null;
            }
        }
        this.f1533r.m2008a(obj);
    }

    private void m1853a() {
        cl.m1829a((Long) this.f1528m.m2010c());
        C0401q c0401q = (C0401q) this.f1537v.m2010c();
        cl.m1829a(c0401q);
        cl.m1829a(c0401q.f1805c);
        cl.m1829a(c0401q.f1806d);
        cl.m1829a(c0401q.f1807e);
        cl.m1829a(c0401q.f1809g);
        bm bmVar = (bm) this.f1538w.m2010c();
        cl.m1829a(bmVar);
        cl.m1829a(bmVar.f1569d);
        cl.m1829a(bmVar.f1566a);
        cl.m1829a(bmVar.f1567b);
    }

    public final void m1858f() {
        try {
            m1853a();
        } catch (Throwable e) {
            C0311h.f1370a.m1625a("verification for db failed", e, (C0361e) C0383e.f1774a.m1782c(this));
        }
    }

    public final long m1860h() {
        Long l = (Long) this.f1528m.m2010c();
        if (l != null) {
            return l.longValue();
        }
        C0311h.f1370a.m1622a("AccountData problem", "id is null", (C0361e) C0383e.f1774a.m1782c(this));
        throw new RuntimeException("Account.id is null");
    }

    public final long m1861i() {
        Long l = (Long) this.f1531p.m2010c();
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public final am m1862j() {
        return (am) this.f1532q.m2010c();
    }

    public final boolean m1864l() {
        return this.f1539x.m2012a().f1775a.f1812j;
    }

    public final bm m1865m() {
        return this.f1539x.m2012a().f1776b;
    }

    public final String m1857e() {
        as asVar = m1865m().f1569d;
        if (asVar.f1498a == C0405u.f1818a) {
            return asVar.f1499b;
        }
        aa aaVar;
        C0405u c0405u = asVar.f1498a;
        String str = asVar.f1499b;
        if (str != null) {
            aaVar = (aa) m1854a(c0405u).get(str);
        } else {
            aaVar = null;
        }
        if (aaVar == null) {
            return asVar.f1499b;
        }
        dd ddVar = aaVar.f1482c;
        if (ddVar == null) {
            return asVar.f1499b;
        }
        String str2 = ddVar.f1725b;
        if (str2 == null) {
            return asVar.f1499b;
        }
        return str2;
    }

    public final void m1859g() {
        try {
            m1853a();
            cl.m1829a(((C0401q) this.f1537v.m2010c()).f1804b);
            cl.m1829a(((bm) this.f1538w.m2010c()).f1570e);
        } catch (Throwable e) {
            C0311h.f1370a.m1625a("verification for db failed", e, (C0361e) C0383e.f1774a.m1782c(this));
        }
    }

    public final cq m1863k() {
        return this.f1539x.m2012a().f1775a.f1804b;
    }
}
