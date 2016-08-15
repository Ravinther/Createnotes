package com.socialnmobile.util.p011b;

import android.content.ContentValues;

/* renamed from: com.socialnmobile.util.b.b */
final class C0467b implements C0385e {
    final /* synthetic */ ContentValues f2262a;
    final /* synthetic */ C0449a f2263b;
    final /* synthetic */ C0449a f2264c;

    C0467b(C0449a c0449a, ContentValues contentValues, C0449a c0449a2) {
        this.f2264c = c0449a;
        this.f2262a = contentValues;
        this.f2263b = c0449a2;
    }

    public final Object m2309c() {
        if (this.f2262a.containsKey(this.f2264c.f2234a)) {
            return this.f2263b.m2247a(this.f2262a);
        }
        throw new C0469f("Column " + this.f2264c.f2234a + " not exists");
    }

    public final void m2307a(Object obj) {
        this.f2264c.m2248a(this.f2262a, obj);
    }

    public final void m2308b() {
        this.f2262a.remove(this.f2264c.f2234a);
    }
}
