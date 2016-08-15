package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.sync.p018b.C0361e;

public final class cn {
    final cq f1630a;
    final bx f1631b;
    final bw f1632c;

    public cn(cq cqVar) {
        this.f1631b = bz.f1589a;
        this.f1632c = bw.f1588a;
        this.f1630a = cqVar;
    }

    public final void m1968a(C0361e c0361e) {
        try {
            c0361e.m1833a(NoteMajorColumns.TITLE, m1966b(c0361e.m1839e(NoteMajorColumns.TITLE)));
            c0361e.m1833a("content", m1966b(c0361e.m1839e("content")));
        } catch (Throwable e) {
            throw new cl(e);
        } catch (Throwable e2) {
            throw new cl(e2);
        }
    }

    public final Object m1967a(String str) {
        return this.f1632c.m1782c(this.f1631b.m1923a(this.f1630a, str.getBytes()));
    }

    private String m1966b(C0361e c0361e) {
        return new String(((bv) this.f1632c.m1783d(c0361e)).m1918a(this.f1630a));
    }
}
