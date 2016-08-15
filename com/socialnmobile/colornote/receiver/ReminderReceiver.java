package com.socialnmobile.colornote.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.socialnmobile.colornote.C0310g;

public class ReminderReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        long currentTimeMillis = System.currentTimeMillis();
        if ("note.socialnmobile.intent.action.TIME_REMINDER".equals(intent.getAction())) {
            C0310g.m1620d(context, intent.getLongExtra("alarm_id", 0));
            C0310g.m1611a(context, currentTimeMillis);
            C0310g.m1619c(context, currentTimeMillis);
        } else if ("note.socialnmobile.intent.action.DAY_REMINDER".equals(intent.getAction())) {
            C0310g.m1618b(context, currentTimeMillis);
        }
    }
}
