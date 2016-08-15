package com.socialnmobile.colornote.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.socialnmobile.colornote.activity.SyncLogIn;
import com.socialnmobile.colornote.sync.C0367b;

final class cu implements OnClickListener {
    final /* synthetic */ SideMenuFragment f1305a;

    cu(SideMenuFragment sideMenuFragment) {
        this.f1305a = sideMenuFragment;
    }

    public final void onClick(View view) {
        if (C0367b.m1868a(this.f1305a.f1203f)) {
            this.f1305a.f1203f.m714a(true, true, "SIDEMENU");
            this.f1305a.f1203f.m723f();
            return;
        }
        this.f1305a.f1203f.startActivity(new Intent(this.f1305a.f1203f, SyncLogIn.class));
    }
}
