package com.flurry.android.monolithic.sdk.impl;

import java.util.Timer;

public final class aj {
    private Timer f437a;
    private ak f438b;
    private al f439c;

    aj(al alVar) {
        this.f439c = alVar;
    }

    public final synchronized void m549a(long j) {
        if (m550b()) {
            m548a();
        }
        this.f437a = new Timer("FlurrySessionTimer");
        this.f438b = new ak(this, this.f439c);
        this.f437a.schedule(this.f438b, j);
    }

    public final synchronized void m548a() {
        if (this.f437a != null) {
            this.f437a.cancel();
            this.f437a = null;
        }
        this.f438b = null;
    }

    public final boolean m550b() {
        if (this.f437a != null) {
            return true;
        }
        return false;
    }
}
