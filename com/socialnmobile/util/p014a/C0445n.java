package com.socialnmobile.util.p014a;

import android.os.Handler;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.socialnmobile.util.a.n */
public final class C0445n extends AbstractExecutorService {
    final ExecutorService f2227a;
    final C0334q f2228b;
    final Handler f2229c;
    int f2230d;

    public C0445n(ExecutorService executorService, C0334q c0334q, Handler handler) {
        this.f2230d = 0;
        this.f2227a = executorService;
        this.f2228b = c0334q;
        this.f2229c = handler;
    }

    private synchronized void m2243a() {
        this.f2230d++;
    }

    public final void execute(Runnable runnable) {
        m2243a();
        this.f2227a.execute(new C0446o(this, runnable));
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f2227a.awaitTermination(j, timeUnit);
    }

    public final boolean isShutdown() {
        return this.f2227a.isShutdown();
    }

    public final boolean isTerminated() {
        return this.f2227a.isTerminated();
    }

    public final void shutdown() {
        this.f2227a.shutdown();
    }

    public final List shutdownNow() {
        return this.f2227a.shutdownNow();
    }
}
