package com.socialnmobile.colornote.p012f;

import com.socialnmobile.colornote.sync.cm;

/* renamed from: com.socialnmobile.colornote.f.b */
public abstract class C0268b {
    public abstract int m1201a(cm cmVar, cm cmVar2);

    public static int m1200c(String str) {
        if (str == null) {
            return 0;
        }
        if (str.startsWith("[ ]") || str.startsWith("[V]")) {
            return 16;
        }
        return 0;
    }
}
