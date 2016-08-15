package com.socialnmobile.colornote.data;

import android.content.Context;
import android.database.Cursor;
import android.text.format.Time;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.sync.SyncIndexColumns;
import java.security.GeneralSecurityException;

/* renamed from: com.socialnmobile.colornote.data.t */
public final class C0230t {
    public long f1002a;
    public int f1003b;
    public int f1004c;
    public int f1005d;
    public int f1006e;
    public int f1007f;
    public String f1008g;
    public long f1009h;
    public long f1010i;
    public int f1011j;
    public int f1012k;
    public long f1013l;
    public int f1014m;
    public int f1015n;
    public long f1016o;
    private String f1017p;
    private String f1018q;
    private long f1019r;
    private long f1020s;
    private long f1021t;
    private double f1022u;
    private double f1023v;

    public static long m1055a(int i, long j) {
        if (j <= 0) {
            return j;
        }
        if (i == 16) {
            Time time = new Time("UTC");
            time.set(j);
            Time time2 = new Time();
            time2.set(59, 59, 23, time.monthDay, time.month, time.year);
            return C0147f.m661a(time2, true);
        }
        time2 = new Time();
        time2.set(j);
        return C0147f.m661a(time2, false);
    }

    public C0230t(Cursor cursor) {
        m1058a(cursor);
    }

    public final void m1058a(Cursor cursor) {
        this.f1002a = cursor.getLong(cursor.getColumnIndex("_id"));
        this.f1003b = cursor.getInt(cursor.getColumnIndex(NoteMinorColumns.FOLDER));
        this.f1004c = cursor.getInt(cursor.getColumnIndex(NoteMinorColumns.STATE));
        this.f1005d = cursor.getInt(cursor.getColumnIndex(NoteMinorColumns.FLAGS));
        this.f1006e = cursor.getInt(cursor.getColumnIndex(NoteMinorColumns.SPACE));
        this.f1007f = cursor.getInt(cursor.getColumnIndex(NoteMinorColumns.TYPE));
        this.f1008g = cursor.getString(cursor.getColumnIndex(NoteMajorColumns.TITLE));
        this.f1017p = cursor.getString(cursor.getColumnIndex(NoteMajorColumns.NOTE));
        this.f1018q = cursor.getString(cursor.getColumnIndex(NoteMinorColumns.NOTE_EXT));
        this.f1009h = cursor.getLong(cursor.getColumnIndex(NoteMinorColumns.CREATED_DATE));
        this.f1010i = cursor.getLong(cursor.getColumnIndex(NoteMajorColumns.MODIFIED_DATE));
        this.f1011j = cursor.getInt(cursor.getColumnIndex(NoteMinorColumns.COLOR));
        this.f1012k = cursor.getInt(cursor.getColumnIndex(NoteMajorColumns.ENCRYPTION));
        this.f1019r = cursor.getLong(cursor.getColumnIndex(NoteMinorColumns.REMINDER_DATE));
        this.f1020s = cursor.getLong(cursor.getColumnIndex(NoteMinorColumns.REMINDER_BASE));
        this.f1013l = cursor.getLong(cursor.getColumnIndex(NoteMinorColumns.REMINDER_LAST));
        this.f1014m = cursor.getInt(cursor.getColumnIndex(NoteMinorColumns.REMINDER_TYPE));
        this.f1015n = cursor.getInt(cursor.getColumnIndex(NoteMinorColumns.REMINDER_REPEAT));
        this.f1021t = cursor.getLong(cursor.getColumnIndex(NoteMinorColumns.REMINDER_REPEAT_END));
        this.f1022u = cursor.getDouble(cursor.getColumnIndex(NoteMinorColumns.LATITUDE));
        this.f1023v = cursor.getDouble(cursor.getColumnIndex(NoteMinorColumns.LONGITUDE));
        this.f1016o = cursor.getLong(cursor.getColumnIndex(SyncIndexColumns.REVISION));
    }

    public final boolean m1059a() {
        return (this.f1005d & 16) != 0;
    }

    public final boolean m1060b() {
        return (this.f1005d & 4096) != 0;
    }

    public final String m1061c() {
        if (m1063e()) {
            return "";
        }
        return this.f1017p;
    }

    public final String m1062d() {
        if (m1063e()) {
            return "";
        }
        return this.f1017p.substring(0, Math.min(800, this.f1017p.length()));
    }

    public final String m1057a(Context context) {
        if (this.f1012k == 1) {
            return m1056a(null);
        }
        if (this.f1012k == 2) {
            return m1056a(C0213c.m964c(context));
        }
        return this.f1017p;
    }

    private String m1056a(String str) {
        String str2 = "";
        try {
            C0222l a = C0222l.m1006a(this.f1012k);
            if (this.f1012k == 1) {
                a.m1016a("ColorNote Password");
            } else {
                a.m1017b(str);
            }
            a.m1019c(2);
            return a.m1020d(this.f1017p);
        } catch (GeneralSecurityException e) {
            ColorNote.m651a("Error Decryption");
            return str2;
        }
    }

    public final boolean m1063e() {
        return this.f1012k != 0;
    }

    public final long m1064f() {
        return C0230t.m1055a(this.f1014m, this.f1020s);
    }

    public final long m1065g() {
        return C0230t.m1055a(this.f1014m, this.f1019r);
    }

    public final long m1066h() {
        return C0230t.m1055a(this.f1014m, this.f1013l);
    }

    public final long m1067i() {
        return C0230t.m1055a(this.f1014m, this.f1021t);
    }
}
