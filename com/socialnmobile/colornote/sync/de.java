package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

public final class de extends C0354c {
    public final /* synthetic */ Object m1989a(Object obj) {
        Number number = null;
        C0361e c0361e = (C0361e) obj;
        String h = c0361e.m1842h("etag");
        String h2 = c0361e.m1842h("fullName");
        String h3 = c0361e.m1842h("firstName");
        String h4 = c0361e.m1842h("lastName");
        String h5 = c0361e.m1842h("gender");
        String h6 = c0361e.m1842h("locale");
        C0361e j = c0361e.m1844j("ageRange");
        Number g = j != null ? j.m1841g("min") : null;
        if (j != null) {
            number = j.m1841g("max");
        }
        return new dd(h, h2, h3, h4, h5, h6, g, number, c0361e.m1842h("picture"));
    }

    public final /* synthetic */ void m1990a(Object obj, Object obj2) {
        dd ddVar = (dd) obj;
        C0361e c0361e = (C0361e) obj2;
        c0361e.m1833a("etag", ddVar.f1724a);
        c0361e.m1833a("fullName", ddVar.f1725b);
        c0361e.m1833a("firstName", ddVar.f1726c);
        c0361e.m1833a("lastName", ddVar.f1727d);
        c0361e.m1833a("gender", ddVar.f1728e);
        c0361e.m1833a("locale", ddVar.f1729f);
        Object c0361e2 = new C0361e();
        c0361e2.m1833a("min", ddVar.f1730g);
        c0361e2.m1833a("max", ddVar.f1731h);
        c0361e.m1833a("ageRange", c0361e2);
        c0361e.m1833a("picture", ddVar.f1732i);
    }
}
