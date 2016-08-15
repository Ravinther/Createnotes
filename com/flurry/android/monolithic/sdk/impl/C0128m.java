package com.flurry.android.monolithic.sdk.impl;

/* renamed from: com.flurry.android.monolithic.sdk.impl.m */
final class C0128m implements Runnable {
    final /* synthetic */ C0127l f561a;

    C0128m(C0127l c0127l) {
        this.f561a = c0127l;
    }

    public final void run() {
        Thread.currentThread().setName("DataSender Main Single Thread , id = " + Thread.currentThread().getId());
        try {
            this.f561a.f556e = new C0141z();
        } catch (Throwable e) {
            C0127l.f552a;
            bh.m590b("initialization of FlurryDataSenderIndex error", e);
        }
    }
}
