package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

/* renamed from: com.socialnmobile.colornote.sync.r */
public final class C0402r extends C0354c {
    public static final C0402r f1813a;
    final C0403s f1814b;

    public C0402r() {
        this.f1814b = new C0403s();
    }

    public final /* synthetic */ void m2048a(Object obj, Object obj2) {
        int i;
        C0401q c0401q = (C0401q) obj;
        C0361e c0361e = (C0361e) obj2;
        this.f1814b.m2053a(c0401q, c0361e);
        String str = "hidden";
        if (c0401q.f1812j) {
            i = 1;
        } else {
            i = 0;
        }
        c0361e.m1833a(str, Integer.valueOf(i));
    }

    static {
        f1813a = new C0402r();
    }

    public final C0401q m2046a(C0361e c0361e) {
        C0401q a = this.f1814b.m2051a(c0361e);
        try {
            boolean z;
            if (c0361e.m1837c("hidden").intValue() != 0) {
                z = true;
            } else {
                z = false;
            }
            a.f1812j = z;
        } catch (cl e) {
            a.f1812j = false;
        }
        return a;
    }
}
