package android.support.v4.p002c;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.c.a */
public class C0047a extends C0046l implements Map {
    C0048f f237a;

    private C0048f m231b() {
        if (this.f237a == null) {
            this.f237a = new C0049b(this);
        }
        return this.f237a;
    }

    public void putAll(Map map) {
        int size = this.h + map.size();
        if (this.f234f.length < size) {
            Object obj = this.f234f;
            Object obj2 = this.f235g;
            super.m228a(size);
            if (this.f236h > 0) {
                System.arraycopy(obj, 0, this.f234f, 0, this.f236h);
                System.arraycopy(obj2, 0, this.f235g, 0, this.f236h << 1);
            }
            C0046l.m223a(obj, obj2, this.f236h);
        }
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set entrySet() {
        C0048f b = m231b();
        if (b.f238b == null) {
            b.f238b = new C0054h(b);
        }
        return b.f238b;
    }

    public Set keySet() {
        C0048f b = m231b();
        if (b.f239c == null) {
            b.f239c = new C0055i(b);
        }
        return b.f239c;
    }

    public Collection values() {
        C0048f b = m231b();
        if (b.f240d == null) {
            b.f240d = new C0057k(b);
        }
        return b.f240d;
    }
}
