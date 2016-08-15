package android.support.v4.p000a;

import android.os.Process;

/* renamed from: android.support.v4.a.i */
final class C0009i extends C0008o {
    final /* synthetic */ C0002g f36a;

    C0009i(C0002g c0002g) {
        this.f36a = c0002g;
        super();
    }

    public final Object call() {
        this.f36a.f21i.set(true);
        Process.setThreadPriority(10);
        return this.f36a.m21b(this.f36a.m27b());
    }
}
