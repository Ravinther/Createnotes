package com.socialnmobile.colornote.p010d;

import android.os.Bundle;
import android.webkit.CookieSyncManager;
import com.p004a.p005a.C0106a;
import com.p004a.p005a.C0108d;
import com.p004a.p005a.C0110e;

/* renamed from: com.socialnmobile.colornote.d.g */
public final class C0208g implements C0108d {
    final /* synthetic */ C0207f f907a;

    public C0208g(C0207f c0207f) {
        this.f907a = c0207f;
    }

    public final void m872a(Bundle bundle) {
        int i;
        CookieSyncManager.getInstance().sync();
        this.f907a.f904d = bundle.getString("access_token");
        this.f907a.f905e = bundle.getString("refresh_token");
        this.f907a.f904d = bundle.getString("access_token");
        C0207f c0207f = this.f907a;
        String string = bundle.getString("expires_in");
        if (!(string == null || string.equals("0"))) {
            c0207f.f906f = ((long) (Integer.parseInt(string) * 1000)) + System.currentTimeMillis();
        }
        c0207f = this.f907a;
        if (c0207f.f904d == null || (c0207f.f906f != 0 && System.currentTimeMillis() >= c0207f.f906f)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            this.f907a.f901a.m494a(bundle);
        } else {
            this.f907a.f901a.m495a(new C0106a("Failed to receive access token.", 0, ""));
        }
    }

    public final void m873a(C0106a c0106a) {
        this.f907a.f901a.m495a(c0106a);
    }

    public final void m871a() {
        this.f907a.f901a.m493a();
    }

    public final void m874a(C0110e c0110e) {
        this.f907a.f901a.m496a(c0110e);
    }
}
