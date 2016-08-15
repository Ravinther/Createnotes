package com.socialnmobile.colornote;

import android.content.Context;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.p007e.C0263a;
import com.socialnmobile.colornote.p007e.C0264b;
import com.socialnmobile.colornote.p007e.C0265c;

/* renamed from: com.socialnmobile.colornote.d */
public final class C0209d {
    private static C0262d f908a;

    public static C0262d m875a(Context context) {
        if (f908a == null) {
            C0209d.m876b(context);
        }
        return f908a;
    }

    public static void m876b(Context context) {
        if (C0212b.m949i(context).equals("COLORTABLE/DEFAULT")) {
            f908a = new C0264b();
        } else if (C0212b.m949i(context).equals("COLORTABLE/DARK")) {
            f908a = new C0263a();
        } else if (C0212b.m949i(context).equals("COLORTABLE/SOFT")) {
            f908a = new C0265c();
        } else {
            f908a = new C0264b();
        }
    }
}
