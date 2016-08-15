package com.socialnmobile.colornote.sync.p019c;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import java.util.Arrays;

/* renamed from: com.socialnmobile.colornote.sync.c.b */
public final class C0369b extends Exception {
    private static final long serialVersionUID = -1031309747423635409L;
    public final int f1591a;
    public final String f1592b;
    public final Object f1593c;

    private C0369b(int i, String str, Object obj) {
        super(i + " " + str);
        this.f1591a = i;
        this.f1592b = str;
        this.f1593c = obj;
    }

    public static C0369b m1932a(C0361e c0361e) {
        return new C0369b(c0361e.m1837c("code").intValue(), c0361e.m1838d("message"), c0361e.get("data"));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            C0369b c0369b = (C0369b) obj;
            return Arrays.deepEquals(new Object[]{getClass(), Integer.valueOf(this.f1591a), this.f1592b, this.f1593c}, new Object[]{c0369b.getClass(), Integer.valueOf(c0369b.f1591a), c0369b.f1592b, c0369b.f1593c});
        } catch (RuntimeException e) {
            return false;
        }
    }
}
