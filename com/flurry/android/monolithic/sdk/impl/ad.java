package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

public class ad implements al, aq {
    public static final String f386a;
    private static AtomicInteger f387l;
    private static AtomicInteger f388m;
    private int f389A;
    private boolean f390B;
    private String f391C;
    private byte f392D;
    private long f393E;
    private Map f394F;
    private List f395G;
    private boolean f396H;
    private int f397I;
    private List f398J;
    private int f399K;
    private Map f400L;
    private final Handler f401M;
    private ah f402N;
    String f403b;
    boolean f404c;
    public List f405d;
    public long f406e;
    public long f407f;
    public long f408g;
    public Map f409h;
    public aj f410i;
    public int f411j;
    public boolean f412k;
    private File f413n;
    private File f414o;
    private volatile boolean f415p;
    private String f416q;
    private List f417r;
    private Map f418s;
    private long f419t;
    private String f420u;
    private long f421v;
    private long f422w;
    private String f423x;
    private String f424y;
    private byte f425z;

    static {
        f386a = ad.class.getSimpleName();
        f387l = new AtomicInteger(0);
        f388m = new AtomicInteger(0);
    }

    public final void m534a(bk bkVar) {
        this.f401M.post(bkVar);
    }

    public ad(Context context, String str, ah ahVar) {
        this.f413n = null;
        this.f414o = null;
        this.f415p = false;
        this.f418s = new HashMap();
        this.f405d = new ArrayList();
        this.f423x = "";
        this.f424y = "";
        this.f425z = (byte) -1;
        this.f394F = new HashMap();
        this.f395G = new ArrayList();
        this.f398J = new ArrayList();
        this.f412k = false;
        bh.m584a(4, "Initializing new Flurry session");
        HandlerThread handlerThread = new HandlerThread("FlurryAgentSession_" + str);
        handlerThread.start();
        this.f401M = new Handler(handlerThread.getLooper());
        if (TextUtils.isEmpty(this.f420u)) {
            m534a(new af(this));
        }
        this.f410i = new aj(this);
        this.f402N = ahVar;
        this.f403b = str;
        this.f413n = context.getFileStreamPath(".flurryagent." + Integer.toString(this.f403b.hashCode(), 16));
        this.f414o = context.getFileStreamPath(".flurryinstallreceiver.");
        this.f416q = az.m573a();
        this.f421v = -1;
        this.f389A = 0;
        this.f424y = TimeZone.getDefault().getID();
        this.f423x = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
        this.f394F = new HashMap();
        this.f395G = new ArrayList();
        this.f396H = true;
        this.f398J = new ArrayList();
        this.f397I = 0;
        this.f399K = 0;
        f387l.set(0);
        f388m.set(0);
        ap a = ao.m552a();
        this.f392D = ((Byte) a.m553a("Gender")).byteValue();
        a.m554a("Gender", (aq) this);
        bh.m584a(4, "initSettings, Gender = " + this.f392D);
        this.f391C = (String) a.m553a("UserId");
        a.m554a("UserId", (aq) this);
        bh.m584a(4, "initSettings, UserId = " + this.f391C);
        this.f390B = ((Boolean) a.m553a("LogEvents")).booleanValue();
        a.m554a("LogEvents", (aq) this);
        bh.m584a(4, "initSettings, LogEvents = " + this.f390B);
        this.f393E = ((Long) a.m553a("Age")).longValue();
        a.m554a("Age", (aq) this);
        bh.m584a(4, "initSettings, BirthDate = " + this.f393E);
        this.f408g = ((Long) a.m553a("ContinueSessionMillis")).longValue();
        a.m554a("ContinueSessionMillis", (aq) this);
        bh.m584a(4, "initSettings, ContinueSessionMillis = " + this.f408g);
    }

    public final void m535a(String str, Object obj) {
        if (str.equals("Gender")) {
            this.f392D = ((Byte) obj).byteValue();
            bh.m584a(4, "onSettingUpdate, Gender = " + this.f392D);
        } else if (str.equals("UserId")) {
            this.f391C = (String) obj;
            bh.m584a(4, "onSettingUpdate, UserId = " + this.f391C);
        } else if (str.equals("LogEvents")) {
            this.f390B = ((Boolean) obj).booleanValue();
            bh.m584a(4, "onSettingUpdate, LogEvents = " + this.f390B);
        } else if (str.equals("Age")) {
            this.f393E = ((Long) obj).longValue();
            bh.m584a(4, "onSettingUpdate, Birthdate = " + this.f393E);
        } else if (str.equals("ContinueSessionMillis")) {
            this.f408g = ((Long) obj).longValue();
            bh.m584a(4, "onSettingUpdate, ContinueSessionMillis = " + this.f408g);
        } else {
            bh.m584a(6, "onSettingUpdate internal error!");
        }
    }

