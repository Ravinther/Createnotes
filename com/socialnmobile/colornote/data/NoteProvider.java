package com.socialnmobile.colornote.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.socialnmobile.colornote.data.NoteColumns.NoteLocalColumns;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.sync.SyncIndexColumns;
import com.socialnmobile.colornote.sync.SyncStateColumns;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

public class NoteProvider extends ContentProvider {
    static C0234x f911a;
    static C0231u f912b;
    private static final String[] f913c;
    private static final String[] f914d;
    private static HashMap f915e;
    private static final UriMatcher f916f;
    private static NoteProvider f917i;
    private final ArrayList f918g;
    private Handler f919h;

    public NoteProvider() {
        this.f918g = new ArrayList();
        this.f919h = new Handler();
    }

    static {
        f913c = new String[]{"_id", "suggest_text_1", "suggest_text_2", "suggest_intent_data", "suggest_shortcut_id", "suggest_spinner_while_refreshing"};
        f914d = new String[]{"_id", NoteMajorColumns.TITLE, NoteMajorColumns.NOTE, NoteMajorColumns.ENCRYPTION};
        UriMatcher uriMatcher = new UriMatcher(-1);
        f916f = uriMatcher;
        uriMatcher.addURI("note.socialnmobile.provider.colornote", "notes", 1);
        f916f.addURI("note.socialnmobile.provider.colornote", "notes/#", 2);
        f916f.addURI("note.socialnmobile.provider.colornote", "notes/title/*", 6);
        f916f.addURI("note.socialnmobile.provider.colornote", "counts", 5);
        f916f.addURI("note.socialnmobile.provider.colornote", "search_suggest_query", 3);
        f916f.addURI("note.socialnmobile.provider.colornote", "search_suggest_query/*", 3);
        f916f.addURI("note.socialnmobile.provider.colornote", "search_suggest_shortcut", 4);
        f916f.addURI("note.socialnmobile.provider.colornote", "search_suggest_shortcut/*", 4);
        f916f.addURI("note.socialnmobile.provider.colornote", "tempnotes", 10);
        f916f.addURI("note.socialnmobile.provider.colornote", "tempnotes/#", 11);
        f916f.addURI("note.socialnmobile.provider.colornote", "tempnotes/title/*", 6);
        HashMap hashMap = new HashMap();
        f915e = hashMap;
        hashMap.put("_id", "_id");
        f915e.put(NoteMinorColumns.STATE, NoteMinorColumns.STATE);
        f915e.put(NoteLocalColumns.ACCOUNT_ID, NoteLocalColumns.ACCOUNT_ID);
        f915e.put(NoteMinorColumns.FOLDER, NoteMinorColumns.FOLDER);
        f915e.put(NoteMinorColumns.FLAGS, NoteMinorColumns.FLAGS);
        f915e.put(NoteMinorColumns.SPACE, NoteMinorColumns.SPACE);
        f915e.put(NoteMinorColumns.TYPE, NoteMinorColumns.TYPE);
        f915e.put(NoteMajorColumns.TITLE, NoteMajorColumns.TITLE);
        f915e.put(NoteMajorColumns.NOTE, NoteMajorColumns.NOTE);
        f915e.put(NoteMinorColumns.NOTE_EXT, NoteMinorColumns.NOTE_EXT);
        f915e.put(NoteMinorColumns.NOTE_VERSION, NoteMinorColumns.NOTE_VERSION);
        f915e.put(NoteMinorColumns.TAGS, NoteMinorColumns.TAGS);
        f915e.put(NoteMinorColumns.IMPORTANCE, NoteMinorColumns.IMPORTANCE);
        f915e.put(NoteMinorColumns.CREATED_DATE, NoteMinorColumns.CREATED_DATE);
        f915e.put(NoteMajorColumns.MODIFIED_DATE, NoteMajorColumns.MODIFIED_DATE);
        f915e.put(NoteMinorColumns.MINOR_MODIFIED_DATE, NoteMinorColumns.MINOR_MODIFIED_DATE);
        f915e.put(NoteMinorColumns.REMINDER_DATE, NoteMinorColumns.REMINDER_DATE);
        f915e.put(NoteMinorColumns.REMINDER_BASE, NoteMinorColumns.REMINDER_BASE);
        f915e.put(NoteMinorColumns.REMINDER_LAST, NoteMinorColumns.REMINDER_LAST);
        f915e.put(NoteMinorColumns.REMINDER_DURATION, NoteMinorColumns.REMINDER_DURATION);
        f915e.put(NoteMinorColumns.REMINDER_TYPE, NoteMinorColumns.REMINDER_TYPE);
        f915e.put(NoteMinorColumns.REMINDER_OPTION, NoteMinorColumns.REMINDER_OPTION);
        f915e.put(NoteMinorColumns.REMINDER_REPEAT, NoteMinorColumns.REMINDER_REPEAT);
        f915e.put(NoteMinorColumns.REMINDER_REPEAT_END, NoteMinorColumns.REMINDER_REPEAT_END);
        f915e.put(NoteMinorColumns.LATITUDE, NoteMinorColumns.LATITUDE);
        f915e.put(NoteMinorColumns.LONGITUDE, NoteMinorColumns.LONGITUDE);
        f915e.put(NoteMinorColumns.COLOR, NoteMinorColumns.COLOR);
        f915e.put(NoteMajorColumns.ENCRYPTION, NoteMajorColumns.ENCRYPTION);
        f915e.put(SyncIndexColumns.REVISION, SyncIndexColumns.REVISION);
    }

