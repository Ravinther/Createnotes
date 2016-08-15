package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.util.service.ServiceJob.JobListener;

/* renamed from: com.socialnmobile.colornote.sync.do */
final class C0382do implements Runnable {
    final /* synthetic */ RuntimeException f1744a;
    final /* synthetic */ JobListener f1745b;
    final /* synthetic */ SyncService f1746c;

    C0382do(SyncService syncService, RuntimeException runtimeException, JobListener jobListener) {
        this.f1746c = syncService;
        this.f1744a = runtimeException;
        this.f1745b = jobListener;
    }

    public final void run() {
        C0212b.m938a(this.f1746c, System.currentTimeMillis(), this.f1744a);
        this.f1745b.onException(this.f1744a);
    }
}
