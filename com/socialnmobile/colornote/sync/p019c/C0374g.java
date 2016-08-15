package com.socialnmobile.colornote.sync.p019c;

import com.socialnmobile.colornote.sync.cl;
import com.socialnmobile.colornote.sync.p018b.C0358b;
import com.socialnmobile.colornote.sync.p018b.C0361e;

/* renamed from: com.socialnmobile.colornote.sync.c.g */
public final class C0374g extends C0361e {
    private C0374g(C0361e c0361e) {
        super(c0361e);
    }

    public static C0374g m1939k(String str) {
        C0361e a = C0361e.m1830a(str);
        a.m1842h("jsonrpc");
        try {
            a.m1835b("id");
            try {
                a.m1835b("result");
                return new C0374g(a);
            } catch (C0358b e) {
                try {
                    a.m1839e("error");
                    return new C0374g(a);
                } catch (Throwable e2) {
                    throw new cl(e2);
                }
            }
        } catch (Throwable e22) {
            throw new cl(e22);
        }
    }

    public final Object m1940a() {
        try {
            return m1835b("result");
        } catch (C0358b e) {
            C0369b b = m1938b();
            if (b != null) {
                throw b;
            }
            throw new C0372e("not null expected: error");
        }
    }

    private C0369b m1938b() {
        C0361e j = m1844j("error");
        if (j == null) {
            return null;
        }
        try {
            return C0369b.m1932a(j);
        } catch (Throwable e) {
            throw new C0372e(e);
        } catch (Throwable e2) {
            throw new C0372e(e2);
        }
    }
}
