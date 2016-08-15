package com.flurry.android.monolithic.sdk.impl;

import java.io.Closeable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class bj {
    private static final String f507a;

    static {
        f507a = bj.class.getSimpleName();
    }

    public static String m595a(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() > 255) {
            return str.substring(0, 255);
        }
        return str;
    }

    public static void m596a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static byte[] m597b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes(), 0, str.length());
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            bh.m584a(6, "Unsupported SHA1: " + e.getMessage());
            return null;
        }
    }
}
