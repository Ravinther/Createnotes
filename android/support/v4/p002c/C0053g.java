package android.support.v4.p002c;

import java.util.Iterator;

/* renamed from: android.support.v4.c.g */
final class C0053g implements Iterator {
    final int f247a;
    int f248b;
    int f249c;
    boolean f250d;
    final /* synthetic */ C0048f f251e;

    C0053g(C0048f c0048f, int i) {
        this.f251e = c0048f;
        this.f250d = false;
        this.f247a = i;
        this.f248b = c0048f.m233a();
    }

    public final boolean hasNext() {
        return this.f249c < this.f248b;
    }

    public final Object next() {
        Object a = this.f251e.m235a(this.f249c, this.f247a);
        this.f249c++;
        this.f250d = true;
        return a;
    }

    public final void remove() {
        if (this.f250d) {
            this.f249c--;
            this.f248b--;
            this.f250d = false;
            this.f251e.m237a(this.f249c);
            return;
        }
        throw new IllegalStateException();
    }
}
