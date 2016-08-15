package android.support.v4.p003d;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.d.aj */
public final class aj {
    static final am f268a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f268a = new al();
        } else {
            f268a = new ak();
        }
    }

    public static int m286a(ViewConfiguration viewConfiguration) {
        return f268a.m287a(viewConfiguration);
    }
}
