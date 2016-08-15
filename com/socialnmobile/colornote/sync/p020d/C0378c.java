package com.socialnmobile.colornote.sync.p020d;

import com.socialnmobile.colornote.sync.C0401q;
import com.socialnmobile.colornote.sync.C0403s;
import com.socialnmobile.colornote.sync.bm;
import com.socialnmobile.colornote.sync.bo;
import com.socialnmobile.colornote.sync.cl;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

/* renamed from: com.socialnmobile.colornote.sync.d.c */
public final class C0378c extends C0354c {
    final C0403s f1709a;
    final bo f1710b;

    public C0378c() {
        this.f1709a = new C0403s();
        this.f1710b = new bo();
    }

    public final /* synthetic */ Object m1983a(Object obj) {
        C0361e c0361e = (C0361e) obj;
        C0401q c0401q = (C0401q) c0361e.m1836b("account", this.f1709a);
        if (c0401q.f1804b == null) {
            throw new cl("nek is missing");
        } else if (c0401q.f1809g == null) {
            throw new cl("identities is missing");
        } else {
            bm bmVar = (bm) c0361e.m1836b("device", this.f1710b);
            if (bmVar.f1570e != null) {
                return new C0377b(c0401q, bmVar, c0361e.m1844j("external_userinfo"));
            }
            throw new cl("device.token is null");
        }
    }

    public final /* bridge */ /* synthetic */ void m1984a(Object obj, Object obj2) {
        C0377b c0377b = (C0377b) obj;
        C0361e c0361e = (C0361e) obj2;
        c0361e.m1834a("account", c0377b.f1706a, this.f1709a);
        c0361e.m1834a("device", c0377b.f1707b, this.f1710b);
        c0361e.m1833a("external_userinfo", c0377b.f1708c);
    }
}
