package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.sync.errors.AccountNotMatch;
import com.socialnmobile.colornote.sync.errors.AccountNotMatch.Listener;
import com.socialnmobile.colornote.sync.errors.AlreadyInUse;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.errors.BadFields;
import com.socialnmobile.colornote.sync.errors.ExternalAuthFailed;
import com.socialnmobile.colornote.sync.errors.PasswordNotMatch;
import com.socialnmobile.colornote.sync.errors.RepositoryRebuildRequired;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import com.socialnmobile.colornote.sync.errors.UserNotFound;
import com.socialnmobile.colornote.sync.p019c.C0368a;
import com.socialnmobile.colornote.sync.p019c.C0369b;
import com.socialnmobile.util.service.ServiceJob;
import com.socialnmobile.util.service.ServiceJob.JobListener;

public abstract class SyncServiceJob extends ServiceJob {
    public C0368a jsonrpc;

    public SyncServiceJob(C0368a c0368a, JobListener jobListener) {
        super(jobListener);
        this.jsonrpc = c0368a;
    }

    public boolean onJobException(Exception exception) {
        if (exception instanceof C0369b) {
            C0369b c0369b = (C0369b) exception;
            JobListener jobListener = getJobListener();
            if (jobListener != null) {
                return dispatchError(jobListener, c0369b);
            }
        }
        return false;
    }

    static boolean dispatchError(Object obj, C0369b c0369b) {
        try {
            switch (c0369b.f1591a) {
                case 440:
                    ((Listener) cast(obj, Listener.class)).onError(new AccountNotMatch(c0369b));
                    break;
                case 441:
                    ((AlreadyInUse.Listener) cast(obj, AlreadyInUse.Listener.class)).onError(new AlreadyInUse(c0369b));
                    break;
                case 442:
                    ((BadFields.Listener) cast(obj, BadFields.Listener.class)).onError(new BadFields(c0369b));
                    break;
                case 443:
                    ((ExternalAuthFailed.Listener) cast(obj, ExternalAuthFailed.Listener.class)).onError(new ExternalAuthFailed(c0369b));
                    break;
                case 444:
                    ((PasswordNotMatch.Listener) cast(obj, PasswordNotMatch.Listener.class)).onError(new PasswordNotMatch(c0369b));
                    break;
                case 445:
                    ((UserNotFound.Listener) cast(obj, UserNotFound.Listener.class)).onError(new UserNotFound(c0369b));
                    break;
                case 446:
                    ((AuthRequired.Listener) cast(obj, AuthRequired.Listener.class)).onError(new AuthRequired(c0369b));
                    break;
                case 447:
                    ((RepositoryRebuildRequired.Listener) cast(obj, RepositoryRebuildRequired.Listener.class)).onError(new RepositoryRebuildRequired(c0369b));
                    break;
                case 448:
                    ((UnsupportedClientVersion.Listener) cast(obj, UnsupportedClientVersion.Listener.class)).onError(new UnsupportedClientVersion(c0369b));
                    break;
                default:
                    return false;
            }
            return true;
        } catch (dq e) {
            return false;
        }
    }

    static Object cast(Object obj, Class cls) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            throw new dq();
        }
    }
}
