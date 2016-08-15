package com.socialnmobile.util.p011b.p016c;

import com.socialnmobile.colornote.sync.cl;

/* renamed from: com.socialnmobile.util.b.c.b */
public abstract class C0352b implements C0351e {
    public abstract Object m1780a(Object obj);

    public abstract Object m1781b(Object obj);

    public final Object m1782c(Object obj) {
        if (obj == null) {
            return null;
        }
        return m1781b(obj);
    }

    public final Object m1783d(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return m1780a(obj);
        } catch (Throwable e) {
            throw new cl(e);
        }
    }
}
