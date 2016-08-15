package com.socialnmobile.colornote.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.C0313j;

final class ay implements OnClickListener {
    final /* synthetic */ SyncStatus f808a;

    ay(SyncStatus syncStatus) {
        this.f808a = syncStatus;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0313j.m1665c(this.f808a.getApplicationContext());
    }
}
