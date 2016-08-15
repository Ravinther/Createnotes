package com.socialnmobile.colornote.sync.p015a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.socialnmobile.colornote.sync.a.c */
public final class C0337c implements HttpRequestInterceptor {
    final Header f1469a;

    public C0337c(Context context) {
        String str = "ColorNote " + C0337c.m1751a(context);
        String str2 = "X-COLORNOTE-AGENT";
        this.f1469a = new BasicHeader(str2, str + '/' + ("android-" + VERSION.SDK_INT));
    }

    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        httpRequest.addHeader(this.f1469a);
    }

    private static String m1751a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return "UNKNOWN";
        }
    }
}
