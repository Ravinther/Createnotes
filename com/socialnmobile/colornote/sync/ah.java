package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p019c.C0368a;
import com.socialnmobile.colornote.sync.p020d.C0376a;
import java.util.concurrent.Callable;

public final class ah extends ab {
    public final Callable m1774a(C0398n c0398n, C0368a c0368a, C0405u c0405u, bd bdVar) {
        C0366d a = c0398n.m2037a();
        if (a != null) {
            return ab.m1765b(c0368a, m1773a(c0405u, bdVar, c0398n.m2040c(), a), new ad(a));
        }
        throw new UnexpectedLocalAccountException();
    }

    public final C0376a m1773a(C0405u c0405u, bd bdVar, C0361e c0361e, C0366d c0366d) {
        return new C0376a(ab.f1485c, c0405u, c0405u.m2059a(c0366d, bdVar), c0361e, ((Long) c0366d.f1528m.m2010c()).longValue());
    }
}
