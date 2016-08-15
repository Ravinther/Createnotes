package com.socialnmobile.colornote.sync.p015a;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.HttpResponseException;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.socialnmobile.colornote.sync.a.l */
public final class C0346l implements HttpResponseInterceptor {
    public final void process(HttpResponse httpResponse, HttpContext httpContext) {
        if (httpResponse.getStatusLine().getStatusCode() >= 400) {
            throw new HttpResponseException(httpResponse.getStatusLine().getStatusCode(), httpResponse.getStatusLine().getReasonPhrase());
        }
    }
}
