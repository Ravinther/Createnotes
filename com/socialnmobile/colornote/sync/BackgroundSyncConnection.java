package com.socialnmobile.colornote.sync;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.socialnmobile.util.service.C0477d;

public class BackgroundSyncConnection extends BackgroundSyncListener implements ServiceConnection {
    public BackgroundSyncConnection(Context context, boolean z, boolean z2) {
        super(context, z, z2);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ((SyncService) ((C0477d) iBinder).f2282a).m1746a(this);
        new Handler().post(new au(this));
    }

    void unbind() {
        this.context.unbindService(this);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
