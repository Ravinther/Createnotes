package com.socialnmobile.util.p011b.p021a;

import android.content.ContentValues;
import android.database.Cursor;
import com.socialnmobile.util.p011b.C0385e;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.C0452c;

/* renamed from: com.socialnmobile.util.b.a.a */
public final class C0450a extends C0449a {
    public final /* synthetic */ void m2255a(ContentValues contentValues, Object obj) {
        contentValues.put(this.a, (Double) obj);
    }

    public final /* synthetic */ C0385e m2256b(Cursor cursor) {
        return m2253a(cursor);
    }

    public final /* synthetic */ Object m2257c(Cursor cursor) {
        return m2253a(cursor);
    }

    public C0450a(String str) {
        super(str);
    }

    public final C0452c m2253a(Cursor cursor) {
        return new C0453b(this, cursor, this, cursor);
    }

    public final /* synthetic */ Object m2254a(ContentValues contentValues) {
        return contentValues.getAsDouble(this.a);
    }
}
