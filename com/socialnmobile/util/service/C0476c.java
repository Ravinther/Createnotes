package com.socialnmobile.util.service;

import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.util.p014a.C0439h;

/* renamed from: com.socialnmobile.util.service.c */
final class C0476c implements C0439h {
    final /* synthetic */ ServiceJob f2280a;
    final /* synthetic */ JobService f2281b;

    C0476c(JobService jobService, ServiceJob serviceJob) {
        this.f2281b = jobService;
        this.f2280a = serviceJob;
    }

    public final void m2331a(Object obj) {
        this.f2280a.onJobResult(obj);
        if (this.f2280a.listener != null) {
            this.f2280a.listener.onFinished(obj);
        }
    }

    public final void m2330a(Exception exception) {
        if (!this.f2280a.onJobException(exception)) {
            if (this.f2280a.listener != null) {
                this.f2280a.listener.onException(exception);
            } else {
                exception.printStackTrace();
            }
            if (exception instanceof RuntimeException) {
                try {
                    C0311h.f1370a.f1371b.m856a((Throwable) exception);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void m2329a() {
        this.f2280a.onJobFinally();
    }
}
