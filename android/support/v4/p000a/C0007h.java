package android.support.v4.p000a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: android.support.v4.a.h */
final class C0007h implements ThreadFactory {
    private final AtomicInteger f34a;

    C0007h() {
        this.f34a = new AtomicInteger(1);
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "ModernAsyncTask #" + this.f34a.getAndIncrement());
    }
}
