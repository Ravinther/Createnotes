package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.data.C0231u;
import com.socialnmobile.colornote.data.aa;

public final class av {
    final C0367b f1502a;
    final C0231u f1503b;
    final aa f1504c;

    private long m1809a(com.socialnmobile.colornote.data.C0232v r11, com.socialnmobile.colornote.sync.cm r12) {
        /* JADX: method processing error */
/*
        Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r10 = this;
        r4 = r12.m1852n();
        r0 = r12.f1627a;
        r0 = r0.f1733a;
        r0 = r0.m2010c();
        r0 = (java.util.UUID) r0;
        if (r0 != 0) goto L_0x0018;
    L_0x0010:
        r0 = "sid is null";
        com.socialnmobile.colornote.ColorNote.m651a(r0);
        r0 = -1;
    L_0x0017:
        return r0;
    L_0x0018:
        r1 = r12.f1627a;
        r1 = r1.f1734b;
        r1 = r1.m2010c();
        r1 = (java.lang.Long) r1;
        if (r1 != 0) goto L_0x002c;
    L_0x0024:
        r0 = "revision is null";
        com.socialnmobile.colornote.ColorNote.m651a(r0);
        r0 = -1;
        goto L_0x0017;
    L_0x002c:
        r1 = "dirty";
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r4.put(r1, r2);
        r1 = r11.f1027a;
        r1.beginTransaction();
        r1 = r10.f1504c;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r1.m910a(r0);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        if (r1 != 0) goto L_0x005f;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x0043:
        r1 = 1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r12.m1965a(r1);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r10.f1504c;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2 = r1.m909a(r4);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r4 = 0;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        if (r1 <= 0) goto L_0x00e9;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x0053:
        r1 = r11.f1027a;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1.setTransactionSuccessful();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = r2;
    L_0x0059:
        r2 = r11.f1027a;
        r2.endTransaction();
        goto L_0x0017;
    L_0x005f:
        r2 = 0;
        r12.m1965a(r2);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2 = new com.socialnmobile.util.b.a.e;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r3 = "_id";	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2.<init>(r3);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r3 = new com.socialnmobile.util.b.l;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r3.<init>(r2);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r5 = new com.socialnmobile.colornote.sync.dx;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r5.<init>();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r3.m2321c(r1);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r5.m1850c(r1);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r3.m2320c();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = (java.lang.Long) r1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2 = r1.longValue();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r5.f1770b;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r1.m2010c();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = (java.lang.Integer) r1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r1.intValue();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        if (r1 == 0) goto L_0x00b6;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x0092:
        r1 = 1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x0093:
        if (r1 == 0) goto L_0x00b8;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x0095:
        r1 = new com.socialnmobile.colornote.sync.aw;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1.<init>();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        throw r1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x009b:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r0.toString();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        com.socialnmobile.colornote.ColorNote.m651a(r1);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = com.socialnmobile.colornote.C0311h.f1370a;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2 = "CheckoutDock.insert()";	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1.m1624a(r2, r0);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = r11.f1027a;
        r0.endTransaction();
        r0 = -1;
        goto L_0x0017;
    L_0x00b6:
        r1 = 0;
        goto L_0x0093;
    L_0x00b8:
        r1 = r5.f1769a;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r1.m2010c();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = (java.lang.Integer) r1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r1.intValue();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r1 & 1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        if (r1 == 0) goto L_0x00ec;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00c8:
        r1 = 1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00c9:
        if (r1 != 0) goto L_0x00dc;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00cb:
        r1 = r5.f1769a;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r1.m2010c();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = (java.lang.Integer) r1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r1.intValue();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        if (r1 == 0) goto L_0x00ee;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00d9:
        r1 = 1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00da:
        if (r1 == 0) goto L_0x00f0;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00dc:
        r2 = 0;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00de:
        r4 = 0;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        if (r1 < 0) goto L_0x00e9;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00e4:
        r1 = r11.f1027a;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1.setTransactionSuccessful();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00e9:
        r0 = r2;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        goto L_0x0059;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00ec:
        r1 = 0;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        goto L_0x00c9;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00ee:
        r1 = 0;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        goto L_0x00da;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x00f0:
        r1 = r10.f1504c;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r5 = new com.socialnmobile.util.b.n;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r6 = "_id=?";	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r7 = 1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r7 = new java.lang.Object[r7];	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r8 = 0;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r9 = java.lang.Long.valueOf(r2);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r7[r8] = r9;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r5.<init>(r6, r7);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1 = r1.m906a(r4, r5);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r4 = 1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        if (r1 == r4) goto L_0x00de;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x010a:
        r1 = new com.socialnmobile.colornote.sync.ax;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r1.<init>();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        throw r1;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
    L_0x0110:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r3 = "Note of uuid ";	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2.<init>(r3);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = r2.append(r0);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2 = " is in commit; checkout failed";	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = r0.append(r2);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = r0.toString();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        com.socialnmobile.colornote.ColorNote.m651a(r0);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = com.socialnmobile.colornote.C0311h.f1370a;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2 = "CheckoutDock.insert()";	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0.m1624a(r2, r1);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = r11.f1027a;
        r0.endTransaction();
        r0 = -1;
        goto L_0x0017;
    L_0x0139:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r3 = "Note of uuid ";	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2.<init>(r3);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = r2.append(r0);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2 = ": is not updated; checkout failed";	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = r0.append(r2);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = r0.toString();	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        com.socialnmobile.colornote.ColorNote.m651a(r0);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = com.socialnmobile.colornote.C0311h.f1370a;	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r2 = "CheckoutDock.insert()";	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0.m1624a(r2, r1);	 Catch:{ SQLException -> 0x009b, aw -> 0x0110, ax -> 0x0139, all -> 0x0162 }
        r0 = r11.f1027a;
        r0.endTransaction();
        r0 = -1;
        goto L_0x0017;
    L_0x0162:
        r0 = move-exception;
        r1 = r11.f1027a;
        r1.endTransaction();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.sync.av.a(com.socialnmobile.colornote.data.v, com.socialnmobile.colornote.sync.cm):long");
    }

    public av(C0367b c0367b, C0231u c0231u) {
        this.f1502a = c0367b;
        this.f1503b = c0231u;
        this.f1504c = new aa(c0231u);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m1810a(long r22, com.socialnmobile.colornote.sync.p018b.C0360d r24) {
        /*
        r21 = this;
        r3 = 0;
        r2 = 0;
        r0 = r21;
        r4 = r0.f1502a;
        r4 = r4.m1863k();
        r5 = com.socialnmobile.colornote.sync.cs.f1643a;
        r8 = new com.socialnmobile.colornote.sync.cn;
        r8.<init>(r4);
        r0 = r21;
        r4 = r0.f1503b;
        r9 = r4.m1074f();
        r10 = r24.iterator();
        r5 = r2;
        r4 = r3;
    L_0x001f:
        r2 = r10.hasNext();
        if (r2 == 0) goto L_0x01b5;
    L_0x0025:
        r2 = r10.next();
        r3 = r9.f1027a;
        r3.beginTransaction();
        r2 = (com.socialnmobile.colornote.sync.p018b.C0360d) r2;	 Catch:{ cl -> 0x00d0 }
        r3 = 0;
        r3 = r2.get(r3);	 Catch:{ cl -> 0x00d0 }
        r3 = (java.lang.Number) r3;	 Catch:{ cl -> 0x00d0 }
        r12 = r3.longValue();	 Catch:{ cl -> 0x00d0 }
        r3 = 1;
        r2 = r2.get(r3);	 Catch:{ cl -> 0x00d0 }
        r2 = (com.socialnmobile.colornote.sync.p018b.C0360d) r2;	 Catch:{ cl -> 0x00d0 }
        r3 = 0;
        r11 = new com.socialnmobile.colornote.sync.cm;	 Catch:{ cl -> 0x00d0 }
        r11.<init>();	 Catch:{ cl -> 0x00d0 }
        r14 = r2.iterator();	 Catch:{ cl -> 0x00d0 }
        r7 = r3;
        r6 = r4;
    L_0x004e:
        r3 = r14.hasNext();	 Catch:{ cl -> 0x00d0 }
        if (r3 == 0) goto L_0x0154;
    L_0x0054:
        r3 = r14.next();	 Catch:{ cl -> 0x00d0 }
        r3 = (com.socialnmobile.colornote.sync.p018b.C0361e) r3;	 Catch:{ cl -> 0x00d0 }
        r4 = new android.content.ContentValues;	 Catch:{ cl -> 0x00d0 }
        r4.<init>();	 Catch:{ cl -> 0x00d0 }
        r11.m1850c(r4);	 Catch:{ cl -> 0x00d0 }
        r8.m1968a(r3);	 Catch:{ bf -> 0x0071 }
        com.socialnmobile.colornote.sync.cs.m1973a(r11, r3);	 Catch:{ cl -> 0x00d0 }
        r0 = r21;
        r0.m1809a(r9, r11);	 Catch:{ cl -> 0x00d0 }
        r3 = r7 + 1;
        r7 = r3;
        goto L_0x004e;
    L_0x0071:
        r4 = move-exception;
        r15 = com.socialnmobile.colornote.C0311h.f1370a;	 Catch:{ cl -> 0x00d0 }
        r16 = "CheckoutDock.importCheckouts()";
        r0 = r16;
        r15.m1625a(r0, r4, r3);	 Catch:{ cl -> 0x00d0 }
        r4.printStackTrace();	 Catch:{ cl -> 0x00d0 }
        r4 = com.socialnmobile.colornote.sync.dk.f1737a;	 Catch:{ cl -> 0x00d0 }
        r4 = r11.f1627a;	 Catch:{ cl -> 0x00d0 }
        com.socialnmobile.colornote.sync.dk.m1995b(r4, r3);	 Catch:{ cl -> 0x00d0 }
        r3 = r11.f1627a;	 Catch:{ cl -> 0x00d0 }
        r3 = r3.f1733a;	 Catch:{ cl -> 0x00d0 }
        r3 = r3.m2010c();	 Catch:{ cl -> 0x00d0 }
        r3 = (java.util.UUID) r3;	 Catch:{ cl -> 0x00d0 }
        r4 = r9.f1027a;	 Catch:{ cl -> 0x00d0 }
        r4.beginTransaction();	 Catch:{ cl -> 0x00d0 }
        r0 = r21;
        r4 = r0.f1504c;	 Catch:{ all -> 0x00c9 }
        r4 = r4.m910a(r3);	 Catch:{ all -> 0x00c9 }
        if (r4 != 0) goto L_0x00f1;
    L_0x009e:
        r4 = r11.f1628b;	 Catch:{ all -> 0x00c9 }
        r4 = r4.f1659e;	 Catch:{ all -> 0x00c9 }
        r15 = 32;
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ all -> 0x00c9 }
        r4.m2008a(r15);	 Catch:{ all -> 0x00c9 }
        r4 = 1;
        r11.m1965a(r4);	 Catch:{ all -> 0x00c9 }
        r0 = r21;
        r4 = r0.f1504c;	 Catch:{ all -> 0x00c9 }
        r15 = r11.m1852n();	 Catch:{ all -> 0x00c9 }
        r16 = r4.m909a(r15);	 Catch:{ all -> 0x00c9 }
        r18 = 0;
        r4 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1));
        if (r4 > 0) goto L_0x012c;
    L_0x00c1:
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x00c9 }
        r3 = "can't insert note";
        r2.<init>(r3);	 Catch:{ all -> 0x00c9 }
        throw r2;	 Catch:{ all -> 0x00c9 }
    L_0x00c9:
        r2 = move-exception;
        r3 = r9.f1027a;	 Catch:{ cl -> 0x00d0 }
        r3.endTransaction();	 Catch:{ cl -> 0x00d0 }
        throw r2;	 Catch:{ cl -> 0x00d0 }
    L_0x00d0:
        r2 = move-exception;
        r3 = new com.socialnmobile.colornote.sync.b.e;	 Catch:{ all -> 0x00ea }
        r3.<init>();	 Catch:{ all -> 0x00ea }
        r4 = "checkouts";
        r0 = r24;
        r3.m1833a(r4, r0);	 Catch:{ all -> 0x00ea }
        r4 = com.socialnmobile.colornote.C0311h.f1370a;	 Catch:{ all -> 0x00ea }
        r5 = "CheckoutDoc.importCheckouts()";
        r4.m1625a(r5, r2, r3);	 Catch:{ all -> 0x00ea }
        r3 = new com.socialnmobile.colornote.sync.dl;	 Catch:{ all -> 0x00ea }
        r3.<init>(r2);	 Catch:{ all -> 0x00ea }
        throw r3;	 Catch:{ all -> 0x00ea }
    L_0x00ea:
        r2 = move-exception;
        r3 = r9.f1027a;
        r3.endTransaction();
        throw r2;
    L_0x00f1:
        r4 = r11.f1627a;	 Catch:{ all -> 0x00c9 }
        r4 = r4.f1734b;	 Catch:{ all -> 0x00c9 }
        r4 = r4.m2010c();	 Catch:{ all -> 0x00c9 }
        r4 = (java.lang.Long) r4;	 Catch:{ all -> 0x00c9 }
        r15 = new android.content.ContentValues;	 Catch:{ all -> 0x00c9 }
        r15.<init>();	 Catch:{ all -> 0x00c9 }
        r16 = new com.socialnmobile.colornote.sync.di;	 Catch:{ all -> 0x00c9 }
        r16.<init>();	 Catch:{ all -> 0x00c9 }
        r0 = r16;
        r0.m1850c(r15);	 Catch:{ all -> 0x00c9 }
        r0 = r16;
        r0 = r0.f1734b;	 Catch:{ all -> 0x00c9 }
        r16 = r0;
        r0 = r16;
        r0.m2008a(r4);	 Catch:{ all -> 0x00c9 }
        r4 = 1;
        r0 = r21;
        r0 = r0.f1504c;	 Catch:{ all -> 0x00c9 }
        r16 = r0;
        r0 = r16;
        r15 = r0.m907a(r15, r3);	 Catch:{ all -> 0x00c9 }
        if (r4 == r15) goto L_0x012c;
    L_0x0124:
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x00c9 }
        r3 = "can't update note revision";
        r2.<init>(r3);	 Catch:{ all -> 0x00c9 }
        throw r2;	 Catch:{ all -> 0x00c9 }
    L_0x012c:
        r4 = 1;
        r0 = r21;
        r15 = r0.f1504c;	 Catch:{ all -> 0x00c9 }
        r3 = com.socialnmobile.colornote.data.aa.m904b(r3);	 Catch:{ all -> 0x00c9 }
        r3 = r15.m908a(r3);	 Catch:{ all -> 0x00c9 }
        if (r4 == r3) goto L_0x0143;
    L_0x013b:
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x00c9 }
        r3 = "can't mark note dirty";
        r2.<init>(r3);	 Catch:{ all -> 0x00c9 }
        throw r2;	 Catch:{ all -> 0x00c9 }
    L_0x0143:
        r3 = r9.f1027a;	 Catch:{ all -> 0x00c9 }
        r3.setTransactionSuccessful();	 Catch:{ all -> 0x00c9 }
        r3 = r9.f1027a;	 Catch:{ cl -> 0x00d0 }
        r3.endTransaction();	 Catch:{ cl -> 0x00d0 }
        r3 = r7 + 1;
        r6 = r6 + 1;
        r7 = r3;
        goto L_0x004e;
    L_0x0154:
        r2 = r2.size();	 Catch:{ cl -> 0x00d0 }
        if (r7 == r2) goto L_0x0162;
    L_0x015a:
        r2 = new java.lang.RuntimeException;	 Catch:{ cl -> 0x00d0 }
        r3 = "not all checkout notes imported";
        r2.<init>(r3);	 Catch:{ cl -> 0x00d0 }
        throw r2;	 Catch:{ cl -> 0x00d0 }
    L_0x0162:
        r2 = r5 + r7;
        r0 = r21;
        r3 = r0.f1502a;	 Catch:{ cl -> 0x00d0 }
        r3.m1876a(r12);	 Catch:{ cl -> 0x00d0 }
        r3 = r9.f1027a;	 Catch:{ cl -> 0x00d0 }
        r3.setTransactionSuccessful();	 Catch:{ cl -> 0x00d0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ cl -> 0x00d0 }
        r4 = "checkout: rev=";
        r3.<init>(r4);	 Catch:{ cl -> 0x00d0 }
        r3 = r3.append(r12);	 Catch:{ cl -> 0x00d0 }
        r4 = " count=";
        r3 = r3.append(r4);	 Catch:{ cl -> 0x00d0 }
        r3.append(r7);	 Catch:{ cl -> 0x00d0 }
        if (r6 <= 0) goto L_0x01ac;
    L_0x0186:
        r3 = new com.socialnmobile.colornote.sync.b.e;	 Catch:{ cl -> 0x00d0 }
        r3.<init>();	 Catch:{ cl -> 0x00d0 }
        r4 = "nFailedDecryption";
        r5 = java.lang.Integer.valueOf(r6);	 Catch:{ cl -> 0x00d0 }
        r3.m1833a(r4, r5);	 Catch:{ cl -> 0x00d0 }
        r4 = "Account";
        r5 = com.socialnmobile.colornote.sync.C0383e.f1774a;	 Catch:{ cl -> 0x00d0 }
        r0 = r21;
        r7 = r0.f1502a;	 Catch:{ cl -> 0x00d0 }
        r5 = r5.m1782c(r7);	 Catch:{ cl -> 0x00d0 }
        r3.m1833a(r4, r5);	 Catch:{ cl -> 0x00d0 }
        r4 = com.socialnmobile.colornote.C0311h.f1370a;	 Catch:{ cl -> 0x00d0 }
        r5 = "CheckoutDock.importCheckouts()";
        r7 = "Failed Decryption";
        r4.m1622a(r5, r7, r3);	 Catch:{ cl -> 0x00d0 }
    L_0x01ac:
        r3 = r9.f1027a;
        r3.endTransaction();
        r5 = r2;
        r4 = r6;
        goto L_0x001f;
    L_0x01b5:
        r0 = r21;
        r2 = r0.f1502a;
        r0 = r22;
        r2.m1876a(r0);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.sync.av.a(long, com.socialnmobile.colornote.sync.b.d):int");
    }
}
