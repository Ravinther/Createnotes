package com.socialnmobile.colornote.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class al implements OnClickListener {
    final /* synthetic */ ReminderSettings f790a;

    al(ReminderSettings reminderSettings) {
        this.f790a = reminderSettings;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f790a.m738b((System.currentTimeMillis() + ((long) this.f790a.f710n[i])) + 10000);
        this.f790a.m742c();
        dialogInterface.dismiss();
    }
}
