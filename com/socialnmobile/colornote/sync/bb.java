package com.socialnmobile.colornote.sync;

import android.content.Context;
import com.socialnmobile.colornote.sync.p015a.C0336b;
import com.socialnmobile.colornote.sync.p015a.C0338d;
import com.socialnmobile.colornote.sync.p015a.C0343i;
import com.socialnmobile.colornote.sync.p015a.C0345k;
import com.socialnmobile.colornote.sync.p015a.C0347m;
import com.socialnmobile.colornote.sync.p015a.C0348n;
import org.apache.http.client.HttpClient;

public final class bb implements C0343i, C0348n {
    final Context f1552a;

    public final /* synthetic */ HttpClient m1888c() {
        return m1887b();
    }

    public bb(Context context) {
        this.f1552a = context;
    }

    public final C0345k m1886a() {
        return new C0347m();
    }

    public final C0338d m1887b() {
        return new C0338d(C0336b.m1749a(this.f1552a));
    }
}
