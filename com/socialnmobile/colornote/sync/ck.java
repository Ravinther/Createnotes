package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;

public final class ck extends cj {
    public ck() {
        super("access_token", "expires_in", "expires_at", "refresh_token");
    }

    public final String m1960a(C0361e c0361e) {
        try {
            return b.m1948a(c0361e);
        } catch (Exception e) {
            return c.m1948a(c0361e);
        }
    }

    public final int m1961b(C0361e c0361e) {
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

    public final String m1962c(C0361e c0361e) {
        try {
            return c0361e.m1838d(b.f1626e);
        } catch (Exception e) {
            try {
                return c0361e.m1838d(c.f1626e);
            } catch (Exception e2) {
                return null;
            }
        }
    }
}
