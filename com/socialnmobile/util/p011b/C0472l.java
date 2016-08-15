package com.socialnmobile.util.p011b;

import android.content.ContentValues;
import android.database.Cursor;

/* renamed from: com.socialnmobile.util.b.l */
public final class C0472l implements C0385e, C0363j {
    final C0448m f2271a;
    C0385e f2272b;

    public C0472l(C0448m c0448m) {
        this.f2271a = c0448m;
    }

    public final Object m2320c() {
        if (this.f2272b != null) {
            return this.f2272b.m2010c();
        }
        throw new IllegalStateException("Field is not bound to any source");
    }

    public final void m2318a(Object obj) {
        if (this.f2272b == null) {
            throw new IllegalStateException();
        }
        this.f2272b.m2008a(obj);
    }

    public final void m2319b() {
        if (this.f2272b == null) {
            throw new IllegalStateException();
        }
        this.f2272b.m2009b();
    }

    public final Object m2322c(Cursor cursor) {
        this.f2272b = this.f2271a.m2245b(cursor);
        return this;
    }

    public final Object m2321c(ContentValues contentValues) {
        this.f2272b = this.f2271a.m2244b(contentValues);
        return this;
    }
}
