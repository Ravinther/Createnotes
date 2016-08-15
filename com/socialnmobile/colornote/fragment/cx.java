package com.socialnmobile.colornote.fragment;

import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

final class cx extends SimpleCursorAdapter {
    final /* synthetic */ TextEditor f1307a;

    cx(TextEditor textEditor, Context context, String[] strArr, int[] iArr) {
        this.f1307a = textEditor;
        super(context, 17367043, null, strArr, iArr);
    }

    public final CharSequence convertToString(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("suggest_text_1"));
    }
}
