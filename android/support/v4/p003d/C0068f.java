package android.support.v4.p003d;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* renamed from: android.support.v4.d.f */
public final class C0068f {
    static final C0069j f270a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f270a = new C0072i();
        } else {
            f270a = new C0070g();
        }
    }

    public static boolean m301a(KeyEvent keyEvent, int i) {
        return f270a.m304a(keyEvent.getMetaState(), i);
    }

    public static boolean m300a(KeyEvent keyEvent) {
        return f270a.m305b(keyEvent.getMetaState());
    }

    public static void m302b(KeyEvent keyEvent) {
        f270a.m303a(keyEvent);
    }
}
