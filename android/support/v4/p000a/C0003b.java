package android.support.v4.p000a;

import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;

/* renamed from: android.support.v4.a.b */
final class C0003b extends C0002g implements Runnable {
    Object f22a;
    boolean f23b;
    final /* synthetic */ C0001a f24c;
    private CountDownLatch f25h;

    C0003b(C0001a c0001a) {
        this.f24c = c0001a;
        this.f25h = new CountDownLatch(1);
    }

    protected final void m29a(Object obj) {
        try {
            C0000d c0000d = this.f24c;
            if (c0000d.f8a != this) {
                c0000d.m13a(this, obj);
            } else if (c0000d.f4q) {
                c0000d.m14a(obj);
            } else {
                c0000d.f7t = false;
                c0000d.f11d = SystemClock.uptimeMillis();
                c0000d.f8a = null;
                c0000d.m3b(obj);
            }
            this.f25h.countDown();
        } catch (Throwable th) {
            this.f25h.countDown();
        }
    }

    protected final void m28a() {
        try {
            this.f24c.m13a(this, this.f22a);
        } finally {
            this.f25h.countDown();
        }
    }

    public final void run() {
        this.f23b = false;
        this.f24c.m17c();
    }

    protected final /* synthetic */ Object m30b() {
        this.f22a = this.f24c.m18d();
        return this.f22a;
    }
}
