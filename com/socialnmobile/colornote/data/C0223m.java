package com.socialnmobile.colornote.data;

import android.content.Context;

/* renamed from: com.socialnmobile.colornote.data.m */
public final class C0223m {
    private static C0223m f984b;
    public C0224n f985a;
    private Context f986c;

    public static C0223m m1021a(Context context) {
        if (f984b == null) {
            C0223m c0223m = new C0223m();
            f984b = c0223m;
            Context applicationContext = context.getApplicationContext();
            c0223m.f986c = applicationContext;
            c0223m.f985a = new C0224n(applicationContext);
        }
        return f984b;
    }
}
