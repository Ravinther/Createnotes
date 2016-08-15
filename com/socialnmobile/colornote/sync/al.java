package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import com.socialnmobile.colornote.sync.p019c.C0368a;
import java.util.concurrent.Callable;

public abstract class al extends ab {
    public final Callable m1771a(C0398n c0398n, C0368a c0368a, C0405u c0405u, bd bdVar) {
        C0367b a = c0398n.m2037a();
        if (a == null) {
            return ab.m1765b(c0368a, m1766a(c0405u, bdVar, c0398n.m2040c(), null), new ac(c0398n));
        }
        throw new UnexpectedLocalAccountException(a);
    }
}
