package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import java.util.HashMap;

public final class cy {
    public static final cy f1688d;
    public final HashMap f1689a;
    public final HashMap f1690b;
    public final HashMap f1691c;

    public cy() {
        HashMap hashMap = new HashMap();
        hashMap.put("text", Integer.valueOf(0));
        hashMap.put("list", Integer.valueOf(16));
        hashMap.put("pref", Integer.valueOf(256));
        hashMap.put("none", Integer.valueOf(-1));
        this.f1689a = hashMap;
        hashMap = new HashMap();
        hashMap.put("normal", Integer.valueOf(0));
        hashMap.put("archived", Integer.valueOf(0));
        hashMap.put("recyclebin", Integer.valueOf(16));
        hashMap.put("deleted", Integer.valueOf(32));
        hashMap.put("hidden", Integer.valueOf(256));
        this.f1690b = hashMap;
        hashMap = new HashMap();
        hashMap.put("normal", Integer.valueOf(0));
        hashMap.put("archived", Integer.valueOf(16));
        hashMap.put("recyclebin", Integer.valueOf(0));
        hashMap.put("deleted", Integer.valueOf(0));
        hashMap.put("hidden", Integer.valueOf(0));
        this.f1691c = hashMap;
    }

    static String m1978a(int i) {
        switch (i) {
            case -1:
                return "none";
            case 0:
                return "text";
            case 16:
                return "list";
            case 256:
                return "pref";
            default:
                throw new IllegalStateException("type: " + i);
        }
    }

    static String m1979a(int i, int i2) {
        if (i2 == 16) {
            return "archived";
        }
        switch (i) {
            case 0:
                return "normal";
            case 16:
                return "recyclebin";
            case 32:
                return "deleted";
            case 256:
                return "hidden";
            default:
                return "normal";
        }
    }

    static C0361e m1977a(cz czVar) {
        if (((Integer) czVar.f1692a.m2010c()).intValue() == 0) {
            return null;
        }
        C0361e c0361e = new C0361e();
        da daVar = da.f1723a;
        da.m1987a(czVar, c0361e);
        return c0361e;
    }

    static void m1980a(cz czVar, C0361e c0361e, String str) {
        C0361e j = c0361e.m1844j(str);
        try {
            da daVar = da.f1723a;
            da.m1988b(czVar, j);
        } catch (Throwable e) {
            throw new cl(str, e);
        }
    }

    static {
        f1688d = new cy();
    }
}
