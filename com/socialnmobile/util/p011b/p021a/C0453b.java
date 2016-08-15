package com.socialnmobile.util.p011b.p021a;

import android.database.Cursor;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.C0452c;

/* renamed from: com.socialnmobile.util.b.a.b */
final class C0453b extends C0452c {
    final /* synthetic */ Cursor f2238d;
    final /* synthetic */ C0450a f2239e;

    C0453b(C0450a c0450a, Cursor cursor, C0449a c0449a, Cursor cursor2) {
        this.f2239e = c0450a;
        this.f2238d = cursor2;
        super(cursor, c0449a);
    }

    public final /* synthetic */ Object m2262a(int i) {
        return Double.valueOf(this.f2238d.getDouble(i));
    }
}
