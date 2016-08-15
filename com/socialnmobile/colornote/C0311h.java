package com.socialnmobile.colornote;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.socialnmobile.colornote.p008b.C0191a;
import com.socialnmobile.colornote.p008b.C0194c;
import com.socialnmobile.colornote.sync.p018b.C0357a;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import java.net.URISyntaxException;
import org.json.JSONObject;

/* renamed from: com.socialnmobile.colornote.h */
public final class C0311h {
    public static C0311h f1370a;
    public C0191a f1371b;

    C0311h(Context context) {
        try {
            this.f1371b = new C0191a(context, "googleplay-release", "http://event-collector-colornote.appspot.com");
            C0191a c0191a = this.f1371b;
            c0191a.f863g = new C0194c(c0191a, Thread.getDefaultUncaughtExceptionHandler());
            Thread.setDefaultUncaughtExceptionHandler(c0191a.f863g);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
        }
    }

    public final void m1621a(String str) {
        this.f1371b.m853a(str);
    }

    public final void m1624a(String str, Throwable th) {
        try {
            this.f1371b.m855a("EXCEPTION", th, str, th.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void m1625a(String str, Throwable th, C0361e c0361e) {
        try {
            this.f1371b.m855a("EXCEPTION", th, str, (JSONObject) C0357a.m1823b(c0361e));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void m1623a(String str, String str2, String str3) {
        try {
            this.f1371b.m854a("DEBUG", str2, str, (Object) str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void m1626b(String str, String str2, String str3) {
        try {
            this.f1371b.m854a("ERROR", str2, str, (Object) str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void m1622a(String str, String str2, C0361e c0361e) {
        try {
            this.f1371b.m854a("ERROR", str2, str, (JSONObject) C0357a.m1823b(c0361e));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
