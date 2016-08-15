package com.flurry.android.monolithic.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.android.C0115a;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.android.monolithic.sdk.impl.f */
public class C0121f implements ah, aq, bi, UncaughtExceptionHandler {
    private static final String f523d;
    private static C0121f f524e;
    public ad f525a;
    public Map f526b;
    public C0127l f527c;
    private String f528f;
    private boolean f529g;

    static {
        f523d = C0121f.class.getSimpleName();
    }

    private C0121f() {
        this.f528f = "";
        this.f526b = new HashMap();
        jc.m611a().m613a((bi) this);
        ba a = ba.m576a();
        synchronized (a.f496b) {
            a.f496b.put(this, null);
        }
        ap a2 = ao.m552a();
        this.f529g = ((Boolean) a2.m553a("CaptureUncaughtExceptions")).booleanValue();
        a2.m554a("CaptureUncaughtExceptions", (aq) this);
        bh.m584a(4, "initSettings, CrashReportingEnabled = " + this.f529g);
        String str = (String) a2.m553a("VesionName");
        a2.m554a("VesionName", (aq) this);
        az.m574a(str);
        bh.m584a(4, "initSettings, VersionName = " + str);
    }

    public final void m604a(String str, Object obj) {
        if (str.equals("CaptureUncaughtExceptions")) {
            this.f529g = ((Boolean) obj).booleanValue();
            bh.m584a(4, "onSettingUpdate, CrashReportingEnabled = " + this.f529g);
        } else if (str.equals("VesionName")) {
            String str2 = (String) obj;
            az.m574a(str2);
            bh.m584a(4, "onSettingUpdate, VersionName = " + str2);
        } else {
            bh.m584a(6, "onSettingUpdate internal error!");
        }
    }

    public static C0121f m598a() {
        if (f524e == null) {
            f524e = new C0121f();
        }
        return f524e;
    }

    public static int m600b() {
        int intValue = ((Integer) ao.m552a().m553a("AgentVersion")).intValue();
        bh.m584a(4, "getAgentVersion() = " + intValue);
        return intValue;
    }

    public static Map m599a(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        Bundle extras = ((Activity) context).getIntent().getExtras();
        if (extras == null) {
            return null;
        }
        bh.m584a(3, "Launch Options Bundle is present " + extras.toString());
        Map hashMap = new HashMap();
        for (String str : extras.keySet()) {
            if (str != null) {
                Object obj = extras.get(str);
                hashMap.put(str, new ArrayList(Arrays.asList(new String[]{obj != null ? obj.toString() : "null"})));
                bh.m584a(3, "Launch options Key: " + str + ". Its value: " + r1);
            }
        }
        return hashMap;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        th.printStackTrace();
        if (this.f529g) {
            String str = "";
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                if (th.getMessage() != null) {
                    stringBuilder.append(" (" + th.getMessage() + ")\n");
                }
                str = stringBuilder.toString();
            } else if (th.getMessage() != null) {
                str = th.getMessage();
            }
            C0115a.m513a("uncaught", str, th);
        }
        for (ad adVar : new HashMap(this.f526b).values()) {
            if (adVar != null) {
                adVar.m533a();
            }
        }
        av a = av.m561a();
        a.f480e = 0;
        a.m568e();
    }

    public static int m601c() {
        return 0;
    }

    public static Location m602d() {
        av a = av.m561a();
        Location location = null;
        if (a.f479d) {
            location = a.m563a(a.m569f());
            if (location != null) {
                a.f477b = location;
            }
            location = a.f477b;
        }
        String str = av.f475a;
        bh.m584a(4, "getLocation() = " + location);
        return location;
    }

    public final void m605a(boolean z) {
    }

    public final void m603a(String str) {
        if (this.f526b.containsKey(str)) {
            ad adVar = this.f525a;
            if (adVar != null && TextUtils.equals(adVar.f403b, str)) {
                this.f525a = null;
            }
            this.f526b.remove(str);
        } else {
            bh.m584a(6, "Ended session is not in the session map! Maybe it was already destroyed.");
        }
        if (this.f526b.isEmpty()) {
            bh.m584a(5, "LocationProvider is going to be unsubscribed");
            av.m561a().m567d();
        }
    }
}
