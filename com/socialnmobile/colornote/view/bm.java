package com.socialnmobile.colornote.view;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.p000a.C0004c;
import android.text.format.Time;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.fragment.ce;
import com.socialnmobile.colornote.p006a.C0147f;

final class bm extends C0004c {
    Time f2105u;
    ce f2106v;

    public final /* synthetic */ Object m2197d() {
        return m2198e();
    }

    public bm(Context context, ScreenCalendar screenCalendar) {
        super(context);
        this.f2106v = screenCalendar.f1985f;
        this.f2105u = screenCalendar.getTime();
    }

    public final Cursor m2198e() {
        ce ceVar = this.f2106v;
        Context context = this.f2o;
        Time time = this.f2105u;
        int i = this.f2106v.f1283c;
        Time time2 = new Time();
        Time time3 = new Time();
        time2.set(time);
        time2.monthDay = 1;
        C0147f.m660a(time2);
        time3.set(time2);
        time3.month++;
        time3.monthDay++;
        C0147f.m660a(time3);
        time2.monthDay--;
        C0147f.m660a(time2);
        C0313j.m1647a(time2);
        C0313j.m1647a(time3);
        long a = C0147f.m661a(time3, true);
        long a2 = C0147f.m661a(time2, true);
        String str = "";
        if (i > 0) {
            str = " AND color_index = " + i;
        }
        ceVar.f1281a = context.getContentResolver().query(C0228r.f997a, null, "(reminder_repeat = 0 AND reminder_base < " + a + " AND reminder_base > " + a2 + " AND space = 0 AND active_state = 0" + str + ") OR (reminder_repeat <> 0 AND reminder_base < " + a + " AND reminder_date <> 0 AND space = 0 AND active_state = 0" + str + ") OR (reminder_repeat <> 0 AND reminder_base < " + a + " AND reminder_last > " + a2 + " AND space = 0 AND active_state = 0" + str + ")", null, null);
        return this.f2106v.f1281a;
    }
}
