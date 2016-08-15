package android.support.v4.p000a;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.p002c.C0059n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;

/* renamed from: android.support.v4.a.a */
public abstract class C0001a extends C0000d {
    volatile C0003b f8a;
    volatile C0003b f9b;
    long f10c;
    long f11d;
    Handler f12e;

    public abstract Object m18d();

    public C0001a(Context context) {
        super(context);
        this.f11d = -10000;
    }

    protected final void m12a() {
        super.m0a();
        m16b();
        this.f8a = new C0003b(this);
        m17c();
    }

    public final boolean m16b() {
        boolean z = false;
        if (this.f8a != null) {
            if (this.f9b != null) {
                if (this.f8a.f23b) {
                    this.f8a.f23b = false;
                    this.f12e.removeCallbacks(this.f8a);
                }
                this.f8a = null;
            } else if (this.f8a.f23b) {
                this.f8a.f23b = false;
                this.f12e.removeCallbacks(this.f8a);
                this.f8a = null;
            } else {
                z = this.f8a.f19f.cancel(false);
                if (z) {
                    this.f9b = this.f8a;
                }
                this.f8a = null;
            }
        }
        return z;
    }

    public void m14a(Object obj) {
    }

    final void m17c() {
        if (this.f9b == null && this.f8a != null) {
            if (this.f8a.f23b) {
                this.f8a.f23b = false;
                this.f12e.removeCallbacks(this.f8a);
            }
            if (this.f10c <= 0 || SystemClock.uptimeMillis() >= this.f11d + this.f10c) {
                C0002g c0002g = this.f8a;
                Executor executor = C0002g.f16d;
                if (c0002g.f20g != C0014n.f41a) {
                    switch (C0011k.f38a[c0002g.f20g - 1]) {
                        case 1:
                            throw new IllegalStateException("Cannot execute task: the task is already running.");
                        case 2:
                            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                    }
                }
                c0002g.f20g = C0014n.f42b;
                c0002g.f18e.f35b = null;
                executor.execute(c0002g.f19f);
                return;
            }
            this.f8a.f23b = true;
            this.f12e.postAtTime(this.f8a, this.f11d + this.f10c);
        }
    }

    final void m13a(C0003b c0003b, Object obj) {
        m14a(obj);
        if (this.f9b == c0003b) {
            if (this.f7t) {
                this.f6s = true;
            }
            this.f11d = SystemClock.uptimeMillis();
            this.f9b = null;
            m17c();
        }
    }

    public void m15a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.m2a(str, fileDescriptor, printWriter, strArr);
        if (this.f8a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f8a);
            printWriter.print(" waiting=");
            printWriter.println(this.f8a.f23b);
        }
        if (this.f9b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f9b);
            printWriter.print(" waiting=");
            printWriter.println(this.f9b.f23b);
        }
        if (this.f10c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            C0059n.formatDuration(this.f10c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            C0059n.formatDuration(this.f11d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
