package com.socialnmobile.colornote.activity;

/* renamed from: com.socialnmobile.colornote.activity.z */
final class C0190z implements Runnable {
    final /* synthetic */ SyncListener f856a;

    C0190z(SyncListener syncListener) {
        this.f856a = syncListener;
    }

    public final void run() {
        Main main = (Main) this.f856a.mActivityReference.get();
        if (main != null) {
            main.unbindService(this.f856a);
        }
    }
}
