package com.flurry.android.monolithic.sdk.impl;

import java.util.TimerTask;

final class ak extends TimerTask {
    final /* synthetic */ aj f440a;
    private al f441b;

    ak(aj ajVar, al alVar) {
        this.f440a = ajVar;
        this.f441b = alVar;
    }

    public final void run() {
        this.f440a.m548a();
        if (this.f441b != null) {
            this.f441b.m519b();
        }
    }
}
