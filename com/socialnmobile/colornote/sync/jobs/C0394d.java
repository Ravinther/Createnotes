package com.socialnmobile.colornote.sync.jobs;

import com.socialnmobile.colornote.sync.jobs.SyncJob.Listener;

/* renamed from: com.socialnmobile.colornote.sync.jobs.d */
final class C0394d implements Runnable {
    final /* synthetic */ Listener f1791a;
    final /* synthetic */ int f1792b;
    final /* synthetic */ int f1793c;
    final /* synthetic */ C0393c f1794d;

    C0394d(C0393c c0393c, Listener listener, int i, int i2) {
        this.f1794d = c0393c;
        this.f1791a = listener;
        this.f1792b = i;
        this.f1793c = i2;
    }

    public final void run() {
        this.f1791a.onProgress(this.f1792b, this.f1793c);
    }
}
