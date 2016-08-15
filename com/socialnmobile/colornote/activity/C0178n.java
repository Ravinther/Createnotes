package com.socialnmobile.colornote.activity;

import android.content.pm.PackageManager.NameNotFoundException;
import com.socialnmobile.colornote.data.C0210a;
import com.socialnmobile.colornote.sync.ay;

/* renamed from: com.socialnmobile.colornote.activity.n */
final class C0178n implements Runnable {
    final /* synthetic */ Main f831a;

    C0178n(Main main) {
        this.f831a = main;
    }

    public final void run() {
        Main.m701a(this.f831a);
        ay a = C0210a.m895a(this.f831a);
        if (a != null) {
            Integer valueOf;
            Number g = a.f1505a.m1841g("MARKET");
            if (g != null) {
                valueOf = Integer.valueOf(g.intValue());
            } else {
                valueOf = null;
            }
            try {
                int i = this.f831a.getPackageManager().getPackageInfo(this.f831a.getPackageName(), 0).versionCode;
                if (valueOf != null && valueOf.intValue() > i) {
                    this.f831a.m724g();
                }
            } catch (NameNotFoundException e) {
            }
        }
    }
}
