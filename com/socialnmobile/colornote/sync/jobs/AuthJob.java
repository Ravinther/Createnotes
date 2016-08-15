package com.socialnmobile.colornote.sync.jobs;

import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.C0398n;
import com.socialnmobile.colornote.sync.C0405u;
import com.socialnmobile.colornote.sync.SyncServiceJob;
import com.socialnmobile.colornote.sync.ab;
import com.socialnmobile.colornote.sync.bd;
import com.socialnmobile.colornote.sync.p019c.C0368a;
import com.socialnmobile.util.service.ServiceJob.JobListener;
import java.util.concurrent.Callable;

public class AuthJob extends SyncServiceJob {
    final Callable callable;

    public interface Listener extends JobListener {
    }

    public AuthJob(C0398n c0398n, C0368a c0368a, C0405u c0405u, ab abVar, bd bdVar, Listener listener) {
        super(c0368a, listener);
        this.callable = abVar.m1767a(c0398n, c0368a, c0405u, bdVar);
    }

    public final C0367b call() {
        return (C0367b) this.callable.call();
    }
}
