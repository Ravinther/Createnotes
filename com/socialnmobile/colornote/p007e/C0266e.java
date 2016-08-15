package com.socialnmobile.colornote.p007e;

import android.app.Activity;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.data.C0212b;

/* renamed from: com.socialnmobile.colornote.e.e */
public final class C0266e {
    String f1138a;
    int f1139b;
    Activity f1140c;
    public C0162f f1141d;
    int f1142e;

    public C0266e(Activity activity) {
        this.f1140c = activity;
    }

    public final void m1195a(int i) {
        this.f1142e = i;
        m1194a();
    }

    public final void m1194a() {
        String i = C0212b.m949i(this.f1140c);
        int q = C0212b.m957q(this.f1140c);
        if (this.f1138a == null || !this.f1138a.equals(i) || this.f1139b == 0 || this.f1139b != q) {
            this.f1138a = i;
            this.f1139b = q;
            C0262d a = C0209d.m875a(this.f1140c);
            Activity activity;
            int i2;
            if (a.m1131a()) {
                activity = this.f1140c;
                if (C0212b.m957q(this.f1140c) == 1) {
                    if (this.f1142e == 1) {
                        i2 = 2131427329;
                    } else {
                        i2 = 2131427334;
                    }
                } else if (this.f1142e == 1) {
                    i2 = 2131427337;
                } else {
                    i2 = 2131427340;
                }
                activity.setTheme(i2);
            } else {
                activity = this.f1140c;
                if (C0212b.m957q(this.f1140c) == 1) {
                    if (this.f1142e == 1) {
                        i2 = 2131427328;
                    } else {
                        i2 = 2131427333;
                    }
                } else if (this.f1142e == 1) {
                    i2 = 2131427335;
                } else {
                    i2 = 2131427339;
                }
                activity.setTheme(i2);
            }
            if (this.f1141d != null) {
                this.f1141d.m805a(a);
            }
        }
    }
}
