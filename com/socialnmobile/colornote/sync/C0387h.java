package com.socialnmobile.colornote.sync;

import android.content.Context;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.C0385e;
import com.socialnmobile.util.p011b.C0471i;
import com.socialnmobile.util.p011b.p016c.C0353a;
import java.util.HashMap;

/* renamed from: com.socialnmobile.colornote.sync.h */
public final class C0387h extends C0353a {
    final Context f1780a;

    public C0387h(Context context) {
        this.f1780a = context;
    }

    private C0384f m2018a(C0366d c0366d) {
        C0385e c0385e = c0366d.f1527l;
        C0385e c0471i = new C0471i(c0366d.f1536u, cg.f1620d);
        if (((Long) c0366d.f1528m.m2010c()) == null) {
            throw new cl("id is null");
        }
        as asVar;
        as asVar2;
        cq a = new C0400p(c0366d.m1860h(), this.f1780a).m2045a();
        C0409z c0409z = new C0409z();
        HashMap hashMap = c0409z.f1825a;
        HashMap hashMap2 = c0409z.f1828d;
        HashMap hashMap3 = c0409z.f1827c;
        cf cfVar = (cf) c0471i.m2010c();
        String str = (String) c0385e.m2010c();
        String str2 = (String) c0366d.f1533r.m2010c();
        String str3 = (String) c0366d.f1534s.m2010c();
        if (cfVar != null) {
            HashMap hashMap4 = hashMap3;
            hashMap4.put("", new aa(C0405u.f1819b, "", new dd(null, str, null, null, null, null, null, null, null)));
            asVar = new as(C0405u.f1819b, "", cfVar);
        } else {
            asVar = null;
        }
        if (str2 != null) {
            hashMap.put(str2, new aa(C0405u.f1818a, str2));
        }
        if (asVar == null) {
            C0405u c0405u = C0405u.f1818a;
            bd bsVar = new bs(str2, null);
            if (str2 == null) {
                C0311h.f1370a.m1622a("AccountExtraInfoField v1 email", "email is null", (C0361e) C0383e.f1774a.m1782c(c0366d));
            }
            asVar2 = new as(c0405u, str2, bsVar);
        } else {
            asVar2 = asVar;
        }
        if (str3 != null) {
            hashMap2.put(str3, new aa(C0405u.f1821d, str3));
        }
        Long l = (Long) c0366d.f1528m.m2010c();
        return new C0384f(new C0401q(l.longValue(), a, new bg(0), new bg(0), (bg) c0366d.f1530o.m2010c(), 0, c0409z), new bm(asVar2));
    }

    public final /* synthetic */ Object m2019a() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void m2021a(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }
}