    public final void m533a() {
        if (this.f412k) {
            bh.m584a(5, "Ending session");
            this.f411j = 0;
            if (this.f410i.m550b()) {
                this.f410i.m548a();
            }
            this.f421v = SystemClock.elapsedRealtime() - this.f407f;
            long j = this.f421v;
            for (C0125j c0125j : this.f395G) {
                if (c0125j.f541c && !c0125j.f542d) {
                    c0125j.f542d = true;
                    c0125j.f543e = j - c0125j.f540b;
                    bh.m584a(3, "Ended event '" + c0125j.f539a + "' (" + c0125j.f540b + ") after " + c0125j.f543e + "ms");
                }
            }
            m534a(new ag(this, am.f442a.f443b));
            if (this.f402N != null) {
                this.f402N.m543a(this.f403b);
            }
            ao.m552a().m556b("Gender", this);
            ao.m552a().m556b("UserId", this);
            ao.m552a().m556b("Age", this);
            ao.m552a().m556b("LogEvents", this);
            ao.m552a().m556b("ContinueSessionMillis", this);
            this.f401M.getLooper().quit();
        }
    }

    private synchronized aa m524c() {
        aa aaVar;
        String str;
        ab abVar = new ab();
        abVar.f364a = this.f416q;
        abVar.f365b = this.f406e;
        abVar.f366c = this.f421v;
        abVar.f367d = this.f422w;
        abVar.f368e = this.f423x;
        abVar.f369f = this.f424y;
        abVar.f370g = this.f425z;
        if (this.f391C == null) {
            str = "";
        } else {
            str = this.f391C;
        }
        abVar.f371h = str;
        C0121f.m598a();
        abVar.f372i = C0121f.m602d();
        abVar.f373j = this.f399K;
        abVar.f374k = this.f392D;
        abVar.f375l = Long.valueOf(this.f393E);
        abVar.f376m = this.f395G;
        abVar.f379p = this.f394F;
        abVar.f378o = this.f398J;
        abVar.f377n = this.f389A;
        abVar.f380q = this.f396H;
        try {
            aaVar = new aa(abVar);
        } catch (IOException e) {
            e.printStackTrace();
            aaVar = null;
        }
        if (aaVar == null) {
            bh.m584a(6, "New session report wasn't created");
        }
        return aaVar;
    }

