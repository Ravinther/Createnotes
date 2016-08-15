package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.sync.p018b.C0361e;

public final class da {
    public static final da f1723a;

    public static void m1987a(cz czVar, C0361e c0361e) {
        if (((Integer) czVar.f1692a.m2010c()).intValue() == 0) {
            throw new IllegalArgumentException("reminder.type should not be NONE");
        }
        c0361e.m1833a(NoteMinorColumns.TYPE, Integer.valueOf(((Integer) czVar.f1692a.m2010c()).intValue()));
        c0361e.m1834a("when", (bg) czVar.f1693b.m2010c(), bg.f1556d);
        c0361e.m1834a("base", (bg) czVar.f1694c.m2010c(), bg.f1556d);
        c0361e.m1834a("last", (bg) czVar.f1695d.m2010c(), bg.f1556d);
        c0361e.m1833a("repeat", Integer.valueOf(((Integer) czVar.f1697f.m2010c()).intValue()));
        c0361e.m1834a("repeat_end", (bg) czVar.f1699h.m2010c(), bg.f1556d);
        c0361e.m1833a("option", Integer.valueOf(((Integer) czVar.f1696e.m2010c()).intValue()));
        c0361e.m1833a("duration", Integer.valueOf(((Integer) czVar.f1698g.m2010c()).intValue()));
    }

    public static void m1988b(cz czVar, C0361e c0361e) {
        if (c0361e == null) {
            czVar.f1692a.m2008a(Integer.valueOf(0));
            czVar.m1981a();
            return;
        }
        try {
            int intValue = c0361e.m1837c(NoteMinorColumns.TYPE).intValue();
            czVar.f1692a.m2008a(Integer.valueOf(intValue));
            if (intValue == 0) {
                czVar.m1981a();
                return;
            }
            czVar.f1693b.m2008a((bg) c0361e.m1831a("when", bg.f1556d));
            czVar.f1694c.m2008a((bg) c0361e.m1831a("base", bg.f1556d));
            czVar.f1695d.m2008a((bg) c0361e.m1831a("last", bg.f1556d));
            czVar.f1697f.m2008a(Integer.valueOf(c0361e.m1837c("repeat").intValue()));
            czVar.f1699h.m2008a((bg) c0361e.m1831a("repeat_end", bg.f1556d));
            czVar.f1696e.m2008a(Integer.valueOf(c0361e.m1837c("option").intValue()));
            czVar.f1698g.m2008a(Integer.valueOf(c0361e.m1837c("duration").intValue()));
            czVar.m1981a();
        } catch (Throwable e) {
            throw new cl(e);
        } catch (Throwable e2) {
            throw new cl(e2);
        }
    }

    static {
        f1723a = new da();
    }
}
