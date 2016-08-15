package com.flurry.android.monolithic.sdk.impl;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

public final class an extends RelativeLayout {
    private static final String f445a;
    private final String f446b;
    private final ViewGroup f447c;
    private long f448d;

    static {
        f445a = an.class.getSimpleName();
    }

    public final long getRotationRateInMilliseconds() {
        return this.f448d;
    }

    public final ViewGroup getViewGroup() {
        return this.f447c;
    }

    public final String getAdSpace() {
        return this.f446b;
    }

    private ac getCurrentBannerView() {
        if (getChildCount() <= 0) {
            return null;
        }
        try {
            return (ac) getChildAt(0);
        } catch (ClassCastException e) {
            return null;
        }
    }
}
