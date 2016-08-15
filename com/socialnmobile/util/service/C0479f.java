package com.socialnmobile.util.service;

import com.socialnmobile.colornote.sync.p018b.C0360d;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* renamed from: com.socialnmobile.util.service.f */
public final class C0479f extends C0354c {
    public static final C0479f f2283a;
    final C0478e f2284b;

    public C0479f() {
        this.f2284b = new C0478e();
    }

    public final /* synthetic */ void m2335a(Object obj, Object obj2) {
        Throwable th = (Throwable) obj;
        C0361e c0361e = (C0361e) obj2;
        c0361e.m1833a("string", th.toString());
        c0361e.m1833a("class", th.getClass().getName());
        c0361e.m1833a("message", th.getMessage());
        Throwable cause = th.getCause();
        if (cause != null) {
            c0361e.m1834a("cause", cause, this);
        }
        String str = "stacktrace";
        StackTraceElement[] stackTrace = th.getStackTrace();
        Object c0360d = new C0360d();
        for (Object c : stackTrace) {
            c0360d.add(this.f2284b.m1782c(c));
        }
        c0361e.m1833a(str, c0360d);
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        c0361e.m1833a("stacktrace_printed", stringWriter.getBuffer().toString());
    }

    static {
        f2283a = new C0479f();
    }

    public final /* synthetic */ Object m2334a(Object obj) {
        throw new UnsupportedOperationException();
    }
}
