package com.socialnmobile.colornote.sync.p015a;

import android.content.Context;
import com.socialnmobile.colornote.data.C0231u;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.am;
import com.socialnmobile.colornote.sync.dg;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.socialnmobile.colornote.sync.a.a */
public final class C0335a implements HttpRequestInterceptor {
    final Context f1460a;
    final C0231u f1461b;
    final dg f1462c;

    public C0335a(Context context, C0231u c0231u) {
        this.f1462c = new dg();
        this.f1460a = context;
        this.f1461b = c0231u;
    }

    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        am j;
        C0367b a = C0367b.m1866a(this.f1460a, this.f1461b);
        if (a != null) {
            j = a.m1862j();
        } else {
            j = null;
        }
        if (j != null) {
            j.m1776a(httpRequest);
        }
    }
}
