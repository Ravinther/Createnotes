package com.socialnmobile.util.p014a;

import android.os.Handler;

/* renamed from: com.socialnmobile.util.a.b */
public final class C0433b implements C0390a {
    final C0390a f2210a;
    final Handler f2211b;

    public C0433b(C0390a c0390a, Handler handler) {
        this.f2210a = c0390a;
        this.f2211b = handler;
    }

    public final void m2234a() {
        this.f2211b.post(new C0434c(this));
    }

    public final void m2235b() {
        this.f2211b.post(new C0435d(this));
    }
}
