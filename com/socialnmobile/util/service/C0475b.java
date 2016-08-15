package com.socialnmobile.util.service;

import com.socialnmobile.util.p014a.C0390a;

/* renamed from: com.socialnmobile.util.service.b */
final class C0475b implements C0390a {
    final /* synthetic */ ServiceJob f2278a;
    final /* synthetic */ JobService f2279b;

    C0475b(JobService jobService, ServiceJob serviceJob) {
        this.f2279b = jobService;
        this.f2278a = serviceJob;
    }

    public final void m2327a() {
        if (this.f2278a.listener != null) {
            this.f2278a.listener.onInit();
        }
    }

    public final void m2328b() {
        if (this.f2278a.listener != null) {
            this.f2278a.listener.onFinalize();
        }
    }
}
