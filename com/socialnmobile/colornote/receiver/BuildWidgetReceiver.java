package com.socialnmobile.colornote.receiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.socialnmobile.colornote.C0151a;
import com.socialnmobile.colornote.C0311h;

public class BuildWidgetReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C0332a.m1730a(context, intent.getIntArrayExtra("WIDGET_IDS"), intent.getIntExtra("WIDGET_TYPE", 1), intent.getIntExtra("RETRY", 0) - 1);
    }

    public static void m1717a(Context context, int[] iArr, int i, int i2) {
        Intent intent = new Intent("note.socialnmobile.intent.action.BUILD_WIDGET");
        intent.setClass(context, BuildWidgetReceiver.class);
        intent.putExtra("WIDGET_IDS", iArr);
        intent.putExtra("WIDGET_TYPE", i);
        intent.putExtra("RETRY", i2);
        try {
            C0151a.m676a().m677a(context, 1, System.currentTimeMillis() + 60000, PendingIntent.getBroadcast(context, 0, intent, 134217728));
        } catch (Throwable e) {
            C0311h.f1370a.m1624a("GALAXY LOLLIPOP ALARM (BUILD WIDGET)", e);
        }
    }
}
