package com.socialnmobile.colornote.sync.p015a;

import java.util.Locale;
import org.apache.http.HttpHost;

/* renamed from: com.socialnmobile.colornote.sync.a.m */
public final class C0347m implements C0345k {
    boolean f1477a;
    final String f1478b;
    final String f1479c;

    public C0347m() {
        this.f1477a = Locale.getDefault().getCountry().equals(Locale.CHINA.getCountry());
        this.f1478b = "proxy.colornote.com";
        this.f1479c = "colornote-server";
    }

    public final HttpHost m1758a() {
        return m1756a(false);
    }

    public final HttpHost m1759b() {
        return m1756a(true);
    }

    private HttpHost m1756a(boolean z) {
        if (this.f1477a) {
            return C0347m.m1757a(z, "proxy.colornote.com");
        }
        String str = "colornote-server";
        if (z) {
            str = "api." + str + ".appspot.com";
        } else {
            str = "api-dot-" + str + ".appspot.com";
        }
        return C0347m.m1757a(z, str);
    }

    private static HttpHost m1757a(boolean z, String str) {
        if (z) {
            return new HttpHost(str);
        }
        return new HttpHost(str, 443, "https");
    }
}
