package com.socialnmobile.colornote.sync.jobs;

import android.content.Context;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.SyncServiceJob;
import com.socialnmobile.colornote.sync.am;
import com.socialnmobile.colornote.sync.bg;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.p019c.C0368a;
import com.socialnmobile.util.service.ServiceJob.JobListener;
import java.util.Calendar;

public abstract class AuthRequiredJob extends SyncServiceJob {
    final C0367b currentAccount;

    public interface Listener extends com.socialnmobile.colornote.sync.errors.AuthRequired.Listener, JobListener {
    }

    public abstract Object callWithAccount(C0367b c0367b);

    public AuthRequiredJob(Context context, C0367b c0367b, C0368a c0368a, Listener listener) {
        super(c0368a, listener);
        this.currentAccount = c0367b;
        if (c0367b == null) {
            throw new IllegalArgumentException("account is null");
        }
    }

    public final Object call() {
        Object obj;
        am j = this.currentAccount.m1862j();
        if (j == null || j.m1777a(Calendar.getInstance(bg.f1555c).getTime())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return callWithAccount(this.currentAccount);
        }
        throw new AuthRequired("AuthToken is required");
    }

    public boolean onJobException(Exception exception) {
        if (!(exception instanceof AuthRequired)) {
            return super.onJobException(exception);
        }
        AuthRequired authRequired = (AuthRequired) exception;
        Listener listener = (Listener) getJobListener();
        if (listener != null) {
            listener.onError(authRequired);
        }
        return true;
    }
}
