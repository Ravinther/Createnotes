package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Map;

/* renamed from: com.flurry.android.monolithic.sdk.impl.e */
public final class C0120e {
    public final String f517a;
    public final Map f518b;
    public final Context f519c;
    public final AdUnit f520d;
    public final bl f521e;
    public final int f522f;

    public C0120e(String str, Map map, Context context, AdUnit adUnit, bl blVar, int i) {
        this.f517a = str;
        this.f518b = map;
        this.f519c = context;
        this.f520d = adUnit;
        this.f521e = blVar;
        this.f522f = i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("event=").append(this.f517a);
        stringBuilder.append(",params=").append(this.f518b);
        stringBuilder.append(",adspace=").append(this.f520d.b());
        return stringBuilder.toString();
    }
}
