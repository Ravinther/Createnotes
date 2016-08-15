package com.socialnmobile.colornote.sync;

import java.security.MessageDigest;

public abstract class bx {
    public abstract bv m1923a(cq cqVar, byte[] bArr);

    public abstract String m1924a();

    public abstract byte[] m1925a(cq cqVar, bv bvVar);

    public static byte[] m1922a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