    public static int m877a(Uri uri) {
        return f916f.match(uri);
    }

    static void m882a(C0232v c0232v) {
        c0232v.m1081a("CREATE TABLE notes (_id INTEGER PRIMARY KEY AUTOINCREMENT,active_state INTEGER DEFAULT 0,account_id INTEGER DEFAULT 0,folder_id INTEGER DEFAULT 0,status INTEGER DEFAULT 0,space INTEGER DEFAULT 0,type INTEGER NOT NULL,title TEXT NOT NULL COLLATE LOCALIZED,note TEXT NOT NULL ,note_ext TEXT DEFAULT '',note_type INTEGER NOT NULL,tags TEXT DEFAULT '',importance INTEGER DEFAULT 0,created_date INTEGER NOT NULL,modified_date INTEGER NOT NULL,minor_modified_date INTEGER DEFAULT 0,reminder_type INTEGER DEFAULT 0,reminder_option INTEGER DEFAULT 0,reminder_date INTEGER DEFAULT 0,reminder_base INTEGER DEFAULT 0,reminder_last INTEGER DEFAULT 0,reminder_duration INTEGER DEFAULT 0,reminder_repeat INTEGER DEFAULT 0,reminder_repeat_ends INTEGER DEFAULT 0,latitude DOUBLE DEFAULT 0,longitude DOUBLE DEFAULT 0,color_index INTEGER NOT NULL,encrypted INTEGER DEFAULT 0,dirty INTEGER DEFAULT 1,staged INTEGER DEFAULT 0,uuid TEXT,revision INTEGER DEFAULT 0);");
        c0232v.m1081a("CREATE TABLE SyncAccount(_id INTEGER PRIMARY KEY NOT NULL,client_uuid TEXT,repository_built INTEGER DEFAULT 0 NOT NULL,base_revision INTEGER DEFAULT 0 NOT NULL,auth_token TEXT,email TEXT,colornote_id TEXT,fb_access TEXT,fb_user_name TEXT)");
    }

    static void m886b(C0232v c0232v) {
        c0232v.m1081a("CREATE INDEX idx_note1 ON notes(active_state,account_id,folder_id,space)");
        c0232v.m1081a("CREATE INDEX idx_note2 ON notes(reminder_type,reminder_date)");
        c0232v.m1081a("CREATE INDEX idx_note3 ON notes(reminder_repeat,reminder_base)");
        c0232v.m1081a("CREATE INDEX idx_note4 ON notes(title)");
        c0232v.m1081a("CREATE INDEX idx_note_s1 ON notes(dirty)");
        c0232v.m1081a("CREATE INDEX idx_note_s2 ON notes(staged)");
    }

    public static void m889c(C0232v c0232v) {
        c0232v.m1081a("DROP TABLE IF EXISTS notes;");
        c0232v.m1081a("DROP TABLE IF EXISTS SyncAccount;");
        m882a(c0232v);
        m886b(c0232v);
    }

    public static NoteProvider m880a(Context context) {
        if (f917i == null) {
            m888c(context);
            context.getContentResolver().getType(C0228r.f997a);
            context.getContentResolver().query(C0228r.f997a, null, null, null, null);
        }
        return f917i;
    }

