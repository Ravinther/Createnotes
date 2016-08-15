package com.flurry.android.monolithic.sdk.impl;

/* renamed from: com.flurry.android.monolithic.sdk.impl.t */
final class C0136t implements Runnable {
    final /* synthetic */ int f578a;
    final /* synthetic */ String f579b;
    final /* synthetic */ String f580c;
    final /* synthetic */ C0127l f581d;

    C0136t(C0127l c0127l, int i, String str, String str2) {
        this.f581d = c0127l;
        this.f578a = i;
        this.f579b = str;
        this.f580c = str2;
    }

    public final void run() {
        if (this.f578a == 200) {
            ad adVar = C0121f.m598a().f525a;
            if (adVar != null) {
                adVar.f404c = true;
            }
        }
        Thread.currentThread().setName("DataSender Main Single Thread , id = " + Thread.currentThread().getId());
        if (!this.f581d.f556e.m643a(this.f579b, this.f580c)) {
            C0127l.f552a;
            bh.m584a(6, "Internal error. Block wasn't deleted with id = " + this.f579b);
        }
        if (!this.f581d.f557f.remove(this.f579b)) {
            C0127l.f552a;
            bh.m584a(6, "Internal error. Block with id = " + this.f579b + " was not in progress state");
        }
    }
}
