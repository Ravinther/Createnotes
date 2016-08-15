package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.service.ServiceJob.JobListener;

final class dn implements Runnable {
    final /* synthetic */ JobListener f1742a;
    final /* synthetic */ SyncService f1743b;

    dn(SyncService syncService, JobListener jobListener) {
        this.f1743b = syncService;
        this.f1742a = jobListener;
    }

    public final void run() {
        this.f1742a.onInit();
    }
}
