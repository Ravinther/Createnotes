package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;

public class cj extends dc {
    public static final cj f1622a;
    public static final cj f1623b;
    public static final cj f1624c;
    public static final cj f1625d;
    final String f1626e;

    static {
        f1622a = new cj("access_token", "expires_in", null, "refresh_token");
        f1623b = new cj("access_token", "expires_in", "expires_at", "refresh_token");
        f1624c = new cj("accesstoken", "expiresin", null, "refreshtoken");
        f1625d = new ck();
    }

    public cj(String str, String str2, String str3, String str4) {
        super(str, str2, str3);
        this.f1626e = str4;
    }

    private void m1955a(ci ciVar, C0361e c0361e) {
        super.m1949a((db) ciVar, c0361e);
        if (ciVar.f1621a != null) {
            c0361e.m1833a(this.f1626e, ciVar.f1621a);
        }
    }

    public String m1959c(C0361e c0361e) {
        return c0361e.m1842h(this.f1626e);
    }

    public final /* synthetic */ db m1956a(String str, int i, bg bgVar, C0361e c0361e) {
        return new ci(str, i, bgVar, m1959c(c0361e));
    }
}
