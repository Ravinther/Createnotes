package com.socialnmobile.util.service;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

/* renamed from: com.socialnmobile.util.service.e */
public final class C0478e extends C0354c {
    public final /* synthetic */ void m2333a(Object obj, Object obj2) {
        StackTraceElement stackTraceElement = (StackTraceElement) obj;
        C0361e c0361e = (C0361e) obj2;
        c0361e.m1833a("class", stackTraceElement.getClassName());
        c0361e.m1833a("file", stackTraceElement.getFileName());
        c0361e.m1833a("line", Integer.valueOf(stackTraceElement.getLineNumber()));
        c0361e.m1833a("method", stackTraceElement.getMethodName());
        c0361e.m1833a("native", Boolean.valueOf(stackTraceElement.isNativeMethod()));
    }

    public final /* synthetic */ Object m2332a(Object obj) {
        throw new UnsupportedOperationException();
    }
}
