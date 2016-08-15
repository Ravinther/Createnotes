package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.p011b.p016c.C0354c;

/* renamed from: com.socialnmobile.colornote.sync.u */
public abstract class C0405u {
    public static final C0406v f1818a;
    public static final C0407w f1819b;
    public static final C0408x f1820c;
    public static final C0405u f1821d;
    public final String f1822e;
    public final be f1823f;
    public final be f1824g;

    static {
        f1818a = new C0406v();
        f1819b = new C0407w();
        f1820c = new C0408x();
        f1821d = null;
    }

    public static C0405u m2057a(String str) {
        C0405u[] c0405uArr = new C0405u[]{f1818a, f1819b, f1820c};
        for (int i = 0; i < 3; i++) {
            C0405u c0405u = c0405uArr[i];
            if (c0405u.f1822e.equals(str)) {
                return c0405u;
            }
        }
        return null;
    }

    public C0405u(String str, C0354c c0354c, C0354c c0354c2) {
        this.f1822e = str;
        this.f1823f = new be(c0354c);
        this.f1824g = new be(c0354c2);
    }

    public static String m2058a(C0366d c0366d) {
        return c0366d.m1857e();
    }

    public bd m2059a(C0366d c0366d, bd bdVar) {
        return bdVar;
    }
}
