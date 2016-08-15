package com.socialnmobile.colornote.sync.p015a;

import org.apache.http.HttpVersion;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* renamed from: com.socialnmobile.colornote.sync.a.d */
public final class C0338d extends DefaultHttpClient {
    static final C0341g f1470a;
    static final C0342h f1471b;
    static final C0346l f1472c;

    static {
        f1470a = new C0341g();
        f1471b = new C0342h();
        f1472c = new C0346l();
    }

    public C0338d(String str) {
        HttpParams params = getParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        HttpProtocolParams.setUseExpectContinue(params, false);
        HttpProtocolParams.setUserAgent(params, "gzip " + C0336b.m1750a(str));
        setParams(params);
        addRequestInterceptor(f1470a);
        addResponseInterceptor(f1470a);
        addRequestInterceptor(f1471b);
        addResponseInterceptor(f1472c);
    }
}
