package com.socialnmobile.colornote.menu;

/* renamed from: com.socialnmobile.colornote.menu.j */
final class C0325j implements Runnable {
    final /* synthetic */ C0318c f1428a;

    private C0325j(C0318c c0318c) {
        this.f1428a = c0318c;
    }

    public final void run() {
        if (this.f1428a.f1398c != null && this.f1428a.f1398c.getCount() > this.f1428a.f1398c.getChildCount() && this.f1428a.f1398c.getChildCount() <= this.f1428a.f1400e) {
            this.f1428a.f1396a.setInputMethodMode(2);
            this.f1428a.m1692a();
        }
    }
}
