package com.socialnmobile.colornote.sync;

import javax.crypto.KeyGenerator;

/* renamed from: com.socialnmobile.colornote.sync.a */
public final class C0349a {
    public static byte[] m1761a(int i) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(i);
            return instance.generateKey().getEncoded();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
