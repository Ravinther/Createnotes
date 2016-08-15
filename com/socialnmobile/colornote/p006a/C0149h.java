package com.socialnmobile.colornote.p006a;

import android.app.Notification;
import android.app.Service;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: com.socialnmobile.colornote.a.h */
public final class C0149h {
    private static final Class[] f613i;
    private static final Class[] f614j;
    private static final Class[] f615k;
    public Method f616a;
    public Method f617b;
    public Method f618c;
    public Object[] f619d;
    public Object[] f620e;
    public Object[] f621f;
    public Service f622g;
    boolean f623h;

    static {
        f613i = new Class[]{Boolean.TYPE};
        f614j = new Class[]{Integer.TYPE, Notification.class};
        f615k = new Class[]{Boolean.TYPE};
    }

    public C0149h(Service service) {
        this.f619d = new Object[1];
        this.f620e = new Object[2];
        this.f621f = new Object[1];
        this.f623h = false;
        this.f622g = service;
        try {
            this.f617b = service.getClass().getMethod("startForeground", f614j);
            this.f618c = service.getClass().getMethod("stopForeground", f615k);
        } catch (NoSuchMethodException e) {
            this.f618c = null;
            this.f617b = null;
            try {
                this.f616a = service.getClass().getMethod("setForeground", f613i);
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("OS doesn't have Service.startForeground OR Service.setForeground!");
            }
        }
    }

    public final void m672a(Method method, Object[] objArr) {
        try {
            method.invoke(this.f622g, objArr);
        } catch (Throwable e) {
            Log.w("ColorNote", "Unable to invoke method", e);
        } catch (Throwable e2) {
            Log.w("ColorNote", "Unable to invoke method", e2);
        }
    }
}
