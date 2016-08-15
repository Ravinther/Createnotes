package com.socialnmobile.colornote.fragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.dialog.C0170m;

final class bq implements C0170m {
    final /* synthetic */ NoteListFragment f1266a;

    bq(NoteListFragment noteListFragment) {
        this.f1266a = noteListFragment;
    }

    public final boolean m1580a(String str) {
        if (!C0213c.m962a(this.f1266a.f48C, str)) {
            return false;
        }
        Context context = this.f1266a.f48C;
        Uri uri = this.f1266a.ad;
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query.moveToNext()) {
            C0230t c0230t = new C0230t();
            c0230t.m1058a(query);
            query.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put(NoteMajorColumns.NOTE, c0230t.m1057a(context));
            contentValues.put(NoteMajorColumns.ENCRYPTION, Integer.valueOf(0));
            contentValues.put(NoteMajorColumns.MODIFIED_DATE, Long.valueOf(c0230t.f1010i + 1));
            context.getContentResolver().update(uri, contentValues, null, null);
        } else {
            query.close();
        }
        return true;
    }
}
