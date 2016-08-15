package com.socialnmobile.colornote.fragment;

import android.app.DatePickerDialog.OnDateSetListener;
import android.text.format.Time;
import android.widget.DatePicker;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.view.ScreenCalendar;

/* renamed from: com.socialnmobile.colornote.fragment.x */
final class C0300x implements OnDateSetListener {
    final /* synthetic */ CalendarFragment f1346a;

    C0300x(CalendarFragment calendarFragment) {
        this.f1346a = calendarFragment;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        Time time = new Time();
        time.year = i;
        time.month = i2;
        time.monthDay = 1;
        C0147f.m660a(time);
        ScreenCalendar screenCalendar = this.f1346a.f1170b;
        screenCalendar.setMonth(time);
        this.f1346a.f1171c = time;
        screenCalendar.m2128a();
    }
}
