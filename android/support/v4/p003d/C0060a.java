package android.support.v4.p003d;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.d.a */
public final class C0060a {
    static final C0064b f266a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f266a = new C0066d();
        } else {
            f266a = new C0065c();
        }
    }

    public static int m268a(int i, int i2) {
        return f266a.m296a(i, i2);
    }
}
