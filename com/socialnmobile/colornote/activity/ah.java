package com.socialnmobile.colornote.activity;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TimePicker;

final class ah implements OnTimeSetListener {
    final /* synthetic */ ReminderSettings f786a;

    ah(ReminderSettings reminderSettings) {
        this.f786a = reminderSettings;
    }

    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.f786a.f699c.hour = i;
        this.f786a.f699c.minute = i2;
        this.f786a.f699c.second = 0;
        ReminderSettings.m733a(this.f786a, this.f786a.f699c);
        this.f786a.m742c();
    }
}
