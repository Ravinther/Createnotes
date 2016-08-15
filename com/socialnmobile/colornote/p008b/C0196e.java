package com.socialnmobile.colornote.p008b;

/* renamed from: com.socialnmobile.colornote.b.e */
final class C0196e implements Runnable {
    final /* synthetic */ String f870a;
    final /* synthetic */ String f871b;
    final /* synthetic */ String f872c;
    final /* synthetic */ Object f873d;
    final /* synthetic */ String f874e;
    final /* synthetic */ boolean f875f;
    final /* synthetic */ C0191a f876g;

    C0196e(C0191a c0191a, String str, String str2, String str3, Object obj, String str4) {
        this.f876g = c0191a;
        this.f870a = str;
        this.f871b = str2;
        this.f872c = str3;
        this.f873d = obj;
        this.f874e = str4;
        this.f875f = true;
    }

    public final void run() {
        try {
            this.f876g.m857a(this.f876g.m852a(this.f870a, this.f871b, this.f872c, this.f873d, this.f874e, this.f875f));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
