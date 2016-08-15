package com.socialnmobile.colornote.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.socialnmobile.util.service.C0477d;

public class RealtimeSyncService extends Service {
    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
    }

    public IBinder onBind(Intent intent) {
        return new C0477d(this);
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }
}
