package android.support.v4.p002c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.c.h */
final class C0054h implements Set {
    final /* synthetic */ C0048f f252a;

    C0054h(C0048f c0048f) {
        this.f252a = c0048f;
    }

    public final boolean addAll(Collection collection) {
        int a = this.f252a.m233a();
        for (Entry entry : collection) {
            this.f252a.m238a(entry.getKey(), entry.getValue());
        }
        return a != this.f252a.m233a();
    }

    public final void clear() {
        this.f252a.m243c();
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.f252a.m234a(entry.getKey());
        if (a >= 0) {
            return C0050c.m255a(this.f252a.m235a(a, 1), entry.getValue());
        }
        return false;
    }

    public final boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        return this.f252a.m233a() == 0;
    }

    public final Iterator iterator() {
        return new C0056j(this.f252a);
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        return this.f252a.m233a();
    }

    public final Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray(Object[] objArr) {
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        return C0048f.m232a((Set) this, obj);
    }

    public final int hashCode() {
        int a = this.f252a.m233a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.f252a.m235a(a, 0);
            Object a3 = this.f252a.m235a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }

    public final /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }
}
