package com.socialnmobile.colornote.sync.jobs;

import android.os.Handler;
import com.socialnmobile.colornote.sync.du;
import com.socialnmobile.colornote.sync.jobs.SyncJob.Listener;

/* renamed from: com.socialnmobile.colornote.sync.jobs.c */
final class C0393c implements du {
    final Handler f1789a;
    final /* synthetic */ SyncJob f1790b;

    C0393c(SyncJob syncJob) {
        this.f1790b = syncJob;
        this.f1789a = new Handler();
    }

    public final void m2031a(int i, int i2) {
        Listener listener = (Listener) this.f1790b.getJobListener();
        if (listener != null) {
            this.f1789a.post(new C0394d(this, listener, i, i2));
        }
    }
}
