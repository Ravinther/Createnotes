package android.support.v4.p000a;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: android.support.v4.a.e */
public final class C0005e extends ContentObserver {
    final /* synthetic */ C0000d f33a;

    public C0005e(C0000d c0000d) {
        this.f33a = c0000d;
        super(new Handler());
    }

    public final boolean deliverSelfNotifications() {
        return true;
    }

    public final void onChange(boolean z) {
        this.f33a.m11m();
    }
}
