package com.flurry.android.monolithic.sdk.impl;

import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;

public final class bg {
    private static SchemeRegistry f502a;

    static synchronized SchemeRegistry m582a() {
        SchemeRegistry schemeRegistry;
        synchronized (bg.class) {
            if (f502a != null) {
                schemeRegistry = f502a;
            } else {
                schemeRegistry = new SchemeRegistry();
                f502a = schemeRegistry;
                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                f502a.register(new Scheme("https", new be(), 443));
                schemeRegistry = f502a;
            }
        }
        return schemeRegistry;
    }
}
