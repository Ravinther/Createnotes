package com.socialnmobile.colornote.activity;

/* renamed from: com.socialnmobile.colornote.activity.m */
final class C0177m implements Runnable {
    final /* synthetic */ SyncListener f830a;

    C0177m(SyncListener syncListener) {
        this.f830a = syncListener;
    }

    public final void run() {
        this.f830a.this$0.unbindService(this.f830a);
    }
}
