package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.p017b.C0466i;
import java.util.UUID;

public final class dk {
    public static final dk f1737a;

    public static void m1994a(di diVar, C0361e c0361e) {
        c0361e.m1834a(SyncIndexColumns.UUID, (UUID) diVar.f1733a.m2010c(), C0466i.f2261a);
        c0361e.m1833a(SyncIndexColumns.REVISION, Long.valueOf(((Long) diVar.f1734b.m2010c()).longValue()));
    }

    public static void m1995b(di diVar, C0361e c0361e) {
        try {
            diVar.f1733a.m2008a((UUID) c0361e.m1831a(SyncIndexColumns.UUID, C0466i.f2261a));
            diVar.f1734b.m2008a(Long.valueOf(c0361e.m1837c(SyncIndexColumns.REVISION).longValue()));
        } catch (Throwable e) {
            throw new cl(e);
        } catch (Throwable e2) {
            throw new cl(e2);
        }
    }

    static {
        f1737a = new dk();
    }
}
