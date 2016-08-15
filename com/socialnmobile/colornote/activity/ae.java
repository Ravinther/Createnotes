package com.socialnmobile.colornote.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class ae implements OnItemSelectedListener {
    final /* synthetic */ ReminderSettings f783a;

    ae(ReminderSettings reminderSettings) {
        this.f783a = reminderSettings;
    }

    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.f783a.m752c(this.f783a.m748a(i));
    }

    public final void onNothingSelected(AdapterView adapterView) {
    }
}
