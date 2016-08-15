package com.socialnmobile.util.p011b.p021a;

import android.content.ContentValues;
import android.database.Cursor;
import com.socialnmobile.util.p011b.C0385e;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.C0452c;

/* renamed from: com.socialnmobile.util.b.a.e */
public final class C0456e extends C0449a {
    public final /* synthetic */ void m2271a(ContentValues contentValues, Object obj) {
        contentValues.put(this.a, (Long) obj);
    }

    public final /* synthetic */ C0385e m2272b(Cursor cursor) {
        return m2269a(cursor);
    }

    public final /* synthetic */ Object m2273c(Cursor cursor) {
        return m2269a(cursor);
    }

    public C0456e(String str) {
        super(str);
    }

    public final C0452c m2269a(Cursor cursor) {
        return new C0457f(this, cursor, this, cursor);
    }

    public final /* synthetic */ Object m2270a(ContentValues contentValues) {
        return contentValues.getAsLong(this.a);
    }
}
