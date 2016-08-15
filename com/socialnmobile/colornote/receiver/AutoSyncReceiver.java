package com.socialnmobile.colornote.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.socialnmobile.colornote.C0151a;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.service.AutoSyncService;
import com.socialnmobile.colornote.service.SDBackupService;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import java.util.Random;

public class AutoSyncReceiver extends BroadcastReceiver {
    private static final Random f1450a;

    static {
        f1450a = new Random(System.currentTimeMillis());
    }

    public static void m1714a(Context context) {
        m1715a(context, false);
    }

    public static void m1716b(Context context) {
        m1715a(context, true);
    }

    private static void m1715a(Context context, boolean z) {
        long a;
        long j;
        long j2 = 86400000;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("note.socialnmobile.intent.action.AUTO_SYNC"), 134217728);
        long currentTimeMillis = System.currentTimeMillis();
        long a2 = C0212b.m935a(context, "PREF_RESERVED_AUTO_SYNC_TIME");
        if (C0367b.m1868a(context) && C0212b.m954n(context)) {
            if (AuthRequired.class.getSimpleName().equals(C0212b.m936a(context, "SYNC_ERROR_EXCEPTION_NAME", ""))) {
                a = m1713a(currentTimeMillis, a2);
            } else {
                j2 = currentTimeMillis + 21600000;
                if (a2 > currentTimeMillis && a2 <= j2) {
                    j2 = a2;
                }
                a = j2;
                j2 = 21600000;
            }
            new StringBuilder("schedule error auto sync : ").append(ColorNote.m645a(a));
            j = j2;
        } else {
            a = m1713a(currentTimeMillis, a2);
            new StringBuilder("schedule normal auto sync : ").append(ColorNote.m645a(a));
            j = 86400000;
        }
        if (a < currentTimeMillis) {
            new StringBuilder("AutoSync Schedule Error : ").append(a).append(" < ").append(currentTimeMillis);
        } else if (a != a2 || z) {
            try {
                C0151a a3 = C0151a.m676a();
                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                alarmManager.cancel(broadcast);
                alarmManager.setInexactRepeating(0, a, j, broadcast);
                a3.m679b();
                Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                edit.putLong("PREF_RESERVED_AUTO_SYNC_TIME", a);
                edit.commit();
            } catch (Throwable e) {
                C0311h.f1370a.m1624a("GALAXY LOLLIPOP ALARM AUTOSYNC", e);
            }
        }
    }

    private static long m1713a(long j, long j2) {
        if (j2 > j) {
            return j2;
        }
        return (C0313j.m1655b(j) + 9000000) + ((long) f1450a.nextInt(9000000));
    }

    public void onReceive(Context context, Intent intent) {
        if (!"note.socialnmobile.intent.action.AUTO_SYNC".equals(intent.getAction())) {
            return;
        }
        if (C0367b.m1868a(context)) {
            AutoSyncService.m1735a(context);
        } else {
            SDBackupService.m1737a(context);
        }
    }
}
