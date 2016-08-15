package com.socialnmobile.colornote.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.support.v4.app.C0017z;
import android.support.v4.app.C0031p;
import android.support.v4.app.FragmentActivity;
import com.flurry.android.C0115a;
import com.socialnmobile.colornote.p007e.C0162f;
import com.socialnmobile.colornote.p007e.C0266e;

public class ThemeFragmentActivity extends FragmentActivity {
    C0266e f626G;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f626G = new C0266e(this);
    }

    public final void m682a(int i, C0162f c0162f) {
        this.f626G.f1141d = c0162f;
        this.f626G.m1195a(i);
    }

    protected void onResume() {
        super.onResume();
        this.f626G.m1194a();
    }

    protected void onStart() {
        super.onStart();
        C0115a.m512a((Context) this, "7WTGHNWSX5PSDGSHN65D");
    }

    protected void onStop() {
        super.onStop();
        C0115a.m511a(this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        C0031p c0031p = this.f97b;
        while (true) {
            C0015f a = c0031p.m156a("dialog");
            if (a != null) {
                C0017z a2 = c0031p.m158a();
                a2.m129a(a);
                a2.m131b();
                c0031p.m162b();
            } else {
                super.onSaveInstanceState(bundle);
                return;
            }
        }
    }
}
