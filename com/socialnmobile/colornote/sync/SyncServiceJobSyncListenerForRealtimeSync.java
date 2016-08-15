package com.socialnmobile.colornote.sync;

import android.content.Context;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import com.socialnmobile.colornote.sync.jobs.C0395e;
import com.socialnmobile.colornote.sync.jobs.SyncJob.Listener;

public class SyncServiceJobSyncListenerForRealtimeSync implements Listener {
    final Context context;
    final Listener delegate;

    public SyncServiceJobSyncListenerForRealtimeSync(Context context, Listener listener) {
        this.context = context;
        this.delegate = listener;
    }

    public void onInit() {
        this.delegate.onInit();
    }

    public void onFinished(Object obj) {
        this.delegate.onFinished(obj);
        df.m1991a(this.context, new ds(this, (C0395e) obj));
    }

    public void onException(Exception exception) {
        this.delegate.onException(exception);
    }

    public void onFinalize() {
        this.delegate.onFinalize();
    }

    public void onError(AuthRequired authRequired) {
        this.delegate.onError(authRequired);
    }

    public void onError(UnsupportedClientVersion unsupportedClientVersion) {
        this.delegate.onError(unsupportedClientVersion);
    }

    public void onProgress(int i, int i2) {
        this.delegate.onProgress(i, i2);
    }
}
