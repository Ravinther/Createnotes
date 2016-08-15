package com.socialnmobile.colornote.sync.p018b;

import java.util.AbstractList;
import org.json.JSONArray;

/* renamed from: com.socialnmobile.colornote.sync.b.d */
public final class C0360d extends AbstractList {
    final JSONArray f1506a;

    public C0360d(JSONArray jSONArray) {
        this.f1506a = jSONArray;
    }

    public C0360d() {
        this(new JSONArray());
    }

    public final String toString() {
        return this.f1506a.toString();
    }

    public final Object get(int i) {
        return C0357a.m1820a(this.f1506a, i);
    }

    public final int size() {
        return this.f1506a.length();
    }

    public final boolean add(Object obj) {
        this.f1506a.put(C0357a.m1823b(obj));
        return true;
    }
}
