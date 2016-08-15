package com.socialnmobile.colornote.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.socialnmobile.colornote.data.x */
public final class C0234x extends SQLiteOpenHelper {
    Context f1030a;

    public C0234x(Context context, String str) {
        super(context, str, null, 6);
        this.f1030a = context;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        C0232v c0232v = new C0232v(sQLiteDatabase);
        NoteProvider.m882a(c0232v);
        NoteProvider.m886b(c0232v);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase r5, int r6, int r7) {
        /*
        r4 = this;
        switch(r6) {
            case 1: goto L_0x0004;
            case 2: goto L_0x0009;
            case 3: goto L_0x00a2;
            case 4: goto L_0x00f7;
            case 5: goto L_0x0111;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        r0 = "ALTER TABLE notes ADD COLUMN status INTEGER DEFAULT 0;";
        r5.execSQL(r0);
    L_0x0009:
        r0 = "UPDATE notes SET color_index=color_index+1 WHERE color_index <= 5";
        r5.execSQL(r0);
        r0 = r4.f1030a;
        r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0);
        r1 = "pref_default_color";
        r2 = 100;
        r1 = r0.getInt(r1, r2);
        r2 = 5;
        if (r1 > r2) goto L_0x002d;
    L_0x001f:
        r0 = r0.edit();
        r2 = "pref_default_color";
        r1 = r1 + 1;
        r0.putInt(r2, r1);
        r0.commit();
    L_0x002d:
        r0 = "ALTER TABLE notes ADD COLUMN folder_id INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN importance INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN note_ext TEXT DEFAULT '';";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN active_state INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN reminder_type INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN reminder_option INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN reminder_base INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN reminder_last INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN reminder_duration INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN reminder_repeat INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = java.lang.System.currentTimeMillis();
        r0 = com.socialnmobile.colornote.C0313j.m1633a(r0);
        r2 = "UPDATE notes SET reminder_type = 32, reminder_repeat = 0, reminder_base = reminder_date WHERE reminder_date > 0";
        r5.execSQL(r2);
        r2 = new java.lang.StringBuilder;
        r3 = "UPDATE notes SET reminder_type = 16, reminder_repeat = 144, reminder_base = ";
        r2.<init>(r3);
        r2 = r2.append(r0);
        r3 = ", reminder_date = ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r3 = ", reminder_last = ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r1 = " WHERE reminder_date = -1";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r5.execSQL(r0);
        r0 = "UPDATE notes SET status = 16 WHERE status = 1";
        r5.execSQL(r0);
        r0 = "UPDATE notes SET type = 16 WHERE type = 1";
        r5.execSQL(r0);
    L_0x00a2:
        r0 = "ALTER TABLE notes ADD COLUMN account_id INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN space INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN latitude DOUBLE DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN longitude DOUBLE DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN minor_modified_date INTEGER DEFAULT 0;";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN dirty INTEGER DEFAULT 1";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN staged INTEGER DEFAULT 0";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN uuid TEXT";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN revision INTEGER DEFAULT 0";
        r5.execSQL(r0);
        r0 = "UPDATE notes SET minor_modified_date = modified_date";
        r5.execSQL(r0);
        r0 = "CREATE TABLE SyncAccount(_id INTEGER PRIMARY KEY NOT NULL,client_uuid TEXT,repository_built INTEGER DEFAULT 0 NOT NULL,base_revision INTEGER DEFAULT 0 NOT NULL,auth_token TEXT,email TEXT,colornote_id TEXT,fb_access TEXT,fb_user_name TEXT)";
        r5.execSQL(r0);
        r0 = "CREATE INDEX idx_note1 ON notes(active_state,account_id,folder_id,space)";
        r5.execSQL(r0);
        r0 = "CREATE INDEX idx_note2 ON notes(reminder_type,reminder_date)";
        r5.execSQL(r0);
        r0 = "CREATE INDEX idx_note3 ON notes(reminder_repeat,reminder_base)";
        r5.execSQL(r0);
        r0 = "CREATE INDEX idx_note4 ON notes(title)";
        r5.execSQL(r0);
        r0 = "CREATE INDEX idx_note_s1 ON notes(dirty)";
        r5.execSQL(r0);
        r0 = "CREATE INDEX idx_note_s2 ON notes(staged)";
        r5.execSQL(r0);
    L_0x00f7:
        r0 = 4;
        if (r6 != r0) goto L_0x00ff;
    L_0x00fa:
        r0 = "ALTER TABLE SyncAccount ADD COLUMN auth_token TEXT;";
        r5.execSQL(r0);	 Catch:{ Exception -> 0x0125 }
    L_0x00ff:
        r0 = new com.socialnmobile.colornote.data.v;
        r0.<init>(r5);
        r1 = new com.socialnmobile.colornote.data.aa;
        r2 = new com.socialnmobile.colornote.data.u;
        r2.<init>(r0);
        r1.<init>(r2);
        r1.m912a();
    L_0x0111:
        r0 = "DELETE FROM SyncAccount";
        r5.execSQL(r0);
        r0 = "UPDATE notes SET dirty = 1,staged = 0,revision = 0";
        r5.execSQL(r0);
        r0 = "ALTER TABLE notes ADD COLUMN reminder_repeat_ends INTEGER DEFAULT 0;";
        r5.execSQL(r0);	 Catch:{ SQLiteException -> 0x0122 }
        goto L_0x0003;
    L_0x0122:
        r0 = move-exception;
        goto L_0x0003;
    L_0x0125:
        r0 = move-exception;
        r0 = "Column already exists";
        com.socialnmobile.colornote.ColorNote.m651a(r0);
        goto L_0x00ff;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.data.x.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
