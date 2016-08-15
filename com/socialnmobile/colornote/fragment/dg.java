package com.socialnmobile.colornote.fragment;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.widget.FilterQueryProvider;

final class dg implements FilterQueryProvider {
    final /* synthetic */ TextEditor f1317a;

    dg(TextEditor textEditor) {
        this.f1317a = textEditor;
    }

    public final Cursor runQuery(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (charSequence.length() == 0) {
            return new MatrixCursor(new String[]{"_id", "suggest_text_1"});
        }
        return this.f1317a.f48C.getContentResolver().query(Uri.parse("content://com.socialnmobile.colordict.colordictprovider/search_suggest_query/" + charSequence), null, null, null, null);
    }
}
