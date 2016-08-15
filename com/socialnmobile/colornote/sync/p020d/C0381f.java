package com.socialnmobile.colornote.sync.p020d;

import com.socialnmobile.colornote.sync.C0401q;
import com.socialnmobile.colornote.sync.C0403s;
import com.socialnmobile.colornote.sync.ay;
import com.socialnmobile.colornote.sync.bm;
import com.socialnmobile.colornote.sync.bo;
import com.socialnmobile.colornote.sync.p018b.C0360d;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

/* renamed from: com.socialnmobile.colornote.sync.d.f */
public final class C0381f extends C0354c {
    public static final C0381f f1720a;
    final C0403s f1721b;
    final bo f1722c;

    public C0381f() {
        this.f1721b = new C0403s();
        this.f1722c = new bo();
    }

    public final /* synthetic */ Object m1985a(Object obj) {
        ay ayVar;
        C0361e c0361e = (C0361e) obj;
        long longValue = c0361e.m1837c("BASE").longValue();
        long longValue2 = c0361e.m1837c("HEAD").longValue();
        C0361e j = c0361e.m1844j("checkin");
        C0360d i = c0361e.m1843i("checkout");
        C0401q c0401q = (C0401q) c0361e.m1836b("account", this.f1721b);
        bm bmVar = (bm) c0361e.m1836b("device", this.f1722c);
        C0361e j2 = c0361e.m1844j("client_releases");
        if (j2 == null) {
            ayVar = null;
        } else {
            ayVar = new ay(j2);
        }
        return new C0380e(longValue, longValue2, j, i, c0401q, bmVar, c0361e.m1844j("prefs"), c0361e.m1843i("commands"), ayVar);
    }

    static {
        f1720a = new C0381f();
    }

    public final /* synthetic */ void m1986a(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }
}
