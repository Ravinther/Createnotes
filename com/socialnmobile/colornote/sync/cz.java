package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.p011b.C0364k;
import com.socialnmobile.util.p011b.C0385e;

public final class cz extends C0364k {
    public final C0385e f1692a;
    public final C0385e f1693b;
    public final C0385e f1694c;
    public final C0385e f1695d;
    public final C0385e f1696e;
    public final C0385e f1697f;
    public final C0385e f1698g;
    public final C0385e f1699h;

    public cz() {
        this.f1692a = m1849a(cx.f1680o);
        this.f1693b = m1847a(cx.f1681p, bg.f1557e);
        this.f1694c = m1847a(cx.f1682q, bg.f1557e);
        this.f1695d = m1847a(cx.f1683r, bg.f1557e);
        this.f1696e = m1849a(cx.f1684s);
        this.f1697f = m1849a(cx.f1685t);
        this.f1698g = m1849a(cx.f1687v);
        this.f1699h = m1847a(cx.f1686u, bg.f1557e);
    }

    public final void m1981a() {
        Integer num = (Integer) this.f1692a.m2010c();
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (num.intValue() == 0) {
            this.f1692a.m2008a(Integer.valueOf(0));
            this.f1693b.m2008a(new bg(0));
            this.f1694c.m2008a(new bg(0));
            this.f1695d.m2008a(new bg(0));
            this.f1696e.m2008a(Integer.valueOf(0));
            this.f1697f.m2008a(Integer.valueOf(0));
            this.f1698g.m2008a(Integer.valueOf(0));
            this.f1699h.m2008a(new bg(0));
        }
    }
}
