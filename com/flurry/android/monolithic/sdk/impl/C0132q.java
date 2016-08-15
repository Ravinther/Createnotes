package com.flurry.android.monolithic.sdk.impl;

/* renamed from: com.flurry.android.monolithic.sdk.impl.q */
final class C0132q implements Runnable {
    final /* synthetic */ byte[] f571a;
    final /* synthetic */ String f572b;
    final /* synthetic */ String f573c;
    final /* synthetic */ C0127l f574d;

    C0132q(C0127l c0127l, byte[] bArr, String str, String str2) {
        this.f574d = c0127l;
        this.f571a = bArr;
        this.f572b = str;
        this.f573c = str2;
    }

    public final void run() {
        Thread.currentThread().setName("DataSender Main Single Thread , id = " + Thread.currentThread().getId());
        try {
            C0127l c0127l = this.f574d;
            byte[] bArr = this.f571a;
            String str = this.f572b;
            str = "Data_" + str + "_" + this.f573c;
            C0140x c0140x = new C0140x();
            c0140x.m632a(bArr);
            String str2 = c0140x.f591b;
            c0127l.f556e.m642a(c0140x, str);
        } catch (Throwable e) {
            C0127l.f552a;
            bh.m590b("storeData error", e);
        }
    }
}
