package android.support.v4.p002c;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: android.support.v4.c.j */
final class C0056j implements Iterator, Entry {
    int f254a;
    int f255b;
    boolean f256c;
    final /* synthetic */ C0048f f257d;

    C0056j(C0048f c0048f) {
        this.f257d = c0048f;
        this.f256c = false;
        this.f254a = c0048f.m233a() - 1;
        this.f255b = -1;
    }

    public final boolean hasNext() {
        return this.f255b < this.f254a;
    }

    public final void remove() {
        if (this.f256c) {
            this.f257d.m237a(this.f255b);
            this.f255b--;
            this.f254a--;
            this.f256c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public final Object getKey() {
        if (this.f256c) {
            return this.f257d.m235a(this.f255b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final Object getValue() {
        if (this.f256c) {
            return this.f257d.m235a(this.f255b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final Object setValue(Object obj) {
        if (this.f256c) {
            return this.f257d.m236a(this.f255b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final boolean equals(Object obj) {
        if (!this.f256c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (C0050c.m255a(entry.getKey(), this.f257d.m235a(this.f255b, 0)) && C0050c.m255a(entry.getValue(), this.f257d.m235a(this.f255b, 1))) {
                return true;
            }
            return false;
        }
    }

    public final int hashCode() {
        int i = 0;
        if (this.f256c) {
            Object a = this.f257d.m235a(this.f255b, 0);
            Object a2 = this.f257d.m235a(this.f255b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.f255b++;
        this.f256c = true;
        return this;
    }
}
