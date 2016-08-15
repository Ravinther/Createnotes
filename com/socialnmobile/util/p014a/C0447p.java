package com.socialnmobile.util.p014a;

/* renamed from: com.socialnmobile.util.a.p */
final class C0447p implements Runnable {
    final /* synthetic */ C0446o f2233a;

    C0447p(C0446o c0446o) {
        this.f2233a = c0446o;
    }

    public final void run() {
        C0445n c0445n = this.f2233a.f2232b;
        synchronized (c0445n) {
            int i = c0445n.f2230d - 1;
            c0445n.f2230d = i;
        }
        if (i == 0) {
            c0445n.f2228b.m1738c();
        }
    }
}
