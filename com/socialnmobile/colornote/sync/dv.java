package com.socialnmobile.colornote.sync;

import android.database.Cursor;
import android.os.Build;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0232v;
import com.socialnmobile.colornote.data.aa;
import com.socialnmobile.colornote.sync.p018b.C0360d;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.C0473n;
import java.util.Iterator;

public final class dv {
    final dt f1766a;

    dv(dt dtVar) {
        this.f1766a = dtVar;
    }

    public final Object m2003a(String str, C0361e c0361e) {
        Object c0361e2;
        if (str == null) {
            return null;
        }
        if (str.equals("forcetostop")) {
            this.f1766a.f1761i = true;
            return null;
        } else if (str.equals("session_params")) {
            Number g = c0361e.m1841g("MAX_CHECKINS_PER_REQUEST");
            if (g != null) {
                this.f1766a.f1764l.m1833a("MAX_CHECKINS_PER_REQUEST", Integer.valueOf(g.intValue()));
            }
            g = c0361e.m1841g("DEBUG");
            if (g == null) {
                return null;
            }
            this.f1766a.f1764l.m1833a("DEBUG", Integer.valueOf(g.intValue()));
            return null;
        } else if (str.equals("buildinfo")) {
            c0361e2 = new C0361e();
            try {
                c0361e2.m1833a("BOARD", Build.BOARD);
                c0361e2.m1833a("BRAND", Build.BRAND);
                c0361e2.m1833a("DEVICE", Build.DEVICE);
                c0361e2.m1833a("DISPLAY", Build.DISPLAY);
                c0361e2.m1833a("FINGERPRINT", Build.FINGERPRINT);
                c0361e2.m1833a("ID", Build.ID);
                c0361e2.m1833a("MODEL", Build.MODEL);
                c0361e2.m1833a("PRODUCT", Build.PRODUCT);
                return c0361e2;
            } catch (Exception e) {
                return c0361e2;
            }
        } else if (str.equals("note_indexes")) {
            return this.f1766a.f1754b.m1874a(null);
        } else {
            if (str.equals("note_indexes_with_id0")) {
                return this.f1766a.f1754b.m1874a(new C0473n("_id=0", new String[0]));
            }
            Object h;
            Object a;
            if (str.equals("sql_query")) {
                h = c0361e.m1842h("sql");
                if (h == null) {
                    return "sql is null";
                }
                a = m2002a(this.f1766a.f1754b.f1541b.m1074f(), h, new String[0]);
                c0361e2 = new C0361e();
                c0361e2.m1833a("sql", h);
                c0361e2.m1833a("result", a);
                return c0361e2;
            } else if (str.equals("sql_insert")) {
                h = c0361e.m1842h("sql");
                if (h == null) {
                    return "sql is null";
                }
                a = Long.valueOf(this.f1766a.f1754b.f1541b.m1074f().m1082b(h));
                c0361e2 = new C0361e();
                c0361e2.m1833a("sql", h);
                c0361e2.m1833a("result", a);
                return c0361e2;
            } else if (str.equals("sql_exec")) {
                h = c0361e.m1842h("sql");
                if (h == null) {
                    return "sql is null";
                }
                a = Integer.valueOf(this.f1766a.f1754b.f1541b.m1074f().m1077a((String) h, new Object[0]));
                c0361e2 = new C0361e();
                c0361e2.m1833a("sql", h);
                c0361e2.m1833a("result", a);
                return c0361e2;
            } else if (str.equals("full_checkin")) {
                return Integer.valueOf(new aa(this.f1766a.f1754b.f1541b).m908a(null));
            } else {
                if (!str.equals("report_installed_packages")) {
                    return null;
                }
                C0361e c0361e3 = new C0361e();
                Iterator it = c0361e.m1843i("packages").iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    c0361e3.m1833a(str2, Boolean.valueOf(C0313j.m1651a(this.f1766a.f1754b.f1540a, str2)));
                }
                return c0361e3;
            }
        }
    }

    private static Object m2002a(C0232v c0232v, String str, String[] strArr) {
        Cursor a = c0232v.m1079a(str, strArr);
        if (a == null) {
            return "can't execute sql: " + str;
        }
        try {
            int i;
            Object c0360d = new C0360d();
            for (i = 0; i < a.getColumnCount(); i++) {
                c0360d.add(a.getColumnName(i));
            }
            Object c0360d2 = new C0360d();
            for (int i2 = 0; i2 < a.getCount(); i2++) {
                if (a.moveToPosition(i2)) {
                    C0360d c0360d3 = new C0360d();
                    for (i = 0; i < a.getColumnCount(); i++) {
                        c0360d3.add(a.getString(i));
                    }
                    c0360d2.add(c0360d3);
                } else {
                    c0360d2.add("row " + i2 + " is not acccessible");
                }
            }
            Object c0361e = new C0361e();
            c0361e.m1833a("columns", c0360d);
            c0361e.m1833a("rows", c0360d2);
            return c0361e;
        } finally {
            a.close();
        }
    }
}
