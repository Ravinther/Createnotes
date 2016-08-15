package com.socialnmobile.util.p011b.p021a;

import android.database.Cursor;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.C0452c;

/* renamed from: com.socialnmobile.util.b.a.h */
final class C0459h extends C0452c {
    final /* synthetic */ Cursor f2244d;
    final /* synthetic */ C0458g f2245e;

    C0459h(C0458g c0458g, Cursor cursor, C0449a c0449a, Cursor cursor2) {
        this.f2245e = c0458g;
        this.f2244d = cursor2;
        super(cursor, c0449a);
    }

    public final /* synthetic */ Object m2280a(int i) {
        return this.f2244d.getString(i);
    }
}
