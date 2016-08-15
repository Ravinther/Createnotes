package com.socialnmobile.colornote.sync.p019c;

import com.socialnmobile.colornote.sync.p018b.C0361e;

/* renamed from: com.socialnmobile.colornote.sync.c.f */
public class C0373f extends C0361e {
    private C0373f(String str) {
        m1833a("jsonrpc", (Object) "2.0");
        m1833a("method", (Object) str);
        m1833a("id", null);
    }

    public C0373f(String str, C0361e c0361e) {
        this(str);
        m1833a("params", (Object) c0361e);
    }
}
