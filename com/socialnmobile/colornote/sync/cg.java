package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;

public class cg extends dc {
    public static final cg f1617a;
    public static final cg f1618b;
    public static final cg f1619c;
    public static final cg f1620d;

    static {
        f1617a = new cg("access_token", "expires_in", null);
        f1618b = new cg("access_token", "expires_in", "expires_at");
        f1619c = new cg("accessToken", "expiresIn", null);
        f1620d = new ch();
    }

    public cg(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public final /* synthetic */ db m1952a(String str, int i, bg bgVar, C0361e c0361e) {
        return new cf(str, i, bgVar);
    }
}
