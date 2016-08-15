package com.socialnmobile.util.p011b.p021a;

import android.content.ContentValues;
import android.database.Cursor;
import com.socialnmobile.util.p011b.C0385e;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.C0452c;

/* renamed from: com.socialnmobile.util.b.a.g */
public final class C0458g extends C0449a {
    public final /* synthetic */ void m2277a(ContentValues contentValues, Object obj) {
        contentValues.put(this.a, (String) obj);
    }

    public final /* synthetic */ C0385e m2278b(Cursor cursor) {
        return m2275a(cursor);
    }

    public final /* synthetic */ Object m2279c(Cursor cursor) {
        return m2275a(cursor);
    }

    public C0458g(String str) {
        super(str);
    }

    public final C0452c m2275a(Cursor cursor) {
        return new C0459h(this, cursor, this, cursor);
    }

    public final /* synthetic */ Object m2276a(ContentValues contentValues) {
        return contentValues.getAsString(this.a);
    }
}
