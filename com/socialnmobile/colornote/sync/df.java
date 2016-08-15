package com.socialnmobile.colornote.sync;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public abstract class df implements ServiceConnection {
    public abstract void m1992a();

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m1992a();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }

    public static df m1991a(Context context, df dfVar) {
        return context.bindService(new Intent(context, RealtimeSyncService.class), dfVar, 1) ? dfVar : null;
    }
}
