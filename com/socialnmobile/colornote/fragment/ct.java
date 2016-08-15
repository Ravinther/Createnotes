package com.socialnmobile.colornote.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.socialnmobile.colornote.activity.SyncLogIn;
import com.socialnmobile.colornote.activity.SyncStatus;
import com.socialnmobile.colornote.sync.C0367b;

final class ct implements OnClickListener {
    final /* synthetic */ SideMenuFragment f1304a;

    ct(SideMenuFragment sideMenuFragment) {
        this.f1304a = sideMenuFragment;
    }

    public final void onClick(View view) {
        if (C0367b.m1868a(this.f1304a.f1203f)) {
            this.f1304a.f1203f.startActivity(new Intent(this.f1304a.f1203f, SyncStatus.class));
            return;
        }
        this.f1304a.f1203f.startActivity(new Intent(this.f1304a.f1203f, SyncLogIn.class));
    }
}
