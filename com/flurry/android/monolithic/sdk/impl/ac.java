package com.flurry.android.monolithic.sdk.impl;

import android.widget.RelativeLayout;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;

public abstract class ac extends RelativeLayout {
    private static final String f381e;
    FlurryAdModule f382a;
    bl f383b;
    AdUnit f384c;
    int f385d;

    static {
        f381e = ac.class.getSimpleName();
    }

    public bl getAdLog() {
        return this.f383b;
    }

    public void setAdLog(bl blVar) {
        this.f383b = blVar;
    }

    public void setPlatformModule(FlurryAdModule flurryAdModule) {
        this.f382a = flurryAdModule;
    }

    public AdUnit getAdUnit() {
        return this.f384c;
    }

    public void setAdUnit(AdUnit adUnit) {
        this.f384c = adUnit;
    }

    public int getAdFrameIndex() {
        return this.f385d;
    }

    public void setAdFrameIndex(int i) {
        this.f385d = i;
    }
}
