package com.socialnmobile.util.p011b;

import android.content.ContentValues;
import android.database.Cursor;
import com.socialnmobile.util.p011b.p016c.C0351e;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.socialnmobile.util.b.k */
public class C0364k implements C0363j {
    final ArrayList a_;
    ContentValues b_;
    Cursor c_;

    public C0364k() {
        this.a_ = new ArrayList();
    }

    public final C0363j m1848a(C0363j c0363j) {
        this.a_.add(c0363j);
        return c0363j;
    }

    public final C0472l m1849a(C0448m c0448m) {
        C0472l c0472l = new C0472l(c0448m);
        this.a_.add(c0472l);
        return c0472l;
    }

    public final C0471i m1847a(C0448m c0448m, C0351e c0351e) {
        return new C0471i(m1849a(c0448m), c0351e);
    }

    public final Object m1851c(Cursor cursor) {
        Iterator it = this.a_.iterator();
        while (it.hasNext()) {
            ((C0363j) it.next()).m1846c(cursor);
        }
        this.c_ = cursor;
        return this;
    }

    public final Object m1850c(ContentValues contentValues) {
        Iterator it = this.a_.iterator();
        while (it.hasNext()) {
            ((C0363j) it.next()).m1845c(contentValues);
        }
        this.b_ = contentValues;
        return this;
    }

    public final ContentValues m1852n() {
        if (this.b_ != null) {
            return this.b_;
        }
        throw new IllegalStateException();
    }
}
