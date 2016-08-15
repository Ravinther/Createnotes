package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: android.support.v4.app.u */
final class C0036u implements AnimationListener {
    final /* synthetic */ C0015f f212a;
    final /* synthetic */ C0033r f213b;

    C0036u(C0033r c0033r, C0015f c0015f) {
        this.f213b = c0033r;
        this.f212a = c0015f;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.f212a.f71k != null) {
            this.f212a.f71k = null;
            this.f213b.m187a(this.f212a, this.f212a.f72l, 0, 0, false);
        }
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
