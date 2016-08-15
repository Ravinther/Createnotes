package com.socialnmobile.util.p011b.p021a;

import android.content.ContentValues;
import android.database.Cursor;
import com.socialnmobile.util.p011b.C0385e;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.C0452c;

/* renamed from: com.socialnmobile.util.b.a.c */
public final class C0454c extends C0449a {
    public final /* synthetic */ void m2265a(ContentValues contentValues, Object obj) {
        contentValues.put(this.a, (Integer) obj);
    }

    public final /* synthetic */ C0385e m2266b(Cursor cursor) {
        return m2263a(cursor);
    }

    public final /* synthetic */ Object m2267c(Cursor cursor) {
        return m2263a(cursor);
    }

    public C0454c(String str) {
        super(str);
    }

    public final C0452c m2263a(Cursor cursor) {
        return new C0455d(this, cursor, this, cursor);
    }

    public final /* synthetic */ Object m2264a(ContentValues contentValues) {
        return contentValues.getAsInteger(this.a);
    }
}
