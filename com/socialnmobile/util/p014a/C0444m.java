package com.socialnmobile.util.p014a;

import java.util.concurrent.Callable;

/* renamed from: com.socialnmobile.util.a.m */
public final class C0444m implements Runnable {
    final Callable f2225a;
    final C0439h f2226b;

    public C0444m(Callable callable, C0439h c0439h) {
        this.f2225a = callable;
        this.f2226b = c0439h;
    }

    public final void run() {
        try {
            this.f2226b.m2239a(this.f2225a.call());
        } catch (Exception e) {
            this.f2226b.m2238a(e);
        } finally {
            this.f2226b.m2237a();
        }
    }
}
