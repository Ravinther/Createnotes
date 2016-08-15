package com.socialnmobile.colornote.fragment;

final class at implements Runnable {
    final /* synthetic */ int f1233a;
    final /* synthetic */ as f1234b;

    at(as asVar, int i) {
        this.f1234b = asVar;
        this.f1233a = i;
    }

    public final void run() {
        this.f1234b.f1232a.ap.remove(this.f1233a - 1);
        this.f1234b.f1232a.ab();
        this.f1234b.f1232a.aE.invalidateViews();
    }
}
