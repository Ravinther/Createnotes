package com.socialnmobile.colornote.sync.p015a;

import android.content.Context;
import com.socialnmobile.colornote.data.C0231u;
import com.socialnmobile.colornote.sync.bb;
import com.socialnmobile.colornote.sync.bj;
import org.apache.http.client.HttpClient;

/* renamed from: com.socialnmobile.colornote.sync.a.j */
public final class C0344j implements C0343i {
    final Context f1475a;
    final C0231u f1476b;

    public C0344j(Context context, C0231u c0231u) {
        this.f1475a = context;
        this.f1476b = c0231u;
    }

    public final /* synthetic */ HttpClient m1753c() {
        HttpClient b = new bb(this.f1475a).m1887b();
        b.addRequestInterceptor(new C0335a(this.f1475a, this.f1476b));
        b.addRequestInterceptor(new C0337c(this.f1475a));
        if (bj.f1560a.m1899a("useFakeConnectionError")) {
            b.addResponseInterceptor(new C0339e());
        }
        return b;
    }
}
