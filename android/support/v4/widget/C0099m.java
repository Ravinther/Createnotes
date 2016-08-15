package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* renamed from: android.support.v4.widget.m */
final class C0099m implements C0098l {
    C0099m() {
    }

    public final Object m436a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    public final boolean m438a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public final int m439b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public final int m440c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public final boolean m441d(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public final void m437a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public final void m442e(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public final int m443f(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public final int m444g(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
