package com.socialnmobile.colornote.fragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0222l;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.dialog.C0170m;

final class bp implements C0170m {
    final /* synthetic */ NoteListFragment f1265a;

    bp(NoteListFragment noteListFragment) {
        this.f1265a = noteListFragment;
    }

    public final boolean m1579a(String str) {
        if (!C0213c.m962a(this.f1265a.f48C, str)) {
            return false;
        }
        Context context = this.f1265a.f48C;
        Uri uri = this.f1265a.ad;
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query.moveToNext()) {
            String string = query.getString(query.getColumnIndex(NoteMajorColumns.NOTE));
            long j = query.getLong(query.getColumnIndex(NoteMajorColumns.MODIFIED_DATE));
            query.close();
            C0222l a = C0222l.m1007a(context);
            int i = a.f973b;
            String c = a.m1018c(string);
            ContentValues contentValues = new ContentValues();
            contentValues.put(NoteMajorColumns.NOTE, c);
            contentValues.put(NoteMajorColumns.ENCRYPTION, Integer.valueOf(i));
            contentValues.put(NoteMajorColumns.MODIFIED_DATE, Long.valueOf(j + 1));
            context.getContentResolver().update(uri, contentValues, null, null);
        } else {
            query.close();
        }
        return true;
    }
}
