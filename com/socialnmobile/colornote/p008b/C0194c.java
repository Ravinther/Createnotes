package com.socialnmobile.colornote.p008b;

import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.socialnmobile.colornote.b.c */
public final class C0194c implements UncaughtExceptionHandler {
    final /* synthetic */ UncaughtExceptionHandler f866a;
    final /* synthetic */ C0191a f867b;

    public C0194c(C0191a c0191a, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f867b = c0191a;
        this.f866a = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        this.f867b.m856a(th);
        if (this.f866a != null) {
            this.f866a.uncaughtException(thread, th);
        }
    }
}
