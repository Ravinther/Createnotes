package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* renamed from: android.support.v4.widget.p */
final class C0102p {
    public static Object m454a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static boolean m456a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static int m457b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m458c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m459d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m455a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void m460e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m461f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m462g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
