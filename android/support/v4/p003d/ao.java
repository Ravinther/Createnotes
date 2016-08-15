package android.support.v4.p003d;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* renamed from: android.support.v4.d.ao */
public final class ao {
    static final ar f269a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 18) {
            f269a = new as();
        } else if (i >= 14) {
            f269a = new aq();
        } else if (i >= 11) {
            f269a = new ap();
        } else {
            f269a = new at();
        }
    }

    public static void m291a(ViewGroup viewGroup, boolean z) {
        f269a.m292a(viewGroup, z);
    }
}
