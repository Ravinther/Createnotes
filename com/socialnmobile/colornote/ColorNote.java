package com.socialnmobile.colornote;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.Log;
import com.flurry.android.C0115a;
import com.socialnmobile.colornote.data.C0210a;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.ad;
import com.socialnmobile.colornote.receiver.AutoSyncReceiver;
import com.socialnmobile.colornote.sync.ay;
import com.socialnmobile.colornote.sync.bb;
import com.socialnmobile.colornote.sync.cd;
import com.socialnmobile.colornote.sync.cl;
import com.socialnmobile.colornote.sync.p015a.C0347m;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class ColorNote extends Application {
    static String f598a;
    static ColorNote f599b;
    Handler f600c;
    public cd f601d;

    public ColorNote() {
        this.f600c = new Handler();
    }

    public static void m651a(String str) {
        Log.e("ColorNote", str);
    }

    private static void m650a(Context context, Map map) {
        if (context != null && f598a == null) {
            long b = C0210a.m899b(context, "APP_INSTALL_TIME_MILLIS");
            if (b != 0) {
                new Time().set(b);
                f598a = String.format(Locale.US, "%d-%02d", new Object[]{Integer.valueOf(r2.year), Integer.valueOf(r2.month + 1)});
            }
        }
        if (f598a != null) {
            map.put("installMonth", f598a);
        }
    }

    public static void m646a(Context context, String str, String str2) {
        try {
            Map hashMap = new HashMap();
            m650a(context, hashMap);
            C0115a.m514a(str + " " + str2, hashMap);
        } catch (RuntimeException e) {
        }
    }

    public static void m648a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            Map hashMap = new HashMap();
            hashMap.put(str3, str4);
            hashMap.put(str5, str6);
            m649a(context, str, str2, hashMap);
        } catch (RuntimeException e) {
        }
    }

    public static void m647a(Context context, String str, String str2, String str3, String str4) {
        try {
            Map hashMap = new HashMap();
            hashMap.put(str3, str4);
            m649a(context, str, str2, hashMap);
        } catch (RuntimeException e) {
        }
    }

    public static void m649a(Context context, String str, String str2, Map map) {
        try {
            m650a(context, map);
            C0115a.m514a(str + " " + str2, map);
        } catch (RuntimeException e) {
        }
    }

    public static String m645a(long j) {
        return DateUtils.formatDateTime(f599b, j, 17);
    }

    public void onCreate() {
        f599b = this;
        super.onCreate();
        if (C0311h.f1370a == null) {
            C0311h.f1370a = new C0311h(this);
        }
        C0311h.f1370a.m1621a("com.socialnmobile.colornote");
        C0311h.f1370a.m1621a("com.github.nkzawa");
        this.f601d = new cd(this.f600c);
        ad.m925a(new Handler());
        C0313j.m1643a();
        getContentResolver().getType(C0228r.f997a);
        C0115a.m517d();
        C0115a.m516c();
        C0115a.m515b();
    }

    public static ColorNote m644a() {
        return f599b;
    }

    public static void m653b(String str) {
        if (f599b != null && f599b.f600c != null) {
            f599b.f600c.post(new C0199b(str));
        }
    }

    public static void m652b() {
        new C0201c().execute(new String[0]);
    }

    public static void m654c() {
        ad.m924a();
        C0310g.m1610a(f599b);
        AutoSyncReceiver.m1714a(f599b);
    }

    static void m655d() {
        Context context = f599b;
        long b = C0210a.m899b(context, "CLIENT_RELEASES_SAVE_TIME");
        if (b == 0) {
            b = C0210a.m899b(context, "APP_INSTALL_TIME_MILLIS");
        }
        if (System.currentTimeMillis() - b > 1296000000 && b != 0) {
            try {
                ay ayVar;
                HttpEntity entity = new bb(f599b).m1887b().execute(new C0347m().m1755b(), new HttpGet("/support/client-releases-v8")).getEntity();
                if (entity == null) {
                    ayVar = null;
                } else {
                    String entityUtils = EntityUtils.toString(entity);
                    if (entityUtils == null) {
                        ayVar = null;
                    } else {
                        C0361e a = ay.m1811a(entityUtils);
                        if (a == null) {
                            ayVar = null;
                        } else {
                            ayVar = new ay(a);
                        }
                    }
                }
                if (ayVar != null) {
                    C0210a.m896a(f599b, ayVar);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (cl e2) {
                e2.printStackTrace();
            } catch (RuntimeException e3) {
                e3.printStackTrace();
            }
        }
    }
}
