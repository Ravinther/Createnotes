package com.socialnmobile.util.p011b;

import android.database.Cursor;

/* renamed from: com.socialnmobile.util.b.c */
public abstract class C0452c extends C0451h {
    public final C0449a f2235a;
    final Cursor f2236b;
    final int f2237c;

    public abstract Object m2260a(int i);

    public C0452c(Cursor cursor, C0449a c0449a) {
        this.f2235a = c0449a;
        this.f2236b = cursor;
        this.f2237c = cursor.getColumnIndex(c0449a.f2234a);
    }

    public final Object m2261c() {
        if (this.f2237c >= 0) {
            return m2260a(this.f2237c);
        }
        throw new C0469f("Column " + this.f2235a.f2234a + " not exists");
    }
}
