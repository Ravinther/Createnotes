package com.socialnmobile.colornote.sync.p015a;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.socialnmobile.colornote.sync.a.e */
public final class C0339e implements HttpResponseInterceptor {
    public final void process(HttpResponse httpResponse, HttpContext httpContext) {
        if ((System.currentTimeMillis() % 10 > 7 ? 1 : null) != null) {
            throw new IOException("Fake Connection Failed");
        }
    }
}
