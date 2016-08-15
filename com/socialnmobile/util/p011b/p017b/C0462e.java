package com.socialnmobile.util.p011b.p017b;

import com.socialnmobile.colornote.sync.cl;

/* renamed from: com.socialnmobile.util.b.b.e */
public final class C0462e extends C0356a {
    static final char[] f2254a;
    public static final C0462e f2255b;

    public final /* synthetic */ Object m2290a(Object obj) {
        String str = (String) obj;
        int length = str.length();
        if (length % 2 == 1) {
            throw new cl("odd number of characters");
        }
        Object obj2 = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            obj2[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return obj2;
    }

    public final /* synthetic */ Object m2291b(Object obj) {
        byte[] bArr = (byte[]) obj;
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            stringBuilder.append(f2254a[(b >> 4) & 15]);
            stringBuilder.append(f2254a[b & 15]);
        }
        return stringBuilder.toString();
    }

    static {
        f2254a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f2255b = new C0462e();
    }
}
