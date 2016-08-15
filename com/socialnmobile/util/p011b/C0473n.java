package com.socialnmobile.util.p011b;

/* renamed from: com.socialnmobile.util.b.n */
public final class C0473n {
    public String f2273a;
    public String[] f2274b;

    public C0473n() {
        this(null, null);
    }

    public C0473n(String str, String... strArr) {
        this.f2273a = str;
        this.f2274b = strArr;
    }

    public C0473n(String str, Object... objArr) {
        this.f2273a = str;
        this.f2274b = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            this.f2274b[i] = objArr[i].toString();
        }
    }

    public static C0473n m2323a(String str, C0473n... c0473nArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        int i2 = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            if (c0473nArr[i3].f2273a != null) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuilder.append(str);
                }
                stringBuilder.append('(').append(c0473nArr[i3].f2273a).append(')');
                if (c0473nArr[i3].f2274b != null) {
                    i2 += c0473nArr[i3].f2274b.length;
                }
            }
        }
        Object obj = new String[i2];
        i2 = 0;
        i = 0;
        while (i2 < 2) {
            if (!(c0473nArr[i2].f2273a == null || c0473nArr[i2].f2274b == null)) {
                System.arraycopy(c0473nArr[i2].f2274b, 0, obj, i, c0473nArr[i2].f2274b.length);
                i += c0473nArr[i2].f2274b.length;
            }
            i2++;
        }
        C0473n c0473n = new C0473n();
        c0473n.f2273a = stringBuilder.toString();
        c0473n.f2274b = obj;
        return c0473n;
    }

    public final C0473n m2324a(C0473n c0473n) {
        return C0473n.m2323a("AND", this, c0473n);
    }
}
