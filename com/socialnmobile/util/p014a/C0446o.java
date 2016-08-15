package com.socialnmobile.util.p014a;

/* renamed from: com.socialnmobile.util.a.o */
final class C0446o implements Runnable {
    final /* synthetic */ Runnable f2231a;
    final /* synthetic */ C0445n f2232b;

    C0446o(C0445n c0445n, Runnable runnable) {
        this.f2232b = c0445n;
        this.f2231a = runnable;
    }

    public final void run() {
        try {
            this.f2231a.run();
        } finally {
            this.f2232b.f2229c.post(new C0447p(this));
        }
    }
}
