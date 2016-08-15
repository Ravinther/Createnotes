package android.support.v4.p002c;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: android.support.v4.c.k */
final class C0057k implements Collection {
    final /* synthetic */ C0048f f258a;

    C0057k(C0048f c0048f) {
        this.f258a = c0048f;
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.f258a.m243c();
    }

    public final boolean contains(Object obj) {
        return this.f258a.m240b(obj) >= 0;
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
        return this.f258a.m233a() == 0;
    }

    public final Iterator iterator() {
        return new C0053g(this.f258a, 1);
    }

    public final boolean remove(Object obj) {
        int b = this.f258a.m240b(obj);
        if (b < 0) {
            return false;
        }
        this.f258a.m237a(b);
        return true;
    }

    public final boolean removeAll(Collection collection) {
        int i = 0;
        int a = this.f258a.m233a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.f258a.m235a(i, 1))) {
                this.f258a.m237a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public final boolean retainAll(Collection collection) {
        int i = 0;
        int a = this.f258a.m233a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.f258a.m235a(i, 1))) {
                this.f258a.m237a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public final int size() {
        return this.f258a.m233a();
    }

    public final Object[] toArray() {
        return this.f258a.m242b(1);
    }

    public final Object[] toArray(Object[] objArr) {
        return this.f258a.m239a(objArr, 1);
    }
}
