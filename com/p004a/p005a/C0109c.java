package com.p004a.p005a;

import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieSyncManager;

/* renamed from: com.a.a.c */
final class C0109c implements C0108d {
    final /* synthetic */ C0107b f349a;

    C0109c(C0107b c0107b) {
        this.f349a = c0107b;
    }

    public final void m498a(Bundle bundle) {
        CookieSyncManager.getInstance().sync();
        this.f349a.f342d = bundle.getString("access_token");
        this.f349a.m490a(bundle.getString("expires_in"));
        if (this.f349a.m491a()) {
            Log.d("Facebook-authorize", "Login Success! access_token=" + this.f349a.f342d + " expires=" + this.f349a.f343e);
            this.f349a.f345g.m494a(bundle);
            return;
        }
        this.f349a.f345g.m496a(new C0110e("Failed to receive access token."));
    }

    public final void m499a(C0106a c0106a) {
        Log.d("Facebook-authorize", "Login failed: " + c0106a);
        this.f349a.f345g.m495a(c0106a);
    }

    public final void m500a(C0110e c0110e) {
        Log.d("Facebook-authorize", "Login failed: " + c0110e);
        this.f349a.f345g.m496a(c0110e);
    }

    public final void m497a() {
        Log.d("Facebook-authorize", "Login canceled");
        this.f349a.f345g.m493a();
    }
}
