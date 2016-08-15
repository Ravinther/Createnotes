package com.socialnmobile.colornote.sync.jobs;

import com.socialnmobile.colornote.sync.am;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.socialnmobile.colornote.sync.jobs.b */
final class C0392b implements HttpRequestInterceptor {
    final /* synthetic */ am f1787a;
    final /* synthetic */ SyncJob f1788b;

    C0392b(SyncJob syncJob, am amVar) {
        this.f1788b = syncJob;
        this.f1787a = amVar;
    }

    public final void process(HttpRequest httpRequest, HttpContext httpContext) {
        this.f1787a.m1776a(httpRequest);
    }
}
