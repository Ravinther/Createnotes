package com.socialnmobile.colornote.sync.p015a;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.socialnmobile.colornote.sync.a.g */
public final class C0341g implements HttpRequestInterceptor, HttpResponseInterceptor {
    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (!httpRequest.containsHeader("Accept-Encoding")) {
            httpRequest.addHeader("Accept-Encoding", "gzip");
        }
    }

    public final void process(HttpResponse httpResponse, HttpContext httpContext) {
        HttpEntity entity = httpResponse.getEntity();
        Header contentEncoding = entity.getContentEncoding();
        if (contentEncoding != null) {
            for (HeaderElement name : contentEncoding.getElements()) {
                if (name.getName().equalsIgnoreCase("gzip")) {
                    httpResponse.setEntity(new C0340f(entity));
                }
            }
        }
    }
}
