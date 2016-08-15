package android.support.v4.p003d;

import android.os.Build.VERSION;
import android.view.View;

/* renamed from: android.support.v4.d.w */
public final class C0085w {
    static final af f273a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            f273a = new ae();
        } else if (i >= 17) {
            f273a = new ad();
        } else if (i >= 16) {
            f273a = new ac();
        } else if (i >= 14) {
            f273a = new ab();
        } else if (i >= 11) {
            f273a = new aa();
        } else if (i >= 9) {
            f273a = new C0063z();
        } else {
            f273a = new C0061x();
        }
    }

    public static boolean m357a(View view, int i) {
        return f273a.m270a(view, i);
    }

    public static void m356a(View view) {
        f273a.m269a(view);
    }

    public static void m359b(View view, int i) {
        f273a.m272b(view, i);
    }

    public static int m358b(View view) {
        return f273a.m271b(view);
    }
}
