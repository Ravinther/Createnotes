package com.socialnmobile.colornote.sync;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class ca extends by {
    public static final ca f1599a;

    public final SecretKey m1943a(cq cqVar) {
        return new SecretKeySpec(cqVar.m1970b(), "AES");
    }

    public final String m1942a() {
        return "AES256_CBC_PKCS5";
    }

    static {
        f1599a = new ca();
    }
}
