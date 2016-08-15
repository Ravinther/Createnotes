package com.socialnmobile.colornote.sync;

import android.content.Context;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.util.p011b.C0385e;
import java.util.HashMap;

/* renamed from: com.socialnmobile.colornote.sync.g */
public final class C0386g implements C0385e {
    final C0366d f1777a;
    final C0396k f1778b;
    Context f1779c;

    public final /* synthetic */ Object m2017c() {
        return m2012a();
    }

    public C0386g(C0366d c0366d) {
        this.f1778b = new C0396k();
        this.f1779c = null;
        this.f1777a = c0366d;
    }

    public final void m2013a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        this.f1779c = context;
    }

    public final C0384f m2012a() {
        try {
            return m2011d();
        } catch (Throwable e) {
            C0311h.f1370a.m1625a("Invalid AccountExtraInfo", e, (C0361e) C0383e.f1774a.m1782c(this.f1777a));
            return new C0384f();
        }
    }

    private C0384f m2011d() {
        C0384f a;
        C0388i c0388i;
        C0405u c0405u;
        String str;
        bd bsVar;
        as asVar;
        C0361e b;
        String h;
        long longValue;
        cq a2;
        bg bgVar;
        bg bgVar2;
        C0409z c0409z;
        HashMap a3;
        C0361e b2;
        dd ddVar;
        Number g;
        boolean z;
        try {
            a = this.f1778b.m2033a(this.f1777a);
        } catch (C0397l e) {
            try {
                c0388i = new C0388i(this.f1777a, this.f1779c);
                c0405u = c0388i.f1785e;
                if (c0405u == C0405u.f1818a) {
                    str = (String) c0388i.f1781a.f1533r.m2010c();
                    bsVar = new bs(str);
                    if (str == null) {
                        C0311h.f1370a.m1622a("AccountExtraInfoField v2 email", "email is null", (C0361e) C0383e.f1774a.m1782c(c0388i.f1781a));
                    }
                    asVar = new as(C0405u.f1818a, str, bsVar);
                } else if (c0405u == C0405u.f1820c) {
                    b = c0388i.m2026b();
                    if (b == null) {
                        h = b.m1842h(AccountColumns.EMAIL);
                    } else {
                        h = null;
                    }
                    asVar = new as(C0405u.f1820c, h, c0388i.m2024a(cj.f1624c));
                } else if (c0405u != C0405u.f1819b) {
                    b = c0388i.m2026b();
                    if (b == null) {
                        h = b.m1842h("id");
                    } else {
                        h = null;
                    }
                    asVar = new as(C0405u.f1819b, h, c0388i.m2023a(cg.f1619c));
                } else {
                    throw new IllegalStateException("unsupported authority: " + c0405u);
                }
                longValue = ((Long) c0388i.f1781a.f1528m.m2010c()).longValue();
                a2 = c0388i.m2025a();
                bgVar = new bg(0);
                bgVar = new bg(0);
                bgVar2 = (bg) c0388i.f1781a.f1530o.m2010c();
                c0409z = new C0409z();
                if (asVar.f1499b != null) {
                    a3 = c0409z.m2062a(asVar.f1498a);
                    c0405u = asVar.f1498a;
                    b2 = c0388i.m2026b();
                    if (c0405u == C0405u.f1819b || b2 == null) {
                        ddVar = null;
                    } else {
                        Number g2;
                        Number g3;
                        String str2;
                        str = b2.m1842h("id");
                        h = b2.m1842h("updated_time");
                        String h2 = b2.m1842h("name");
                        String h3 = b2.m1842h("first_name");
                        String h4 = b2.m1842h("last_name");
                        String h5 = b2.m1842h("gender");
                        String h6 = b2.m1842h("locale");
                        C0361e j = b2.m1844j("age_range");
                        if (j != null) {
                            g2 = j.m1841g("ageRangeMin");
                            g3 = j.m1841g("ageRangeMax");
                        } else {
                            g2 = null;
                            g3 = null;
                        }
                        if (str != null) {
                            str2 = "https://graph.facebook.com/" + str + "/picture";
                        } else {
                            str2 = null;
                        }
                        ddVar = new dd(h, h2, h3, h4, h5, h6, g2, g3, str2);
                    }
                    a3.put(asVar.f1499b, new aa(asVar.f1498a, asVar.f1499b, ddVar));
                }
                if (c0388i.f1783c == null) {
                    g = c0388i.f1783c.m1841g("hidden");
                    if (g != null || g.intValue() == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    z = false;
                }
                a = new C0384f(new C0401q(longValue, a2, bgVar, bgVar, bgVar2, 0, c0409z, z, (byte) 0), new bm(asVar));
            } catch (C0389j e2) {
                if (this.f1779c != null) {
                    if (this.f1779c != null) {
                        throw new IllegalStateException("context is null");
                    }
                    try {
                        a = (C0384f) new C0387h(this.f1779c).m1783d(this.f1777a);
                        return a;
                    } catch (Throwable e3) {
                        C0311h.f1370a.m1625a("Malformed AccountExtraInfo V1", e3, (C0361e) C0383e.f1774a.m1782c(this.f1777a));
                        throw new IllegalStateException("invalid account data");
                    }
                }
                throw new IllegalStateException("invalid account data");
            } catch (Throwable e32) {
                C0311h.f1370a.m1625a("Malformed AccountExtraInfo V2", e32, (C0361e) C0383e.f1774a.m1782c(this.f1777a));
                if (this.f1779c != null) {
                    if (this.f1779c != null) {
                        a = (C0384f) new C0387h(this.f1779c).m1783d(this.f1777a);
                        return a;
                    }
                    throw new IllegalStateException("context is null");
                }
                throw new IllegalStateException("invalid account data");
            }
            return a;
        } catch (Throwable e322) {
            C0311h.f1370a.m1625a("Malformed AccountExtraInfo V3", e322, (C0361e) C0383e.f1774a.m1782c(this.f1777a));
            c0388i = new C0388i(this.f1777a, this.f1779c);
            c0405u = c0388i.f1785e;
            if (c0405u == C0405u.f1818a) {
                str = (String) c0388i.f1781a.f1533r.m2010c();
                bsVar = new bs(str);
                if (str == null) {
                    C0311h.f1370a.m1622a("AccountExtraInfoField v2 email", "email is null", (C0361e) C0383e.f1774a.m1782c(c0388i.f1781a));
                }
                asVar = new as(C0405u.f1818a, str, bsVar);
            } else if (c0405u == C0405u.f1820c) {
                b = c0388i.m2026b();
                if (b == null) {
                    h = null;
                } else {
                    h = b.m1842h(AccountColumns.EMAIL);
                }
                asVar = new as(C0405u.f1820c, h, c0388i.m2024a(cj.f1624c));
            } else if (c0405u != C0405u.f1819b) {
                throw new IllegalStateException("unsupported authority: " + c0405u);
            } else {
                b = c0388i.m2026b();
                if (b == null) {
                    h = null;
                } else {
                    h = b.m1842h("id");
                }
                asVar = new as(C0405u.f1819b, h, c0388i.m2023a(cg.f1619c));
            }
            longValue = ((Long) c0388i.f1781a.f1528m.m2010c()).longValue();
            a2 = c0388i.m2025a();
            bgVar = new bg(0);
            bgVar = new bg(0);
            bgVar2 = (bg) c0388i.f1781a.f1530o.m2010c();
            c0409z = new C0409z();
            if (asVar.f1499b != null) {
                a3 = c0409z.m2062a(asVar.f1498a);
                c0405u = asVar.f1498a;
                b2 = c0388i.m2026b();
                if (c0405u == C0405u.f1819b) {
                }
                ddVar = null;
                a3.put(asVar.f1499b, new aa(asVar.f1498a, asVar.f1499b, ddVar));
            }
            if (c0388i.f1783c == null) {
                z = false;
            } else {
                g = c0388i.f1783c.m1841g("hidden");
                if (g != null) {
                }
                z = false;
            }
            a = new C0384f(new C0401q(longValue, a2, bgVar, bgVar, bgVar2, 0, c0409z, z, (byte) 0), new bm(asVar));
            return a;
        }
        return a;
    }

    public final void m2014a(C0384f c0384f) {
        C0396k.m2032a(c0384f, this.f1777a);
    }

    public final void m2016b() {
        throw new UnsupportedOperationException();
    }
}
