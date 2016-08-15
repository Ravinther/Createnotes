package com.socialnmobile.colornote.view;

import android.database.ContentObserver;
import android.os.Handler;

final class br extends ContentObserver {
    final /* synthetic */ ScreenGridList f2111a;

    br(ScreenGridList screenGridList, Handler handler) {
        this.f2111a = screenGridList;
        super(handler);
    }

    public final void onChange(boolean z) {
        if (this.f2111a.f1998a.m74h()) {
            this.f2111a.f1998a.m77l().m102a(1, null, this.f2111a);
        }
    }
}
