package com.flurry.android.monolithic.sdk.impl;

import java.lang.Thread.UncaughtExceptionHandler;

final class bb implements UncaughtExceptionHandler {
    final /* synthetic */ ba f497a;

    private bb(ba baVar) {
        this.f497a = baVar;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        for (UncaughtExceptionHandler uncaughtException : this.f497a.m577b()) {
            try {
                uncaughtException.uncaughtException(thread, th);
            } catch (Throwable th2) {
            }
        }
        ba baVar = this.f497a;
        if (baVar.f495a != null) {
            baVar.f495a.uncaughtException(thread, th);
        }
    }
}
