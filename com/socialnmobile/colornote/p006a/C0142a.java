package com.socialnmobile.colornote.p006a;

import android.os.Build.VERSION;
import android.widget.TextView;
import com.socialnmobile.colornote.view.C0410a;

/* renamed from: com.socialnmobile.colornote.a.a */
public final class C0142a {
    static final C0143b f602a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f602a = new C0145d();
        } else {
            f602a = new C0144c();
        }
    }

    public static void m656a(TextView textView, C0410a c0410a) {
        f602a.m657a(textView, c0410a);
    }
}
