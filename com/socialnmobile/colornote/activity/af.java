package com.socialnmobile.colornote.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class af implements OnItemSelectedListener {
    final /* synthetic */ ReminderSettings f784a;

    af(ReminderSettings reminderSettings) {
        this.f784a = reminderSettings;
    }

    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        int intValue;
        if (this.f784a.f696S != null) {
            intValue = ((Integer) this.f784a.f696S.get(i)).intValue();
        } else {
            intValue = 0;
        }
        if (intValue != 0) {
            this.f784a.f715s.setVisibility(0);
            return;
        }
        this.f784a.f715s.setVisibility(8);
        this.f784a.f702f = 0;
        this.f784a.m750a(this.f784a.f702f);
    }

    public final void onNothingSelected(AdapterView adapterView) {
    }
}
