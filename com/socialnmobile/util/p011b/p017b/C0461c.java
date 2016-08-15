package com.socialnmobile.util.p011b.p017b;

import com.socialnmobile.colornote.sync.cl;

/* renamed from: com.socialnmobile.util.b.b.c */
public final class C0461c extends C0356a {
    public static final C0461c f2253a;

    public final /* synthetic */ Object m2288a(Object obj) {
        return C0461c.m2287b((String) obj);
    }

    public final /* synthetic */ Object m2289b(Object obj) {
        return C0461c.m2286a((byte[]) obj);
    }

    private static String m2286a(byte[] bArr) {
        try {
            return C0460b.m2281a(bArr);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] m2287b(String str) {
        try {
            return C0460b.m2283a(str);
        } catch (Throwable e) {
            throw new cl(e);
        }
    }

    static {
        f2253a = new C0461c();
    }
}
