package com.socialnmobile.colornote.data;

import java.util.Set;
import java.util.concurrent.Callable;

final class ac implements Callable {
    final /* synthetic */ int f930a;
    final /* synthetic */ Set f931b;
    final /* synthetic */ aa f932c;

    ac(aa aaVar, int i, Set set) {
        this.f932c = aaVar;
        this.f930a = i;
        this.f931b = set;
    }

    public final /* synthetic */ Object call() {
        return Integer.valueOf(this.f932c.m914b(this.f930a, this.f931b));
    }
}
