package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public final class am {
    static am f442a;
    final Context f443b;
    final Handler f444c;

    public static synchronized void m551a(Context context) {
        synchronized (am.class) {
            if (f442a == null) {
                if (context == null) {
                    throw new IllegalArgumentException("Context cannot be null");
                }
                f442a = new am(context);
            }
        }
    }

    private am(Context context) {
        this.f443b = context.getApplicationContext();
        this.f444c = new Handler(Looper.getMainLooper());
    }
}
