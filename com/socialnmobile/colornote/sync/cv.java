package com.socialnmobile.colornote.sync;

import android.util.SparseArray;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import java.util.HashMap;
import java.util.Map.Entry;

public final class cv {
    public static final HashMap f1652a;
    public static final SparseArray f1653b;
    public static final cv f1654c;

    static void m1976a(C0361e c0361e, String str, int i) {
        Object obj = (String) f1653b.get(i);
        if (obj != null) {
            c0361e.m1833a(str, obj);
        } else {
            c0361e.m1833a(str, Integer.valueOf(i));
        }
    }

    static int m1974a(C0361e c0361e, String str) {
        String h = c0361e.m1842h(str);
        if (h != null) {
            Integer num = (Integer) f1652a.get(h);
            if (num != null) {
                return num.intValue();
            }
        }
        try {
            return c0361e.m1837c(str).intValue();
        } catch (Throwable e) {
            throw new cl(e);
        } catch (Throwable e2) {
            throw new cl(e2);
        }
    }

    private static SparseArray m1975a() {
        SparseArray sparseArray = new SparseArray();
        for (Entry entry : f1652a.entrySet()) {
            sparseArray.put(((Integer) entry.getValue()).intValue(), entry.getKey());
        }
        return sparseArray;
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("none", Integer.valueOf(0));
        hashMap.put("type1", Integer.valueOf(1));
        hashMap.put("type2", Integer.valueOf(2));
        hashMap.put("type3", Integer.valueOf(3));
        f1652a = hashMap;
        f1653b = m1975a();
        f1654c = new cv();
    }
}
