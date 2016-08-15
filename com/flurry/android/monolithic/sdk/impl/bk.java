package com.flurry.android.monolithic.sdk.impl;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class bk implements Runnable {
    private static final String f426a;
    PrintStream f427c;
    PrintWriter f428d;

    public abstract void m539a();

    static {
        f426a = bk.class.getSimpleName();
    }

    public final void run() {
        try {
            m539a();
        } catch (Throwable th) {
            if (this.f427c != null) {
                th.printStackTrace(this.f427c);
            } else if (this.f428d != null) {
                th.printStackTrace(this.f428d);
            } else {
                th.printStackTrace();
            }
            bh.m590b("", th);
        }
    }
}
