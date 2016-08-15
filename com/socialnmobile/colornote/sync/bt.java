package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

public class bt extends C0354c {
    public static final bt f1582a;
    public static final bt f1583b;

    public final /* synthetic */ Object m1912a(Object obj) {
        C0361e c0361e = (C0361e) obj;
        return m1911a(c0361e.m1838d(AccountColumns.EMAIL), c0361e.m1842h("password"));
    }

    static {
        f1582a = new bt();
        f1583b = new bu();
    }

    public void m1913a(bs bsVar, C0361e c0361e) {
        c0361e.m1833a(AccountColumns.EMAIL, bsVar.f1580a);
        c0361e.m1833a("password", bsVar.f1581b);
    }

    public bs m1911a(String str, String str2) {
        return new bs(str, str2);
    }
}
