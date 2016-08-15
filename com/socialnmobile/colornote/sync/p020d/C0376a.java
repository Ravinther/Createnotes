package com.socialnmobile.colornote.sync.p020d;

import com.socialnmobile.colornote.sync.C0405u;
import com.socialnmobile.colornote.sync.ab;
import com.socialnmobile.colornote.sync.af;
import com.socialnmobile.colornote.sync.ah;
import com.socialnmobile.colornote.sync.aj;
import com.socialnmobile.colornote.sync.bd;
import com.socialnmobile.colornote.sync.cq;
import com.socialnmobile.colornote.sync.cr;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p019c.C0373f;

/* renamed from: com.socialnmobile.colornote.sync.d.a */
public final class C0376a extends C0373f {
    public final ab f1700b;
    public final C0405u f1701c;
    public final bd f1702d;
    public final C0361e f1703e;
    public final cq f1704f;
    public final long f1705g;

    public C0376a(aj ajVar, C0405u c0405u, bd bdVar, C0361e c0361e, cq cqVar) {
        C0361e a = C0376a.m1982a(c0405u, bdVar, c0361e);
        a.m1834a("nek", cqVar, cr.f1642a);
        super("signup", a);
        this.f1700b = ajVar;
        this.f1701c = c0405u;
        this.f1702d = bdVar;
        this.f1703e = c0361e;
        this.f1704f = cqVar;
        this.f1705g = 0;
    }

    public C0376a(af afVar, C0405u c0405u, bd bdVar, C0361e c0361e) {
        super("login", C0376a.m1982a(c0405u, bdVar, c0361e));
        this.f1700b = afVar;
        this.f1701c = c0405u;
        this.f1702d = bdVar;
        this.f1703e = c0361e;
        this.f1704f = null;
        this.f1705g = 0;
    }

    public C0376a(ah ahVar, C0405u c0405u, bd bdVar, C0361e c0361e, long j) {
        C0361e a = C0376a.m1982a(c0405u, bdVar, c0361e);
        a.m1833a("account", Long.valueOf(j));
        super("login", a);
        this.f1700b = ahVar;
        this.f1701c = c0405u;
        this.f1702d = bdVar;
        this.f1703e = c0361e;
        this.f1704f = null;
        this.f1705g = j;
    }

    private static C0361e m1982a(C0405u c0405u, bd bdVar, C0361e c0361e) {
        C0361e c0361e2 = new C0361e();
        c0361e2.m1833a("authority", c0405u.f1822e);
        c0361e2.m1834a("credentials", bdVar, c0405u.f1823f);
        c0361e2.m1833a("device", (Object) c0361e);
        return c0361e2;
    }
}
