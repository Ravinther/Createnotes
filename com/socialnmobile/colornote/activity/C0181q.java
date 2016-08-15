package com.socialnmobile.colornote.activity;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.socialnmobile.colornote.activity.q */
final class C0181q implements OnClickListener {
    final /* synthetic */ Main f837a;

    C0181q(Main main) {
        this.f837a = main;
    }

    public final void onClick(View view) {
        DrawerLayout drawerLayout = this.f837a.f655t;
        View a = drawerLayout.m369a(3);
        if (a == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.m364b(3));
        }
        drawerLayout.m372d(a);
    }
}
