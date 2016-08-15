package com.socialnmobile.colornote.sync;

/* renamed from: com.socialnmobile.colornote.sync.f */
public final class C0384f {
    public C0401q f1775a;
    bm f1776b;

    public C0384f(C0401q c0401q, bm bmVar) {
        if (c0401q == null) {
            throw new IllegalArgumentException("account is null");
        }
        this.f1775a = c0401q;
        if (bmVar == null) {
            throw new IllegalArgumentException("device is null");
        }
        this.f1776b = bmVar;
    }

    public C0384f() {
        this.f1775a = new C0401q(0, null, null, null, null, 0, null);
    }
}
