package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import java.io.IOException;

public final class ay {
    public final C0361e f1505a;

    public ay(C0361e c0361e) {
        if (c0361e == null) {
            throw new IllegalArgumentException("json: null");
        }
        this.f1505a = c0361e;
    }

    public static C0361e m1811a(String str) {
        try {
            return C0361e.m1830a(str);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }
}
