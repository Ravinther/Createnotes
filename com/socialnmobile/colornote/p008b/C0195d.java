package com.socialnmobile.colornote.p008b;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.socialnmobile.colornote.b.d */
final class C0195d implements ThreadFactory {
    final ThreadFactory f868a;
    final /* synthetic */ C0191a f869b;

    C0195d(C0191a c0191a) {
        this.f869b = c0191a;
        this.f868a = Executors.defaultThreadFactory();
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f868a.newThread(runnable);
        newThread.setPriority(1);
        return newThread;
    }
}
