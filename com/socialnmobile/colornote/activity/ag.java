package com.socialnmobile.colornote.activity;

import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.p006a.C0150i;
import java.util.Calendar;

final class ag implements OnClickListener {
    final /* synthetic */ ReminderSettings f785a;

    ag(ReminderSettings reminderSettings) {
        this.f785a = reminderSettings;
    }

    public final void onClick(View view) {
        Calendar instance;
        switch (view.getId()) {
            case 2131623963:
                this.f785a.f705i = true;
                int i = this.f785a.f679B;
                this.f785a.f679B = 0;
                this.f785a.f680C = 0;
                this.f785a.f683F = 0;
                this.f785a.f681D = 0;
                this.f785a.f682E = 0;
                this.f785a.m752c(i);
                this.f785a.f720x.setEnabled(true);
                this.f785a.f716t.setEnabled(true);
                this.f785a.f717u.setEnabled(true);
                this.f785a.f718v.setEnabled(true);
                this.f785a.f721y.setEnabled(true);
                this.f785a.f722z.setVisibility(8);
                return;
            case 2131623964:
                if (this.f785a.f697a == 128) {
                    ReminderSettings.m739b(this.f785a);
                    return;
                }
                this.f785a.f678A.setVisibility(8);
                C0229s.m1042a(this.f785a, this.f785a.f687J, this.f785a.f697a);
                this.f785a.f697a = 0;
                this.f785a.m749a();
                this.f785a.f688K = false;
                this.f785a.setResult(-1);
                this.f785a.finish();
                return;
            case 2131623970:
                Builder builder = new Builder(this.f785a);
                if (this.f785a.f697a == 16) {
                    builder.setTitle(2131231007);
                    ReminderSettings.m743c(this.f785a);
                    builder.setSingleChoiceItems(new ArrayAdapter(this.f785a, 2130903075, this.f785a.f708l), -1, this.f785a.f694Q).show();
                    return;
                } else if (this.f785a.f697a == 32) {
                    builder.setTitle(2131231009);
                    builder.setSingleChoiceItems(new ArrayAdapter(this.f785a, 2130903075, this.f785a.f709m), -1, this.f785a.f695R).show();
                    return;
                } else {
                    return;
                }
            case 2131623971:
                if (Time.isEpoch(this.f785a.f699c)) {
                    instance = Calendar.getInstance();
                    new DatePickerDialog(this.f785a, this.f785a.f789a.f693P, instance.get(1), instance.get(2), instance.get(5)).show();
                    return;
                }
                new DatePickerDialog(this.f785a, this.f785a.f789a.f693P, this.f785a.f699c.year, this.f785a.f699c.month, this.f785a.f699c.monthDay).show();
                return;
            case 2131623972:
                new TimePickerDialog(this.f785a, this.f785a.f691N, this.f785a.f699c.hour, this.f785a.f699c.minute, DateFormat.is24HourFormat(this.f785a)).show();
                return;
            case 2131623978:
                this.f785a.f701e.set(this.f785a.f702f);
                if (this.f785a.f702f == 0) {
                    instance = Calendar.getInstance();
                    new DatePickerDialog(this.f785a, this.f785a.f692O, instance.get(1), instance.get(2), instance.get(5)).show();
                    return;
                }
                new DatePickerDialog(this.f785a, this.f785a.f692O, this.f785a.f701e.year, this.f785a.f701e.month, this.f785a.f701e.monthDay).show();
                return;
            case 2131623981:
                this.f785a.f720x.setSelection(this.f785a.m751b(16));
                this.f785a.m752c(16);
                this.f785a.f706j = true;
                this.f785a.m738b(-1);
                return;
            case 2131623982:
                instance = Calendar.getInstance();
                instance.set(instance.get(1), instance.get(2), instance.get(5), 6, 0, 0);
                this.f785a.f720x.setSelection(this.f785a.m751b(16));
                this.f785a.m752c(16);
                this.f785a.f706j = true;
                this.f785a.m738b(instance.getTimeInMillis());
                return;
            case 2131623983:
                this.f785a.f720x.setSelection(this.f785a.m751b(32));
                this.f785a.m752c(32);
                this.f785a.f706j = true;
                this.f785a.m738b((System.currentTimeMillis() + 900000) + 10000);
                return;
            case 2131623984:
                this.f785a.f720x.setSelection(this.f785a.m751b(32));
                this.f785a.m752c(32);
                this.f785a.f706j = true;
                this.f785a.m738b((System.currentTimeMillis() + 1800000) + 10000);
                return;
            case 2131623985:
                this.f785a.f720x.setSelection(this.f785a.m751b(128));
                this.f785a.m736a(false);
                return;
            case 2131623986:
                if (!C0150i.m673a()) {
                    ReminderSettings.m746e(this.f785a);
                    return;
                }
                break;
            case 2131623987:
                ReminderSettings.m739b(this.f785a);
                return;
            case 2131623988:
                if (C0150i.m673a()) {
                    ReminderSettings.m746e(this.f785a);
                    return;
                }
                break;
            default:
                return;
        }
        this.f785a.m736a(false);
    }
}