    public final synchronized void m537a(String str, Map map) {
        if (this.f395G == null) {
            bh.m584a(6, "onEvent called before onStartSession.  Event: " + str);
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f407f;
            String a = bj.m595a(str);
            if (a.length() != 0) {
                C0122g c0122g = (C0122g) this.f394F.get(a);
                if (c0122g != null) {
                    c0122g.f530a++;
                } else if (this.f394F.size() < 100) {
                    c0122g = new C0122g();
                    c0122g.f530a = 1;
                    this.f394F.put(a, c0122g);
                    bh.m584a(3, "Event count incremented: " + a);
                } else {
                    bh.m584a(5, "Too many different events. Event not counted: " + a);
                }
                if (!this.f390B || this.f395G.size() >= 1000 || this.f397I >= 160000) {
                    this.f396H = false;
                } else {
                    Map emptyMap;
                    if (map == null) {
                        emptyMap = Collections.emptyMap();
                    } else {
                        emptyMap = map;
                    }
                    if (emptyMap.size() > 10) {
                        bh.m584a(5, "MaxEventParams exceeded: " + emptyMap.size());
                    } else {
                        C0125j c0125j = new C0125j(f387l.incrementAndGet(), a, emptyMap, elapsedRealtime);
                        if (c0125j.m610a().length + this.f397I <= 160000) {
                            this.f395G.add(c0125j);
                            this.f397I = c0125j.m610a().length + this.f397I;
                        } else {
                            this.f397I = 160000;
                            this.f396H = false;
                            bh.m584a(5, "Event Log size exceeded. No more event details logged.");
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m536a(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Throwable r13) {
        /*
        r9 = this;
        r0 = 0;
        monitor-enter(r9);
        r1 = r9.f398J;	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x001b;
    L_0x0006:
        r0 = 6;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006c }
        r2 = "onError called before onStartSession.  Error: ";
        r1.<init>(r2);	 Catch:{ all -> 0x006c }
        r1 = r1.append(r10);	 Catch:{ all -> 0x006c }
        r1 = r1.toString();	 Catch:{ all -> 0x006c }
        com.flurry.android.monolithic.sdk.impl.bh.m584a(r0, r1);	 Catch:{ all -> 0x006c }
    L_0x0019:
        monitor-exit(r9);
        return;
    L_0x001b:
        if (r10 == 0) goto L_0x006f;
    L_0x001d:
        r1 = "uncaught";
        r1 = r1.equals(r10);	 Catch:{ all -> 0x006c }
        if (r1 == 0) goto L_0x006f;
    L_0x0025:
        r1 = 1;
    L_0x0026:
        r2 = r9.f389A;	 Catch:{ all -> 0x006c }
        r2 = r2 + 1;
        r9.f389A = r2;	 Catch:{ all -> 0x006c }
        r2 = r9.f398J;	 Catch:{ all -> 0x006c }
        r2 = r2.size();	 Catch:{ all -> 0x006c }
        r3 = 50;
        if (r2 >= r3) goto L_0x0071;
    L_0x0036:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x006c }
        r2 = java.lang.Long.valueOf(r0);	 Catch:{ all -> 0x006c }
        r0 = new com.flurry.android.monolithic.sdk.impl.i;	 Catch:{ all -> 0x006c }
        r1 = f388m;	 Catch:{ all -> 0x006c }
        r1 = r1.incrementAndGet();	 Catch:{ all -> 0x006c }
        r2 = r2.longValue();	 Catch:{ all -> 0x006c }
        r4 = r10;
        r5 = r11;
        r6 = r12;
        r7 = r13;
        r0.<init>(r1, r2, r4, r5, r6, r7);	 Catch:{ all -> 0x006c }
        r1 = r9.f398J;	 Catch:{ all -> 0x006c }
        r1.add(r0);	 Catch:{ all -> 0x006c }
        r1 = 3;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006c }
        r3 = "Error logged: ";
        r2.<init>(r3);	 Catch:{ all -> 0x006c }
        r0 = r0.f533a;	 Catch:{ all -> 0x006c }
        r0 = r2.append(r0);	 Catch:{ all -> 0x006c }
        r0 = r0.toString();	 Catch:{ all -> 0x006c }
        com.flurry.android.monolithic.sdk.impl.bh.m584a(r1, r0);	 Catch:{ all -> 0x006c }
        goto L_0x0019;
    L_0x006c:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x006f:
        r1 = r0;
        goto L_0x0026;
    L_0x0071:
        if (r1 == 0) goto L_0x00b8;
    L_0x0073:
        r8 = r0;
    L_0x0074:
        r0 = r9.f398J;	 Catch:{ all -> 0x006c }
        r0 = r0.size();	 Catch:{ all -> 0x006c }
        if (r8 >= r0) goto L_0x0019;
    L_0x007c:
        r0 = r9.f398J;	 Catch:{ all -> 0x006c }
        r0 = r0.get(r8);	 Catch:{ all -> 0x006c }
        r0 = (com.flurry.android.monolithic.sdk.impl.C0124i) r0;	 Catch:{ all -> 0x006c }
        r1 = r0.f533a;	 Catch:{ all -> 0x006c }
        if (r1 == 0) goto L_0x00b4;
    L_0x0088:
        r1 = "uncaught";
        r0 = r0.f533a;	 Catch:{ all -> 0x006c }
        r0 = r1.equals(r0);	 Catch:{ all -> 0x006c }
        if (r0 != 0) goto L_0x00b4;
    L_0x0092:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x006c }
        r2 = java.lang.Long.valueOf(r0);	 Catch:{ all -> 0x006c }
        r0 = new com.flurry.android.monolithic.sdk.impl.i;	 Catch:{ all -> 0x006c }
        r1 = f388m;	 Catch:{ all -> 0x006c }
        r1 = r1.incrementAndGet();	 Catch:{ all -> 0x006c }
        r2 = r2.longValue();	 Catch:{ all -> 0x006c }
        r4 = r10;
        r5 = r11;
        r6 = r12;
        r7 = r13;
        r0.<init>(r1, r2, r4, r5, r6, r7);	 Catch:{ all -> 0x006c }
        r1 = r9.f398J;	 Catch:{ all -> 0x006c }
        r1.set(r8, r0);	 Catch:{ all -> 0x006c }
        goto L_0x0019;
    L_0x00b4:
        r0 = r8 + 1;
        r8 = r0;
        goto L_0x0074;
    L_0x00b8:
        r0 = 3;
        r1 = "Max errors logged. No more errors logged.";
        com.flurry.android.monolithic.sdk.impl.bh.m584a(r0, r1);	 Catch:{ all -> 0x006c }
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.android.monolithic.sdk.impl.ad.a(java.lang.String, java.lang.String, java.lang.String, java.lang.Throwable):void");
    }

    private void m527d() {
        try {
            bh.m584a(3, "generating agent report");
            C0126k c0126k = new C0126k(this.f403b, this.f416q, this.f420u, this.f404c, this.f419t, this.f406e, this.f405d, this.f414o, this.f418s, this.f400L, this.f409h);
            this.f417r = new ArrayList(this.f405d);
            if (c0126k.f551a != null) {
                bh.m584a(3, "generated report of size " + c0126k.f551a.length + " with " + this.f405d.size() + " reports.");
                byte[] bArr = c0126k.f551a;
                C0127l c0127l = C0121f.m598a().f527c;
                StringBuilder stringBuilder = new StringBuilder();
                C0121f.m598a();
                String stringBuilder2 = stringBuilder.append(C0121f.m600b()).toString();
                String str = this.f403b;
                if (bArr == null || bArr.length == 0) {
                    String str2 = C0127l.f552a;
                    bh.m584a(6, "Report that has to be sent is EMPTY or NULL");
                } else {
                    c0127l.f558g.submit(new C0132q(c0127l, bArr, str, stringBuilder2));
                    c0127l.m623a();
                }
                this.f405d.removeAll(this.f417r);
                this.f417r = null;
                m529e();
                return;
            }
            bh.m584a(6, "Error generating report");
        } catch (Throwable th) {
            bh.m590b("", th);
        }
    }

    private synchronized void m529e() {
        if (bd.m579a(this.f413n)) {
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.f413n));
                ai aiVar = new ai();
                aiVar.f434a = this.f404c;
                aiVar.f436c = this.f419t;
                aiVar.f435b = this.f405d;
                aiVar.m546a(dataOutputStream, this.f403b, this.f420u);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else {
            bh.m584a(6, "ERROR! CREATE PARENT DIR DIDN'T PROCCEED");
        }
    }

    private synchronized void m530f() {
        Closeable dataInputStream;
        Throwable th;
        if (this.f413n.exists()) {
            bh.m584a(4, "loading persistent data: " + this.f413n.getAbsolutePath());
            try {
                dataInputStream = new DataInputStream(new FileInputStream(this.f413n));
                try {
                    ai aiVar = new ai();
                    this.f415p = aiVar.m547a((DataInputStream) dataInputStream, this.f403b);
                    if (this.f415p) {
                        this.f404c = aiVar.f434a;
                        this.f419t = aiVar.f436c;
                        this.f405d = aiVar.f435b;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bh.m590b("Error when loading persistent file", th);
                        bj.m596a(dataInputStream);
                        if (!this.f415p) {
                            if (this.f413n.delete()) {
                                bh.m584a(6, "Cannot delete persistence file");
                            } else {
                                bh.m584a(3, "Deleted persistence file");
                            }
                        }
                        if (!this.f415p) {
                            this.f404c = false;
                            this.f419t = this.f406e;
                            this.f415p = true;
                        }
                        this.f400L = new C0123h(this.f414o).m608a();
                    } catch (Throwable th3) {
                        th = th3;
                        bj.m596a(dataInputStream);
                        throw th;
                    }
                }
                bj.m596a(dataInputStream);
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                bj.m596a(dataInputStream);
                throw th;
            }
            try {
                if (this.f415p) {
                    if (this.f413n.delete()) {
                        bh.m584a(3, "Deleted persistence file");
                    } else {
                        bh.m584a(6, "Cannot delete persistence file");
                    }
                }
            } catch (Throwable th5) {
                bh.m590b("", th5);
            }
        } else {
            bh.m584a(4, "Agent cache file doesn't exist.");
        }
        if (this.f415p) {
            this.f404c = false;
            this.f419t = this.f406e;
            this.f415p = true;
        }
        this.f400L = new C0123h(this.f414o).m608a();
    }

    public final void m538b() {
        if (this.f411j != 0) {
            bh.m584a(6, "Error! Session with apiKey = " + this.f403b + " was ended while getSessionCount() is not 0");
        }
        m533a();
    }

    static /* synthetic */ void m525c(ad adVar) {
        try {
            byte[] a = au.m559a();
            if (a != null) {
                bh.m584a(3, "Fetched hashed IMEI");
                adVar.f418s.put(as.Sha1Imei, ByteBuffer.wrap(a));
            }
            adVar.m527d();
        } catch (Throwable th) {
            bh.m590b("", th);
        }
    }

    static /* synthetic */ void m532g(ad adVar) {
        try {
            Object obj;
            synchronized (adVar) {
                obj = adVar.f405d.size() > 0 ? 1 : null;
            }
            if (obj != null) {
                adVar.m527d();
            }
        } catch (Throwable th) {
            bh.m590b("", th);
        }
    }
}
