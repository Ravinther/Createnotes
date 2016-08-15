package android.support.v4.p002c;

import java.io.PrintWriter;

/* renamed from: android.support.v4.c.n */
public final class C0059n {
    private static final Object f264a;
    private static char[] f265b;

    static {
        f264a = new Object();
        f265b = new char[24];
    }

    private static int m266a(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    private static int m267a(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        if (!z && i <= 0) {
            return i2;
        }
        int i4;
        int i5;
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
            i5 = i;
        } else {
            i5 = i / 100;
            cArr[i2] = (char) (i5 + 48);
            i4 = i2 + 1;
            i5 = i - (i5 * 100);
        }
        if ((z && i3 >= 2) || i5 > 9 || i2 != i4) {
            int i6 = i5 / 10;
            cArr[i4] = (char) (i6 + 48);
            i4++;
            i5 -= i6 * 10;
        }
        cArr[i4] = (char) (i5 + 48);
        i4++;
        cArr[i4] = c;
        return i4 + 1;
    }

    public static void formatDuration(long j, PrintWriter printWriter, int i) {
        synchronized (f264a) {
            int i2;
            if (f265b.length < i) {
                f265b = new char[i];
            }
            char[] cArr = f265b;
            int i3;
            if (j == 0) {
                i3 = i - 1;
                while (i3 > 0) {
                    cArr[0] = ' ';
                }
                cArr[0] = '0';
                i2 = 1;
            } else {
                char c;
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                if (j > 0) {
                    c = '+';
                } else {
                    j = -j;
                    c = '-';
                }
                int i9 = (int) (j % 1000);
                int floor = (int) Math.floor((double) (j / 1000));
                i3 = 0;
                if (floor > 86400) {
                    i3 = floor / 86400;
                    floor -= 86400 * i3;
                }
                if (floor > 3600) {
                    i4 = floor / 3600;
                    i5 = i4;
                    i4 = floor - (i4 * 3600);
                } else {
                    i5 = 0;
                    i4 = floor;
                }
                if (i4 > 60) {
                    i6 = i4 / 60;
                    i7 = i6;
                    i8 = i4 - (i6 * 60);
                } else {
                    i7 = 0;
                    i8 = i4;
                }
                i6 = 0;
                if (i != 0) {
                    floor = C0059n.m266a(i3, 1, false, 0);
                    floor += C0059n.m266a(i5, 1, floor > 0, 2);
                    floor += C0059n.m266a(i7, 1, floor > 0, 2);
                    floor += C0059n.m266a(i8, 1, floor > 0, 2);
                    i4 = (C0059n.m266a(i9, 2, true, floor > 0 ? 3 : 0) + 1) + floor;
                    while (i4 < i) {
                        cArr[i6] = ' ';
                        i4++;
                        i6++;
                    }
                }
                cArr[i6] = c;
                i4 = i6 + 1;
                Object obj = i != 0 ? 1 : null;
                int a = C0059n.m267a(cArr, i3, 'd', i4, false, 0);
                a = C0059n.m267a(cArr, i5, 'h', a, a != i4, obj != null ? 2 : 0);
                a = C0059n.m267a(cArr, i7, 'm', a, a != i4, obj != null ? 2 : 0);
                int a2 = C0059n.m267a(cArr, i8, 's', a, a != i4, obj != null ? 2 : 0);
                int i10 = (obj == null || a2 == i4) ? 0 : 3;
                i3 = C0059n.m267a(cArr, i9, 'm', a2, true, i10);
                cArr[i3] = 's';
                i2 = i3 + 1;
            }
            printWriter.print(new String(f265b, 0, i2));
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter) {
        C0059n.formatDuration(j, printWriter, 0);
    }

    public static void formatDuration(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            C0059n.formatDuration(j - j2, printWriter, 0);
        }
    }
}
