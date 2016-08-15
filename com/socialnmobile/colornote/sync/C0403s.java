package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;
import java.net.URI;
import java.util.HashMap;

/* renamed from: com.socialnmobile.colornote.sync.s */
public final class C0403s extends C0354c {
    final cr f1815a;
    final de f1816b;

    public C0403s() {
        this.f1815a = new cr();
        this.f1816b = new de();
    }

    public final void m2053a(C0401q c0401q, C0361e c0361e) {
        Object obj;
        c0361e.m1833a("id", Long.valueOf(c0401q.f1803a));
        c0361e.m1834a("nek", c0401q.f1804b, this.f1815a);
        c0361e.m1834a("created", c0401q.f1805c, bg.f1556d);
        c0361e.m1834a("modified", c0401q.f1806d, bg.f1556d);
        c0361e.m1834a(AccountColumns.REPOSITORY_BUILT, c0401q.f1807e, bg.f1556d);
        C0409z c0409z = c0401q.f1809g;
        if (c0409z == null) {
            obj = null;
        } else {
            obj = new C0361e();
            Object a = m2049a(c0409z.f1825a);
            Object a2 = m2049a(c0409z.f1826b);
            Object a3 = m2049a(c0409z.f1827c);
            Object a4 = m2049a(c0409z.f1828d);
            obj.m1833a(AccountColumns.EMAIL, a);
            obj.m1833a("google", a2);
            obj.m1833a("facebook", a3);
            obj.m1833a("colornote", a4);
        }
        c0361e.m1833a("identities", obj);
        c0361e.m1833a("notes_count", Integer.valueOf(c0401q.f1808f));
        if (c0401q.f1810h) {
            c0361e.m1833a("realtimesync_enable", Boolean.valueOf(true));
            c0361e.m1834a("realtimesync_server_url", c0401q.f1811i, dz.f1773a);
        }
    }

    public final C0401q m2051a(C0361e c0361e) {
        C0409z c0409z;
        long longValue = c0361e.m1837c("id").longValue();
        cq cqVar = (cq) c0361e.m1832a("nek", this.f1815a);
        bg bgVar = (bg) c0361e.m1831a("created", bg.f1556d);
        bg bgVar2 = (bg) c0361e.m1831a("modified", bg.f1556d);
        bg bgVar3 = (bg) c0361e.m1831a(AccountColumns.REPOSITORY_BUILT, bg.f1556d);
        C0361e j = c0361e.m1844j("identities");
        if (j == null) {
            c0409z = null;
        } else {
            c0409z = new C0409z(m2050a(C0405u.f1818a, j.m1844j(AccountColumns.EMAIL)), m2050a(C0405u.f1820c, j.m1844j("google")), m2050a(C0405u.f1819b, j.m1844j("facebook")), m2050a(C0405u.f1821d, j.m1844j("colornote")));
        }
        C0401q c0401q = new C0401q(longValue, cqVar, bgVar, bgVar2, bgVar3, c0361e.m1837c("notes_count").intValue(), c0409z);
        c0401q.f1810h = c0361e.m1840f("realtimesync_enable");
        c0401q.f1811i = (URI) dz.f1773a.m1783d(c0361e.m1842h("realtimesync_server_url"));
        return c0401q;
    }

    private C0361e m2049a(HashMap hashMap) {
        if (hashMap == null) {
            return null;
        }
        C0361e c0361e = new C0361e();
        for (String str : hashMap.keySet()) {
            Object obj;
            aa aaVar = (aa) hashMap.get(str);
            if (aaVar == null) {
                obj = null;
            } else {
                C0361e c0361e2 = new C0361e();
                c0361e2.m1833a("id", aaVar.f1481b);
                if (aaVar.f1482c != null) {
                    c0361e2.m1834a("profile", aaVar.f1482c, this.f1816b);
                }
                C0361e c0361e3 = c0361e2;
            }
            c0361e.m1833a(str, obj);
        }
        return c0361e;
    }

    private HashMap m2050a(C0405u c0405u, C0361e c0361e) {
        if (c0361e == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : c0361e.keySet()) {
            Object obj;
            C0361e j = c0361e.m1844j(str);
            if (j == null) {
                obj = null;
            } else {
                aa aaVar = new aa(c0405u, j.m1838d("id"), (dd) this.f1816b.m1783d(j.m1844j("profile")));
            }
            hashMap.put(str, obj);
        }
        return hashMap;
    }
}
