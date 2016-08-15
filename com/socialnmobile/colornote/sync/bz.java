package com.socialnmobile.colornote.sync;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class bz extends by {
    public static final bz f1589a;

    public final SecretKey m1930a(cq cqVar) {
        return new SecretKeySpec(cqVar.m1969a(), "AES");
    }

    public final String m1929a() {
        return "AES128_CBC_PKCS5";
    }

    static {
        f1589a = new bz();
    }
}
