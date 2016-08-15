package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.service.ServiceJob.JobListener;

final class dp implements Runnable {
    final /* synthetic */ JobListener f1747a;
    final /* synthetic */ SyncService f1748b;

    dp(SyncService syncService, JobListener jobListener) {
        this.f1748b = syncService;
        this.f1747a = jobListener;
    }

    public final void run() {
        this.f1747a.onFinalize();
    }
}
