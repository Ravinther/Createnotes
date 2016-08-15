package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.jobs.C0395e;

final class ds extends df {
    final /* synthetic */ C0395e f1751a;
    final /* synthetic */ SyncServiceJobSyncListenerForRealtimeSync f1752b;

    ds(SyncServiceJobSyncListenerForRealtimeSync syncServiceJobSyncListenerForRealtimeSync, C0395e c0395e) {
        this.f1752b = syncServiceJobSyncListenerForRealtimeSync;
        this.f1751a = c0395e;
    }

    public final void m1997a() {
        this.f1752b.context.unbindService(this);
    }
}
