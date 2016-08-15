package com.socialnmobile.util.p011b.p017b;

import com.socialnmobile.colornote.sync.cl;
import org.json.JSONTokener;

/* renamed from: com.socialnmobile.util.b.b.g */
public final class C0464g extends C0356a {
    public static final C0464g f2259a;

    public final /* synthetic */ Object m2300a(Object obj) {
        return C0464g.m2299b((String) obj);
    }

    private static Object m2299b(String str) {
        try {
            return new JSONTokener(str).nextValue();
        } catch (Throwable e) {
            throw new cl(e);
        }
    }

    static {
        f2259a = new C0464g();
    }

    public final /* synthetic */ Object m2301b(Object obj) {
        return obj.toString();
    }
}
