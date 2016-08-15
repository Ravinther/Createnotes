package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.p011b.C0364k;
import com.socialnmobile.util.p011b.C0385e;
import com.socialnmobile.util.p011b.C0469f;

public class cm extends C0364k {
    public final di f1627a;
    public final cw f1628b;
    public final ct f1629c;

    public cm() {
        this.f1627a = (di) m1848a(new di());
        this.f1628b = (cw) m1848a(new cw());
        this.f1629c = (ct) m1848a(new ct());
    }

    public final void m1965a(boolean z) {
        m1964a(z, this.f1628b.f1660f, Integer.valueOf(0));
        m1964a(z, this.f1628b.f1661g, Integer.valueOf(0));
        m1964a(z, this.f1628b.f1657c, Integer.valueOf(0));
        m1964a(z, this.f1628b.f1664j, Integer.valueOf(0));
        m1964a(z, this.f1628b.f1662h, new bg(0));
        m1964a(z, this.f1629c.f1647d, new bg(0));
        m1964a(z, this.f1629c.f1644a, "");
        m1964a(z, this.f1629c.f1645b, "");
    }

    private static void m1964a(boolean z, C0385e c0385e, Object obj) {
        if (m1963a(c0385e) != null) {
            return;
        }
        if (z) {
            c0385e.m2008a(obj);
        } else {
            c0385e.m2009b();
        }
    }

    private static Object m1963a(C0385e c0385e) {
        try {
            return c0385e.m2010c();
        } catch (C0469f e) {
            return null;
        }
    }
}
