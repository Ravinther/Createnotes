package com.socialnmobile.colornote.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.socialnmobile.colornote.ColorNote;

/* renamed from: com.socialnmobile.colornote.data.n */
public final class C0224n extends SQLiteOpenHelper {
    C0224n(Context context) {
        super(context, "internal.db", null, 3);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
            case 2:
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE widget ADD COLUMN widget_type INTEGER DEFAULT 0;");
                } catch (Exception e) {
                    ColorNote.m651a("Column already exists");
                }
                sQLiteDatabase.execSQL("UPDATE widget SET widget_type = 1");
            default:
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE widget (_id INTEGER PRIMARY KEY,note_id INTEGER NOT NULL,widget_type INTEGER DEFAULT 0);");
    }
}
