package com.socialnmobile.colornote.sync;

import android.content.Context;
import com.socialnmobile.colornote.data.C0210a;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0214d;
import com.socialnmobile.colornote.data.C0229s;
import java.util.concurrent.Semaphore;

public final class br implements Runnable {
    final /* synthetic */ Semaphore f1578a;
    final /* synthetic */ bq f1579b;

    public br(bq bqVar, Semaphore semaphore) {
        this.f1579b = bqVar;
        this.f1578a = semaphore;
    }

    public final void run() {
        Context context = this.f1579b.f1577b;
        C0229s.m1049b(context);
        C0212b.m937a(context);
        new C0214d(context).m997d();
        C0210a.m897a(context, "WIPE_OUT_MARK", 1);
        this.f1578a.release();
    }
}
