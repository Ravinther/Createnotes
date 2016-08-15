package com.socialnmobile.colornote.sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* renamed from: com.socialnmobile.colornote.sync.z */
public final class C0409z {
    public final HashMap f1825a;
    public final HashMap f1826b;
    public final HashMap f1827c;
    public final HashMap f1828d;

    public C0409z() {
        this.f1825a = new HashMap();
        this.f1826b = new HashMap();
        this.f1827c = new HashMap();
        this.f1828d = new HashMap();
    }

    public C0409z(HashMap hashMap, HashMap hashMap2, HashMap hashMap3, HashMap hashMap4) {
        this.f1825a = new HashMap();
        this.f1826b = new HashMap();
        this.f1827c = new HashMap();
        this.f1828d = new HashMap();
        if (hashMap != null) {
            this.f1825a.putAll(hashMap);
        }
        if (hashMap2 != null) {
            this.f1826b.putAll(hashMap2);
        }
        if (hashMap3 != null) {
            this.f1827c.putAll(hashMap3);
        }
        if (hashMap4 != null) {
            this.f1828d.putAll(hashMap4);
        }
    }

    public final HashMap m2062a(C0405u c0405u) {
        if (c0405u == C0405u.f1818a) {
            return this.f1825a;
        }
        if (c0405u == C0405u.f1820c) {
            return this.f1826b;
        }
        if (c0405u == C0405u.f1819b) {
            return this.f1827c;
        }
        if (c0405u == C0405u.f1821d) {
            return this.f1828d;
        }
        throw new IllegalArgumentException("unsupported authority: " + c0405u);
    }

    public static List m2061a(Set set) {
        List arrayList = new ArrayList(set);
        Collections.sort(arrayList);
        return arrayList;
    }
}
