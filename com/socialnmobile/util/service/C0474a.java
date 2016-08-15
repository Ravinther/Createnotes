package com.socialnmobile.util.service;

import android.app.Notification;
import android.app.NotificationManager;
import com.socialnmobile.colornote.p006a.C0149h;
import com.socialnmobile.util.p014a.C0390a;

/* renamed from: com.socialnmobile.util.service.a */
public final class C0474a implements C0390a {
    final /* synthetic */ int f2275a;
    final /* synthetic */ Notification f2276b;
    final /* synthetic */ JobService f2277c;

    public C0474a(JobService jobService, Notification notification) {
        this.f2277c = jobService;
        this.f2275a = 20;
        this.f2276b = notification;
    }

    public final void m2325a() {
        C0149h c0149h = this.f2277c.f1453e;
        int i = this.f2275a;
        Notification notification = this.f2276b;
        if (c0149h.f617b != null) {
            c0149h.f620e[0] = Integer.valueOf(i);
            c0149h.f620e[1] = notification;
            c0149h.m672a(c0149h.f617b, c0149h.f620e);
            return;
        }
        c0149h.f619d[0] = Boolean.TRUE;
        c0149h.m672a(c0149h.f616a, c0149h.f619d);
        ((NotificationManager) c0149h.f622g.getSystemService("notification")).notify(i, notification);
    }

    public final void m2326b() {
        C0149h c0149h = this.f2277c.f1453e;
        int i = this.f2275a;
        if (c0149h.f618c != null) {
            c0149h.f621f[0] = Boolean.TRUE;
            c0149h.m672a(c0149h.f618c, c0149h.f621f);
            return;
        }
        ((NotificationManager) c0149h.f622g.getSystemService("notification")).cancel(i);
        c0149h.f619d[0] = Boolean.FALSE;
        c0149h.m672a(c0149h.f616a, c0149h.f619d);
    }
}
