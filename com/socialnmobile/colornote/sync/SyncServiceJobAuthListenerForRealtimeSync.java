package com.socialnmobile.colornote.sync;

import android.content.Context;
import com.socialnmobile.colornote.sync.jobs.AuthJob.Listener;

public class SyncServiceJobAuthListenerForRealtimeSync implements Listener {
    final Context context;
    final Listener delegate;

    public SyncServiceJobAuthListenerForRealtimeSync(Context context, Listener listener) {
        this.context = context;
        this.delegate = listener;
    }

    public void onInit() {
        this.delegate.onInit();
    }

    public void onFinished(Object obj) {
        this.delegate.onFinished(obj);
        df.m1991a(this.context, new dr(this, (C0367b) obj));
    }

    public void onFinalize() {
        this.delegate.onFinalize();
    }

    public void onException(Exception exception) {
        this.delegate.onException(exception);
    }
}
