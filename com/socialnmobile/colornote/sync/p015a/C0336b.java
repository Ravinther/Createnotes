package com.socialnmobile.colornote.sync.p015a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;

/* renamed from: com.socialnmobile.colornote.sync.a.b */
public final class C0336b {
    public static final String f1463a;
    public static final String f1464b;
    public static final String f1465c;
    public static final String f1466d;
    public static final String f1467e;
    public static final String f1468f;

    static {
        f1463a = "Android/" + VERSION.RELEASE;
        f1464b = "Android-api/" + VERSION.SDK_INT;
        f1465c = "Brand/" + Build.BRAND;
        f1466d = "Model/" + Build.MODEL;
        f1467e = "Manufacturer/" + Build.MANUFACTURER;
        f1468f = VERSION.CODENAME + "/" + VERSION.INCREMENTAL;
    }

    public static String m1750a(String str) {
        return ("ColorNote/" + str) + " " + f1464b + " " + f1463a + " " + f1468f + " " + f1465c + " " + f1466d + " " + f1467e;
    }

    public static String m1749a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName + "-" + packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return "UNKNOWN";
        }
    }
}
