package com.socialnmobile.util.p011b.p017b;

import com.socialnmobile.colornote.sync.cl;
import java.util.UUID;

/* renamed from: com.socialnmobile.util.b.b.i */
public final class C0466i extends C0356a {
    public static final C0466i f2261a;

    public final /* synthetic */ Object m2305a(Object obj) {
        return C0466i.m2304b((String) obj);
    }

    public final /* synthetic */ Object m2306b(Object obj) {
        return ((UUID) obj).toString();
    }

    private static UUID m2304b(String str) {
        try {
            return UUID.fromString(str);
        } catch (Throwable e) {
            throw new cl("invalid UUID: " + str, e);
        }
    }

    static {
        f2261a = new C0466i();
    }
}
