package com.socialnmobile.colornote;

import com.socialnmobile.colornote.data.C0230t;
import java.util.Comparator;

/* renamed from: com.socialnmobile.colornote.l */
final class C0315l implements Comparator {
    C0315l() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        C0230t c0230t = (C0230t) obj;
        C0230t c0230t2 = (C0230t) obj2;
        if (c0230t.m1065g() < c0230t2.m1065g()) {
            return -1;
        }
        if (c0230t.m1065g() > c0230t2.m1065g()) {
            return 1;
        }
        if (c0230t.f1015n > c0230t2.f1015n) {
            return -1;
        }
        if (c0230t.f1015n < c0230t2.f1015n) {
            return 1;
        }
        return 0;
    }
}
