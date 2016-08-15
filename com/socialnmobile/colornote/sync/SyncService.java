package com.socialnmobile.colornote.sync;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.preference.PreferenceManager;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0231u;
import com.socialnmobile.colornote.data.NoteProvider;
import com.socialnmobile.colornote.sync.jobs.AuthJob;
import com.socialnmobile.colornote.sync.jobs.SyncJob;
import com.socialnmobile.colornote.sync.jobs.SyncJob.Listener;
import com.socialnmobile.colornote.sync.p015a.C0344j;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p019c.C0368a;
import com.socialnmobile.colornote.sync.p019c.C0370c;
import com.socialnmobile.colornote.sync.p019c.C0371d;
import com.socialnmobile.util.p014a.C0433b;
import com.socialnmobile.util.p014a.C0436e;
import com.socialnmobile.util.service.C0474a;
import com.socialnmobile.util.service.C0477d;
import com.socialnmobile.util.service.JobService;
import com.socialnmobile.util.service.ServiceJob;
import com.socialnmobile.util.service.ServiceJob.JobListener;
import java.util.Date;
import org.apache.http.HttpHost;

public class SyncService extends JobService {
    public static final String f1456a;
    C0370c f1457b;
    C0368a f1458c;
    C0398n f1459d;

    static {
        f1456a = SyncService.class.getSimpleName();
    }

    public static Notification m1743a(Context context, int i, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        Notification notification = new Notification(i, null, System.currentTimeMillis());
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        return notification;
    }

    public final void m1746a(Listener listener) {
        C0367b a = this.f1459d.m2037a();
        if (a != null) {
            try {
                ServiceJob syncJob = new SyncJob(this, a, this.f1458c, listener);
                Notification a2 = m1743a(this, 17301628, getText(2131231058), getString(2131230998), PendingIntent.getActivity(this, 0, new Intent(), 1073741824));
                a2.flags = 18;
                m1740a(C0436e.m2236a(new C0433b(new C0474a(this, a2), this.f1454f), m1739a(syncJob)));
            } catch (RuntimeException e) {
                m1744a(e, listener);
            }
        }
    }

    public final void m1745a() {
        m1746a(new BackgroundSyncListener(this, false, false));
    }

    public void onCreate() {
        super.onCreate();
        C0231u b = NoteProvider.m885b((Context) this);
        this.f1457b = new C0371d(new C0344j(this, b).m1752c(), (HttpHost) bj.f1560a.m1898a("JSONRPC_HOST", new bb(this).m1760a().m1754a()), (String) bj.f1560a.m1898a("JSONRPC_PATH", "/api/v1/jsonrpc"));
        this.f1458c = new C0368a(this.f1457b);
        this.f1459d = new C0399o(this, b);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final IBinder m1748b() {
        return new C0477d(this);
    }

    public final void m1747a(C0405u c0405u, ab abVar, bd bdVar, AuthJob.Listener listener) {
        PreferenceManager.getDefaultSharedPreferences(this);
        long a = C0212b.m935a((Context) this, "LAST_AUTH_TIME");
        long time = new Date().getTime();
        Editor edit = PreferenceManager.getDefaultSharedPreferences(this).edit();
        edit.putLong("LAST_AUTH_TIME", time);
        edit.commit();
        if (time - a > 259200000 && abVar == ab.f1485c) {
            C0361e c0361e = new C0361e();
            C0367b a2 = this.f1459d.m2037a();
            C0367b b = this.f1459d.m2039b();
            c0361e.m1834a("activeAccount", a2, C0383e.f1774a);
            c0361e.m1834a("hiddenAccount", b, C0383e.f1774a);
            C0311h.f1370a.m1622a("Abnormal relogin", "", c0361e);
        }
        try {
            m1740a(m1739a(new AuthJob(this.f1459d, this.f1458c, c0405u, abVar, bdVar, listener)));
        } catch (RuntimeException e) {
            m1744a(e, listener);
        }
    }

    private void m1744a(RuntimeException runtimeException, JobListener jobListener) {
        C0311h.f1370a.m1624a("Sync Problem", runtimeException);
        this.f.post(new dn(this, jobListener));
        this.f.post(new C0382do(this, runtimeException, jobListener));
        this.f.post(new dp(this, jobListener));
    }
}
