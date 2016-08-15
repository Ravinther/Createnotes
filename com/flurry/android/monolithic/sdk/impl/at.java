package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public final class at {
    private static final String f472a;

    static {
        f472a = at.class.getSimpleName();
    }

    private static PackageInfo m558b(Context context) {
        PackageInfo packageInfo = null;
        if (context != null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 20815);
            } catch (NameNotFoundException e) {
                bh.m585a("Cannot find package info for package: " + context.getPackageName());
            }
        }
        return packageInfo;
    }

    public static String m557a(Context context) {
        PackageInfo b = m558b(context);
        return (b == null || b.packageName == null) ? "" : b.packageName;
    }
}
