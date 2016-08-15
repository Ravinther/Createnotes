package android.support.v4.p002c;

import java.util.Map;

/* renamed from: android.support.v4.c.b */
final class C0049b extends C0048f {
    final /* synthetic */ C0047a f241a;

    C0049b(C0047a c0047a) {
        this.f241a = c0047a;
    }

    protected final int m244a() {
        return this.f241a.h;
    }

    protected final Object m246a(int i, int i2) {
        return this.f241a.g[(i << 1) + i2];
    }

    protected final int m245a(Object obj) {
        return obj == null ? this.f241a.m225a() : this.f241a.m227a(obj, obj.hashCode());
    }

    protected final int m250b(Object obj) {
        return this.f241a.m226a(obj);
    }

    protected final Map m251b() {
        return this.f241a;
    }

    protected final void m249a(Object obj, Object obj2) {
        this.f241a.put(obj, obj2);
    }

    protected final Object m247a(int i, Object obj) {
        C0046l c0046l = this.f241a;
        int i2 = (i << 1) + 1;
        Object obj2 = c0046l.f235g[i2];
        c0046l.f235g[i2] = obj;
        return obj2;
    }

    protected final void m248a(int i) {
        this.f241a.m230c(i);
    }

    protected final void m252c() {
        this.f241a.clear();
    }
}
