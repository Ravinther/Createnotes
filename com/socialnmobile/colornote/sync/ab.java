package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.data.C0232v;
import com.socialnmobile.colornote.data.aa;
import com.socialnmobile.colornote.sync.p018b.C0357a;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p019c.C0368a;
import com.socialnmobile.colornote.sync.p020d.C0376a;
import com.socialnmobile.colornote.sync.p020d.C0377b;
import com.socialnmobile.colornote.sync.p020d.C0378c;
import com.socialnmobile.util.p011b.C0473n;
import java.util.concurrent.Callable;

public abstract class ab {
    public static final aj f1483a;
    public static final af f1484b;
    public static final ah f1485c;

    public abstract C0376a m1766a(C0405u c0405u, bd bdVar, C0361e c0361e, C0366d c0366d);

    public abstract Callable m1767a(C0398n c0398n, C0368a c0368a, C0405u c0405u, bd bdVar);

    static {
        f1483a = new aj();
        f1484b = new af();
        f1485c = new ah();
    }

    static C0367b m1764a(C0376a c0376a, C0377b c0377b, C0398n c0398n) {
        long j = c0377b.f1706a.f1803a;
        C0367b b = c0398n.m2039b();
        if (b != null) {
            if (j == b.m1860h()) {
                b.m1877a(c0376a, c0377b);
                return b;
            }
            C0232v f = b.f1541b.m1074f();
            f.f1027a.beginTransaction();
            try {
                new aa(b.f1541b).m917c();
                C0404t c0404t = b.f1542c;
                C0473n b2 = b.m1879b();
                c0404t.f1817a.m1074f().m1076a("SyncAccount", b2.f2273a, b2.f2274b);
                f.f1027a.setTransactionSuccessful();
            } finally {
                f.f1027a.endTransaction();
            }
        }
        return c0398n.m2038a(c0376a, c0377b);
    }

    static C0367b m1763a(C0376a c0376a, C0377b c0377b, C0367b c0367b) {
        long h = c0367b.m1860h();
        long j = c0377b.f1706a.f1803a;
        if (h != j) {
            throw new IllegalStateException("returned account " + j + " not match with local account id " + h);
        }
        c0367b.m1877a(c0376a, c0377b);
        return c0367b;
    }

    static Callable m1765b(C0368a c0368a, C0376a c0376a, C0350y c0350y) {
        return new ae(c0368a, c0376a, c0350y);
    }

    static C0367b m1762a(C0368a c0368a, C0376a c0376a, C0350y c0350y) {
        return c0350y.m1768a(c0376a, (C0377b) new C0378c().m1783d(C0357a.m1824c(c0368a.m1931a(c0376a))));
    }
}
