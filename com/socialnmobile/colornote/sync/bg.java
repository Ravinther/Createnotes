package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.p011b.p017b.C0463f;
import java.util.Calendar;
import java.util.TimeZone;

public final class bg {
    static long f1554b;
    public static final TimeZone f1555c;
    public static final bi f1556d;
    public static final bh f1557e;
    public final long f1558a;

    public bg(long j) {
        this.f1558a = j;
    }

    public final String toString() {
        return "DateTime(" + ((String) f1556d.m1782c(this)) + ")";
    }

    public final int hashCode() {
        return ((int) (this.f1558a ^ (this.f1558a >>> 32))) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.f1558a != ((bg) obj).f1558a) {
            return false;
        }
        return true;
    }

    public static bg m1891a() {
        if (f1554b != 0) {
            return new bg(f1554b);
        }
        return new bg(Calendar.getInstance(f1555c).getTime().getTime());
    }

    static {
        f1554b = 0;
        f1555c = C0463f.f2256a;
        f1556d = new bi();
        f1557e = new bh();
    }
}
