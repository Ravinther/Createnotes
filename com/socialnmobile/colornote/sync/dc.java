package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

public abstract class dc extends C0354c {
    final String f1614f;
    final String f1615g;
    final String f1616h;

    public abstract db m1946a(String str, int i, bg bgVar, C0361e c0361e);

    public final /* synthetic */ Object m1947a(Object obj) {
        C0361e c0361e = (C0361e) obj;
        return m1946a(m1948a(c0361e), m1951b(c0361e), m1945c(c0361e), c0361e);
    }

    public dc(String str, String str2, String str3) {
        this.f1614f = str;
        this.f1615g = str2;
        this.f1616h = str3;
    }

    public void m1949a(db dbVar, C0361e c0361e) {
        c0361e.m1833a(this.f1614f, dbVar.f1611b);
        c0361e.m1833a(this.f1615g, Integer.valueOf(dbVar.f1612c));
        if (this.f1616h != null) {
            c0361e.m1834a(this.f1616h, dbVar.f1613d, bg.f1556d);
        }
    }

    public String m1948a(C0361e c0361e) {
        return c0361e.m1838d(this.f1614f);
    }

    public int m1951b(C0361e c0361e) {
        try {
            return c0361e.m1837c(this.f1615g).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    private bg m1945c(C0361e c0361e) {
        if (this.f1616h == null) {
            return null;
        }
        try {
            return (bg) bg.f1556d.m1783d(c0361e.m1842h(this.f1616h));
        } catch (cl e) {
            return null;
        }
    }
}
