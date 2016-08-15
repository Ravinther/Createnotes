package android.support.v4.p003d;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* renamed from: android.support.v4.d.r */
public final class C0080r {
    static final C0081u f272a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f272a = new C0083t();
        } else {
            f272a = new C0082s();
        }
    }

    public static float m346a(VelocityTracker velocityTracker, int i) {
        return f272a.m348a(velocityTracker, i);
    }

    public static float m347b(VelocityTracker velocityTracker, int i) {
        return f272a.m349b(velocityTracker, i);
    }
}
