package com.socialnmobile.colornote.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class am implements OnClickListener {
    final /* synthetic */ ReminderSettings f791a;

    am(ReminderSettings reminderSettings) {
        this.f791a = reminderSettings;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f791a.m736a(true);
    }
}
