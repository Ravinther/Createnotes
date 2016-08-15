package com.flurry.android.monolithic.sdk.impl;

/* renamed from: com.flurry.android.monolithic.sdk.impl.p */
final class C0131p implements Runnable {
    final /* synthetic */ C0138v f569a;
    final /* synthetic */ C0127l f570b;

    C0131p(C0127l c0127l) {
        this.f570b = c0127l;
        this.f569a = null;
    }

    public final void run() {
        Thread.currentThread().setName("DataSender Main Single Thread , id = " + Thread.currentThread().getId());
        try {
            C0127l.m615a(this.f570b);
        } catch (Throwable e) {
            C0127l.f552a;
            bh.m590b("retransmitNotSentBlocks error", e);
        }
    }
}
