package com.socialnmobile.colornote.data;

import java.util.ArrayList;

/* renamed from: com.socialnmobile.colornote.data.h */
public final class C0218h {
    public int f955a;
    public int f956b;
    public long f957c;
    public int f958d;
    public String f959e;
    public String f960f;
    public ArrayList f961g;

    public C0218h(int i, int i2, long j, int i3, String str, String str2) {
        this.f955a = i;
        this.f956b = i2;
        this.f957c = j;
        this.f958d = i3;
        this.f959e = str;
        this.f960f = str2;
        this.f961g = new ArrayList();
        this.f961g.add(str);
    }

    public final boolean m999a() {
        return this.f955a >= 7;
    }
}
