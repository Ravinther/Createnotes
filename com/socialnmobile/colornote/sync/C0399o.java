package com.socialnmobile.colornote.sync;

import android.content.Context;
import com.socialnmobile.colornote.data.C0231u;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p020d.C0376a;
import com.socialnmobile.colornote.sync.p020d.C0377b;

/* renamed from: com.socialnmobile.colornote.sync.o */
public final class C0399o implements C0398n {
    final Context f1799a;
    final C0231u f1800b;

    public C0399o(Context context, C0231u c0231u) {
        this.f1799a = context;
        this.f1800b = c0231u;
    }

    public final C0367b m2041a() {
        return C0367b.m1866a(this.f1799a, this.f1800b);
    }

    public final C0367b m2043b() {
        return C0367b.m1869b(this.f1799a, this.f1800b);
    }

    public final C0367b m2042a(C0376a c0376a, C0377b c0377b) {
        return C0367b.m1867a(this.f1799a, this.f1800b, c0376a, c0377b);
    }

    public final C0361e m2044c() {
        C0361e c0361e = new C0361e();
        c0361e.m1833a("id", bk.m1901a(bk.m1900a()));
        c0361e.m1833a("info", bl.m1902a(this.f1799a).m1903a());
        return c0361e;
    }
}
