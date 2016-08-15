package android.support.v4.p000a;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: android.support.v4.a.g */
abstract class C0002g {
    private static final ThreadFactory f13a;
    private static final BlockingQueue f14b;
    private static final C0013m f15c;
    public static final Executor f16d;
    private static volatile Executor f17h;
    final C0008o f18e;
    final FutureTask f19f;
    volatile int f20g;
    private final AtomicBoolean f21i;

    protected abstract Object m27b();

    static {
        f13a = new C0007h();
        f14b = new LinkedBlockingQueue(10);
        f16d = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f14b, f13a);
        f15c = new C0013m();
        f17h = f16d;
    }

    public C0002g() {
        this.f20g = C0014n.f41a;
        this.f21i = new AtomicBoolean();
        this.f18e = new C0009i(this);
        this.f19f = new C0010j(this, this.f18e);
    }

    private Object m21b(Object obj) {
        f15c.obtainMessage(1, new C0012l(this, obj)).sendToTarget();
        return obj;
    }

    protected void m26a(Object obj) {
    }

    protected static void m23c() {
    }

    protected void m25a() {
    }

    static /* synthetic */ void m22b(C0002g c0002g, Object obj) {
        if (!c0002g.f21i.get()) {
            c0002g.m21b(obj);
        }
    }

    static /* synthetic */ void m24c(C0002g c0002g, Object obj) {
        if (c0002g.f19f.isCancelled()) {
            c0002g.m25a();
        } else {
            c0002g.m26a(obj);
        }
        c0002g.f20g = C0014n.f43c;
    }
}
