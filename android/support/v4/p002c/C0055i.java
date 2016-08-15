package android.support.v4.p002c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.c.i */
final class C0055i implements Set {
    final /* synthetic */ C0048f f253a;

    C0055i(C0048f c0048f) {
        this.f253a = c0048f;
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.f253a.m243c();
    }

    public final boolean contains(Object obj) {
        return this.f253a.m234a(obj) >= 0;
    }

    public final boolean containsAll(Collection collection) {
        Map b = this.f253a.m241b();
        for (Object containsKey : collection) {
            if (!b.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        return this.f253a.m233a() == 0;
    }

    public final Iterator iterator() {
        return new C0053g(this.f253a, 0);
    }

    public final boolean remove(Object obj) {
        int a = this.f253a.m234a(obj);
        if (a < 0) {
            return false;
        }
        this.f253a.m237a(a);
        return true;
    }

    public final boolean removeAll(Collection collection) {
        Map b = this.f253a.m241b();
        int size = b.size();
        for (Object remove : collection) {
            b.remove(remove);
        }
        return size != b.size();
    }

    public final boolean retainAll(Collection collection) {
        Map b = this.f253a.m241b();
        int size = b.size();
        Iterator it = b.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != b.size();
    }

    public final int size() {
        return this.f253a.m233a();
    }

    public final Object[] toArray() {
        return this.f253a.m242b(0);
    }

    public final Object[] toArray(Object[] objArr) {
        return this.f253a.m239a(objArr, 0);
    }

    public final boolean equals(Object obj) {
        return C0048f.m232a((Set) this, obj);
    }

    public final int hashCode() {
        int i = 0;
        for (int a = this.f253a.m233a() - 1; a >= 0; a--) {
            Object a2 = this.f253a.m235a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }
}
