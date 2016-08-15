package com.flurry.android;

import android.content.Context;
import android.os.SystemClock;
import com.flurry.android.monolithic.sdk.impl.C0121f;
import com.flurry.android.monolithic.sdk.impl.C0127l;
import com.flurry.android.monolithic.sdk.impl.ad;
import com.flurry.android.monolithic.sdk.impl.ae;
import com.flurry.android.monolithic.sdk.impl.am;
import com.flurry.android.monolithic.sdk.impl.ao;
import com.flurry.android.monolithic.sdk.impl.av;
import com.flurry.android.monolithic.sdk.impl.bh;
import com.flurry.android.monolithic.sdk.impl.jc;
import java.util.Map;

/* renamed from: com.flurry.android.a */
public final class C0115a {
    private static final String f361a;

    static {
        f361a = C0115a.class.getSimpleName();
    }

    public static int m510a() {
        C0121f.m598a();
        return C0121f.m600b();
    }

    public static void m515b() {
        bh.m583a();
    }

    public static void m516c() {
        bh.m591c();
    }

    public static void m517d() {
        ao.m552a().m555a("CaptureUncaughtExceptions", Boolean.valueOf(false));
    }

    public static void m512a(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("Null context");
        } else if (str.length() == 0) {
            throw new IllegalArgumentException("Api key not specified");
        } else {
            am.m551a(context);
            try {
                ad adVar;
                Object a = C0121f.m598a();
                jc.m611a().m614b();
                av.m561a().m565b();
                if (a.f527c == null) {
                    a.f527c = new C0127l();
                }
                if (a.f526b.isEmpty()) {
                    av.m561a().m566c();
                }
                if (a.f526b.containsKey(str)) {
                    adVar = (ad) a.f526b.get(str);
                } else {
                    adVar = new ad(context, str, a);
                    adVar.f409h = C0121f.m599a(context);
                    a.f526b.put(str, adVar);
                }
                if (adVar.f410i.m550b()) {
                    adVar.f410i.m548a();
                }
                adVar.f411j++;
                String str2;
                if (adVar.f412k) {
                    str2 = ad.f386a;
                    bh.m584a(5, "Continuing previous session");
                    if (!adVar.f405d.isEmpty()) {
                        adVar.f405d.remove(adVar.f405d.size() - 1);
                    }
                } else {
                    str2 = ad.f386a;
                    bh.m584a(5, "Start session");
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    adVar.f406e = System.currentTimeMillis();
                    adVar.f407f = elapsedRealtime;
                    adVar.m534a(new ae(adVar));
                    adVar.f412k = true;
                }
                a.f525a = adVar;
            } catch (Throwable th) {
                bh.m586a("", th);
            }
        }
    }

    public static void m511a(Context context) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        try {
            ad adVar = C0121f.m598a().f525a;
            if (adVar != null) {
                String str = ad.f386a;
                bh.m584a(5, "Trying to end session");
                if (adVar.f412k) {
                    if (adVar.f411j > 0) {
                        adVar.f411j--;
                    }
                    if (adVar.f411j == 0) {
                        adVar.f410i.m549a(adVar.f408g);
                    }
                }
            }
        } catch (Throwable th) {
            bh.m586a("", th);
        }
    }

    public static void m514a(String str, Map map) {
        if (str == null) {
            bh.m589b("String eventId passed to logEvent was null.");
        } else if (map == null) {
            bh.m589b("String parameters passed to logEvent was null.");
        } else {
            try {
                ad adVar = C0121f.m598a().f525a;
                if (adVar != null) {
                    adVar.m537a(str, map);
                }
            } catch (Throwable th) {
                bh.m586a("Failed to log event: " + str, th);
            }
        }
    }

    public static void m513a(String str, String str2, Throwable th) {
        if (str2 == null) {
            bh.m589b("String message passed to onError was null.");
        } else if (th == null) {
            bh.m589b("Throwable passed to onError was null.");
        } else {
            try {
                ad adVar = C0121f.m598a().f525a;
                if (adVar != null) {
                    adVar.m536a(str, str2, th.getClass().getName(), th);
                }
            } catch (Throwable th2) {
                bh.m586a("", th2);
            }
        }
    }
}
