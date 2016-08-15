package com.socialnmobile.colornote.data;

import java.util.Comparator;

/* renamed from: com.socialnmobile.colornote.data.f */
final class C0216f implements Comparator {
    final /* synthetic */ C0214d f953a;

    C0216f(C0214d c0214d) {
        this.f953a = c0214d;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        C0218h c0218h = (C0218h) obj;
        C0218h c0218h2 = (C0218h) obj2;
        if (c0218h.f957c - c0218h2.f957c < 0) {
            return 1;
        }
        if (c0218h.f957c - c0218h2.f957c == 0) {
            return 0;
        }
        return -1;
    }
}
