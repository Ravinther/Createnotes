package com.socialnmobile.colornote.data;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.format.Time;
import com.socialnmobile.colornote.C0310g;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.p012f.C0269a;
import com.socialnmobile.colornote.receiver.C0332a;
import com.socialnmobile.util.p011b.C0449a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.socialnmobile.colornote.data.s */
public final class C0229s {
    public static void m1042a(Context context, Uri uri, int i) {
        if (i == 128) {
            C0229s.m1048a(context, uri, 0, 0, 0, 0, false);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteMinorColumns.REMINDER_DATE, Integer.valueOf(0));
        context.getContentResolver().update(uri, contentValues, null, null);
        C0310g.m1615a(context, uri);
        C0310g.m1619c(context, currentTimeMillis);
        C0310g.m1618b(context, currentTimeMillis);
    }

    public static boolean m1048a(Context context, Uri uri, long j, int i, int i2, long j2, boolean z) {
        ContentValues contentValues = new ContentValues();
        long currentTimeMillis = System.currentTimeMillis();
        C0310g.m1615a(context, uri);
        long a;
        if (i == 16 && i2 == 144) {
            a = C0313j.m1633a(currentTimeMillis);
            contentValues.put(NoteMinorColumns.REMINDER_TYPE, Integer.valueOf(16));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT, Integer.valueOf(144));
            contentValues.put(NoteMinorColumns.REMINDER_BASE, Long.valueOf(a));
            contentValues.put(NoteMinorColumns.REMINDER_DATE, Long.valueOf(a));
            contentValues.put(NoteMinorColumns.REMINDER_LAST, Long.valueOf(a));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT_END, Integer.valueOf(0));
            context.getContentResolver().update(uri, contentValues, null, null);
        } else if (i == 16) {
            long a2 = C0313j.m1633a(j);
            if (j2 != 0) {
                a = C0313j.m1633a(j2);
            } else {
                a = 0;
            }
            contentValues.put(NoteMinorColumns.REMINDER_TYPE, Integer.valueOf(i));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT, Integer.valueOf(i2));
            contentValues.put(NoteMinorColumns.REMINDER_BASE, Long.valueOf(a2));
            contentValues.put(NoteMinorColumns.REMINDER_DATE, Long.valueOf(a2));
            contentValues.put(NoteMinorColumns.REMINDER_LAST, Long.valueOf(a2));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT_END, Long.valueOf(a));
            Time time = new Time();
            time.setToNow();
            time.set(time.monthDay, time.month, time.year);
            if (j < C0147f.m661a(time, true) && !z) {
                return false;
            }
            context.getContentResolver().update(uri, contentValues, null, null);
        } else if (i == 32) {
            contentValues.put(NoteMinorColumns.REMINDER_TYPE, Integer.valueOf(i));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT, Integer.valueOf(i2));
            contentValues.put(NoteMinorColumns.REMINDER_BASE, Long.valueOf(j));
            contentValues.put(NoteMinorColumns.REMINDER_DATE, Long.valueOf(j));
            contentValues.put(NoteMinorColumns.REMINDER_LAST, Long.valueOf(j));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT_END, Long.valueOf(j2));
            if (j < currentTimeMillis && !z) {
                return false;
            }
            context.getContentResolver().update(uri, contentValues, null, null);
        } else if (i == 128) {
            contentValues.put(NoteMinorColumns.REMINDER_TYPE, Integer.valueOf(i));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT, Integer.valueOf(0));
            contentValues.put(NoteMinorColumns.REMINDER_BASE, Integer.valueOf(0));
            contentValues.put(NoteMinorColumns.REMINDER_DATE, Integer.valueOf(-1));
            contentValues.put(NoteMinorColumns.REMINDER_LAST, Integer.valueOf(0));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT_END, Integer.valueOf(0));
            context.getContentResolver().update(uri, contentValues, null, null);
            C0310g.m1620d(context, ContentUris.parseId(uri));
        } else if (i == 0) {
            contentValues.put(NoteMinorColumns.REMINDER_TYPE, Integer.valueOf(0));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT, Integer.valueOf(0));
            contentValues.put(NoteMinorColumns.REMINDER_DATE, Integer.valueOf(0));
            contentValues.put(NoteMinorColumns.REMINDER_BASE, Integer.valueOf(0));
            contentValues.put(NoteMinorColumns.REMINDER_LAST, Integer.valueOf(0));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT_END, Integer.valueOf(0));
            contentValues.put(NoteMinorColumns.REMINDER_DURATION, Integer.valueOf(0));
            contentValues.put(NoteMinorColumns.REMINDER_OPTION, Integer.valueOf(0));
            context.getContentResolver().update(uri, contentValues, null, null);
        }
        C0310g.m1619c(context, currentTimeMillis);
        C0310g.m1618b(context, currentTimeMillis);
        return true;
    }

    public static void m1045a(Context context, Uri uri, long j, int i, int i2, long j2, long j3, boolean z, boolean z2) {
        ContentValues contentValues = new ContentValues();
        long a;
        if (i == 16) {
            long a2 = C0313j.m1633a(j2);
            if (z) {
                a = C0310g.m1607a(context, i2, a2, a2 + 1, 1);
            } else if (i2 == 0) {
                a = 0;
            } else {
                a = C0310g.m1607a(context, i2, a2, C0313j.m1633a(j), 1);
            }
            if (j3 != 0 && r0 > j3) {
                a = 0;
            }
            contentValues.put(NoteMinorColumns.REMINDER_LAST, Long.valueOf(a2));
            contentValues.put(NoteMinorColumns.REMINDER_DATE, Long.valueOf(a));
            context.getContentResolver().update(uri, contentValues, null, null);
            if (z2) {
                C0310g.m1618b(context, j);
            }
        } else if (i == 32) {
            if (z) {
                a = C0310g.m1607a(context, i2, j2, j2 + 1, 2);
            } else if (i2 == 0) {
                a = 0;
            } else {
                a = C0310g.m1607a(context, i2, j2, j, 2);
            }
            if (j3 != 0 && r0 > j3) {
                a = 0;
            }
            contentValues.put(NoteMinorColumns.REMINDER_LAST, Long.valueOf(j2));
            contentValues.put(NoteMinorColumns.REMINDER_DATE, Long.valueOf(a));
            context.getContentResolver().update(uri, contentValues, null, null);
            C0310g.m1619c(context, j);
        }
    }

    public static void m1044a(Context context, Uri uri, int i, String str, String str2, int i2, int i3, int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteMinorColumns.FLAGS, Integer.valueOf(i));
        contentValues.put(NoteMajorColumns.NOTE, str);
        contentValues.put(NoteMajorColumns.TITLE, str2);
        contentValues.put(NoteMinorColumns.COLOR, Integer.valueOf(i2));
        contentValues.put(NoteMajorColumns.ENCRYPTION, Integer.valueOf(i3));
        context.getContentResolver().update(uri, contentValues, null, null);
        C0332a.m1725a(context, uri);
        if (i4 == 128) {
            C0310g.m1620d(context, ContentUris.parseId(uri));
        } else if (i4 == 16) {
            C0310g.m1618b(context, System.currentTimeMillis());
        }
    }

    public static void m1043a(Context context, Uri uri, int i, int i2, int i3) {
        int a = C0229s.m1033a(i, i2, i3);
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteMinorColumns.FLAGS, Integer.valueOf(a));
        context.getContentResolver().update(uri, contentValues, null, null);
        C0332a.m1725a(context, uri);
    }

    public static int m1033a(int i, int i2, int i3) {
        return ((i3 ^ -1) & i) | (i2 & i3);
    }

    public static void m1047a(Context context, Uri uri, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query.moveToNext()) {
            int a;
            C0230t c0230t = new C0230t();
            c0230t.m1058a(query);
            ArrayList b = C0269a.m1204b(c0230t.m1057a(context));
            Iterator it = b.iterator();
            while (it.hasNext()) {
                ((C0220j) it.next()).m1004a(z);
            }
            String a2 = C0269a.m1203a(b);
            ContentValues contentValues = new ContentValues();
            if (c0230t.m1063e()) {
                C0222l a3 = C0222l.m1007a(context);
                int i = a3.f973b;
                contentValues.put(NoteMajorColumns.NOTE, a3.m1018c(a2));
                contentValues.put(NoteMajorColumns.ENCRYPTION, Integer.valueOf(i));
            } else {
                contentValues.put(NoteMajorColumns.NOTE, a2);
            }
            if (z) {
                a = C0229s.m1033a(c0230t.f1005d, 16, 16);
            } else {
                a = C0229s.m1033a(c0230t.f1005d, 0, 16);
            }
            contentValues.put(NoteMinorColumns.FLAGS, Integer.valueOf(a));
            context.getContentResolver().update(uri, contentValues, null, null);
            C0310g.m1618b(context, currentTimeMillis);
            C0332a.m1725a(context, uri);
        }
        query.close();
    }

    public static int m1034a(Context context) {
        Cursor query = context.getContentResolver().query(C0228r.f997a, null, "active_state = 0", null, null);
        if (query == null) {
            return -1;
        }
        int count = query.getCount();
        query.close();
        return count;
    }

    public static Uri m1040a(Context context, ContentValues contentValues) {
        return context.getContentResolver().insert(C0228r.f997a, contentValues);
    }

    public static void m1046a(Context context, Uri uri, String str) {
        ColorNote.m647a(context, "NOTE", "DELETE", "FROM", str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteMinorColumns.STATE, Integer.valueOf(16));
        contentValues.put(NoteMinorColumns.REMINDER_DATE, Integer.valueOf(0));
        context.getContentResolver().update(uri, contentValues, null, null);
        long currentTimeMillis = System.currentTimeMillis();
        C0310g.m1615a(context, uri);
        C0332a.m1725a(context, uri);
        C0310g.m1618b(context, currentTimeMillis);
        C0310g.m1619c(context, currentTimeMillis);
    }

    public static void m1041a(Context context, Uri uri) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteMinorColumns.STATE, Integer.valueOf(0));
        context.getContentResolver().update(uri, contentValues, null, null);
        C0332a.m1725a(context, uri);
    }

    public static void m1050b(Context context, Uri uri) {
        ColorNote.m646a(context, "NOTE", "ARCHIVE");
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteMinorColumns.SPACE, Integer.valueOf(16));
        contentValues.put(NoteMinorColumns.REMINDER_DATE, Integer.valueOf(0));
        context.getContentResolver().update(uri, contentValues, null, null);
        long currentTimeMillis = System.currentTimeMillis();
        C0310g.m1615a(context, uri);
        C0310g.m1619c(context, currentTimeMillis);
        C0310g.m1618b(context, currentTimeMillis);
    }

    public static void m1051c(Context context, Uri uri) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteMinorColumns.SPACE, Integer.valueOf(0));
        context.getContentResolver().update(uri, contentValues, null, null);
    }

    public static ContentValues m1035a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteMinorColumns.STATE, Integer.valueOf(32));
        contentValues.put(NoteMajorColumns.TITLE, "");
        contentValues.put(NoteMajorColumns.NOTE, "");
        contentValues.put(NoteMinorColumns.NOTE_EXT, "");
        contentValues.put(NoteMajorColumns.ENCRYPTION, Integer.valueOf(0));
        contentValues.put(NoteMinorColumns.REMINDER_DATE, Integer.valueOf(0));
        contentValues.put(NoteMinorColumns.REMINDER_BASE, Integer.valueOf(0));
        contentValues.put(NoteMinorColumns.REMINDER_LAST, Integer.valueOf(0));
        contentValues.put(NoteMinorColumns.REMINDER_REPEAT, Integer.valueOf(0));
        contentValues.put(NoteMinorColumns.REMINDER_TYPE, Integer.valueOf(0));
        contentValues.put(NoteMinorColumns.REMINDER_DURATION, Integer.valueOf(0));
        contentValues.put(NoteMinorColumns.REMINDER_OPTION, Integer.valueOf(0));
        return contentValues;
    }

    public static void m1052d(Context context, Uri uri) {
        context.getContentResolver().update(uri, C0229s.m1035a(), null, null);
        C0332a.m1725a(context, uri);
        long currentTimeMillis = System.currentTimeMillis();
        C0310g.m1615a(context, uri);
        C0310g.m1618b(context, currentTimeMillis);
        C0310g.m1619c(context, currentTimeMillis);
    }

    public static void m1049b(Context context) {
        C0231u.m1069a();
        try {
            NoteProvider.m889c(NoteProvider.m885b(context).m1074f());
            C0223m a = C0223m.m1021a(context);
            SQLiteDatabase writableDatabase = a.f985a.getWritableDatabase();
            writableDatabase.execSQL("DROP TABLE IF EXISTS widget;");
            a.f985a.onCreate(writableDatabase);
            context.getContentResolver().notifyChange(C0228r.f997a, null);
        } finally {
            C0231u.m1070b();
        }
    }

    public static Uri m1039a(Context context, int i, int i2, int i3, int i4, String str, String str2) {
        HashMap hashMap = new HashMap();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteMinorColumns.STATE, Integer.valueOf(i));
        contentValues.put(NoteMinorColumns.FLAGS, Integer.valueOf(0));
        contentValues.put(NoteMinorColumns.TYPE, Integer.valueOf(i2));
        contentValues.put(NoteMinorColumns.FOLDER, Integer.valueOf(i3));
        contentValues.put(NoteMinorColumns.NOTE_VERSION, Integer.valueOf(0));
        contentValues.put(NoteMinorColumns.COLOR, Integer.valueOf(i4));
        if (str != null) {
            contentValues.put(NoteMajorColumns.TITLE, str);
        }
        if (str2 != null) {
            contentValues.put(NoteMajorColumns.NOTE, str2);
        }
        return context.getContentResolver().insert(C0228r.f997a, contentValues);
    }

    public static Cursor m1053e(Context context, Uri uri) {
        return context.getContentResolver().query(uri, null, null, null, null);
    }

    public static Cursor m1037a(Context context, String str) {
        return context.getContentResolver().query(C0228r.f997a, null, "active_state = ? AND account_id = 0 AND folder_id = ? AND type = ? AND title = ?", new String[]{"256", "256", "256", str}, "created_date asc");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.database.Cursor m1038a(android.content.Context r6, boolean r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        /*
        r5 = 1;
        r4 = -1;
        r2 = 0;
        r3 = "active_state = 0 AND account_id = 0";
        if (r12 == r4) goto L_0x002d;
    L_0x0007:
        r0 = new java.lang.StringBuilder;
        r1 = "folder_id = ";
        r0.<init>(r1);
        r0 = r0.append(r12);
        r0 = r0.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r3);
        r3 = " AND ";
        r1 = r1.append(r3);
        r0 = r1.append(r0);
        r3 = r0.toString();
    L_0x002d:
        if (r13 == r4) goto L_0x0055;
    L_0x002f:
        r0 = new java.lang.StringBuilder;
        r1 = "space = ";
        r0.<init>(r1);
        r0 = r0.append(r13);
        r0 = r0.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r3);
        r3 = " AND ";
        r1 = r1.append(r3);
        r0 = r1.append(r0);
        r3 = r0.toString();
    L_0x0055:
        if (r9 != r5) goto L_0x007d;
    L_0x0057:
        r0 = new java.lang.StringBuilder;
        r1 = "color_index = ";
        r0.<init>(r1);
        r0 = r0.append(r10);
        r0 = r0.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r3);
        r3 = " AND ";
        r1 = r1.append(r3);
        r0 = r1.append(r0);
        r3 = r0.toString();
    L_0x007d:
        if (r11 == r4) goto L_0x00a5;
    L_0x007f:
        r0 = new java.lang.StringBuilder;
        r1 = "type = ";
        r0.<init>(r1);
        r0 = r0.append(r11);
        r0 = r0.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r3);
        r3 = " AND ";
        r1 = r1.append(r3);
        r0 = r1.append(r0);
        r3 = r0.toString();
    L_0x00a5:
        switch(r8) {
            case 1: goto L_0x00b7;
            case 2: goto L_0x00bd;
            case 3: goto L_0x00c0;
            case 4: goto L_0x00e0;
            case 5: goto L_0x00ba;
            case 6: goto L_0x00a8;
            case 7: goto L_0x00f5;
            default: goto L_0x00a8;
        };
    L_0x00a8:
        r5 = r2;
    L_0x00a9:
        if (r7 == 0) goto L_0x010b;
    L_0x00ab:
        r0 = r6.getContentResolver();
        r1 = com.socialnmobile.colornote.data.C0228r.f1000d;
        r4 = r2;
        r0 = r0.query(r1, r2, r3, r4, r5);
    L_0x00b6:
        return r0;
    L_0x00b7:
        r5 = "modified_date DESC";
        goto L_0x00a9;
    L_0x00ba:
        r5 = "created_date DESC";
        goto L_0x00a9;
    L_0x00bd:
        r5 = "title ASC";
        goto L_0x00a9;
    L_0x00c0:
        r0 = "pref_sort_order_in_color";
        r1 = 2131231064; // 0x7f080158 float:1.8078198E38 double:1.052968052E-314;
        r1 = r6.getString(r1);
        r0 = com.socialnmobile.colornote.data.C0212b.m936a(r6, r0, r1);
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r0.intValue();
        r1 = 2;
        if (r0 != r1) goto L_0x00db;
    L_0x00d8:
        r5 = "color_index ASC, title ASC";
        goto L_0x00a9;
    L_0x00db:
        if (r0 != r5) goto L_0x00a8;
    L_0x00dd:
        r5 = "color_index ASC, modified_date DESC";
        goto L_0x00a9;
    L_0x00e0:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r3);
        r1 = " AND reminder_date > 0";
        r0 = r0.append(r1);
        r3 = r0.toString();
        r5 = r2;
        goto L_0x00a9;
    L_0x00f5:
        r5 = "reminder_last DESC";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r3);
        r1 = " AND reminder_last > 0";
        r0 = r0.append(r1);
        r3 = r0.toString();
        goto L_0x00a9;
    L_0x010b:
        r0 = r6.getContentResolver();
        r1 = com.socialnmobile.colornote.data.C0228r.f997a;
        r4 = r2;
        r0 = r0.query(r1, r2, r3, r4, r5);
        goto L_0x00b6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.data.s.a(android.content.Context, boolean, int, int, int, int, int, int):android.database.Cursor");
    }

    public static Cursor m1036a(Context context, long j) {
        return context.getContentResolver().query(C0228r.f997a, null, "reminder_type = 16 AND reminder_date = " + C0313j.m1633a(j) + " AND active_state = 0", null, "color_index ASC, reminder_repeat DESC, modified_date DESC");
    }

    public static boolean m1054f(Context context, Uri uri) {
        int i = 0;
        Cursor e = C0229s.m1053e(context, uri);
        try {
            if (e.moveToNext()) {
                ContentValues contentValues = new ContentValues();
                C0449a[] c0449aArr = NoteColumns.f909a;
                int length = c0449aArr.length;
                while (i < length) {
                    C0449a c0449a = c0449aArr[i];
                    c0449a.m2248a(contentValues, c0449a.m2246a(e).m2261c());
                    i++;
                }
                contentValues.remove("_id");
                contentValues.remove(NoteMinorColumns.CREATED_DATE);
                contentValues.remove(NoteMajorColumns.MODIFIED_DATE);
                C0229s.m1040a(context, contentValues);
                return true;
            } else if (e == null) {
                return false;
            } else {
                e.close();
                return false;
            }
        } finally {
            if (e != null) {
                e.close();
            }
        }
    }
}
