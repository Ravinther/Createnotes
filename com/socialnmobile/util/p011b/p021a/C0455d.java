package com.socialnmobile.util.p011b.p021a;

import android.database.Cursor;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.C0452c;

/* renamed from: com.socialnmobile.util.b.a.d */
final class C0455d extends C0452c {
    final /* synthetic */ Cursor f2240d;
    final /* synthetic */ C0454c f2241e;

    C0455d(C0454c c0454c, Cursor cursor, C0449a c0449a, Cursor cursor2) {
        this.f2241e = c0454c;
        this.f2240d = cursor2;
        super(cursor, c0449a);
    }

    public final /* synthetic */ Object m2268a(int i) {
        return Integer.valueOf(this.f2240d.getInt(i));
    }
}
