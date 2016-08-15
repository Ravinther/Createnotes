package com.socialnmobile.colornote.sync.p019c;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.util.EntityUtils;

/* renamed from: com.socialnmobile.colornote.sync.c.d */
public final class C0371d implements C0370c {
    final HttpClient f1594a;
    final HttpHost f1595b;
    final String f1596c;

    public C0371d(HttpClient httpClient, HttpHost httpHost, String str) {
        this.f1594a = httpClient;
        this.f1595b = httpHost;
        this.f1596c = str;
    }

    public final C0374g m1937a(C0373f c0373f) {
        return C0371d.m1934a(m1935a(m1936b(c0373f)));
    }

    private HttpEntityEnclosingRequest m1936b(C0373f c0373f) {
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", this.f1596c, HttpVersion.HTTP_1_1);
        try {
            HttpEntity stringEntity = new StringEntity(c0373f.toString(), "UTF-8");
            stringEntity.setContentType("application/json");
            basicHttpEntityEnclosingRequest.setEntity(stringEntity);
            return basicHttpEntityEnclosingRequest;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private HttpResponse m1935a(HttpRequest httpRequest) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpResponse execute = this.f1594a.execute(this.f1595b, httpRequest);
            return execute;
        } finally {
            new StringBuilder("HTTP request time: ").append(Long.toString(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private static C0374g m1934a(HttpResponse httpResponse) {
        StatusLine statusLine = httpResponse.getStatusLine();
        if (statusLine.getStatusCode() >= 400) {
            throw new IOException(statusLine.toString());
        }
        try {
            return C0374g.m1939k(EntityUtils.toString(httpResponse.getEntity()));
        } catch (Throwable e) {
            throw new C0372e("failed to parse HTTP Response: " + e.getMessage(), e);
        }
    }
}
