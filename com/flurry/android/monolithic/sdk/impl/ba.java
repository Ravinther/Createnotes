package com.flurry.android.monolithic.sdk.impl;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class ba {
    private static ba f494c;
    final UncaughtExceptionHandler f495a;
    final Map f496b;

    public static synchronized ba m576a() {
        ba baVar;
        synchronized (ba.class) {
            if (f494c == null) {
                f494c = new ba();
            }
            baVar = f494c;
        }
        return baVar;
    }

    final Set m577b() {
        Set keySet;
        synchronized (this.f496b) {
            keySet = this.f496b.keySet();
        }
        return keySet;
    }

    private ba() {
        this.f496b = new WeakHashMap();
        this.f495a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new bb());
    }
}
