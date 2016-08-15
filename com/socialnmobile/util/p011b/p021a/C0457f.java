package com.socialnmobile.util.p011b.p021a;

import android.database.Cursor;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.C0452c;

/* renamed from: com.socialnmobile.util.b.a.f */
final class C0457f extends C0452c {
    final /* synthetic */ Cursor f2242d;
    final /* synthetic */ C0456e f2243e;

    C0457f(C0456e c0456e, Cursor cursor, C0449a c0449a, Cursor cursor2) {
        this.f2243e = c0456e;
        this.f2242d = cursor2;
        super(cursor, c0449a);
    }

    public final /* synthetic */ Object m2274a(int i) {
        return Long.valueOf(this.f2242d.getLong(i));
    }
}
