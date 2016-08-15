package com.socialnmobile.colornote.activity;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import com.socialnmobile.colornote.p006a.C0147f;

final class ai implements OnDateSetListener {
    final /* synthetic */ ReminderSettings f787a;

    ai(ReminderSettings reminderSettings) {
        this.f787a = reminderSettings;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.f787a.f701e.year = i;
        this.f787a.f701e.month = i2;
        this.f787a.f701e.monthDay = i3;
        this.f787a.f701e.hour = 23;
        this.f787a.f701e.minute = 59;
        this.f787a.f701e.second = 59;
        this.f787a.f702f = C0147f.m660a(this.f787a.f701e);
        this.f787a.f699c.set(this.f787a.f702f);
        this.f787a.m750a(this.f787a.f702f);
    }
}
