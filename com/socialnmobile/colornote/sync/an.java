package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p016c.C0354c;

public final class an extends C0354c {
    final ap f1492a;
    final ar f1493b;

    public an() {
        this.f1492a = new ap();
        this.f1493b = new ar();
    }

    public final /* synthetic */ void m1792a(Object obj, Object obj2) {
        am amVar = (am) obj;
        C0361e c0361e = (C0361e) obj2;
        if (amVar instanceof aq) {
            ar.m1804a((aq) amVar, c0361e);
        } else if (amVar instanceof ao) {
            ap.m1797a((ao) amVar, c0361e);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private static am m1790a(C0361e c0361e) {
        try {
            return ar.m1803a(c0361e);
        } catch (Exception e) {
            return ap.m1796a(c0361e);
        }
    }
}
