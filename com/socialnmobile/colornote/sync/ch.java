package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;

public final class ch extends cg {
    public ch() {
        super("access_token", "expires_in", "expires_at");
    }

    public final String m1953a(C0361e c0361e) {
        try {
            return b.m1948a(c0361e);
        } catch (Exception e) {
            return c.m1948a(c0361e);
        }
    }

    public final int m1954b(C0361e c0361e) {
        try {
            return c0361e.m1837c(b.g).intValue();
        } catch (Exception e) {
            try {
                return c0361e.m1837c(c.g).intValue();
            } catch (Exception e2) {
                return 0;
            }
        }
    }
}
