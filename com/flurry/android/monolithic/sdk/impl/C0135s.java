package com.flurry.android.monolithic.sdk.impl;

import android.widget.Toast;

/* renamed from: com.flurry.android.monolithic.sdk.impl.s */
final class C0135s implements Runnable {
    final /* synthetic */ int f576a;
    final /* synthetic */ C0134r f577b;

    C0135s(C0134r c0134r, int i) {
        this.f577b = c0134r;
        this.f576a = i;
    }

    public final void run() {
        Toast.makeText(am.f442a.f443b, "SD HTTP Response Code: " + this.f576a, 0).show();
    }
}
