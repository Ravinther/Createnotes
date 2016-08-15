package com.socialnmobile.util.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.socialnmobile.colornote.p006a.C0149h;
import com.socialnmobile.util.p014a.C0334q;
import com.socialnmobile.util.p014a.C0433b;
import com.socialnmobile.util.p014a.C0436e;
import com.socialnmobile.util.p014a.C0440i;
import com.socialnmobile.util.p014a.C0444m;
import com.socialnmobile.util.p014a.C0445n;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class JobService extends Service implements C0334q {
    final C0149h f1453e;
    public final Handler f1454f;
    C0445n f1455g;

    public abstract IBinder m1741b();

    public JobService() {
        this.f1453e = new C0149h(this);
        this.f1454f = new Handler();
    }

    public void onCreate() {
        super.onCreate();
        this.f1455g = new C0445n(Executors.newSingleThreadExecutor(), this, this.f1454f);
    }

    public void onDestroy() {
        this.f1455g.shutdown();
        super.onDestroy();
    }

    public final void m1742c() {
        stopSelf();
    }

    public final Future m1740a(Runnable runnable) {
        startService(new Intent(this, getClass()));
        return this.f1455g.submit(runnable);
    }

    public IBinder onBind(Intent intent) {
        return m1741b();
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }

    public final Runnable m1739a(ServiceJob serviceJob) {
        return C0436e.m2236a(new C0433b(new C0475b(this, serviceJob), this.f1454f), new C0444m(serviceJob, new C0440i(new C0476c(this, serviceJob), this.f1454f)));
    }
}
