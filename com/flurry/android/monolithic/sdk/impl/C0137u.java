package com.flurry.android.monolithic.sdk.impl;

/* renamed from: com.flurry.android.monolithic.sdk.impl.u */
final class C0137u implements Runnable {
    final /* synthetic */ String f582a;
    final /* synthetic */ C0127l f583b;

    C0137u(C0127l c0127l, String str) {
        this.f583b = c0127l;
        this.f582a = str;
    }

    public final void run() {
        Thread.currentThread().setName("DataSender Main Single Thread , id = " + Thread.currentThread().getId());
        if (!this.f583b.f557f.remove(this.f582a)) {
            C0127l.f552a;
            bh.m584a(6, "Internal error. Block with id = " + this.f582a + " was not in progress state");
        }
    }
}
