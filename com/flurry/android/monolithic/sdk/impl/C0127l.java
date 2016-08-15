package com.flurry.android.monolithic.sdk.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.flurry.android.monolithic.sdk.impl.l */
public class C0127l implements aq, bi {
    static final String f552a;
    static String f553b;
    static String f554c;
    static String f555d;
    C0141z f556e;
    Set f557f;
    ExecutorService f558g;
    private boolean f559h;
    private ExecutorService f560i;

    static {
        f552a = C0127l.class.getSimpleName();
        f554c = "http://data.flurry.com/aap.do";
        f555d = "https://data.flurry.com/aap.do";
    }

    public C0127l() {
        this((byte) 0);
    }

    private C0127l(byte b) {
        this.f557f = new HashSet();
        jc.m611a().m613a((bi) this);
        this.f558g = Executors.newSingleThreadExecutor();
        this.f560i = Executors.newCachedThreadPool();
        ap a = ao.m552a();
        this.f559h = ((Boolean) a.m553a("UseHttps")).booleanValue();
        a.m554a("UseHttps", (aq) this);
        bh.m584a(4, "initSettings, UseHttps = " + this.f559h);
        String str = (String) a.m553a("ReportUrl");
        a.m554a("ReportUrl", (aq) this);
        C0127l.m618a(str);
        bh.m584a(4, "initSettings, ReportUrl = " + str);
        this.f558g.submit(new C0128m(this));
        m623a();
    }

    public final void m624a(String str, Object obj) {
        if (str.equals("UseHttps")) {
            this.f559h = ((Boolean) obj).booleanValue();
            bh.m584a(4, "onSettingUpdate, UseHttps = " + this.f559h);
        } else if (str.equals("ReportUrl")) {
            String str2 = (String) obj;
            C0127l.m618a(str2);
            bh.m584a(4, "onSettingUpdate, ReportUrl = " + str2);
        } else {
            bh.m584a(6, "onSettingUpdate internal error!");
        }
    }

    final void m623a() {
        this.f558g.submit(new C0131p(this));
    }

    public final void m625a(boolean z) {
        bh.m584a(4, "onNetworkStateChanged : isNetworkEnable = " + z);
        if (z) {
            m623a();
        }
    }

    private static void m618a(String str) {
        if (!(str == null || str.endsWith(".do"))) {
            bh.m584a(5, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        f553b = str;
    }

    private boolean m622d() {
        return this.f557f.size() <= 8;
    }

    static /* synthetic */ void m615a(C0127l c0127l) {
        if (jc.m611a().f547a) {
            List<String> arrayList = new ArrayList(c0127l.f556e.f597b.keySet());
            if (arrayList.isEmpty()) {
                bh.m584a(4, "No more reports to send.");
                return;
            }
            for (String str : arrayList) {
                if (c0127l.m622d()) {
                    List a = c0127l.f556e.m641a(str);
                    bh.m584a(4, "Number of not sent blocks = " + a.size());
                    for (int i = 0; i < a.size(); i++) {
                        String str2 = (String) a.get(i);
                        if (!c0127l.f557f.contains(str2)) {
                            if (!c0127l.m622d()) {
                                break;
                            }
                            byte[] a2 = new C0140x(str2).m633a();
                            if (a2 == null || a2.length == 0) {
                                bh.m584a(6, "Internal ERROR! Report is empty!");
                                c0127l.f556e.m643a(str2, str);
                            } else {
                                String str3;
                                c0127l.f557f.add(str2);
                                if (f553b != null) {
                                    str3 = f553b;
                                } else if (c0127l.f559h) {
                                    str3 = f555d;
                                } else {
                                    str3 = f554c;
                                }
                                bh.m584a(4, "FlurryDataSender: start upload data with id = " + str2 + " to " + str3);
                                c0127l.f560i.submit(new C0139w(str3, str2, str, a2, new C0134r(c0127l)));
                            }
                        }
                    }
                } else {
                    return;
                }
            }
            return;
        }
        bh.m584a(5, "Reports were not sent! No Internet connection!");
    }
}
