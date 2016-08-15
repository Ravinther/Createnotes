package com.socialnmobile.util.p014a;

import java.util.concurrent.Callable;

/* renamed from: com.socialnmobile.util.a.g */
public final class C0438g implements Callable {
    final /* synthetic */ C0390a f2216a;
    final /* synthetic */ Callable f2217b;

    public C0438g(C0390a c0390a, Callable callable) {
        this.f2216a = c0390a;
        this.f2217b = callable;
    }

    public final Object call() {
        this.f2216a.m2027a();
        try {
            Object call = this.f2217b.call();
            return call;
        } finally {
            this.f2216a.m2028b();
        }
    }
}
