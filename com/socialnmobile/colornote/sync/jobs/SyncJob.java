package com.socialnmobile.colornote.sync.jobs;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0210a;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.aa;
import com.socialnmobile.colornote.receiver.C0332a;
import com.socialnmobile.colornote.sync.AccountColumns;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.C0375c;
import com.socialnmobile.colornote.sync.am;
import com.socialnmobile.colornote.sync.bb;
import com.socialnmobile.colornote.sync.bg;
import com.socialnmobile.colornote.sync.bj;
import com.socialnmobile.colornote.sync.bp;
import com.socialnmobile.colornote.sync.bq;
import com.socialnmobile.colornote.sync.br;
import com.socialnmobile.colornote.sync.cd;
import com.socialnmobile.colornote.sync.dm;
import com.socialnmobile.colornote.sync.dt;
import com.socialnmobile.colornote.sync.du;
import com.socialnmobile.colornote.sync.dw;
import com.socialnmobile.colornote.sync.p015a.C0337c;
import com.socialnmobile.colornote.sync.p015a.C0347m;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p019c.C0368a;
import com.socialnmobile.colornote.sync.p019c.C0369b;
import com.socialnmobile.colornote.sync.p019c.C0371d;
import com.socialnmobile.colornote.sync.p019c.C0373f;
import com.socialnmobile.util.p014a.C0438g;
import java.util.concurrent.Semaphore;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;

public class SyncJob extends AuthRequiredJob {
    final Context context;
    final cd eventRegistry;
    final bq handler;
    final du progressCallback;

    public interface Listener extends com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion.Listener, com.socialnmobile.colornote.sync.jobs.AuthRequiredJob.Listener {
        void onProgress(int i, int i2);
    }

    public SyncJob(Context context, C0367b c0367b, C0368a c0368a, Listener listener) {
        super(context, c0367b, c0368a, listener);
        this.progressCallback = new C0393c(this);
        this.context = context;
        this.eventRegistry = ((ColorNote) context.getApplicationContext()).f601d;
        this.handler = new bq(context);
    }

    public Object callWithAccount(C0367b c0367b) {
        long longValue = ((Long) c0367b.p.m2010c()).longValue();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        while (true) {
            try {
                break;
            } catch (C0369b e) {
                if (e.f1591a == 447) {
                    bg bgVar = (bg) bg.f1556d.m1783d(((C0361e) e.f1593c).m1842h(AccountColumns.REPOSITORY_BUILT));
                    C0375c a = c0367b.m1875a();
                    a.p.m2008a(Long.valueOf(0));
                    a.o.m2008a(bgVar);
                    if (a.m1941a()) {
                        c0367b.p.m2008a(Long.valueOf(0));
                        c0367b.o.m2008a(bgVar);
                    }
                    new aa(c0367b.f1541b).m917c();
                } else {
                    break;
                    throw e;
                }
            } catch (bp e2) {
                am amVar = (am) c0367b.q.m2010c();
                bq bqVar = this.handler;
                Semaphore semaphore = new Semaphore(0);
                bqVar.f1576a.post(new br(bqVar, semaphore));
                semaphore.acquire();
                HttpClient b = new bb(this.context).m1887b();
                b.addRequestInterceptor(new C0337c(this.context));
                b.addRequestInterceptor(new C0392b(this, amVar));
                new C0368a(new C0371d(b, (HttpHost) bj.f1560a.m1898a("JSONRPC_HOST", new C0347m().m1754a()), (String) bj.f1560a.m1898a("JSONRPC_PATH", "/api/v1/jsonrpc"))).m1931a(new C0373f("deviceWipeoutComplete", new C0361e()));
                return new C0395e(new dw(null, new dm()), longValue);
            }
        }
        C0367b c0367b2 = c0367b;
        dw dwVar = (dw) new C0438g(new C0391a(), new dt(this.eventRegistry, c0367b2, this.jsonrpc, defaultSharedPreferences.getInt("Sync.NOTES_PER_COMMIT", 20), this.progressCallback)).call();
        if (dwVar.f1767a != null) {
            C0210a.m896a(this.context, dwVar.f1767a.f1719i);
        }
        return new C0395e(dwVar, longValue);
    }

    public void onJobResult(Object obj) {
        C0395e c0395e = (C0395e) obj;
        Context context = this.context;
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("LAST_SYNC_TIME_MILLIS", currentTimeMillis);
        edit.commit();
        if (c0395e != null) {
            int i;
            Context context2 = this.context;
            if (c0395e.f1795a.f1767a == null) {
                i = 0;
            } else {
                i = c0395e.f1795a.f1767a.f1715e.f1808f;
            }
            Editor edit2 = PreferenceManager.getDefaultSharedPreferences(context2).edit();
            edit2.putInt("SYNC_NOTE_COUNT", i);
            edit2.commit();
            if (c0395e.f1795a.f1768b.f1739b > 0) {
                context = this.context;
                currentTimeMillis = System.currentTimeMillis();
                edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                edit.putLong("LAST_SYNC_CHECKOUT_TIME_MILLIS", currentTimeMillis);
                edit.commit();
            }
        }
        ColorNote.m654c();
        C0332a.m1724a(this.context);
    }

    public boolean onJobException(Exception exception) {
        C0212b.m938a(this.context, System.currentTimeMillis(), exception);
        return super.onJobException(exception);
    }

    public void onJobFinally() {
        this.context.getContentResolver().notifyChange(C0228r.f997a, null);
    }
}
