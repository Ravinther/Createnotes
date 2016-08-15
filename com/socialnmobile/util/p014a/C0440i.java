package com.socialnmobile.util.p014a;

import android.os.Handler;

/* renamed from: com.socialnmobile.util.a.i */
public final class C0440i implements C0439h {
    final Handler f2218a;
    final C0439h f2219b;

    public C0440i(C0439h c0439h, Handler handler) {
        this.f2218a = handler;
        this.f2219b = c0439h;
    }

    public final void m2242a(Object obj) {
        this.f2218a.post(new C0441j(this, obj));
    }

    public final void m2241a(Exception exception) {
        this.f2218a.post(new C0442k(this, exception));
    }

    public final void m2240a() {
        this.f2218a.post(new C0443l(this));
    }
}
