package com.socialnmobile.colornote.sync;

import android.content.Context;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.sync.p018b.C0357a;
import com.socialnmobile.colornote.sync.p018b.C0360d;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p019c.C0368a;
import com.socialnmobile.colornote.sync.p020d.C0379d;
import com.socialnmobile.colornote.sync.p020d.C0380e;
import com.socialnmobile.colornote.sync.p020d.C0381f;
import com.socialnmobile.util.p011b.p016c.C0351e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.Callable;

public final class dt implements Callable {
    final cd f1753a;
    final C0367b f1754b;
    final C0368a f1755c;
    final du f1756d;
    long f1757e;
    final HashSet f1758f;
    final C0361e f1759g;
    final dv f1760h;
    boolean f1761i;
    C0360d f1762j;
    final UUID f1763k;
    final C0361e f1764l;
    public final dm f1765m;

    public final /* synthetic */ Object call() {
        return m2000a();
    }

    public dt(cd cdVar, C0367b c0367b, C0368a c0368a, int i, du duVar) {
        boolean z = false;
        this.f1757e = -1;
        this.f1758f = new HashSet();
        this.f1759g = new C0361e();
        this.f1760h = new dv(this);
        this.f1761i = false;
        this.f1762j = new C0360d();
        this.f1763k = UUID.randomUUID();
        this.f1764l = new C0361e();
        this.f1765m = new dm();
        this.f1753a = cdVar;
        this.f1754b = c0367b;
        this.f1755c = c0368a;
        this.f1764l.m1833a("MAX_CHECKINS_PER_REQUEST", Integer.valueOf(i));
        this.f1756d = duVar;
        C0361e c0361e = this.f1759g;
        String str = "firstcheckout";
        if (c0367b.m1861i() == 0) {
            z = true;
        }
        c0361e.m1833a(str, Boolean.valueOf(z));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.socialnmobile.colornote.sync.dw m2000a() {
        /*
        r10 = this;
        r0 = 0;
        r1 = r10.f1754b;
        r1 = r1.m1863k();
        if (r1 != 0) goto L_0x0018;
    L_0x0009:
        r1 = r10.f1754b;
        r1 = r1.q;
        r1.m2008a(r0);
        r0 = new com.socialnmobile.colornote.sync.errors.AuthRequired;
        r1 = "AuthToken is required";
        r0.<init>(r1);
        throw r0;
    L_0x0018:
        r1 = r0;
    L_0x0019:
        r2 = r10.m1998a(r1);
        if (r2 == 0) goto L_0x00a1;
    L_0x001f:
        r0 = r2.f1714d;
        if (r0 == 0) goto L_0x0039;
    L_0x0023:
        r3 = r10.f1754b;
        r4 = new com.socialnmobile.colornote.sync.av;
        r5 = r3.f1541b;
        r4.<init>(r3, r5);
        r3 = r10.f1765m;
        r5 = r3.f1739b;
        r6 = r2.f1711a;
        r0 = r4.m1810a(r6, r0);
        r0 = r0 + r5;
        r3.f1739b = r0;
    L_0x0039:
        r0 = r10.f1754b;
        r3 = r0.f1539x;
        r3 = r3.m2012a();
        r4 = r2.f1715e;
        r6 = r4.f1803a;
        r5 = r3.f1775a;
        r8 = r5.f1803a;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 == 0) goto L_0x0055;
    L_0x004d:
        r0 = new com.socialnmobile.colornote.sync.dl;
        r1 = "account id mismatch";
        r0.<init>(r1);
        throw r0;
    L_0x0055:
        r5 = r4.f1804b;
        if (r5 != 0) goto L_0x005f;
    L_0x0059:
        r5 = r3.f1775a;
        r5 = r5.f1804b;
        r4.f1804b = r5;
    L_0x005f:
        r5 = r4.f1809g;
        if (r5 != 0) goto L_0x0069;
    L_0x0063:
        r5 = r3.f1775a;
        r5 = r5.f1809g;
        r4.f1809g = r5;
    L_0x0069:
        r5 = r2.f1716f;
        r6 = r5.f1569d;
        r6 = r6.f1500c;
        if (r6 != 0) goto L_0x007b;
    L_0x0071:
        r6 = r5.f1569d;
        r3 = r3.f1776b;
        r3 = r3.f1569d;
        r3 = r3.f1500c;
        r6.f1500c = r3;
    L_0x007b:
        r3 = r0.f1532q;
        r6 = r5.f1570e;
        r3.m2008a(r6);
        r3 = r0.f1537v;
        r3.m2008a(r4);
        r3 = r0.f1538w;
        r3.m2008a(r5);
        r0.m1880c();
        r0 = r10.f1753a;
        r3 = com.socialnmobile.colornote.sync.cb.AccountStateChanged;
        r4 = r2.f1715e;
        r0.m1944a(r3, r4);
        r0 = r10.f1753a;
        r3 = com.socialnmobile.colornote.sync.cb.DeviceStateChanged;
        r4 = r2.f1716f;
        r0.m1944a(r3, r4);
    L_0x00a1:
        if (r2 == 0) goto L_0x014a;
    L_0x00a3:
        r0 = r2.f1718h;
        r3 = r10.f1760h;
        r4 = r10.f1762j;
        if (r0 == 0) goto L_0x00f2;
    L_0x00ab:
        r5 = r0.iterator();
    L_0x00af:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x00f2;
    L_0x00b5:
        r0 = r5.next();
        r0 = (com.socialnmobile.colornote.sync.p018b.C0361e) r0;
        r6 = "method";
        r6 = r0.m1842h(r6);
        r7 = "params";
        r0 = r0.m1844j(r7);
        r7 = new com.socialnmobile.colornote.sync.b.e;
        r7.<init>();
        r8 = "method";
        r7.m1833a(r8, r6);
        r0 = r3.m2003a(r6, r0);	 Catch:{ Exception -> 0x00e0 }
        if (r0 == 0) goto L_0x00af;
    L_0x00d7:
        r6 = "result";
        r7.m1833a(r6, r0);	 Catch:{ Exception -> 0x00e0 }
        r4.add(r7);	 Catch:{ Exception -> 0x00e0 }
        goto L_0x00af;
    L_0x00e0:
        r0 = move-exception;
        r6 = com.socialnmobile.util.service.C0479f.f2283a;
        r0 = r6.m1782c(r0);
        r0 = (com.socialnmobile.colornote.sync.p018b.C0361e) r0;
        r6 = "error";
        r7.m1833a(r6, r0);
        r4.add(r7);
        goto L_0x00af;
    L_0x00f2:
        r0 = r10.f1761i;
        if (r0 != 0) goto L_0x014a;
    L_0x00f6:
        r0 = r2.f1716f;
        r0 = r0.f1568c;
        r3 = 2;
        if (r0 != r3) goto L_0x0103;
    L_0x00fd:
        r0 = new com.socialnmobile.colornote.sync.bp;
        r0.<init>();
        throw r0;
    L_0x0103:
        r4 = r2.f1712b;
        r6 = r2.f1711a;
        r0 = r10.f1762j;
        r0 = r0.size();
        if (r0 != 0) goto L_0x0117;
    L_0x010f:
        if (r1 == 0) goto L_0x0117;
    L_0x0111:
        r8 = r1.f1711a;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 == 0) goto L_0x014a;
    L_0x0117:
        r0 = r10.f1757e;
        r8 = -1;
        r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0121;
    L_0x011f:
        r10.f1757e = r6;
    L_0x0121:
        r0 = r10.f1757e;
        r0 = r6 - r0;
        r0 = (int) r0;
        r6 = r10.f1757e;
        r4 = r4 - r6;
        r1 = (int) r4;
        r3 = new java.lang.StringBuilder;
        r4 = "Sync.onProgress: ";
        r3.<init>(r4);
        r3 = r3.append(r0);
        r4 = 47;
        r3 = r3.append(r4);
        r3.append(r1);
        r3 = r10.f1756d;
        if (r3 == 0) goto L_0x0147;
    L_0x0142:
        r3 = r10.f1756d;
        r3.m2001a(r0, r1);
    L_0x0147:
        r1 = r2;
        goto L_0x0019;
    L_0x014a:
        r0 = new com.socialnmobile.colornote.sync.dw;
        r2 = r10.f1765m;
        r0.<init>(r1, r2);
        r1 = r10.f1753a;
        r2 = com.socialnmobile.colornote.sync.cb.SyncSessionCompleted;
        r1.m1944a(r2, r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.sync.dt.a():com.socialnmobile.colornote.sync.dw");
    }

    private C0380e m1998a(C0380e c0380e) {
        Object obj;
        long i = this.f1754b.m1861i();
        C0367b c0367b = this.f1754b;
        ba baVar = new ba(c0367b.f1541b, this.f1764l, this.f1758f, c0367b.m1863k());
        if (c0380e == null) {
            obj = 1;
        } else {
            try {
                obj = baVar.f1545c.getCount() > 0 ? 1 : this.f1762j.size() > 0 ? 1 : i < c0380e.f1712b ? 1 : null;
            } catch (Throwable th) {
                baVar.m1884a();
            }
        }
        if (obj == null) {
            baVar.m1884a();
            return null;
        }
        C0361e c0361e;
        bm m = this.f1754b.m1865m();
        if (m.f1570e == null) {
            C0367b c0367b2 = this.f1754b;
            c0361e = new C0361e();
            Context context = c0367b2.f1540a;
            Object a = bk.m1901a(bk.m1900a());
            bl a2 = bl.m1902a(c0367b2.f1540a);
            c0361e.m1833a("id", a);
            c0361e.m1833a("info", a2.m1903a());
            C0351e atVar = new at();
            as asVar = m.f1569d;
            if (asVar != null && asVar.f1499b == null) {
                C0311h.f1370a.m1622a("Sync Upgrade Problem", "authentication.id is null", (C0361e) C0383e.f1774a.m1782c(this.f1754b));
            }
            c0361e.m1834a("authentication", asVar, atVar);
        } else {
            c0361e = null;
        }
        C0361e c0361e2 = new C0361e();
        C0405u[] c0405uArr = new C0405u[]{C0405u.f1818a, C0405u.f1820c, C0405u.f1819b};
        for (int i2 = 0; i2 < 3; i2++) {
            C0405u c0405u = c0405uArr[i2];
            HashMap a3 = this.f1754b.m1854a(c0405u);
            Object c0361e3 = new C0361e();
            for (String str : a3.keySet()) {
                dd ddVar = ((aa) a3.get(str)).f1482c;
                if (ddVar != null) {
                    c0361e3.m1833a(str, ddVar.f1724a);
                }
            }
            c0361e2.m1833a(c0405u.f1822e, c0361e3);
        }
        if (baVar.f1545c == null) {
            throw new IllegalStateException("CommitStage.c is null");
        } else if (baVar.f1546d == null) {
            throw new IllegalStateException("CommitStage.nek is null");
        } else {
            C0360d a4 = baVar.m1883a(baVar.f1545c, baVar.f1546d);
            C0360d c0360d = this.f1762j;
            this.f1762j = new C0360d();
            C0380e a5 = m1999a(this.f1755c.m1931a(new C0379d(this.f1763k, this.f1759g, ((Long) this.f1754b.m.m2010c()).longValue(), c0361e, (UUID) this.f1754b.f1529n.m2010c(), (bg) this.f1754b.f1530o.m2010c(), c0361e2, i, a4, c0360d)));
            baVar.m1885a(a5, this.f1758f);
            dm dmVar = this.f1765m;
            dm dmVar2 = baVar.f1551i;
            dmVar.f1738a += dmVar2.f1738a;
            dmVar.f1739b += dmVar2.f1739b;
            dmVar.f1740c += dmVar2.f1740c;
            dmVar.f1741d = dmVar2.f1741d + dmVar.f1741d;
            if (baVar.f1551i.f1741d > 0) {
                C0361e c0361e4 = new C0361e();
                c0361e4.m1833a("badNotes", Integer.valueOf(baVar.f1551i.f1741d));
                C0311h.f1370a.m1622a("Commit Problem", "Bad notes", c0361e4);
            }
            baVar.m1884a();
            return a5;
        }
    }

    private static C0380e m1999a(Object obj) {
        try {
            return (C0380e) C0381f.f1720a.m1783d(C0357a.m1824c(obj));
        } catch (Throwable e) {
            throw new dl(e);
        } catch (Throwable e2) {
            throw new dl(e2);
        } catch (Throwable e22) {
            throw new dl(e22);
        }
    }
}