    public static C0231u m885b(Context context) {
        if (f911a == null) {
            m888c(context);
        }
        return f912b;
    }

    public boolean onCreate() {
        f917i = this;
        m892b();
        Log.i("NoteProvider", "databasePath=" + getContext().getDatabasePath("colornote.db"));
        return true;
    }

    public final void m891a(C0235y c0235y) {
        synchronized (this.f918g) {
            this.f918g.add(c0235y);
        }
    }

    public final void m893b(C0235y c0235y) {
        synchronized (this.f918g) {
            this.f918g.remove(c0235y);
        }
    }

    public final void m890a() {
        this.f919h.post(new C0233w(this));
    }

    private static void m888c(Context context) {
        if (f911a == null) {
            f911a = new C0234x(context.getApplicationContext(), "colornote.db");
            f912b = new C0231u(f911a);
        }
    }

    public final void m892b() {
        m888c(getContext());
        m890a();
    }

    public static void m887c() {
        if (f911a != null) {
            f911a.close();
            f911a = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor query(android.net.Uri r9, java.lang.String[] r10, java.lang.String r11, java.lang.String[] r12, java.lang.String r13) {
        /*
        r8 = this;
        r3 = 1;
        r2 = 0;
        r0 = android.os.Binder.getCallingUid();
        r1 = android.os.Process.myUid();
        if (r0 == r1) goto L_0x001b;
    L_0x000c:
        r0 = r8.getContext();
        r1 = "android.permission.GLOBAL_SEARCH";
        r0 = r0.checkCallingPermission(r1);
        r1 = -1;
        if (r0 != r1) goto L_0x001b;
    L_0x0019:
        r0 = r2;
    L_0x001a:
        return r0;
    L_0x001b:
        com.socialnmobile.colornote.data.C0231u.m1069a();
        r0 = new android.database.sqlite.SQLiteQueryBuilder;	 Catch:{ all -> 0x004b }
        r0.<init>();	 Catch:{ all -> 0x004b }
        r1 = "notes";
        r0.setTables(r1);	 Catch:{ all -> 0x004b }
        r1 = f915e;	 Catch:{ all -> 0x004b }
        r0.setProjectionMap(r1);	 Catch:{ all -> 0x004b }
        r1 = f916f;	 Catch:{ all -> 0x004b }
        r1 = r1.match(r9);	 Catch:{ all -> 0x004b }
        switch(r1) {
            case 1: goto L_0x0050;
            case 2: goto L_0x0074;
            case 3: goto L_0x011b;
            case 4: goto L_0x013c;
            case 5: goto L_0x00c4;
            case 6: goto L_0x0099;
            case 7: goto L_0x0036;
            case 8: goto L_0x0036;
            case 9: goto L_0x0036;
            case 10: goto L_0x00e1;
            case 11: goto L_0x00ef;
            default: goto L_0x0036;
        };	 Catch:{ all -> 0x004b }
    L_0x0036:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x004b }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004b }
        r2 = "Unknown URI ";
        r1.<init>(r2);	 Catch:{ all -> 0x004b }
        r1 = r1.append(r9);	 Catch:{ all -> 0x004b }
        r1 = r1.toString();	 Catch:{ all -> 0x004b }
        r0.<init>(r1);	 Catch:{ all -> 0x004b }
        throw r0;	 Catch:{ all -> 0x004b }
    L_0x004b:
        r0 = move-exception;
        com.socialnmobile.colornote.data.C0231u.m1070b();
        throw r0;
    L_0x0050:
        r1 = f912b;	 Catch:{ all -> 0x004b }
        r1 = r1.m1073e();	 Catch:{ all -> 0x004b }
    L_0x0056:
        r3 = android.text.TextUtils.isEmpty(r13);	 Catch:{ all -> 0x004b }
        if (r3 == 0) goto L_0x0166;
    L_0x005c:
        r7 = "modified_date DESC";
    L_0x005e:
        if (r2 == 0) goto L_0x0159;
    L_0x0060:
        r0 = 0;
        r0 = r1.m1079a(r2, r0);	 Catch:{ all -> 0x004b }
    L_0x0065:
        r1 = r8.getContext();	 Catch:{ all -> 0x004b }
        r1 = r1.getContentResolver();	 Catch:{ all -> 0x004b }
        r0.setNotificationUri(r1, r9);	 Catch:{ all -> 0x004b }
        com.socialnmobile.colornote.data.C0231u.m1070b();
        goto L_0x001a;
    L_0x0074:
        r1 = f912b;	 Catch:{ all -> 0x004b }
        r3 = r1.m1073e();	 Catch:{ all -> 0x004b }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004b }
        r1 = "_id=";
        r4.<init>(r1);	 Catch:{ all -> 0x004b }
        r1 = r9.getPathSegments();	 Catch:{ all -> 0x004b }
        r5 = 1;
        r1 = r1.get(r5);	 Catch:{ all -> 0x004b }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x004b }
        r1 = r4.append(r1);	 Catch:{ all -> 0x004b }
        r1 = r1.toString();	 Catch:{ all -> 0x004b }
        r0.appendWhere(r1);	 Catch:{ all -> 0x004b }
        r1 = r3;
        goto L_0x0056;
    L_0x0099:
        r1 = f912b;	 Catch:{ all -> 0x004b }
        r3 = r1.m1073e();	 Catch:{ all -> 0x004b }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004b }
        r1 = "title = '";
        r4.<init>(r1);	 Catch:{ all -> 0x004b }
        r1 = r9.getPathSegments();	 Catch:{ all -> 0x004b }
        r5 = 2;
        r1 = r1.get(r5);	 Catch:{ all -> 0x004b }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x004b }
        r1 = r4.append(r1);	 Catch:{ all -> 0x004b }
        r4 = "'";
        r1 = r1.append(r4);	 Catch:{ all -> 0x004b }
        r1 = r1.toString();	 Catch:{ all -> 0x004b }
        r0.appendWhere(r1);	 Catch:{ all -> 0x004b }
        r1 = r3;
        goto L_0x0056;
    L_0x00c4:
        r1 = f912b;	 Catch:{ all -> 0x004b }
        r1 = r1.m1073e();	 Catch:{ all -> 0x004b }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004b }
        r3 = "SELECT count(*) as notes_count,color_index from notes where ";
        r2.<init>(r3);	 Catch:{ all -> 0x004b }
        r2 = r2.append(r11);	 Catch:{ all -> 0x004b }
        r3 = " group by color_index";
        r2 = r2.append(r3);	 Catch:{ all -> 0x004b }
        r2 = r2.toString();	 Catch:{ all -> 0x004b }
        goto L_0x0056;
    L_0x00e1:
        r1 = r8.getContext();	 Catch:{ all -> 0x004b }
        r1 = com.socialnmobile.colornote.data.af.m930a(r1);	 Catch:{ all -> 0x004b }
        r1 = r1.m933b();	 Catch:{ all -> 0x004b }
        goto L_0x0056;
    L_0x00ef:
        r1 = r8.getContext();	 Catch:{ all -> 0x004b }
        r1 = com.socialnmobile.colornote.data.af.m930a(r1);	 Catch:{ all -> 0x004b }
        r3 = r1.m933b();	 Catch:{ all -> 0x004b }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004b }
        r1 = "_id=";
        r4.<init>(r1);	 Catch:{ all -> 0x004b }
        r1 = r9.getPathSegments();	 Catch:{ all -> 0x004b }
        r5 = 1;
        r1 = r1.get(r5);	 Catch:{ all -> 0x004b }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x004b }
        r1 = r4.append(r1);	 Catch:{ all -> 0x004b }
        r1 = r1.toString();	 Catch:{ all -> 0x004b }
        r0.appendWhere(r1);	 Catch:{ all -> 0x004b }
        r1 = r3;
        goto L_0x0056;
    L_0x011b:
        r0 = f912b;	 Catch:{ all -> 0x004b }
        r0 = r0.m1073e();	 Catch:{ all -> 0x004b }
        r1 = r9.getPathSegments();	 Catch:{ all -> 0x004b }
        r1 = r1.size();	 Catch:{ all -> 0x004b }
        if (r1 <= r3) goto L_0x0133;
    L_0x012b:
        r1 = r9.getLastPathSegment();	 Catch:{ all -> 0x004b }
        r2 = r1.toLowerCase();	 Catch:{ all -> 0x004b }
    L_0x0133:
        r0 = m879a(r0, r2);	 Catch:{ all -> 0x004b }
        com.socialnmobile.colornote.data.C0231u.m1070b();
        goto L_0x001a;
    L_0x013c:
        r0 = f912b;	 Catch:{ all -> 0x004b }
        r0 = r0.m1073e();	 Catch:{ all -> 0x004b }
        r1 = r9.getPathSegments();	 Catch:{ all -> 0x004b }
        r1 = r1.size();	 Catch:{ all -> 0x004b }
        if (r1 <= r3) goto L_0x0150;
    L_0x014c:
        r2 = r9.getLastPathSegment();	 Catch:{ all -> 0x004b }
    L_0x0150:
        r0 = m884b(r0, r2);	 Catch:{ all -> 0x004b }
        com.socialnmobile.colornote.data.C0231u.m1070b();
        goto L_0x001a;
    L_0x0159:
        r1 = r1.f1027a;	 Catch:{ all -> 0x004b }
        r5 = 0;
        r6 = 0;
        r2 = r10;
        r3 = r11;
        r4 = r12;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x004b }
        goto L_0x0065;
    L_0x0166:
        r7 = r13;
        goto L_0x005e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.data.NoteProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public String getType(Uri uri) {
        switch (f916f.match(uri)) {
            case 1:
            case 10:
                return "vnd.android.cursor.dir/vnd.socialnmobile.colornote.note";
            case 2:
            case 11:
                return "vnd.android.cursor.item/vnd.socialnmobile.colornote.note";
            case 3:
                return "vnd.android.cursor.dir/vnd.android.search.suggest";
            case 4:
                return "vnd.android.cursor.item/vnd.android.search.suggest";
            case 6:
            case 12:
                return "vnd.android.cursor.item/vnd.socialnmobile.colornote.note.title";
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uri2 = null;
        if (Binder.getCallingUid() == Process.myUid() || getContext().checkCallingPermission("android.permission.GLOBAL_SEARCH") != -1) {
            C0231u.m1069a();
            try {
                C0232v f = f912b.m1074f();
                if (f916f.match(uri) != 1) {
                    throw new IllegalArgumentException("Unknown URI " + uri);
                }
                ContentValues contentValues2;
                if (contentValues != null) {
                    contentValues2 = new ContentValues(contentValues);
                } else {
                    contentValues2 = new ContentValues();
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (!contentValues2.containsKey(NoteMinorColumns.CREATED_DATE)) {
                    contentValues2.put(NoteMinorColumns.CREATED_DATE, valueOf);
                }
                if (!contentValues2.containsKey(NoteMajorColumns.MODIFIED_DATE)) {
                    contentValues2.put(NoteMajorColumns.MODIFIED_DATE, valueOf);
                }
                contentValues2.put(NoteMinorColumns.MINOR_MODIFIED_DATE, valueOf);
                contentValues2.put(SyncStateColumns.DIRTY_STATE, Integer.valueOf(3));
                contentValues2.put(SyncIndexColumns.UUID, UUID.randomUUID().toString());
                contentValues2.put(SyncIndexColumns.REVISION, Integer.valueOf(0));
                if (!contentValues2.containsKey(NoteMajorColumns.TITLE)) {
                    contentValues2.put(NoteMajorColumns.TITLE, "");
                }
                if (!contentValues2.containsKey(NoteMajorColumns.NOTE)) {
                    contentValues2.put(NoteMajorColumns.NOTE, "");
                }
                long a = f.m1078a("notes", NoteMajorColumns.NOTE, contentValues2);
                if (a > 0) {
                    uri2 = ContentUris.withAppendedId(C0228r.f997a, a);
                    getContext().getContentResolver().notifyChange(uri2, null);
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
            } finally {
                C0231u.m1070b();
            }
        }
        return uri2;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (Binder.getCallingUid() != Process.myUid() && getContext().checkCallingPermission("android.permission.GLOBAL_SEARCH") == -1) {
            return 0;
        }
        C0231u.m1069a();
        try {
            int a;
            C0232v f = f912b.m1074f();
            switch (f916f.match(uri)) {
                case 1:
                    a = f.m1076a("notes", str, strArr);
                    break;
                case 2:
                    a = f.m1076a("notes", "_id=" + ((String) uri.getPathSegments().get(1)) + (!TextUtils.isEmpty(str) ? " AND (" + str + ')' : ""), strArr);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown URI " + uri);
            }
            getContext().getContentResolver().notifyChange(uri, null);
            return a;
        } finally {
            C0231u.m1070b();
        }
    }

    private static int m878a(C0232v c0232v, ContentValues contentValues, String str, String[] strArr) {
        int i;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        contentValues.put(NoteMinorColumns.MINOR_MODIFIED_DATE, valueOf);
        if (contentValues.containsKey(NoteMajorColumns.NOTE) && !contentValues.containsKey(NoteMajorColumns.MODIFIED_DATE)) {
            contentValues.put(NoteMajorColumns.MODIFIED_DATE, valueOf);
        }
        if (contentValues.containsKey(NoteMajorColumns.MODIFIED_DATE)) {
            i = 3;
        } else {
            i = 2;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder(240);
        stringBuilder.append("UPDATE ");
        stringBuilder.append("notes");
        stringBuilder.append(" SET ");
        Iterable arrayList2 = new ArrayList();
        for (Entry entry : contentValues.valueSet()) {
            arrayList2.add(((String) entry.getKey()) + "=?");
            arrayList.add(entry.getValue());
        }
        arrayList2.add("dirty=dirty|" + i);
        stringBuilder.append(TextUtils.join(", ", arrayList2));
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ");
            stringBuilder.append(str);
            if (strArr != null) {
                arrayList.addAll(Arrays.asList(strArr));
            }
        }
        return c0232v.m1077a(stringBuilder.toString(), arrayList.toArray());
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (Binder.getCallingUid() != Process.myUid() && getContext().checkCallingPermission("android.permission.GLOBAL_SEARCH") == -1) {
            return 0;
        }
        C0231u.m1069a();
        try {
            int a;
            C0232v f = f912b.m1074f();
            switch (f916f.match(uri)) {
                case 1:
                    a = m878a(f, contentValues, str, strArr);
                    break;
                case 2:
                    a = m878a(f, contentValues, "_id=" + ((String) uri.getPathSegments().get(1)) + (!TextUtils.isEmpty(str) ? " AND (" + str + ')' : ""), strArr);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown URI " + uri);
            }
            getContext().getContentResolver().notifyChange(uri, null);
            return a;
        } finally {
            C0231u.m1070b();
        }
    }

    private static Cursor m879a(C0232v c0232v, String str) {
        if ((str == null ? "" : str.toLowerCase()).equals("")) {
            return null;
        }
        Cursor a = c0232v.m1080a("notes", f914d, "active_state <> 32 AND active_state <> 256 AND (title like ? OR note like ? )", new String[]{"%" + (str == null ? "" : str.toLowerCase()) + "%", "%" + (str == null ? "" : str.toLowerCase()) + "%"}, "modified_date DESC");
        MatrixCursor matrixCursor = new MatrixCursor(f913c);
        int i = 0;
        while (a.moveToNext() && i < 15) {
            matrixCursor.addRow(m883a(a));
            i++;
        }
        a.close();
        return matrixCursor;
    }

    private static Cursor m884b(C0232v c0232v, String str) {
        Cursor cursor = null;
        try {
            long longValue = Long.valueOf(str).longValue();
            MatrixCursor matrixCursor = new MatrixCursor(f913c);
            C0232v c0232v2 = c0232v;
            Cursor a = c0232v2.m1080a("notes", f914d, "_id = ?", new String[]{String.valueOf(longValue)}, null);
            if (a.moveToNext()) {
                matrixCursor.addRow(m883a(a));
                cursor = matrixCursor;
            }
            a.close();
        } catch (NumberFormatException e) {
        }
        return cursor;
    }

    private static Object[] m883a(Cursor cursor) {
        String string;
        int i = 60;
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        String valueOf = String.valueOf(j);
        String string2 = cursor.getString(cursor.getColumnIndex(NoteMajorColumns.TITLE));
        if (cursor.getInt(cursor.getColumnIndex(NoteMajorColumns.ENCRYPTION)) == 0) {
            string = cursor.getString(cursor.getColumnIndex(NoteMajorColumns.NOTE));
        } else {
            string = "";
        }
        if (string.length() < 60) {
            i = string.length();
        }
        string = string.substring(0, i);
        Uri withAppendedId = ContentUris.withAppendedId(C0228r.f997a, j);
        return new String[]{valueOf, string2, string, withAppendedId.toString(), valueOf, "true"};
    }
}
