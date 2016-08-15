package com.flurry.android.monolithic.sdk.impl;

import android.location.Criteria;

public final class ao {
    public static final Integer f449a;
    public static final String f450b;
    public static final Boolean f451c;
    public static final Boolean f452d;
    public static final String f453e;
    public static final Boolean f454f;
    public static final Criteria f455g;
    public static final Long f456h;
    public static final Boolean f457i;
    public static final Long f458j;
    public static final Byte f459k;
    private static ap f460l;

    static {
        f449a = Integer.valueOf(151);
        f450b = null;
        f451c = Boolean.valueOf(true);
        f452d = Boolean.valueOf(false);
        f453e = null;
        f454f = Boolean.valueOf(true);
        f455g = null;
        f456h = Long.valueOf(10000);
        f457i = Boolean.valueOf(true);
        f458j = Long.valueOf(0);
        f459k = Byte.valueOf((byte) -1);
    }

    public static synchronized ap m552a() {
        ap apVar;
        synchronized (ao.class) {
            if (f460l == null) {
                apVar = new ap();
                f460l = apVar;
                apVar.m555a("AgentVersion", f449a);
                f460l.m555a("VesionName", f450b);
                f460l.m555a("CaptureUncaughtExceptions", f451c);
                f460l.m555a("UseHttps", f452d);
                f460l.m555a("ReportUrl", f453e);
                f460l.m555a("ReportLocation", f454f);
                f460l.m555a("LocationCriteria", f455g);
                f460l.m555a("ContinueSessionMillis", f456h);
                f460l.m555a("LogEvents", f457i);
                f460l.m555a("Age", f458j);
                f460l.m555a("Gender", f459k);
                f460l.m555a("UserId", (Object) "");
            }
            apVar = f460l;
        }
        return apVar;
    }
}
