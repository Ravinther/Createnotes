package com.socialnmobile.colornote.sync;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.socialnmobile.colornote.data.C0231u;
import com.socialnmobile.util.p011b.C0473n;

/* renamed from: com.socialnmobile.colornote.sync.t */
public final class C0404t implements AccountColumns {
    final C0231u f1817a;

    public C0404t(C0231u c0231u) {
        this.f1817a = c0231u;
    }

    public final int m2055a(ContentValues contentValues, C0473n c0473n) {
        if (c0473n == null) {
            c0473n = new C0473n();
        }
        return this.f1817a.m1074f().m1075a("SyncAccount", contentValues, c0473n.f2273a, c0473n.f2274b);
    }

    public final ContentValues m2056a(C0473n c0473n) {
        ContentValues contentValues = null;
        if (c0473n == null) {
            c0473n = new C0473n();
        }
        Cursor a = this.f1817a.m1073e().m1080a("SyncAccount", null, c0473n.f2273a, c0473n.f2274b, null);
        try {
            if (a.moveToFirst()) {
                contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(a, contentValues);
            } else {
                a.close();
            }
            return contentValues;
        } finally {
            a.close();
        }
    }
}
