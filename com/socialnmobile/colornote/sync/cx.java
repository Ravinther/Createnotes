package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.util.p011b.p021a.C0450a;
import com.socialnmobile.util.p011b.p021a.C0454c;
import com.socialnmobile.util.p011b.p021a.C0456e;
import com.socialnmobile.util.p011b.p021a.C0458g;

public interface cx extends NoteMinorColumns {
    public static final C0454c f1666a;
    public static final C0454c f1667b;
    public static final C0454c f1668c;
    public static final C0454c f1669d;
    public static final C0454c f1670e;
    public static final C0454c f1671f;
    public static final C0454c f1672g;
    public static final C0456e f1673h;
    public static final C0456e f1674i;
    public static final C0454c f1675j;
    public static final C0450a f1676k;
    public static final C0450a f1677l;
    public static final C0458g f1678m;
    public static final C0458g f1679n;
    public static final C0454c f1680o;
    public static final C0456e f1681p;
    public static final C0456e f1682q;
    public static final C0456e f1683r;
    public static final C0454c f1684s;
    public static final C0454c f1685t;
    public static final C0456e f1686u;
    public static final C0454c f1687v;

    static {
        f1666a = new C0454c(NoteMinorColumns.STATE);
        f1667b = new C0454c(NoteMinorColumns.FOLDER);
        f1668c = new C0454c(NoteMinorColumns.FLAGS);
        f1669d = new C0454c(NoteMinorColumns.SPACE);
        f1670e = new C0454c(NoteMinorColumns.IMPORTANCE);
        f1671f = new C0454c(NoteMinorColumns.TYPE);
        f1672g = new C0454c(NoteMinorColumns.COLOR);
        f1673h = new C0456e(NoteMinorColumns.CREATED_DATE);
        f1674i = new C0456e(NoteMinorColumns.MINOR_MODIFIED_DATE);
        f1675j = new C0454c(NoteMinorColumns.NOTE_VERSION);
        f1676k = new C0450a(NoteMinorColumns.LATITUDE);
        f1677l = new C0450a(NoteMinorColumns.LONGITUDE);
        f1678m = new C0458g(NoteMinorColumns.TAGS);
        f1679n = new C0458g(NoteMinorColumns.NOTE_EXT);
        f1680o = new C0454c(NoteMinorColumns.REMINDER_TYPE);
        f1681p = new C0456e(NoteMinorColumns.REMINDER_DATE);
        f1682q = new C0456e(NoteMinorColumns.REMINDER_BASE);
        f1683r = new C0456e(NoteMinorColumns.REMINDER_LAST);
        f1684s = new C0454c(NoteMinorColumns.REMINDER_OPTION);
        f1685t = new C0454c(NoteMinorColumns.REMINDER_REPEAT);
        f1686u = new C0456e(NoteMinorColumns.REMINDER_REPEAT_END);
        f1687v = new C0454c(NoteMinorColumns.REMINDER_DURATION);
    }
}
