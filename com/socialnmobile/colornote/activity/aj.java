package com.socialnmobile.colornote.activity;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;

final class aj implements OnDateSetListener {
    final /* synthetic */ ReminderSettings f788a;

    aj(ReminderSettings reminderSettings) {
        this.f788a = reminderSettings;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.f788a.f699c.year = i;
        this.f788a.f699c.month = i2;
        this.f788a.f699c.monthDay = i3;
        ReminderSettings.m733a(this.f788a, this.f788a.f699c);
        this.f788a.m742c();
    }
}
