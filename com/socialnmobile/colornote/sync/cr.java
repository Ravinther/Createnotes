package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;
import com.socialnmobile.util.p011b.p017b.C0462e;

public final class cr extends C0354c {
    public static final cr f1642a;

    public final /* synthetic */ Object m1971a(Object obj) {
        C0361e c0361e = (C0361e) obj;
        return new cq((byte[]) c0361e.m1831a("key128", C0462e.f2255b), (byte[]) c0361e.m1831a("key256", C0462e.f2255b));
    }

    public final /* synthetic */ void m1972a(Object obj, Object obj2) {
        cq cqVar = (cq) obj;
        C0361e c0361e = (C0361e) obj2;
        c0361e.m1834a("key128", cqVar.m1969a(), C0462e.f2255b);
        c0361e.m1834a("key256", cqVar.m1970b(), C0462e.f2255b);
    }

    static {
        f1642a = new cr();
    }
}
