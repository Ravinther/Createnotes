package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0220j;

final class ar implements Runnable {
    final /* synthetic */ int f1229a;
    final /* synthetic */ int f1230b;
    final /* synthetic */ aq f1231c;

    ar(aq aqVar, int i, int i2) {
        this.f1231c = aqVar;
        this.f1229a = i;
        this.f1230b = i2;
    }

    public final void run() {
        if (this.f1229a - 1 < this.f1231c.f1228a.ap.size()) {
            this.f1231c.f1228a.ap.add(this.f1230b - 1, (C0220j) this.f1231c.f1228a.ap.remove(this.f1229a - 1));
        }
        this.f1231c.f1228a.ab();
        this.f1231c.f1228a.aE.invalidateViews();
    }
}
