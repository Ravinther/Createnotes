package com.socialnmobile.util.p014a;

/* renamed from: com.socialnmobile.util.a.f */
final class C0437f implements Runnable {
    final /* synthetic */ C0390a f2214a;
    final /* synthetic */ Runnable f2215b;

    C0437f(C0390a c0390a, Runnable runnable) {
        this.f2214a = c0390a;
        this.f2215b = runnable;
    }

    public final void run() {
        this.f2214a.m2027a();
        try {
            this.f2215b.run();
        } finally {
            this.f2214a.m2028b();
        }
    }
}
