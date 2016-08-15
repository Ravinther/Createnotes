package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

public class az {
    private static final String f491a;
    private static String f492b;
    private static String f493c;

    static {
        f491a = az.class.getSimpleName();
    }

    public static void m574a(String str) {
        f492b = str;
    }

    public static String m573a() {
        if (!TextUtils.isEmpty(f492b)) {
            return f492b;
        }
        if (!TextUtils.isEmpty(f493c)) {
            return f493c;
        }
        String b = m575b();
        f493c = b;
        return b;
    }

    private static String m575b() {
        try {
            Context context = am.f442a.f443b;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.versionName != null) {
                return packageInfo.versionName;
            }
            if (packageInfo.versionCode != 0) {
                return Integer.toString(packageInfo.versionCode);
            }
            return "Unknown";
        } catch (Throwable th) {
            bh.m590b("", th);
        }
    }
}
