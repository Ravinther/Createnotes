package com.socialnmobile.colornote.fragment;

import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class dk implements OnItemClickListener {
    final /* synthetic */ TextEditor f1321a;

    dk(TextEditor textEditor) {
        this.f1321a = textEditor;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Cursor cursor = (Cursor) this.f1321a.aw.getItemAtPosition(i);
        this.f1321a.av.setText(cursor.getString(cursor.getColumnIndex("suggest_text_1")));
        this.f1321a.at.requestFocus();
    }
}
