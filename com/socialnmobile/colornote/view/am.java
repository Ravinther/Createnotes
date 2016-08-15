package com.socialnmobile.colornote.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.widget.C0092f;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

final class am extends C0092f {
    float f2028a;
    float f2029b;
    float f2030c;
    float f2031d;
    private long f2032e;
    private float f2033f;
    private final Interpolator f2034g;
    private int f2035h;

    public am(Context context) {
        super(context);
        this.f2035h = 0;
        context.getResources();
        this.f2034g = new DecelerateInterpolator();
    }

    public final void m2162a(int i, int i2) {
    }

    public final boolean m2163a() {
        return this.f2035h == 0;
    }

    public final boolean m2164a(float f) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f2035h != 4 || ((float) (currentAnimationTimeMillis - this.f2032e)) >= this.f2033f) {
            this.f2035h = 1;
            this.f2032e = currentAnimationTimeMillis;
            this.f2033f = 167.0f;
            this.f2031d += f;
            this.f2028a = this.f2031d;
            this.f2030c = this.f2031d;
        }
        return true;
    }

    public final boolean m2166b() {
        this.f2031d = 0.0f;
        if (this.f2035h != 1 && this.f2035h != 4) {
            return m2163a();
        }
        this.f2035h = 3;
        this.f2029b = this.f2028a;
        this.f2030c = 0.0f;
        this.f2032e = AnimationUtils.currentAnimationTimeMillis();
        this.f2033f = 200.0f;
        return m2163a();
    }

    public final boolean m2165a(Canvas canvas) {
        float min = Math.min(((float) (AnimationUtils.currentAnimationTimeMillis() - this.f2032e)) / this.f2033f, 1.0f);
        float interpolation = this.f2034g.getInterpolation(min);
        if (this.f2035h == 3) {
            this.f2028a = (interpolation * (this.f2030c - this.f2029b)) + this.f2029b;
        }
        if (min >= 0.999f) {
            switch (this.f2035h) {
                case 3:
                    this.f2035h = 0;
                    break;
            }
        }
        if (this.f2035h != 0) {
            return true;
        }
        return false;
    }
}
