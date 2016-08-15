package com.socialnmobile.colornote.receiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import com.socialnmobile.colornote.C0151a;
import com.socialnmobile.colornote.C0310g;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0210a;

public class TimeChangedReceiver extends BroadcastReceiver {
    static long f1451a;

    public void onReceive(Context context, Intent intent) {
        if (context.getContentResolver() == null) {
            ColorNote.m651a("Alarm Init Resolver Error");
            return;
        }
        String action = intent.getAction();
        long currentTimeMillis = System.currentTimeMillis();
        if (action.equals("android.intent.action.BOOT_COMPLETED")) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                C0310g.m1613a(context, currentTimeMillis2, true);
                long b = C0210a.m899b(context, "TIME_ALARM_SCHEDULE");
                long b2 = C0210a.m899b(context, "TIME_ALARM_ID");
                if (b > currentTimeMillis2) {
                    C0310g.m1612a(context, b2, b, C0310g.m1609a(context, b2, b));
                }
                AutoSyncReceiver.m1716b(context);
                C0310g.m1610a(context);
                f1451a = currentTimeMillis;
            } catch (SQLiteException e) {
                Intent intent2 = new Intent("note.socialnmobile.intent.action.RENEW_ALARM");
                intent2.setClass(context, TimeChangedReceiver.class);
                PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 134217728);
                C0151a.m676a().m677a(context, 0, 150000 + System.currentTimeMillis(), broadcast);
                ColorNote.m651a("Can't schedule alarms, job delayed" + action);
            }
        } else if (action.equals("android.intent.action.TIMEZONE_CHANGED") || action.equals("android.intent.action.DATE_CHANGED") || action.equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
            try {
                if (currentTimeMillis - f1451a >= 120000) {
                    AutoSyncReceiver.m1714a(context);
                    C0310g.m1610a(context);
                    f1451a = currentTimeMillis;
                }
            } catch (SQLiteException e2) {
                ColorNote.m651a("Can't schedule alarms" + action);
            }
        } else if (action.equals("note.socialnmobile.intent.action.RENEW_ALARM")) {
            try {
                AutoSyncReceiver.m1714a(context);
                C0310g.m1610a(context);
                f1451a = currentTimeMillis;
            } catch (SQLiteException e3) {
                ColorNote.m651a("Can't schedule alarms" + action);
            }
        }
    }
}
