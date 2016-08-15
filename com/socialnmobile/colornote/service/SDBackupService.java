package com.socialnmobile.colornote.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0212b;

public class SDBackupService extends Service {
    public void onCreate() {
        super.onCreate();
        C0313j.m1645a((Context) this);
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        new C0333a(this).execute(new String[0]);
    }

    public void onDestroy() {
        super.onDestroy();
        C0313j.m1659b();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void m1737a(Context context) {
        Object obj;
        if (System.currentTimeMillis() - C0212b.m935a(context, "PREF_LAST_AUTO_SDBACKUP_TIME") < 64800000) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null || !C0212b.m940a(context, "pref_enable_auto_backup", context.getResources().getBoolean(2131296260))) {
            C0313j.m1659b();
            return;
        }
        C0313j.m1645a(context);
        context.startService(new Intent(context, SDBackupService.class));
    }
}
