package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;
import com.socialnmobile.util.p011b.p017b.C0462e;

public final class ap extends C0354c {
    public static void m1797a(ao aoVar, C0361e c0361e) {
        c0361e.m1833a("id", aoVar.f1494b);
        c0361e.m1834a("expires", aoVar.f1496d, bg.f1556d);
        c0361e.m1834a("secret", aoVar.m1795a(), C0462e.f2255b);
    }

    public static ao m1796a(C0361e c0361e) {
        return new ao(c0361e.m1838d("id"), (bg) c0361e.m1831a("expires", bg.f1556d), (byte[]) c0361e.m1831a("secret", C0462e.f2255b));
    }
}
