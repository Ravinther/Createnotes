package com.socialnmobile.colornote;

import com.socialnmobile.colornote.data.C0230t;
import java.util.Comparator;

/* renamed from: com.socialnmobile.colornote.k */
final class C0314k implements Comparator {
    C0314k() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        C0230t c0230t = (C0230t) obj;
        C0230t c0230t2 = (C0230t) obj2;
        if (c0230t.f1011j < c0230t2.f1011j) {
            return -1;
        }
        if (c0230t.f1011j > c0230t2.f1011j) {
            return 1;
        }
        if (c0230t.m1065g() != 0 && c0230t2.m1065g() == 0) {
            return -1;
        }
        if (c0230t.m1065g() != 0 || c0230t2.m1065g() == 0) {
            return C0313j.f1373b.compare(c0230t, c0230t2);
        }
        return 1;
    }
}
