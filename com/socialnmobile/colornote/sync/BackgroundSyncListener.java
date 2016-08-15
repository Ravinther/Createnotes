package com.socialnmobile.colornote.sync;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.SyncRelogin;
import com.socialnmobile.colornote.receiver.AutoSyncReceiver;
import com.socialnmobile.colornote.service.AutoSyncService;
import com.socialnmobile.colornote.service.SDBackupService;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import com.socialnmobile.colornote.sync.jobs.SyncJob.Listener;

public class BackgroundSyncListener implements Listener {
    private final boolean authNotification;
    private boolean autoBackUp;
    public Context context;

    public BackgroundSyncListener(Context context, boolean z, boolean z2) {
        this.context = context;
        this.authNotification = z;
        this.autoBackUp = z2;
    }

    public void onInit() {
        C0313j.m1645a(this.context);
    }

    public void onFinalize() {
        AutoSyncReceiver.m1714a(this.context);
        if (this.autoBackUp) {
            SDBackupService.m1737a(this.context);
        } else {
            C0313j.m1659b();
        }
        if (this.context instanceof AutoSyncService) {
            ((Service) this.context).stopSelf();
        }
    }

    public void onException(Exception exception) {
        ColorNote.m651a("sync background error : " + exception.getMessage());
        if (this.autoBackUp) {
            new StringBuilder("Auto sync exception :").append(exception.getMessage());
        }
    }

    public void onError(AuthRequired authRequired) {
        Intent intent = new Intent(this.context, SyncRelogin.class);
        intent.putExtra("EXTRA_PROCEED", 1);
        intent.putExtra("FROM", "BackgroundSyncListener");
        intent.setFlags(268435456);
        if (this.authNotification) {
            PendingIntent activity = PendingIntent.getActivity(this.context, 0, intent, 1073741824);
            ((NotificationManager) this.context.getSystemService("notification")).notify(21, SyncService.m1743a(this.context, 17301624, this.context.getString(2131231058), this.context.getString(2131230758), activity));
            return;
        }
        this.context.startActivity(intent);
    }

    public void onProgress(int i, int i2) {
    }

    public void onFinished(Object obj) {
        if (this.autoBackUp) {
            Context context = this.context;
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putLong("PREF_LAST_AUTO_SYNC_TIME", currentTimeMillis);
            edit.commit();
        }
    }

    public void onError(UnsupportedClientVersion unsupportedClientVersion) {
    }
}
