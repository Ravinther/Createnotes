package com.socialnmobile.util.p011b;

import android.content.ContentValues;
import android.database.Cursor;

/* renamed from: com.socialnmobile.util.b.a */
public abstract class C0449a implements C0448m {
    public final String f2234a;

    public abstract C0452c m2246a(Cursor cursor);

    public abstract Object m2247a(ContentValues contentValues);

    public abstract void m2248a(ContentValues contentValues, Object obj);

    public /* synthetic */ C0385e m2250b(Cursor cursor) {
        return m2246a(cursor);
    }

    public final /* synthetic */ Object m2251c(ContentValues contentValues) {
        return m2249b(contentValues);
    }

    public /* synthetic */ Object m2252c(Cursor cursor) {
        return m2246a(cursor);
    }

    public C0449a(String str) {
        this.f2234a = str;
    }

    public final C0385e m2249b(ContentValues contentValues) {
        return new C0467b(this, contentValues, this);
    }
}
