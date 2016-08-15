package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import android.util.Log;

public final class bh {
    private static int f503a;
    private static boolean f504b;
    private static int f505c;
    private static boolean f506d;

    static {
        f503a = 4000;
        f504b = false;
        f505c = 5;
        f506d = true;
    }

    public static void m583a() {
        f504b = false;
    }

    public static int m587b() {
        return f505c;
    }

    public static void m591c() {
        f505c = 6;
    }

    public static void m585a(String str) {
        m588b(3, str);
    }

    public static void m589b(String str) {
        m588b(6, str);
    }

    public static void m590b(String str, Throwable th) {
        m592c(6, str + '\n' + Log.getStackTraceString(th));
    }

    public static void m584a(int i, String str) {
        m592c(i, str);
    }

    private static void m588b(int i, String str) {
        if (!f504b && f505c <= i) {
            m593d(i, str);
        }
    }

    private static void m592c(int i, String str) {
        if (f506d) {
            m593d(i, str);
        }
    }

    private static void m593d(int i, String str) {
        String str2 = "FlurryAgent";
        if (!f504b && f505c <= i) {
            int length = TextUtils.isEmpty(str) ? 0 : str.length();
            int i2 = 0;
            while (i2 < length) {
                int i3 = f503a > length - i2 ? length : f503a + i2;
                if (Log.println(i, str2, str.substring(i2, i3)) > 0) {
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }

    public static void m586a(String str, Throwable th) {
        m588b(6, str + '\n' + Log.getStackTraceString(th));
    }
}
