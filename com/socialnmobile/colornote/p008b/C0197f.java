package com.socialnmobile.colornote.p008b;

import org.json.JSONObject;

/* renamed from: com.socialnmobile.colornote.b.f */
final class C0197f implements Runnable {
    final /* synthetic */ String f877a;
    final /* synthetic */ Throwable f878b;
    final /* synthetic */ int f879c;
    final /* synthetic */ String f880d;
    final /* synthetic */ Object f881e;
    final /* synthetic */ String f882f;
    final /* synthetic */ boolean f883g;
    final /* synthetic */ C0191a f884h;

    C0197f(C0191a c0191a, String str, Throwable th, String str2, Object obj, String str3) {
        this.f884h = c0191a;
        this.f877a = str;
        this.f878b = th;
        this.f879c = 0;
        this.f880d = str2;
        this.f881e = obj;
        this.f882f = str3;
        this.f883g = true;
    }

    public final void run() {
        try {
            C0191a c0191a = this.f884h;
            String str = this.f877a;
            Throwable th = this.f878b;
            int i = this.f879c;
            String str2 = this.f880d;
            Object obj = this.f881e;
            String str3 = this.f882f;
            boolean z = this.f883g;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("causes", c0191a.m851a(th, i));
            this.f884h.m857a(c0191a.m852a(str, jSONObject, str2, obj, str3, z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
