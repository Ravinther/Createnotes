package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

public final class at extends C0354c {
    public final /* synthetic */ Object m1807a(Object obj) {
        C0361e c0361e = (C0361e) obj;
        String d = c0361e.m1838d("authority");
        C0405u a = C0405u.m2057a(d);
        if (a != null) {
            return new as(a, c0361e.m1838d("id"), (bd) c0361e.m1832a("credentials", a.f1823f));
        }
        throw new cl("unrecognized authority: " + d);
    }

    public final /* bridge */ /* synthetic */ void m1808a(Object obj, Object obj2) {
        as asVar = (as) obj;
        C0361e c0361e = (C0361e) obj2;
        c0361e.m1833a("authority", asVar.f1498a.f1822e);
        c0361e.m1833a("id", asVar.f1499b);
        c0361e.m1834a("credentials", asVar.f1500c, asVar.f1498a.f1823f);
    }
}
