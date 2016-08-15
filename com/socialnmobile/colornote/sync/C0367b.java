package com.socialnmobile.colornote.sync;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0231u;
import com.socialnmobile.colornote.data.C0232v;
import com.socialnmobile.colornote.data.NoteProvider;
import com.socialnmobile.colornote.data.aa;
import com.socialnmobile.colornote.sync.p018b.C0360d;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p020d.C0376a;
import com.socialnmobile.colornote.sync.p020d.C0377b;
import com.socialnmobile.util.p011b.C0473n;
import java.util.UUID;

/* renamed from: com.socialnmobile.colornote.sync.b */
public final class C0367b extends C0366d {
    final Context f1540a;
    public final C0231u f1541b;
    final C0404t f1542c;

    public static boolean m1868a(Context context) {
        return C0367b.m1871c(context) != null;
    }

    public static boolean m1870b(Context context) {
        return C0367b.m1871c(context) == null ? false : false;
    }

    public static C0367b m1866a(Context context, C0231u c0231u) {
        C0367b c = C0367b.m1872c(context, c0231u);
        if (c == null || c.m1864l()) {
            return null;
        }
        return c;
    }

    public static C0367b m1869b(Context context, C0231u c0231u) {
        C0367b c = C0367b.m1872c(context, c0231u);
        if (c == null || !c.m1864l()) {
            return null;
        }
        return c;
    }

    public static boolean m1873d(Context context) {
        C0367b c = C0367b.m1871c(context);
        if (c != null && new aa(c.f1541b).m913b() > 0) {
            return true;
        }
        return false;
    }

    private static C0367b m1872c(Context context, C0231u c0231u) {
        ContentValues a = new C0404t(c0231u).m2056a(null);
        if (a != null) {
            return new C0367b(context, c0231u, a);
        }
        return null;
    }

    private C0367b(Context context, C0231u c0231u, ContentValues contentValues) {
        this.f1540a = context;
        this.f1541b = c0231u;
        this.f1542c = new C0404t(c0231u);
        m1850c(contentValues);
        this.x.m2013a(context);
    }

    static C0367b m1867a(Context context, C0231u c0231u, C0376a c0376a, C0377b c0377b) {
        C0367b c0367b = new C0367b(context, c0231u, new ContentValues());
        c0367b.p.m2008a(Long.valueOf(0));
        c0367b.n.m2008a(UUID.randomUUID());
        c0367b.m1855b(c0376a, c0377b);
        c0367b.m1856d();
        c0367b.m1859g();
        C0232v f = c0367b.f1541b.m1074f();
        f.f1027a.beginTransaction();
        try {
            long j;
            long h = c0367b.m1860h();
            ContentValues n = c0367b.m1852n();
            C0404t c0404t = c0367b.f1542c;
            if (n.getAsLong("_id") == null) {
                ColorNote.m651a("insert into SyncAccount requires explicit _ID");
                j = -1;
            } else {
                j = c0404t.f1817a.m1074f().m1078a("SyncAccount", AccountColumns.COLORNOTE_ID, n);
            }
            if (j == h) {
                ContentValues a = c0367b.f1542c.m2056a(c0367b.m1879b());
                if (a != null) {
                    if (!a.containsKey("_id")) {
                        C0311h.f1370a.m1622a("Account _id is missing", "", (C0361e) C0383e.f1774a.m1782c(c0367b));
                    }
                    c0367b.m1850c(a);
                    c0367b.m1856d();
                    c0367b.m1859g();
                    f.f1027a.setTransactionSuccessful();
                    n = c0367b.f1542c.m2056a(c0367b.m1879b());
                    C0366d c0366d = new C0366d();
                    c0366d.m1850c(n);
                    c0366d.m1856d();
                    c0366d.m1859g();
                    return c0367b;
                }
            }
            C0311h.f1370a.m1622a("Account insert failed", "DB table insert failed", (C0361e) C0383e.f1774a.m1782c(c0367b));
            throw new RuntimeException("Account insert failed");
        } finally {
            f.f1027a.endTransaction();
        }
    }

    final void m1877a(C0376a c0376a, C0377b c0377b) {
        m1855b(c0376a, c0377b);
        m1880c();
    }

    public final C0375c m1875a() {
        return new C0375c(this);
    }

    public final void m1876a(long j) {
        C0375c a = m1875a();
        a.p.m2008a(Long.valueOf(j));
        if (a.m1941a()) {
            this.p.m2008a(Long.valueOf(j));
        }
    }

    final C0473n m1879b() {
        return new C0473n("_id=?", Long.valueOf(m1860h()));
    }

    final boolean m1878a(ContentValues contentValues) {
        C0232v f = this.f1541b.m1074f();
        f.f1027a.beginTransaction();
        try {
            if (this.f1542c.m2055a(contentValues, m1879b()) == 1) {
                f.f1027a.setTransactionSuccessful();
                return true;
            }
            f.f1027a.endTransaction();
            return false;
        } finally {
            f.f1027a.endTransaction();
        }
    }

    public final void m1880c() {
        m1858f();
        C0232v f = this.f1541b.m1074f();
        f.f1027a.beginTransaction();
        try {
            if (this.f1542c.m2055a(m1852n(), m1879b()) == 1) {
                ContentValues a = this.f1542c.m2056a(m1879b());
                if (!a.containsKey("_id")) {
                    C0311h.f1370a.m1622a("Account _id is missing", "", (C0361e) C0383e.f1774a.m1782c(this));
                }
                C0366d c0366d = new C0366d();
                c0366d.m1850c(a);
                c0366d.m1858f();
                f.f1027a.setTransactionSuccessful();
                ContentValues a2 = this.f1542c.m2056a(m1879b());
                C0366d c0366d2 = new C0366d();
                c0366d2.m1850c(a2);
                c0366d2.m1858f();
                return;
            }
            C0311h.f1370a.m1622a("Account update failed", "DB table update failed", (C0361e) C0383e.f1774a.m1782c(this));
            throw new RuntimeException("Account update failed");
        } finally {
            f.f1027a.endTransaction();
        }
    }

    public final C0360d m1874a(C0473n c0473n) {
        aa aaVar = new aa(this.f1541b);
        C0360d c0360d = new C0360d();
        Cursor a = aaVar.m911a(new String[]{"_id", SyncIndexColumns.UUID, SyncIndexColumns.REVISION}, c0473n);
        if (a != null) {
            int i = 0;
            while (i < a.getCount()) {
                try {
                    Object c0361e;
                    if (a.moveToPosition(i)) {
                        boolean z;
                        c0361e = new C0361e();
                        c0361e.m1833a("_id", Long.valueOf(a.getLong(0)));
                        String str = SyncIndexColumns.UUID;
                        if (a.getString(1) != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c0361e.m1833a(str, Boolean.valueOf(z));
                        c0361e.m1833a("rev", Long.valueOf(a.getLong(2)));
                    } else {
                        c0361e = null;
                    }
                    c0360d.add(c0361e);
                    i++;
                } finally {
                    a.close();
                }
            }
        }
        return c0360d;
    }

    public static C0367b m1871c(Context context) {
        C0367b c = C0367b.m1872c(context, NoteProvider.m885b(context));
        if (c == null || c.m1864l()) {
            return null;
        }
        return c;
    }
}
