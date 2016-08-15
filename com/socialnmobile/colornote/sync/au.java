package com.socialnmobile.colornote.sync;

final class au implements Runnable {
    final /* synthetic */ BackgroundSyncConnection f1501a;

    au(BackgroundSyncConnection backgroundSyncConnection) {
        this.f1501a = backgroundSyncConnection;
    }

    public final void run() {
        this.f1501a.unbind();
    }
}
