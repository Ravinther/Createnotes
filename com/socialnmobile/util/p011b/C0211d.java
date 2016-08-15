package com.socialnmobile.util.p011b;

import android.database.Cursor;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.socialnmobile.util.b.d */
public abstract class C0211d implements Iterable, Iterator {
    public final Cursor f928b;

    public abstract Object m918a();

    public C0211d(Cursor cursor) {
        this.f928b = cursor;
    }

    public Iterator iterator() {
        this.f928b.moveToFirst();
        this.f928b.move(-1);
        return this;
    }

    public boolean hasNext() {
        return this.f928b.getPosition() + 1 < this.f928b.getCount();
    }

    public Object next() {
        if (this.f928b.moveToNext()) {
            return m918a();
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
