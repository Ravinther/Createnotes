package com.socialnmobile.colornote.p013g;

import android.content.Context;
import com.socialnmobile.colornote.data.C0212b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.socialnmobile.colornote.g.g */
public final class C0309g {
    static SimpleDateFormat f1362e;
    static final long[] f1363g;
    static final long[] f1364h;
    public int f1365a;
    public int f1366b;
    public int f1367c;
    public boolean f1368d;
    long[] f1369f;

    static {
        f1362e = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");
        f1363g = new long[]{19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42448, 83315, 21200, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46496, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22208, 43959, 9680, 37584, 51893, 43344, 46240, 111779, 46416, 21977, 19360, 42416, 38261, 21168, 43344, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19415, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448};
        f1364h = new long[]{19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42448, 83315, 21200, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46496, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19415, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448};
    }

    private final int m1598b(int i) {
        int i2 = 348;
        for (int i3 = 32768; i3 > 8; i3 >>= 1) {
            if ((this.f1369f[i - 1900] & ((long) i3)) != 0) {
                i2++;
            }
        }
        return i2 + m1599c(i);
    }

    private final int m1599c(int i) {
        if (m1601a(i) == 0) {
            return 0;
        }
        if ((this.f1369f[i - 1900] & 65536) != 0) {
            return 30;
        }
        return 29;
    }

    public final int m1601a(int i) {
        return (int) (this.f1369f[i - 1900] & 15);
    }

    public final int m1602a(int i, int i2) {
        if ((this.f1369f[i - 1900] & ((long) (65536 >> i2))) == 0) {
            return 29;
        }
        return 30;
    }

    public C0309g(Context context) {
        if ("KR".equals(C0212b.m951k(context))) {
            this.f1369f = f1363g;
        } else {
            this.f1369f = f1364h;
        }
    }

    public C0309g(Context context, long j, int i) {
        if ("KR".equals(C0212b.m951k(context))) {
            this.f1369f = f1363g;
        } else {
            this.f1369f = f1364h;
        }
        int d = (int) ((j - C0309g.m1600d(i)) / 86400000);
        int i2 = 1900;
        int i3 = 0;
        while (i2 < 2050 && d > 0) {
            i3 = m1598b(i2);
            d -= i3;
            i2++;
        }
        if (d < 0) {
            d += i3;
            i2--;
        }
        this.f1365a = i2;
        int a = m1601a(i2);
        this.f1368d = false;
        int i4 = 0;
        i2 = 1;
        i3 = d;
        while (i2 < 13 && i3 > 0) {
            if (a <= 0 || i2 != a + 1 || this.f1368d) {
                d = m1602a(this.f1365a, i2);
            } else {
                i2--;
                this.f1368d = true;
                d = m1599c(this.f1365a);
            }
            i3 -= d;
            if (this.f1368d && i2 == a + 1) {
                this.f1368d = false;
            }
            i2++;
            i4 = d;
        }
        if (i3 != 0 || a <= 0 || i2 != a + 1) {
            d = i2;
        } else if (this.f1368d) {
            this.f1368d = false;
            d = i2;
        } else {
            this.f1368d = true;
            d = i2 - 1;
        }
        if (i3 < 0) {
            i2 = i3 + i4;
            d--;
        } else {
            i2 = i3;
        }
        this.f1366b = d;
        this.f1367c = i2 + 1;
    }

    public final long m1603a(int i, int i2, boolean z, int i3) {
        long d = C0309g.m1600d(i3);
        for (int i4 = 1900; i4 < i; i4++) {
            d += ((long) m1598b(i4)) * 86400000;
        }
        int a = m1601a(i);
        long j = d;
        int i5 = 1;
        while (i5 < i2) {
            j += ((long) m1602a(i, i5)) * 86400000;
            if (a > 0 && i5 == a) {
                j += ((long) m1599c(i)) * 86400000;
            }
            i5++;
        }
        if (z) {
            return j + (((long) m1602a(i, i2)) * 86400000);
        }
        return j;
    }

    public final Object[] m1604a(int i, int i2, boolean z, long j) {
        boolean z2;
        int a;
        int a2 = m1601a(i);
        if (i2 == a2 && !z) {
            z2 = true;
            a = m1602a(i, i2);
            a2 = i2;
        } else if (i2 == a2 && z) {
            i2++;
            z2 = false;
            a = m1599c(i);
            a2 = i2;
        } else {
            z2 = false;
            a = m1602a(i, i2);
            a2 = i2 + 1;
        }
        if (a2 > 12) {
            i++;
            a2 = 1;
        }
        long j2 = (((long) a) * 86400000) + j;
        return new Object[]{Integer.valueOf(i), Integer.valueOf(a2), Boolean.valueOf(z2), Long.valueOf(j2)};
    }

    private static long m1600d(int i) {
        if (i == 1) {
            return -2206396800000L;
        }
        Date date = null;
        try {
            date = f1362e.parse("1900\u5e741\u670831\u65e5");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
