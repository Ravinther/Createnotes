package com.flurry.android.monolithic.sdk.impl;

/* renamed from: com.flurry.android.monolithic.sdk.impl.r */
final class C0134r implements C0133y {
    final /* synthetic */ C0127l f575a;

    C0134r(C0127l c0127l) {
        this.f575a = c0127l;
    }

    public final void m629a(int i, String str, String str2, String str3) {
        C0127l.f552a;
        bh.m584a(5, "--onReport " + str2 + " sent. HTTP response: " + i + " : " + str);
        if (bh.m587b() <= 3) {
            am amVar = am.f442a;
            amVar.f444c.post(new C0135s(this, i));
        }
        this.f575a.f558g.submit(new C0136t(this.f575a, i, str2, str3));
        this.f575a.m623a();
    }

    public final void m630a(String str) {
        C0127l.f552a;
        bh.m584a(5, "--onServerError " + str);
        this.f575a.f558g.submit(new C0137u(this.f575a, str));
    }
}
