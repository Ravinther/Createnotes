package com.socialnmobile.colornote.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.flurry.android.C0115a;
import com.socialnmobile.colornote.p007e.C0266e;

public class ThemeActivity extends Activity {
    C0266e f723c;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f723c = new C0266e(this);
    }

    public final void m753a() {
        this.f723c.m1195a(2);
        this.f723c.f1141d = null;
    }

    protected void onResume() {
        super.onResume();
        this.f723c.m1194a();
    }

    protected void onStart() {
        super.onStart();
        C0115a.m512a((Context) this, "7WTGHNWSX5PSDGSHN65D");
    }

    protected void onStop() {
        super.onStop();
        C0115a.m511a(this);
    }
}
