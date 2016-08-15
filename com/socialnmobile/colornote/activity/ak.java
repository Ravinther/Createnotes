package com.socialnmobile.colornote.activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.Calendar;

final class ak implements OnClickListener {
    final /* synthetic */ ReminderSettings f789a;

    ak(ReminderSettings reminderSettings) {
        this.f789a = reminderSettings;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        long longValue = ((Long) this.f789a.f707k.get(i)).longValue();
        if (longValue == -1 || longValue != -2) {
            this.f789a.m738b(longValue);
        } else if (this.f789a.f700d == -1) {
            Calendar instance = Calendar.getInstance();
            new DatePickerDialog(this.f789a, this.f789a.f693P, instance.get(1), instance.get(2), instance.get(5)).show();
        } else {
            new DatePickerDialog(this.f789a, this.f789a.f789a.f693P, this.f789a.f699c.year, this.f789a.f699c.month, this.f789a.f699c.monthDay).show();
        }
        this.f789a.m742c();
        dialogInterface.dismiss();
    }
}
