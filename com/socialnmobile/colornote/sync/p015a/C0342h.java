package com.socialnmobile.colornote.sync.p015a;

import java.util.Locale;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.socialnmobile.colornote.sync.a.h */
public final class C0342h implements HttpRequestInterceptor {
    final String f1473a;
    final String f1474b;

    public C0342h() {
        this.f1473a = Locale.getDefault().getCountry();
        this.f1474b = Locale.getDefault().getLanguage();
    }

    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        httpRequest.addHeader(new BasicHeader("Accept-Language", this.f1474b + "-" + this.f1473a));
    }
}
