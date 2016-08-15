package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.k */
public final class C0097k {
    Object f311a;
    C0098l f312b;

    public static C0097k m425a(Context context, Interpolator interpolator) {
        return new C0097k(context, interpolator);
    }

    private C0097k(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    private C0097k(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f312b = new C0101o();
        } else if (i >= 9) {
            this.f312b = new C0100n();
        } else {
            this.f312b = new C0099m();
        }
        this.f311a = this.f312b.m427a(context, interpolator);
    }

    public final void m426a() {
        this.f312b.m433e(this.f311a);
    }
}
