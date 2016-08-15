package com.socialnmobile.colornote.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.sync.BackgroundSyncConnection;
import com.socialnmobile.colornote.sync.SyncService;

public class AutoSyncService extends Service {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1735a(android.content.Context r10) {
        /*
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r1 = 1;
        r0 = 0;
        r2 = "PREF_LAST_AUTO_SYNC_TIME";
        r2 = com.socialnmobile.colornote.data.C0212b.m935a(r10, r2);
        r4 = java.lang.System.currentTimeMillis();
        r2 = r4 - r2;
        r6 = 64800000; // 0x3dcc500 float:1.2975667E-36 double:3.2015454E-316;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x002d;
    L_0x0018:
        if (r0 == 0) goto L_0x006a;
    L_0x001a:
        com.socialnmobile.colornote.C0313j.m1645a(r10);
        r0 = new android.content.Intent;
        r2 = com.socialnmobile.colornote.service.AutoSyncService.class;
        r0.<init>(r10, r2);
        r2 = "START_PARAM";
        r0.putExtra(r2, r1);
        r10.startService(r0);
    L_0x002c:
        return;
    L_0x002d:
        r2 = com.socialnmobile.colornote.sync.C0367b.m1873d(r10);
        if (r2 != 0) goto L_0x0068;
    L_0x0033:
        r2 = "LAST_SYNC_CHECKOUT_TIME_MILLIS";
        r2 = com.socialnmobile.colornote.data.C0212b.m935a(r10, r2);
        r2 = r4 - r2;
        r2 = r2 / r8;
        r6 = "LAST_SYNC_TIME_MILLIS";
        r6 = com.socialnmobile.colornote.data.C0212b.m935a(r10, r6);
        r4 = r4 - r6;
        r4 = r4 / r8;
        r6 = 50;
        r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x0050;
    L_0x004a:
        r6 = 6;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 < 0) goto L_0x0018;
    L_0x0050:
        r6 = 30;
        r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x005c;
    L_0x0056:
        r6 = 4;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 < 0) goto L_0x0018;
    L_0x005c:
        r6 = 10;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0068;
    L_0x0062:
        r2 = 2;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0018;
    L_0x0068:
        r0 = r1;
        goto L_0x0018;
    L_0x006a:
        com.socialnmobile.colornote.C0313j.m1659b();
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.service.AutoSyncService.a(android.content.Context):void");
    }

    public static void m1736b(Context context) {
        Intent intent = new Intent(context, AutoSyncService.class);
        intent.putExtra("START_PARAM", 2);
        context.startService(intent);
    }

    public void onCreate() {
        super.onCreate();
        C0313j.m1645a((Context) this);
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent == null) {
            ColorNote.m651a("AutoSyncService intent error");
            C0313j.m1659b();
            stopSelf();
            return;
        }
        int intExtra = intent.getIntExtra("START_PARAM", 1);
        Intent intent2 = new Intent(this, SyncService.class);
        ServiceConnection serviceConnection = null;
        if (intExtra == 1) {
            serviceConnection = new BackgroundSyncConnection(this, true, true);
        } else if (intExtra == 2) {
            serviceConnection = new BackgroundSyncConnection(this, false, false);
        } else if (intExtra == 3) {
            serviceConnection = new BackgroundSyncConnection(this, false, false);
        }
        if (!bindService(intent2, serviceConnection, 1)) {
            ColorNote.m651a("AutoSync on exit bind SyncService FAILED");
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
